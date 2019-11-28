package edu.sjsu.cs151.tetris.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPanel extends Panel
{
	public MainPanel()
	{
		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(204,229,255));
		mainPanel.setSize(600, 800);
		
		JPanel bigPanel = new JPanel();
		bigPanel.setBackground(new Color(204,229,255));
		bigPanel.setOpaque(true);
		bigPanel.setPreferredSize(new Dimension(550, 550));
		
		JPanel iconZ = iconZ();
		iconZ.setBackground(new Color(204,229,255));
		iconZ.setOpaque(true);
		
		JPanel iconL = iconL();
		iconL.setBackground(new Color(204,229,255));
		iconL.setOpaque(true);
		
		JPanel iconO = iconO();
		iconO.setBackground(new Color(204,229,255));
		iconO.setOpaque(true);
		
		JLabel gameLabel = new JLabel("T E R I S");	
		gameLabel.setFont(new Font("TimesRoman", Font.BOLD, 84));
		setLabelCenter(gameLabel);
		gameLabel.setBackground(new Color(204,229,255));
		gameLabel.setOpaque(true);
		
		playgameButton = new JButton	("    Play Game   ");
		setButton(playgameButton, 48);
		
		leaderboardsButton = new JButton(" Leaderboards ");
		setButton(leaderboardsButton, 48);

		quitButton = new JButton		("         Quit         ");
		setButton(quitButton, 48);
		
		JPanel box1 = empty3Boxs();
		box1.setBackground(new Color(204,229,255));
		box1.setOpaque(true);
		
		JPanel box2 = new JPanel(new GridLayout(1, 10));
		box2.setBackground(new Color(204,229,255));
		box2.setOpaque(true);
		
		JPanel box3 = new JPanel(new GridLayout(1, 10));
		box3.setBackground(new Color(204,229,255));
		box3.setOpaque(true);
		
		JPanel box4 = new JPanel(new GridLayout(1, 10));
		box4.setBackground(new Color(204,229,255));
		box4.setOpaque(true);
		
		JPanel box5 = empty3Boxs();
		box5.setBackground(new Color(204,229,255));
		box5.setOpaque(true);
        
		bigPanel.setLayout(new BoxLayout(bigPanel, BoxLayout.Y_AXIS));
		
		bigPanel.add(box1);
		bigPanel.add(gameLabel);
		
		bigPanel.add(box2);
		bigPanel.add(playgameButton);
		
		bigPanel.add(box3);
		bigPanel.add(leaderboardsButton);
		
		bigPanel.add(box4);
		bigPanel.add(quitButton);
		bigPanel.add(box5);
		
		bigPanel.setVisible(true);
		
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(bigPanel, BorderLayout.CENTER);
		mainPanel.add(iconZ, BorderLayout.WEST);
		mainPanel.add(iconL, BorderLayout.EAST);
		mainPanel.add(iconO, BorderLayout.SOUTH);
		
		mainPanel.setVisible(true);
	}
	
	public JPanel getMainPanel()
	{
		return mainPanel;
	}
	
	public JButton getPlaygameButtun()
	{
		return playgameButton;
	}
	
	public JButton getLeaderboardsButton()
	{
		return leaderboardsButton;
	}
	
	public JButton getQuitButton()
	{
		return quitButton;
	}
	
	JPanel mainPanel;
	JButton playgameButton;
	JButton leaderboardsButton;
	JButton quitButton;	
}


