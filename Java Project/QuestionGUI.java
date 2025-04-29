/*
	 * Author: Levi McRea
	 * Purpose: To create a page that takes in user input
	 * Last Version Date: 4/19/2025
	 * 
	 */

import javax.swing.*;



import java.awt.*;
import java.awt.event.*;

public class QuestionGUI extends JPanel{

	private Main objMain; //objects to reference data
	private Player player;
	
	
	public QuestionGUI(Main objMain, Player player) {
		
		this.objMain = objMain;
		this.player = player;
		
		setLayout(new BorderLayout()); //create border layout
		
		//creating outer borders to be blank with the same color to make it asthetically pleasing
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
		panCenter.setLayout(new BoxLayout(panCenter,BoxLayout.Y_AXIS)); //setting boxlayout for center panel to allow for better positioning for components
		panCenter.setBackground(new Color(255, 70, 85));
		
		JLabel pageTop = new JLabel("Please answer the following questions provided!");
		pageTop.setFont(new Font("Monospaced", Font.BOLD, 26));
		pageTop.setForeground(Color.BLACK);
		pageTop.setAlignmentX(Component.CENTER_ALIGNMENT); // center horizontally
		//panCenter.add(Box.createVerticalStrut(10)); // spacing
		panCenter.add(pageTop);
		
		JLabel questionOne = new JLabel("<html>[]What personality do you prefer your agent to be?"); //first question JLabel
		questionOne.setFont(new Font("Monospaced",Font.BOLD,18 ));
		questionOne.setForeground(new Color(0,0,0)); //set word colors
		questionOne.setAlignmentX(Component.CENTER_ALIGNMENT); //center horizontally
	
		panCenter.add(questionOne);
		
		JPanel radioPanelOne = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10)); //radio panel 1 for buttons
		radioPanelOne.setBackground(new Color(255, 70, 85)); //setting background
		
		ButtonGroup answerGroupOne = new ButtonGroup(); //creating button group for radio buttons on the first question
        JRadioButton rTricky = new JRadioButton("Tricky");
        JRadioButton rIntimidating = new JRadioButton("Intimidating");
        JRadioButton rWild = new JRadioButton("Wild");
        JRadioButton rEnergetic = new JRadioButton("Energetic");
        JRadioButton rCalm = new JRadioButton("Calm");
        JRadioButton rChaotic = new JRadioButton("Chaotic");
        JRadioButton rSneaky = new JRadioButton("Sneaky");
        JRadioButton rMysterious = new JRadioButton("Mysterious");
        JRadioButton rIndependent = new JRadioButton("Independent");
        JRadioButton rStylish = new JRadioButton("Stylish");
        JRadioButton rGenius = new JRadioButton("Genius");

        answerGroupOne.add(rTricky);  //adding buttons to group and panel
        answerGroupOne.add(rIntimidating);
        answerGroupOne.add(rWild);
        answerGroupOne.add(rEnergetic);
        answerGroupOne.add(rCalm);
        answerGroupOne.add(rChaotic);
        answerGroupOne.add(rSneaky);
        answerGroupOne.add(rMysterious);
        answerGroupOne.add(rIndependent);
        answerGroupOne.add(rStylish);
        answerGroupOne.add(rGenius);

        radioPanelOne.add(rTricky);
        radioPanelOne.add(rIntimidating);
        radioPanelOne.add(rWild);
        radioPanelOne.add(rEnergetic);
        radioPanelOne.add(rCalm);
        radioPanelOne.add(rChaotic);
        radioPanelOne.add(rSneaky);
        radioPanelOne.add(rMysterious);
        radioPanelOne.add(rIndependent);
        radioPanelOne.add(rStylish);
        radioPanelOne.add(rGenius);
        
        panCenter.add(radioPanelOne); //adding radio button panel to center
        
		JLabel questionTwo = new JLabel("<html>[]What map types do you prefer?"); //second question JLabel
		questionTwo.setFont(new Font("Monospaced",Font.BOLD,18 ));
		questionTwo.setForeground(new Color(0,0,0)); //set word colors
		questionTwo.setAlignmentX(Component.CENTER_ALIGNMENT);
	
		panCenter.add(questionTwo); //adding second question
		
		JPanel radioPanelTwo = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
		radioPanelTwo.setBackground(new Color(255, 70, 85));

		ButtonGroup answerGroupTwo = new ButtonGroup(); //create button group for second question
		JRadioButton rCloseQuarter = new JRadioButton("Close-quarter");
		JRadioButton rOpenAngle = new JRadioButton("Open-angle");
		JRadioButton rVertical = new JRadioButton("Vertical-based");
		JRadioButton rHybrid = new JRadioButton("Hybrid-mix");

		
		answerGroupTwo.add(rCloseQuarter); //adding buttons to group and panel
		answerGroupTwo.add(rOpenAngle);
		answerGroupTwo.add(rVertical);
		answerGroupTwo.add(rHybrid);

		
		radioPanelTwo.add(rCloseQuarter);
		radioPanelTwo.add(rOpenAngle);
		radioPanelTwo.add(rVertical);
		radioPanelTwo.add(rHybrid);

		panCenter.add(radioPanelTwo);
		
		JLabel questionThree = new JLabel("<html>[]What is your preferred playstyle?");
		questionThree.setFont(new Font("Monospaced",Font.BOLD,18));
		questionThree.setForeground(new Color(0,0,0));
		questionThree.setAlignmentX(Component.CENTER_ALIGNMENT);
		panCenter.add(questionThree);

		JPanel radioPanelThree = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
		radioPanelThree.setBackground(new Color(255, 70, 85));
		
		ButtonGroup answerGroupThree = new ButtonGroup(); //creating button group for radio buttons on the third question
		JRadioButton rAggressive = new JRadioButton("Aggressive");
		JRadioButton rPassive = new JRadioButton("Passive");
		JRadioButton rTactical = new JRadioButton("Tactical");
		JRadioButton rLurker = new JRadioButton("Lurker");
		JRadioButton rEntryFragger = new JRadioButton("Entry Fragger");
		JRadioButton rSupport = new JRadioButton("Support");
		JRadioButton rSniper = new JRadioButton("Sniper");
		JRadioButton rController = new JRadioButton("Controller");
		JRadioButton rHealer = new JRadioButton("Healer");

		answerGroupThree.add(rAggressive); //adding buttons to group and panel
		answerGroupThree.add(rPassive);
		answerGroupThree.add(rTactical);
		answerGroupThree.add(rLurker);
		answerGroupThree.add(rEntryFragger);
		answerGroupThree.add(rSupport);
		answerGroupThree.add(rSniper);
		answerGroupThree.add(rController);
		answerGroupThree.add(rHealer);

		radioPanelThree.add(rAggressive);
		radioPanelThree.add(rPassive);
		radioPanelThree.add(rTactical);
		radioPanelThree.add(rLurker);
		radioPanelThree.add(rEntryFragger);
		radioPanelThree.add(rSupport);
		radioPanelThree.add(rSniper);
		radioPanelThree.add(rController);
		radioPanelThree.add(rHealer);

		panCenter.add(radioPanelThree);

		// Fourth question
		JLabel questionFour = new JLabel("<html>[]Do you prefer taking fights at Long-range, Mid-range, or Short-range?");
		questionFour.setFont(new Font("Monospaced",Font.BOLD,18));
		questionFour.setForeground(new Color(0,0,0));
		questionFour.setAlignmentX(Component.CENTER_ALIGNMENT);
		panCenter.add(questionFour);

		JPanel radioPanelFour = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
		radioPanelFour.setBackground(new Color(255, 70, 85));
		
		ButtonGroup answerGroupFour = new ButtonGroup(); //creating button group for radio buttons on the fourth question
		JRadioButton rLongRange = new JRadioButton("Long-range");
		JRadioButton rMidRange = new JRadioButton("Mid-range");
		JRadioButton rShortRange = new JRadioButton("Short-range");

		answerGroupFour.add(rLongRange); //adding buttons to group and panel
		answerGroupFour.add(rMidRange);
		answerGroupFour.add(rShortRange);

		radioPanelFour.add(rLongRange);
		radioPanelFour.add(rMidRange);
		radioPanelFour.add(rShortRange);

		panCenter.add(radioPanelFour);

		// Fifth question
		JLabel questionFive = new JLabel("<html>[]What game mode do you prefer?");
		questionFive.setFont(new Font("Monospaced",Font.BOLD,18));
		questionFive.setForeground(new Color(0,0,0));
		questionFive.setAlignmentX(Component.CENTER_ALIGNMENT);
		panCenter.add(questionFive);

		JPanel radioPanelFive = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
		radioPanelFive.setBackground(new Color(255, 70, 85));
		
		ButtonGroup answerGroupFive = new ButtonGroup(); //creating button group for radio buttons on the fifth question
		JRadioButton rCompetitive = new JRadioButton("Competitive");
		JRadioButton rStrategic = new JRadioButton("Strategic");
		JRadioButton rLaidBack = new JRadioButton("Laid-back");
		JRadioButton rFastPaced = new JRadioButton("Fast-paced");
		JRadioButton rShortMatches = new JRadioButton("Short-matches");

		answerGroupFive.add(rCompetitive); //adding buttons to group and panel
		answerGroupFive.add(rStrategic);
		answerGroupFive.add(rLaidBack);
		answerGroupFive.add(rFastPaced);
		answerGroupFive.add(rShortMatches);

		radioPanelFive.add(rCompetitive);
		radioPanelFive.add(rStrategic);
		radioPanelFive.add(rLaidBack);
		radioPanelFive.add(rFastPaced);
		radioPanelFive.add(rShortMatches);

		panCenter.add(radioPanelFive);

		// Sixth question
		JLabel questionSix = new JLabel("<html>[]What weapon types do you prefer?");
		questionSix.setFont(new Font("Monospaced",Font.BOLD,18));
		questionSix.setForeground(new Color(0,0,0));
		questionSix.setAlignmentX(Component.CENTER_ALIGNMENT);
		panCenter.add(questionSix);

		JPanel radioPanelSix = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
		radioPanelSix.setBackground(new Color(255, 70, 85));
		
		ButtonGroup answerGroupSix = new ButtonGroup(); //creating button group for radio buttons on the sixth question
		JRadioButton rPistols = new JRadioButton("Pistols");
		JRadioButton rRifles = new JRadioButton("Rifles");
		JRadioButton rShotguns = new JRadioButton("Shotguns");
		JRadioButton rLMGs = new JRadioButton("LMG's");
		JRadioButton rSMGs = new JRadioButton("SMG's");
		JRadioButton rSnipers = new JRadioButton("Snipers");

		answerGroupSix.add(rPistols); //adding buttons to group and panel
		answerGroupSix.add(rRifles);
		answerGroupSix.add(rShotguns);
		answerGroupSix.add(rLMGs);
		answerGroupSix.add(rSMGs);
		answerGroupSix.add(rSnipers);

		radioPanelSix.add(rPistols);
		radioPanelSix.add(rRifles);
		radioPanelSix.add(rShotguns);
		radioPanelSix.add(rLMGs);
		radioPanelSix.add(rSMGs);
		radioPanelSix.add(rSnipers);

		panCenter.add(radioPanelSix);
		
		JButton btnContinue = new JButton("Save and continue!");
		btnContinue.setFont(new Font("Monospaced",Font.BOLD,18));
		btnContinue.setMaximumSize(new Dimension(300, 75)); //sets button size
		btnContinue.setAlignmentX(Component.CENTER_ALIGNMENT); //sets alignment to center
		
		
		//TWO ACTION LISTENERS ARE BEING CREATED BELOW, ONE SENDS THE USER TO THE NEXT PAGE
		//THE SECOND ACTION LISTENER IS SAVING THE CLICKED BUTTON VALUES
		//this will be done using the same button
		
		
		 btnContinue.addActionListener(new ActionListener() { //action listener is for checking if values are NULL for radio buttons
			 
			 public void actionPerformed(ActionEvent e) { 
	             
				 	//assigns personality to player object
			        if (rTricky.isSelected()) player.setPrefCharacterType("Tricky");
			        else if (rIntimidating.isSelected()) player.setPrefCharacterType("Intimidating");
			        else if (rWild.isSelected()) player.setPrefCharacterType("Wild");
			        else if (rEnergetic.isSelected()) player.setPrefCharacterType("Energetic");
			        else if (rCalm.isSelected()) player.setPrefCharacterType("Calm");
			        else if (rChaotic.isSelected()) player.setPrefCharacterType("Chaotic");
			        else if (rSneaky.isSelected()) player.setPrefCharacterType("Sneaky");
			        else if (rMysterious.isSelected()) player.setPrefCharacterType("Mysterious");
			        else if (rIndependent.isSelected()) player.setPrefCharacterType("Independent");
			        else if (rStylish.isSelected()) player.setPrefCharacterType("Stylish");
			        else if (rGenius.isSelected()) player.setPrefCharacterType("Genius");

			        //assigns map type  to player object
			        if (rCloseQuarter.isSelected()) player.setPrefMapType("Close-quarter");
			        else if (rOpenAngle.isSelected()) player.setPrefMapType("Open-angle");
			        else if (rVertical.isSelected()) player.setPrefMapType("Vertical-based");
			        else if (rHybrid.isSelected()) player.setPrefMapType("Hybrid-mix");

			        //assigns play style to player object
			        if (rAggressive.isSelected()) player.setPrefPlaystyle("Aggressive");
			        else if (rPassive.isSelected()) player.setPrefPlaystyle("Passive");
			        else if (rTactical.isSelected()) player.setPrefPlaystyle("Tactical");
			        else if (rLurker.isSelected()) player.setPrefPlaystyle("Lurker");
			        else if (rEntryFragger.isSelected()) player.setPrefPlaystyle("Entry Fragger");
			        else if (rSupport.isSelected()) player.setPrefPlaystyle("Support");
			        else if (rSniper.isSelected()) player.setPrefPlaystyle("Sniper");
			        else if (rController.isSelected()) player.setPrefPlaystyle("Controller");
			        else if (rHealer.isSelected()) player.setPrefPlaystyle("Healer");

			        //assigns range to player object
			        if (rLongRange.isSelected()) player.setPrefRange("Long-range");
			        else if (rMidRange.isSelected()) player.setPrefRange("Medium-range");
			        else if (rShortRange.isSelected()) player.setPrefRange("Short-range");

			        //assigns game mode to player object
			        if (rCompetitive.isSelected()) player.setPrefGameMode("Competitive");
			        else if (rStrategic.isSelected()) player.setPrefGameMode("Strategic");
			        else if (rLaidBack.isSelected()) player.setPrefGameMode("Laid-back");
			        else if (rFastPaced.isSelected()) player.setPrefGameMode("Fast-paced");
			        else if (rShortMatches.isSelected()) player.setPrefGameMode("Short-matches");

			        //assigns weapon to player object
			        if (rPistols.isSelected()) player.setPrefWeapon("Pistols");
			        else if (rRifles.isSelected()) player.setPrefWeapon("Rifles");
			        else if (rShotguns.isSelected()) player.setPrefWeapon("Shotguns");
			        else if (rLMGs.isSelected()) player.setPrefWeapon("LMG's");
			        else if (rSMGs.isSelected()) player.setPrefWeapon("SMG's");
			        else if (rSnipers.isSelected()) player.setPrefWeapon("Snipers");

			        //validate missing values and continue to the result page
			        if (player.getPrefCharacterType() == null || player.getPrefMapType() == null ||
			            player.getPrefPlaystyle() == null || player.getPrefRange() == null ||
			            player.getPrefGameMode() == null || player.getPrefWeapon() == null) {
			            JOptionPane.showMessageDialog(null, "Please answer all questions before continuing.");
			        } 
			        else {
			        	objMain.showResPage(); //calls the result page to pull it up
			        }
			    }
			});
		 
		panCenter.add(btnContinue); //add continue button
		add(panCenter, BorderLayout.CENTER);//add center
		
		
		setVisible(true);
		
		
	}

}
