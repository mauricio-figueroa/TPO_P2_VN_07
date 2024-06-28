package com.uade.exercise_2;


import com.uade.exercise_2.model.IStack;
import com.uade.exercise_2.model.Stack;

public class StackInvert {

    public static IStack invert(IStack stack) {
        Stack invertedStackResult = new Stack();
        while (!stack.isEmpty()) {
            int value = stack.getTop();
            invertedStackResult.add(value);
            stack.remove();
        }
        return invertedStackResult;
    }

}
