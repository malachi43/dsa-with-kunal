package com.malachi.DSA.datastructures;

public class CircularLinkedList {
    private Node head;
    private Node tail;
    private int size;

    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }

        public String toString(){
            return "{ node: " + value + " , " + "next: " +( next != null ? "true" : "false") + "}";
        }
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

    public Node find(int value){
        Node node = head;
        for(int i = 0; i < size; i++){
            System.out.println("node value: " + node.value);
            if(node.value == value) return node;
            node = node.next;
        }
        return null;
    }

    public void insert(int value){
        if(head == null){
            Node newNode = new Node(value);
            head = newNode;
            tail = newNode;
            tail.next = head;
            ++size;
            return;
        }
        Node newNode = new Node(value);
        tail.next = newNode;
        newNode.next = head;
        ++size;
        tail = newNode;
    }

    public void deleteByIndex(int index) throws IllegalArgumentException{
        if(size <= 0) return;
        if(index < 0 || index >= size) throw new IllegalArgumentException("index should be in the range of 0 - " + (size - 1) + " (inclusive)");
        if(index == 0){
            Node nodeToDelete = get(index);
            if(nodeToDelete == null) return;
            if(nodeToDelete.value != tail.value){
                head = nodeToDelete.next;
                tail.next = head;
                --size;
                return;
            }
            head = null;
            tail = null;
            --size;
            return;
        }
        Node nodeBeforeNodeToDelete = get(index - 1);
        Node nodeToDelete = get(index);
        nodeBeforeNodeToDelete.next = nodeToDelete.next;
        if(nodeToDelete.value == tail.value){
            tail = nodeBeforeNodeToDelete;
            tail.next = head;
        }
        --size;
    }

    public void deleteByValue(int value){
        if(size <= 0) return;
        Node node = head;
        if(node == null) return;
        if(node.value == value && size == 1){
            head = null;
            tail = null;
            --size;
            return;
        }

        if(node.value == value){
            tail.next = head.next;
            head = head.next;
            --size;
            return;
        }

        Node previous = head;
        Node currentNode = head.next;
        while(head.value != currentNode.value){
            if(currentNode.value == value){
                previous.next = currentNode.next;
                //this means we deleted the tail.
                if(currentNode.value == tail.value){
                    tail = previous;
                }
                --size;
                break;
            }
            previous = currentNode;
            currentNode = currentNode.next;
        }
    }


    public void display(){
        if(head == null) return;
        StringBuilder builder = new StringBuilder();
        Node node = head;
        while( node.next.value != head.value ){
            builder.append(node.value).append(" -> ");
            node = node.next;
        }
        builder.append(tail.value).append(" -> ").append("HEAD");
        System.out.println(builder);
    }

    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.insert(4);
        cll.insert(12);
        cll.insert(8);
        cll.insert(5);
        cll.display();
        cll.deleteByIndex(2);
        cll.display();
    }

}
