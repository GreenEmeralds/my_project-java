package managers;

public interface IGameManager {
	// Abstract method
    void setStart(); 
    void setPause(); 
    void setResume(); 
    void setRestart(); 
    
    //boolean addScore();
    
    //...
    default void printInfo() { // Default method
        System.out.println("This is a shape.");
    }

}
