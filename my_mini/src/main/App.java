package main;

import javax.swing.JFrame;
 
public class App{
     
  public static void main(String[] args) {
	  JFrame frame = new JFrame(); 
	  frame.setTitle( "My Mini" );
	  
	  //initialize background components
	  Constants.loadFont();
	  ScreenController.setFrame(frame);
	  GameController.setFrame(frame);

      // Configure frame properties
      frame.setSize(Constants.SCREEN_SIZE[0], Constants.SCREEN_SIZE[1]);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLocationRelativeTo(null); // Center the window from Google
      
      // Add a component to the frame
      project_1.GamePanel game_1 = new project_1.GamePanel(Constants.SCREEN_SIZE[0],Constants.SCREEN_SIZE[1]);
      project_2.GamePanel game_2 = new project_2.GamePanel(Constants.SCREEN_SIZE[0],Constants.SCREEN_SIZE[1]);
      project_3.GamePanel game_3 = new project_3.GamePanel(Constants.SCREEN_SIZE[0],Constants.SCREEN_SIZE[1]);
      
      // pass keyboard inputs to the Panel
      frame.addKeyListener(game_1);
      frame.addKeyListener(game_2);
      frame.addKeyListener(game_3);
      
<<<<<<< Updated upstream
      MainMenu mainMenu = new MainMenu(frame,game_1, game_2, game_3);
=======
      MainMenu mainMenu = new MainMenu();
>>>>>>> Stashed changes
      
      // add the Panel to the window
      frame.add(mainMenu);
      //frame.add(game_2);
      
      // Make the frame visible
      frame.setVisible(true);
  }
  
  

}



