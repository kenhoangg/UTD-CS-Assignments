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
// BucketSort.java implements the Bucket Sort algorithm


public class BucketSort {
	public void sort(int[] array) {
		int maxVal = getMax(array, array.length);
		sort(array, maxVal);
    }

	static int getMax(int[] arr, int n)
    {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }
	
    private static void sort(int[] array, int maxVal) {
    	int bucket[] = new int[maxVal+1];
    	 
        for (int i=0; i<bucket.length; i++) {
           bucket[i]=0;
        }
   
        for (int i=0; i<array.length; i++) {
           bucket[array[i]]++;
        }
   
        int outPos=0;
        for (int i=0; i<bucket.length; i++) {
           for (int j=0; j<bucket[i]; j++) {
              array[outPos++]=i;
           }
        }
    }
}
