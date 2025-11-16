package com.malachi.DSA;

import java.util.Arrays;

//https://leetcode.com/problems/first-missing-positive/submissions/1831558803/?envType=problem-list-v2&envId=array
public class FirstMissingPositiveNumber {
    public static void main(String[] args) {
    }

    //we use cyclic sort technique since it uses O(n) time complexity and O(1) space complexity.
    public static int firstMissingPositive(int[] nums){
        int i = 0;
        while(i < nums.length){
            int correctIndex = nums[i] - 1;
            /*
            we ensure the number to be swapped is greater than zero (since zero is not a positive number)
            and the number is <= to the length of the array to avoid IndexOutOfBoundException
             */
            if(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[correctIndex]){
                swap(nums, i, correctIndex);
            }else{
                i++;
            }
        }
        for(int index = 0; index < nums.length; index++){
            if(nums[index] != (index + 1)) return index + 1;
        }

        return nums.length + 1;
    }


    public static void swap(int[] arr, int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
