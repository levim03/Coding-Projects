/*
 * Author: Levi McRea
 * Date: 2/25/2025
 * Purpose: To create files, write to files, read from them and output information to them
 */

import java.util.*;		//import libraries for i/o and exceptions
import java.io.*;		
import java.io.IOException;

public class IO {

	public static void main(String[] args) throws IOException{
		
	Scanner userInput = new Scanner(System.in);
		
	FileOutputStream fileStream1 = null;  //create objects for making file and outputting numbers
	PrintWriter outFS = null;
	
	//opening the file (creating it)
	System.out.print("Please input the desired file name (path) to export numbers: ");
	String fileName1 = userInput.nextLine();
	
	fileStream1 = new FileOutputStream(fileName1);
	outFS = new PrintWriter(fileStream1);
		
	for(int i = 0; i < 101; i++) {  //will print numbers 1 - 100 to the file
		
		outFS.println(i);
	}
	
	outFS.close();  //close output file
	
	FileInputStream fileStream2 = null;  
	Scanner inFS = null;  //create objects for pulling in file
	
	//reaching the input file
	System.out.print("Please input the desired file name (path) to be imported: ");
	
	String fileName2 = userInput.nextLine();
	
	try {
		fileStream2 = new FileInputStream(fileName2);	
        inFS = new Scanner(fileStream2);
	}
	catch (IOException e){  //exceptions for importing
		System.out.println("Error finding the file, please try again");
	}
		//sum, average, median calculations and variables
	
	    double sum = 0;
		double average = 0;
		int median = 0;
		int [] fileNumbers = new int[101]; //creating array to populate to get median
		int ct = 0;
		
		for(int i = 0; i < 100;i++) {
			
			sum += inFS.nextInt(); //adding up numbers
			average = sum / 100; //finding average
			
		}
		
		inFS.close();  //closing file once
		
		System.out.println("The sum of all the numbers in that file are: "+ sum);
		System.out.println("The average of all the numbers in that file are: "+ average);
		
		fileStream2 = new FileInputStream(fileName2);  //reopen the file stream to re-read for median
        inFS = new Scanner(fileStream2);  //recreate the scanner to read again
		
		while (inFS.hasNextInt()) {  //checks for the next value in file
			
			if (ct < fileNumbers.length) {
                fileNumbers[ct] = inFS.nextInt();  //populating the array
                ct++;  //increment count
			}
		}
		inFS.close();  //closing file twice
		
		median = fileNumbers.length / 2;  //this only works because the number if values in the file is even
		System.out.println("The median of all the numbers in that file are: "+ median);
		System.out.println();
		System.out.print("Please type the name (path) of the file for the results: ");  //asking for result file path
		
		String fileName3 = userInput.nextLine(); //user input for final file output path
		FileOutputStream outputStream = null;  //more file output objects
		PrintWriter outFile = null;
		
		outputStream = new FileOutputStream(fileName3);
		outFile = new PrintWriter(outputStream);
		
		outFile.println("The sum: " + sum);		//outputting values to new file
		outFile.println("The average: " + average);
		outFile.println("The median: " + median);
		
		outFile.close();
			
		System.out.print("Values have been printed out!");
	}
}

	

