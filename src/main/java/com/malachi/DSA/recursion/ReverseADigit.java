package com.malachi.DSA.recursion;

public class ReverseADigit {
    public static void main(String[] args) {
        int digits = 246810;
        System.out.println(reverseDigits(digits, 0));
    }

    public static int reverseDigits(int n, int accumulator){
        if( n == 0){
            return accumulator;
        }
        int lastDigit = n % 10;
        int reverse = (accumulator * 10) + lastDigit;
        return reverseDigits( n  / 10, reverse);
    }
}
