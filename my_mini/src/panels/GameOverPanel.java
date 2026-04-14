package panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import main.Constants;
import main.GameController;


public class GameOverPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	public static JButton backBtn = new JButton("< BACK >");
	public static JButton Restart_BTN  = new JButton("RESTART");
	
	public GameOverPanel(int num)// num to get which game to start 
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
		
		backBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GameController.goToMain();
			}	
		});
        
		//TEXT
		JLabel GameOver_LBL = new JLabel();
		
		int text_W = 300;
		int text_H = 100;

		GameOver_LBL.setBounds((int)GameConstants.getCenterPosX(text_W), (int)GameConstants.getCenterPosY(text_H)- 40, text_W , text_H); // x y, w h 
		GameOver_LBL.setText("GAME OVER");
		GameOver_LBL.setFont(GameConstants.titleFont);
		GameOver_LBL.setBackground(GameConstants.bgColor);

		//RESTART BUTTON
		int btn_W = 200;
		int btn_H = 50;
		Restart_BTN.setBounds((int)Constants.getCenterPosX(btn_W), (int)Constants.getCenterPosY(btn_H)+Constants.margin, btn_W , btn_H); // x y, w h 
		Restart_BTN.setBorder(BorderFactory.createLineBorder(Constants.acColor, Constants.lineWidth));
		Restart_BTN.setBackground(Constants.bgColor);

		Restart_BTN.setFont(Constants.headerFont);
		
		if(Restart_BTN.getActionListeners().length > 0)
		{
			Restart_BTN.removeActionListener(Restart_BTN.getActionListeners()[0]);
		}
		
		Restart_BTN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GameController.gameRestart(num);
			}	
		});
		
		//ADD TO PANEL
		add(backBtn);
		add(Restart_BTN);
		add(GameOver_LBL);
		
	}
	
	public static void initialize()
	{
		//
	}
	

}
