package project_1;

import java.awt.*;
import java.awt.geom.Rectangle2D;

import main.Constants;

public class EnemyBlock {
	int VEL_X = 1;
    int DIRECTION;
    float REC_WIDTH,REC_HEIGHT,POS_X,POS_Y;
    float[] BOUNDS_X = {0,0};

    public EnemyBlock(float REC_WIDTH, float REC_HEIGHT, float POS_X, float POS_Y, float SCREEN_X, float SCREEN_Y)
    {
    	//super(REC_WIDTH,REC_HEIGHT,POS_X,POS_Y,SCREEN_X,SCREEN_Y);
        
    	this.POS_X = POS_X;
        this.POS_Y = POS_Y;
        this.REC_WIDTH = REC_WIDTH;
        this.REC_HEIGHT= REC_HEIGHT;
        
        DIRECTION = 1;
        
        BOUNDS_X[0]= 0;
        BOUNDS_X[1]= SCREEN_X-REC_WIDTH;
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
    
    public void move(float BALL_POS_X)
    {
        if(POS_X <= BOUNDS_X[0]) // X left 
        {
        	DIRECTION = 1;
        }
        else if(POS_X >= BOUNDS_X[1]) // X right 
        {
        	DIRECTION = -1;
        }
    	
    	setPosition(POS_X + VEL_X * DIRECTION);
        
    }

    public float getPosition()
    {
        return POS_X;
    }

    public void setPosition(float newPOS_X) {

    	this.POS_X = newPOS_X;
        
    }

}
