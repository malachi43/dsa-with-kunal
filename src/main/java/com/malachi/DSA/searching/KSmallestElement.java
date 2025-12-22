package com.malachi.DSA.searching;

import java.security.SecureRandom;
import java.util.Arrays;

public class KSmallestElement {
    public static void main(String[] args) {
        int[] arr = {3,5,7,11,13};
        //shuffle the array to create randomness
        shuffleArray(arr);
        for(int i = arr.length; i >= 1; i--){
            int smallest = select(arr, i);
            System.out.println("The " + i + " smallest element is: " + smallest );
        }
        System.out.println(removeChar("bccdaapple"));
        int[] arr2 = {9,8,6,4,2,1,0};
        System.out.println("array sorted using cyclic sort: " + Arrays.toString(arr2));
    }

    public static int partition(int[] arr, int lo, int hi){
        int i = lo;
        int j = hi + 1;
        int pivot = arr[lo];

        while(true){
            while(i < hi && arr[++i] < pivot){
                if(i == hi) break;
            }

            while(arr[--j] > pivot){
                if(j == lo) break;
            }

            if( i >= j) break;

            swap(arr, i, j);
        }

        swap(arr, lo, j);

        return j;

    }

    public static int select(int[] arr, int k){
        int lo = 0;
        int hi = arr.length - 1;

        while( lo < hi ){
            int j = partition(arr, lo, hi);
            if( j < k) {
                lo = j + 1;
            }else if( j > k ){
                hi = j - 1;
            }else{
                return arr[k - 1];
            }
        }

        return arr[k - 1];
    }

    public static void swap(int[] arr, int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    public static void shuffleArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int randomIndex = new SecureRandom().nextInt(i + 1);
            swap(arr, i, randomIndex);
        }
    }

    public static String removeChar(String str){
       if(str.isEmpty()) return "";
       char ch = str.charAt(0);
       if(str.startsWith(("apple"))){
           return removeChar(str.substring(3));
       }else{
           return str.charAt(0) + removeChar(str.substring(1));
       }
    }
}
