package com.malachi.DSA.bitwise;

public class BitWise {
    public static void main(String[] args) {
        System.out.println(convertDecimalToBinary(7));
        System.out.println("get magic number: " + getMagicNumber(5));
    }
    public static boolean isOdd(long n){
        return (n & 1) == 1;
    }

    public static int findUnique(int[] arr){
        int unique = 0; //note any number XOR with 0 will give back the same number.
        for (int element : arr) {
            unique ^= element;
        }
        return unique;
    }

    public static int findTheIthBit(int num, int ithBit){
        /*
        bit index ->                                                   8  7  6  5  4  3  2  1
        If you are asked to find the ith bit of this binary number say 1  1  0  1  1  1  0  1

        Let say you're asked to look for the 5th index of the above binary number. Remember, when you AND any digit with 1 you get back the number;
        So we would look for a way to place the digit 1 at the 5th index of the above binary number, to do that we can left shift the digit 1
        four times to get it at the fifth index. Let me give an illustration
    index ->          5
             1  1  0  1  1  1  0  1
    AND      0  0  0  1  0  0  0  0  ( A mask )
             -----------------------
             0  0  0  1  0  0  0  0
             -----------------------

             So the workflow to get the ith index of a binary digit is this:
             1. Left shift the digit 1 (n - 1) times,so to get the 7th digit we left shift 1 ( 7 - 1 ) times. I hope you get the pattern.
             2. Then AND the number n, with the result you get when you left shift 1 (n - 1)  times.
             3. n & ( 1 << (n - 1) )  - the gives the value of the ith bit.
         */

        return num & ( 1 << ( ithBit - 1 ) );
    }

    public static String convertDecimalToBinary(int n){
        if(n <=  0) throw new IllegalArgumentException("Please provide a positive number");
        StringBuilder binary = new StringBuilder();
        while (n > 0){
            int last = n & 1; //converts n to binary and get the last binary digit from the right.
            binary.append(last).append(" ");
            n = n >> 1; //this converts n to a binary number and shift it bits to the right.
        }
        return binary.reverse().toString();
    }

    public static int getMagicNumber(int n){
        /*
        suppose you have 1 0 1 in binary, the magic number would be (1 * 5^3) + (0 * 5^2) + (1 * 5^1) = 130
        A Magic Number is when you sum the product of every binary digit with an increasing multiple of 5 starting from the right, as illustrated above
         */
        int base = 5;
        int ans = 0;
        while(n > 0){
            int last = n & 1; //this converts n to a binary number and get the last digit from the right.
            ans += last * base;
            base = base * 5;
            n = n >> 1; //this converts n to a binary number and shift it bits to the right.
        }
        return ans;
    }
}
