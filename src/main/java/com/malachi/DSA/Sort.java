package com.malachi.DSA;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] arr = {9,8,7,6,0,5,4,3,2,1};
        int[] sortedArr = bubbleSort(arr);
        pattern(5, 5);
        System.out.println("sorted_arr: " + Arrays.toString(sortedArr));
    }

    public static int[] bubbleSort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length - 1 - i; j++){
                if(arr[j] > arr[j + 1]){
                    swap(arr, j, j + 1);
                }
            }
        }
        return arr;
    }

    public static int[] selectionSort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int smallestIndex = getSmallestIndex(arr, i, arr.length - 1);
            swap(arr, smallestIndex, i);
        }
        return arr;
    }

    public static int getSmallestIndex(int[] arr,  int start, int end){
        int min = start;
        for(int i = start; i <= end; i++){
            if(arr[i] < arr[min]){
                min = i;
            }
        }
        return min;
    }



    public static void swap(int[] arr, int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    public static void pattern(int r, int c){
        if(r == 0) return;
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < c; i++){
            builder.append(" * ");
        }
        System.out.println(builder);
        pattern(--r, --c);
    }

}
