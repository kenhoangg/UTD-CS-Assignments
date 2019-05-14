/**
 *	@author Kenny Hoang
 *	Class: CS3345 - Data Structures and Introduction to Algorithmic Analysis
 *	Section: 004
 *	Semester: Spring 2017
 *
 *	Assignment: Project 3
 **/
// Description: Project 3 is the implementation of binary search tree class with lazy deletion 
// 				that has TreeNode as nested class in Java.
// BinarySearchTree.java defines the main method and other functions for input validation

// Import Statements
import java.util.Scanner;

public class BinarySearchTreeTester {
	public static void main(String args[]){
		BinarySearchTree bst = new BinarySearchTree();
		boolean contOperations = true;
		Scanner scan = new Scanner(System.in);
		String input;
		int choice;
		do{
			System.out.println("Binary Search Trees\n\t1. Insert\n\t2. Delete\n\t3. Find Max\n\t4. Find Min\n\t"
					+ "5. Contains\n\t6. In Order Tree Traversal\n\t7. Height\n\t8. Number of Nodes\nEnter a menu choice or 0 to exit: ");
			while(!scan.hasNextInt()){
				input = scan.nextLine();
				System.out.printf("%s is invalid input! Please enter a number corresponding to a menu choice or 0 to exit.", input);
			}
			if(scan.hasNextInt()){
				choice = scan.nextInt();
				scan.nextLine();
				if(validChoice(choice)){
					System.out.printf("Your option: %d\n", choice);
					menuChoice(choice, bst, scan);
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
		if(choice < 0 || choice > 8)
			return false;
		return true;
	}
	
	public static void menuChoice(int choice, BinarySearchTree bst, Scanner scan){
		int element;
		switch(choice){
			case 1: bst.insert(elementInput(scan));
					System.out.println("Element inserted.");
					break;
			case 2: bst.delete(elementInput(scan));
					break;
			case 3: bst.findMax(elementInput(scan));
					break;
			case 4: bst.findMin(elementInput(scan));
					break;
			case 5: element = elementInput(scan);
					if(bst.contains(element)){
						System.out.printf("The binary search tree contains the element %d.\n", element);
					}
					else{
						System.out.printf("The element %d is not in the binary search tree.\n", element);
					}
					break;
			case 6: System.out.println("In order traversal:");
					bst.inOrderTraversal();
					break;
			case 7: System.out.printf("Height = %d\n", bst.height());
					break;
			case 8: bst.numNodes();
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
