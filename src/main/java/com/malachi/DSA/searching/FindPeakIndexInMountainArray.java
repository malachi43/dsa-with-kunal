package com.malachi.DSA.searching;

//https://leetcode.com/problems/find-peak-element/submissions/1798678131/?envType=problem-list-v2&envId=array
public class FindPeakIndexInMountainArray {
    public static void main(String[] args) {
        int[] mountainArray = {1,2,3,4,8,3,2,1,0};
        int result = findPeakIndexInMountainArray(mountainArray);
        System.out.println("result: " + result);
    }
    public static int findPeakIndexInMountainArray(int[] arr){
        int start = 0;
        int end = arr.length - 1;

        while (start < end){
            int mid = start + (end - start) / 2;
            if(arr[mid] > arr[mid + 1]){
                //this show we are in the descending part of the array, this may be the answer but look at left. This is my end is not equal to mid + 1
                end = mid;
            }else{
                //we are in the asc part of the array.
                //because we know that mid element < mid + 1.
                start = mid + 1;
            }
        }
        //at this point start and end will point to the same value. start == end because of this two checks.
        return start; //return end //both are the same.
    }
}
