package se.kth.id1020.sorting;

public class MergeSort {
    private static int[] aux;

    /**
     * Merge sort without cutoff value.
     * @param a the array to sort
     */
    public  static void mergeSort(int[] a){
        aux = new int[a.length];
        sort(a, 0, a.length-1, 0);
    }

    /**
     * Merge sort with cutoff value.
     * @param a the array.
     * @param cutoff if the number of indices to sort is less than or equal to cutoff, use insertion sort.
     */
    public static void mergeSortCutoff(int[] a, int cutoff){
        if(cutoff < 0){
            throw new IllegalArgumentException("You cannot use a negative cutoff value");
        }
        else if(cutoff == 0){
            mergeSort(a);
        }
        else{
            sort(a, 0, a.length-1, cutoff);
        }

    }

    private static void sort(int[] a, int lo, int hi, int cutoff){
        if(hi-lo+1 <= cutoff){
            insertionSort(a, lo, hi);
        }
        if(hi <= lo)
            return;
        int mid = lo + (hi-lo)/2;
        sort(a, lo, mid, cutoff);
        sort(a, mid+1, hi, cutoff);
        merge(a, lo, mid, hi);
    }

    private static void  merge(int[] a, int lo, int mid, int hi){
        int i = lo, j = mid+1;
        for(int k = lo; k <= hi; k++){
            //copy into aux array
            aux[k] = a[k];
        }
        for(int k = lo; k <= hi; k++){
            if(i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if(aux[j] < aux[i])
                a[k] = aux[j++];
            else
                a[k] = aux[i++];
        }
    }

    public void printArray(int[] a){
        System.out.print("[");
        for(int i=0; i<a.length; i++){
            if(i == a.length-1){
                System.out.print(a[i]);
            }
            else {
                System.out.print(a[i] + ", ");
            }
        }
        System.out.println("]");
    }

    //lo is starting point (like 0), hi is end point (like a.length)
    private static void insertionSort(int[] a, int lo, int hi){
        for(int i=lo; i<=hi; i++){
            for(int j=i; j>lo && a[j]<a[j-1]; j--){
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }
    }
}
