/*
 * Author: Levi McRea
 * Purpose: User recommendation calculator class
 * Last Version Date: 4/10/2025
 */
 
import java.util.*; //java imports

import javax.swing.JRadioButton;

public class Recommendation extends ValData { //inheritance relationship

	Player user;
	String recAgent;
	String recMap;
	String recGameMode;
	String recWeapon;
	
	 
	Recommendation(){ //default constructor
		
		recAgent = null;
		recMap = null;
		recGameMode = null;
		recWeapon = null;
	}
	//arguments constructor
	Recommendation(Player player){
		
		user = player;  //using the original object passed to reccomendation to keep the same values used for calculations
	}
	
	public String getRecAgent() { //getter and setter for recommended agent
		
		return recAgent;
	}
	public void setRecAgent(String rAgent) {
		
		recAgent = rAgent;
	}
	
	public String getRecMapType() {//getter and setter for recommended map
	    return recMap;
	}
	public void setRecMapType(String rMapType) {
	    recMap = rMapType;
	}

	public String getRecGameMode() {//getter and setter for recommended gamemode
	    return recGameMode;
	}
	public void setRecGameMode(String rGameMode) {
	    recGameMode = rGameMode;
	}

	public String getRecWeapon() {//getter and setter for recommended weapon
	    return recWeapon;
	}
	public void setRecWeapon(String rWeapon) {
	    recWeapon = rWeapon;
	}
	
	//methods to take all information given and start calculations on recommendations
	
	public void calculateCharacter() { //will calculate the users agent
		
		String givenCharPersonality = user.getPrefCharacterType(); //accessing the methods that contain information regarding character
		String givenPlaystyle = user.getPrefPlaystyle();
		
		//TRICKY BASED PERSONALITY
		if (givenCharPersonality.equals("Tricky") && givenPlaystyle.equals("Aggressive")) {
		    setRecAgent("Yoru");
		}

		else if (givenCharPersonality.equals("Tricky") && givenPlaystyle.equals("Passive")) {
		    setRecAgent("Cypher");
		}

		else if (givenCharPersonality.equals("Tricky") && givenPlaystyle.equals("Tactical")) {
		    setRecAgent("Killjoy");
		}

		else if (givenCharPersonality.equals("Tricky") && givenPlaystyle.equals("Lurker")) {
		    setRecAgent("Omen");
		}

		else if (givenCharPersonality.equals("Tricky") && givenPlaystyle.equals("Entry Fragger")) {
		    setRecAgent("Jett");
		}

		else if (givenCharPersonality.equals("Tricky") && givenPlaystyle.equals("Support")) {
		    setRecAgent("Gekko");
		}

		else if (givenCharPersonality.equals("Tricky") && givenPlaystyle.equals("Sniper")) {
		    setRecAgent("Chamber");
		}

		else if (givenCharPersonality.equals("Tricky") && givenPlaystyle.equals("Controller")) {
		    setRecAgent("Viper");
		}

		else if (givenCharPersonality.equals("Tricky") && givenPlaystyle.equals("Healer")) {
		    setRecAgent("Skye");
		}


		// INTIMIDATING PERSONALITY ANSWER BASED
		if (givenCharPersonality.equals("Intimidating") && givenPlaystyle.equals("Aggressive")) {
		    setRecAgent("Reyna");
		}

		else if (givenCharPersonality.equals("Intimidating") && givenPlaystyle.equals("Passive")) {
		    setRecAgent("Deadlock");
		}

		else if (givenCharPersonality.equals("Intimidating") && givenPlaystyle.equals("Tactical")) {
		    setRecAgent("Brimstone");
		}

		else if (givenCharPersonality.equals("Intimidating") && givenPlaystyle.equals("Lurker")) {
		    setRecAgent("Omen");
		}

		else if (givenCharPersonality.equals("Intimidating") && givenPlaystyle.equals("Entry Fragger")) {
		    setRecAgent("Phoenix");
		}

		else if (givenCharPersonality.equals("Intimidating") && givenPlaystyle.equals("Support")) {
		    setRecAgent("Astra");
		}

		else if (givenCharPersonality.equals("Intimidating") && givenPlaystyle.equals("Sniper")) {
		    setRecAgent("Jett");
		}

		else if (givenCharPersonality.equals("Intimidating") && givenPlaystyle.equals("Controller")) {
		    setRecAgent("Viper");
		}

		else if (givenCharPersonality.equals("Intimidating") && givenPlaystyle.equals("Healer")) {
		    setRecAgent("Sage");
		}


		// WILD PERSONALITY ANSWER BASED
		if (givenCharPersonality.equals("Wild") && givenPlaystyle.equals("Aggressive")) {
		    setRecAgent("Reyna");
		}

		else if (givenCharPersonality.equals("Wild") && givenPlaystyle.equals("Passive")) {
		    setRecAgent("Brimstone");
		}

		else if (givenCharPersonality.equals("Wild") && givenPlaystyle.equals("Tactical")) {
		    setRecAgent("Killjoy");
		}

		else if (givenCharPersonality.equals("Wild") && givenPlaystyle.equals("Lurker")) {
		    setRecAgent("Omen");
		}

		else if (givenCharPersonality.equals("Wild") && givenPlaystyle.equals("Entry Fragger")) {
		    setRecAgent("Jett");
		}

		else if (givenCharPersonality.equals("Wild") && givenPlaystyle.equals("Support")) {
		    setRecAgent("Skye");
		}

		else if (givenCharPersonality.equals("Wild") && givenPlaystyle.equals("Sniper")) {
		    setRecAgent("Chamber");
		}

		else if (givenCharPersonality.equals("Wild") && givenPlaystyle.equals("Controller")) {
		    setRecAgent("Viper");
		}

		else if (givenCharPersonality.equals("Wild") && givenPlaystyle.equals("Healer")) {
		    setRecAgent("Sage");
		}


		// ENERGETIC PERSONALITY ANSWER BASED
		if (givenCharPersonality.equals("Energetic") && givenPlaystyle.equals("Aggressive")) {
		    setRecAgent("Phoenix");
		}

		else if (givenCharPersonality.equals("Energetic") && givenPlaystyle.equals("Passive")) {
		    setRecAgent("Astra");
		}

		else if (givenCharPersonality.equals("Energetic") && givenPlaystyle.equals("Tactical")) {
		    setRecAgent("Brimstone");
		}

		else if (givenCharPersonality.equals("Energetic") && givenPlaystyle.equals("Lurker")) {
		    setRecAgent("Omen");
		}

		else if (givenCharPersonality.equals("Energetic") && givenPlaystyle.equals("Entry Fragger")) {
		    setRecAgent("Jett");
		}

		else if (givenCharPersonality.equals("Energetic") && givenPlaystyle.equals("Support")) {
		    setRecAgent("Skye");
		}

		else if (givenCharPersonality.equals("Energetic") && givenPlaystyle.equals("Sniper")) {
		    setRecAgent("Chamber");
		}

		else if (givenCharPersonality.equals("Energetic") && givenPlaystyle.equals("Controller")) {
		    setRecAgent("Viper");
		}

		else if (givenCharPersonality.equals("Energetic") && givenPlaystyle.equals("Healer")) {
		    setRecAgent("Sage");
		}


		// CALM PERSONALITY ANSWER BASED
		if (givenCharPersonality.equals("Calm") && givenPlaystyle.equals("Aggressive")) {
		    setRecAgent("Phoenix");
		}

		else if (givenCharPersonality.equals("Calm") && givenPlaystyle.equals("Passive")) {
		    setRecAgent("Cypher");
		}

		else if (givenCharPersonality.equals("Calm") && givenPlaystyle.equals("Tactical")) {
		    setRecAgent("Brimstone");
		}

		else if (givenCharPersonality.equals("Calm") && givenPlaystyle.equals("Lurker")) {
		    setRecAgent("Omen");
		}

		else if (givenCharPersonality.equals("Calm") && givenPlaystyle.equals("Entry Fragger")) {
		    setRecAgent("Jett");
		}

		else if (givenCharPersonality.equals("Calm") && givenPlaystyle.equals("Support")) {
		    setRecAgent("Gekko");
		}

		else if (givenCharPersonality.equals("Calm") && givenPlaystyle.equals("Sniper")) {
		    setRecAgent("Chamber");
		}

		else if (givenCharPersonality.equals("Calm") && givenPlaystyle.equals("Controller")) {
		    setRecAgent("Viper");
		}

		else if (givenCharPersonality.equals("Calm") && givenPlaystyle.equals("Healer")) {
		    setRecAgent("Sage");
		}


		// CHAOTIC PERSONALITY ANSWER BASED
		if (givenCharPersonality.equals("Chaotic") && givenPlaystyle.equals("Aggressive")) {
		    setRecAgent("Reyna");
		}

		else if (givenCharPersonality.equals("Chaotic") && givenPlaystyle.equals("Passive")) {
		    setRecAgent("Omen");
		}

		else if (givenCharPersonality.equals("Chaotic") && givenPlaystyle.equals("Tactical")) {
		    setRecAgent("Killjoy");
		}

		else if (givenCharPersonality.equals("Chaotic") && givenPlaystyle.equals("Lurker")) {
		    setRecAgent("Omen");
		}

		else if (givenCharPersonality.equals("Chaotic") && givenPlaystyle.equals("Entry Fragger")) {
		    setRecAgent("Jett");
		}

		else if (givenCharPersonality.equals("Chaotic") && givenPlaystyle.equals("Support")) {
		    setRecAgent("Astra");
		}

		else if (givenCharPersonality.equals("Chaotic") && givenPlaystyle.equals("Sniper")) {
		    setRecAgent("Chamber");
		}

		else if (givenCharPersonality.equals("Chaotic") && givenPlaystyle.equals("Controller")) {
		    setRecAgent("Viper");
		}

		else if (givenCharPersonality.equals("Chaotic") && givenPlaystyle.equals("Healer")) {
		    setRecAgent("Skye");
		}


		// SNEAKY PERSONALITY ANSWER BASED
		if (givenCharPersonality.equals("Sneaky") && givenPlaystyle.equals("Aggressive")) {
		    setRecAgent("Sova");
		}

		else if (givenCharPersonality.equals("Sneaky") && givenPlaystyle.equals("Passive")) {
		    setRecAgent("Cypher");
		}

		else if (givenCharPersonality.equals("Sneaky") && givenPlaystyle.equals("Tactical")) {
		    setRecAgent("Killjoy");
		}

		else if (givenCharPersonality.equals("Sneaky") && givenPlaystyle.equals("Lurker")) {
		    setRecAgent("Omen");
		}

		else if (givenCharPersonality.equals("Sneaky") && givenPlaystyle.equals("Entry Fragger")) {
		    setRecAgent("Raze");
		}

		else if (givenCharPersonality.equals("Sneaky") && givenPlaystyle.equals("Support")) {
		    setRecAgent("Sova");
		}

		else if (givenCharPersonality.equals("Sneaky") && givenPlaystyle.equals("Sniper")) {
		    setRecAgent("Chamber");
		}

		else if (givenCharPersonality.equals("Sneaky") && givenPlaystyle.equals("Controller")) {
		    setRecAgent("Viper");
		}

		else if (givenCharPersonality.equals("Sneaky") && givenPlaystyle.equals("Healer")) {
		    setRecAgent("Sage");
		}


		// MYSTERIOUS PERSONALITY ANSWER BASED
		if (givenCharPersonality.equals("Mysterious") && givenPlaystyle.equals("Aggressive")) {
		    setRecAgent("Yoru");
		}

		else if (givenCharPersonality.equals("Mysterious") && givenPlaystyle.equals("Passive")) {
		    setRecAgent("Cypher");
		}

		else if (givenCharPersonality.equals("Mysterious") && givenPlaystyle.equals("Tactical")) {
		    setRecAgent("Killjoy");
		}

		else if (givenCharPersonality.equals("Mysterious") && givenPlaystyle.equals("Lurker")) {
		    setRecAgent("Omen");
		}

		else if (givenCharPersonality.equals("Mysterious") && givenPlaystyle.equals("Entry Fragger")) {
		    setRecAgent("Jett");
		}

		else if (givenCharPersonality.equals("Mysterious") && givenPlaystyle.equals("Support")) {
		    setRecAgent("Sova");
		}

		else if (givenCharPersonality.equals("Mysterious") && givenPlaystyle.equals("Sniper")) {
		    setRecAgent("Chamber");
		}

		else if (givenCharPersonality.equals("Mysterious") && givenPlaystyle.equals("Controller")) {
		    setRecAgent("Viper");
		}

		else if (givenCharPersonality.equals("Mysterious") && givenPlaystyle.equals("Healer")) {
		    setRecAgent("Sage");
		}


		// INDEPENDENT PERSONALITY ANSWER BASED
		if (givenCharPersonality.equals("Independent") && givenPlaystyle.equals("Aggressive")) {
		    setRecAgent("Reyna");
		}

		else if (givenCharPersonality.equals("Independent") && givenPlaystyle.equals("Passive")) {
		    setRecAgent("Cypher");
		}

		else if (givenCharPersonality.equals("Independent") && givenPlaystyle.equals("Tactical")) {
		    setRecAgent("Brimstone");
		}

		else if (givenCharPersonality.equals("Independent") && givenPlaystyle.equals("Lurker")) {
		    setRecAgent("Omen");
		}

		else if (givenCharPersonality.equals("Independent") && givenPlaystyle.equals("Entry Fragger")) {
		    setRecAgent("Jett");
		}

		else if (givenCharPersonality.equals("Independent") && givenPlaystyle.equals("Support")) {
		    setRecAgent("Gekko");
		}

		else if (givenCharPersonality.equals("Independent") && givenPlaystyle.equals("Sniper")) {
		    setRecAgent("Chamber");
		}

		else if (givenCharPersonality.equals("Independent") && givenPlaystyle.equals("Controller")) {
		    setRecAgent("Viper");
		}

		else if (givenCharPersonality.equals("Independent") && givenPlaystyle.equals("Healer")) {
		    setRecAgent("Sage");
		}


		// STYLISH PERSONALITY ANSWER BASED
		if (givenCharPersonality.equals("Stylish") && givenPlaystyle.equals("Aggressive")) {
		    setRecAgent("Reyna");
		}

		else if (givenCharPersonality.equals("Stylish") && givenPlaystyle.equals("Passive")) {
		    setRecAgent("Cypher");
		}

		else if (givenCharPersonality.equals("Stylish") && givenPlaystyle.equals("Tactical")) {
		    setRecAgent("Brimstone");
		}

		else if (givenCharPersonality.equals("Stylish") && givenPlaystyle.equals("Lurker")) {
		    setRecAgent("Omen");
		}

		else if (givenCharPersonality.equals("Stylish") && givenPlaystyle.equals("Entry Fragger")) {
		    setRecAgent("Jett");
		}

		else if (givenCharPersonality.equals("Stylish") && givenPlaystyle.equals("Support")) {
		    setRecAgent("Gekko");
		}

		else if (givenCharPersonality.equals("Stylish") && givenPlaystyle.equals("Sniper")) {
		    setRecAgent("Chamber");
		}

		else if (givenCharPersonality.equals("Stylish") && givenPlaystyle.equals("Controller")) {
		    setRecAgent("Viper");
		}

		else if (givenCharPersonality.equals("Stylish") && givenPlaystyle.equals("Healer")) {
		    setRecAgent("Skye");
		}


		// GENIUS PERSONALITY ANSWER BASED
		if (givenCharPersonality.equals("Genius") && givenPlaystyle.equals("Aggressive")) {
		    setRecAgent("Raze");
		}

		else if (givenCharPersonality.equals("Genius") && givenPlaystyle.equals("Passive")) {
		    setRecAgent("Brimstone");
		}

		else if (givenCharPersonality.equals("Genius") && givenPlaystyle.equals("Tactical")) {
		    setRecAgent("Killjoy");
		}

		else if (givenCharPersonality.equals("Genius") && givenPlaystyle.equals("Lurker")) {
		    setRecAgent("Omen");
		}

		else if (givenCharPersonality.equals("Genius") && givenPlaystyle.equals("Entry Fragger")) {
		    setRecAgent("Jett");
		}

		else if (givenCharPersonality.equals("Genius") && givenPlaystyle.equals("Support")) {
		    setRecAgent("Sova");
		}

		else if (givenCharPersonality.equals("Genius") && givenPlaystyle.equals("Sniper")) {
		    setRecAgent("Chamber");
		}

		else if (givenCharPersonality.equals("Genius") && givenPlaystyle.equals("Controller")) {
		    setRecAgent("Viper");
		}

		else if (givenCharPersonality.equals("Genius") && givenPlaystyle.equals("Healer")) {
		    setRecAgent("Sage");
		}

	}
	
	public void calculateMap() { //will calculate the users map
		
		String givenMapType = user.getPrefMapType(); //accessing the methods that contain information regarding map
		String givenRange = user.getPrefRange();
		
		//CLOSE-QUARTER BASED
		if(givenMapType.equals("Close-quarter")&& givenRange.equals("Long-range")) {
			
			setRecMapType("Lotus");
			
		}
		if(givenMapType.equals("Close-quarter")&& givenRange.equals("Medium-range")) {
			
			setRecMapType("Split");
			
		}
		if(givenMapType.equals("Close-quarter")&& givenRange.equals("Short-range")) {
			
			setRecMapType("Bind");
			
		}
		
		//OPEN-ANGLE BASED
		
		if(givenMapType.equals("Open-angle")&& givenRange.equals("Long-range")) {
			
			setRecMapType("Ascent");
			
		}
		if(givenMapType.equals("Open-angle")&& givenRange.equals("Medium-range")) {
		
			setRecMapType("Fracture");
		
		}
	
		if(givenMapType.equals("Open-angle")&& givenRange.equals("Short-range")) {
		
			setRecMapType("Haven");
		
		//VERTICAL-BASED
			
		}
		if(givenMapType.equals("Vertical-based")&& givenRange.equals("Long-range")) {
			
			setRecMapType("Breeze");
		
		}
		if(givenMapType.equals("Vertical-based")&& givenRange.equals("Medium-range")) {
			
			setRecMapType("Icebox");
		
		}
		if(givenMapType.equals("Vertical-based")&& givenRange.equals("Short-range")) {
			
			setRecMapType("Pearl");
		
		}
		
		//HYBRID-MIX BASED
		
		if(givenMapType.equals("Hybrid-mix")&& givenRange.equals("Long-range")) {
			
			setRecMapType("Abyss");
		
		}
		if(givenMapType.equals("Hybrid-mix")&& givenRange.equals("Medium-range")) {
			
			setRecMapType("Sunset");
		
		}
		if(givenMapType.equals("Hybrid-mix")&& givenRange.equals("Short-range")) {
			
			setRecMapType("Split");
		
		}
		
	}
	
	public void calculateGamemode() {  //will calculate the users gamemode
		
		String givenGamemodeType = user.getPrefGameMode(); //accessing the methods that contain information regarding gamemode
		//"Competitive", "Strategic", "Laid-back", "Fast-Paced", "Short-Matches"
		
		if(givenGamemodeType.equals("Competitive")) {
			
			setRecGameMode("Ranked");
		
		}
		
		if(givenGamemodeType.equals("Strategic")) {
			
			setRecGameMode("Escalation");
		
		}
		
		if(givenGamemodeType.equals("Laid-back")) {
			
			setRecGameMode("Unrated");
		
		}
		
		if(givenGamemodeType.equals("Fast-paced")) {
			
			setRecGameMode("Spike Rush");
		
		}

		if(givenGamemodeType.equals("Short-matches")) {
	
			setRecGameMode("Swiftplay");

		}
		
	}
	
	public void calculateWeapon() { //will calculate the users weapon
		
		String givenWeaponType = user.getPrefWeapon(); //accessing the methods that contain information regarding weapon
		String givenRange = user.getPrefRange();
		
		
		if(givenWeaponType.equals("Pistols")&& givenRange.equals("Long-range")) {
			
			setRecWeapon("Sheriff");
		
		}
		if(givenWeaponType.equals("Pistols")&& givenRange.equals("Medium-range")) {
			
			setRecWeapon("Ghost");
		
		}
		if(givenWeaponType.equals("Pistols")&& givenRange.equals("Short-range")) {
			
			setRecWeapon("Classic");
		
		}
		if(givenWeaponType.equals("Rifles")&& givenRange.equals("Long-range")) {
			
			setRecWeapon("Vandal");
		
		}
		if(givenWeaponType.equals("Rifles")&& givenRange.equals("Medium-range")) {
			
			setRecWeapon("Phantom");
		
		}
		if(givenWeaponType.equals("Rifles")&& givenRange.equals("Short-range")) {
			
			setRecWeapon("Bulldog");
		
		}
		if(givenWeaponType.equals("Shotguns")&& givenRange.equals("Long-range")) {
			
			setRecWeapon("Judge");
		
		}
		if(givenWeaponType.equals("Shotguns")&& givenRange.equals("Medium-range")) {
			
			setRecWeapon("Bucky");
		
		}
		if(givenWeaponType.equals("Shotguns")&& givenRange.equals("Short-range")) {
			
			setRecWeapon("Shorty");
		
		}
		if(givenWeaponType.equals("LMG's")&& givenRange.equals("Long-range")) {
			
			setRecWeapon("Odin");
		
		}
		if(givenWeaponType.equals("LMG's")&& givenRange.equals("Medium-range")) {
			
			setRecWeapon("Odin");
		
		}
		if(givenWeaponType.equals("LMG's")&& givenRange.equals("Short-range")) {
			
			setRecWeapon("Ares");
		
		}
		if(givenWeaponType.equals("SMG's")&& givenRange.equals("Long-range")) {
			
			setRecWeapon("Spectre");
		
		}
		if(givenWeaponType.equals("SMG's")&& givenRange.equals("Medium-range")) {
			
			setRecWeapon("Spectre");
		
		}
		if(givenWeaponType.equals("SMG's")&& givenRange.equals("Short-range")) {
			
			setRecWeapon("Stinger");
		
		}
		if(givenWeaponType.equals("Snipers")&& givenRange.equals("Long-range")) {
			
			setRecWeapon("Operator");
		
		}
		if(givenWeaponType.equals("Snipers")&& givenRange.equals("Medium-range")) {
			
			setRecWeapon("Outlaw");
		
		}
		if(givenWeaponType.equals("Snipers")&& givenRange.equals("Short-range")) {
			
			setRecWeapon("Marshall");
		
		}
		
	}
	
	@Override
	public String toString() {
		
		return "Recommended beginning agent: " + getRecAgent() + "\n"
				+ "Recommended beginning map: " + getRecMapType() + "\n"
				+ "Recommended beginning gamemode: " + getRecGameMode() + "\n"
				+ "Recommended beginning weapon: " + getRecWeapon() + "\n";
	}
	
}


