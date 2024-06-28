package com.uade.exercise_2.model;

public class Stack implements IStack {

    private int[] array;
    private int count;

    public Stack() {
        this.array = new int[10000];
    }

    @Override
    public void add(int a) {
        if(count == 10000) {
            throw new RuntimeException("Muchos elementos");
        }
        array[count] = a;
        count++;
    }

    @Override
    public void remove() {
        if(count == 0) {
            throw new RuntimeException("No se puede desapilar una pila vacia");
        }
        count--;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int getTop() {
        if(count == 0) {
            throw new RuntimeException("No se puede obtener el tope de una pila vacia");
        }
        return array[count - 1];
    }
}
