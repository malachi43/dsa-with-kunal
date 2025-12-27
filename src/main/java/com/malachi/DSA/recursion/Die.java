package com.malachi.DSA.recursion;

import java.util.ArrayList;
import java.util.List;

public class Die {
    public static void main(String[] args) {
        int target = 4;
        System.out.println("number combination -> " + dice("", target));
        System.out.println("There are " + dice("", target).size() + " way(s) to form the number " + target + " on a die");
    }

    public static List<List<Integer>> dice(String processed, int target){
        int MAX_DIE_NUMBER = 6;
        if(target > MAX_DIE_NUMBER){
            throw new IllegalArgumentException("'target' must be in the range 1 - " + MAX_DIE_NUMBER);
        }
        if(target == 0){
            List<List<Integer>> list = new ArrayList<>();
            char[] charArray = processed.toCharArray();
            List<Integer> result = new ArrayList<>();
            for(char element : charArray){
                int digit = element - '0';
                result.add(digit);
            }
            list.add(result);
            return list;
        }

        List<List<Integer>> result = new ArrayList<>();
        for(int i = 1; i <= MAX_DIE_NUMBER && i <= target; i++ ){
            List<List<Integer>> resultFromPreviousRecursiveCall = dice(processed + i, target - i);
            result.addAll(resultFromPreviousRecursiveCall);
        }
        return result;
    }


}
