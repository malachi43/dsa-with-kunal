package com.malachi.DSA.maths;

import java.util.ArrayList;
import java.util.List;

public class Factors {
    public static void main(String[] args) {
        int n = 36;
        List<Integer> factors = factors(n);
        List<Integer> factors2 = factors2(n);

        System.out.println("factors of " + n + " is = " + factors);
        System.out.println("factors2 of " + n + " is = " + factors2);

    }

    public static List<Integer> factors(int n){
        List<Integer> factors = new ArrayList<>();
        for(int i = 1; i * i <= n; i++){
           if(n % i == 0){
               factors.add(i);
               if(i != n/i){
                   factors.add(n / i);
               }
           }
       }
        factors.sort((a, b) -> a - b);
        return factors;
    }

    public static List<Integer> factors2(int n){
        List<Integer> factors = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            if(n % (i) == 0){
                factors.add(i);
            }
        }
        return factors;
    }


}
