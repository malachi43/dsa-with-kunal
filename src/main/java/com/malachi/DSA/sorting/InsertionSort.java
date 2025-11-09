package com.malachi.DSA.sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {5,3,4,1,2};
        insertionSort((arr));
        System.out.println("sorted array using insertion sort: " + Arrays.toString(arr));

        int[] rotated = {4,5,6,7,0,1,2};
        int target = 3;
        int index = searchInRotatedArray(rotated,target);
        System.out.println("index of " + target + " is: " + index);
    }

    public static void insertionSort(int[] arr){
        int N = arr.length - 1;
        for (int i = 0; i < N; i++){
          for(int j = i + 1; j > 0; j--){
              if(arr[j] < arr[j - 1]){
                  swap(arr, j, j-1);
              }else{
                  //this is because the element to the left of j are already sorted, since the sorting is done incrementally.
                  break;
              }
          }
        }
    }

    public static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static int searchInRotatedArray(int[] arr, int target){
        int start = 0 , end = arr.length - 1;

        while (start <= end){
            int mid = start + (end - start) / 2;

            if(arr[mid] == target) return mid;
            //check if left half is sorted.
            else if(arr[start] <= arr[mid]){
                //check if target is in left half
                if( arr[start] <= target && target < arr[mid]){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
                //right half is sorted.
            }else{
                //check if target is in right half
                if(arr[mid] < target && target <= arr[end]){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
