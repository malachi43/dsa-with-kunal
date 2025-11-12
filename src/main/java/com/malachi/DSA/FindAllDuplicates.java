package com.malachi.DSA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllDuplicates {
    public static void main(String[] args) {
      int[] nums = {4,3,2,7,8,2,3,1};
      List<Integer> duplicates = findDuplicates(nums);
      duplicates.sort((a,b) -> a - b);
      System.out.println("duplicates: " + duplicates);
    }

    public static List<Integer> findDuplicates(int[] nums){
        int i = 0;
        while(i < nums.length){
            int correctIndex = nums[i] - 1;
            if(nums[i] != nums[correctIndex]){
                swap(nums, i, correctIndex);
            }else{
                i++;
            }
        }

        List<Integer> duplicates = new ArrayList<>();
        //find all the duplicates
        for(int index = 0; index < nums.length; index++){
            if(nums[index] != index + 1){
                duplicates.add(nums[index]);
            }
        }
        return duplicates;
    }
   public static void swap(int[] arr, int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
