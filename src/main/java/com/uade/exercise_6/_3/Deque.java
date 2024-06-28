package com.uade.exercise_6._3;

public class Deque {

    private NodeOfDeque head;
    private NodeOfDeque tail;
    private int size;

    public Deque() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addFirst(int data) {
        NodeOfDeque newNode = new NodeOfDeque(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(int data) {
        NodeOfDeque newNode = new NodeOfDeque(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public int removeFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Deque vacio");
        }
        int data = head.value;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        size--;
        return data;
    }

    public int removeLast() {
        if (isEmpty()) {
            throw new RuntimeException("Deque vacio");
        }
        int data = tail.value;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
        size--;
        return data;
    }


    public boolean isEmpty() {
        return size == 0;
    }

}
