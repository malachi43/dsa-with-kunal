package com.malachi.DSA.patterns;

import org.springframework.core.StandardReflectionParameterNameDiscoverer;

public class Patterns {
    public static void main(String[] args) {
        pattern9(5);
    }

    public static void pattern1(int n){
        for(int row = 1; row <= n; row++){
            //for every row, print n number of "asterisks" for this col.
            for(int col = 0; col < n; col++){
                System.out.print("*");
            }
            //after every row print a newline.
            System.out.println();
        }
    }
    public static void pattern2(int n){
        for(int row = 1; row <= n; row++){
            //for every row, print an "asterisks" equal to the current row.
            for(int col = 0; col < row; col++){
                System.out.print("*");
            }
            //after every row print a newline.
            System.out.println();
        }
    }

    public static void pattern3(int n){
        for(int row = 0; row < n; row++){
            //for every row print decreasing number of "asterisks" starting from n
            for(int col = 0; col < n - row; col++ ){
                System.out.print("*");
            }
            //after every row print a newline.
            System.out.println();
        }
    }

    public static void pattern4(int n){
        for(int row = 1; row <= n; row++){
            //for every row append the value of col to the serial reference variable and print the append value at the end of the current col iteration.
            for(int col = 1; col <= row; col++){
                System.out.print(" " + col + " ");
            }
            System.out.println();
        }
    }

    public static void pattern5(int n){
        int N = 2 * n;
       for(int row = 1; row <= N - 1; row++){
           int totalColsInRow = row <= n ? row : N - row; //for values greater than N we start printing in decreasing amount of n.
           for(int col = 0; col < totalColsInRow; col++){
               System.out.print("*");
           }
           System.out.println();
       }
    }

    public static void pattern6(int n){
        int N = 2 * n;
        for(int row = 1; row <= N - 1; row++){
            int totalAsterisksInRow = row <= n ? row : N - row; //for values greater than N we start printing in decreasing amount of n.
            //totalColsInRow will follow the sequence 1,2,3,4,5,4,3,2,1 for n = 5;

            int noOfSpaces = n - totalAsterisksInRow;
            for(int s = 0; s < noOfSpaces; s++){
                System.out.print(" ");
            }

            for(int col = 0; col < totalAsterisksInRow; col++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void pattern7(int n){
        for(int row = 1; row <= n; row++){

            int noOfSpaces = n - row;
            for(int s = 0; s < noOfSpaces; s++){
                System.out.print("  ");
            }

            for(int col = row; col >= 1; col--){
                System.out.print(col + " ");
            }

            for(int col = 2; col <= row; col++){
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    public static void pattern8(int n){
        int N = 2 * n;
        for(int row = 1; row < N;  row++){

            int c = row <= n ? row : N - row;

            int noOfSpaces = n - c;
            for(int s = 0; s < noOfSpaces; s++){
                System.out.print("  ");
            }

            for(int col = c; col >= 1; col--){
                System.out.print(col + " ");
            }

            for(int col = 2; col <= c; col++){
                System.out.print(col + " ");
            }

            System.out.println();
        }
    }

    public static void pattern9(int n){
        int N = 2 * n;
        int originalN = n;
        for(int row = 1; row < N; row++){
            for(int col = 1; col < N; col++){
                int minDistanceOnYAxis = Math.min(row - 1, (N - 1) - row);
                int minDistanceOnXAxis = Math.min(col - 1, (N - 1) - col);

                int minDistanceToElementAtThisIndex = Math.min(minDistanceOnXAxis, minDistanceOnYAxis);
                int value = originalN - minDistanceToElementAtThisIndex;

                System.out.print(" " + value + " ");
            }
            System.out.println();
        }
    }
}
