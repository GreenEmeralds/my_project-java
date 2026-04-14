package managers;


import main.ScreenController;
import panels.GameOverPanel;


public interface IGameManager {
	// Abstract method
    void setStart(); 
    void setPause(); 
    void setResume(); 
    
    default void gameOver(int num) // game over panel 
    {	
		ScreenController.switchScene(new GameOverPanel(num));
    }


}
