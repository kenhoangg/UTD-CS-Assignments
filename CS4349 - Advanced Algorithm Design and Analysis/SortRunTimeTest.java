/**
 *	@author Kenny Hoang
 *	Class: CS4349 - Advanced Algorithm Design and Analysis
 *	Section: 002
 *	Semester: Fall 2017
 *
 *	Assignment 1 - Problem 2. Parts A - C
 **/
// Description: Assignment 1 Problem 2 implements insertion and merge sorts and measures the runtime of each algorithm for integer arrays of 
// 				sizes n = 100, 1000, and 10000.
// SortRunTimeTest.java defines the main method and other functions for input validation.



import java.util.Scanner;
import java.util.Random;

public class SortRunTimeTest {

	public static void main(String[] args) {
		InsertionSort insertion = new InsertionSort();
		MergeSort merge = new MergeSort();
		QuickSort sortList = new QuickSort();
		Scanner scan = new Scanner(System.in);
		String input;
		int arrSize = 0;
		System.out.print("Sort Algorithm Analysis\n\tEnter the array size: ");
		while(!scan.hasNextInt()){
			input = scan.nextLine();
			System.out.printf("%s is invalid input! Please enter a number for the array size.", input);
		}
		if(scan.hasNextInt()){
			arrSize = scan.nextInt();
			scan.nextLine();
		}
		scan.close();
		// Initailize the arrays to be sorted
		int ascendArr[] = new int[arrSize];
		int descendArr[] = new int[arrSize];
		int unsortArr[] = new int[arrSize];
		
		
		Random rand = new Random();
		
		// Populate the unsorted array with random integers
		// Only populate the unsorted array and use the 
		// unsorted array to populate the other arrays
		// to stay consistent with values between the arrays
		for(int i = 0; i < arrSize; i++)
		{
			unsortArr[i] = rand.nextInt(arrSize - 1) + 1;
		}
		
		// Fill ascending array with unsorted array 
		for(int i = 0; i < arrSize; i++)
		{
			ascendArr[i] = unsortArr[i];
		}
		
		// Use QuickSort to get a sorted array of ascending order
		sortList.sort(ascendArr, 1);
		
		// Fill descending with sorted ascending array elements
		for(int i = 0; i < arrSize; i++)
		{
			descendArr[i] = ascendArr[i];
		}
		
		// Reverse the descending array containing ascending elements
		int temp[] = new int[arrSize];
		for(int j = 0; j < arrSize; j++)
		{
			temp[j] = descendArr[j];
		}
		for(int k = arrSize; k > 0; k--)
		{
			descendArr[arrSize - k] = temp[k-1];
		}

		// Do both InsertionSort and MergeSort for both, use System.currentTimeMillis() to find time
		// record current time -> run algorithm -> record end time, then subtract end from start and print
		
		// Case 1: Running time of a sorted array of ascending order
		
		// Measuring run time of InsertionSort on an array of ascending order
		long startTimeInsertion1 = System.nanoTime();
		insertion.insertionSort(ascendArr);
		long endTimeInsertion1 = System.nanoTime();
		long totalTimeInsertion1 = endTimeInsertion1 - startTimeInsertion1;
		
		// Measuring run time of MergeSort on an array of ascending order
		long startTimeMerge1 = System.nanoTime();
		merge.sort(ascendArr);
		long endTimeMerge1 = System.nanoTime();
		long totalTimeMerge1 = endTimeMerge1 - startTimeMerge1;

		
		// Case 2: Running time of a sorted array of descending order
		
		// Measuring run time of InsertionSort on an array of descending order
		long startTimeInsertion2 = System.nanoTime();
		insertion.insertionSort(descendArr);
		long endTimeInsertion2 = System.nanoTime();
		long totalTimeInsertion2 = endTimeInsertion2- startTimeInsertion2;

		// Measuring run time of MergeSort on an array of ascending order
		long startTimeMerge2 = System.nanoTime();
		merge.sort(descendArr);
		long endTimeMerge2 = System.nanoTime();
		long totalTimeMerge2 = endTimeMerge2 - startTimeMerge2;

		
		// Case 3: Running time of an unsorted (random) array
		
		// Measuring run time of InsertionSort on an unsorted array
		long startTimeInsertion3 = System.nanoTime();
		insertion.insertionSort(unsortArr);
		long endTimeInsertion3 = System.nanoTime();
		long totalTimeInsertion3 = endTimeInsertion3- startTimeInsertion3;
		
		// Measuring run time of MergeSort on an unsorted array
		long startTimeMerge3 = System.nanoTime();
		merge.sort(unsortArr);
		long endTimeMerge3 = System.nanoTime();
		long totalTimeMerge3 = endTimeMerge3 - startTimeMerge3;

		
		System.out.printf("%39s%21s\n","InsertionSort", "MergeSort");
		System.out.printf("%-20s%14d ns%20d ns\n", "Ascending Order:",totalTimeInsertion1, totalTimeMerge1);
		System.out.printf("%-20s%14d ns%20d ns\n", "Descending Order:",totalTimeInsertion2, totalTimeMerge2);
		System.out.printf("%-20s%14d ns%20d ns\n", "Unsorted:", totalTimeInsertion3, totalTimeMerge3);
	}
}
