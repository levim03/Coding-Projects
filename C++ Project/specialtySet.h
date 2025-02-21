#pragma once

/*
--> Author: Levi McRea
--> Purpose: To create a inheritence relationship to legoSets.h and to interact with the shopping cart vector for a "special" outcome
--> Date: 4/22/2024
*/

#ifndef SPECIALTYSET_H
#define SPECIALTYSET_H

//Make speciality lego set, so it inherits
#include <iostream>
#include <vector>
#include "legoSet.h"
using namespace std;

class specialtySet: public legoSet {
								
private:
	
	string keyChain;   //Attributes
						//if chosen specialty set, add a keychain to the shopping cart
public:

	/*
--> Purpose: Default constructor for the class
--> Version: 1
	*/
	specialtySet() {

		keyChain = "\nBaby Yoda Keychain";

	}
	/*
--> Purpose: Constructor for the class
--> Version: 1
	*/
	specialtySet(int modNum, string setName, double setP) :legoSet(modNum, setName, setP) {  //Constructor for the class (calls the other constructor of the base class
																//Calling base class's initilizer list 

	}
	/*
--> Purpose: Getter for the attribute keyChain
--> Version: 1
	*/
	string getKeyChain() {

		return keyChain;

	}
	/*
--> Purpose: Setter for the attribute keyChain
--> Version: 1
	*/
	void setKeyChain(string k) {

		keyChain = k;
	}

	/*
--> Purpose: print method for the class
--> Version: 1
	*/
	void toString() { 

		//legoSet::toString();


		cout << getKeyChain() << " [FREE]" << endl;
	}

};


#endif