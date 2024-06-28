package com.uade.exercise_6._4;

public class Multiset {

    private NodeOfMultiset first;


    public void add(int value) {
        NodeOfMultiset current = first;
        NodeOfMultiset prev = null;

        while (current != null && current.getValue() != value) {
            prev = current;
            current = current.getNext();
        }

        if (current == null) {
            NodeOfMultiset newNode = new NodeOfMultiset(value);
            if (prev == null) {
                first = newNode;
            } else {
                prev.setNext(newNode);
            }
        } else {

            current.setCount(current.getCount() + 1);
        }
    }


    public void remove(int value) {
        NodeOfMultiset current = first;
        NodeOfMultiset prev = null;

        while (current != null && current.getValue() != value) {
            prev = current;
            current = current.getNext();
        }

        if (current != null) {
            if (current.getCount() > 1) {
                current.setCount(current.getCount() - 1);
            } else {
                if (prev == null) {
                    first = current.getNext();
                } else {
                    prev.setNext(current.getNext());
                }
            }
        }
    }

    public void printMultiset() {
        NodeOfMultiset current = first;
        while (current != null) {
            System.out.println("Value: " + current.getValue() + " Count: " + current.getCount());
            current = current.getNext();
        }

    }
}
