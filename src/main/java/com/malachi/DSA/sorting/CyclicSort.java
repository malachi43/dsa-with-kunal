package com.malachi.DSA.sorting;

import ch.qos.logback.core.util.InvocationGate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CyclicSort {
    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1,0};
//        int[] arr = {1,1};
        sort(arr);
        System.out.println("sorted array: " + Arrays.toString(arr));
    }

    //for [0,N] range of numbers.
    public static void sort(int[] arr) {
       int i = 0;
       while (i < arr.length){
           int correctIndex = arr[i];
           if(arr[i] != arr[correctIndex]){
               swap(arr, i, correctIndex);
           }else{
               //increment i when the element at i is at the correct index.
               ++i;
           }
       }

    }

    public static void swap(int[] arr, int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
