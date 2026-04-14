package project_1;

import java.awt.*;
import java.awt.geom.Rectangle2D;

import main.GameConstants;


public class EnemyBlock {
	int SPEED_X = 10;
    int DIRECTION;
    float REC_WIDTH,REC_HEIGHT,POS_X,POS_Y;
    float[] BOUNDS_X = {0,0};
    
    public int move = 1; // 0 = stop, 1 = move

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
        
        g2d.setColor(GameConstants.acColor);
        Rectangle2D.Float r2 = new Rectangle2D.Float(POS_X,POS_Y,REC_WIDTH,REC_HEIGHT);
        g2d.fill(r2);
    } 
    
    public Rectangle2D.Float getBounds() {
        return new Rectangle2D.Float(POS_X, POS_Y, REC_WIDTH, REC_HEIGHT);
    }
    
    public void move(float BALL_POS_X, float BALL_VEL_X)
    {	
    	/*if (move == 0 && BALL_VEL_X < 0)
    		setPositionX(getPositionX() + ( BOUNDS_X[1] - getPositionX())*.1f);
    	
    	else if (move == 0 && BALL_VEL_X > 0)
    		setPositionX(getPositionX() + ( BOUNDS_X[1] - getPositionX())*.1f);
    	
    	else if (move == 1 && BALL_POS_X < BOUNDS_X[1]+10)
    		setPositionX(getPositionX() + ((BALL_POS_X) - getPositionX())*.1f);     
    	*/
    	
    	if (move == 0 && BALL_VEL_X > 0)
    		setPositionX(getPositionX() + ((BALL_POS_X-10) - getPositionX())*.05f);
    	else if (move == 1 && BALL_POS_X-30 < BOUNDS_X[1])
    		setPositionX(getPositionX() + ((BALL_POS_X-30) - getPositionX())*.1f);
    
    }
    
    public float getPositionX()
    {
        return POS_X;
    }
    
    public float getPositionY()
    {
        return POS_Y;
    }

    public void setPositionX(float newPOS_X) {

    	this.POS_X = newPOS_X;
        
    }

}
