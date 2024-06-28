package com.uade.exercise_1.utils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

public class QueueOfStacksUtils {

    // fill a Matrix with random numbers in the range 1 to 9
    private static Queue<Stack<Integer>> fillMatrix(int rows, int cols) {
        Queue<Stack<Integer>> matrix = new LinkedList<>();
        Random random = new Random();

        for (int i = 0; i < rows; i++) {
            Stack<Integer> row = new Stack<>();
            for (int j = 0; j < cols; j++) {
                int randomNumber = random.nextInt(9) + 1; // Generar número aleatorio en el rango de 1 a 99
                row.push(randomNumber);
            }
            matrix.add(row);
        }
        return matrix;
    }
}
