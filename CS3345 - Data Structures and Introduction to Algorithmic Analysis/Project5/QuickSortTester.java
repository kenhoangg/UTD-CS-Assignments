/**
 *	@author Kenny Hoang
 *	Class: CS3345 - Data Structures and Introduction to Algorithmic Analysis
 *	Section: 004
 *	Semester: Spring 2017
 *
 *	Assignment: Project 5
 **/
// Description: Project 5 is the implementation of a program to sort a list of integers
// 				using the 'in place' Quicksort algorithm 
// QuickSOrtTester.java defines the main method and other functions for input validation.

// Import Statements
import java.util.Scanner;
import java.util.Random;
import java.io.*;

public class QuickSortTester {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		QuickSort sortList = new QuickSort();
		Scanner scan = new Scanner(System.in);
		String input;
		int arrSize = 0, choice;
			System.out.print("QuickSort\n\tEnter the array size: ");
			while(!scan.hasNextInt()){
				input = scan.nextLine();
				System.out.printf("%s is invalid input! Please enter a number for the array size.", input);
			}
			if(scan.hasNextInt()){
				arrSize = scan.nextInt();
				scan.nextLine();
			}
			int array[] = new int[arrSize];
			Random rand = new Random();
			for(int i = 0; i < arrSize; i++)
			{
				array[i] = rand.nextInt(arrSize - 1) + 1;
			}
			try{
				PrintWriter pw1 = new PrintWriter("unsorted.txt");
				for(int j = 0; j < array.length; j++)
					pw1.println(array[j]);
				pw1.close();
				
			}catch(IOException ioe){
			}
			System.out.print("\n\tEnter the pivot choice:\n\t1. First element as pivot.\n\t2. Random pivot element.\n\t"
					+ "3. Choosing the median of 3 random elements.\n\t4. Median of first, center and last element.\n");
			while(!scan.hasNextInt()){
				input = scan.nextLine();
				System.out.printf("%s is invalid input! Please enter a number for the array size.", input);
			}
			if(scan.hasNextInt()){
				choice = scan.nextInt();
				scan.nextLine();
				if(validChoice(choice)){
					System.out.printf("Your option: %d\n", choice);
					sortList.sort(array, choice);
				}
				else{
					System.out.printf("%d is invalid menu choice.\nPlease enter a valid choice corresponding to"
							+ "the type of pivot choice.", choice);
				}
			}
			scan.close();
			try{
				PrintWriter pw2 = new PrintWriter("sorted.txt");
				for(int k = 0; k < array.length; k++)
					pw2.println(array[k]);
				pw2.close();
				
			}catch(IOException ioe){
			}
			System.out.println("Program finished! Now exiting...");
			//code
			long endTime = System.currentTimeMillis();
			System.out.println("Program took "+(endTime - startTime) + " ms"); 
	}
	
	public static boolean validChoice(int choice){
		if(choice < 0 || choice > 4)
			return false;
		return true;
	}

}
