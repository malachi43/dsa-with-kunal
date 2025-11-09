package com.malachi.DSA;

public class FloorOfANumber {
    public static void main(String[] args) {

    }

    //floor of a number - the greatest number <= to target.
    public static int floorOfANumber(int[] arr, int target){
//        if(target < arr[0]) return -1;

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
        //at this point, end is the index of the greatest value smaller than target i.e the floor of the number.
        return end; // end < start (loop condition violated)

    }
}
