package com.malachi.DSA;

import java.util.Arrays;

public class FindDuplicateNumber {
    public static void main(String[] args) {
    }

    public static int findDuplicate(int[] nums){
        int i = 0;
        while(i <  nums.length){
            int correctIndex = nums[i] - 1;
            if(nums[i] != nums[correctIndex]){
                swap(nums, i, correctIndex);
            }else{
                i++;
            }
        }
        //find duplicate/repeated number
        for(int index = 0; index < nums.length; index++){
            if(nums[index] != index + 1){
                return nums[index];
            }
        }
        return -1;
    }

    public static int findDuplicateOptimized(int[] nums){
        int i = 0;

        while (i < nums.length){
            int correctIndex = nums[i] - 1;

            if(nums[i] != i + 1){
                if(nums[i] != nums[correctIndex]){
                    swap(nums, i, correctIndex);
                }else{
                    //this condition is executed when the two element at the index are equal.
                    return nums[i];
                }
            }else{
                i++;
            }
        }
        return -1;
    }

    public static void swap(int[] arr, int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
