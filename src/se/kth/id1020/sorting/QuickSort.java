package se.kth.id1020.sorting;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSort {
    public static void quickSort(int[] a){
        shuffle(a);
        sort(a, 0, a.length-1);
    }

    private static void sort(int[] a, int lo, int hi){
        if(hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    private static int partition(int[] a, int lo, int hi){
        int i = lo, j = hi+1;
        int v = a[lo]; //partitioning item
        while(true){
            while(a[++i] < v){
                if (i == hi) break;
            }
            while(v < a[--j]){
                if(j==lo) break;
            }
            if(i>=j) break;
            swap(a, i, j);
        }
        swap(a, lo, j);
        return j;
    }

    private static void swap(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static void shuffle(int[] arr){
        Random rnd = ThreadLocalRandom.current();
        for(int i=arr.length-1; i>0; i--){
            int index = rnd.nextInt(i+1);
            swap(arr, index, i);
        }
    }
}
