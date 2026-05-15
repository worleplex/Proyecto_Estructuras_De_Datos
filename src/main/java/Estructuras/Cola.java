/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import Nodos.NodoSimple;

/**
 * implementacion de una cola generica con comportamiento FIFO
 * el primer elemento en entrar es el primero en salir
 * se usa para gestionar la cola de solicitudes de calificaciones
 * las inserciones se hacen al final y las extracciones al inicio
 * 
 * @param <T> tipo de dato que almacena la cola
 * @author julian izaguirre
 */
public class Cola<T> {
    private NodoSimple<T> inicio;
    private NodoSimple<T> fin;
 
    /**
     * constructor que inicializa la cola vacia
     * el frente y el final quedan en null porque no hay elementos
     */
    public Cola() {
        this.inicio = null;
        this.fin = null;
    }
 
    /**
     * inserta un nuevo elemento al final de la cola
     * si la cola esta vacia el nuevo nodo es tanto el frente como el final
     * si ya tiene elementos solo se actualiza el apuntador al final
     *
     * @param dato elemento a insertar al final de la cola
     */
    public void enqueue(T dato) {
        NodoSimple<T> nuevo = new NodoSimple<>(dato);
 
        if (isEmpty()) {
            inicio = fin = nuevo;
        } else {
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }
    }
 
    /**
     * elimina y regresa el elemento del frente de la cola
     * si despues de eliminar la cola queda vacia, el final tambien se pone en null
     *
     * @return elemento que estaba al frente de la cola
     * @throws RuntimeException si la cola esta vacia al momento de llamar el metodo
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("cola vacia");
        }
 
        T dato = inicio.getDato();
        inicio = inicio.getSiguiente();
 
        if (inicio == null) {
            fin = null;
        }
        return dato;
    }
 
    /**
     * regresa el elemento del frente de la cola sin eliminarlo
     * permite consultar quien es el siguiente en salir sin modificar la cola
     *
     * @return elemento que esta al frente de la cola
     * @throws RuntimeException si la cola esta vacia al momento de llamar el metodo
     */
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("cola vacia");
        }
        return inicio.getDato();
    }
 
    /**
     * regresa el elemento del final de la cola sin eliminarlo
     * permite consultar el ultimo elemento que entro sin modificar la cola
     *
     * @return elemento que esta al final de la cola
     * @throws RuntimeException si la cola esta vacia al momento de llamar el metodo
     */
    public T rear() {
        if (isEmpty()) {
            throw new RuntimeException("cola vacia");
        }
        return fin.getDato();
    }
 
    /**
     * determina si la cola esta vacia
     * la cola esta vacia cuando el frente es null
     *
     * @return true si no hay elementos en la cola, false en caso contrario
     */
    public boolean isEmpty() {
        return inicio == null;
    }
 
    /**
     * regresa la cantidad de elementos que hay actualmente en la cola
     * recorre todos los nodos desde el frente hasta el final para contarlos
     *
     * @return numero de elementos en la cola
     */
    public int getSize() {
        int size = 0;
        NodoSimple<T> aux = inicio;
        while (aux != null) {
            size++;
            aux = aux.getSiguiente();
        }
        return size;
    }  
}
