package com.uade.exercise_6._3;

public class NodeOfDeque {

    public int value;
    public NodeOfDeque next;
    public NodeOfDeque prev;

    public NodeOfDeque(int value) {
        this.value = value;
    }

    public NodeOfDeque(int value, NodeOfDeque next, NodeOfDeque prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public NodeOfDeque getNext() {
        return next;
    }

    public void setNext(NodeOfDeque next) {
        this.next = next;
    }

    public NodeOfDeque getPrev() {return prev;}

    public void setPrev(NodeOfDeque prev) {this.prev = prev;}
}
