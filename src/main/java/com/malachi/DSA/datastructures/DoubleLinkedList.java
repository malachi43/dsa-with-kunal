package com.malachi.DSA.datastructures;

public class DoubleLinkedList {
    private Node head;
    private Node tail;
    private int size;

    private class Node{
        private int value;
        private Node next;
        private Node prev;

        public Node(int value){
            this.value = value;
        }

        public Node(int value, Node other){
            this.value = value;
            next = other;
            other.prev = this;
        }

        public String toString(){
            return "{ node: " + value + " , " + "next: " +( next != null ? "true" : "false") + ", prev: " + (prev != null ? "true" : "false" ) +  "}";
        }

    }

    public void insertFirst(int value){
        Node currentHead = head;
        Node node = new Node(value);

        if(head == null){
            head = node;
            tail = node;
            tail.next = null;
            head.prev = null;
            ++size;
            return;
        }

        node.next = currentHead;
        currentHead.prev = node;
        node.prev = null;
        head = node;
        ++size;
    }

    public void insertLast(int value){
//        Node lastNode = tail;
//        if(lastNode == null){
//            insertFirst(value);
//            return;
//        }
//        Node node = new Node(value);
//        lastNode.next = node;
//        node.prev = lastNode;
//        tail = node;

        //without using tail
        Node temp = head;
        Node previous = null;
        while(temp != null){
            previous = temp;
            temp = temp.next;
        }
        Node node = new Node(value);
        if(previous == null){
            insertFirst(value);
            return;
        }
        previous.next = node;
        node.prev = previous;
        ++size;
        tail = node;
    }

    public Node get(int index){
        Node node = head;
        if(node == null) return null;
        if(index < 0) return null;
        if(index >= size) return null;
        for(int i = 0; i < index; i++){
            node = node.next;
        }
        return node;
    }

    public void insert(int index, int value){
        Node currentNode = get(index);
        if(currentNode == null) return;
        if(index == 0){
            Node firstNode = get(index);
            Node newNode = new Node(value);
            newNode.next = firstNode;
            firstNode.prev = newNode;
            newNode.prev = null;
            head = newNode;
            ++size;
            return;
        }
        Node previousNode = get(index - 1);
        Node newNode = new Node(value);
        newNode.prev = previousNode;
        previousNode.next = newNode;
        newNode.next = currentNode;
        currentNode.prev = newNode;
        ++size;
    }


    public void display(){
        DoubleLinkedList.Node node = null;
        if(head == null) return;
        node = head;
        StringBuilder linkedList = new StringBuilder();
        while(node != null){
//            String item = "{ node: " + node.value + " , " + "next: " +( node.next != null ? "true" : "false") + "}";
            linkedList.append(node.value).append(" <-> ");
            node = node.next;
        }
        linkedList.append("null");
        System.out.println(linkedList);
    }

    public void displayReverse(){
        DoubleLinkedList.Node node = null;
        if(tail == null) return;
        node = tail;
        StringBuilder linkedList = new StringBuilder();
        while(node != null){
//            String item = "{ node: " + node.value + " , " + "next: " +( node.next != null ? "true" : "false") + "}";
            linkedList.append(node.value).append(" <-> ");
            node = node.prev;
        }
        linkedList.append("null");
        System.out.println(linkedList);
    }

    public static void main(String[] args) {
        DoubleLinkedList dll = new DoubleLinkedList();
        dll.insertFirst(10);
        dll.display();
        dll.insertFirst(12);
        dll.display();
        dll.insertFirst(17);
        dll.display();
        dll.insertLast(43);
        dll.display();
        dll.insertLast(105);
        dll.display();
        dll.insertLast(345);
        dll.display();
        dll.insertLast(43);
        dll.display();
        dll.insertLast(11);
        dll.display();
        dll.insert(0, 111);
        dll.display();
        dll.insert(1, 43);
        dll.display();
        dll.insert(4, 7987);
        dll.display();
        dll.insertFirst(0);
        dll.display();
        dll.insertLast(39);

        dll.display();

        System.out.println(dll.size);
    }
}
