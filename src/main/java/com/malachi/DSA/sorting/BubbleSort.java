package com.malachi.DSA.sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {1000,2,1,4,5,10,100,101,3, -1,0};
//        int[] nums = {1,2,3,4,5,6};

        bubbleSort(nums);
        System.out.println("sorted array: " + Arrays.toString(nums));
    }

    public static void bubbleSort(int[] arr){
        //run this steps n-1 times
        for(int i = 0; i < arr.length - 1; i++){
             //this helps us check if the array is sorted. if no swap is made then the array is sorted.
             boolean swapped = false;

             //after each iteration the max value will be moved to the end of the array.
            for (int j = 1; j < arr.length - i; j++){
                if(arr[j-1] > arr[j]){
                    swap(arr, j-1, j);
                    swapped = true;
                }
            }

            //if no swap was made for any iteration of i, that means the array is sorted at that point in time and therefore we break from the loop.
            if(!swapped) break;
        }
    }

    public static void swap(int[] arr, int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
