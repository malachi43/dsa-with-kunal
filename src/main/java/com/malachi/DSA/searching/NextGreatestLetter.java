package com.malachi.DSA.searching;

public class NextGreatestLetter {
    public static void main(String[] args) {

    }
    //https://leetcode.com/problems/find-smallest-letter-greater-than-target/submissions/1796318943/?envType=problem-list-v2&envId=array
    public static char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;

        while(start <= end){
            int mid = start + (end - start)/ 2;
            if(target >= letters[mid]){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return letters[start % letters.length];
    }
}
