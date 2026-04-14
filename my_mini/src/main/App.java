package main;

import javax.swing.JFrame;
 
public class App{
     
  public static void main(String[] args) {
	  JFrame frame = new JFrame(); 
	  frame.setTitle( "My Mini" );
	  
	  //initialize background components
	  GameConstants.loadFont();
	  ScreenController.setFrame(frame);
	  GameController.setFrame(frame);

      // Configure frame properties
      frame.setSize(GameConstants.SCREEN_SIZE[0], GameConstants.SCREEN_SIZE[1]);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLocationRelativeTo(null); // Center the window from Google
      
      MainMenu mainMenu = new MainMenu();
      
      // add the Panel to the window
      frame.add(mainMenu);
      //frame.add(game_2);
      
      // Make the frame visible
      frame.setVisible(true);
  }
  
  

}



