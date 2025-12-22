package com.malachi.DSA.sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
       int[] result =  mergeSort(arr, 0, arr.length - 1);
        System.out.println("sorted array: " + Arrays.toString(result));
    }


    public static int[] mergeSort(int[] arr, int start, int end){
        if(start - end == 0) return arr;
        int mid = start + (end - start) / 2;

        //left half or array
        mergeSort(arr, start, mid);

        //right half of array
        mergeSort(arr, mid + 1, end);

        return merge(arr, start, mid, end);
    }

    public static int[] merge(int[] arr, int start, int mid, int end ){
        int i = start;
        int j = mid + 1;
        int[] temp = new int[end - start + 1];
        int index = 0;
        while(i <= mid && j <= end){
            if(arr[i] <= arr[j]){
                temp[index++] = arr[i++];
            }else{
                temp[index++] = arr[j++];
            }
        }

        while(i <= mid){
            temp[index++] = arr[i++];
        }

        while(j <= end){
            temp[index++] = arr[j++];
        }

        int counter = 0;
        for(int k = start; k <= end; k++){
            arr[k] = temp[counter++];
        }

        return arr;
    }
}
