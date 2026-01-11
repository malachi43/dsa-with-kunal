package com.malachi.DSA.playground;

public class A {
    //nested interface
    public interface NestedInterface{
        boolean isOdd(int num);
    }
}

class B implements A.NestedInterface {

    @Override
    public boolean isOdd(int num) {
       return (num & 1) == 1;
    }


    public static void main(String[] args) {
        B obj = new B();
        int num = 2;
        boolean result = obj.isOdd(num);
        System.out.println("is " + num + " odd? " + result);
    }
}

