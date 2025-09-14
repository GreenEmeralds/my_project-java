package project_1;

import java.awt.*;
//import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import main.Constants;

public class Ball {//extends GameObject{

    float[] POSITION = {0,0};
    float[] VEL = {1,1};
  
    int[] DIRECTION = {1,1};
    
    float[][] BOUNDS = {{0,0},{0,0}};

    float REC_WIDTH,REC_HEIGHT;
    
	int min = 2;
	int max = 4;
	int randomNumber;
	
	public int addScore = 0; // 0 = add, 1 = added, 2 = stop

    public Ball(float REC_WIDTH, float REC_HEIGHT, float POS_X, float POS_Y)
    {
    	//super(REC_WIDTH,REC_HEIGHT,POS_X,POS_Y,SCREEN_X,SCREEN_Y);
        this.POSITION[0] = POS_X;
        this.POSITION[1] = POS_Y;
        
        this.REC_WIDTH = REC_WIDTH;
        this.REC_HEIGHT = REC_HEIGHT;
        
        //BOUNDS_X (left to right)
        BOUNDS[0][0] = Constants.margin;
        BOUNDS[0][1] = Constants.SCREEN_SIZE[0] - REC_WIDTH - Constants.margin;
        
        //BOUNDS_Y (top to bottom)
        BOUNDS[1][0] = Constants.margin;
        BOUNDS[1][1] = Constants.SCREEN_SIZE[1] - REC_HEIGHT - 25 - Constants.margin;
    }
    
	public void addScore()
	{
		addScore = 1;
	}
	
    public void draw(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setColor(Constants.acColor);
        Ellipse2D.Float r2 = new Ellipse2D.Float(POSITION[0],POSITION[1],REC_WIDTH,REC_HEIGHT);
        g2d.fill(r2);
    } 
    
    public Rectangle2D.Float getBounds() {
        return new Rectangle2D.Float(POSITION[0], POSITION[1], REC_WIDTH, REC_HEIGHT);
    }
    
    public void move()
    {
        if(POSITION[0] <= BOUNDS[0][0]) // X left 
        {
        	DIRECTION[0] = 1;
        }
        else if(POSITION[0] >= BOUNDS[0][1]) // X right 
        {
        	DIRECTION[0] = -1;
        }
        
        if(POSITION[1] <= BOUNDS[1][0])  // Y up 
        {
        	DIRECTION[1] = 1;
        	float[] newpos = {Constants.getCenterPosX(REC_WIDTH),Constants.SCREEN_SIZE[1]};
        	setPosition(newpos);
        	addScore();
        	
        }
        else if(POSITION[1] >= BOUNDS[1][1]) // Y down 
        {
        	DIRECTION[1] = -1;
        	float[] newpos = {Constants.getCenterPosX(REC_WIDTH),Constants.getCenterPosY(REC_WIDTH)};
        	setPosition(newpos);
        }
        	
    	
    	float[] newPOS = {POSITION[0] + VEL[0] * DIRECTION[0], POSITION[1] + VEL[1] * DIRECTION[1]};
    	setPosition(newPOS);
    }
    
    public void collided()
    {
    	//VEL[0]= ((int) (Math.random() * (max - min + 1)) + min)*.5f;
    	//VEL[1]= ((int) (Math.random() * (max - min + 1)) + min)*.5f;
    	
    	float[] newVel = {0,1};
    	VEL = newVel;
    	
    	DIRECTION[1] = DIRECTION[1] * -1;
    }
    
    public float[] getPosition()
    {
        return POSITION;
    }

    public void setPosition(float[] newPOSITION) {
        this.POSITION = newPOSITION;
    }
    
}
