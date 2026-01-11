package com.malachi.DSA.generics;

import java.util.Arrays;

public class CustomArrayList<T> {
    private Object[] data;
    private static int DEFAULT_SIZE = 10;
    private int size = 0;

    public CustomArrayList(){
        data = new Object[DEFAULT_SIZE];
    }

    public boolean isFull(){
        return size == data.length;
    }

    public void resize(){
        int newSize = size * 2;
        Object[] temp = new Object[newSize];
        //copy item into the newData array
        for(int i = 0; i < size; i++){
            temp[i] = data[i];
        }
        data = temp;
    }

    public void add(int num){
        if(isFull()){
            resize();
        }
        data[size++] = num;
    }

    public T remove(){
        return (T) data[--size];
    }

    public T get(int index){
        if(index < size){
            return (T) data[index];
        }
        return null;
    }

    public int size(){
        return size;
    }

    public void set(int index, T num){
       if(index < size){
           data[index] = num;
       }
    }

    @Override
    public String toString(){
        return Arrays.toString(data);
    }


    public static void main(String[] args) {
        CustomArrayList<Integer> list = new CustomArrayList<>();
        for(int i = 0; i < 3; i++){
            list.add( i + 1);
        }
        list.set(0, 12);
        System.out.println(list);
        System.out.println(list.get(0));
        System.out.println("size : " + list.size());
    }
}
