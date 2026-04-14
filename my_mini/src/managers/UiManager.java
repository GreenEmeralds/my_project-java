package managers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import main.Constants;
import main.GameController;

public class UiManager{ 
	public static JButton Pause_BTN  = new JButton("PAUSE");
	public static JButton Resume_BTN  = new JButton("RESUME");
	
	public static JButton Back_BTN  = new JButton("BACK");

	public static JLabel Score_LBL  = new JLabel("SCORE:");

	public static JButton pause_BTN(JPanel game_pnl, IGameManager gameManager)
	{
		int W = 200;
		int H = 50;
		
		Pause_BTN.setBounds(Constants.SCREEN_SIZE[0]-W - Constants.margin - Constants.margin , Constants.margin, W, H); // x y, w h 
		Pause_BTN.setFont(Constants.printFont);
		Pause_BTN.setHorizontalAlignment(SwingConstants.RIGHT);
		
		Pause_BTN.setBorder(null);
		
		Pause_BTN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Pause_BTN.setVisible(false);
				Resume_BTN.setVisible(true);
				Back_BTN.setVisible(true);
				gameManager.setPause();
			}	
		});

		return Pause_BTN;
	}

	public static JButton resume_BTN(JPanel game_pnl, IGameManager gameManager)
	{
		Resume_BTN.setVisible(false);
		int W = 100;
		int H = 50;
		
		Resume_BTN.setBounds(Constants.SCREEN_SIZE[0]-W- Constants.margin-Constants.margin , Constants.margin, W, H); // x y, w h 
		Resume_BTN.setFont(Constants.printFont);
		Resume_BTN.setHorizontalAlignment(SwingConstants.RIGHT);
		
		Resume_BTN.setBorder(null);

		Resume_BTN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Pause_BTN.setVisible(true);
				Resume_BTN.setVisible(false);
				Back_BTN.setVisible(false);
				gameManager.setResume();
			}	
		});

		return Resume_BTN;
	}
	
	public static JButton back_BTN(JPanel game_pnl, IGameManager gameManager)
	{
		Back_BTN.setVisible(false);
		int W = 200;
		int H = 100;
		
		Back_BTN.setBounds(Constants.SCREEN_SIZE[0]-W- Constants.margin-Constants.margin, Constants.SCREEN_SIZE[1]-H- Constants.margin, W, H); // x y, w h 
		Back_BTN.setFont(Constants.printFont);
		Back_BTN.setHorizontalAlignment(SwingConstants.RIGHT);
		
		Back_BTN.setBorder(null);
		
		Back_BTN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Pause_BTN.setVisible(true);
				Resume_BTN.setVisible(false);
				Back_BTN.setVisible(false);			
				GameController.goToMain();
			}	
		});

		return Back_BTN;
		
	}

	public static JLabel score_LBL(int score)
	{
		Score_LBL.setBounds(Constants.margin+Constants.margin, Constants.margin, 200, 50);
		Score_LBL.setFont(Constants.printFont);

		Score_LBL.setText("SCORE: "+ score);
		return Score_LBL;
	}

}
