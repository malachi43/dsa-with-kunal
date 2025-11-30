package com.malachi.DSA.maths;

import java.io.FilterOutputStream;

public class GCD {
    public static void main(String[] args) {
        int result = gcd3(105,224);
        System.out.println("gcd is : " + result);
    }

    /*
    Euclidean Algorithm to compute the GCD(Greatest Common Divisor) - the highest factor that divides both numbers without any remainder.
    HOW IT WORKS:
    1. If you are given two numbers.
    2. Divide the larger number with the smaller number.
    3. Replace the larger number with remainder of the division gotten from step 2.
    4. Continue Step 2 and Step 3 until the remainder is zero.
    5. The last non-zero remainder is the GCD

    IN SUMMARY:
    The Euclidean Algorithm is an efficient method for finding the greatest common divisor(GCD) of two integers.
    It works by repeatedly applying division algorithm, where you replace the larger number with the remainder of
    the division until the remainder is 0. The last non-zero remainder is the GCD.
    */
    public static int gcd(int a, int b){
        while( a > 0 && b > 0){
            int max = Math.max(a,b);
            int min = Math.min(a,b);
            a =  max % min;
            b = min;
        }
        return Math.max(a, b);
    }

    public static int gcd2(int a, int b){
        while( a != b){
            int max = Math.max(a,b);
            int min = Math.min(a,b);
            a = max - min;
            b = min;
        }
        //at this point a == b, so we can return either a or b.
        return a;
    }

    public static int gcd3(int a, int b){
        if(a == 0) return b;
        return gcd(b % a, a);
    }


}
