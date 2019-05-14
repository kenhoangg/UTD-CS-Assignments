/**
 *	@author Kenny Hoang
 *	Class: CS2336 - Computer Science II
 *	Section: 001	
 *	Semester: Fall 2016
 *
 *	Assignment: Assignment 5 - Linear Equation
 *	Program Description: This program utilizes the LinearEquation class to 
 *	calculate and display a system of equations.
 **/

// Import statements
import java.util.Scanner;

public class LinearEquationTest {
	public static void main(String [] args)
	{
		double a = 0, b = 0, c = 0, d = 0, e = 0, f = 0;
		double [] dArray = new double[6];
		Scanner input = new Scanner(System.in);
		String[] values = new String[6];
		int count = 0;
		boolean valid = true;
		do{
			System.out.print("Enter a, b, c, d, e, f: ");
			while(input.hasNext())
			{
				values[count] = input.next();
				count++;
				
				if(count > 5)
					break;
			}
			if(checkDoubles(values))
				valid = false;
			count = 0;
		}while(valid);
		
		fillArray(values, dArray);
		
		a = dArray[0];
		b = dArray[1];
		c = dArray[2];
		d = dArray[3];
		e = dArray[4];
		f = dArray[5];
		
		LinearEquation equation1 = new LinearEquation(a, b, c, d, e, f);
		
		if(!equation1.isSolvable())
			System.out.println("The equation has no solution.");
		else
			System.out.println("x is "+ equation1.getX() + " and y is " + equation1.getY());
		
		input.close();
	}
	
	public static boolean checkDoubles(String[] values)
	{
		boolean allDoubles = true;
		for(int i = 0; i < 6; i++)
		{
			try{
				Double.parseDouble(values[i]);
			}catch(NumberFormatException e) {
				System.out.println("Please enter list of doubles only.");
				allDoubles = false;
				break;
			}
		}
		if(allDoubles == false)
			return false;
		return true;
	}
	
	public static void fillArray(String[] values, double[] dArray)
	{
		for(int i = 0; i < 6; i++)
			dArray[i] = Double.parseDouble(values[i]);
	}
}
