package com.uade.exercise_5;

import com.uade.exercise_5.model.IStack;
import com.uade.exercise_5.model.Stack;
import com.uade.exercise_5.model.StaticSet;
import com.uade.exercise_5.utils.SetUtil;

public class StackOrderAndFilterRepeated {
    /**
     * Dada una pila de elementos desordenados, generar una nueva pila sin elementos repetidos y ordenados.
     * Elegi ordenarlos de mayor a menor
     */
    public IStack filterRepeatedAndOrderDescending(IStack stack) {

        //al agregarlos al SET filtro los repetidos
        StaticSet set = new StaticSet();
        while (!stack.isEmpty()) {
            int value = stack.getTop();
            set.add(value);
            stack.remove();
        }

        // Creo un array del tamaño del set
        int[] array = new int[SetUtil.size(set)];

        // Agrego los elementos del set al array
        int index = 0;
        while (!set.isEmpty()) {
            int element = set.choose();
            array[index++] = element;
            set.add(element); // Devolver el elemento al set original
            set.remove(element);
        }

        //ordeno el array con el metodo bubble sort de manera descendente es decir, de mayor a menor
        bubbleSortDescending(array);
        Stack result = new Stack();

        for (int i = 0; i < array.length; i++) {
            result.add(array[i]);
        }
        return result;
    }

    public void bubbleSortDescending(int[] array) {
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
