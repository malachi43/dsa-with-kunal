package com.malachi.DSA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }

    public static List<List<String>> solveNQueens(int n){
       char[][] board = new char[n][n];
       for(char[] row : board){
           Arrays.fill(row, '.');
       }
      return placeQueen(board, 0);
    }

    public static List<List<String>> placeQueen(char[][] board, int row){
        if(row == board.length){
            for(char[] newRow: board){
                System.out.println(Arrays.toString(newRow));
            }
            System.out.println();
            List<List<String>> ans = new ArrayList<>();
            List<String> line = new ArrayList<>();
            for(char[] newRow : board){
                line.add(new String(newRow));
            }
            ans.add(line);
            return ans;
        }

        List<List<String>> finalAns = new ArrayList<>();
        for(int i = 0; i < board.length; i++) {
            if (isSafeToPlaceQueen(board, row, i)) {
                board[row][i] = 'Q';
                List<List<String>> ans = placeQueen(board, row + 1);
                finalAns.addAll(ans);
                board[row][i] = '.';
            }
        }

        return finalAns;
    }

    public static boolean isSafeToPlaceQueen(char[][] board, int row, int col){
        //check if queen can be placed at the top
        for(int i = 0; i <= row; i++){
            if(board[row - i][col] == 'Q'){
                return false;
            }
        }

        //check if queen can be placed at left diagonal
        for(int i = 1; i <= Math.min(row, col); i++){
            if(board[row - i][col - i] == 'Q'){
                return false;
            }
        }

        //check if queen can be placed at right diagonal
        for(int i = 1; i <= Math.min(board.length - col - 1, row); i++){
            if(board[row - i][col + i] == 'Q'){
                return false;
            }
        }

        return true;
    }


}
