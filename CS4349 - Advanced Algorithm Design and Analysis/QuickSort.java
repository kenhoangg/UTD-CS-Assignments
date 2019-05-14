import java.util.Random;

/**
 *	@author Kenny Hoang
 *	Class: CS3345 - Data Structures and Introduction to Algorithmic Analysis
 *	Section: 004
 *	Semester: Spring 2017
 *
 *	Assignment: Project 5
 **/
// Description: Project 5 is the implementation of a program to sort a list of integers
// 				using the 'in place' Quicksort algorithm 
// QuickSort.java implements the 'in place' Quicksort algorithm 

public class QuickSort {
	public void sort(int[] arr, int pivot)
	{
		quickSort(arr, 0,arr.length - 1, pivot);
	}
	
	public static void quickSort(int arr[], int low, int high, int pivotChoice)
	{
		int i = low, j = high;
        int temp, pivot = pivot(arr, pivotChoice, low, high);
        
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
	
	public static int pivot(int[] arr, int pivotChoice, int low, int high){
		Random rand = new Random();
		if(pivotChoice == 2){
			return arr[rand.nextInt((high+1)-low) + low];
		}
		int one, two, three;
		if(pivotChoice == 3){
			one = rand.nextInt((high+1)-low) + low;
			two = rand.nextInt((high+1)-low) + low;
			three = rand.nextInt((high+1)-low) + low;
			if(arr[one] > arr[two]){
				if(arr[two] > arr[three]){
					return arr[two];
				}else if(arr[one] > arr[three]){
					return arr[three];
				}else{
					return arr[one];
				}
			}else{
				if(arr[one] > arr[three]){
					return arr[one];
				}else if(arr[two] > arr[three]){
					return arr[three];
				}else{
					return arr[two];
				}
			}
				
		}
		if(pivotChoice == 4){
			one = arr[low];
			two = arr[(low + (high - low)/ 2)];
			three = arr[high];
			if(one > two){
				if(two > three){
					return two;
				}else if(one > three){
					return three;
				}else{
					return one;
				}
			}else{
				if(one > three){
					return one;
				}else if(two > three){
					return three;
				}else{
					return two;
				}
			}
		}
		return arr[low];
	} //end pivot method
} // end QuickSort class