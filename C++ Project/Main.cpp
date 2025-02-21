/*
--> Author: Levi McRea
--> Purpose: Final project for CSC-250 
--> Date: 4/22/2024
*/

#include <iostream>
#include <string>
#include <vector>
#include <fstream>
#include <sstream>
#include "shoppingCart.h"
#include "specialtySet.h"
#include "legoSet.h"


using namespace std;

//Declaring the prototypes to functions BELOW THE MAIN
void legoThemeStar();

void legoThemeNinja();

void legoThemeTech();

string getUserName();

string getThemeInput(string& themeIn);

void insertionSortAlgorithm(vector <int>& modelNumbers);

int binarySearchAlgorithm(vector <int>& modelNumbers, vector<legoSet> LEGOS, int chosenSet, shoppingCart& inputLEGOS, vector <specialtySet> specialLEGOS);

int binarySearchRecursive(const vector<int>& setNumbers, int chosenNum, int minimum, int maximum, int count, vector<legoSet> LEGOS, shoppingCart& inputLEGOS, vector <specialtySet> specialLEGOS);

void printSortedVector(vector <legoSet>& legoInformation);

char userContinue(char& con);

int main() {				//Main function

	ifstream inputLegoInfo; //Input file stream for the lego set model number
	vector <legoSet> legoInformation; //This is a vector object used to store information from the text file regarding the lego sets
	vector <int> modelNumbers;
	vector <specialtySet> specLEGOS;

	int chosenSet;
	string userName;                //Declaring and initializing strings
	string themeInput;
	string themeStar = "Starwars";
	string themeNinja = "Ninjago";
	string themeTech = "Technic";

	int modNumber; //These declarations are for the vector of objects 
	string legoName;
	double legoPrice;
	
	shoppingCart inputLego; //Creating object for adding the lego sets to the shopping cart

	//Declaring and initilizing boolean 
	bool validTheme = false;

	
	inputLegoInfo.open("LEGO Set Information.txt"); //opening the file with the model numbers
	if (!inputLegoInfo.is_open()) {
		cout << "Error opening the model numbers from file!\n";
		return 0;
	}

	while (inputLegoInfo >> modNumber >> ws) {   //This will begin the creation of the vector of objects
												// This will read until end of file is reached (also reads the model number)
		
		getline(inputLegoInfo, legoName); // Read the lego set name
		inputLegoInfo >> legoPrice; // Read the lego set price

		// Create legoSets object and push it back into the vector
		legoSet setInf(modNumber, legoName, legoPrice);
		legoInformation.push_back(setInf);  //pushing back

		specialtySet setSpec(modNumber, legoName, legoPrice);
		specLEGOS.push_back(setSpec);
	}

	inputLegoInfo.close();  //close file stream

	for (int i = 0; i < legoInformation.size(); i++) {  //This for loop is for copying the model numbers from the vector of objects to another vector so the numbers can be sorted

		legoSet& numLego = legoInformation.at(i);  //Object that helps identify what index to copy the object at
		modelNumbers.push_back(numLego.getModelNumber());
		
	}

	for (int i = 0; i < legoInformation.size(); i++) {  //This does the same thing as above, but also puts the objects into a 'special' lego set vector

		specialtySet& specNum = specLEGOS.at(i);  //Object that helps identify what index to copy the object at
		modelNumbers.push_back(specNum.getModelNumber());

	}
	
	//Calling the function getUserName and assigning it to userName
	userName = getUserName();

	//Program's initial output statements
	cout << "Howdy " << userName << ", welcome to Levi's Lego Emporium.  please look over these featured themes and decide which you want" << endl;
	cout << "--> " << themeStar << " <--\n" << "--> " << themeNinja << "  <--\n" << "--> " << themeTech << "  <--" << endl;
	cout << "*CASE SENTSITIVE*" << endl;
	cout << "Pick your chosen theme: ";
	
	//Start of input validation for themes with boolean value
	getThemeInput(themeInput);
	
	 //If the theme chosen is valid, it enters the large decision branch structure 

		if (themeInput == themeStar) {  //If the input matches themeStar, the program enters this branch

			legoThemeStar();

		}
		if (themeInput == themeNinja) {  //If the input matches themeNinja, the program enters this branch

			legoThemeNinja();
		}

		if (themeInput == themeTech) {		//If the input matches themeTech, the program enters this branch

			legoThemeTech();

		}
		
	cout << endl;
	
	cout << "Would you like to keep building and add another set to your shopping cart? [Y/N]: ";  //Ask user if they want to add another set
	char c;
	userContinue(c);  //calling function that validates the input for the character

	if (c == 'n' || c == 'N') {  //This snippet is making sure if when the user does not want to continue, the program actually exits and does not repeat information

		return -1;
	}


	cout << endl;
	printSortedVector(legoInformation);  //printing list of the vector of objects

	while (c == 'y' || c == 'Y') {  //While loop to begin adding lego sets to the shopping cart

		cout << endl;
		cout << "Here is a list of all the available LEGO sets on the shelf" << endl;

		insertionSortAlgorithm(modelNumbers);  //Calling insertion sort algorithm to sort model numbers

		int num;
		cout << "To add a set to the shopping cart, please type in ONLY the model number that relates to the desired set: "; 
		cin >> num;  
		binarySearchAlgorithm(modelNumbers, legoInformation, num, inputLego, specLEGOS);  //Calling binary search to search for model numbers the user wants to add to the shoppingCart

		cout << "\nWould you like to keep shopping? [Y/N]: ";
		userContinue(c);  //For if the user wants to continue or not
	}
	cout << "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=" << endl;

	cout << "\nIt is time to check out!" << endl;
	cout << "Here is your receipt, " << endl;
	cout << "\n";
	inputLego.toString();  //printing out everything in the cart to user when program is done
	cout << "\nThank you " << userName << " for shopping at Levi's Lego Emporium, please visit again soon!" << endl;
}



/*
 * Purpose: To get user input validation with try/catch statements for looping through adding sets to the cart
*/
char userContinue(char& con) {

	bool usrCon = false; //Declared to make sure the while loop starts looping

	while (!usrCon) {
		try {
			//user will be asked to input the desired LEGO theme

			cin >> con;
			cout << "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";
			if (cin.fail()) {			//This makes sure no numbers or weird strings are inputted

				throw runtime_error("Please, type 'y/Y' OR 'n/N' to continue: ");
				usrCon = false;

			}
			else if ((con == 'y') || (con == 'Y')) {

				usrCon = true;							//Here user input is being tested for the right character to be inputted
			}
			else if ((con == 'n') || (con == 'N')) {

				cout << "You have exited the program. Thank you for your time and have a nice day!" << endl;
				break;
			}
			else {
				throw runtime_error("Invalid input!, please type 'y/Y' OR 'n/N' to continue: ");
				usrCon = false;
			}
			return con;
		}
		catch (runtime_error& excpt) {

			cin.clear();		//clears stream so the next input can be read
			cin.ignore();

			cout << excpt.what();
		}
	}
}


/*
* Purpose: To validate the string input for theme with exceptions
* Will correctly validate with multiple decisions and throwing errors to be caught with the 'try catch' functionality
* Return: returns the theme input
*/

string getThemeInput(string& themeIn) {

	bool validTheme = false; //Declared to make sure the while loop starts looping

	while (!validTheme) {
		try {
			//user will be asked to input the desired LEGO theme

			cin >> themeIn;
			cout << "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";
			if (cin.fail()) {			//This makes sure no numbers or weird strings are inputted

				throw runtime_error("Numbers are not accepted, please enter an input for themes");
				validTheme = false;

			}
			else if ((themeIn == "Starwars") || (themeIn == "Ninjago") || (themeIn == "Technic")) {

				validTheme = true;
			}
			else {
				throw runtime_error("Invalid theme!\n");
				validTheme = false;
			}
			return themeIn;
		}
		catch (runtime_error& excpt) {

			cin.clear();		//clears stream so the next input can be read
			cin.ignore();

			cout << excpt.what() << endl;
			cout << "Sorry, that input was not a valid theme, please choose one from the list given previously: ";
		}
	}

}

/*
 * Purpose: To output a recommended LEGO set for a certain amount of pieces for the Starwars theme
 * Function will get input of a # of lego pieces.
 * If outside the range of LEGO pieces, it will return false and ask user to input another number
 * If inside the range of LEGO pieces, it output a LEGO set within the users chosen number of pieces
*/
void legoThemeStar() {

	int piecesInput;
	bool validPieces = false;

	//At this point, user will enter the # of LEGO pieces they want to build for Starwars theme
	cout << endl;
	cout << "For this theme, sets sold are only buildable within 100 to 8000 pieces." << endl;
	cout << "How many LEGO pieces would you like to build for a StarWars set? ";

	//This do-while loop will continue to loop if the user picks an invalid number of pieces
	while (!validPieces) {
		try {						//Implementing try catch for input validation
			cin >> piecesInput;

			if (cin.fail()) {			//This makes sure no numbers or weird strings are inputted

				throw runtime_error("\nLetters are not accepted, try again");
				validPieces = false;

			}

			else if ((piecesInput >= 100) && (piecesInput <= 8000)) {  //This decision is validating the number of pieces for Starwars theme
				validPieces = true;
			}

			else {
				validPieces = false;
				throw runtime_error("Invalid amount!\n");

				cout << "\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=" << endl;

				cout << "Please try choosing between 100 and 8,000 pieces: ";
			}
		}
		catch (runtime_error& excpt) {

			cin.clear();		//clears stream so the next input can be read
			cin.ignore();

			cout << excpt.what() << endl;
			cout << "Sorry, that input was not a valid amount of pieces, please try again: ";

		}
	}
	if (validPieces) {	//Once valid range is inputted by user, the loop will break and output a specific set and price with these branches

		if ((piecesInput >= 100) && (piecesInput <= 1000)) {

			cout << "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=" << endl;
			cout << "The best value set in this range is the SnowTrooper Battlepack and its MSRP price is $19.99" << endl;

		}
		else if ((piecesInput >= 1000) && (piecesInput <= 2000)) {

			cout << "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=" << endl;
			cout << "The best value set in this range is the AT-TE Walker and its MSRP price is $139.99" << endl;

		}
		else if ((piecesInput >= 2000) && (piecesInput <= 3000)) {

			cout << "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=" << endl;
			cout << "The best value set in this range is R2-D2 Replica and its MSRP price is $239.99" << endl;

		}
		else if ((piecesInput >= 3000) && (piecesInput <= 4000)) {

			cout << "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=" << endl;
			cout << "The best value set in this range is the Republic Gunship and its MSRP price is $399.99" << endl;

		}
		else if ((piecesInput >= 4000) && (piecesInput <= 5000)) {

			cout << "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=" << endl;
			cout << "The best value set in this range is the Death Star and its MSRP price is $499.99" << endl;

		}
		else if ((piecesInput >= 5000) && (piecesInput <= 6000)) {

			cout << "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=" << endl;
			cout << "The best value set in this range is the Venator-Class Republic Attack Cruiser and its MSRP price is $649.99" << endl;

		}
		else if ((piecesInput >= 6000) && (piecesInput <= 7000)) {

			cout << "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=" << endl;
			cout << "The best value set in this range is the AT-AT and its MSRP price is $849.99" << endl;

		}
		else if ((piecesInput >= 7000) && (piecesInput <= 8000)) {

			cout << "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=" << endl;
			cout << "The best value set in this range is the Ultimate Millennium Falcon and its MSRP price is $799.99" << endl;

		}
	}

}

/*
 * Purpose: To output a recommended LEGO set for a certain amount of pieces for the Ninjago theme
 * Function will get input of a # of lego pieces.
 * If outside the range of LEGO pieces, it will return false and ask user to input another number
 * If inside the range of LEGO pieces, it output a LEGO set within the users chosen number of pieces
*/
void legoThemeNinja() {

	int piecesInput;
	bool validPieces = false;

	//At this point, user will enter the # of LEGO pieces they want to build for Ninjago theme
	cout << endl;
	cout << "For this theme, sets sold are only buildable within 100 to 3,000 and 5,000 to 7,000 pieces." << endl;
	cout << "How many LEGO pieces would you like to build for a Ninjago set? ";
	while (!validPieces) {
		try {						//Implementing try catch for input validation
			cin >> piecesInput;

			if (cin.fail()) {			//This makes sure no numbers or weird strings are inputted

				throw runtime_error("\nLetters are not accepted, try again");
				validPieces = false;

			}

			if ((piecesInput >= 100) && (piecesInput <= 3000) || (piecesInput >= 5000) && (piecesInput <= 7000)) {  //This decision is validating the number of pieces for Ninjago theme
				validPieces = true;
			}

			else {
				validPieces = false;
				throw runtime_error("Invalid amount!\n");

				cout << "\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=" << endl;

				cout << "Please try choosing between 100 and 8,000 pieces: ";
			}
		}
		catch (runtime_error& excpt) {

			cin.clear();		//clears stream so the next input can be read
			cin.ignore();

			cout << excpt.what() << endl;
			cout << "Sorry, that input was not a valid amount of pieces, please try again: ";

		}
	}

	if (validPieces) {		//Once valid range is inputted by user, the loop will break and output a specific set and price with these branches

		if ((piecesInput >= 100) && (piecesInput < 1000)) {

			cout << "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=" << endl;
			cout << "The best value set in this range is Zane's Ice Dragon Creature and its MSRP price is $99.99" << endl;
		}
		else if ((piecesInput >= 1000) && (piecesInput <= 2000)) {

			cout << "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=" << endl;
			cout << "The best value set in this range is Ninja Dojo Temple and its MSRP price is $99.99" << endl;

		}
		else if ((piecesInput >= 2000) && (piecesInput <= 3000)) {

			cout << "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=" << endl;
			cout << "The best value set in this range is the Temple of Airjitzu and its MSRP price is $199.99" << endl;
		}
		else if ((piecesInput >= 5000) && (piecesInput <= 6000)) {

			cout << "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=" << endl;
			cout << "The best value set in this range is NINJAGO City Gardens and its MSRP price is $349.99" << endl;
		}
		else if ((piecesInput >= 6000) && (piecesInput <= 7000)) {

			cout << "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=" << endl;
			cout << "The best value set in this range is NINJAGO City Markets and its MSRP price is $369.99" << endl;
		}
	}

}

/*
 * Purpose: To output a recommended LEGO set for a certain amount of pieces for the Technic theme
 * Function will get input of a # of lego pieces.
 * If outside the range of LEGO pieces, it will return false and ask user to input another number
 * If inside the range of LEGO pieces, it output a LEGO set within the users chosen number of pieces
*/
void legoThemeTech() {

	int piecesInput;
	bool validPieces = false;

	//At this point, user will enter the # of LEGO pieces they want to build for Technic theme
	cout << endl;
	cout << "For this theme, sets sold are only buildable within 50 to 5,000 pieces." << endl;
	cout << "How many LEGO pieces would you like to build for a Technic set? ";
	while (!validPieces) {
		try {						//Implementing try catch for input validation
			cin >> piecesInput;

			if (cin.fail()) {			//This makes sure no numbers or weird strings are inputted

				throw runtime_error("\nLetters are not accepted, try again");
				validPieces = false;

			}

			if ((piecesInput >= 50) && (piecesInput <= 5000)) {  //This decision is validating the number of pieces for Technic theme
				validPieces = true;
			}

			else {
				validPieces = false;
				throw runtime_error("Invalid amount!\n");

				cout << "\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=" << endl;

				cout << "Please try choosing between 100 and 8,000 pieces: ";
			}
		}
		catch (runtime_error& excpt) {

			cin.clear();		//clears stream so the next input can be read
			cin.ignore();

			cout << excpt.what() << endl;
			cout << "Sorry, that input was not a valid amount of pieces, please try again: ";

		}
	}
	if (validPieces) {		//Once valid range is inputted by user, the loop will break and output a specific set and price with these branches

		if ((piecesInput >= 50) && (piecesInput <= 1000)) {

			cout << "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=" << endl;
			cout << "The best value set in this range is the Lamborghini Huracán Tecnica and its MSRP price is $49.99" << endl;
		}
		else if ((piecesInput >= 1000) && (piecesInput <= 2000)) {

			cout << "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=" << endl;
			cout << "The best value set in this range is the 2022 Ford GT and its MSRP price is $119.99" << endl;

		}
		else if ((piecesInput >= 2000) && (piecesInput <= 3000)) {

			cout << "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=" << endl;
			cout << "The best value set in this range is the Liebherr Crawler Crane and its MSRP price is $699.99" << endl;
		}

		else if ((piecesInput >= 3000) && (piecesInput <= 4000)) {

			cout << "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=" << endl;
			cout << "The best value set in this range is the Lamborghini Sián FKP 37 and its MSRP price is $449.99" << endl;
		}
		else if ((piecesInput >= 4000) && (piecesInput <= 5000)) {

			cout << "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=" << endl;
			cout << "The best value set in this range is the Technic Liebherr R 9800 Excavator and its MSRP price is $935.99" << endl;
		}
	}

}

/*
 * Purpose: To ask user for their name and print it to the screen once called
 * Return: Returns the name inputted from the user
 *
*/
string getUserName() {

	string inputName;

	cout << "Please enter your name: ";   //Asking for user input for a LEGO theme
	getline(cin, inputName);

	return inputName;

}

/*
 * Purpose: To sort the model number vector using insertion sort algorithm 
*/
void insertionSortAlgorithm(vector <int>& setNumbers) {	 //insertion sort algorithm function for sorting the items in the input file

	int keyValue, j;
	for (int i = 1; i < setNumbers.size(); i++) {
		keyValue = setNumbers.at(i);
		j = i - 1;

		// Move elements of arr[0..i-1],
		// that are greater than key, 
		// to one position ahead of their
		// current position
		while (j >= 0 && setNumbers.at(j) > keyValue) {
			setNumbers.at(j + 1) = setNumbers.at(j);
			j = j - 1;
		}
		setNumbers.at(j + 1) = keyValue;
	}
}


/*
 * Purpose: This is the binary search algorithm that includes recursion.  There are 2 functions that help achieve this, this function and the one below it
*/

int binarySearchRecursive(const vector<int>& setNumbers, int chosenNum, int minimum, int maximum, int count, vector<legoSet> LEGOS, shoppingCart& inputLEGOS, vector <specialtySet> specialLEGOS) {


	if (maximum >= minimum) {
		int mean = minimum + (maximum - minimum) / 2;

		if (setNumbers[mean] == chosenNum) {
			cout << "\nThe model number you're looking has been found on the shelf! \n";             //call a function in this function that would allow the user to add the set to the cart??? (function would have objects)
			cout << "Just FYI, it took " << count << " searches to find your set on the shelf" << endl;  //Here add what you talked about with Caudill
			cout << "\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=" << endl;


			for (int i = 0; i < LEGOS.size(); i++) {  //for loop to loop through the vector of objects

				legoSet chooseLego = LEGOS.at(i);  //Object that helps identify what index to print the object at
				specialtySet& special = specialLEGOS.at(i); //Same meaning as above comment

				if (chosenNum == chooseLego.getModelNumber()) {		//This will compare the model number to the model number object, if true, it will push that entire index of the vector to the shoppingCart class to populate the 'cart'
					inputLEGOS.addRegLegosToCart(LEGOS.at(i));  //This sends the index to the class method in shoppingCart
					inputLEGOS.toString();  //Printing the 'shopping cart' items to the user every time something is added
					break;
				}
				else if (chosenNum == 8009) {   //This does the same thing as the comments above mention but its for the specialLEGOS vector

					inputLEGOS.addSpecLegosToCart(specialLEGOS.at(2));
					inputLEGOS.toString();
					break;
				}
			}
		
			
			return mean;  
		}

		if (setNumbers[mean] > chosenNum)
			return binarySearchRecursive(setNumbers, chosenNum, minimum, mean - 1, count + 1, LEGOS, inputLEGOS, specialLEGOS);  //recursion call of the function

		return binarySearchRecursive(setNumbers, chosenNum, mean + 1, maximum, count + 1, LEGOS, inputLEGOS, specialLEGOS);  //recursion call of the function
	}

	cout << "Your model number was not found. The program looped " << count << " times with no avail :(" << endl;
	return -1;
}

/*
 * Purpose: This is the second function for the binary search, and resursive function.  This function is just for declaring and initializing values for the resursive function so it works correctly
*/
int binarySearchAlgorithm(vector<int>& setNumbers, vector<legoSet> LEGOS,int chosenNum, shoppingCart& inputLEGOS, vector <specialtySet> specialLEGOS) {
	int maximum = setNumbers.size() - 1;
	int minimum = 0;
	int count = 0;

	//Recursion function is called here
	return binarySearchRecursive(setNumbers, chosenNum, minimum, maximum, count, LEGOS, inputLEGOS, specialLEGOS);
}

/*
 * Purpose: To print the sorted vector of legoInformation to the user so the user can choose what lego set they want
*/
void printSortedVector(vector <legoSet>& legoInformation) {  //prints the random vector of objects elements back to the user

	for (int i = 0; i < legoInformation.size(); i++) {

		legoSet& printLego = legoInformation.at(i);  //Object that helps identify what index to print the object at
		printLego.toString();
	}

}
