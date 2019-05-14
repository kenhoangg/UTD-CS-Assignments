/**
 *	@author Kenny Hoang
 *	Class: CS2336 - Computer Science II
 *	Section: 001	
 *	Semester: Fall 2016
 *
 *	Assignment: Assignment 6 - Letter Count
 *	Program Description: This program reads a file and displays
 *	the number of times a letter in in the file.
 **/

// Import Statements
import java.util.Scanner;
import java.io.*;

public class LetterCount {

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		String fileName;
		char nextChar;
		File file;
		int[] numUpper = new int[26];
		int[] numLower = new int[26];
		int[] numDigits = new int[10];
		do{
			System.out.print("Enter a filename: ");
			fileName = scan.next();
			file = new File(fileName);
			if(file.exists())
				break;
			System.out.printf("The file \"%s\" does not exist.\n", fileName);
		}
		while(true);
		
		try{
			Scanner fileIn = new Scanner(file);
		
		while(fileIn.hasNext())
		{
			String str = fileIn.next();
			char[] cArray = str.toCharArray();
			for(int i = 0; i < str.length(); i++)
			{
				nextChar = cArray[i];
				if(!digitCount(nextChar, numDigits))
					if(!upperCount(nextChar, numUpper))
						lowerCount(nextChar, numLower);
			}
		}
		printCount(numUpper, numLower, numDigits,fileName);
		scan.close();
		fileIn.close();
		}
		catch(FileNotFoundException e){
		}
	}
	
	public static boolean upperCount(char c, int[] upper)
	{
		if(c < 'A' || c > 'Z')
			return false;
		int valueChar = (int) c;
		valueChar -= 65;
		upper[valueChar]++;
		return true;
	}
	
	public static boolean lowerCount(char c, int[] lower)
	{
		if(c < 'a' || c > 'z')
			return false;
		int valueChar = (int) c;
		valueChar -= 97;
		lower[valueChar]++;
		return true;
	}
	
	public static boolean digitCount(char c, int [] digit)
	{
		if(c < '0' || c > '9')
			return false;
		int valueChar = (int) c;
		valueChar -= 48;
		digit[valueChar]++;
		return true;
	}
	
	public static void printCount(int[] upper, int[] lower, int [] digit,String name)
	{
		char[] upperAlpha = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
				'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		char[] lowerAlpha = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
				'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
		char[] cDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		
			for(int i = 0; i < 26; i++)
			{
				System.out.printf("Number of %c's: %d\n", upperAlpha[i], upper[i]);
			}
			
			for(int j = 0; j < 26; j++)
			{
				System.out.printf("Number of %c's: %d\n", lowerAlpha[j], lower[j]);
			}
			
			for(int k = 0; k < 10; k++)
			{
				System.out.printf("Number of %c's: %d\n", cDigits[k], digit[k]);
			}
	}
}

