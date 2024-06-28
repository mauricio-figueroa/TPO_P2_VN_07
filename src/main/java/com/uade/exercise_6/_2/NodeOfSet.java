package com.uade.exercise_6._2;

public class NodeOfSet
{

    private int value;
    private NodeOfSet next;

    public NodeOfSet(int value) {
        this.value = value;
    }

    public NodeOfSet(int value, NodeOfSet next) {
        this.value = value;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public NodeOfSet getNext() {
        return next;
    }

    public void setNext(NodeOfSet next) {
        this.next = next;
    }

}
