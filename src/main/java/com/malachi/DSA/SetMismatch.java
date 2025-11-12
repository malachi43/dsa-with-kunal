package com.malachi.DSA;

import java.util.ArrayList;
import java.util.List;

public class SetMismatch {
    public static void main(String[] args) {
    }

    public static int[] findErrorNums(int[] nums){
        int i = 0;
        while (i <  nums.length){
            int correctIndex = nums[i] - 1;
            if(nums[i] != nums[correctIndex]){
                swap(nums, i , correctIndex);
            }else{
                i++;
            }
         }

        //find the number that occurs twice and the missing number.
        for(int index = 0; index < nums.length; index++){
            if(nums[index] != index + 1){
                return new int[]{nums[index], index + 1};
            }
        }

        return new int[]{-1,-1};
    }

    public static void swap(int[] arr, int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
