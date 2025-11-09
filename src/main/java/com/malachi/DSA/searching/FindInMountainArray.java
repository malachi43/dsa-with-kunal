package com.malachi.DSA.searching;

public class FindInMountainArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,3,1,-1};
        int target =  4;
        int index = findInMountainArray(arr, target);
        System.out.println("result: " + index);
    }

    public static int findInMountainArray(int[] arr, int target){
        int peakIndex = findPeakIndex(arr);
        int start = 0;

        Integer index = null;
        index = binarySearch(arr, start, peakIndex, target, true);
        if(index == -1){
            index = binarySearch(arr, peakIndex + 1, arr.length -1, target, false);
        }
        return index;
    }

    public static int findPeakIndex(int[] arr){
        int start = 0;
        int end = arr.length - 1;

        while (start < end){
            int mid = start + (end - start) / 2;
            if(arr[mid] > arr[mid + 1]){
                //This might be the peak index so we still remain at the mid
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        //at this point start == end
        return start;
    }

    public static int binarySearch(int[] arr, int start,  int end, int target, boolean isAsc){
        if(isAsc){
            while (start <= end){
                int mid = start + (end - start) / 2;
                if(arr[mid] == target) return mid;
                else if(target > arr[mid]){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
            return -1;
        }else{ //descending array
            while (start <= end){
                int mid = start + (end - start) / 2;
                if(arr[mid] == target) return mid;
                else if(target > arr[mid]){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }
            return -1;
        }
    }
}
