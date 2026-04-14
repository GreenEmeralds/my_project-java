package main;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import managers.IGameManager;
import managers.UiManager;
import panels.GameOverPanel;
import panels.StartPanel;

import java.awt.event.*;
//import java.awt.Toolkit;
import java.awt.*;

public class MainMenu extends JPanel{
    private static final long serialVersionUID = -4681849094713181468L;
    
    String TITLE = "< MY MINI GAMES >";
    String HEADER = "BY GREEN EMERALDS";
    int[] TITLE_SIZE = {GameConstants.SCREEN_SIZE[0],80};
    int[] HEADER_SIZE = {GameConstants.SCREEN_SIZE[0],30};
    int[] PNL_SIZE = {GameConstants.mainBTN_Dimension[0]+10,GameConstants.mainBTN_Dimension[1]*3+20};
    
    JButton[] btns = new JButton[3];
    StartPanel startPanel;
    
    public MainMenu(JFrame f, project_1.GamePanel game_1, project_2.GamePanel game_2, project_3.GamePanel game_3)
    {
    	setLayout(null);
    	setBackground(GameConstants.bgColor);
    	CreateTitle(0,GameConstants.margin,TITLE_SIZE[0],TITLE_SIZE[1]);
    	AddButtons((int)GameConstants.getCenterPosX(PNL_SIZE[0]),TITLE_SIZE[1]+HEADER_SIZE[1]+GameConstants.margin*2,PNL_SIZE[0],PNL_SIZE[1]);
    	//
    	AddExit(0, GameConstants.SCREEN_SIZE[1]- 50 - GameConstants.margin - 25,200,50);
    	
    	StartPanel.setBackButton(this);
    	GameOverPanel.setBackButton(this);
    	UiManager.setBackButton(this);
    }


    void CreateTitle(int x,int y,int w,int h)
    {
        // Create Title label
        JLabel titleLabel = new JLabel(TITLE);
        titleLabel.setFont(GameConstants.titleFont);
        titleLabel.setBackground(GameConstants.bgColor);
        titleLabel.setOpaque(true);
        titleLabel.setBounds(x,y, w, h);
        
        titleLabel.setHorizontalAlignment(0);//center text
        
        // Create header label
        JLabel headerLabel = new JLabel(HEADER);
        headerLabel.setFont(GameConstants.printFont);
        headerLabel.setBackground(GameConstants.bgColor);
        headerLabel.setOpaque(true);
        headerLabel.setBounds(0,TITLE_SIZE[1]+GameConstants.margin, HEADER_SIZE[0], HEADER_SIZE[1]);
        
        headerLabel.setHorizontalAlignment(0);//center text
        
        // add Components to JPanel (this)
        add(titleLabel);
        add(headerLabel);
    }

    void AddButtons(int x, int y, int w, int h, JFrame f, JPanel game_1, JPanel game_2, JPanel game_3)
    {
    	// Initialize start button game system ...
    	JPanel[] games = {game_1,game_2,game_3};
    	IGameManager[] gameManagers = {(IGameManager)game_1,(IGameManager)game_2,(IGameManager)game_3};
    	startPanel = new StartPanel(games,gameManagers);
    	
    	// Create Buttons
        JPanel panel = new JPanel();
        //panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.setBackground(GameConstants.bgColor);
        panel.setBounds(x,y, w, h);
    
        JButton[] btns = new JButton[3];
        JButton btn_1 = new JButton("PING PONG");
        JButton btn_2 = new JButton("DUCK JUMP");
        JButton btn_3 = new JButton("TIC TAC TOE");

        btns[0] = btn_1;
        btns[1] = btn_2;
        btns[2] = btn_3;
        
        for(JButton btn : btns)
        {
        	btn.setBorder(BorderFactory.createLineBorder(GameConstants.acColor, GameConstants.lineWidth));
        	btn.setBackground(GameConstants.bgColor);
            btn.setPreferredSize(new Dimension(GameConstants.mainBTN_Dimension[0],GameConstants.mainBTN_Dimension[1]));
            btn.setFont(GameConstants.headerFont);
            panel.add(btn);
        }
        
/// BUTTON ACTIONS ///

    	btns[0].addActionListener(new ActionListener() {
    		
            public void actionPerformed(ActionEvent e)
            {
            	startPanel.initialize(0);
            	ScreenController.switchScene(startPanel);    
            	System.out.println("game1");
            }
        });
    	
    	btns[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
            	startPanel.initialize(1);
            	ScreenController.switchScene(startPanel); 
            	System.out.println("game2");
            }
        });
    	
    	btns[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
            	startPanel.initialize(2);
            	ScreenController.switchScene(startPanel);
            	System.out.println("game3");
            }
        });
    	
    	add(panel);
    }
    
    public void AddExit(int x, int y, int w ,int h)
    {
        JButton exitBtn = new JButton("< EXIT >");
        
        exitBtn.setBorder(null);
        exitBtn.setFont(GameConstants.printFont);
        exitBtn.setBounds(x, y, w, h);
        
        add(exitBtn);

    }
}

