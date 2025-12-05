package com.malachi.DSA.recursion;

public class FiboFormula {
    public static void main(String[] args) {
        int n = 11;
     for(int i = 0; i < n; i++){
         System.out.print(fiboFormula(i) + " ");
     }
    }

    /*
     This formula can be used to get the fibonacci of any number
     fibonacci(n) = ( ( 1 + root(5) ) / 2 ) ^ n - ( ( 1 - root(5) ) / 2 ) ^ n  ) / root(5)
     */
    public static long fiboFormula(long n){
        double root1 = Math.pow((1 + Math.sqrt(5)) / 2, n);
        double root2 = Math.pow((1 - Math.sqrt(5)) / 2, n);
        double difference = root1 - root2;
        return (long) (difference / Math.sqrt(5));
    }
}
