/*
	 * Author: Levi McRea
	 * Purpose: To create a page that outputs the information for the users recommendation
	 * Last Version Date: 4/20/2025
	 * 
	 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ResultGUI extends JPanel{

	
	private Main objMain; //objects to reference data
	private Player player;
	

		public ResultGUI(Main objMain, Player player) {
		
			this.objMain = objMain;
			this.player = player;
		
			Recommendation rec = new Recommendation(this.player); //create a "recommendation"
			
		setLayout(new BorderLayout()); //create border layout
		//creating outer borders to be blank with the same color to make it asthetically pleasing (same as question page)
				JPanel panNorth = new JPanel();
				panNorth.setBackground(new Color(22, 33, 54));
				JPanel panEast = new JPanel();
				panEast.setBackground(new Color(22, 33, 54));
				JPanel panWest = new JPanel();
				panWest.setBackground(new Color(22, 33, 54));
				
				add(panNorth, BorderLayout.NORTH); //add panels to layout
				add(panEast, BorderLayout.EAST);
				add(panWest, BorderLayout.WEST);
		
				JPanel panSouth = new JPanel(); //south panel components
				panSouth.setBackground(new Color(22, 33, 54));
				JLabel lblfooter = new JLabel("© 2025 ValVanguard.");
				lblfooter.setFont(new Font("Monospaced",Font.BOLD,16 )); //set font and word size
				lblfooter.setForeground(new Color(255,255,255)); //set word colors
				panSouth.add(lblfooter);
				
				add(panSouth, BorderLayout.SOUTH); //add south
				
				JPanel panCenter = new JPanel();
				panCenter.setLayout(new BoxLayout(panCenter,BoxLayout.Y_AXIS)); //setting boxlayout for center panel
				panCenter.setBackground(new Color(255, 70, 85));
				
				JLabel pageTop = new JLabel("Here are the following recommendations for Valorant!");
				pageTop.setFont(new Font("Monospaced", Font.BOLD, 26));
				pageTop.setForeground(Color.BLACK);
				pageTop.setAlignmentX(Component.CENTER_ALIGNMENT); // center horizontally
				
				panCenter.add(pageTop);
				
				rec.calculateCharacter(); //calculates recommendations for player
				rec.calculateGamemode();
				rec.calculateMap();
				rec.calculateWeapon();
				
				String outHold = rec.toString(); //place holder for the toString
				String output = "<html><pre>" + outHold + "</pre></html>"; //use html to allow formatting of string (allows for easy line break)
				
				JLabel lblRecommend = new JLabel(output);
				lblRecommend.setFont(new Font("Monospaced", Font.BOLD, 18));
				lblRecommend.setForeground(Color.BLACK);
				lblRecommend.setAlignmentX(Component.CENTER_ALIGNMENT); // center horizontally
				
				panCenter.add(lblRecommend);
				
				JButton btnReturn = new JButton("Return"); //button to return user to beginning
				btnReturn.setFont(new Font("Monospaced",Font.BOLD,18));
				btnReturn.setMaximumSize(new Dimension(200, 75)); //sets button size
				btnReturn.setAlignmentX(Component.CENTER_ALIGNMENT); //sets alignment to center
				
				btnReturn.addActionListener(new ActionListener() { //action listener is for returning to home page
					 
					 public void actionPerformed(ActionEvent e) { 
				
						 objMain.showWelcomePage(); //returns to main page
					 }
					});
				
				panCenter.add(btnReturn);
			    
			
				add(panCenter, BorderLayout.CENTER);
		
		setVisible(true);
}
}
