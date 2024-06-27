package com.uade.exercise_4;

import java.util.Random;

public class StaticSet implements Set {

    private static final int MAX = 10000;

    private int[] array;
    private int count;

    public StaticSet(Builder builder) {
        this.array = builder.array;
        this.count = builder.count;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder {
        private int[] array;
        private int count;

        public Builder() {
            this.array = new int[MAX];
            this.count = 0;
        }

        public Builder add(int a) {
            if (count == MAX) {
                throw new RuntimeException("Limite de elementos alcanzado");
            }
            for (int i = 0; i < count; i++) {
                if (this.array[i] == a) {
                    return this; // No se agrega duplicados en el builder
                }
            }
            this.array[count] = a;
            this.count++;
            return this;
        }
        public Builder addAll(StaticSet set) {
            int[] copy = new int[set.getCount()];
            int copyCount = set.getCount();

            if (count == MAX) {
                throw new RuntimeException("Limite de elementos alcanzado");
            }

            // Crear una copia del array del set para evitar modificar el original
            for (int i = 0; i < copyCount; i++) {
                copy[i] = set.choose();
                set.remove(copy[i]);
            }

            for (int i = 0; i < copyCount; i++) {
                int setData = copy[i];
                boolean isDuplicate = false;
                for (int j = 0; j < count; j++) {
                    if (this.array[j] == setData) {
                        isDuplicate = true;
                        break;
                    }
                }
                if (!isDuplicate) {
                    if (count == MAX) {
                        throw new RuntimeException("Limite de elementos alcanzado");
                    }
                    this.array[count] = setData;
                    this.count++;
                }
            }
            return this;
        }


        // Método para construir la instancia final de StaticSet
        public StaticSet build() {
            return new StaticSet(this);
        }
    }

    @Override
    public void add(int a) {
        if (count == MAX) {
            throw new RuntimeException("Limite de elementos alcanzado");
        }
        for (int i = 0; i < count; i++) {
            if (this.array[i] == a) {
                return; // No se agrega duplicados en el set
            }
        }
        this.array[count] = a;
        this.count++;
    }

    @Override
    public void remove(int a) {
        for (int i = 0; i < count; i++) {
            if (this.array[i] == a) {
                this.array[i] = this.array[count - 1];
                count--;
                return;
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int choose() {
        if (this.count == 0) {
            throw new RuntimeException("No se puede elegir un valor de un conjunto vacio");
        }
        return this.array[new Random().nextInt(this.count)];
    }
    public int getCount(){
        return count;
    }
    public void display() {
        if (this.count == 0) {
            System.out.println("El conjunto está vacío.");
            return;
        }
        System.out.print("Elementos del conjunto: ");
        for (int i = 0; i < this.count; i++) {
            System.out.print(this.array[i] + " ");
        }
        System.out.println();
    }
}
