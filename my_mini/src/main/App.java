package main;

import javax.swing.JFrame;
 
public class App{
     
  public static void main(String[] args) {
	  JFrame frame = new JFrame(); 
	  frame.setTitle( "My Mini" );
	  
	  //initialize background components
	  Constants.loadFont();
	  ScreenController.setFrame(frame);

      // Configure frame properties
      frame.setSize(Constants.SCREEN_SIZE[0], Constants.SCREEN_SIZE[1]);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLocationRelativeTo(null); // Center the window from Google
      
      // Add a component to the frame ...
      
      // pass keyboard inputs to the Panel ...

      
      MainMenu mainMenu = new MainMenu(frame);
      
      // add the Panel to the window
      frame.add(mainMenu);
      //frame.add(game_2);
      
      // Make the frame visible
      frame.setVisible(true);
  }
  
  

}



