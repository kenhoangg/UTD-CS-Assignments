/**
 *	@author Kenny Hoang
 *	Class: CS4349 - Advanced Algorithm Design and Analysis
 *	Section: 002
 *	Semester: Fall 2017
 *
 *	Assignment 1 - Problem 2. Parts A - C
 **/
// Description: Assignment 1 Problem 2 implements insertion and merge sorts and measures the runtime of each algorithm for integer arrays of 
// 				sizes n = 100, 1000, and 10000. InsertionSort.java in particular implements the InsertionSort.



public class InsertionSort {
	    public void insertionSort(int array[]) {
	        int n = array.length;
	        for (int j = 1; j < n; j++) {
	            int key = array[j];
	            int i = j-1;
	            while ( (i > -1) && ( array [i] > key ) ) {
	                array [i+1] = array [i];
	                i--;
	            }
	            array[i+1] = key;
	        }
	    }
}
