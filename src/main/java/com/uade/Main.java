package com.uade;


import com.uade.exercise_1.QueueOfStacks;
import com.uade.exercise_6._1.DynamicStackLimited;
import com.uade.exercise_6._2.Set;
import com.uade.exercise_6._3.Deque;
import com.uade.exercise_6._4.Multiset;
import com.uade.exercise_6._5.RandomDynamicDictionary;

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


        //Ejercicio 6

        //punto 1
        DynamicStackLimited stack = new DynamicStackLimited(2);

        stack.add(3);
        stack.add(2);
        //stack.add(3) si agrega el 3 elemento arroja un RuntimeException
        stack.remove();
        stack.add(5);


        //punto 2
        com.uade.exercise_6._2.Set set = new com.uade.exercise_6._2.Set();
        set.add(1);
        set.add(2);
        set.add(3);

        com.uade.exercise_6._2.Set subset = new com.uade.exercise_6._2.Set();
        subset.add(1);
        subset.add(2);

        com.uade.exercise_6._2.Set notSubset = new Set();
        notSubset.add(4);
        notSubset.add(5);

        // Verificar si subset es subconjunto de set
        System.out.println("¿Subset es subconjunto de set?: " + set.isSubset(subset));

        // Verificar si notSubset es subconjunto de set
        System.out.println("¿NotSubset es subconjunto de set?: " + set.isSubset(notSubset));

        //Complemento

        ArrayList<Integer> values = set.isComplement(subset);
        if(values.isEmpty())
        {
            System.out.println("\nNo es complemento");
        }
        else {
            System.out.println("\nLos complementos son");
            for (int i = 0; i < values.size(); i++) {

                System.out.println(values.get(i));
            }
        }

        //punto 3
        Deque deque = new Deque();
        deque.addFirst(1);
        deque.addLast(2);
        deque.addFirst(0);
        deque.addLast(3);

        System.out.println("\nSaco el primero: " + deque.removeFirst());
        System.out.println("Saco el ultimo: " + deque.removeLast());
        System.out.println("Saco el primero: " + deque.removeFirst());
        System.out.println("Saco el primero: " + deque.removeLast());

        // punto 4
        Multiset multiset = new Multiset();
        multiset.add(5);
        multiset.add(5);
        multiset.add(5);

        multiset.add(3);
        multiset.add(3);

        multiset.add(7);



        System.out.println("\nMultiset after adding elements:");
        multiset.printMultiset();

        multiset.remove(5);
        multiset.remove(3);
        multiset.remove(7);

        System.out.println("\nMultiset after removing elements:");
        multiset.printMultiset();


        //punto 5
        RandomDynamicDictionary dictionary = new RandomDynamicDictionary();
        dictionary.add(1,5);
        dictionary.add(1,6);
        dictionary.add(1,7);

        dictionary.add(2,3);
        dictionary.add(2,4);
        dictionary.add(2,2);

        dictionary.add(3,8);
        dictionary.add(3,9);
        dictionary.add(3,100);

        System.out.println("\nel valor random para la key 1 es:" + dictionary.getValue(1));
        System.out.println("el valor random para la key 2 es:" + dictionary.getValue(2));
        System.out.println("el valor random para la key 3 es:" + dictionary.getValue(3));


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