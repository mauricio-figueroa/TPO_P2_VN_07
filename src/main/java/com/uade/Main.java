package com.uade;

import com.uade.exercise_3.QueueOfQueue;
import com.uade.exercise_3.StaticQueue;

public class Main {
    public static void main(String[] args) {
        QueueOfQueue qq1 = new QueueOfQueue();
        QueueOfQueue qq2 = new QueueOfQueue();
        QueueOfQueue qq3 = new QueueOfQueue();

        StaticQueue queue1 = new StaticQueue();
        queue1.add(10);
        queue1.add(20);
        queue1.add(30);
        qq1.add(queue1);

        StaticQueue queue2 = new StaticQueue();
        queue2.add(40);
        queue2.add(50);
        qq2.add(queue2);

        StaticQueue queue3 = new StaticQueue();
        queue3.add(60);
        qq3.add(queue3);

        // Concatenar las colas
        QueueOfQueue concatenatedQueue = new QueueOfQueue();
        concatenatedQueue = concatenatedQueue.concatenate(qq1, qq2, qq3);
        concatenatedQueue.displayQueues();

        // Invertir con profundidad y mostrar
        concatenatedQueue.reverseWithDepth().displayQueues();

        concatenatedQueue.reverseWithDepth().flat().displayQueue();
    }
}
