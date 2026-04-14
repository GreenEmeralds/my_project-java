package panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import main.GameConstants;
import main.GameController;
import main.ScreenController;

public class StartPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	
	
	public static JButton backBtn = new JButton("< BACK >");
	public static JButton[] Start_BTNs = new JButton[3];
	public static JButton Start_BTN = new JButton("START");
	int num=0;
	
	public StartPanel()
	{
		// BACKGROUND 
        // Create the inner border line effect
        EmptyBorder paddingBorder = new EmptyBorder(GameConstants.margin, GameConstants.margin, GameConstants.margin, GameConstants.margin);
        LineBorder lineBorder = new LineBorder(GameConstants.acColor, 3); // 2-pixel blue line
        CompoundBorder innerLineBorder = new CompoundBorder(paddingBorder, lineBorder);
        
        setLayout(null);
        setBackground(GameConstants.bgColor);
        setBorder(innerLineBorder);
        
        // BACK BUTTON 
        backBtn.setBorder(null);
		backBtn.setFont(GameConstants.printFont);
		backBtn.setBounds(0, GameConstants.SCREEN_SIZE[1] - 50 - GameConstants.margin - 25, 200, 50);
        
        // START BUTTON 
		int W = 300;
		int H = 100;
		
		// NOTE: you can't change the already  start btn after it had been initialed // maybe JButton and Button class work differently
		// RENOTE: Set new instance of StartPanel... 
		
		Start_BTN.setBounds(GameConstants.SCREEN_SIZE[0]/2 - W/2, GameConstants.SCREEN_SIZE[1]/2 -H/2 -25, W, H); // x y, w h 
		
		Start_BTN.setBorder(BorderFactory.createLineBorder(GameConstants.acColor, GameConstants.lineWidth));
		Start_BTN.setBackground(GameConstants.bgColor);

		Start_BTN.setFont(GameConstants.titleFont);
		
		if(Start_BTN.getActionListeners().length > 0)
		{
			Start_BTN.removeActionListener(Start_BTN.getActionListeners()[0]);
		}
		
		Start_BTN.addActionListener(new ActionListener() {
			@Override
<<<<<<< Updated upstream
			public void actionPerformed(ActionEvent e) {
				ScreenController.switchScene(game[0]);
                // set start function from game panel
				gameManager[0].setStart();
			}	
		});
		Start_BTNs[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ScreenController.switchScene(game[1]);
                // set start function from game panel
				gameManager[1].setStart();
			}	
		});
		Start_BTNs[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ScreenController.switchScene(game[2]);
                // set start function from game panel
				gameManager[2].setStart();
=======
			public void actionPerformed(ActionEvent e) {		
				GameController.gameStart();
>>>>>>> Stashed changes
			}	
		});

		initialize();
		
	}
	

	public void initialize()
	{
		// ADD COMPONEMTS
		add(Start_BTN);
        
        add(backBtn);		
	}
	
	public static void setBackButton(JPanel mainMenu)
	{
        backBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ScreenController.switchScene(mainMenu);
			}	
		});
	}
	
}
