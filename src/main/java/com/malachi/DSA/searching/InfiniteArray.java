package com.malachi.DSA.searching;



public class InfiniteArray {
    public static void main(String[] args) {

    }

    //https://www.geeksforgeeks.org/dsa/find-position-element-sorted-array-infinite-numbers/
    public static int ans(int[] arr, int target){
        int index = -1;

        int start = 0;
        int end = 1;

        while(arr[end] < target){
            //double the box size.
            int boxSize = (end - start + 1) * 2;
            start = end  + 1;
            end = end + boxSize;
        }

        index = binarySearch(arr, target, start, end);

        return index;
    }
    public static int binarySearch(int[] arr, int target, int start, int end){
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(target > arr[mid]){
                start = mid + 1;
            }else if(target < arr[mid]){
                end = mid - 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
