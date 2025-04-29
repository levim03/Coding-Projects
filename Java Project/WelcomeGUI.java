/*
	 * Author: Levi McRea
	 * Purpose: To create a page that welcomes the user and explains the program
	 * Last Version Date: 4/19/2025
	 * 
	 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;


public class WelcomeGUI extends JPanel {

	private ValData dialogMessage = new ValData();
	private Main objMain;
	
	public WelcomeGUI(Main objMain) { //using main object to initialize constructor and use its information
		
		this.objMain = objMain;
		
		setLayout(null); //set layout to null so i can put another layout with the additional panel on top of it
		setBackground(new Color(22, 33, 54)); //set background color
		
		
		JPanel centerPanel = new JPanel(); //create a panel to add on top of the main one for styling
		centerPanel.setBounds(425, 0, 1000, 1000); //setting the bounds of the panel or "window"
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS)); //using boxlayout as it allows me to stack components the most efficiently
		centerPanel.setBackground(new Color(255, 70, 85));
		
		JLabel lblWelcome = new JLabel("Welcome to ValVanguard!"); //create JLabel
		lblWelcome.setFont(new Font("Monospaced",Font.BOLD,30 )); //set label fonts
		lblWelcome.setForeground(new Color(0,0,0)); //set word colors
		lblWelcome.setAlignmentX(Component.CENTER_ALIGNMENT); //sets alignment to center with box layout
		
		centerPanel.add(lblWelcome);
		
										//using <html> allows me to put <br> statements to put new line for the text.  This is so I don't have to make multiple JLabels
		JLabel lblExplain = new JLabel("<html>"
				+ "[]This is the all inclusive program that gives the best suggestions to new Valorant players<br>"
				+ "[]You will be asked a series of questions regarding various important topics in Valorant<br>"
				+ "[]After the answers have been logged, you will recieve the best suggestions to start playing Valorant!");
		lblExplain.setFont(new Font("Monospaced",Font.BOLD,16 )); //set label fonts
		lblExplain.setForeground(new Color(0,0,0)); //set word colors
		lblExplain.setBorder(new LineBorder(Color.WHITE, 4)); //making an outline around the main JLabel title
		lblExplain.setAlignmentX(Component.CENTER_ALIGNMENT); //sets alignment to center with box layout
		
		centerPanel.add(lblExplain);
		
		
		JButton btnbegin = new JButton("Click here to begin!");
		btnbegin.setFont(new Font("Monospaced",Font.BOLD,18));
		btnbegin.setMaximumSize(new Dimension(300, 50)); //sets button size
		btnbegin.setAlignmentX(Component.CENTER_ALIGNMENT); //sets alignment to center
		btnbegin.addActionListener(new btnBeginListener());
		
		centerPanel.add(Box.createRigidArea(new Dimension(0, 20))); //adds spacing between the button and the JLabels
		
		
		centerPanel.add(btnbegin);
		
		
		JLabel lblYesno = new JLabel("Would you like to view all referenced Valorant data for the program? (IF NO, JUST CLICK BEGIN)");
		lblYesno.setFont(new Font("Monospaced",Font.BOLD,16 )); //set label fonts
		lblYesno.setForeground(new Color(0,0,0)); //set word colors
		lblYesno.setAlignmentX(Component.CENTER_ALIGNMENT); //sets alignment to center
		centerPanel.add(lblYesno);
		
		JButton btnYes = new JButton("Yes"); //button to ask if user wants to display information the program is referencing
		
		btnYes.setPreferredSize(new Dimension(150, 40)); //set dimensions
		btnYes.setAlignmentX(Component.CENTER_ALIGNMENT); //sets alignment to center
		
		btnYes.addActionListener(new ActionListener() { //create action listener for button yes
		    public void actionPerformed(ActionEvent e) {
		        String output = dialogMessage.toString();
		        JOptionPane.showMessageDialog(objMain, output); // Use objectMain instead of `this` if you're inside an inner class
		    }
		});

		
		centerPanel.add(btnYes); //add buttons

		
		add(centerPanel); //adding panel to frame
		
	}
	
	private class btnBeginListener implements ActionListener { //action listener function for start button
		
		public void actionPerformed(ActionEvent event) {
			
			System.out.println("Button was clicked!");
			
			objMain.showQuePage(); //calls the question page to pull it up
		}
	}
	
}
