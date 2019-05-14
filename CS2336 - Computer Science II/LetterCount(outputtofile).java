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
				if(!upperCount(nextChar, numUpper))
					lowerCount(nextChar, numLower);
			}
		}
		printCount(numUpper, numLower, fileName);
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
	
	public static void printCount(int[] upper, int[] lower, String name)
	{
		char[] upperAlpha = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
				'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		char[] lowerAlpha = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
				'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

		try{
			FileWriter fWrite = new FileWriter(name, true);
			BufferedWriter bWrite = new BufferedWriter(fWrite);
			PrintWriter pWrite = new PrintWriter(bWrite);
			pWrite.println("");
			
			for(int i = 0; i < 26; i++)
			{
				pWrite.printf("Number of %c's: %d", upperAlpha[i], upper[i]);
				pWrite.println("");
			}
			
			for(int j = 0; j < 26; j++)
			{
				pWrite.printf("Number of %c's: %d", lowerAlpha[j], lower[j]);
				pWrite.println("");
			}
			
			pWrite.close();
		}
		catch(IOException ioe){
		}
	}
}

