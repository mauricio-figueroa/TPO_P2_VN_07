package com.uade.exercise_6._5;

public class NodeOfDictionary {
    private int value;
    private NodeOfDictionary next;

    public NodeOfDictionary(int value) {
        this.value = value;
    }

    public NodeOfDictionary(int value, NodeOfDictionary next) {
        this.value = value;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public NodeOfDictionary getNext() {
        return next;
    }

    public void setNext(NodeOfDictionary next) {
        this.next = next;
    }
}
