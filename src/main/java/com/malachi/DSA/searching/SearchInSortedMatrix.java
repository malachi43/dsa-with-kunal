package com.malachi.DSA.searching;

import java.util.Arrays;

public class SearchInSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };

        int target = 12;
        int[] ans = search(matrix, target);
        System.out.println("ans: " + Arrays.toString(ans));
    }

    public static int[] search(int[][] matrix, int target){
        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        if(rowEnd == 0){
            int index = binarySearch(matrix, rowStart, 0, matrix[rowStart].length - 1, target);
            if(index == -1) return new int[]{-1,-1};
            return new int[]{rowStart, index};
        }
        while(rowStart <= rowEnd){
            int mid = rowStart + (rowEnd - rowStart) / 2;
            int index = binarySearch(matrix, mid, 0, matrix[mid].length - 1, target);

            //the target element was not found at mid row index.
            if(index == -1) {
                int[] array = matrix[mid];
                //check if the last element in a row is greater that target.
                if(array[array.length - 1] > target){
                   rowEnd = mid - 1;
                }else{
                    rowStart = mid + 1;
                }
            }else{
                //the element is found
                return new int[]{mid, index};
            }
        }

        return new int[]{-1,-1};

    }

    public static int binarySearch(int[][] matrix, int row, int colStart, int colEnd, int target){
        while(colStart<= colEnd){
            int mid = colStart + (colEnd - colStart) / 2;
            if(matrix[row][mid] == target) return mid;
            else if(matrix[row][mid] < target){
                colStart = mid + 1;
            }else{
                colEnd = mid - 1;
            }
        }
        return -1;
    }
}
