package com.uade;


import com.uade.exercise_5.StackOrderAndFilterRepeated;
import com.uade.exercise_5.model.IStack;
import com.uade.exercise_5.model.Stack;

public class Main {
    public static void main(String[] args) {
        int[] array = {4, 3, 7, 9, 10, 15, 13, 25};
        printArray(array);
        bubbleSortDescending(array);
        printArray(array);

        Stack stack = new Stack();
        
        stack.add(4);
        stack.add(3);
        stack.add(5);
        stack.add(23);
        stack.add(12);
        stack.add(4);
        stack.add(9);
        StackOrderAndFilterRepeated sta= new StackOrderAndFilterRepeated();
        IStack stack2 = sta.filterRepeatedAndOrderDescending(stack);
        System.out.println(stack2);
        
        
    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void bubbleSortDescending(int[] array) {
        int n = array.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] < array[j + 1]) {
                    // Intercambiar array[j] y array[j + 1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    swapped = true;
                }
            }

            // Si no hubo intercambios en la pasada, el array ya está ordenado
            if (!swapped) {
                break;
            }
        }
    }


}

