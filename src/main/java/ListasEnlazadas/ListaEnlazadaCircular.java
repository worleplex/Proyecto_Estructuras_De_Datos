/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListasEnlazadas;

import Interfaces.IList;
import Nodos.NodoSimple;
import Excepciones.ListException;

/**
 * Lista enlazada circular para la rotacion de turnos o roles
 *
 * @author chris
 */
public class ListaEnlazadaCircular<T> implements IList<T> {

    // Punteros
    private NodoSimple<T> inicio;
    private NodoSimple<T> ultimo;

    private int size;

    public ListaEnlazadaCircular() {
        this.inicio = null;
        this.ultimo = null;
        this.size = 0;
    }

    @Override
    public void append(T o) {
        NodoSimple<T> nuevo = new NodoSimple<>(o);

        if (inicio == null) {
            inicio = nuevo;
            ultimo = nuevo;
            
            // Para ser circular el ultimo debe apuntar al primer nodo
            ultimo.setSiguiente(inicio);
        } else {
            
            ultimo.setSiguiente(nuevo);
            nuevo.setSiguiente(inicio);
            
            ultimo = nuevo; // El nuevo nodo ahora es el último
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
            if (inicio == null) {
                append(o);
            } else {
                nuevo.setSiguiente(inicio);
                inicio = nuevo;
                ultimo.setSiguiente(inicio); // Cierre del círculo
                size++;
            }
            return;
        }

        // Insertar en medio
        NodoSimple<T> aux = inicio;
        for (int cont = 0; cont < i - 1; cont++) {
            aux = aux.getSiguiente();
        }

        nuevo.setSiguiente(aux.getSiguiente());
        aux.setSiguiente(nuevo);
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

        // Solo hay un elemento
        if (size == 1) {
            nodoAEliminar = inicio;
            inicio = null;
            ultimo = null;
            
        } else if (i == 0) { 
          
            // Eliminar el primero
            nodoAEliminar = inicio;
            inicio = inicio.getSiguiente();
            ultimo.setSiguiente(inicio); // El ultimo noda ahora apunta al (nuevo) primer nodo
            
        } else { 
            
            // Eliminar en medio o al final
            NodoSimple<T> anterior = inicio;
            for (int cont = 0; cont < i - 1; cont++) {
                anterior = anterior.getSiguiente();
            }
            nodoAEliminar = anterior.getSiguiente();
            anterior.setSiguiente(nodoAEliminar.getSiguiente());

            // Si actualiza el ultimo si se borra al ser una lista circular
            if (i == size - 1) {
                ultimo = anterior;
            }
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
        if (inicio == null) {
            return false;
        }

        NodoSimple<T> actual = inicio;
        int index = 0;

        do {
            if (actual.getDato().equals(o)) {
                try {
                    remove(index);
                    return true;
                } catch (ListException e) {
                    return false;
                }
            }
            actual = actual.getSiguiente();
            index++;
        } while (actual != inicio);

        return false;
    }

    @Override
    public int indexOf(T o) {
        if (inicio == null) {
            return -1;
        }

        NodoSimple<T> actual = inicio;
        int index = 0;

        do {
            if (actual.getDato().equals(o)) {
                return index;
            }
            actual = actual.getSiguiente();
            index++;
        } while (actual != inicio);

        return -1;
    }

    @Override
    public void set(T o, int i) {
        try {
            if (i < 0 || i >= size || inicio == null) {
                return;
            }

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
        ultimo = null;
        size = 0;
    }

    /**
     * Metodo para la rotacion de roles, se llama para mover el puntero de
     * 'inicio' al siguiente elemento de forma permanente, rotando la lista
     * entera un espacio
     */
    public void rotar() {
        if (inicio != null && size > 1) {
            inicio = inicio.getSiguiente();
            ultimo = ultimo.getSiguiente();
        }
    }
}
