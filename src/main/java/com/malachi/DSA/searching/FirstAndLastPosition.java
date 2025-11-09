package com.malachi.DSA.searching;

import java.util.Arrays;

public class FirstAndLastPosition {
    public static void main(String[] args) {
    }

    //https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/submissions/1796390693/?envType=problem-list-v2&envId=array
    public static int[] findFirstAndLastPosition(int[] arr, int target){
        int[] ans = {-1,-1};
        ans[0]= search(arr, target, true);
        if(ans[0] != -1){
            ans[1] = search(arr, target, false);

        }

        return ans;

    }

    //binary search
    public static int search(int[] arr, int target, boolean findStartIndex){
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;

        while (start <= end){
            int mid = start + (end - start) / 2;
            if(target == arr[mid]){
                //potential answer found.
                ans = mid;
                //the target may still exist at the LHS of the array
                if(findStartIndex){
                    end = mid - 1;
                }else{
                    //target may still exist at the RHS of the array.
                    start = mid + 1;
                }
            }else if(target < arr[mid]){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return ans;
    }


}
