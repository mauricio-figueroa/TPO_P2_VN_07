package com.uade.exercise_6._5;

import com.uade.exercise_6._2.ISet;

import java.util.List;

public interface MultipleDictionary {
    void add(int key, int value);

    void remove(int key, int value);

    ISet getKeys();

    int getValue(int key);
}
