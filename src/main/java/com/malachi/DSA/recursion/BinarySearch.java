package com.malachi.DSA.recursion;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {3,5,7,11,13,17,19};
        int target = 5;
        int result = binarySearch(arr, 0, arr.length - 1, target);
        System.out.println("result: " + result);
    }

    public static int binarySearch(int[] arr, int start, int end, int target){
        if(start > end) return -1;
        int mid = start + (end - start) / 2;
        if(arr[mid] == target) return mid;
        else if(target > arr[mid]){
            return binarySearch(arr, mid + 1, end, target);
        }
        else{
            return binarySearch(arr,start, mid - 1, target);
        }
    }

}
