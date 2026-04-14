package panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import main.Constants;
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
        EmptyBorder paddingBorder = new EmptyBorder(Constants.margin, Constants.margin, Constants.margin, Constants.margin);
        LineBorder lineBorder = new LineBorder(Constants.acColor, 3); // 2-pixel blue line
        CompoundBorder innerLineBorder = new CompoundBorder(paddingBorder, lineBorder);
        
        setLayout(null);
        setBackground(Constants.bgColor);
        setBorder(innerLineBorder);
        
        // BACK BUTTON 
        backBtn.setBorder(null);
		backBtn.setFont(Constants.printFont);
		backBtn.setBounds(0, Constants.SCREEN_SIZE[1] - 50 - Constants.margin - 25, 200, 50);
        
        // START BUTTON 
		int W = 300;
		int H = 100;
		
		// NOTE: you can't change the already  start btn after it had been initialed // maybe JButton and Button class work differently
		// RENOTE: Set new instance of StartPanel... 
		
		Start_BTN.setBounds(Constants.SCREEN_SIZE[0]/2 - W/2, Constants.SCREEN_SIZE[1]/2 -H/2 -25, W, H); // x y, w h 
		
		Start_BTN.setBorder(BorderFactory.createLineBorder(Constants.acColor, Constants.lineWidth));
		Start_BTN.setBackground(Constants.bgColor);

		Start_BTN.setFont(Constants.titleFont);
		
		if(Start_BTN.getActionListeners().length > 0)
		{
			Start_BTN.removeActionListener(Start_BTN.getActionListeners()[0]);
		}
		
		Start_BTN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {		
				GameController.gameStart();
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
