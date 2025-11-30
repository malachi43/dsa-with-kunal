package com.malachi.DSA.maths;

import java.util.ArrayList;
import java.util.List;

public class Prime {
    public static void main(String[] args) {
        int n = 40;
       List<Integer> primeFactors = findPrimeFactors(n);
        System.out.println(primeFactors);
    }

    public static boolean isPrime(int num){
        if(num <= 1) return false;
        int i  = 2; //we start checking from 2.Remember, we already have a check for 1 in the first "if" condition.
        while(i * i <= num){
            if(num % i == 0) return false;
            i++;
        }
        return true;
    }

    public static List<Integer> findPrimeFactors(int n){
        List<Integer> primeFactors = new ArrayList<>();
        int i = 2;
        while ( i <= n){
            if(isPrime(i)){
                primeFactors.add(i);
            }
            i++;
        }
        return primeFactors;
    }
}
