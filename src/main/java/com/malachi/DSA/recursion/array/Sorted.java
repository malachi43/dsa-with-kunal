package com.malachi.DSA.recursion.array;

import java.util.Arrays;

public class Sorted {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,16,9};
        boolean isSorted = sorted(arr);
        System.out.println("is array -> " + Arrays.toString(arr) + " sorted?: " + isSorted);
    }

    public static boolean sorted(int[] arr){
        int startingIndex = 0;
       return helper(arr, startingIndex);
    }

    public static boolean helper(int[] arr, int index){
        if(arr.length == 1) return true;
        if(index == arr.length - 1) return true;
        return arr[index] <= arr[index + 1] && helper(arr, index + 1);
    }

}
