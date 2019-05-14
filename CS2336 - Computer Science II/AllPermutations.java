/**
 *	@author Kenny Hoang
 *	Class: CS2336 - Computer Science II
 *	Section: 001	
 *	Semester: Fall 2016
 *
 *	Assignment: Assignment 7 - All Permutations
 *	Program Description: This program reads in a string from keyboard
 *	and then displays all permutations of the inputted string.
 **/

//	Import Statements
import java.util.Scanner;

public class AllPermutations 
{

	public static void main(String[] args) 
	{
		System.out.print("Enter a string: ");
		Scanner input = new Scanner(System.in);
		String str = input.next();
		displayPermutation(str);
		input.close();
	}

	public static void displayPermutation(String str)
	{
		System.out.printf("All permutations of %s:\n", str);
		displayPermutation("", str);
	}
	
	public static void displayPermutation(String str1, String str2)
	{
		if(str2.length() == 0)
		{
			System.out.println(str1);
		}
		else
			for(int i = 0; i < str2.length(); i++)
				displayPermutation(str1 + str2.charAt(i), str2.substring(0,i) + str2.substring(i+1));
	}
}
