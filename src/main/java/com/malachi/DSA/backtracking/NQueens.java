package com.malachi.DSA.backtracking;

import java.util.Arrays;

public class NQueens {
    public static void main(String[] args) {
        int n = 4;
      boolean[][] board = new boolean[n][n];
        int result = queens(board, 0);
        System.out.println("result: " + result);
    }

    public static int queens(boolean[][] board, int row){
        if(row == board.length){
            display(board);
            System.out.println();
            return 1;
        }

       int count = 0;
       for(int col = 0; col < board.length; col++){
           //place queen if it is safe
           if(isSafeToPlaceQueen(board, row, col)) {
               board[row][col] = true;
               count += queens(board,row + 1);
               board[row][col] = false;
           }
       }

        return count;
    }

    private static void display(boolean[][] board) {
        for(boolean[] row: board){
            for(boolean col: row){
                if(col){
                    System.out.print("  Q  ");
                }else{
                    System.out.print("  X  ");
                }
            }
            System.out.println();
            System.out.println("--------------------");
        }
    }

    public static boolean isSafeToPlaceQueen(boolean[][] board, int row, int col){
        //check left diagonal
        int maxLeft =  Math.min(row,col);
        for(int i = 1; i <= maxLeft; i++){
            int newRow = row - i;
            int newCol = col - i;
            if(board[newRow][newCol]){
                return false;
            }
        }

        //check top
        for(int i = 1; i <= row; i++){
            int newRow = row - i;
            if(board[newRow][col]){
                return false;
            }
        }

        //check right diagonal
        int maxRight =  Math.min(row, board.length - col - 1);
        for(int i = 1; i <= maxRight; i++){
            int newRow = row - i;
            int newCol = col + i;
            if(board[newRow][newCol]){
                return false;
            }
        }

        return true;
    }


}
