package main;

import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import managers.IGameManager;
import panels.StartPanel;

public class GameController {
	
	public static JFrame f;
	public static JPanel mainMenu;
	
	static JPanel Game;
	
	public static void setFrame(JFrame frame)
	{
		f = frame;
	}
	
	public static void setMainMenu(JPanel main)
	{
		mainMenu = main;
	}
	
	public static void goToMain()
	{
		ScreenController.switchScene(mainMenu);
	}
	
	public static void startGame(int num)
	{
		
        if(num == 1 )
        {
        	Game =  new project_1.GamePanel(GameConstants.SCREEN_SIZE[0],GameConstants.SCREEN_SIZE[1]);
        }
        else if(num == 2 )
        {
        	Game = new project_2.GamePanel(GameConstants.SCREEN_SIZE[0],GameConstants.SCREEN_SIZE[1]);
        }
        else if (num == 3 )
        {
        	Game = new project_3.GamePanel(GameConstants.SCREEN_SIZE[0],GameConstants.SCREEN_SIZE[1]);
			
        }
        
        f.addKeyListener((KeyListener) Game); // pass keyboard inputs to the Panel
        ScreenController.switchScene(new StartPanel()); 
		
	}
	
	public static void gameStart()
	{
		ScreenController.switchScene(Game);
        // set start function from game
		IGameManager GameManager = (IGameManager)Game;
		GameManager.setStart();
	}
	
	public static void gameRestart(int num)
	{
        if(num == 1 )
        {
        	Game =  new project_1.GamePanel(GameConstants.SCREEN_SIZE[0],GameConstants.SCREEN_SIZE[1]);
        }
        else if(num == 2 )
        {
        	Game = new project_2.GamePanel(GameConstants.SCREEN_SIZE[0],GameConstants.SCREEN_SIZE[1]);
        }
        else if (num == 3 )
        {
        	Game = new project_3.GamePanel(GameConstants.SCREEN_SIZE[0],GameConstants.SCREEN_SIZE[1]);
			
        }
        f.addKeyListener((KeyListener) Game); // pass keyboard inputs to the Panel
        
        gameStart();
	}



}
