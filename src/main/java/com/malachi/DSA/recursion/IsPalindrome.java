package com.malachi.DSA.recursion;

public class IsPalindrome {
    public static void main(String[] args) {
        int n = 1;
        boolean isPalindrome = isPalindrome(n);
        System.out.println("is " + n + " a palindrome? " + isPalindrome);
    }

    public static boolean isPalindrome(int n){
        return ReverseADigit.reverseDigits(n,0) == n;
    }

}
