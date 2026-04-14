package main;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import panels.StartPanel;

import java.awt.event.*;
//import java.awt.Toolkit;
import java.awt.*;

public class MainMenu extends JPanel{
    private static final long serialVersionUID = -4681849094713181468L;
    
    String TITLE = "< MY MINI GAMES >";
    String HEADER = "BY GREEN EMERALDS";
    int[] TITLE_SIZE = {Constants.SCREEN_SIZE[0],80};
    int[] HEADER_SIZE = {Constants.SCREEN_SIZE[0],30};
    int[] PNL_SIZE = {Constants.mainBTN_Dimension[0]+10,Constants.mainBTN_Dimension[1]*3+20};
    
    JButton[] btns = new JButton[3];
    
    public MainMenu()
    {
    	setLayout(null);
    	setBackground(Constants.bgColor);
    	CreateTitle(0,Constants.margin,TITLE_SIZE[0],TITLE_SIZE[1]);
    	AddButtons((int)Constants.getCenterPosX(PNL_SIZE[0]),TITLE_SIZE[1]+HEADER_SIZE[1]+Constants.margin*2,PNL_SIZE[0],PNL_SIZE[1]);
    	//
    	AddExit(0, Constants.SCREEN_SIZE[1]- 50 - Constants.margin - 25,200,50);
    	
    	StartPanel.setBackButton(this);
    	GameController.setMainMenu(this);
    }


    void CreateTitle(int x,int y,int w,int h)
    {
        // Create Title label
        JLabel titleLabel = new JLabel(TITLE);
        titleLabel.setFont(Constants.titleFont);
        titleLabel.setBackground(Constants.bgColor);
        titleLabel.setOpaque(true);
        titleLabel.setBounds(x,y, w, h);
        
        titleLabel.setHorizontalAlignment(0);//center text
        
        // Create header label
        JLabel headerLabel = new JLabel(HEADER);
        headerLabel.setFont(Constants.printFont);
        headerLabel.setBackground(Constants.bgColor);
        headerLabel.setOpaque(true);
        headerLabel.setBounds(0,TITLE_SIZE[1]+Constants.margin, HEADER_SIZE[0], HEADER_SIZE[1]);
        
        headerLabel.setHorizontalAlignment(0);//center text
        
        // add Components to JPanel (this)
        add(titleLabel);
        add(headerLabel);
    }

    void AddButtons(int x, int y, int w, int h)
    {
    	
    	// Create Buttons
        JPanel panel = new JPanel();
        //panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.setBackground(Constants.bgColor);
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
        	btn.setBorder(BorderFactory.createLineBorder(Constants.acColor, Constants.lineWidth));
        	btn.setBackground(Constants.bgColor);
            btn.setPreferredSize(new Dimension(Constants.mainBTN_Dimension[0],Constants.mainBTN_Dimension[1]));
            btn.setFont(Constants.headerFont);
            panel.add(btn);
        }
        
/// BUTTON ACTIONS ///

    	btns[0].addActionListener(new ActionListener() {
    		
            public void actionPerformed(ActionEvent e)
            {
            	GameController.startGame(1);
            }
        });
    	
    	btns[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
            	GameController.startGame(2);
            }
        });
    	
    	btns[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
            	GameController.startGame(3);
            }
        });
    	
    	add(panel);
    }
    
    public void AddExit(int x, int y, int w ,int h)
    {
        JButton exitBtn = new JButton("< EXIT >");
        
        exitBtn.setBorder(null);
        exitBtn.setFont(Constants.printFont);
        exitBtn.setBounds(x, y, w, h);
        
        add(exitBtn);

    }
}

