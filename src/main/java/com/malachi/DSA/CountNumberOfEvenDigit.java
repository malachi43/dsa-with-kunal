package com.malachi.DSA;

import java.util.Arrays;

public class CountNumberOfEvenDigit {
    public static void main(String[] args) {
        int[] arr = {345,456,348, 123, 0, 900};
        int evenDigitCount = numberOfEvenDigits(arr);
        System.out.println("The number of even digits in the array, " + Arrays.toString(arr) + " is: " + evenDigitCount);
    }

    public static int digitCount(int digit){
        return (int) Math.log10(digit) + 1; //this returns the digit count in constant time.
    }

    public static int numberOfEvenDigits(int[] arr){
        int evenDigitCount = 0;
        for(int num : arr){
            if(digitCount(num) % 2 == 0) evenDigitCount++;
        }
        return evenDigitCount;
    }
}
