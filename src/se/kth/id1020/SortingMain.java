package se.kth.id1020;

import se.kth.id1020.sorting.InsertionSort;
import se.kth.id1020.sorting.MergeSort;

import java.util.Scanner;

public class SortingMain {
    public static void main(String[] args){
        //prepare sorting algorithms and scanner
        InsertionSort inSort = new InsertionSort();
        MergeSort mSort = new MergeSort();
        //QuickSort qSort = new QuickSort();
        Scanner in = new Scanner(System.in);

        System.out.println("Please specify the desired size of the array.");
        int userArraySize = in.nextInt();

        /*
        //Tasks 1-3:


        //allow user to specify values.
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

        //count inversions for task 3
        inSort.showInversions(userArray);

        //sort array, task 1-3
        inSort.insertionSort(userArray);
        System.out.println("Merge sort:");

         */

        //Task 5-6:

        //create random arrays
        System.out.println("Please specify a seed for the array generator:");
        int randSeed = in.nextInt();
        RandomIntArrayGenerator generator = new RandomIntArrayGenerator(randSeed);
        System.out.println("Please specify minimum value in array:");
        int userMin = in.nextInt();
        System.out.println("Please specify maximum value in array:");
        int userMax = in.nextInt();
        int[] userArray = generator.generateArray(userArraySize, userMin, userMax);
        int[] userArrayCopy = generator.generateCopyOfArray(userArray);

        //time sorting algorithms average case for insertionsort.
        System.out.println("Average case for insertionsort:");
        Timer inSortTimer = new Timer();
        inSort.insertionSort(userArray);
        System.out.println("Insertion sort took " + inSortTimer.getRunTime() + " ms.");

        Timer mSortTimer = new Timer();
        mSort.mergeSort(userArrayCopy);
        System.out.println("Merge sort took " + mSortTimer.getRunTime() + " ms.");

        //time sorting algorithms worst case for insertionsort.
        int[] descending = generator.generateSortedDescending(userArraySize);
        int[] descendingCopy = generator.generateCopyOfArray(descending);

        System.out.println("Worst case for insertion sort:");
        inSortTimer.reset();
        inSort.insertionSort(descending);
        System.out.println("Insertionsort took " + inSortTimer.getRunTime() + " ms.");

        mSortTimer.reset();
        mSort.mergeSort(descendingCopy);
        System.out.println("Mergesort took " + mSortTimer.getRunTime() + " ms.");

        //time sorting algorithms best case for insertionsort.
        int[] ascending = generator.generateSortedAscending(userArraySize);
        int[] ascendingCopy = generator.generateCopyOfArray(ascending);

        System.out.println("Best case for insertion sort:");

        inSortTimer.reset();
        inSort.insertionSort(ascending);
        System.out.println("Insertionsort took " + inSortTimer.getRunTime() + " ms.");

        mSortTimer.reset();
        mSort.mergeSort(ascendingCopy);
        System.out.println("Mergesort took " + mSortTimer.getRunTime() + " ms.");
    }
}
