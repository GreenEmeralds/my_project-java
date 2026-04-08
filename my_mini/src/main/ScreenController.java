package main;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ScreenController {
	
	public static JFrame f;
	
	public static void setFrame(JFrame frame)
	{
		f = frame;
	}
	
	public static void switchScene(JPanel scene)
	{
		//System.out.println("change to " + scene);
        //Remove all components from the content pane of the JFrame
        f.getContentPane().removeAll();
        // Add new components
        f.add(scene); 
        
        // Revalidated and repaint to update the UI
        f.getContentPane().revalidate();
        f.getContentPane().repaint();

	}
}
