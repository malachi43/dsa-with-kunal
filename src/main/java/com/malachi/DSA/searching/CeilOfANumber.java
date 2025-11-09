package com.malachi.DSA.searching;

public class CeilOfANumber {
    public static void main(String[] args) {

    }

    //ceil of a number - the smallest number >= target
    public static int ceilOfANumber(int[] arr, int target){
        //when target is greater than the greatest number in the array.
        if(target > arr[arr.length - 1]) return -1;

        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] == target) return arr[mid];
            else if(target > arr[mid]){
                start = mid + 1;
            }else{
                end = mid - 1;
            }

        }
        //at this point, start is the index of the smallest value greater than target i.e the ceil of the number.
        return start; //start > end (loop condition violated.

    }
}
