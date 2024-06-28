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
            while (!currentQueue.isEmpty()) {
                flatQueue.add(currentQueue.getFirst());
                currentQueue.remove();
            }
        }
        return flatQueue;
    }

    @Override
    public QueueOfQueue reverseWithDepth() {
        QueueOfQueue reversedQueueOfQueue = new QueueOfQueue();
        StaticStack queueIndices = new StaticStack();
        StaticStack tempStack = new StaticStack();

        for (int i = 0; i < count; i++) {
            queueIndices.add(i);
        }

        while (!queueIndices.isEmpty()) {
            int queueIndex = queueIndices.getTop();
            queueIndices.remove();
            StaticQueue currentQueue = queueOfQueues[queueIndex];

            while (!currentQueue.isEmpty()) {
                tempStack.add(currentQueue.getFirst());
                currentQueue.remove();
            }
            while (!tempStack.isEmpty()) {
                currentQueue.add(tempStack.getTop());
                tempStack.remove();
            }
            reversedQueueOfQueue.add(currentQueue);
        }
        return reversedQueueOfQueue;
    }




}

