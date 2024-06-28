package com.uade.exercise_6._4;

public class NodeOfMultiset {

    private int value;
    private int count;
    private NodeOfMultiset next;

    public NodeOfMultiset(int value) {
        this.value = value;
        this.count = 1;
    }

    public NodeOfMultiset(int value, NodeOfMultiset next) {
        this.value = value;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public NodeOfMultiset getNext() {
        return next;
    }

    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }

    public void setNext(NodeOfMultiset next) {
        this.next = next;
    }
}
