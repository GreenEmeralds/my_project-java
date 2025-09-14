package project_1;


import java.awt.geom.Rectangle2D;

public class GameObject{
	
    protected float REC_WIDTH,REC_HEIGHT,POS_X,POS_Y;

    public GameObject(float REC_WIDTH, float REC_HEIGHT, float POS_X, float POS_Y, float SCREEN_X, float SCREEN_Y)
    {
        this.REC_WIDTH = REC_WIDTH;
        this.REC_HEIGHT = REC_HEIGHT;
        
        this.POS_X = POS_X;
        this.POS_Y = POS_Y;
    }

    public Rectangle2D.Float getBounds() {
        return new Rectangle2D.Float(POS_X, POS_Y, REC_WIDTH, REC_HEIGHT);
    }

}
