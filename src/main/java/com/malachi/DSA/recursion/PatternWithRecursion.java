package com.malachi.DSA.recursion;

public class PatternWithRecursion {
    public static void main(String[] args) {
        int r = 10;
        int c = 0;
        normalTriangle(r,c);    }

    public static void invertedTriangle(int r, int c){
        if( r == 0) return;
        if( c < r){
            System.out.print(" * ");
            invertedTriangle(r, c + 1);
        }else{
            System.out.println();
            invertedTriangle(r - 1, 0);
        }
    }

    public static void normalTriangle(int r, int c){
        if( r == 0) return;
        if( c < r){
            normalTriangle(r, c + 1);
            System.out.print(" * ");
        }else{
            normalTriangle(r - 1, 0);
            System.out.println();
        }
    }
}
