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
<<<<<<< Updated upstream
import main.ScreenController;
import managers.IGameManager;
=======
import main.GameController;

>>>>>>> Stashed changes

public class GameOverPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	public static JButton backBtn = new JButton("< BACK >");
<<<<<<< Updated upstream

	public void initialize(JPanel game, IGameManager gameManager)
=======
	public static JButton Restart_BTN  = new JButton("RESTART");
	
	public GameOverPanel(int num)// num to get which game to start 
>>>>>>> Stashed changes
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

		GameOver_LBL.setBounds((int)Constants.getCenterPosX(text_W), (int)Constants.getCenterPosY(text_H)- 40, text_W , text_H); // x y, w h 
		GameOver_LBL.setText("GAME OVER");
		GameOver_LBL.setFont(Constants.titleFont);
		GameOver_LBL.setBackground(Constants.bgColor);

		//RESTART BUTTON
		int btn_W = 200;
		int btn_H = 50;
<<<<<<< Updated upstream
		
		JButton Restart_BTN  = new JButton("RESTART");
		
=======

>>>>>>> Stashed changes
		Restart_BTN.setBounds((int)Constants.getCenterPosX(btn_W), (int)Constants.getCenterPosY(btn_H)+Constants.margin, btn_W , btn_H); // x y, w h 
		Restart_BTN.setBorder(BorderFactory.createLineBorder(Constants.acColor, Constants.lineWidth));
		Restart_BTN.setBackground(Constants.bgColor);

		Restart_BTN.setFont(Constants.headerFont);
<<<<<<< Updated upstream

		Restart_BTN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ScreenController.switchScene(game);
				gameManager.setRestart();
			}	
		});
		
		//ADD TO PANEL
		add(backBtn);
		add(GameOver_LBL);
		add(Restart_BTN);
		
	}
	
	public static void setBackButton(JPanel mainMenu)
	{
        backBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("back");
				ScreenController.switchScene(mainMenu);
			}	
		});
=======
		
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
>>>>>>> Stashed changes
	}
	

}
