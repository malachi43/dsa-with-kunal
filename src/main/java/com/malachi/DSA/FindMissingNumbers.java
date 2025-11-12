package com.malachi.DSA;

import com.sun.source.tree.ArrayAccessTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindMissingNumbers {
    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        List<Integer> missingElements = findDisappearedNumbers(arr);
        System.out.println("The missing element is: " + missingElements);
    }

    public static List<Integer> findDisappearedNumbers(int[] nums){
        int i = 0;

        while (i < nums.length){
            int correctIndex = nums[i] - 1;
            if(nums[i] != nums[correctIndex]){
                swap(nums, i, correctIndex);
            }else{
                i++;
            }
        }

        //find missing number
        List<Integer> missingNumbers = new ArrayList<>();
        for(int index = 0; index < nums.length; index++){
            if(nums[index] != (index + 1)){
                missingNumbers.add((index + 1));
            }
        }
        return missingNumbers;
    }

    public static void swap(int[] arr, int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
