/**
 *	@author Kenny Hoang
 *	Class: CS3345 - Data Structures and Introduction to Algorithmic Analysis
 *	Section: 004
 *	Semester: Spring 2017
 *
 *	Assignment: Project 4
 **/
// Description: Project 4 is the implementation of a red-black tree with no deletion and appropriate rotation
// 				that has RBTreeNode as nested class in Java.
// RBTreeTester.java defines the main method and other functions for input validation.

// Import Statements
import java.util.Scanner;

public class RBTreeTester {

	public static void main(String[] args) {
		RBTree rbtree = new RBTree();
		boolean contOperations = true;
		Scanner scan = new Scanner(System.in);
		String input;
		int choice;
		do{
			System.out.println("Red-Black Trees\n\t1. Insert\n\t2. Contains\n\t3. Print Tree\nEnter a menu choice or 0 to exit: ");
			while(!scan.hasNextInt()){
				input = scan.nextLine();
				System.out.printf("%s is invalid input! Please enter a number corresponding to a menu choice or 0 to exit.", input);
			}
			if(scan.hasNextInt()){
				choice = scan.nextInt();
				scan.nextLine();
				if(validChoice(choice)){
					System.out.printf("Your option: %d\n", choice);
					menuChoice(choice, rbtree, scan);
					if(choice == 0){
						contOperations = false;
					}
				}
				else{
					System.out.printf("%d is invalid menu choice.\nPlease enter a valid choice e.g. Entering \"1\" to insert a element or"
							+ " \"0\" to exit.\n", choice);
				}
			}
		}while(contOperations);
}

public static boolean validChoice(int choice){
	if(choice < 0 || choice > 3)
		return false;
	return true;
}

public static void menuChoice(int choice, RBTree rbtree, Scanner scan){
	int element;
	switch(choice){
		case 1: rbtree.insert(elementInput(scan));
				break;
		case 2: element = elementInput(scan);
				if(rbtree.contains(element)){
					System.out.printf("The red-black tree contains the element %d.\n", element);
				}
				else{
					System.out.printf("The element %d is not in the red-black tree.\n", element);
				}
				break;
		case 3: rbtree.printTree();
				break;
		case 0:	System.out.println("Exiting program...");
				break;
	}
}

public static int elementInput(Scanner scan){
	String input;
	int element;
	do{
		System.out.print("Enter element: ");
		input = scan.next();
	}while(!isInteger(input));
	element = Integer.parseInt(input);
	return element;
}

public static boolean isInteger(String s){
	try{
		Integer.parseInt(s);
	}catch(NumberFormatException e){
		System.out.println("Please enter an integer only.");
		return false;
	}
	return true;
} // end isInteger
}
