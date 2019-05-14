/**
 *	@author Kenny Hoang
 *	Class: CS4349 - Advanced Algorithm Design and Analysis
 *	Section: 002
 *	Semester: Fall 2017
 *
 *	Assignment 4 - Problem 4. Parts A - C
 **/
// Description: Assignment 2 Problem 4 implements quick sort and measures the runtime of the algorithm for integer arrays of 
// 				sizes n = 100, 1000, and 10000.
// QuickSortRunTimeTest.java defines the main method and other functions for input validation.



import java.util.Scanner;
import java.util.Random;

public class QuickSortRunTimeTest {

	public static void main(String[] args) {
		QuickSort sortList = new QuickSort();
		String input;
		// Initailize the arrays to be sorted
		int hundArr[] = new int[100];
		int thousArr[] = new int[1000];
		int tenthousArr[] = new int[10000];
		
		
		Random rand = new Random();
		
		// Populate the unsorted array with random integers
		// Only populate the unsorted array and use the 
		// unsorted array to populate the other arrays
		// to stay consistent with values between the arrays
		for(int i = 0; i < 100; i++)
		{
			hundArr[i] = rand.nextInt(100 - 1) + 1;
		}
		
		for(int i = 0; i < 1000; i++)
		{
			thousArr[i] = rand.nextInt(1000 - 1) + 1;
		}
		
		for(int i = 0; i < 10000; i++)
		{
			tenthousArr[i] = rand.nextInt(10000 - 1) + 1;
		}

		// Do both Quicksort for all three sizes, use System.currentTimeMillis() to find time
		// record current time -> run algorithm -> record end time, then subtract end from start and print
		
		// Case 1: Running time of Array Size 100
		
		// Measuring run time of Quicksort on an array of 100
		long startTimeQuickSort1 = System.nanoTime();
		sortList.sort(hundArr, 2); // 2 is the random pivot for quicksort
		long endTimeQuickSort1 = System.nanoTime();
		long totalTimeQuickSort1 = endTimeQuickSort1 - startTimeQuickSort1;
		

		
		// Case 2: Running time of Array Size 1000
		
		// Measuring run time of Quicksort on an array of 1000
		long startTimeQuickSort2 = System.nanoTime();
		sortList.sort(thousArr, 2); // 2 is the random pivot for quicksort
		long endTimeQuickSort2 = System.nanoTime();
		long totalTimeQuickSort2 = endTimeQuickSort2 - startTimeQuickSort2;

		
		// Case 3: Running time of Array Size 10000
		
		// Measuring run time of Quicksort on an array of 10000
		long startTimeQuickSort3 = System.nanoTime();
		sortList.sort(tenthousArr, 2); // 2 is the random pivot for quicksort
		long endTimeQuickSort3 = System.nanoTime();
		long totalTimeQuickSort3 = endTimeQuickSort3 - startTimeQuickSort3;
		

		// Case 4: Running time of best case Array Size 100
		int bestArr[] = new int[100];
		for(int i = 0; i < 100; i++)
		{
			bestArr[i] = rand.nextInt(100 - 1) + 1;
		}
		sortList.sort(bestArr, 2);
		
		long startTimeQuickSort4 = System.nanoTime();
		sortList.sort(bestArr, 2);
		long endTimeQuickSort4 = System.nanoTime();
		long totalTimeQuickSort4 = endTimeQuickSort4 - startTimeQuickSort4;
		
		// Case 5: Running time of worst case Array Size 100 
		int worstArr[] = new int[100];
		
		for(int i = 0; i < 100; i++)
		{
			worstArr[i] = rand.nextInt(100 - 1) + 1;
		}
		worstArr[0] = 0;
		worstArr[99] = 99;
		
		long startTimeQuickSort5 = System.nanoTime();
		sortList.sort(worstArr, 2);
		long endTimeQuickSort5 = System.nanoTime();
		long totalTimeQuickSort5 = endTimeQuickSort5 - startTimeQuickSort5;
		
		
		// Print out times
		System.out.printf("%39s\n","QuickSort Time");
		System.out.printf("%-20s%14d ns\n", "Size 100:", totalTimeQuickSort1);
		System.out.printf("%-20s%14d ns\n", "Size 1000:", totalTimeQuickSort2);
		System.out.printf("%-20s%14d ns\n", "Size 10000:", totalTimeQuickSort3);
		System.out.printf("%-20s%14d ns\n", "Best Case 100:", totalTimeQuickSort4);
		System.out.printf("%-20s%14d ns\n", "Worst Case 100:", totalTimeQuickSort5);
	}
}
