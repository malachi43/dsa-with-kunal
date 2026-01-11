package com.malachi.DSA.comparing;

import java.util.Arrays;

public class Student implements  Comparable<Student>, Cloneable{
    private final int rollno;
    private final float marks;
    private final String name;
    int[] nums = new int[]{2,4,6,8};
    public Student(String name, int rollno, float marks){
        this.rollno = rollno;
        this.marks = marks;
        this.name = name;
    }
    @Override
    public int compareTo(Student other) {
        return (int) (other.marks - this.marks);
    }

    public int getRollno() {
        return rollno;
    }

    public float getMarks(){
        return marks;
    }

    public String getName(){
        return name;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


    public String toString(){
        return "Student { " + "name" + ": " + name + ", " + "rollno: " + rollno + ", " + "marks: " + marks + " , nums: " +  Arrays.toString(nums) + " }";
    }


}
