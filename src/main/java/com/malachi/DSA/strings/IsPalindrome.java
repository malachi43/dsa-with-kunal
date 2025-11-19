package com.malachi.DSA.strings;

public class IsPalindrome {
    public static void main(String[] args) {
    }

    public static boolean isPalindrome(String text){
        if(text == null || text.length() == 1) return true;

        text = text.toLowerCase();

        int start = 0;
        int end = text.length() - 1;

        for(int i = 0; i < text.length() / 2; i++){
            if(text.charAt(start) == text.charAt(end)){
                start++;
                end--;
            }else{
                return false;
            }
        }
        return true;
    }
}
