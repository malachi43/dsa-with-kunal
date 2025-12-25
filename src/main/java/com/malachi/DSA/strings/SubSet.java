package com.malachi.DSA.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSet {
    public static void main(String[] args) {
    }

    public static List<List<String>> subset(String[] arr){
        List<List<String>> outer = new ArrayList<>();
        //add an empty list first.
        outer.add(new ArrayList<>());

        //iterate through every item in the original array give in the method parameter.
        for(String num : arr){
            //get the size of the outer array, so you can iterate through every element in it.
            int n = outer.size();
            for(int i = 0; i < n; i++){
                //create a copy of eah list in the "outer" arraylist.
                List<String> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }
        return outer;
    }

    public static List<List<String>> subsetHandleDuplicate(String[] arr){
        Arrays.sort(arr);
        List<List<String>> outer = new ArrayList<>();
        //add an empty list first.
        outer.add(new ArrayList<>());

        int start = 0;
        int end = 0;

        //iterate through every item in the original array give in the method parameter.
        for(int k = 0; k < arr.length; k++){
            //check if previous is equal to current
            if(k > 0 && arr[k - 1].equals(arr[k])){
                start = end + 1;
            }
            end = outer.size() - 1;

            //get the size of the outer array, so you can iterate through every element in it.
            int n = outer.size();
            for(int i = start; i < n; i++){
                //create a copy of eah list in the "outer" arraylist.
                List<String> internal = new ArrayList<>(outer.get(i));
                internal.add(arr[k]);
                outer.add(internal);
            }
        }
        return outer;
    }

}
