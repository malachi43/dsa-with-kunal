package com.malachi.DSA;

public class MoveKElementToEnd {
    public static void main(String[] args) {
    }
    //https://leetcode.com/problems/move-zeroes/submissions/1796413467/?envType=problem-list-v2&envId=array
    public static int moveKElementToEnd(int[] arr, int value){
        int k = -1;
        int N = arr.length;
        for(int i = 0; i < N; i++){
            if(arr[i] == value){
                k = i;
                break;
            }
        }

        for(int j = k + 1; j < N; j++ ){
            if(arr[j] != value){
                swap(arr, k, j);
                ++k;
            }
        }
        return k;
    }

    public static void swap(int[] arr, int idx1,  int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
