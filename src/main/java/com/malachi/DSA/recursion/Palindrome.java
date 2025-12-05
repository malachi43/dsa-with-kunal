package com.malachi.DSA.recursion;

public class Palindrome {
    public static void main(String[] args) {
        String text = "abbd";
        boolean isPalindrome = isPalindrome(text, 0, text.length() - 1);
        System.out.println("isPalindrome: " + isPalindrome);
    }

    public static boolean isPalindrome(String text, int start, int end){
        if(text.isEmpty()) return true;
        text = text.toLowerCase();
        //at this point "start" and "end" point to the same letter.
        if(start == end) {
            return true;
        }
        /*
        If the character at position start and end is equal, then we move on to check the next characters
        by incrementing "start" to check the next character by moving from left to right and decrementing "end" to check the next moving from right to left
        */
        if(end >= 0 && text.charAt(start) == text.charAt(end)){
            return isPalindrome(text, start + 1, end - 1);
        }else{
            /*
             If "end" is negative or less than 0, it means the text is a palindrome,
             this means "start" and "end" have their pointers crossed and this can only occur if their characters were equal at the previous check.
            */
            return end < 0;
        }
    }
}
