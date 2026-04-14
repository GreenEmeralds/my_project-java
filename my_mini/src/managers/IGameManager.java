package managers;


import main.ScreenController;
import panels.GameOverPanel;


public interface IGameManager {
	// Abstract method
    void setStart(); 
    void setPause(); 
    void setResume(); 
    
<<<<<<< Updated upstream
    //boolean addScore();
    
    //...
    default void printInfo() { // Default method
        System.out.println("This is a shape.");
=======
    default void gameOver(int num) // game over panel 
    {	
		ScreenController.switchScene(new GameOverPanel(num));
>>>>>>> Stashed changes
    }


}
