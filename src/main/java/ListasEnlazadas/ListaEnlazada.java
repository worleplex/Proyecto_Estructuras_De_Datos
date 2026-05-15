/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListasEnlazadas;

import Interfaces.IList;
import Nodos.NodoSimple;
import Excepciones.ListException;


/**
 * Implementacionde una lista enlazada para lisas de inscripciones
 * 
 * @param <T> Tipo de dato genérico
 * @author chris
 */
public class ListaEnlazada<T> implements IList<T> {
    private NodoSimple<T> inicio;
    private int size;

    public ListaEnlazada() {
        this.inicio = null;
        this.size = 0;
    }

    @Override
    public void append(T o) {
        NodoSimple<T> nuevo = new NodoSimple<>(o);

        if (inicio == null) {
            inicio = nuevo;
        } else {
            
            
            // Recorrer hasta llegar al último nodo
            NodoSimple<T> aux = inicio;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
        }
        size++;
    }

    @Override
    public void insert(T o, int i) throws ListException {
        if (i < 0 || i > size) {
            throw new ListException("Posición fuera de rango");
        }

        if (i == size) {
            append(o);
            return;
        }

        NodoSimple<T> nuevo = new NodoSimple<>(o);

        if (i == 0) { 
            // Insertar al inicio
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
            
        } else { // Insertar en medio
            NodoSimple<T> aux = inicio;
            for (int cont = 0; cont < i - 1; cont++) {
                aux = aux.getSiguiente();
            }
            nuevo.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nuevo);
        }
        size++;
    }

    @Override
    public T get(int i) throws ListException {
        if (i < 0 || i >= size || inicio == null) {
            throw new ListException("Posición inválida o lista vacía");
        }

        NodoSimple<T> aux = inicio;
        for (int cont = 0; cont < i; cont++) {
            aux = aux.getSiguiente();
        }
        return aux.getDato();
    }

    @Override
    public T remove(int i) throws ListException {
        if (i < 0 || i >= size || inicio == null) {
            throw new ListException("Posición inválida o lista vacía");
        }

        NodoSimple<T> nodoAEliminar;

        if (i == 0) { 
            // Eliminar el inicio
           nodoAEliminar = inicio;
            inicio = inicio.getSiguiente();
            
        } else { // Eliminar en medio o al final
            NodoSimple<T> aux = inicio;
            for (int cont = 0; cont < i - 1; cont++) {
                aux = aux.getSiguiente();
            }
            nodoAEliminar = aux.getSiguiente();
            aux.setSiguiente(nodoAEliminar.getSiguiente());
        }

        size--;
        return nodoAEliminar.getDato();
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean remove(T o) {
        if (inicio == null) return false;

        // Si el elemento a borrar está en el inicio
        if (inicio.getDato().equals(o)) {
            inicio = inicio.getSiguiente();
            size--;
            return true;
        }

        NodoSimple<T> aux = inicio;
        
        // Buscamos un nodo que por delante tenga el dato que buscamos
        while (aux.getSiguiente() != null) {
            if (aux.getSiguiente().getDato().equals(o)) {
                aux.setSiguiente(aux.getSiguiente().getSiguiente());
                size--;
                return true;
            }
            aux = aux.getSiguiente();
        }

        return false; // No esta
    }

    @Override
    public int indexOf(T o) {
        NodoSimple<T> aux = inicio;
        int index = 0;

        while (aux != null) {
            if (aux.getDato().equals(o)) {
                return index;
            }
            aux = aux.getSiguiente();
            index++;
        }

        return -1; // No existe
    }

    @Override
    public void set(T o, int i) {
        try {
            if (i < 0 || i >= size || inicio == null) return;
            
            NodoSimple<T> aux = inicio;
            for (int cont = 0; cont < i; cont++) {
                aux = aux.getSiguiente();
            }
            aux.setDato(o);
        } catch (Exception e) {
            throw new RuntimeException("Posicion invalida");
        }
    }

    @Override
    public void clear() {
        inicio = null;
        size = 0;
    }
}
