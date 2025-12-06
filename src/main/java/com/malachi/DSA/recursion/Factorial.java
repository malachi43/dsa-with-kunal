package com.malachi.DSA.recursion;

public class Factorial {
    public static void main(String[] args) {
    }

    public static long factorial(int n){
        if( n <= 1 ) return 1;
        return n * factorial(n - 1);
    }





}
