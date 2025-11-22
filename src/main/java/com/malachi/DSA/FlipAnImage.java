package com.malachi.DSA;

import java.util.Arrays;

//https://leetcode.com/problems/flipping-an-image/?envType=problem-list-v2&envId=array
public class FlipAnImage {
    public static void main(String[] args) {
        int[][] arr = {
                {1,1,0},
                {1,0,1},
                {0,0,0}
        };
        flipAndInvertImage(arr);
    }

    public static int[][] flipAndInvertImage(int[][] image){
        for(int row = 0; row < image.length; row++){
            int[] arr = image[row];
            reverseArray(arr);
        }

        return image;
    }

    public static void reverseArray(int[] nums){
        /*
        We move from zero till half the length of the array,
        We added 1 to (nums.length) i.e. (nums.length + 1) so that the array runs till half the length of the array for arrays that have an odd length
        arr = [1,2,3,4] - this will run till index equal 1 ( 0 - index)
        arr = [1,2,3,4,5] - without adding 1 to (nums.length) this will run till index 1 as well but remember we are inverting the bits also.
        Without adding 1 to (nums.length) the element 3 at index 2 will not be inverted. So adding 1 to account for odd length of array is necessary.
        If we only wanted to swap we can leave out adding 1 to (nums.length) but we are also inverting element in this case.
         */
        for(int i = 0; i < (nums.length + 1) / 2; i++){
            swapAndInvert(nums, i, nums.length - i - 1);
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void swapAndInvert(int[] arr, int idx1, int idx2){
        /*
         Properties of XOR:
         - When you XOR any number with 1 the number is inverted i.e  1 XOR 1 => 0, 0 XOR 1 => 1, 12 XOR 1 => 13, 13 XOR 1 = 12
         - Also when you XOR any number with 0 you get back the original number 1 XOR 0 => 1, 0 XOR 0 => 12 XOR 0 => 12

           In programming XOR operator is denoted with ^
          - So 1 XOR 1 => 1 ^ 1 = 0
        */
        int temp = arr[idx1] ^ 1;
        arr[idx1] = arr[idx2] ^ 1;
        arr[idx2] = temp;
    }
}
