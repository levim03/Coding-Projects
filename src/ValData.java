/*
 * Author: Levi McRea
 * Purpose: Valorant data holder
 * Last Version Date: 4/10/2025
 */

import java.util.*; //java imports

public class ValData {

	//remember getters, setters, and constructors 
	//private attributes/fields	
		private ArrayList<String> agents = new ArrayList<>(); //array list of agents (characters)
		private ArrayList<String> weapons = new ArrayList<>();  //array list of weapons
		private ArrayList<String> maps = new ArrayList<>(); //array list of maps
		private ArrayList<String> playStyle = new ArrayList<>(); //array list of play styles
		
		public enum GameMode {  //Enumeration to hold the game modes for the user
			
			UNRATED, COMPETITIVE, SPIKE_RUSH, ESCALATION, SWIFTPLAY  
			
		}	
		
		ValData(){
			
			//initializing agents to add
			agents.add("Brimstone");
			agents.add("Phoenix");
			agents.add("Sage");
			agents.add("Sova");
			agents.add("Viper");
			agents.add("Cypher");
			agents.add("Reyna");
			agents.add("Killjoy");
			agents.add("Breach");
			agents.add("Omen");
			agents.add("Jett");
			agents.add("Raze");
			agents.add("Skye");
			agents.add("Yoru");
			agents.add("Astra");
			agents.add("KAY/O");
			agents.add("Chamber");
			agents.add("Neon");
			agents.add("Fade");
			agents.add("Harbor");
			agents.add("Gekko");
			agents.add("Deadlock");
			agents.add("Iso");
			agents.add("Clove");
			agents.add("Vyse");
			agents.add("Tejo");
			agents.add("Waylay");

			//initializing weapons to add
			weapons.add("Classic");
			weapons.add("Shorty");
			weapons.add("Frenzy");
			weapons.add("Ghost");
			weapons.add("Sheriff");
			weapons.add("Stinger");
			weapons.add("Spectre");
			weapons.add("Bucky");
			weapons.add("Judge");
			weapons.add("Bulldog");
			weapons.add("Guardian");
			weapons.add("Phantom");
			weapons.add("Vandal");
			weapons.add("Marshal");
			weapons.add("Operator");
			weapons.add("Outlaw");
			weapons.add("Ares");
			weapons.add("Odin");
			

			//initializing maps to add
			maps.add("Bind");
			maps.add("Haven");
			maps.add("Split");
			maps.add("Ascent");
			maps.add("Icebox");
			maps.add("Breeze");
			maps.add("Fracture");
			maps.add("Pearl");
			maps.add("Lotus");
			maps.add("Sunset");
			maps.add("Abyss");
			
			//initializing play styles to add
			playStyle.add("Entry Fragger");
			playStyle.add("Support");
			playStyle.add("Controller");
			playStyle.add("Sniper");
			playStyle.add("Lurker");
			playStyle.add("Aggressive");
			playStyle.add("Passive");
			playStyle.add("Tactical");
			
		}
		ValData(ArrayList<String> agents, ArrayList<String> weapons, ArrayList<String> maps, ArrayList<String> playStyle, GameMode selectedGameMode){
			
		//ask caudill
		}
		
		public ArrayList<String> getAgents(){ //getter and setter for agents
			
			return agents;
		}
		
		public void setAgents(ArrayList<String> agents) {
			
			this.agents = agents;
		}
		
		public ArrayList<String> getWeapons() { //getter and setter for weapons
			
			return weapons;
		}
		
		public void setWeapons(ArrayList<String> weapons) {
			
			this.weapons = weapons;
			
		}
		
		public ArrayList<String> getMaps(){ //getter and setter for maps
			
			return maps;
			
		}
		
		public void setMaps(ArrayList<String> maps) {
			
			this.maps = maps;
			
		}
		
		public ArrayList<String> getPlayStyle(){ //getter and setter for play style
			
			return playStyle;
			
		}
		
		public void setPlayStyle(ArrayList<String> playStyle) {
			
			this.playStyle = playStyle;
			
		}
		
		@Override
		public String toString() {
	
		//print out game modes from enum
		return "HERE IS ALL THE DATA REFERENCED BY THE PROGRAM: \n" 
				+ "AGENTS: "  + agents + "\n"
				+ "WEAPONS: " + weapons + "\n"
				+ "MAPS: " + maps + "\n"
				+ "PLAY STYLES: " + playStyle + "\n\n"
				;
		
	}
		//insertion sort algorithm (does it alphabetically)
		public static void insertionSortAlph(ArrayList<String> agnt) {
			
		    for (int i = 1; i < agnt.size(); i++) {
		        String keyVal = agnt.get(i);  //declare key index value
		        int j = i - 1;

		        //compare using .compareTo() for alphabetical order sorting
		        while (j >= 0 && agnt.get(j).compareToIgnoreCase(keyVal) > 0) {
		        	agnt.set(j + 1, agnt.get(j));
		            j = j - 1;
		        }
		        agnt.set(j + 1, keyVal);
		    }
		    
		}
		
		   
	/*	public static int binarySearchRecursive() {

		        if (maximum >= minimum) {
		            int mean = minimum + (maximum - minimum) / 2;

		            if ((mean) == chosenNum) {
		                System.out.println("\nThe model number you're looking for has been found on the shelf!");
		                System.out.println("Just FYI, it took " + count + " searches to find your set on the shelf");
		                System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

		                for (int i = 0; i < .size(); i++) {
		                    LegoSet chooseLego = LEGOS.get(i);  // Object that helps identify what index to print the object at
		                    SpecialtySet special = specialLEGOS.get(i); // Same meaning as above

		                    if (chosenNum == chooseLego.getModelNumber()) {
		                        // This will compare the model number to the model number object, if true,
		                        // it will push that entire index of the list to the shoppingCart class to populate the 'cart'
		                        inputLEGOS.addRegLegosToCart(LEGOS.get(i));
		                        inputLEGOS.toString();  // Printing the 'shopping cart' items to the user every time something is added
		                        break;
		                    } else if (chosenNum == 8009) {
		                        // This does the same thing as above but for the specialLEGOS list
		                        inputLEGOS.addSpecLegosToCart(specialLEGOS.get(2));
		                        inputLEGOS.toString();
		                        break;
		                    }
		                }

		                return mean;  
		            }

		            if (setNumbers.get(mean) > chosenNum) {
		                return binarySearchRecursive(setNumbers, chosenNum, minimum, mean - 1, count + 1, LEGOS, inputLEGOS, specialLEGOS);
		            }

		            return binarySearchRecursive(setNumbers, chosenNum, mean + 1, maximum, count + 1, LEGOS, inputLEGOS, specialLEGOS);
		        }

		        System.out.println("Your model number was not found. The program looped " + count + " times with no avail :(");
		        return -1;
		    }
		}
  */

}
