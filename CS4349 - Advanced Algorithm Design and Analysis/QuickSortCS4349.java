import java.util.Random;

/**
 *	@author Kenny Hoang
 *	Class: CS4349 - Advanced Algorithm Design and Analysis
 *	Section: 002
 *	Semester: Fall 2017
 *
 *	Assignment 4 - Problem 4. Parts A - C
 **/
// Description: Assignment 4 Problem 4 implements quick sort and measures the runtime of the algorithm for integer arrays of 
// 				sizes n = 100, 1000, and 10000.
// QuickSortCS4349.java implements the 'in place' Quicksort algorithm 

public class QuickSortCS4349 {
	public void sort(int[] arr, int pivot)
	{
		quickSort(arr, 0,arr.length - 1, pivot);
	}
	
	public static void quickSort(int arr[], int low, int high, int pivotChoice)
	{
		int i = low, j = high;
		Random rand = new Random();
        int temp, pivot = arr[rand.nextInt((high+1)-low) + low];;
        
        while (i <= j) 
        {
            while (arr[i] < pivot)
                i++;
            while (arr[j] > pivot)
                j--;
            if (i <= j) 
            {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
 
                i++;
                j--;
            }
        }
 
        if (low < j)
            quickSort(arr, low, j, pivotChoice);
        if (i < high)
            quickSort(arr, i, high, pivotChoice);
	}// end quickSort method
} // end QuickSort class