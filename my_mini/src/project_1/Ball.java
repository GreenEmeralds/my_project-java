package project_1;

import java.awt.*;
//import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import main.GameConstants;

public class Ball {//extends GameObject{

    float[] POSITION = {0,0};
    float SPEED = 300;
    float[] VEL={0,0};
  
    int[] DIRECTION = {1,1};
    
    float[][] BOUNDS = {{0,0},{0,0}};
    
	float initialTime;
	float finalTime;
	float deltaTime = 0;
	
	float[] initialPos;
	float[] finalPos;
	float[] DISP = {0,0};
	
	float[] Nx = {1 , 0};
	float[] Ny = {0 , 1};
	

    float REC_WIDTH,REC_HEIGHT;
    
	int min = 20;
	int max = 30;
	int randomNumber;
	
	public int addScore = 0; // 0 = add, 1 = added, 2 = stop
	
	public float[] setVEL(float T)//float[] colliderN)
	{
		
		float i = SPEED *(float) Math.cos(Math.toRadians(T));
		float j = SPEED *(float) Math.sin(Math.toRadians(T));
		//System.out.println(Math.cos(Math.toRadians(T)));
		// vf = vi - 2(vi dot n)n
		//float x = i - 1f*(dotProduct(VEL,N));
		//float y = j - 1f*(dotProduct(VEL,N));
		//System.out.println(2*(dotProduct(VEL,colliderN)));
		
		float[] vel = {i,j};
		return vel;
	}
	
	public float Magnitude(float[] v)
	{
		return (float) Math.sqrt(Math.pow(v[0], 2)+ Math.pow(v[1], 2));
	}
	public float dotProduct(float[] v1, float[] v2)
	{
		return ((v1[0]* v2[0]) + (v1[1]* v2[1]));
	}
	
    public Ball(float REC_WIDTH, float REC_HEIGHT, float POS_X, float POS_Y)
    {
    	VEL = setVEL(45);
    	
    	//super(REC_WIDTH,REC_HEIGHT,POS_X,POS_Y,SCREEN_X,SCREEN_Y);
        this.POSITION[0] = POS_X;
        this.POSITION[1] = POS_Y;
        
        this.REC_WIDTH = REC_WIDTH;
        this.REC_HEIGHT = REC_HEIGHT;
        
        //BOUNDS_X (left to right)
        BOUNDS[0][0] = GameConstants.margin + 5;
        BOUNDS[0][1] = GameConstants.SCREEN_SIZE[0] - REC_WIDTH - 5 - GameConstants.margin;
        
        //BOUNDS_Y (top to bottom)
        BOUNDS[1][0] = GameConstants.margin+5;
        BOUNDS[1][1] = GameConstants.SCREEN_SIZE[1] - REC_HEIGHT  - 35 - GameConstants.margin;
    }
    
	public void addScore()
	{
		addScore = 1;
	}
	
    public void draw(Graphics g)
    {
    	initialTime = (float) System.nanoTime() / 1_000_000_000.0f;
    	initialPos = POSITION;
    	Graphics2D g2d = (Graphics2D) g;
        
        g2d.setColor(GameConstants.acColor);
        Ellipse2D.Float r2 = new Ellipse2D.Float(POSITION[0],POSITION[1],REC_WIDTH,REC_HEIGHT);
        g2d.fill(r2);
    } 
    
    public Rectangle2D.Float getBounds() {
        return new Rectangle2D.Float(POSITION[0], POSITION[1], REC_WIDTH, REC_HEIGHT);
    }
    public float[] NormalCalc(float[] normal, float b)
    {
    	float[] n = {normal[0] * b, normal[1] * b};
    	return n;
    }

    public void move()
    {	
    	
    	//System.out.println(BOUNDS[0][1] - dotProduct(POSITION,Nx) );
    	if(dotProduct(POSITION,Nx) - BOUNDS[0][0] < 0 && VEL[0] < 0)// LEFT BOUNDS
    	{
    		
    		//VEL[0] = VEL[0] -  ((float) (Math.random() * (max - min + 1))) *(dotProduct(VEL,Nx));
    		VEL[0] = -1 * (VEL[0] );//+  (VEL[0] * ((float) (Math.random() * (max - min + 1)) *.25f)) );//* ((float) (Math.random() * (max - min + 1)) *.25f);
    		POSITION[0] = BOUNDS[0][0]+.1f;
    		
    		//System.out.println(VEL[1]);
    	}
    	else if(BOUNDS[0][1] - dotProduct(POSITION,Nx) < 0 && VEL[0] > 0)//RIGHT BOUNDS
    	{
    		VEL[0] = -1 * (VEL[0] );//+  (VEL[0] * ((float) (Math.random() * (max - min + 1)) *.25f))) ;//* ((float) (Math.random() * (max - min + 1)) *.25f);
    		POSITION[0] = BOUNDS[0][1]-.1f;
    	}
    	
    	if(dotProduct(POSITION,Ny) - BOUNDS[1][0] < 0 && VEL[1] < 0)// UP BOUNDS
    	{
    		VEL[1] = -1 * (VEL[1] );//+  (VEL[1] * ((float) (Math.random() * (max - min + 1)) *.25f)));
    		POSITION[1] = BOUNDS[1][0]+.1f;
    		addScore();
    	}
    	else if(BOUNDS[1][1] - dotProduct(POSITION,Ny) < 0 && VEL[1] > 0 )//DOWN BOUNDS
    	{
    		//+  (VEL[1] * ((float) (Math.random() * (max - min + 1)) *.25f)));//* ((float) (Math.random() * (max - min + 1)) *.);
    		VEL = setVEL(45);
    		POSITION[1] = BOUNDS[1][1]-.1f;
    		
    		float[] newpos = {GameConstants.getCenterPosX(REC_WIDTH),GameConstants.getCenterPosY(REC_WIDTH)};
    		setPosition(newpos);
    	}
    	//SPEED[1]= ((int) (Math.random() * (max - min + 1)) + min)*.5f;
    	//float[] newpos = {Constants.getCenterPosX(REC_WIDTH),Constants.getCenterPosY(REC_WIDTH)};
    	//setPosition(newpos);
        
    	
    	float[] newPOS = {POSITION[0] + VEL[0] *deltaTime, POSITION[1] + VEL[1] *deltaTime};
    	setPosition(newPOS);
    	
    	//	Delta time
    	finalTime = (float) System.nanoTime() / 1_000_000_000.0f;
        deltaTime = finalTime - initialTime;
        //System.out.println(deltaTime);
    	initialTime = finalTime;
    	
    	//	displacement
    	finalPos = POSITION;
    	//Array constants can only be used in initializers
    	float[] disp = {finalPos[0] - initialPos[0], finalPos[1] - initialPos[1]};
    	DISP = disp;
    	//System.out.println("var: " + POSITION[0] + " , " + POSITION[1]);
    	initialPos = finalPos;
    }
    
    public void collided(float ColPOSy)
    {

    	float T = (float)(Math.toDegrees(Math.acos((dotProduct(VEL,Ny) )/ ( Magnitude(VEL) * Magnitude(Ny)))) );
    	// +/- .1 TO STOP THE BALL FROM STIKING TO THE SURFACE!!!
    	if( ColPOSy - dotProduct(POSITION,Ny) < 0 && VEL[1] > 0)
    	{
    		VEL[1] = -setVEL(T)[1]; 
    		POSITION[1] = ColPOSy -2f;
    		
    	}
    	else if(dotProduct(POSITION,Ny) - ColPOSy  < 0 && VEL[1] < 0)
    	{
    		VEL[1] = setVEL(T)[1];//+ (float)(Math.random() * (max - min + 1)))[1]; 
    		POSITION[1] = ColPOSy +.5f;
    	}
    }
    
    public float[] getPosition()
    {
        return POSITION;
    }

    public void setPosition(float[] newPOSITION) {
        this.POSITION = newPOSITION;
    }
    
    // for enemy following
    public float[] getVEL()
    {
        return VEL;
    }
    
    
}
