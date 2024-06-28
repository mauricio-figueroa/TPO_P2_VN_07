package com.uade.exercise_6._1;

public class DynamicStackLimited implements IStack{

    private NodeOfStack first;
    private int limit;
    private int count;

    public DynamicStackLimited(int limit)
    {
        this.limit = limit;
        count = 0;
    }

    @Override
    public void add(int a) {
        if(limit <= count)
        {
            throw new RuntimeException("No se puede agregar a la pila. La pila esta llena");
        }
        this.first = new NodeOfStack(a, this.first);
        count ++;
    }

    @Override
    public void remove() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede remover el tope de una pila vacia");
        }
        this.first = this.first.getNext();
        count --;
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public int getTop() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede obtener el tope de una pila vacia");
        }
        return this.first.getValue();
    }
}
