package com.malachi.DSA.recursion;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1,0,100,123,76};
        sort(arr, arr.length - 1, 0);
        System.out.println("sorted array: " + Arrays.toString(arr));
    }

    public static void sort(int[] arr, int r,  int c){
        if(r == 0) return;
        if( c < r){
            sort(arr, r, c + 1);
        }else{
            int maxIndex = getMaxIndex(arr, 0, r);
            swap(arr,maxIndex,r);
            sort(arr, r - 1, 0);
        }
    }

    public static void swap(int[] arr, int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    public static int getMaxIndex(int[] arr,  int start, int end){
        int maxValue = arr[start];
        int maxIndex = 0;
        for(int i = start; i <= end; i++){
            if( arr[i] >= maxValue){
                maxValue = arr[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
