package project_1;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
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

	Timer timer = new Timer(20,this);

	float BOUNDS_LINE_X;
	float BOUNDS_X;

	static int BLOCK_WIDTH = 100;
	static int BLOCK_HEIGHT = 25;
	static int SCREEN_GAP = 35+GameConstants.margin;
	static int BALL_SCALE = 30;

	private Player player;
	private Ball ball;
	private EnemyBlock enemyBlock;
	
	public static JLabel[] Hearts_LBL  = new JLabel[3];
	
	int score = 0;
	
	private ImageIcon heart_IMG;
	
	
	public GamePanel(float SCREEN_X, float SCREEN_Y)
	{
		setLayout(null);
		setBackground(GameConstants.bgColor);
		
		player = new Player(BLOCK_WIDTH,BLOCK_HEIGHT,(SCREEN_X/2- BLOCK_WIDTH/2),(SCREEN_Y-SCREEN_GAP-BLOCK_HEIGHT*2));
		ball = new Ball(BALL_SCALE,BALL_SCALE,(SCREEN_X/2-BALL_SCALE),(SCREEN_Y/2-BALL_SCALE));
		enemyBlock = new EnemyBlock(BLOCK_WIDTH,BLOCK_HEIGHT,(SCREEN_X/2- BLOCK_WIDTH/2),SCREEN_GAP,SCREEN_X,SCREEN_Y);
		
		addKeyListener(this);
		setFocusable(true);

		gameOverPanel.initialize(this,this);
		
		timer.stop();
		
		for(int i=0; i<3; i++)
		{
			Hearts_LBL[i] = new JLabel(heart_IMG);
			Hearts_LBL[i].setBounds(Constants.margin + i*30, Constants.SCREEN_SIZE[1] - 50 - Constants.margin - 25, 50, 50);
			Hearts_LBL[i].setFont(Constants.printFont);

		}
	}
////BUTTON FUNCTIONS ///
	
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
	

	public void addUI()
	{
		//Note: order matters	
		
		//ADD HEARTS
				for(int i=0; i<3; i++)
				{
					Hearts_LBL[i] = new JLabel(new ImageIcon(getClass().getResource("/coin.gif")));
					Hearts_LBL[i].setBounds(GameConstants.margin + i*30, GameConstants.SCREEN_SIZE[1] - 50 - GameConstants.margin - 25, 50, 50);
					Hearts_LBL[i].setFont(GameConstants.printFont);
					add(Hearts_LBL[i]);
				}
				
		//ADD BORDER
        setBorder(new CompoundBorder(
        		BorderFactory.createLineBorder(GameConstants.bgColor, GameConstants.margin), 
        		BorderFactory.createLineBorder(GameConstants.acColor, GameConstants.lineWidth)));
		
		//SCORE LABEL
		add(UiManager.score_LBL(0));

		//PAUSE BUTTON
		add(UiManager.pause_BTN(this,this));
		//System.out.println("position: " + UiManager.score_LBL(0).geX);


		//RESUME BUTTON
		add(UiManager.resume_BTN(this,this));
		//BACK BUTTON
		add(UiManager.back_BTN(this,this));
		
		

	}
	
////UPDATE VOID ////
	public void checkCollision()
	{
		if(ball.getBounds().intersects(player.getBounds()))
		{
			//System.out.println(ball.getBounds());
			ball.collided(player.getPositionY()- (player.REC_HEIGHT));
			enemyBlock.move = 1;
		}
		
		if(ball.getBounds().intersects(enemyBlock.getBounds()) )
		{
			//System.out.println(ball.getBounds());
			ball.collided(enemyBlock.getPositionY() + (enemyBlock.REC_HEIGHT));
			enemyBlock.move = 0;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		player.move();
		ball.move();
		enemyBlock.move(ball.getPosition()[0], ball.getVEL()[1]);
		
		checkCollision();
		repaint();
		
		if(ball.addScore == 1)
		{	
			ball.addScore = 2;
			score++;
			add(UiManager.score_LBL(score));	
		}
		
		if(ball.removeHeart == 1 && hearts >= 1)
		{
			ball.removeHeart = 2;
			hearts -=1;
			Hearts_LBL[hearts].setVisible(false);
		}
		
		//GAME OVER no more hearts 
		if(hearts == 0)
		{
			timer.stop();// important to stop all timer from running while on other panels!!!
			gameOver(1);
		}
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		player.draw(g);
		ball.draw(g);
		enemyBlock.draw(g);
		//Toolkit.getDefaultToolkit().sync();
	} 
	
////KEY IMPUTS ///
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
