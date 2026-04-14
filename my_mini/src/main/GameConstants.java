package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.io.InputStream;

public class GameConstants { 
	
	public static int[] SCREEN_SIZE = {1000,600};
	
	/// FONT
	public static Font myFont;
	
	public static Font titleFont;
	public static Font headerFont;
	public static Font printFont;
	
	public static void loadFont() 
	{
        if (myFont == null) {
        	try{
        		// Load the font from a file 
    			InputStream is = GameConstants.class.getResourceAsStream("/fonts/PressStart2PRegular.ttf");
    			//System.out.println(Constants.class.getResourceAsStream("/PressStart2PRegular.ttf"));
    			myFont = Font.createFont(Font.TRUETYPE_FONT, is);
    			myFont = myFont.deriveFont(12);
    			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    		    ge.registerFont(myFont);
    		} catch (IOException|FontFormatException e) {
    			// Handle font loading errors, e.g., use a default font
    			System.out.println("wrong");
    			//return new Font("Ariel", Font.PLAIN, (int)size);
    		}
        }
        
        titleFont = myFont.deriveFont(Font.PLAIN, 30f);
        headerFont = myFont.deriveFont(Font.PLAIN, 20f);
        printFont = myFont.deriveFont(Font.PLAIN, 15f);
        
	}
	
	/// PLACEMENT ///

	public static int[] mainBTN_Dimension = {300,100};
	float butonPositions = 0;
	public static int margin = 20;
	public static int lineWidth = 3;
	
	/// COLORS ///
	
	public static Color acColor = Color.BLACK;
	public static Color bgColor = Color.WHITE;
	
	/// GET PLACEMENTTS ///
	
	public static float getCenterPosX(float size) 
	{
		float c = SCREEN_SIZE[0]/2- size/2;
		return c;
	}
	
	public static float getCenterPosY(float size) 
	{
		float c = SCREEN_SIZE[1]/2 - size/2;
		return c;
	}
	
	


	
}
