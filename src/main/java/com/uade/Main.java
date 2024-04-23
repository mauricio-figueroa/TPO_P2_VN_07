package com.uade;


import com.uade.exercise_1.QueueOfStacks;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Fill example matrix
        QueueOfStacks matrix1 = new QueueOfStacks(fillMatrix(3, 3));
        QueueOfStacks matrix2 = new QueueOfStacks(fillMatrix(3, 3));
        QueueOfStacks matrix3 = new QueueOfStacks(fillMatrix(3, 3));
        QueueOfStacks matrix4 = new QueueOfStacks(fillMatrix(3, 3));

        System.out.println("Matrix 1: ");
        matrix1.printMatrix();

        // Calculate the trace of the first matrix
        int trace = QueueOfStacks.calculateTrace(matrix1);
        System.out.println("Trace of matrix 1: " + trace);

        System.out.println("Matrix 2: ");
        matrix2.printMatrix();

        // Get the transpose of the first matrix
        QueueOfStacks transpose = QueueOfStacks.transpose(matrix2);
        System.out.println("Transpose of matrix 2:");
        transpose.printMatrix();

        System.out.println("Matrix 3: ");
        matrix3.printMatrix();
        System.out.println("Matrix 4: ");
        matrix4.printMatrix();

        // Obtain the sum of matrices 3 and 4
        QueueOfStacks sumQueue = QueueOfStacks.sumMatrices(matrix3, matrix4);
        System.out.println("Sum of matrices");
        sumQueue.printMatrix();
    }

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