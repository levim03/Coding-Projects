#pragma once

/* 
--> Author: Levi McRea
--> Purpose: To create vectors that hold objects and update total price (Simulate a shopping cart)
--> Date: 4/22/2024
*/

#ifndef SHOPPINGCART_H
#define SHOPPINGCART_H

#include <iostream>
#include <vector>
#include "legoSet.h"
#include "specialtySet.h"        //POSSIBLY ADD COMMENTS TO WHAT THE METHODS RETURN

using namespace std;

class shoppingCart {                                               
	

private:

	vector <legoSet> legoInCart;  
	vector <specialtySet> specialLegoInCart;   //Attributes
	specialtySet special;

	double cartPriceTotal;

public:

	/*
--> Purpose: Default constructor
--> Version: 1
	
	*/
	shoppingCart() {  

		cartPriceTotal = 0;
		
	}

	/*
--> Purpose: Getter for LegoInCart
--> Version: 1
	*/
	vector<legoSet>& getLegoInCart() {  //Getter for LegoInCart

		return legoInCart;

	}

	/*
--> Purpose: Setter for LegoInCart
--> Version: 1
	*/
	void setLegoInCart(int set) {  //Setter for LegoInCart

	}

	/*
--> Purpose: Pushes back the item passes by parameter from the main into the vector (simulates the actual shopping cart)
--> Version: 1
	*/
	void addRegLegosToCart(legoSet& LEGO) {  
		
		legoInCart.push_back(LEGO);
		updatePrice();
	}

	/*
--> Purpose: Pushes back the special lego set which passes by parameter from the main into the vector (simulates the actual shopping cart)
--> Version: 1
	*/
	void addSpecLegosToCart(specialtySet& specialtyLEGO) {

		specialLegoInCart.push_back(specialtyLEGO);
		updatePrice();
	}

	/*
--> Purpose: Getter that accesses the current running total price
--> Version: 1
	*/
	double getPrice() {  
		
		return cartPriceTotal;

	}

	/*
--> Purpose: Creates a running total of the price
--> Version: 1
	*/
	void updatePrice() {

		cartPriceTotal = 0;

		if (!legoInCart.empty()) {
			for (int i = 0; i < legoInCart.size(); i++) {

				cartPriceTotal = cartPriceTotal + legoInCart.at(i).getLegoSetPrice();

			}
		}
		if (!specialLegoInCart.empty()) {
			for (int i = 0; i < specialLegoInCart.size(); i++) {

				cartPriceTotal = cartPriceTotal + specialLegoInCart.at(i).getLegoSetPrice();
			}
		}
	}

	/*
--> Purpose: print method that prints everything in the shopping cart to the user
--> Version: 1
	*/
	void toString() {  
		cout << "The LEGO sets in the cart currently are," << endl;

		if (!legoInCart.empty()) {    //Will only print if it contains an element/elements
			for (int i = 0; i < legoInCart.size(); i++) {

				cout << "\nModel #: " << legoInCart.at(i).getModelNumber() << endl;
				cout << "Name: " << legoInCart.at(i).getLegoSetName() << endl;
				cout << "Price: " << legoInCart.at(i).getLegoSetPrice() << endl;
			}
		}
			if (!specialLegoInCart.empty()) {    //Will only print if it contains an element/elements
				for (int i = 0; i < specialLegoInCart.size(); i++) {

					cout << "\nModel #: " << specialLegoInCart.at(i).getModelNumber() << endl;
					cout << "Name: " << specialLegoInCart.at(i).getLegoSetName() << endl;
					cout << "Price: " << specialLegoInCart.at(i).getLegoSetPrice() << endl;
					special.toString();
				}
			}
		
		cout << "\nCurrent exact total: " << getPrice() << endl;
		cout << "\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=" << endl;
	}
};


#endif