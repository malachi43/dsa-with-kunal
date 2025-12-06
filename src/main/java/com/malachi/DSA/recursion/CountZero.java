package com.malachi.DSA.recursion;

public class CountZero {
    public static void main(String[] args) {
        long n = 30200;
        int zeroCount = countZero(n, 0);
        System.out.println("zero count is: " + zeroCount);
    }

    public static int countZero(long n,  int zeroCount){
        if( n == 0) return zeroCount;
        long lastDigit = n % 10;
        if( lastDigit == 0 ) ++zeroCount;
        return countZero(n / 10, zeroCount);
    }

}
