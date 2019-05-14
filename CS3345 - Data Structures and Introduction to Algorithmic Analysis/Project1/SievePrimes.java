/*
 * @author Kenny Hoang
 * Class: CS3345 - Data Structures and Introduction to Algorithm Analysis
 * Section: 004
 * Semester: Spring 2017
 * Date: 1-24-2017
 * Instructor: Anjum Chida
 * Description: Project 1 - This program receives a integer value n and prints 
 * all primes up till n using the Sieve of Eratosthenes algorithm.
 */

// Import statements
import java.util.Scanner;

public class SievePrimes {
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		int n = -1;
		boolean check = false;
		do{
			System.out.print("Please enter a positive integer value for n: ");
			if(scan.hasNextInt()){
				n = scan.nextInt();
				check = true;
			}
			else
			{
				System.out.println("Invalid input! Please enter an positive integer value for n.");
				scan.nextLine();
			}
		}
		while(!check);
		scan.close();
		System.out.printf("The prime numbers less than %d are: ", n);
		sieve(n);
	}
	
	public static void sieve(int n)
	{
		int isPrime[] = new int[n];
		for(int i = 0; i < n; i++)
			isPrime[i] = 1;
		
		for(int j = 2; j * j <= n; j++)
		{
			if(isPrime[j] == 1)
			{
				for(int k = j * 2; k < n; k += j)
					isPrime[k] = 0;
			}
		}
		
		for(int l = 2; l < n; l++)
		{
			if(isPrime[l] == 1)
				System.out.print(l + " ");
		}
	}
}
