package com.uade;

import com.uade.exercise_3.QueueOfQueue;
import com.uade.exercise_4.StaticQueue;
import com.uade.exercise_4.Set;
import com.uade.exercise_4.StaticSet;
import com.uade.exercise_4.StaticStack;

public class Main {
    public static void main(String[] args) {

// Crear una instancia de StaticQueue usando el Builder
        StaticQueue queue = StaticQueue.builder()
                .add(10)
                .add(20)
                .add(30)
                .addAll(40, 50, 60)
                .build();

        System.out.println( " Elementos de la cola:");
        queue.display();



    }
}
