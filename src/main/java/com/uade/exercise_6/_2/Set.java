package com.uade.exercise_6._2;

import java.util.ArrayList;
import java.util.Random;

public class Set implements ISet{

    private NodeOfSet first;
    private int count;


    @Override
    public int choose() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede obtener el elemento de un conjunto vacio");
        }
        Random random = new Random();
        int index = random.nextInt(count);

        int i = 0;
        NodeOfSet current = this.first;
        while(current.getNext() != null) {
            if(i == index) {
                return current.getValue();
            }
            i++;
            current = current.getNext();
        }

        return 0;
    }

    @Override
    public void add(int a) {
        if(this.isEmpty()) { // C
            this.first = new NodeOfSet(a, null);
            return;
        }
        NodeOfSet current = this.first;
        while(current.getNext() != null) {
            if(current.getValue() == a) {
                return;
            }
            current = current.getNext();
        }
        current.setNext(new NodeOfSet(a, null));
    }

    @Override
    public void remove(int a) {
        if(this.isEmpty()) {
            return;
        }
        if(this.first.getNext() == null) {
            if(this.first.getValue() == a) {
                this.first = null;
            }
            return;
        }

        NodeOfSet backup = this.first;
        NodeOfSet current = this.first.getNext();


        while(current.getNext() != null) {
            if(current.getValue() == a) {
                backup.setNext(current.getNext());
                return;
            }
            current = current.getNext();
        }

        if(current.getValue() == a) {
            backup.setNext(current.getNext());
        }
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    public void size() {
        NodeOfSet current = first;
        while (current != null) {
            count++;
            current = current.getNext();
        }
    }

    private boolean contains(int element) {
        NodeOfSet current = first;
        while (current != null) {
            if (current.getValue() == element) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public boolean isSubset(Set Subset) {
        NodeOfSet current = Subset.first;
        while (current != null) {
            if (!this.contains(current.getValue())) {
                return false;
            }
            current = current.getNext();
        }
        return true;
    }

    public ArrayList<Integer> isComplement(Set auxSet) {
        ArrayList<Integer> complements = new ArrayList<Integer>();
        if (this.isSubset(auxSet)) {
            NodeOfSet current = this.first;
            while (current != null) {
                if (auxSet.contains(current.getValue())) {
                    complements.add(current.getValue());
                }
                current = current.getNext();
            }
        }
        return complements;
    }

}
