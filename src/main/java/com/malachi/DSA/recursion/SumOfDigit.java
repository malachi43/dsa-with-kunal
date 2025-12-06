package com.malachi.DSA.recursion;

public class SumOfDigit {
    public static void main(String[] args) {
    }

    public static long sumOfDigits(int n){
        if( n == 0 ) return 0;
        return (n % 10) + sumOfDigits( n / 10);
    }
}
