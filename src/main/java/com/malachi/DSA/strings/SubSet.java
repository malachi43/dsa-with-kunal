package com.malachi.DSA.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSet {
    public static void main(String[] args) {
        String[] arr = new String[]{"1","2","3"};
        System.out.println(subset(arr));
    }

    public static List<List<String>> subset(String[] arr){
        List<List<String>> outer = new ArrayList<>();
        //add an empty list first.
        outer.add(new ArrayList<>());

        //iterate through every item in the original array.
        for(String num : arr){
            //get the size of the outer array, so you can iterate through every element in it.
            int n = outer.size();
            for(int i = 0; i < n; i++){
                List<String> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                List<String> copy = new ArrayList<>(internal);
                outer.add(copy);
            }
        }
        return outer;
    }

}
