package com.malachi.DSA;

public class Singleton {
    private static Singleton instance;

    //private means that this constructor can be invoked only this file.
    private Singleton(){

    }

    public static Singleton getInstance(){
        //check whether 1 object only is created or not
        if(instance == null){
            instance = new Singleton();
        }

        return instance;
    }
}
