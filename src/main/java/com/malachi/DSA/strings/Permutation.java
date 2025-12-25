package com.malachi.DSA.strings;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
    }

    public static List<String> permutate(String processed, String unprocessed){
        if(unprocessed.isEmpty()){
            List<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
        List<String> ans = new ArrayList<>();
        //We get the number of recursive calls to make using the length of the processed string. No of recursive calls = processed.length + 1
        for(int i = 0; i < processed.length() + 1; i++){
            String first = processed.substring(0, i);
            char ch = unprocessed.charAt(0);
            String second = processed.substring(i);
            List<String> resultFromPreviousRecursiveCalls = permutate(first + ch + second, unprocessed.substring(1));
            ans.addAll(resultFromPreviousRecursiveCalls);
        }
        return ans;
    }

    public static int permutationCount(String processed, String unprocessed){
        if(unprocessed.isEmpty()){
            return 1;
        }
        int noOfPermutations = 0;
        //We get the number of recursive calls to make using the length of the processed string. No of recursive calls = processed.length + 1
        for(int i = 0; i < processed.length() + 1; i++){
            String first = processed.substring(0, i);
            char ch = unprocessed.charAt(0);
            String second = processed.substring(i);
            noOfPermutations = noOfPermutations +  permutationCount(first + ch + second, unprocessed.substring(1));
        }
        return noOfPermutations;
    }
}
