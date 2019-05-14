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
// CountingSort.java implements the Counting Sort algorithm


public class CountingSort {
	void sort(int[] arr)
    {
        int n = arr.length;
 
        // The array that will have sorted arr
        int[] temp = new int[n];
 
        // Create a count array to store count of individual
        // characters and initialize count array as 0
        int[] count = new int[1000];
        for (int i=0; i<1000; ++i)
            count[i] = 0;
 
        // store count of each character
        for (int i=0; i<n; ++i)
            ++count[arr[i]];
 
        // Change count[i] so that count[i] now contains actual
        // position of this character in output array
        for (int i=1; i<=999; ++i)
            count[i] += count[i-1];
 
        // Build the temp character array
        for (int i = 0; i<n; ++i)
        {
            temp[count[arr[i]]-1] = arr[i];
            --count[arr[i]];
        }
 
        // Copy the temp array to arr, so that arr is now sorted
        for (int i = 0; i<n; ++i)
            arr[i] = temp[i];
    }
}
