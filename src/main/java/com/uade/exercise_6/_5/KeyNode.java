package com.uade.exercise_6._5;

public class KeyNode
{

    private int key;
    private KeyNode next;
    private NodeOfDictionary value;

    public KeyNode(int key, KeyNode next, NodeOfDictionary value) {
        this.key = key;
        this.next = next;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public KeyNode getNext() {
        return next;
    }

    public void setNext(KeyNode next) {
        this.next = next;
    }

    public NodeOfDictionary getValue() {
        return value;
    }

    public void setValue(NodeOfDictionary value) {
        this.value = value;
    }
}
