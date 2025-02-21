#pragma once

/*
--> Author: Levi McRea
--> Purpose: To hold all the information for lego sets so it can be used by the main functions and other header files
--> Date: 4/22/2024
*/

#ifndef LEGOSET_H
#define LEGOSET_H

#include <iostream>
#include <vector>

using namespace std;

class  legoSet{

private:
	int modelNumber;
	string legoSetName;   //Attributes
	double legoSetPrice;
	
public:
	/*
--> Purpose: Default constructor
--> Version: 1
	*/
	legoSet() {

		modelNumber = 0;
		legoSetName = "NULL";
		legoSetPrice = 0;
	}

	/*
--> Purpose: Regular constructor for the class
--> Version: 1
	*/
	legoSet(int modelNumber, string legoSetName, double legoSetPrice) {   //Constructor for the class
		
		this->modelNumber = modelNumber;   //The 'this' keyword will use the address to set the variable to whatever was passed from the object in main
		this->legoSetName = legoSetName;
		this->legoSetPrice = legoSetPrice;
	}

	/*
--> Purpose: Getter for modelNumber
--> Version: 1
	*/
	int getModelNumber() {  

		return modelNumber;

	}

	/*
--> Purpose: Getter for legoSetName
--> Version: 1
	*/
	string getLegoSetName() {  

		return legoSetName;

	}

	/*
--> Purpose: Getter for legoSetPrice
--> Version: 1
	*/
	double getLegoSetPrice() {  

		return legoSetPrice;

	}

	/*
--> Purpose: Setter for modelNumber
--> Version: 1
	*/
	void setModelNumber(int mod) {  

		modelNumber = mod;

	}

	/*
--> Purpose: Setter for legoSetName
--> Version: 1
	*/
	void setLegoSetName(string name) {  //Setter for legoSetName

		legoSetName = name;

	}


	/*
--> Purpose: Setter for legoSetPrice
--> Version: 1
	*/
	void setLegoSetPrice(double price) {  

		legoSetPrice = price;

	}

	/*
--> Purpose: print method that is called in main to print all the lego sets and their corresponding objects
--> Version: 1
	*/
	void toString() { 
	
		cout << "Model: " << getModelNumber() << endl;
		cout << "Name: " << getLegoSetName() << endl;
		cout << "Price: " << getLegoSetPrice() << endl;
		cout << "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=" << endl;
	}

};


#endif