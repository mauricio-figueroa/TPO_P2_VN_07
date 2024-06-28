package com.uade.exercise_3;

public interface IQueueOfQueue {

    /**
     * Postcondicion: Acola (coloca en el final de la cola) una Cola.
     *
     * @param a cola a acolar.
     */
    void add(StaticQueue a);

    /**
     * Precondicion: La cola no esta vacia.
     * Postcondicion: Desacola (quita el primer elemento).
     */
    void remove();

    /**
     * @return <code>true</code> si la cola esta vacia, <code>false</code> en otro caso.
     */
    boolean isEmpty();

    /**
     * @return Devuelve el primero.
     */
    int getFirst();

    /**
     * Invierte la instancia de IQueueOfQueue y cada StaticQueue dentro de esta.
     */
    QueueOfQueue reverseWithDepth();

    /**
     * Crea una instancia de StaticQueue a partir de la instancia de IQueueOfQueue con los mismos elementos,
     * juntando todos los elementos en una sola cola respetando el orden.
     *
     * @return StaticQueue con los elementos de IQueueOfQueue.
     */
    StaticQueue flat();

    /**
     * Recibe n instancias de IQueueOfQueue y genera una nueva instancia de IQueueOfQueue
     * con todos los elementos de las instancias anteriores manteniendo el orden en que se leyeron los valores
     * de estas instancias.
     *
     * @param queues colas a concatenar.
     * @return Nueva instancia de IQueueOfQueue con todas las colas concatenadas.
     */
    QueueOfQueue concatenate(QueueOfQueue... queues);

    /**
     * @return La cantidad de colas en la estructura.
     */
    int getCount();

    /**
     * Muestra por consola el contenido de todas las colas dentro de la estructura.
     */
    void displayQueues();
}
