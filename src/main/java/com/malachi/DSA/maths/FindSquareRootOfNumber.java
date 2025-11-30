package com.malachi.DSA.maths;

public class FindSquareRootOfNumber {
    public static void main(String[] args) {
        int n = 40;
        int precision = 3;
        double squareRootOfNumber = findSquareRootOfNumber(n, precision);
        System.out.println("square root of " + n + " is = " + squareRootOfNumber);
    }

    //we used binary search because we are looking for a number between 1 - n that is the square root of n. Numbers from 1 - n follow a sequence
    public static double findSquareRootOfNumber(int n, int precision){
        int start = 0;
        int end = n;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if(mid * mid == n) return mid;
            else if(mid * mid < n){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        double root = 0.0;
        double increment = 0.1;
        //when we reach this point we know that no perfect root was found above.
        for(int i = 0; i < precision; i++){
            while (root * root < n){
                root += increment;
            }
            /*
            we subtract the "increment" from "root" because the condition in the while loop is while (root * root < n),
            so for the loop to break it means that (root * root) is greater than "n"
            so we subtract the "increment" from root to get the previous value of "root" whose square (root * root) was less than "n".
             */
            root -= increment;
            increment /= 10;
        }

        return Double.parseDouble(String.format("%.3f", root));
    }
}
