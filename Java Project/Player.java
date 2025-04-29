/*
 * Author: Levi McRea  
 * Purpose: User class (player)
 * Last Version Date: 4/10/2025
 */

import java.util.*; //java imports

public class Player { //for aggregate relationship, a player HAS A recommendation

	//remember getters, setters, and constructors 
	
	private String userName;
	private String preferredCharacterType; //character personality they like (e.g., aggressive, strategic, stealthy)
	private String preferredMapType;       //close-quarters maps (many corners) or open maps (long angles)
	private String preferredPlaystyle;     //aggressive, passive, tactical, lurker, etc.
	private String preferredGameMode;      //competitive, strategic, or casual
	private String preferredRange;         //long range, mid range, or short range preference for the weapon
	private String preferredWeapon;   //these deal with questions regarding the weapon of choice for user
	
	
	//default constructor
	Player(){
		
	userName = null;
	preferredCharacterType = null;
	preferredRange = null;
	preferredMapType = null;
	preferredPlaystyle = null;
	preferredGameMode = null;
	preferredWeapon = null;
		
	}
	//arguments constructor
	Player(String Name, String prefCharacterType, String prefPlaystyle, String prefRange, String prefMapType, String prefGameMode, String prefWeapon) {
		userName = Name;
		preferredCharacterType = prefCharacterType;
		preferredPlaystyle = prefPlaystyle;
		preferredRange = prefRange;
		preferredMapType = prefMapType;
		preferredGameMode = prefGameMode;
		preferredWeapon = prefWeapon;
		
	}
	
	
    public String getName() { //getter and setter for Name
    	
    	return userName; 
    	
    	}
    public void setName(String Uname){ 
    	
    	userName = Uname; 
    	}
    
    
    public String getPrefCharacterType() { //getter and setter for character type
    	
    	return preferredCharacterType; 
    	}
    public void setPrefCharacterType(String prefCharacterType) {
    	
    	preferredCharacterType = prefCharacterType; 
    	
    	}

    public String getPrefPlaystyle() { //getter and setter for play style
    	
    	return preferredPlaystyle;
    	
    	}
    public void setPrefPlaystyle(String prefPlaystyle) { 
    	
    	preferredPlaystyle = prefPlaystyle; 
    	
    	}

    public String getPrefRange() {  //getter and setter for range
    	
    	return preferredRange; 
    	
    	}
    public void setPrefRange(String prefRange) { 
    	
    	preferredRange = prefRange; 
    	
    	}

    public String getPrefMapType() {  //getter and setter for map type
    	
    	return preferredMapType; 
    	
    	}
    public void setPrefMapType(String prefMapType) { 
    	
    	preferredMapType = prefMapType; 
    	
    	}

    public String getPrefGameMode() { //getter and setter for gamemode
    	
    	return preferredGameMode;
    	
    	}
    public void setPrefGameMode(String prefGameMode) { 
    	
    	preferredGameMode = prefGameMode; 
    	
    	}

    public String getPrefWeapon() { //getter and setter for weapon type 
    	
    	return preferredWeapon; 
    	
    	}
    public void setPrefWeapon(String prefWeapon) { 
    	
    	preferredWeapon = prefWeapon; 
    	
    	}
	
    @Override
	public String toString() {  //to string method (to just test outputs)
		
		return "Player name = " + userName + '\n' +
                "prefCharacterType=" + preferredCharacterType + '\n' +
                "prefPlaystyle=" + preferredPlaystyle + '\n' +
                "prefRange=" + preferredRange + '\n' +
                "prefMapType=" + preferredMapType + '\n' +
                "prefGameMode=" + preferredGameMode + '\n' +
                "prefWeapon=" + preferredWeapon + '\n';
    	}

}
