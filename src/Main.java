/*
 * Author: Levi McRea
 * Purpose: Final project for csc 241
 * Last Version Date: 4/10/2025
 * Project Functionality: The program helps new Valorant players get started by gathering their preferences 
 * on play style, weapons, and game modes, then recommending the best agent, gun, map, and mode to ease them into the game.
 * 
 */
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Scanner scnr = new Scanner(System.in);  //making scanner object
		Player player = new Player(); //making a player and calling default constructor
		ValData info = new ValData(); //making object for data holding class
		Recommendation rec = new Recommendation(player); //making a recommendation object
		
		//user is welcomed and informed about the program
		System.out.println("Welcome to ValVanguard!\n<>This is the all inclusive program that gives the best suggestions to new Valorant players");
		System.out.println("<>You will be asked a series of questions regarding various important topics in Valorant");
		System.out.println("<>After the answers have been logged, you will recieve the best suggestions to start playing Valorant!\n");
		
		String yesno = null;
		System.out.print("Would you like to view all referenced Valorant data? (Y/y to view, any other input to continue program): "); //option to view all program data
		yesno = scnr.nextLine(); //receive input
		if(yesno.equals("Y") || (yesno.equals("y"))) { //only checks for y or Y, no data validation is needed since its just printing info
														//program will continue if anything else is entered rather than y or Y
		System.out.print(info.toString());
		}
		
		question(scnr,player); //call method that gets all the user information (sends scanner and player object)
		
		
		System.out.println("\nThanks for answering the questions " + player.getName() + ", your recommendations to get started playing Valorant are as follows,");
		
		rec.calculateCharacter();
		rec.calculateGamemode();
		rec.calculateMap();
		rec.calculateWeapon();
		
	    System.out.print(rec.toString());
	    System.out.print("\nPlease rate ValVanguard and recommend us!");
	}
	
	
	//method contains all the question the player will be asked, this is in order to have the main less cluttered 
	public static void question (Scanner scnr, Player player) throws Exception {
		
		System.out.print("<>Please enter your name: "); //user is asked for name
		player.setName(scnr.nextLine());
		System.out.println("<>Howdy there " + player.getName() + "!\n"); //testing output

	    //character type preference is set while the input is being validated by an outside function (question prompt is sent as well)
	    player.setPrefCharacterType(validateInput("<>What personality do you prefer your agent to be?\nOPTIONS: Tricky, Intimidating, Wild, Energetic, Calm, Chaotic, Sneaky, Mysterious, Independent, Stylish, Genius\nAnswer: "
	    		,scnr, Arrays.asList("Tricky", "Intimidating", "Wild", "Energetic", "Calm", "Chaotic", "Sneaky", "Mysterious", "Independent", "Stylish", "Genius")));
	    //NOTE: The Arrays.asList ^^ helps send a list that checks user input for valid options
	    
	    //map types preference is set while the input is being validated by an outside function (question prompt is sent as well)
	    player.setPrefMapType(validateInput("<>What map types do you prefer?\nOPTIONS: Close-quarter, Open-angle, Vertical-based, Hybrid-mix\nAnswer: "
	    		,scnr, Arrays.asList("Close-quarter", "Open-angle", "Vertical-based", "Hybrid-mix")));
	    
	    //playstyle preference is set while the input is being validated by an outside function (question prompt is sent as well)
	    player.setPrefPlaystyle(validateInput("<>What is your preferred playstyle?\nOPTIONS: Aggressive, Passive, Tactical, Lurker, Entry Fragger, Support, Sniper, Controller, Healer\nAnswer: "
	    		,scnr, Arrays.asList("Aggressive", "Passive", "Tactical", "Lurker", "Entry Fragger", "Support", "Sniper", "Controller","Healer")));

	    //range preference is set while the input is being validated by an outside function (question prompt is sent as well)
	    player.setPrefRange(validateInput("<>Do you prefer taking fights at Long-range, Mid-range, or Short-range?\nAnswer: "
	    		,scnr, Arrays.asList("Long-range", "Mid-range", "Short-range")));

	    //gamemode preference is set while the input is being validated by an outside function (question prompt is sent as well)
	    player.setPrefGameMode(validateInput("<>What game mode do you prefer?\nOPTIONS: Competitive, Strategic, Laid-back, Fast-Paced, Short-Matches\nAnswer: "
	    		,scnr, Arrays.asList("Competitive", "Strategic", "Laid-back", "Fast-paced", "Short-matches")));

	    //weapon preference is set while the input is being validated by an outside function (question prompt is sent as well)
	    player.setPrefWeapon(validateInput("<>What weapon types do you prefer?\nOPTIONS: Pistols, Rifles, Shotguns, LMG's, SMG's, Snipers\nAnswer: "
	    		,scnr, Arrays.asList("Pistols", "Rifles", "Shotguns", "LMG's", "SMG's", "Snipers")));
		    
	}
	
	// Validates a string input (Ensures it’s not empty)
	public static String validateInput(String prompt, Scanner scnr, List <String> validStrings) throws Exception {
		
		String input = null;
		boolean isValid = false;
		
		while (!isValid) {  //keeps looping until boolean is true
			try {
				System.out.print(prompt);
			
				input = scnr.nextLine(); //get input from user
				//scnr.nextLine();
				
				if (input.isEmpty()) { //throws if empty input
		            throw new Exception ("Input cannot be empty! Please enter a valid response.");
		            
		        }
				if (input.matches(".*\\d.*")) {   //throws if number or related input
	                throw new IllegalArgumentException();
				
				}
				if (!validStrings.contains(input)) {  //makes sure the input is actually a valid one (that its one of the options given)
	                throw new Exception("Invalid option. Please choose from the given list.\n");
	            }
				isValid = true;
			}
			catch (IllegalArgumentException e) { //catching thrown exception
				
	            System.out.print("\nERROR: Input cannot contain numbers! Question will be asked again.\n");
	            
	            
			}
			catch(Exception ex) { //catching thrown exception
				
				System.out.print("\nERROR: " + ex.getMessage());
				
			}
	
		}
		return input;  //return original input to main
	}

}
