/**
 *	@author Kenny Hoang
 *	Class: CS3345 - Data Structures and Introduction to Algorithmic Analysis
 *	Section: 004
 *	Semester: Spring 2017
 *
 *	Assignment: Project 2
 **/

// MagazineList.java defines the main class along with functions for input validation.

import java.util.Scanner;
public class MagazineList {
	public static void main(String args[]){
		ALinkedList<Magazine> list = new ALinkedList<Magazine>();
		boolean contOperations = true;
		Scanner scan = new Scanner(System.in);
		String input;
		int choice;
		do{
			System.out.println("Operations on List\n\t1. Make Empty\n\t2. Find ID\n\t3. Insert At Front\n\t"
					+ "4. Delete From Front\n\t5. Delete ID\n\t6. Print All Records\n\t7. Done\n\t");
			while(!scan.hasNextInt()){
				input = scan.nextLine();
				System.out.printf("%s is invalid input! Please enter a number corresponding to a menu choice.", input);
			}
			if(scan.hasNextInt()){
				choice = scan.nextInt();
				scan.nextLine();
				if(validChoice(choice)){
					System.out.printf("Your choice: %d\n", choice);
					menuChoice(choice, list, scan);
					if(choice == 7)
						contOperations = false;
				}
				else
					System.out.printf("%d is invalid menu choice.\nPlease enter a valid choice e.g. Entering \"2\" to find ID or"
							+ " \"7\" to finish.\n", choice);
			}
		}while(contOperations);
		scan.close();
	} // end main
	
	public static boolean validChoice(int choice){
		if(choice < 1 || choice > 7)
			return false;
		return true;
	}
	
	public static void menuChoice(int choice, ALinkedList<Magazine> magList, Scanner scan){
		int id;
		String magName, pubName;
		Magazine check;
		switch(choice){
			case 1: magList.makeEmpty();
					break;
			case 2: check = magList.findID(idInput(scan));
					if(check != null)
						check.printID();
					break;
			case 3: id = idInput(scan);
					magName = nameInput(1, scan);
					pubName = nameInput(2, scan);
					Magazine mag = new Magazine(id, magName, pubName);
					if(magList.insertAtFront(mag))
						System.out.println("...\nMagazine Added.");
					else
						System.out.println("That ID already exists.");
					break;
			case 4: check = magList.deleteFromFront();
					if(check != null){
						check.printID();
						System.out.println("First item deleted.");
					}
					break;
			case 5: check = magList.delete(idInput(scan));
					if(check != null){
						check.printID();
					}
					break;
			case 6: magList.printAllRecords();
					break;
			case 7:	System.out.println("Done.");
					break;
		}
	}
	
	public static int idInput(Scanner scan){
		String input;
		int id;
		do{
			System.out.print("Please enter magazine ID: ");
			input = scan.next();
		}while(!isInteger(input));
		id = Integer.parseInt(input);
		return id;
	}
	
	public static String nameInput(int nameType, Scanner scan){
		String input;
		if(nameType == 1)
			System.out.print("Please enter magazine name: ");
		else if(nameType == 2)
			System.out.print("Please enter publisher name: ");
		input = scan.next();
		scan.nextLine();
		return input;
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
