package com.uade.exercise_3;



public class QueueOfQueue implements IQueueOfQueue {

    private final StaticQueue[] queueOfQueues;
    private int count;

    public QueueOfQueue() {
        queueOfQueues = new StaticQueue[10000]; // Define un tamaño máximo para la cantidad de colas.
        count = 0;
    }

    @Override
    public void add(StaticQueue queue) {
        if (count == 10000) {
            throw new RuntimeException("No se puede agregar más colas");
        }
        queueOfQueues[count] = queue;
        count++;
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede desacolar una cola vacía");
        }
        for (int i = 0; i < count - 1; i++) {
            queueOfQueues[i] = queueOfQueues[i + 1];
        }
        count--;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int getFirst() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede obtener el primero de una cola vacía");
        }
        return queueOfQueues[0].getFirst();
    }
    public int getCount() {
        return count;
    }
    @Override
    public QueueOfQueue concatenate(QueueOfQueue... queues) {
        QueueOfQueue result = new QueueOfQueue();
        for (QueueOfQueue queueOfQueue : queues) {
            for (int i = 0; i < queueOfQueue.getCount(); i++) {
                result.add(queueOfQueue.queueOfQueues[i]);
            }
        }
        return result;
    }
    @Override
    public StaticQueue flat() {
        StaticQueue flatQueue = new StaticQueue();
        for (int i = 0; i < count; i++) {
            StaticQueue currentQueue = queueOfQueues[i];
            for (int j = 0; j < currentQueue.getCount(); j++) {
                flatQueue.add(currentQueue.getElementAt(j));
            }
        }
        return flatQueue;
    }



    @Override
    public QueueOfQueue reverseWithDepth() {
        QueueOfQueue reversedQueue = new QueueOfQueue();
        for (int i = count - 1; i >= 0; i--) {
            StaticQueue currentQueue = queueOfQueues[i];
            int n = currentQueue.getCount();
            int[] reversedElements = new int[n];

            for (int j = 0; j < n; j++) {
                reversedElements[j] = currentQueue.getElementAt(n - j - 1);
            }
            StaticQueue reversedStaticQueue = new StaticQueue();
            for (int j = 0; j < n; j++) {
                reversedStaticQueue.add(reversedElements[j]);
            }
            reversedQueue.add(reversedStaticQueue);
        }

        return reversedQueue;
    }


    public void displayQueues() {
        if (isEmpty()) {
            System.out.println("La cola de colas está vacía.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.print("Cola " + (i + 1) + ": ");
            StaticQueue currentQueue = queueOfQueues[i];
            for (int j = 0; j < currentQueue.getCount(); j++) {
                System.out.print(currentQueue.getElementAt(j) + " ");
            }
            System.out.println();
        }
    }
}

