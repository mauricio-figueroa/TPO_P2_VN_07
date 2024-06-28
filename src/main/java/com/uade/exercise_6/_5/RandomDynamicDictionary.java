package com.uade.exercise_6._5;

import com.uade.exercise_6._2.ISet;
import com.uade.exercise_6._2.Set;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class RandomDynamicDictionary implements MultipleDictionary {

    private KeyNode first;

    @Override
    public void add(int key, int value) {
        if(this.getKeys().isEmpty()) {
            this.first = new KeyNode(key, null, new NodeOfDictionary(value, null));
            return;
        }

        KeyNode current = this.first;
        while(current.getNext() != null) {
            if(current.getKey() == key) {
                NodeOfDictionary currentAux = current.getValue();
                while (currentAux.getNext() != null) {
                    currentAux = currentAux.getNext();
                }
                currentAux.setNext(new NodeOfDictionary(value, null));
                return;
            }
            current = current.getNext();
        }
        current.setNext(new KeyNode(key, null, new NodeOfDictionary(value, null)));
    }

    @Override
    public void remove(int key, int value) {
        if(Objects.isNull(this.first)) {
            throw new RuntimeException("No existe el par clave-valor");
        }
        if(this.first.getNext() == null) {
            if(this.first.getKey() == key) {
                if(this.first.getValue().getNext() == null) {
                    if(this.first.getValue().getValue() == value) {
                        this.first = null;
                    }
                    throw new RuntimeException("No existe el valor para la clave");
                }
                this.remove(this.first.getKey(), value);
            }
            return;
        }

        KeyNode backup = this.first;
        KeyNode current = this.first.getNext();
        while(current.getNext() != null) {
            if(current.getKey() == key) {
                if(current.getValue().getNext() == null) {
                    if(current.getValue().getValue() == value) {
                        backup.setNext(current.getNext());
                    }
                    throw new RuntimeException("No existe el valor para la clave");
                }
                this.remove(current.getKey(), value);
                return;
            }
            backup = current;
            current = current.getNext();
        }

        if(current.getKey() == key) {
            if(current.getValue().getNext() == null) {
                if(current.getValue().getValue() == value) {
                    backup.setNext(current.getNext());
                }
                throw new RuntimeException("No existe el valor para la clave");
            }
            this.remove(current.getValue(), value);
            return;
        }
        throw new RuntimeException("No existe el par clave-valor");
    }

    private void remove(NodeOfDictionary node, int value) {
        NodeOfDictionary backup = node;
        NodeOfDictionary current = node.getNext();
        while(current.getNext() != null) {
            if(current.getValue() == value) {
                backup.setNext(current.getNext());
                return;
            }
            current = current.getNext();
        }

        if(current.getValue() == value) {
            backup.setNext(current.getNext());
        }
    }
    @Override
   public ISet getKeys() {
        ISet keys = new DynamicSet();
       KeyNode current = this.first;
        while(current != null) {
            keys.add(current.getKey());
            current = current.getNext();
        }
        return keys;
    }

    @Override
    public int getValue(int key) {
        KeyNode current = this.first;
        while(current != null) {
            if(current.getKey() == key) {
                List<Integer> list = new ArrayList<>();
                NodeOfDictionary currentAux = current.getValue();
                while(currentAux != null) {
                    list.add(currentAux.getValue());
                    currentAux = currentAux.getNext();
                }
                if (!list.isEmpty()) {
                    Random rand = new Random();
                    int randomIndex = rand.nextInt(list.size());
                    return list.get(randomIndex);
                } else {
                    throw new RuntimeException("No hay valores asociados a la clave");
                }
            }
            current = current.getNext();
        }
        throw new RuntimeException("No se encontró la clave");
    }


}
