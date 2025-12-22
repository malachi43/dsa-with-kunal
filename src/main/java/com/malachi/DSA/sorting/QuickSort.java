package com.malachi.DSA.sorting;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.security.SecureRandom;
import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        System.out.println("ORIGINAL ARRAY ::::::: " + Arrays.toString(arr));
        //we first shuffle the array.
        shuffleArray(arr);
        System.out.println("SHUFFLED ARRAY ::::::: " + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("ARRAY SORTED USING QUICKSORT ALGORITHM ::::::: " + Arrays.toString(arr)) ;
    }

    public static int partition(int[] arr, int lo, int hi){
       int i = lo;
       int j = hi + 1;
       int pivot = arr[lo];

       while(true){
           while(i < hi && arr[++i] < pivot){
               //break if "i" reaches the end of the array.
               if( i == hi ) break;
           }

           while(arr[--j] > pivot){
               //break if "j" reaches the start of the array.
               if( j == lo ) break;
           }

           //break if the value of "i" and "j" are equal or "i" becomes greater.
           if( i >= j) break;

           swap(arr, i, j);
       }

       //this moves the pivot element to the current index.
       swap(arr, lo, j);
       return j;
    }

   public static void quickSort(int[] arr, int start, int end){
     if(end <= start ) return;
     int partitionIndex = partition(arr, start, end);
     quickSort(arr, start, partitionIndex - 1);
     quickSort(arr, partitionIndex + 1, end);
   }

    public static void swap(int[] arr, int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    public static void shuffleArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int randomIndex = new SecureRandom().nextInt(i + 1);
            swap(arr, i, randomIndex);
        }
    }

}
