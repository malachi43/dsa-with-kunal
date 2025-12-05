package com.malachi.DSA.recursion;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 50;
        Map<Integer, Long> lookupTable = new HashMap<>();
        long result = fib(n, lookupTable);
        System.out.println("The fibonacci of " + n  + " is: " + String.format("%,d", result));
    }

    //Fibonacci using memoization
    public static long fib(int n, Map<Integer, Long> lookupTable){
        if(n < 2){
            return n;
        }
        if(lookupTable.containsKey(n)){
            return lookupTable.get(n);
        }
        long value =  fib(n - 1, lookupTable) + fib( n - 2, lookupTable);
        lookupTable.put(n, value);
        return value;
    }
}
