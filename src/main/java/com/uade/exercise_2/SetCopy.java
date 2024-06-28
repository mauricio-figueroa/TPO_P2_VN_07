package com.uade.exercise_2;


import com.uade.exercise_2.model.DynamicSet;
import com.uade.exercise_2.model.Set;

public class SetCopy {
    
    public static Set copy(Set set) { 
        Set aux = new DynamicSet(); 
        Set aux2 = new DynamicSet(); 

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
