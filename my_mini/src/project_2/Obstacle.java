package project_2;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import main.GameConstants;

public class Obstacle {
	float VEL_X = 1.5f;
	int DIRECTION_X = -1;

	float REC_WIDTH,REC_HEIGHT,POS_X,POS_Y,GROUND;
	public int addScore = 0; // 0 = add, 1 = added, 2 = stop

	public Obstacle(float REC_WIDTH, float REC_HEIGHT, float POS_X, float POS_Y)
	{
		//super(REC_WIDTH,REC_HEIGHT,POS_X,POS_Y,SCREEN_X,SCREEN_Y);

		this.POS_X = POS_X;
		this.POS_Y = POS_Y;
		this.REC_WIDTH = REC_WIDTH;
		this.REC_HEIGHT= REC_HEIGHT;
	}

	public void draw(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;

		g2d.setColor(GameConstants.acColor);
		Rectangle2D.Float r2 = new Rectangle2D.Float(POS_X,POS_Y,REC_WIDTH,REC_HEIGHT);
		g2d.fill(r2);
	} 

	public Rectangle2D.Float getBounds() {
		return new Rectangle2D.Float(POS_X, POS_Y, REC_WIDTH, REC_HEIGHT);
	}

	public void update()
	{
		setPosition(POS_X + VEL_X * DIRECTION_X, POS_Y);

		if(POS_X < - REC_WIDTH+10) // past screen distance + buffer
		{
			move(false);
		}
		
	}
	
	public void addScore(Player p)
	{
		if(getPosition()[0] <= p.getPosition()[0] && addScore == 0)
		{
			addScore = 1;
			//System.out.println("true");
		}
	}
	
	
	public void move(boolean go)
	{
		if(go)
		{
			DIRECTION_X=-1;
		}
		else
		{
			DIRECTION_X=0;
		}
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