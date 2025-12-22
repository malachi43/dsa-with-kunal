package com.malachi.DSA;

import java.util.Arrays;

//https://leetcode.com/problems/missing-number/?envType=problem-list-v2&envId=array
public class MissingNumber {
    public static void main(String[] args) {
    }

    public static int missingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length){
            int correctIndex = nums[i];
            /*
            We are doing that first check in the "if" condition because an element N == arr.length cannot be put in the correct index
            since it would result in an index out of bound exception, remember the given array will have one missing element.
             */
            if(nums[i] < nums.length && nums[i] != nums[correctIndex]){
               swap(nums, i, correctIndex);
            }else{
                i++;
            }
        }

        //search for first missing number. Return the first element not equal to its index.
        for(int index = 0; index < nums.length; index++){
            if(nums[index] != index) return index;
        }

        return nums.length;
    }

    public static void swap(int[] arr, int idx1, int idx2)
{
     int temp = arr[idx1];
     arr[idx1] = arr[idx2];
     arr[idx2] = temp;
}}