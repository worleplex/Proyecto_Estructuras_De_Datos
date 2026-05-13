/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

import nodos.NodoSimple;

/**
 * Solo se puede eliminar y agregar desde el ultimo
 * 
 * @param <T> tipo de dato que almacena la pila
 * @author julian izaguirre
 */
public class Pila<T> {
    private NodoSimple<T> tope;

    /**
     * constructor que inicaializa el inicio nulo
     */
    public Pila() {
        this.tope = null;
    }    
        
    /**
     * Inserta un dato en el tope de la pila
     * @param dato Nuevo dato en la pila
     */
    public void push(T dato) {
        NodoSimple<T> nuevo = new NodoSimple<>(dato);
        nuevo.setSiguiente(tope);
        tope = nuevo;
    }
    
    /**
     * Elimina y devuelve el elemento que esta en el tope de la pila
     * @return Dato que esta en el tope de la pila.
     */
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Pila vacia.");
        }
        T dato = tope.getDato();
        tope = tope.getSiguiente();
        return dato;
    }
    
    /**
     * Consulta el elemento que esta en el tope de la pila sin eliminarlo
     * @return Dato en el tope de la pila
     */
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Pila vacia.");
        }       
        return tope.getDato();
    }
    
    /**
     * Verifica si la pila esta vacia
     * @return true si esta vacia, false en caso contrario
     */
    public boolean isEmpty() {
        return tope == null;
    }
    
    /**
     * Regresa la cantidad de elementos en la pila
     * @return Cantidad de elementos en la pila
     */
    public int getSize() {       
        int size = 0;
        NodoSimple<T> aux = tope;
        while (aux != null) {  
            size++;
            aux = aux.getSiguiente();
        }
        return size;
    }   
}
