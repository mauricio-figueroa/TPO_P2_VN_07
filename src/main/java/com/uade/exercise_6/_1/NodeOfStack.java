package com.uade.exercise_6._1;

public class NodeOfStack
{

    private int value;
    private NodeOfStack next;

    public NodeOfStack(int value) {

        this.value = value;
        next = null;
    }

    public NodeOfStack(int value, NodeOfStack next) {
        this.value = value;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public NodeOfStack getNext() {
        return next;
    }

    public void setNext(NodeOfStack next) {
        this.next = next;
    }
}
