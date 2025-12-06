package com.malachi.DSA;

public class Ordinal {
    public static void main(String[] args) {
        int n = 5;
        ordinal(5);
    }

    public static void ordinal(int n){
        if( n == 0) return;
        System.out.println(n);
        System.out.println("****************");
        ordinal(n - 1);
        System.out.println(n);
        System.out.println("::::::::::::::::");
    }

}
