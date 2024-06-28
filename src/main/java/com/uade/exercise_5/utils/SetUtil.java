package com.uade.exercise_5.utils;

import com.uade.exercise_5.model.Set;
import com.uade.exercise_5.model.StaticSet;

public class SetUtil {

    public static int size(Set set) {
        Set copy = copy(set);
        int result = 0;

        while (!copy.isEmpty()) {
            int n = set.choose();
            copy.remove(n);
            result++;
        }
        return result;
    }

    private static Set copy(Set set) { 
        Set aux = new StaticSet();
        Set aux2 = new StaticSet(); 

        // O(N)
        while(!set.isEmpty()) { 
            int n = set.choose();
            aux.add(n);
            aux2.add(n);
            set.remove(n);
        }

        while(!aux.isEmpty()) {
            int n = aux.choose();
            set.add(n);
            aux.remove(n);
        }

        return aux2;

    }
}
