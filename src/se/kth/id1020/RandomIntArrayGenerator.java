package se.kth.id1020;

import java.util.Random;

public class RandomIntArrayGenerator {
    private final Random rand;

    public RandomIntArrayGenerator(int seed){
        this.rand = new Random(seed);
    }

    /**
     * Generate an array of a specified size with random numbers between min and max value.
     * @param size the size of the array
     * @param min the minimum value in the array
     * @param max the maximum value in the array
     * @return a populated array
     */
    public int[] generateArray(int size, int min, int max){
        int[] array = new int[size];

        for(int i=0; i<array.length; i++){
            array[i] = rand.nextInt(max) + min;
        }

        return array;
    }

    public int[] generateCopyOfArray(int[] array){
        int[] copy = new int[array.length];

        for(int i=0; i<array.length; i++){
            copy[i] = array[i];
        }

        return copy;
    }

    //Best case for insertion sort
    public int[] generateSortedAscending(int arraySize) {
        int[] sorted = new int[arraySize];
        for(int i=0; i<sorted.length; i++){
            sorted[i] = i;
        }
        return sorted;
    }

    //Worst case for insertion sort
    public int[] generateSortedDescending(int arraySize){
        int[] sorted = new int[arraySize];
        int startVal = sorted.length;
        for(int i=0; i<sorted.length; i++){
            sorted[i] = startVal;
            startVal--;
        }
        return sorted;
    }

    public int[] generateArrayWithOnes(int arraySize){
        int[] ones = new int[arraySize];
        for(int i=0; i<ones.length; i++){
            ones[i] = 1;
        }
        return ones;
    }
}
