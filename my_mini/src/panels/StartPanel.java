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
import main.ScreenController;
import managers.IGameManager;

public class StartPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	
	
	public static JButton backBtn = new JButton("< BACK >");
	public static JButton[] Start_BTNs = new JButton[3];
	int num=0;
	
	public StartPanel(JPanel[] game, IGameManager[] gameManager)
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
		
		
		while(num<3)
		{
			Start_BTNs[num] = new JButton("START");
			Start_BTNs[num].setBounds(Constants.SCREEN_SIZE[0]/2 - W/2, Constants.SCREEN_SIZE[1]/2 -H/2 -25, W, H); // x y, w h 
			
			Start_BTNs[num].setBorder(BorderFactory.createLineBorder(Constants.acColor, Constants.lineWidth));
			Start_BTNs[num].setBackground(Constants.bgColor);

			Start_BTNs[num].setFont(Constants.titleFont);
			
			num++;
		}
		// this might justr have to be indivituall because of action listner ... 
		Start_BTNs[0].addActionListener(new ActionListener() {
			@Override
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
			}	
		});
		
	}
	

	public void initialize(int gameNumber)
	{
		// ADD COMPONEMTS
		for(int i =0; i<3; i++)
		{
			if(gameNumber == i)
			{
				add(Start_BTNs[i]);
			}
			else
			{
				remove(Start_BTNs[i]);
			}
		}
        
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
