package com.malachi.DSA.recursion.array;

import java.util.ArrayList;
import java.util.List;

public class Search {
    public static void main(String[] args) {
        int[] nums = {5,6,7,8,9,1,2,3};
        int target = 3;
        List<Integer> result = findOccurrences2(nums, target,0);
//        int result = search(nums, target);
        System.out.println("result: " + result);
    }

    public static int search(int[] arr, int target){
      int startingIndex = 0;
      return helper(arr, target, startingIndex);
    }


    public static List<Integer> findOccurrences(int[] arr, int target){
        List<Integer> foundIndex = new ArrayList<>();
        int startingIndex = 0;
        //in this case we are passing a list to the method parameter.
        return helper2(arr, target, startingIndex, foundIndex);
    }

    private static List<Integer> helper2(int[] arr, int target, int index, List<Integer> foundIndex) {
        if(index == arr.length) {
            return foundIndex;
        }
        if(arr[index] == target){
            foundIndex.add(index);
        }
        return helper2(arr, target, index + 1, foundIndex);
    }

    public static int helper(int[] arr, int target, int index){
        if(index == arr.length) {
            return -1;
        }
        if(arr[index] == target) return index;
        else{
            return helper(arr, target, index + 1);
        }
    }

    //in this case we are creating the list in the method body that will be returned at the end of all the function calls.
    public static List<Integer> findOccurrences2(int[] arr, int target, int index){
        List<Integer> list = new ArrayList<>();
        if(index == arr.length){
            return list;
        }

        //this list will contain the index of the target for this function call only.
        if(arr[index] == target){
            list.add(index);
        }

        List<Integer> returnedListFromPreviousMethodCalls = findOccurrences2(arr, target, index + 1);
        //check if the current "list" in this method body is not empty, if it contains elements, add each of the elements to the returned list.
        if(!list.isEmpty()){
            returnedListFromPreviousMethodCalls.addAll(list);
        }

        //allow for garbage collection.
        list = null;
        return returnedListFromPreviousMethodCalls;
    }

}
