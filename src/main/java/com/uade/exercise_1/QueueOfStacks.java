package com.uade.exercise_1;

import java.util.*;

public class QueueOfStacks {
    Queue<Stack<Integer>> queue;

    public QueueOfStacks(Queue<Stack<Integer>> queue ) {
        this.queue = queue;
    }

    public static int calculateTrace(QueueOfStacks queueOfStacks) {
        int trace = 0;
        int index = 0;
        while (!queueOfStacks.queue.isEmpty()) {
            Stack<Integer> stack = queueOfStacks.queue.poll();
            for (int i = 0; i < index && !stack.isEmpty(); i++) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                trace += stack.pop();
            }
            index++;
        }
        return trace;
    }

    public static QueueOfStacks transpose(QueueOfStacks queueOfStacks) {
        LinkedList<Stack<Integer>> transposed = new LinkedList<>();

        Stack<Integer>[] tempStacks = new Stack[queueOfStacks.queue.peek().size()];
        for (int i = 0; i < tempStacks.length; i++) {
            tempStacks[i] = new Stack<>();
        }

        while (!queueOfStacks.queue.isEmpty()) {
            Stack<Integer> currentStack = queueOfStacks.queue.poll();
            int index = 0;
            while (!currentStack.isEmpty()) {
                tempStacks[index].push(currentStack.pop());
                index++;
            }
        }

        for (Stack<Integer> stack : tempStacks) {
            transposed.push(stack);
        }

        return new QueueOfStacks(transposed);
    }

    public static QueueOfStacks sumMatrices(QueueOfStacks matrixA, QueueOfStacks matrixB) {
        LinkedList<Stack<Integer>> sum = new LinkedList<>();

        while (!matrixA.queue.isEmpty() && !matrixB.queue.isEmpty()) {
            Stack<Integer> stackA = matrixA.queue.poll();
            Stack<Integer> stackB = matrixB.queue.poll();
            Stack<Integer> resultStack = new Stack<>();
            while (!stackA.isEmpty() && !stackB.isEmpty()) {
                int sumElement = stackA.pop() + stackB.pop();
                resultStack.push(sumElement);
            }
            Queue<Integer> queue = new LinkedList<>();
            while (!resultStack.isEmpty()) {
                queue.add(resultStack.pop());
            }
            while (!queue.isEmpty()) {
                resultStack.add(queue.remove());
            }

            sum.push(resultStack);

        }

        LinkedList<Stack<Integer>> reversedList = new LinkedList<>();

        ListIterator<Stack<Integer>> iterator = sum.listIterator(sum.size());
        while (iterator.hasPrevious()) {
            Stack<Integer> previouselement = iterator.previous();
            reversedList.add(previouselement);
        }

        return new QueueOfStacks(reversedList);
    }

    public void printMatrix() {
        Iterator<Integer>[] iterators = new Iterator[queue.size()];
        Integer[] elements = new Integer[queue.size()];

        int i = 0;
        for (Stack<Integer> stack : queue) {
            iterators[i] = stack.iterator();
            if (iterators[i].hasNext()) {
                elements[i] = iterators[i].next();
            }
            i++;
        }

        boolean hasNextElement = true;
        while (hasNextElement) {
            hasNextElement = false;

            for (int j = 0; j < queue.size(); j++) {
                if (elements[j] != null) {
                    System.out.print(elements[j] + "\t");
                    hasNextElement = true;

                    if (iterators[j].hasNext()) {
                        elements[j] = iterators[j].next();
                    } else {
                        elements[j] = null;
                    }
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
}
