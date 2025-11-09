package com.malachi.DSA.searching;

public class FindRotationCountInRotatedSortedArray {
    public static void main(String[] args) {
        int[] num = {6,7,8,9,1,2,3,4,5};
        int count = rotationCount(num);
        System.out.println("rotation count: " + count);
    }

    //the array is rotated pivot times.
    public static int findPivot(int[] arr){
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;
            if(mid < end && arr[mid] > arr[mid + 1])  return mid;
            if(mid > start && arr[mid - 1] > arr[mid]) return mid - 1;
            if(arr[start] >= arr[mid]){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return -1;
    }

    public static int rotationCount(int[] arr){
        int pivot = findPivot(arr);
        return pivot + 1;
    }
}
