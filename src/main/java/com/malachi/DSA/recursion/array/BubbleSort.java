package com.malachi.DSA.recursion.array;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1,0,100,123,76};
        sort(arr, arr.length - 1, 0);
        System.out.println("sorted array: " + Arrays.toString(arr));
    }

    public static void sort(int[] arr, int r, int c){
        if(r == 0) return;
        if(c < r){
            if(arr[c] > arr[c + 1]){
                swap(arr, c, c + 1);
            }
            sort(arr, r, c + 1);
        }else{
            sort( arr,r - 1, 0);
        }
    }

    public static void swap(int[] arr, int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
