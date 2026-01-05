package com.malachi.DSA.backtracking;

import java.util.Arrays;

public class SudokuSolver {
    public static void main(String[] args) {
        int[][] sudokuBoard = new int[][]{
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},

                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},

                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

       solveSudoku(sudokuBoard, 0, 0);
    }


    public static void  solveSudoku(int[][] board, int row, int col) {
        //base case, if we get to this point the sudoku is solved.
       if(row == 8 && col == 9){
           display(board);
           return;
       }

        if(col == 9){
            //if we get to the end of the column move to the next row.
             solveSudoku(board, row + 1, 0);
             return;
        }

       if(board[row][col] != 0){
           //if the current col is already pre-populated go to the next col.
           solveSudoku(board, row, col + 1);
           return;
       }

       for(int i = 1; i <= 9; i++){
           if(isSafe(board, row, col, i)){
               board[row][col] = i;
               solveSudoku(board, row, col + 1);
           }
           board[row][col] = 0;
       }
     }


    private static void display(int[][] board) {
        for(int[] row : board ){
            System.out.println(Arrays.toString(row));
        }
    }

    public static boolean isSafe(int[][] board, int row, int col, int num){
        //check if it is safe to put digit in row
        int[] rowToCheck = board[row];
       for(int item : rowToCheck){
           if(item == num){
               return false;
           }
       }

        //check if it is safe to put digit in column.
        for (int[] ints : board) {
            if (ints[col] == num) {
                return false;
            }
        }

        //check if it is safe to put in 3x3 grid
        int startRow = row - (row % 3);
        int startCol = col - (col % 3);

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i + startRow][j + startCol] == num){
                    return false;
                }
            }
        }

        return true;
    }

}
