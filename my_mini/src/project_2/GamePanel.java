package project_2;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.CompoundBorder;

import main.Constants;
import main.ScreenController;
import managers.IGameManager;
import managers.UiManager;
import panels.GameOverPanel;

import java.awt.*;
import java.awt.event.*;


public class GamePanel extends JPanel implements ActionListener,KeyListener,IGameManager{

	private static final long serialVersionUID = -1349882208747354405L;

	Timer timer = new Timer(5,this);

	float BOUNDS_LINE_X;
	float BOUNDS_X;

	static int PLAYER_WIDTH = 30;
	static int PLAYER_HEIGHT = 50;

	static int GROUND_GAP = 100;

	private Player player;
	private Spawner spawner;
	
	GameOverPanel gameOverPanel = new GameOverPanel();
	
	int score = 0;

	public GamePanel(float SCREEN_X, float SCREEN_Y)
	{
		setLayout(null);
		setBackground(Constants.bgColor);

		player = new Player(PLAYER_WIDTH,PLAYER_HEIGHT,(30),(SCREEN_Y - GROUND_GAP - PLAYER_HEIGHT),SCREEN_Y-GROUND_GAP - PLAYER_HEIGHT);
		spawner = new Spawner(SCREEN_X,SCREEN_Y,GROUND_GAP);

		addKeyListener(this);
		setFocusable(true);
		
		//use this instead of remove 
		//setVisible(true);

		timer.stop();
	}
	
//// BUTTON FUNCTIONS ///
	
	public void setStart()
	{
		timer.start();
		gameOverPanel.initialize(this,this);
		addUI();
		// in order for KeyListener to work properly 
		requestFocusInWindow(); // Request focus for the panel
		spawner.addSpawnTimer(); // start timer after start is pressed
	}
	
	public void setPause()
	{		
		// add spawn timer stop as well
		timer.stop();
	}
	
	public void setResume()
	{
		timer.start();
	}
	
	public void setRestart()
	{
		//spawner.addSpawnTimer(); // start timer after start is pressed
		timer.start();
	}

	public void addUI()
	{
		//Note: order matters	
		
		//ADD BORDER
        setBorder(new CompoundBorder(
        		BorderFactory.createLineBorder(Constants.bgColor, Constants.margin), 
        		BorderFactory.createLineBorder(Constants.acColor, Constants.lineWidth)));
		
		//SCORE LABEL
		add(UiManager.score_LBL(0));

		//PAUSE BUTTON
		add(UiManager.pause_BTN(this,this));

		//RESUME BUTTON
		add(UiManager.resume_BTN(this,this));
		
		//BACK BUTTON
		add(UiManager.back_BTN(this,this));

	}
	
//// UPDATE VOID ////

	@Override
	public void actionPerformed(ActionEvent e)
	{
		player.move();

		for(int i = 0; i < spawner.getObstacle().length; i++)
		{
			spawner.getObstacle()[i].update();
			// if obstacles is within bounds for optimization... 
			
			if(spawner.gameOver(player,i))
			{
				gameOver();
			}
			
			spawner.getObstacle()[i].addScore(player);
			
			if(spawner.getObstacle()[i].addScore == 1)
			{	
				spawner.getObstacle()[i].addScore = 2;
				score++;
				add(UiManager.score_LBL(score));	
			}	
		}
		//
		repaint();
	}
	
	public void gameOver()
	{
		timer.stop();
		ScreenController.switchScene(gameOverPanel);
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		player.draw(g);

		for(int i = 0; i < spawner.getObstacle().length; i++)
		{
			spawner.getObstacle()[i].draw(g);
		}

		//Toolkit.getDefaultToolkit().sync();
	} 
	
//// KEY IMPUTS ///

	public void keyPressed(KeyEvent e) {

		player.keyPressed(e);
	}

	public void keyReleased(KeyEvent e)
	{
		player.keyReleased(e);
	}

	public void keyTyped(KeyEvent e)
	{
		//
	}

}
