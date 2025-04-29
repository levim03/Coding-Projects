	/*
	 * Author: Levi McRea 
	 * Purpose: Final project for csc 241
	 * Last Version Date: 4/20/2025
	 * Project Functionality: The program helps new Valorant players get started by gathering their preferences 
	 * on play style, weapons, and game modes, then recommending the best agent, gun, map, and mode to ease them into the game.
	 * 
	 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame{
	
	private Player player = new Player(); //player object to store values
	

	Main(){
		
		 //JFrame window = new JFrame("ValVanguard"); //creating JFrame
		 setTitle("ValVanguard"); //setting name of window
	     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     setSize(800,800); //setting window size
	     setLocationRelativeTo(null); //set window to center screen
	     setLayout(new BorderLayout());
	     
	     showWelcomePage(); //calls the welcome page to launch
	     
	     setVisible(true); //sets window to visible
	}
	
	
	//methods show and add the other classes objects 
	 public void showWelcomePage() {
		 
	        setContentPane(new WelcomeGUI(this)); //pass Main to WelcomeGUI 
	        revalidate(); //refreshes the layout of the container so that a new one being loaded appears correctly
	        				//noticeable when trying to 
	    }

	    public void showQuePage() {
	    	
	        setContentPane(new QuestionGUI(this, player)); //pass the Main and player object to question GUI
	        revalidate();
	    }

	    public void showResPage() {
	    	
	        setContentPane(new ResultGUI(this, player));  //pass the Main and player object to Result GUI
	        revalidate();
	    }
	    
	
    public static void main(String[] args) throws Exception {
    	
      new Main(); //runs the main constructor to start GUI
      
      
    }
}