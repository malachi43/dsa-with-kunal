package com.malachi.DSA.maths;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sieve {
    public static void main(String[] args) {
        int n = 15;
        List<Integer> primes = sieve(n);
        System.out.println(primes);
    }

    private static List<Integer> sieve(int n) {
        boolean[] primeFlags = new boolean[n + 1];
        Arrays.fill(primeFlags, true); //fill all the array indices with "true"
        for(int i = 2; i * i <= n; i++){
            if(isPrime(i)){
                for(int j = i * 2; j <= n; j += i){
                    primeFlags[j] = false; //convert all multiples of this prime index to false. (Because all multiples of a prime number is not a prime number)
                }
            }
        }

        //return every index that has a boolean value true.
        List<Integer> primes = new ArrayList<>();
        for(int i = 2; i <= n; i++){
            if(primeFlags[i]) primes.add(i);
        }
        return primes;
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

}
