package com.malachi.DSA.strings;

import java.util.ArrayList;
import java.util.List;

public class PhonekeypadCombination {
    public static void main(String[] args) {
        System.out.println(keypadCombination("","23"));
    }

    public static List<String> keypadCombination(String processed, String unprocessed) {
        if(unprocessed.isEmpty()){
            List<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
        int digit = unprocessed.charAt(0) - '0' - 1;

        int m  = (digit - 1) * 3;
        int n = digit * 3;

        //when 7 is entered on the keypad.
        if(digit == 6){
            n = (digit * 3) + 1;
        }

        //when 8 is entered on the keypad
        if(digit == 7){
            m += 1;
            n = (digit * 3) + 1;
        }

        //when 9 is entered on the keypad
        if(digit == 8){
            m += 1;
            n = (digit * 3) + 2;
        }

        /*
        Each digit has the following mappings:
        2 -> abc
        3 -> def
        4-> ghi
        5 -> jkl
        6 -> mno
        7 -> pqrs
        8 -> tuv
        9 -> wxyz

         */
        //this will contain the answer from the previous recursive calls.
        List<String> list = new ArrayList<>();
        for(int i = m; i < n; i++){
            char ch = (char) ('a' + i);
            //holds the answer to the previous recursive calls.
            List<String> ans = keypadCombination(processed + ch, unprocessed.substring(1));
            list.addAll(ans);
        }
        return list;
    }
}
