/**
 *	@author Kenny Hoang
 *	Class: CS4349 - Advanced Algorithm Design and Analysis
 *	Section: 002
 *	Semester: Fall 2017
 *
 *	Assignment 5 - Problem 3. Parts A - B
 **/
// Description: Assignment 5 Problem 3 implements counting, radix, and bucket sorts and measures the runtime of each algorithm for integer arrays of 
// 				size 1000, sorted in increasing order, sorted in decreasing order, and randomly generated.
// CRBSortRunTimeTest.java defines the main method and other functions for input validation.


import java.util.*;

public class CRBSortRunTimeTest {

	public static void main(String[] args) {
		CountingSort counting = new CountingSort();
		RadixSort radix = new RadixSort();
		BucketSort bucket = new BucketSort();

		int arrSize = 1000;
		
		// Initailize the arrays to be sorted
		int ascendArr[] = new int[arrSize];
		int descendArr[] = new int[arrSize];
		int unsortArr[] = new int[arrSize];
		int sameArr[] = new int [arrSize];
		
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
		
		// Use Quicksort to get a sorted array of ascending order
		QuickSort quick = new QuickSort();
		quick.sort(ascendArr, 1);
		
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

		// Do Counting, Radix, and Bucket sorts, use System.currentTimeMillis() to find time
		// record current time -> run algorithm -> record end time, then subtract end from start and print
		
		// Case 1: Running time of a sorted array of ascending order
		
		for(int i = 0; i < arrSize; i++)
		{
			sameArr[i] = ascendArr[i];
		}
		
		// Measuring run time of CountingSort on an array of ascending order
		long startTimeCounting1 = System.nanoTime();
		counting.sort(sameArr);
		long endTimeCounting1 = System.nanoTime();
		long totalTimeCounting1 = endTimeCounting1 - startTimeCounting1;
		
		for(int i = 0; i < arrSize; i++)
		{
			sameArr[i] = ascendArr[i];
		}
		
		// Measuring run time of RadixSort on an array of ascending order
		long startTimeRadix1 = System.nanoTime();
		radix.sort(sameArr);
		long endTimeRadix1 = System.nanoTime();
		long totalTimeRadix1 = endTimeRadix1 - startTimeRadix1;

		for(int i = 0; i < arrSize; i++)
		{
			sameArr[i] = ascendArr[i];
		}
		
		// Measuring run time of BucketSort on an array of ascending order
		long startTimeBucket1 = System.nanoTime();
		bucket.sort(sameArr);
		long endTimeBucket1 = System.nanoTime();
		long totalTimeBucket1 = endTimeBucket1 - startTimeBucket1;
		
		// Case 2: Running time of a sorted array of descending order

		for(int i = 0; i < arrSize; i++)
		{
			sameArr[i] = descendArr[i];
		}
		
		// Measuring run time of CountingSort on an array of descending order
		long startTimeCounting2 = System.nanoTime();
		counting.sort(sameArr);
		long endTimeCounting2 = System.nanoTime();
		long totalTimeCounting2 = endTimeCounting2 - startTimeCounting2;
		
		for(int i = 0; i < arrSize; i++)
		{
			sameArr[i] = descendArr[i];
		}
		
		// Measuring run time of RadixSort on an array of descending order
		int sameArr4[] = {5, 3, 0, 2, 4, 1, 0, 5, 2, 3, 1, 4};
		long startTimeRadix2 = System.nanoTime();
		radix.sort(sameArr4);
		long endTimeRadix2 = System.nanoTime();
		long totalTimeRadix2 = endTimeRadix2 - startTimeRadix2;

		for(int i = 0; i < arrSize; i++)
		{
			sameArr[i] = descendArr[i];
		}
		
		// Measuring run time of BucketSort on an array of descending order
		int sameArr5[] = {5, 3, 0, 2, 4, 1, 0, 5, 2, 3, 1, 4};
		long startTimeBucket2 = System.nanoTime();
		bucket.sort(sameArr5);
		long endTimeBucket2 = System.nanoTime();
		long totalTimeBucket2 = endTimeBucket2 - startTimeBucket2;
		
		// Case 3: Running time of an unsorted (random) array
		
		for(int i = 0; i < arrSize; i++)
		{
			sameArr[i] = unsortArr[i];
		}
		
		// Measuring run time of CountingSort on a randomly generated array
		long startTimeCounting3 = System.nanoTime();
		counting.sort(sameArr);
		long endTimeCounting3 = System.nanoTime();
		long totalTimeCounting3 = endTimeCounting3 - startTimeCounting3;
		
		for(int i = 0; i < arrSize; i++)
		{
			sameArr[i] = unsortArr[i];
		}
		
		// Measuring run time of RadixSort on a randomly generated array
		long startTimeRadix3 = System.nanoTime();
		radix.sort(sameArr);
		long endTimeRadix3 = System.nanoTime();
		long totalTimeRadix3 = endTimeRadix3 - startTimeRadix3;

		for(int i = 0; i < arrSize; i++)
		{
			sameArr[i] = unsortArr[i];
		}
		
		// Measuring run time of BucketSort on a randomly generated array
		long startTimeBucket3 = System.nanoTime();
		bucket.sort(sameArr);
		long endTimeBucket3 = System.nanoTime();
		long totalTimeBucket3 = endTimeBucket3 - startTimeBucket3;

		

		System.out.printf("%39s%21s%24s\n","Counting Sort", "Radix Sort", "Bucket Sort");
		System.out.printf("%-20s%14d ns%20d ns%20d ns\n", "Ascending Order:",totalTimeCounting1, totalTimeRadix1, totalTimeBucket1);
		System.out.printf("%-20s%14d ns%20d ns%20d ns\n", "Descending Order:",totalTimeCounting2, totalTimeRadix2, totalTimeBucket2);
		System.out.printf("%-20s%14d ns%20d ns%20d ns\n", "Unsorted:",totalTimeCounting3, totalTimeRadix3, totalTimeBucket3);

	}
}
