package com.malachi.DSA.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = {4,5,1,2,3};
        selectionSort2(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void selectionSort2(int[] arr){
        for(int i = 0; i < arr.length; i++){
            //find the max item in the remaining array that is yet to be sorted.
            int last = (arr.length - i) - 1;
            int maxIndex= getMaxIndexFromArray(arr, 0, last);
            swap(arr, maxIndex, last);
        }
    }

    public static void selectionSort1(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int minIndex = getMinIndexFromArray(arr, i, arr.length);
            swap(arr, i, minIndex);
        }
    }

    public static void swap(int[] arr, int idx1, int idx2){
        int temp =  arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    //get min index from start to end of the given array.
    public static int getMinIndexFromArray(int[] arr, int start, int end){
        int minIndex = start;
        for(int i = start; i < end; i++){
            if(arr[i] < arr[minIndex]){
                minIndex = i;
            }
        }
        return minIndex;
    }

    //get max index from start to end of the given array.
    public static int getMaxIndexFromArray(int[] arr, int start, int end){
        int maxIndex = start;
        for(int i = start; i <= end; i++){
            if(arr[i] > arr[maxIndex]){
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
