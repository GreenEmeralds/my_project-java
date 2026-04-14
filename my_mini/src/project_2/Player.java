package project_2;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;

import main.Constants;

public class Player {
	float VEL_X = 1.5f;
	float VEL_Y = 1f;
	float JUMP_FORCE = 10f;
	float GRAVITY = .25f;
	
	boolean IS_GROUNDED = false;
	
	int DIRECTION_X;
	float REC_WIDTH,REC_HEIGHT,POS_X,POS_Y,GROUND;

	public Player(float REC_WIDTH, float REC_HEIGHT, float POS_X, float POS_Y, float GROUND)
	{
		//super(REC_WIDTH,REC_HEIGHT,POS_X,POS_Y,SCREEN_X,SCREEN_Y);

		this.POS_X = POS_X;
		this.POS_Y = POS_Y;
		this.REC_WIDTH = REC_WIDTH;
		this.REC_HEIGHT= REC_HEIGHT;

		this.GROUND = GROUND;
	}

	public void draw(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;

		g2d.setColor(Constants.acColor);
		Rectangle2D.Float r2 = new Rectangle2D.Float(POS_X,POS_Y,REC_WIDTH,REC_HEIGHT);
		g2d.fill(r2);
	} 

	public Rectangle2D.Float getBounds() {
		return new Rectangle2D.Float(POS_X, POS_Y, REC_WIDTH, REC_HEIGHT);
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP){
			if (IS_GROUNDED)
				jump();
		}
		
		if (e.getKeyCode() == KeyEvent.VK_RIGHT){ 
			moveDirection(1);
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT){
			moveDirection(-1);
		}
	}

	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_LEFT) {
			moveDirection(0);
		}
	}

	public void moveDirection(int direction)
	{
		//because origin top right we have to look at the add on the other side 
		//if ( (POS_X >= (SCREEN_X/2 + BOUNDS_LINE_X/2 - REC_WIDTH) && direction == 1) || (POS_X <= (SCREEN_X/2 - BOUNDS_LINE_X/2) && direction == -1)) 
		if((POS_X >= 800 &&  direction == 1) || (POS_X <= 0 && direction == -1) )
		{
			//TODO: FIX BORDER CONTROL
			DIRECTION_X = 0;
		}
		else
		{
			DIRECTION_X = direction;
		}

	}

	public void move()
	{
		setPosition(POS_X + VEL_X * DIRECTION_X, POS_Y + VEL_Y);

		if(POS_Y < GROUND)
		{
			IS_GROUNDED = false;
		}
		else
		{
			IS_GROUNDED = true;
			VEL_Y = 0;
		}

		if(!IS_GROUNDED)
		{
			VEL_Y += GRAVITY;
		}
	}

	public void jump()
	{
		VEL_Y -= JUMP_FORCE;
		IS_GROUNDED = false;
	}
	

	public float[] getPosition()
	{
		return new float[]{POS_X,POS_Y};
	}

	public void setPosition(float newPOS_X,float newPOS_Y) {
		this.POS_X = newPOS_X;
		this.POS_Y = newPOS_Y;
	}
}
