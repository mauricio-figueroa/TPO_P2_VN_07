package com.uade.exercise_5.model;

import java.util.Arrays;
import java.util.Random;

public class StaticSet implements Set {

    private final int[] array;
    private int count;

    public StaticSet() {
        this.array = new int[10000];
        this.count = 0;
    }

    @Override
    public void add(int a) {
        for (int i = 0; i < this.count; i++) {
            if (this.array[i] == 0 || a % this.array[i] == 0) { 
                return;
            }
        }
        this.array[this.count] = a;
        this.count++; 
    }

    @Override
    public void remove(int a) {
        for (int i = 0; i < this.count; i++) {
            if (this.array[i] == a) {
                if (i == this.count - 1) {
                    this.count--;
                    return;
                }
                this.array[i] = this.array[this.count - 1];
                this.count--;
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
            System.out.println("No se puede elegir un elemento del conjunto vacio");
            return -1;
        }
        int randomIndex = (new Random()).nextInt(this.count);
        return this.array[randomIndex];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaticSet set = (StaticSet) o;
        if (count != set.count) return false;

        int[] array1Copy = Arrays.copyOf(array, array.length);
        int[] array2Copy = Arrays.copyOf(set.array, set.array.length);
        Arrays.sort(array1Copy);
        Arrays.sort(array2Copy);

        for (int i = 0; i < count; i++) {
            if (array1Copy[i] != array2Copy[i]) {
                return false;
            }
        }
        return true;
    }
}