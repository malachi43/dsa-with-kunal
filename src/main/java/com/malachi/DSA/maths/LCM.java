package com.malachi.DSA.maths;

public class LCM {
    public static void main(String[] args) {
        System.out.println(lcm(2,7));
    }

    public static int gcd(int a, int b){
        while( a > 0 && b > 0){
            int max = Math.max(a,b);
            int min = Math.min(a,b);
            a = max % min;
            b = min;
        }
        return Math.max(a, b);
    }

    public static int lcm(int a, int b){
        /*
        LCM(Lowest Common Multiple) - this is the smallest number that can be divided by a and b without remainder.
        So if given a value that should be divisible by both a and b, shouldn't that value contain the value of a * b,
        since we are looking for the lowest common multiple that is divisible by both a and b, to get that we should eliminate the highest common factor
        of a and b, which we can by getting the GCD of a and b, so the formula for the LCM translates to this:

        LCM(a,b) = ( a * b )
                 -------------
                   GCD(a,b)
         */
        return ( a * b ) / gcd(a, b);
    }
}
