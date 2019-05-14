/**
 *	@author Kenny Hoang
 *	Class: CS2336 - Computer Science II
 *	Section: 001	
 *	Semester: Fall 2016
 *
 *	Assignment: Assignment 4 - isSorted Method
 *	Program Description: This program utilizes the isSorted Method to 
 *	determine if a integer list is sorted in ascending order.
 **/

public class TestSorted {

	public static void main(String[] args) {
		int[] list = new int[args.length];
			for(int i = 0; i < args.length; i++)
			{
				if(isInteger(args[i]))
					list[i] = Integer.parseInt(args[i]);
				else
				{
					break;
				}
			}
		if(args.length == 0)
				System.out.println("The list is empty.");
		else if(isSorted(list))
				System.out.println("The list is sorted in increasing order.");
		else if(!isSorted(list))
				System.out.println("The list is not sorted in increasing order.");
	}
	
	public static boolean isSorted(int[] list)
	{
		int small, big;
		for(int j = 0; j < list.length - 1; j++)
		{
			small = list[j];
			big = list[j+1];
			if(small > big)
				return false;
		}
		return true;
	}
	
	public static boolean isInteger(String s)
	{
		try{
			Integer.parseInt(s);
		}catch(NumberFormatException e) {
			System.out.println("Please enter list of integers only.\nProgram will now exit.");
			System.exit(1);
		}
		return true;
	}	
}