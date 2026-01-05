package com.malachi.DSA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static void main(String[] args) {
       List<List<String>> ans = new Solution().solveNQueens(4);
        System.out.println(ans);
    }
    public List<List<String>> solveNQueens(int n) {
        String[][] board = new String[n][n];
        for (String[] strings : board) {
            Arrays.fill(strings, ".");
        }
        return queens(board, 0);
    }

    public List<List<String>> queens(String[][] board, int row){
        if(row == board.length){
            List<List<String>> paths = new ArrayList<>();
            List<String> path = new ArrayList<>();
            for(String[] newRow : board){
                StringBuilder ans = new StringBuilder();

                for(String newCol : newRow){
                    ans.append(newCol);
                }
                path.add(ans.toString());
            }
            paths.add(path);
            return paths;
        }

        List<List<String>> result = new ArrayList<>();
        for(int i = 0; i < board.length; i++){
            //check if it is safe to place queen
            if(isSafeToPlaceQueen(board,row, i)){
                board[row][i] = "Q";
                List<List<String>> ans =  queens(board, row + 1);
                result.addAll(ans);
                board[row][i] = ".";
            }
        }
        return result;
    }

    public boolean isSafeToPlaceQueen(String[][] board, int row, int col){
        //check if queen can be placed at the top
        for(int i = 0; i <= row; i++){
            if(board[row - i][col].equals("Q")){
                return false;
            }
        }

        //check if queen can be placed at left diagonal
        for(int i = 1; i <= Math.min(row, col); i++){
            if(board[row - i][col - i].equals("Q")){
                return false;
            }
        }

        //check if queen can be placed at right diagonal
        for(int i = 1; i <= Math.min(board.length - col - 1, row); i++){
            if(board[row - i][col + i].equals("Q")){
                return false;
            }
        }

        return true;
    }
}