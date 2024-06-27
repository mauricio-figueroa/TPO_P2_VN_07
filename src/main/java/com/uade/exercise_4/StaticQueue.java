package com.uade.exercise_4;

public class StaticQueue implements Queue {

    private static final int MAX = 10000;

    private final int[] array;
    private int count;

    public StaticQueue() {
        this.array = new int[MAX];
        this.count = 0;
    }

    public StaticQueue(Builder builder) {
        this.array = builder.array;
        this.count = builder.count;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final int[] array;
        private int count;

        public Builder() {
            this.array = new int[MAX];
            this.count = 0;
        }

        public Builder add(int a) {
            if (count == MAX) {
                throw new RuntimeException("No se puede agregar el elemento");
            }
            this.array[count] = a;
            this.count++;
            return this;
        }

        public Builder addAll(int... values) {
            for (int value : values) {
                add(value);
            }
            return this;
        }

        public StaticQueue build() {
            return new StaticQueue(this);
        }
    }

    @Override
    public void add(int a) {
        if (count == MAX) {
            throw new RuntimeException("No se puede agregar el elemento");
        }
        array[count] = a;
        count++;
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede desacolar una cola vacía");
        }
        for (int i = 0; i < count - 1; i++) {
            array[i] = array[i + 1];
        }
        count--;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int getFirst() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede obtener el primero de una cola vacía");
        }
        return array[0];
    }

    public void display() {
        System.out.print("Elementos de la cola: ");
        for (int i = 0; i < count; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
