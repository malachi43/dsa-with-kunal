package com.malachi.DSA.recursion.array;


import javax.print.DocFlavor;
import java.util.*;
import java.util.stream.Stream;

public class RotatedBinarySearch {
    public static void main(String[] args) {
        int[] nums = {5,6,7,8,9,1,2,3};
        int target = 10;
        System.out.println("pivot index -> " + search(nums, target, 0,nums.length - 1));
    }

    public static int search(int[] arr,int target, int start, int end) {
        if(start > end) return -1;
        int mid = start + ((end - start) / 2);
        if(arr[mid] == target) return mid;

        //left half is sorted
        if(arr[start] < arr[mid]){
            if(target >= arr[start] && target < arr[mid]){
                return search(arr, target, start, mid - 1);
            }else{
                return search(arr, target, mid + 1, end);
            }
        }
        //search in the right half.
        else if(target > arr[mid] && target <= arr[end]){
            return search(arr, target, mid + 1, end);
        }
        return search(arr, target, start, mid - 1);
    }

}
