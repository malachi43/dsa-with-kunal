package com.malachi.DSA.strings;

import org.springframework.boot.rsocket.context.RSocketPortInfoApplicationContextInitializer;

import java.util.ArrayList;
import java.util.List;

/*
A SUBSET PATTERN - You either take an element or ignore the element.
At the end of the recursion calls you will have all the possible subsets for the value for which the recursion calls were invoked.
E.g Given "abc" -> [ a / bc] or [ "" / bc ]  (So in the example, given "abc", you can decide to take "a" or ignore it (this is the concept subset is built upon)
 */
public class Subsequence {
    public static void main(String[] args) {
        String str = "abc";
        List<String> result = subsequence("abc","");
        System.out.println("subset of '" + str + "' is: " + result);
    }
    public static List<String> subsequence(String str, String current) {
        if(str.isEmpty()){
            List<String> list = new ArrayList<String>();
            list.add(current);
            return list;
        }
        List<String> left = subsequence(str.substring(1), current + str.charAt(0));
        List<String> right = subsequence(str.substring(1), current);
        left.addAll(right);
        return left;
    }

    public static List<String> subsequenceAscii(String str, String current) {
        if(str.isEmpty()){
            List<String> list = new ArrayList<>();
            list.add(current);
            return list;
        }
        char ch = str.charAt(0);
        List<String> left = subsequenceAscii(str.substring(1), current + ch);
        List<String> mid = subsequenceAscii(str.substring(1), current + (int) (ch));
        List<String> right = subsequenceAscii(str.substring(1), current);
        left.addAll(right);
        left.addAll(mid);
        return left;
    }

}


