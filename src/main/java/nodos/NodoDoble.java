/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nodos;

/**
 * nodo generico doble con referencias al nodo anterior y al siguiente
 *
 * @param <T> tipo de dato que almacena el nodo
 * @author julian izaguirre
 */
public class NodoDoble<T> {
    private T dato;
    private NodoDoble<T> siguiente;
    private NodoDoble<T> anterior;
 
    /**
     * constructor que inicializa el nodo con un dato
     * las referencias anterior y siguiente quedan en null
     *
     * @param dato valor que se almacena en el nodo
     */
    public NodoDoble(T dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
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
    public NodoDoble<T> getSiguiente() {
        return siguiente;
    }
 
    /**
     * asigna la referencia al siguiente nodo
     *
     * @param siguiente nodo que va despues de este en la estructura
     */
    public void setSiguiente(NodoDoble<T> siguiente) {
        this.siguiente = siguiente;
    }
 
    /**
     * regresa la referencia al nodo anterior
     *
     * @return nodo anterior o null si no hay uno
     */
    public NodoDoble<T> getAnterior() {
        return anterior;
    }
 
    /**
     * asigna la referencia al nodo anterior
     *
     * @param anterior nodo que va antes de este en la estructura
     */
    public void setAnterior(NodoDoble<T> anterior) {
        this.anterior = anterior;
    }
}
