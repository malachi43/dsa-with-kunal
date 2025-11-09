package com.malachi.DSA.searching;

public class LargesMinSum {
    public static void main(String[] args) {
      int[] arr = {7,2,5,8,10};
      int m = 2;
      int minSum = splitArray(arr,m);
        System.out.println("minSum: " + minSum);
    }

    public static int splitArray(int[] nums, int partition){
        int start = 0;
        int end = 0;

        for(int i = 0; i < nums.length; i++){
            start = Math.max(start, nums[i]); //at the end of the loop this will hold the max value in the array.
            end += nums[i]; //at the end of the loop this will hold the sum of all elements in the array.
        }

        System.out.println("range : [ " + start + "," + end + " ]" );

        while(start < end){
            int mid = start + (end - start) / 2;
            int sum = 0;
            int noOfSubarrays = 1;

            for(int num : nums){
                if(sum + num <= mid){
                    sum += num;
                }else{
                    sum = num; //we reset the new sum to the current num in the new subarray.
                    ++noOfSubarrays; //another subarray is created here.
                }
            }

            if(noOfSubarrays <= partition){
                end = mid;
            }else{
                start = mid + 1;
            }

        }

        return start; //here start == end.
    }
}
