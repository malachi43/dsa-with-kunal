package com.malachi.DSA.comparing;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Main {

    enum Week {
        Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday;

        Week(){
            System.out.println("constructor called for " + this);
        }
    }

    enum Characters {
        Goblin("goblin"), Superman("Clark"), Batman("Bruce Wayne"), Ironman("Tony Stark");
        String name;
        Characters(String name){
            this.name = name;
        }

        int getCharacterLength(){
            return this.name.length();
        }

        String getName(){
            return this.name;
        }
    }

    public int findPivotElement(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        System.out.println();
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(mid < end && arr[mid] > arr[mid + 1]) return arr[mid];
            if(mid > start && arr[mid - 1] > arr[mid]) return arr[mid - 1];
            if(arr[start] >= arr[mid]){
                end =  mid - 1;
            }
            if(arr[start] < arr[mid]){
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
//        Student malachi = new Student("Malachi", 12, 78.89f);
//        Student mikey = new Student("Mikey", 5, 98.89f);
//        Student sarah = new Student("Sarah", 2, 88.89f);
//        Student other = (Student) malachi.clone();

//        System.out.println("other -> " + other);
//        other.nums[0] = 111;
//        List<Student> list =  new ArrayList<Student>();
//        list.add(malachi);
//        list.add(mikey);
//        list.add(sarah);

//        list = list.stream().sorted().toList();
//        Consumer<Student> printValue = System.out::println;
//        list.forEach(printValue);

        Operation sum = (a, b)  -> a + b;
        Operation mul = (a, b) -> a * b;
        Operation sub = (a, b) -> a - b;

        Main main = new Main();
        System.out.println("Highest Mountain peak -> " + main.findPivotElement(new int[]{6,7,8,9,1,2,3,4,5,6}));
        int result = main.operation(5,3, mul);
        System.out.println("result : " + result);
        System.out.println("Character -> " + Main.Characters.Batman);
        System.out.println("weekdays: " + Week.Saturday);
//       for(Week day: Week.values()){
//           System.out.println("day " + (day.ordinal() + 1) + " of the week: " + day);
//       }
    }

    public int operation(int a, int b, Operation op){
        return op.operation(a,b);
    }

}


@FunctionalInterface
interface Operation{
    int operation(int a, int b);
}

