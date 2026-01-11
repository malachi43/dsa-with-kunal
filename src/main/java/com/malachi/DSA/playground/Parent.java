package com.malachi.DSA.playground;

import java.time.LocalDate;
import java.util.Date;

public abstract class Parent {
    static int random;
    String currentDate;

    static {
        System.out.println("this is ran first before the constructor");
        random = (int) (Math.random() * 5);
    }


    Parent(){
        System.out.println("Parent constructor ran.");
        currentDate = new Date().toLocaleString();
    }

    abstract void career();
    abstract void partner();
}
