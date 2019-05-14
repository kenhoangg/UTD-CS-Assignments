/**
 *	@author Kenny Hoang
 *	Class: CS4349 - Advanced Algorithm Design and Analysis
 *	Section: 002
 *	Semester: Fall 2017
 *
 *	Assignment 1 - Problem 2. Parts A - C
 **/
// Description: Assignment 1 Problem 2 implements insertion and merge sorts and measures the runtime of each algorithm for integer arrays of 
// 				sizes n = 100, 1000, and 10000. MergeSort.java in particular implements the MergeSort.



public class MergeSort {
	
	private int[] array;
    private int[] temp;
    private int length;
	
	public void sort(int inputArr[]) {
        this.array = inputArr;
        this.length = inputArr.length;
        this.temp = new int[length];
        merge(0, length - 1);     
    }
	
	private void merge(int lowerIndex, int higherIndex) {
        
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            merge(lowerIndex, middle);
            // Below step sorts the right side of the array
            merge(middle + 1, higherIndex);
            // Now merge both sides
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }
	
	private void mergeParts(int lowerIndex, int middle, int higherIndex) {
		 
        for (int i = lowerIndex; i <= higherIndex; i++) {
            temp[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (temp[i] <= temp[j]) {
                array[k] = temp[i];
                i++;
            } else {
                array[k] = temp[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = temp[i];
            k++;
            i++;
        }
 
    }
}
