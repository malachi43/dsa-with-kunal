package com.malachi.DSA.playground;

public final class Son extends Parent {

    public Son(){
        super();
    }

    void career() {
        System.out.println("This method was inherited from the '" + super.currentDate +  "' I am from the Son class career method - random value " + Parent.random);
    }
    void partner(){
        System.out.println("I am from the Son class partner method");
    }

    public static void main(String[] args) {
        Parent son = new Son();
        son.career();
        son.partner();
    }
}
