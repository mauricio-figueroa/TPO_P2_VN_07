package com.uade;

import com.uade.exercise_7.StaticPriorityQueue;

public class Main {
    public static void main(String[] args) {
        // Crear una instancia de StaticPriorityQueue
        StaticPriorityQueue priorityQueue = new StaticPriorityQueue();

        // Agregar elementos con sus prioridades
        priorityQueue.add(10, 3);
        priorityQueue.add(20, 10);
        priorityQueue.add(30, 21);
        priorityQueue.add(40, 14);
        priorityQueue.add(50, 4);



        // Actualizar la prioridad del elemento con valor 20 a una nueva prioridad 4
        priorityQueue.updatePriority(3, 11);





    }


}
