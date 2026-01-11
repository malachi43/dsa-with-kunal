package com.malachi.DSA.datastructures;

import java.util.List;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size = 0;

    private class Node{
        int value;
        Node next;

        Node(int value){
            this.value =value;
        }

        Node(int value, Node next){
            this.value = value;
            this.next = next;
        }

        public String toString(){
            return "{ node: " + value + " , " + "next: " +( next != null ? "true" : "false") + "}";
        }
    }

    public void insertFirst(int value){
        Node node = new Node(value);
        node.next = head;
        head = node;
        if(tail == null){
            tail = head;
        }
        ++size;
    }

    public void insertLast(int value){
        if(tail == null){
           insertFirst(value);
           return;
        }
        Node node = new Node(value);
        tail.next = node;
        tail = node;
        ++size;
    }

    public void insert(int index,  int value){
        if(index == 0){
            insertFirst(value);
            return;
        }
        if(index == size || index > size){
            insertLast(value);
            return;
        }
        Node temp = head;
        for(int i = 1; i < index; i++){
            temp = temp.next;
        }
        temp.next = new Node(value, temp.next);
        ++size;
    }

    public int deleteFirst(){
        Node temp = head;
        if(temp == null) return - 1;
        head = temp.next;
        if(head == null){
            tail = null;
        }
        --size;
        return temp.value;
    }

    public Node get(int index){
        if(index < 0) return null;
        if(index >= size) return null;
        Node node = head;
        for(int i = 0; i < index; i++){
            node = node.next;
        }
        return node;
    }

    public int delete(int index){
        if(index >= size) return -1;
        if(index == 0){
            return deleteFirst();
        }
        if(index == size - 1){
           return deleteLast();
        }
        Node nodeBeforeNodeToDelete = get(index - 1);
        Node nodeToDelete = get(index);
        nodeBeforeNodeToDelete.next = nodeToDelete.next;
        --size;
        return nodeToDelete.value;
    }


    public int deleteLast(){
        if(size == 0) return -1;
        if(size == 1){
            int value = head.value;
            head = null;
            tail = null;
            --size;
            return value;
        }
        Node secondLast = get(size - 2);
        int value = tail.value;
        tail = secondLast;
        tail.next = null;
        --size;
        return value;
    }

    public Node find(int value){
       for(int i = 0; i < size; i++){
           Node node = get(i);
           if(node != null){
               if( node.value == value){
                   return node;
               }
           }
       }
       return null;
    }


    public void display(){
        Node node = null;
        if(head == null) return;
        node = head;
        StringBuilder linkedList = new StringBuilder();
        while(node != null){
//            String item = "{ node: " + node.value + " , " + "next: " +( node.next != null ? "true" : "false") + "}";
            linkedList.append(node.value).append(" -> ");
            node = node.next;
        }
        linkedList.append("null");
        System.out.println(linkedList);
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(8);
        list.insertFirst(17);
        list.insertLast(99);
        list.display();
        System.out.println(list.find(17));
        System.out.println("size: " + list.size);

    }
}
