/**
 *	@author Kenny Hoang
 *	Class: CS2336 - Computer Science II
 *	Section: 001	
 *	Semester: Fall 2016
 *
 *	Assignment: Assignment 8 - Baby Name Ranking
 *	Program Description: This program prompts user for input of 
 *	a year and name, and displays the ranking for the name.
 **/

// Import Statements
import java.util.Scanner;

public class NameRanking {

	public static void main(String[] args) 
	{
		int year;
		String gender, name;
		boolean status = true;
		Scanner input = new Scanner(System.in);
		do
		{
			year = getYear(input);
			// Populate array of map
			gender = getGender(input);
			name = getName(input);
			status = getInquiryStatus(input);
		}while(status);
	}

	public static int getYear(Scanner in)
	{
		int year = 0;
		System.out.print("Enter the year: ");
		while(!in.hasNextInt())
		{
			in.nextLine();
			System.out.print("Error! Enter numberical values for the year only. \nEnter the year: ");
		}
		if(in.hasNextInt())
		{
			year = in.nextInt();
			in.nextLine();
		}
		if(!checkYear(year))
			getYear(in);
		return year;
	}
	
	public static boolean checkYear(int year)
	{
		if(year > 2015 || year < 2006)
		{
			System.out.println("Year entered should be between 2006 and 2015.");
			return false;
		}
		return true;
	}
	
	public static String getGender(Scanner in)
	{
		System.out.print("Enter the gender: ");
		String gender = in.next();
		if(!gender.equalsIgnoreCase("M") && !gender.equalsIgnoreCase("F"))
			getGender(in);
		return gender;
	}
	
	public static String getName(Scanner in)
	{
		System.out.print("Enter the name: ");
		String name = in.next();
		return name;
	}
	
	public static boolean getInquiryStatus(Scanner in)
	{
		System.out.print("Enter another inquiry? (Y/N) ");
		String stat = in.next();
		if(!stat.equalsIgnoreCase("Y") && !stat.equals("N"))
			getInquiryStatus(in);
		if(stat.equalsIgnoreCase("Y"))
			return true;
		return false;
		
	}
}
