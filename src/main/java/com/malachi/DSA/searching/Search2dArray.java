package com.malachi.DSA.searching;

import java.util.Arrays;

//search in row-sorted and col-sorted 2d-matrix.
public class Search2dArray {
    public static void main(String[] args) {
      int[][] matrix = {
              {10,20,30,40},
              {15,25,35,45},
              {28,29,37,49},
              {33,34,38,50}
      };

        int target = 13;
        int[] index = search(matrix, target);
        System.out.println(target + " is at index: " + Arrays.toString(index));
    }

    //https://leetcode.com/problems/search-a-2d-matrix/submissions/1810115815/?envType=problem-list-v2&envId=array
    public static int[] search(int[][] matrix, int target){
        int row = 0;
        int col = matrix[row].length - 1;

        while(row < matrix.length && col >= 0){
            if(matrix[row][col] == target) return new int[]{row, col};
            else if(matrix[row][col] < target){
                row++;
            }else{
                col--;
            }
        }
        return new int[]{-1,-1};
    }
}
