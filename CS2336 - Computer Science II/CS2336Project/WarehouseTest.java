/**
 *	@author Kenny Hoang
 *	Class: CS2336 - Computer Science II
 *	Section: 001	
 *	Semester: Fall 2016
 *
 *	Assignment: Term Project
 **/

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;


public class WarehouseTest {
	public static void main(String[] args){
		ArrayList<Warehouse> warehouses = new ArrayList<Warehouse>();
		Warehouse test = new Warehouse();
		test.subNumBuilding(); // Subtract twice from the number of buildings to get true # of buildings created
		test.subNumBuilding();
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to Warehouse Management System!");
		String input = "";
		int menuSel = -1;
		boolean menuCheck = true;
		startMenu();
		do{
			do
			{
				System.out.print("Please enter your menu selection: ");
				input = scan.next();
				scan.nextLine();
			}while(!isInteger(input));
			menuSel = Integer.parseInt(input);
			if(menuSel < 0 || menuSel > 2){
				System.out.print("Error! Invalid menu selection!\n");
				menuCheck = false;
			}
		}while(!menuCheck);
		startMenuSelection(menuSel, warehouses, test, scan);
		do{
			selectionMenu();
			do
			{
				System.out.print("Please enter your menu selection: ");
				input = scan.next();
				scan.nextLine();
			}while(!isInteger(input));
			menuSel = Integer.parseInt(input);
			//startWarehouseSelection(menuSel, warehouses, test, scan);
			selectionMenuSelection(menuSel, warehouses, test, scan);
			}while(true);
	} // end main
	
	public static void startMenu(){
		System.out.println("\nCreate Menu:\n 1. Create a basic warehouse.\n 2. Create a warehouse with a name and size.\n Press \"0\" to exit.");
	} // end startMenu
	
	public static void startMenuSelection(int input, ArrayList<Warehouse> warehouses, Warehouse someWarehouse,Scanner in){
		if(input == 0)
			printOutput(warehouses, someWarehouse);
		else if(input == 1)
			warehouses.add(new Warehouse());
		else if(input == 2)
		{
			String name = "";
			int size = 0;
			int inventory = 0;
			setWarehouse(in, name, size, inventory, someWarehouse);
			warehouses.add(new Warehouse(someWarehouse.getName(), someWarehouse.getSize(), someWarehouse.getInventory()));
		}
	} // end startMenuSelection
	
	public static void createSelection(int input, ArrayList<Warehouse> warehouses, Warehouse someWarehouse,Scanner in){
		String menuInput;
		do
		{
			System.out.print("Please enter your menu selection: ");
			menuInput = in.next();
			in.nextLine();
		}while(!isInteger(menuInput));
		input = Integer.parseInt(menuInput);

		if(input == 0)
			printOutput(warehouses, someWarehouse);
		else if(input == 1)
			warehouses.add(new Warehouse());
		else if(input == 2)
		{
			String name = "";
			int size = 0;
			int inventory = 0;
			setWarehouse(in, name, size, inventory, someWarehouse);
			warehouses.add(new Warehouse(someWarehouse.getName(), someWarehouse.getSize(), someWarehouse.getInventory()));
		}
	} // end createSelection
	
	public static void setWarehouse(Scanner in, String name, int size, int inventory, Warehouse someWarehouse){
		System.out.print("Please enter the name of the warehouse: ");
		name = in.nextLine().trim();
		String sizeInput;
		boolean sizeCheck;
		boolean inventoryCheck;
		do{
			do
			{
				System.out.print("Please enter the size of the warehouse: ");
				sizeInput = in.next();
				in.nextLine();
			}while(!isInteger(sizeInput));
			size = Integer.parseInt(sizeInput);
			sizeCheck = true;
			if(size < 0){
				System.out.print("Invalid entry! Cannot set size of factory to a negative number.\n");
				sizeCheck = false;
			}
			if(size > 2500){
				System.out.printf("Too large of an input! The maximum size of a warehouse is 2500. Can increase the warehouse "
						+ "by maximum of %d.\n", 2500 - someWarehouse.getSize());
				sizeCheck = false;
			}
		}while(!sizeCheck);
		String invenInput;
		do{
			do
			{
				System.out.print("Please enter the total inventory in stock: ");
				invenInput = in.next();
				in.nextLine();
			}while(!isInteger(invenInput));
			inventory = Integer.parseInt(invenInput);
			inventoryCheck = true;
			if(inventory < 0){
				System.out.print("Invalid entry! Cannot set inventory to a negative amount.\n");
				inventoryCheck = false;
			}
			if(size < inventory){
				System.out.printf("Inventory is larger than size of warehouse! The size of the warehouse is %d\n", size);
				inventoryCheck = false;
			}
		}while(!inventoryCheck);
			someWarehouse.setName(name);
			someWarehouse.setSize(size);
			someWarehouse.setInventory(inventory);
	} // end setWarehouse
	
	
	public static void selectionMenu(){
		System.out.println("\nMenu:\n 1. Warehouse Functions\n 2. Worker Functions\n 3. Create Functions\n Press \"0\" to exit.");
	}
	
	public static void selectionMenuSelection(int input, ArrayList<Warehouse> warehouses, Warehouse someWarehouse,Scanner in){
		if(input == 0)
			printOutput(warehouses, someWarehouse);
		if(input == 1){
			warehouseMenu();
			warehouseSelection(input, warehouses, someWarehouse, in);
		}
		else if(input == 2){
			workerMenu();
			workerSelection(input, warehouses, someWarehouse, in);
		}
		else if(input == 3){
			startMenu();
			createSelection(input, warehouses, someWarehouse, in);
		}	
	} // end startWare

	public static void warehouseMenu(){
		System.out.print("\nWarehouse Function Menu:\n 1. Get the size of the warehouse.\n 2. Get the total inventory.\n 3. Get the number of workers.\n"
				+ " 4. Add to inventory.\n 5. Remove from inventory.\n Press \"0\" to exit.\n");
	}
	
	public static void warehouseSelection(int input, ArrayList<Warehouse> warehouses, Warehouse someWarehouse,Scanner in){
		String menuInput;
		do
		{
			System.out.print("Please enter your menu selection: ");
			menuInput = in.next();
			in.nextLine();
		}while(!isInteger(menuInput));
		input = Integer.parseInt(menuInput);
		
		if(input == 0)
			printOutput(warehouses, someWarehouse);
		else if(input > 0 && input < 4)
			getWarehouseValues(input, warehouses, someWarehouse, in);
		else if(input > 3 && input < 6)
			changeInventoryValues(input, warehouses, someWarehouse, in);
	} // end warehouseSelection
	
	public static void workerMenu(){
		System.out.print("\nWorker Function Menu:\n 1. Add a worker.\n 2. Remove a worker. \n 3. Get a worker's wage, hours, and salary.\n"
				+ " 4. Set a worker's wage.\n 5. Set a worker's hours.\n Press \"0\" to exit.\n");
	}
	
	public static void workerSelection(int input, ArrayList<Warehouse> warehouses, Warehouse someWarehouse,Scanner in){
		String menuInput;
		do
		{
			System.out.print("Please enter your menu selection: ");
			menuInput = in.next();
			in.nextLine();
		}while(!isInteger(menuInput));
		input = Integer.parseInt(menuInput);
		
		if(input == 0)
			printOutput(warehouses, someWarehouse);
		else if(input == 1)
			addWorkers(warehouses, someWarehouse, in);
		else if(input == 2)
			removeWorkers(warehouses, someWarehouse, in);
		else if(input == 3)
			getWorkerValues(warehouses, someWarehouse, in);
		else if(input > 3 && input < 6)
			setWorkerValues(input, warehouses, someWarehouse, in);
	} // end startMenuSelection
	
	public static void getWarehouseValues(int input, ArrayList<Warehouse> warehouses, Warehouse someWarehouse,Scanner in){
		int warehouseNumber = 0;
		warehouseNumber = getWarehouseNumber(warehouseNumber, warehouses, someWarehouse, in);
		someWarehouse = warehouses.get(warehouseNumber);
		if(input == 1)
			System.out.printf("The size of %s is %d.\n", someWarehouse.getName(),someWarehouse.getSize());
		else if(input == 2)
			System.out.printf("The total inventory of %s is %d.\n", someWarehouse.getName(), someWarehouse.getInventory());
		else
			System.out.printf("The number of workers of %s is %d.\n", someWarehouse.getName(), someWarehouse.getNumWorkers());
	} // end getWarehouseValues
	
	public static void changeInventoryValues(int input, ArrayList<Warehouse> warehouses, Warehouse someWarehouse,Scanner in){
		int warehouseNumber = 0;
		warehouseNumber = getWarehouseNumber(warehouseNumber, warehouses, someWarehouse,in);
		someWarehouse = warehouses.get(warehouseNumber);
		String changeInput;
		int changeInventory;
		boolean changeCheck;
		if(input == 4){
			do{
				do
				{
					System.out.printf("The current inventory space available is %d.\nEnter the amount of stock to add to inventory: "
							,someWarehouse.getSize() - someWarehouse.getInventory());
					changeInput = in.next();
					in.nextLine();
				}while(!isInteger(changeInput));
				changeInventory = Integer.parseInt(changeInput);
				changeCheck = true;
				if(changeInventory < 0){
					System.out.print("Invalid entry! Cannot add a negative amount to inventory.\n");
					changeCheck = false;
				}
				if(changeInventory + someWarehouse.getInventory() > someWarehouse.getSize())
				{
					System.out.printf("Not enough space in warehouse! The size of the warehouse is %d.\n", someWarehouse.getSize());
					if(changeSizeCheck(0, in))
						changeSizeValues(0, warehouses, someWarehouse, in);
					changeCheck = false;
				}
			}while(!changeCheck);
			someWarehouse.increaseInventory(changeInventory);
			System.out.printf("The total inventory of %s is %d.\n", someWarehouse.getName(), someWarehouse.getInventory());
		}
		else if(input == 5){
			do{
				do
				{
					System.out.printf("The current amount in inventory is %d.\nEnter the amount of stock to remove from inventory: "
							, someWarehouse.getInventory());
					changeInput = in.next();
					in.nextLine();
				}while(!isInteger(changeInput));
				changeInventory = Integer.parseInt(changeInput);
				changeCheck = true;
				if(changeInventory < 0){
					System.out.print("Invalid entry! Cannot remove a negative amount from inventory.\n");
					changeCheck = false;
				}
				if(changeInventory > someWarehouse.getInventory()){
					System.out.printf("Not enough in stock! There is only %d in inventory.\n", someWarehouse.getInventory());
					if(changeSizeCheck(1, in))
						changeSizeValues(1, warehouses, someWarehouse, in);
					changeCheck = false;
				}
			}while(!changeCheck);
			someWarehouse.decreaseInventory(changeInventory);
			System.out.printf("The total inventory of %s is %d.\n", someWarehouse.getName(), someWarehouse.getInventory());
		}
	} // end changeInventoryValues
		
	public static boolean changeSizeCheck(int input, Scanner in){
		String sizeInput;
		if(input == 0){
			do{
				System.out.print("Would you like to increase the size of the warehouse?\n Yes/No: "); // Start increase size prompt
				sizeInput = in.next();
				in.nextLine();
			}while(!checkYesNo(sizeInput));
			if(sizeInput.equalsIgnoreCase("Yes"))
				return true;
			return false;
		}
		else{
			do{
				System.out.print("Would you like to decrease the size of the warehouse?\n Yes/No: "); // Start decrease size prompt
				sizeInput = in.next();
				in.nextLine();
			}while(!checkYesNo(sizeInput));
			if(sizeInput.equalsIgnoreCase("Yes"))
				return true;
			return false;
		}	
	} // end changeSizeCheck
	
	public static void changeSizeValues(int input, ArrayList<Warehouse> warehouses, Warehouse someWarehouse, Scanner in){
		int warehouseNumber = 0;
		warehouseNumber = getWarehouseNumber(warehouseNumber, warehouses, someWarehouse,in);
		someWarehouse = warehouses.get(warehouseNumber);
		String changeInput;
		int changeSize;
		boolean changeCheck;
		if(input == 0){
			do{
				do
				{
					System.out.printf("The current warehouse space is %d.\nEnter the amount to increase the warehouse space by: ",
							 someWarehouse.getSize());
					changeInput = in.next();
					in.nextLine();
				}while(!isInteger(changeInput));
				changeSize = Integer.parseInt(changeInput);
				changeCheck = true;
				if(changeSize < 0){
					System.out.print("Invalid entry! Cannot increase by a negative amount.\n");
					changeCheck = false;
				}
				if(changeSize + someWarehouse.getSize() > 2500){
					System.out.printf("Too large of an input! The maximum size of a warehouse is 2500. Can increase the warehouse "
							+ "by maximum of %d.\n", 2500 - someWarehouse.getSize());
					changeCheck = false;
				}
			}while(!changeCheck);
			someWarehouse.increaseSize(changeSize);
			System.out.printf("The total size of %s is %d.\n", someWarehouse.getName(), someWarehouse.getSize());
		}
		else if(input == 1)
		{
			do{
				do
				{
					System.out.printf("The current warehouse space is %d.\nEnter the amount to decrease the warehouse space by: "
							, someWarehouse.getSize());
					changeInput = in.next();
					in.nextLine();
				}while(!isInteger(changeInput));
				changeSize = Integer.parseInt(changeInput);
				changeCheck = true;
				if(changeSize < 0){
					System.out.print("Invalid entry! Cannot decrease a negative amount.\n");
					changeCheck = false;
				}
				if(changeSize > someWarehouse.getSize()){
					System.out.printf("Too large of an input! The size of the %s is %d.\n", someWarehouse.getName(), someWarehouse.getSize());
					changeCheck = false;
				}
				if(someWarehouse.getSize() - changeSize < someWarehouse.getInventory()){
					System.out.printf("There is %d items in inventory! Can only decrease the warehouse by maximum of %d.\n", 
							someWarehouse.getInventory(), someWarehouse.getSize() - someWarehouse.getInventory());
					changeCheck = false;
				}
			}while(!changeCheck);
			someWarehouse.decreaseSize(changeSize);
			System.out.printf("The total size of %s is %d.\n", someWarehouse.getName(), someWarehouse.getSize());
		}
		
	} //end changeSizeValues
	
	public static boolean checkYesNo(String input){
		if(input.equalsIgnoreCase("YES") || input.equalsIgnoreCase("NO"))
			return true;
		System.out.println("Invalid input! Please enter \"Yes\" or \"No\" only.");
		return false;
	} // end checkYesNo
	
	public static void addWorkers(ArrayList<Warehouse> warehouses, Warehouse someWarehouse,Scanner in){
		int warehouseNumber = 0;
		String name, wageInput, hourInput;
		double wage, hours;
		boolean wageCheck, hourCheck;
		warehouseNumber = getWarehouseNumber(warehouseNumber, warehouses, someWarehouse, in);
		someWarehouse = warehouses.get(warehouseNumber);
		System.out.print("Please enter the worker's name: ");
		name = in.nextLine();
		do{
			do
			{
				System.out.print("Enter the worker's wage: ");
				wageInput = in.next();
				in.nextLine();
			}while(!isDouble(wageInput));
			wage = Double.parseDouble(wageInput);
			wageCheck = true;
			if(wage < 0){
				System.out.print("Invalid entry! Wage must be positive!\n");
				wageCheck = false;
			}
		}while(!wageCheck);
		
		do{
			do
			{
				System.out.print("Enter the worker's hours: ");
				hourInput = in.next();
				in.nextLine();
			}while(!isDouble(hourInput));
			hours = Double.parseDouble(hourInput);
			hourCheck = true;
			if(hours < 0){
				System.out.print("Invalid entry! Hours must be positive!\n");
				hourCheck = false;
			}
		}while(!hourCheck);
		someWarehouse.addWorker(new Worker(name, wage, hours));
		System.out.printf("The number of workers in %s is %d.\n", someWarehouse.getName(), someWarehouse.getNumWorkers());
	} // end addWorkers
	
	public static void removeWorkers(ArrayList<Warehouse> warehouses, Warehouse someWarehouse,Scanner in){
		int warehouseNumber = 0;
		String numInput;
		int index = 0;
		boolean indexCheck;
		warehouseNumber = getWarehouseNumber(warehouseNumber, warehouses, someWarehouse, in);
		someWarehouse = warehouses.get(warehouseNumber);
		if(someWarehouse.getNumWorkers() != 0){
			do{
				someWarehouse.displayWorkers();
				do
				{
					System.out.print("Enter the number of the worker to be removed: ");
					numInput = in.next();
					in.nextLine();
				}while(!isInteger(numInput));
				index = Integer.parseInt(numInput);
				indexCheck = true;
				if(index < 0){
					System.out.print("Invalid entry! Number must be positive!\n");
					indexCheck = false;
				}
				if(index > someWarehouse.getNumWorkers()){
					System.out.print("Invalid entry! Please enter a number in the list.\n");
					indexCheck = false;
				}
			}while(!indexCheck);
			someWarehouse.removeWorker(index);
		}
		else
			System.out.println("There are no workers assigned to this warehouse currently.");
	} // end removeWorkers

	public static void getWorkerValues(ArrayList<Warehouse> warehouses, Warehouse someWarehouse,Scanner in){
		int index = 0, warehouseNumber = 0;
		String numInput;
		boolean indexCheck;
		warehouseNumber = getWarehouseNumber(warehouseNumber, warehouses, someWarehouse, in);
		someWarehouse = warehouses.get(warehouseNumber);
		if(someWarehouse.getNumWorkers() != 0){
			do{
				someWarehouse.displayWorkers();
				do{
					System.out.print("Enter the number of the worker: ");
					numInput = in.next();
					in.nextLine();
				}while(!isInteger(numInput));
				index = Integer.parseInt(numInput);
				indexCheck = true;
				if(index < 0){
					System.out.print("Invalid entry! Number must be positive!\n");
					indexCheck = false;
				}
				if(index > someWarehouse.getNumWorkers()){
					System.out.print("Invalid entry! Please enter a number in the list.\n");
					indexCheck = false;
				}
			}while(!indexCheck);
			System.out.printf("The wage of %s is %d.\n", someWarehouse.getWorkerName(index), someWarehouse.getWage(index));
			System.out.printf("The hours %s has worked is %d.\n", someWarehouse.getWorkerName(index), someWarehouse.getHours(index));
			System.out.printf("The salary of %s is %d.\n", someWarehouse.getWorkerName(index), someWarehouse.getHours(index));
		}
		else
			System.out.println("There are no workers assigned to this warehouse currently.");
	} // end getWorkerValues
	
	public static void setWorkerValues(int input, ArrayList<Warehouse> warehouses, Warehouse someWarehouse, Scanner in){
		int index = 0, warehouseNumber = 0;
		warehouseNumber = getWarehouseNumber(warehouseNumber, warehouses, someWarehouse,in);
		someWarehouse = warehouses.get(warehouseNumber);
		String changeInput, numInput;
		int wage, hours;
		boolean indexCheck;
		if(someWarehouse.getNumWorkers() !=0){
			do{
				someWarehouse.displayWorkers();
				do{
					System.out.print("Enter the number of the worker: ");
					numInput = in.next();
					in.nextLine();
				}while(!isInteger(numInput));
				index = Integer.parseInt(numInput);
				indexCheck = true;
				if(index < 0){
					System.out.print("Invalid entry! Number must be positive!\n");
					indexCheck = false;
				}
				if(index > someWarehouse.getNumWorkers()){
					System.out.print("Invalid entry! Please enter a number in the list.\n");
					indexCheck = false;
				}
			}while(!indexCheck);
			if(input == 4){
				do
				{
					System.out.printf("Please enter the wage of %s: ", someWarehouse.getWorkerName(index));
					changeInput = in.next();
					in.nextLine();
				}while(!isInteger(changeInput));
				wage = Integer.parseInt(changeInput);
				someWarehouse.setWage(index, wage);
			}
			else if(input == 5){
				do
				{
					System.out.printf("Please enter the hours of %s: ", someWarehouse.getWorkerName(index));
					changeInput = in.next();
					in.nextLine();
				}while(!isInteger(changeInput));
				hours = Integer.parseInt(changeInput);
				someWarehouse.setHours(index, hours);
			}
		}
		else
			System.out.println("There are no workers assigned to this warehouse currently.");
	}
	
	public static int getWarehouseNumber(int number, ArrayList<Warehouse> warehouses, Warehouse someWarehouse, Scanner in){
		String warehouseString;
		do
		{
			System.out.print("Please enter the warehouse number: ");
			warehouseString = in.next();
			in.nextLine();
		}while(!isWarehouseNum(warehouseString, warehouses, someWarehouse));
		number = Integer.parseInt(warehouseString);
		return number - 1; // Subtract 1 from number to account for indexing of ArrayList starting at 0
	} // end getWarehouseNumber
	
	public static boolean isInteger(String s){
		try{
			Integer.parseInt(s);
		}catch(NumberFormatException e){
			System.out.println("Please enter an integer only.");
			return false;
		}
		return true;
	} // end isInteger
	
	public static boolean isDouble(String s){
		try{
			Double.parseDouble(s);
		}catch(NumberFormatException e){
			System.out.println("Please enter a double only.");
			return false;
		}
		return true;
	} // end isDouble
	
	public static boolean isWarehouseNum(String s, ArrayList<Warehouse> warehouses, Warehouse someWarehouse){
		int number = 0;
		if(!isInteger(s))
			return false;
		else 
			number = Integer.parseInt(s);
		if(number <= 0){
			System.out.print("Invalid input! Number of warehouse must be positive!\n");
			return false;
		}
		someWarehouse = warehouses.get(0);
		if(number <= someWarehouse.getNumberBuildings())
			return true;
		if((someWarehouse.getNumberBuildings()) == 1){
			System.out.printf("There is only %d warehouse.\n", someWarehouse.getNumberBuildings()); 
			return false;
		}
		System.out.printf("There are only %d warehouses.\n", someWarehouse.getNumberBuildings()); 
		return false;
	} // end isWarehouseNum
	
	public static void printOutput(ArrayList<Warehouse> warehouses, Warehouse someWarehouse){
		try{
			FileWriter fWrite = new FileWriter("Warehouse.txt", false);
			BufferedWriter bWrite = new BufferedWriter(fWrite);
			PrintWriter pWrite = new PrintWriter(bWrite);
			pWrite.println("Warehouse Manager System Results:");
			pWrite.printf("Total number of buildings mangaged: %d%n", someWarehouse.getNumberBuildings());
			if(!warehouses.isEmpty())
				for(Warehouse printWarehouse : warehouses){
					pWrite.printf("Warehouse name: %s%n", printWarehouse.getName());
					pWrite.printf("Size of %s is %d.%n", printWarehouse.getName(), printWarehouse.getSize());
					pWrite.printf("Total inventory of %s is %d.%n", printWarehouse.getName(), printWarehouse.getInventory());
					pWrite.println("Worker Inforamtion: ");
					pWrite.printf("Total number of workers: %d%n", printWarehouse.getNumWorkers());
					pWrite.printf("%1$15s%2$15s%3$15s%4$15s%n", "Worker Name", "Wage", "Hours", "Salary");
					int count = 0;
					while(count < printWarehouse.getNumWorkers()){
						pWrite.printf("%1$15s%2$15.2f%3$15.2f%4$15.2f%n", printWarehouse.getWorkerName(count), printWarehouse.getWage(count), 
								printWarehouse.getHours(count), printWarehouse.getSalary(count));
						count++;
					}
				}
			
			pWrite.close();
		}
		catch(IOException ioe){
		}
		System.out.print("Exiting program...");
		System.exit(0);
	} // end printOutput
} // end WarehouseTest class