package project_3;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.CompoundBorder;

import main.GameConstants;
import managers.IGameManager;
import managers.UiManager;

import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements ActionListener,KeyListener,IGameManager{
	private static final long serialVersionUID = 1L; //?

	Timer timer = new Timer(5,this);

	//GameOverPanel gameOverPanel = new GameOverPanel();
	
	public GamePanel(float SCREEN_X, float SCREEN_Y)
	{
		setLayout(null);
		setBackground(GameConstants.bgColor);
//...
		addKeyListener(this);
		setFocusable(true);
		
		timer.stop();
		
	}
////BUTTON FUNCTIONS ///
	
	public JPanel getGame()
	{
		return this;
	}
	
	public void setStart()
	{
		timer.start();
		addUI();
		// in order for KeyListener to work properly 
		requestFocusInWindow(); // Request focus for the panel
	}
	
	public void setPause()
	{		
		timer.stop();
	}
	
	public void setResume()
	{
		timer.start();
	}
	
	public void setRestart()
	{
		timer.start();
	}

	public void addUI()
	{
		//Note: order matters	
		
		//ADD BORDER
        setBorder(new CompoundBorder(
        		BorderFactory.createLineBorder(GameConstants.bgColor, GameConstants.margin), 
        		BorderFactory.createLineBorder(GameConstants.acColor, GameConstants.lineWidth)));
		
		//SCORE LABEL
		add(UiManager.score_LBL(0));

		//PAUSE BUTTON
		add(UiManager.pause_BTN(this,this));
		//System.out.println("pos: " + UiManager.score_LBL(0).geX);


		//RESUME BUTTON
		add(UiManager.resume_BTN(this,this));

	}
	
////UPDATE VOID ////
	public void checkCollision()
	{
		//...
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		//player.move();

		checkCollision();
		repaint();
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		//player.draw(g);

	} 
	
////KEY IMPUTS ///
	public void keyPressed(KeyEvent e) {

		//player.keyPressed(e);
	}

	public void keyReleased(KeyEvent e)
	{
		//player.keyReleased(e);
	}

	public void keyTyped(KeyEvent e)
	{
		//
	}

}