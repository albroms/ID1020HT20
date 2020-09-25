package se.kth.id1020;

import se.kth.id1020.sorting.InsertionSort;
import se.kth.id1020.sorting.MergeSort;
import se.kth.id1020.sorting.QuickSort;

import java.util.Scanner;

public class SortingMain {
    public static void main(String[] args){
        //prepare sorting algorithms and scanner
        InsertionSort inSort = new InsertionSort();
        MergeSort mSort = new MergeSort();
        QuickSort qSort = new QuickSort();
        Scanner in = new Scanner(System.in);

        System.out.println("Please specify the desired size of the array.");
        int userArraySize = in.nextInt();


        System.out.println("\nTasks 1-3:");

        int[] userArray = new int[userArraySize];

        //allow user to specify values. (tasks 1-3)
        /*
        System.out.println("Please enter the desired values in the array, one at a time.\nPress enter after each value.");
        for(int i=0; i<userArraySize; i++){
            if(i != 0)
                System.out.println("Please enter next value.");
            userArray[i] = in.nextInt();
        }

        //count inversions for task 3
        inSort.showInversions(userArray);

        //sort array, task 1-3
        inSort.insertionSort(userArray);

        */
        //Task 5-6:
        System.out.println("\nTask 5-6:");
        //commons

        //prepare generator
        System.out.println("Please specify a seed for the array generator:");
        int randSeed = in.nextInt();
        RandomIntArrayGenerator generator = new RandomIntArrayGenerator(randSeed);
        System.out.println("Please specify minimum value in array:");
        int userMin = in.nextInt();
        System.out.println("Please specify maximum value in array:");
        int userMax = in.nextInt();

        //prepare timer
        Timer timer = new Timer();

        //generate random array and copy
        int[] userArrayTwo = generator.generateArray(userArraySize, userMin, userMax);
        int[] userArrayTwoCopy = generator.generateCopyOfArray(userArray);

        //task 5:
        /*
        //time sorting algorithms average case for insertion sort.
        System.out.println("Average case for insertion sort:");
        timer.reset();
        inSort.insertionSort(userArrayTwo);
        System.out.println("Insertion sort took " + timer.getRunTime() + " ms.");

        timer.reset();
        mSort.mergeSort(userArrayTwoCopy);
        System.out.println("Merge sort took " + timer.getRunTime() + " ms.");

        //time sorting algorithms worst case for insertionsort.
        int[] descending = generator.generateSortedDescending(userArraySize);
        int[] descendingCopy = generator.generateCopyOfArray(descending);

        System.out.println("Worst case for insertion sort:");
        timer.reset();
        inSort.insertionSort(descending);
        System.out.println("Insertionsort took " + timer.getRunTime() + " ms.");

        timer.reset();
        mSort.mergeSort(descendingCopy);
        System.out.println("Mergesort took " + timer.getRunTime() + " ms.");

        //time sorting algorithms best case for insertionsort.
        int[] ascending = generator.generateSortedAscending(userArraySize);
        int[] ascendingCopy = generator.generateCopyOfArray(ascending);

        System.out.println("Best case for insertion sort:");

        timer.reset();
        inSort.insertionSort(ascending);
        System.out.println("Insertionsort took " + timer.getRunTime() + " ms.");

        timer.reset();
        mSort.mergeSort(ascendingCopy);
        System.out.println("Mergesort took " + timer.getRunTime() + " ms.");

        */


        //task 6
        for(int i=0; i<=30; i++){
            //fix new array
            int[] a = generator.generateArray(userArraySize, userMin, userMax);

            //reset timer
            timer.reset();
            //sort
            mSort.mergeSortCutoff(a, i);
            System.out.println("Sorting took " + timer.getRunTime() + " ms with cutoff " + i);
        }

        /*
        //Extra task 1:
        System.out.println("\nExtra task 1:");
        int[] descendArray = new int[]{1, 2, 4, 3, 5, 0};
        inSort.insertionSortDescending(descendArray);
        System.out.print("After descending sort, ");
        inSort.printArray(descendArray);

        //Extra task 2:
        System.out.println("\nExtra task 2:");

        int[] quickSortArray = generator.generateArray(userArraySize, userMin, userMax);
        int[] mergeSortArray = generator.generateCopyOfArray(quickSortArray);

        System.out.println("\nRandom array:");
        timer.reset();
        qSort.quickSort(quickSortArray);
        System.out.println("Quicksort took " + timer.getRunTime() + "ms.");
        timer.reset();
        mSort.mergeSort(mergeSortArray);
        System.out.println("Mergesort took " + timer.getRunTime() + "ms.");

        System.out.println("\nAlready sorted:");
        quickSortArray = generator.generateSortedAscending(userArraySize);
        mergeSortArray = generator.generateCopyOfArray(quickSortArray);
        timer.reset();
        qSort.quickSort(quickSortArray);
        System.out.println("Quicksort took " + timer.getRunTime() + "ms.");
        timer.reset();
        mSort.mergeSort(mergeSortArray);
        System.out.println("Mergesort took " + timer.getRunTime() + "ms.");

        System.out.println("\nArray with identical items:");
        quickSortArray = generator.generateArrayWithOnes(userArraySize);
        mergeSortArray = generator.generateCopyOfArray(quickSortArray);
        timer.reset();
        qSort.quickSort(quickSortArray);
        System.out.println("Quicksort took " + timer.getRunTime() + "ms.");
        timer.reset();
        mSort.mergeSort(mergeSortArray);
        System.out.println("Mergesort took " + timer.getRunTime() + "ms.");

         */
    }
}
