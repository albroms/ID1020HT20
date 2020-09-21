package se.kth.id1020.sorting;

public class InsertionSort {

    /**
     * Sort an array of ints using the insertion sort algorithm.
     * Since there is a nested for loop in the outer loop, we will see an
     * O(N^2) time complexity. This method is however an in-place sorting algorithm,
     * Which will result in a constant memory complexity O(1).
     *
     * @param intArray the array to sort
     */
    public void insertionSort(int[] intArray){
        int N = intArray.length;
        long swaps = 0; //for task 2

        for(int i=1; i<N; i++){
            for(int j=i; j>0 && intArray[j]<intArray[j-1]; j--){
                swap(intArray, j, j-1);
                swaps++; //for task 2
                printArray(intArray); //for task 1
            }
        }
        System.out.println("Performed " + swaps + " swaps."); //for task 2
    }

    private void swap(int[] array, int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    /**
     * Print the array.
     * @param array the array to print
     */
    public void printArray(int[] array){
        System.out.print("Current state: [");
        for(int i=0; i<array.length; i++){
            if(i==array.length-1){
                System.out.print(array[i]);
            }
            else {
                System.out.print(array[i] + ", ");
            }
        }
        System.out.println("]");
    }

    /**
     * Time complexity is O(N^2) due to the nature of the nested for loops.
     * @param array
     */
    public void showInversions(int[] array){
        int numberOfInversions = 0;
        for(int i=0; i<array.length; i++){
            for(int j=1; j<array.length; j++){
                if(array[i] > array[j]){
                    System.out.println("Inversion found: " + "[index: " + i + ", value: " + array[i] + "], " +
                                                             "[index: " + j + ", value: " + array[j] + "]");
                    numberOfInversions++;
                }
            }
        }
        System.out.println("Found " + numberOfInversions + " inversions.");
    }

    //higher grade task 1
    public void insertionSortDescending(int[] array){
        for(int i=0; i<array.length; i++){
            array[i] = array[i] * -1;
        }
        insertionSort(array);
        for(int i=0; i<array.length; i++){
            array[i] = array[i] * -1;
        }
    }
}
