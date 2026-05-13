/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nodos;

/**
 * nodo simple con referencia al siguiente nodo
 * lo vamos a usar como base para lista enlazada simple, pila y cola
 * 
 * @param <T> tipo de dato que almacena el nodo
 * @author julian izaguirre
 */
public class NodoSimple<T> {
    private T dato;
    private NodoSimple<T> siguiente;
    
    /**
     * constructor que inicializa el nodo con un dato
     * la referencia al siguiente nodo queda en null
     *
     * @param dato valor que se almacena en el nodo
     */
    public NodoSimple(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }
    
    /**
     * regresa el dato almacenado en el nodo
     *
     * @return dato de tipo T guardado en el nodo
     */
    public T getDato() {
        return dato;
    }
 
    /**
     * asigna un nuevo dato al nodo
     *
     * @param dato nuevo valor de tipo T a almacenar
     */
    public void setDato(T dato) {
        this.dato = dato;
    }
 
    /**
     * regresa la referencia al siguiente nodo
     *
     * @return nodo siguiente o null si no hay uno
     */
    public NodoSimple<T> getSiguiente() {
        return siguiente;
    }
 
    /**
     * asigna la referencia al siguiente nodo
     *
     * @param siguiente nodo que va despues de este en la estructura
     */
    public void setSiguiente(NodoSimple<T> siguiente) {
        this.siguiente = siguiente;
    }
}