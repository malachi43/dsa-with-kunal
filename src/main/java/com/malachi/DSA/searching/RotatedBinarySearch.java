package com.malachi.DSA.searching;

public class RotatedBinarySearch {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2,3};
        int[] nums1 = {2,2,2,9};
        int target = 2  ;
        int resultIndex = rbs(nums1, target);
        System.out.println("the target " + target + " in the array  is at position: " + resultIndex);
    }

   public static int findPivot(int[] arr){
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = start + (end - start) /  2;
            //4 cases
            if(mid < end && arr[mid] > arr[mid + 1]) return mid;
            if(mid > start && arr[mid - 1] > arr[mid]) return mid - 1;

//            if start, mid and end are equal
            if(arr[mid] == arr[start] && arr[mid] == arr[end]){
                if(arr[start] > arr[start + 1]) return start;
                start++;
                if(mid > end && arr[end - 1] > arr[end]) return end - 1;
                end--;
            }
            if(arr[start] >= arr[mid]){
                end = mid - 1;
            }else{
                //if the pivot exists it would had been found in the first two conditions.
//                if(arr[start] <= mid) start = mid + 1;
                start = mid + 1;
            }
        }

        return -1;
   }

    public static int binarySearch(int[] arr, int start, int end, int target) {
        boolean isAsc = arr[start] < arr[end];
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) return mid;
            if (isAsc) {
                if (target > arr[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (target > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

        }

        return -1;
   }

   //https://leetcode.com/problems/search-in-rotated-sorted-array/submissions/1806155496/?envType=problem-list-v2&envId=array
   public static int rbs(int[] arr, int target){
       int pivotIndex = findPivot(arr);
       System.out.println("pivot index: " + pivotIndex);
       //this means the array is not rotated.
       if(pivotIndex == -1){
           //carry out normal binary search
           return binarySearch(arr, 0, arr.length - 1, target);
       }
       //case 1
       if(arr[pivotIndex] == target) return pivotIndex;

       //case 2
       if(target >= arr[0]){
           return  binarySearch(arr, 0, pivotIndex - 1, target);
       }

          return binarySearch(arr, pivotIndex + 1, arr.length - 1, target);

   }
}
