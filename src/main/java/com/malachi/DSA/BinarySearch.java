package com.malachi.DSA;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int target = 8;
        int ans = binarySearch(arr, target);
        System.out.println("index of " + target + " is: " + ans);
    }

    public static int binarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        /*
        * we use 'start' and 'end' to check if the array is ascending or descending instead of using two contiguous indexes,say index 0 and index 1
        * because the element at index 0 and index 1 could have the same value and the order(asc/desc) of the array would not be known.
        * */
        boolean isAsc = arr[start] < arr[end]; //this helps to know the order(asc/desc) of the array

        if(isAsc){
            while(start <= end){
                int mid = start + (end - start) / 2; //we use this calculation to avoid integer overflow in java.
                if(arr[mid] == target) return mid;
                else if(target < arr[mid]){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }
        }else{
            //when arr is sorted in descending (highest to lowest) order
            while(start <= end){
                int mid = start + (end - start) / 2; //we use this calculation to avoid integer overflow in java.
                if(arr[mid] == target) return mid;
                else if(target > arr[mid]){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
