package com.uade.exercise_4;

public class StaticStack implements Stack {

    private static final int MAX = 10000;

    private final int[] array;
    private int count;

    public StaticStack(Builder builder) {
        this.array = builder.array;
        this.count = builder.count;
    }
    public static Builder builder(){
        return new Builder();
    }
    public static class Builder{
        private int[] array;
        private int count;
        public Builder() {
            this.array = new int[MAX];
            this.count = 0;
        }
        public Builder add(int a) {
            if(this.count >= MAX) {
                throw new RuntimeException("Limite excedido");
            }
            this.array[this.count++] = a;
            return this;
        }
        public StaticStack build(){
            return new StaticStack(this);
        }
    }
    @Override
    public void add(int a) {
        if(this.count >= MAX) {
            throw new RuntimeException("Limite excedido");
        }
        this.array[this.count++] = a;
    }

    @Override
    public void remove() {
        if(this.isEmpty()) {
            throw new RuntimeException("Pila vacía");
        }
        this.count--;
    }

    @Override
    public int getTop() {
        if(this.isEmpty()) {
            throw new RuntimeException("Pila vacía");
        }
        return this.array[this.count - 1];
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }
}
