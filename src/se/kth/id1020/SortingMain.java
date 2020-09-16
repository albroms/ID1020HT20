package se.kth.id1020;

import se.kth.id1020.sorting.InsertionSort;
import se.kth.id1020.sorting.MergeSort;

import java.util.Scanner;

public class SortingMain {
    public static void main(String[] args){
        InsertionSort inSort = new InsertionSort();
        MergeSort mSort = new MergeSort();
        //allow user to specify size and values.
        Scanner in = new Scanner(System.in);
        System.out.println("Please specify the desired size of the array.");
        int userArraySize = in.nextInt();
        int[] userArray = new int[userArraySize];
        int[] mergeArray = new int[userArraySize];
        System.out.println("Please enter the desired values in the array, one at a time.\nPress enter after each value.");
        for(int i=0; i<userArraySize; i++){
            if(i != 0)
                System.out.println("Please enter next value.");
            userArray[i] = in.nextInt();
            mergeArray[i] = userArray[i];
        }
        //verify setup correct
        inSort.printArray(userArray);
        mSort.printArray(userArray);

        //count inversions
        inSort.showInversions(userArray);

        //sort array
        inSort.insertionSort(userArray);
        System.out.println("Merge sort:");
        mSort.mergeSort(userArray);
        mSort.printArray(userArray);
    }
}
