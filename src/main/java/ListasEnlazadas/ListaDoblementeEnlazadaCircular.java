/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListasEnlazadas;

import Interfaces.IList;
import Nodos.NodoDoble;
import Excepciones.ListException;

/**
 * Lista doblemente circular, nos permite recorrer hacia adelante y atras
 *
 * @param <T> dato generico
 * @author chris
 */
public class ListaDoblementeEnlazadaCircular<T> implements IList<T> {
    
    private NodoDoble<T> inicio;
    private int size;

    public ListaDoblementeEnlazadaCircular() {
        this.inicio = null;
        this.size = 0;
    }

    @Override
    public void append(T o) {
        // Agrega al final de la lista
        NodoDoble<T> nuevo = new NodoDoble<>(o);

        if (inicio == null) {
            inicio = nuevo;
            inicio.setSiguiente(inicio);
            inicio.setAnterior(inicio);
        } else {
            
            // El ultimo nodo siempre es el anterior al inicio
            NodoDoble<T> ultimo = inicio.getAnterior();

            ultimo.setSiguiente(nuevo);
            nuevo.setAnterior(ultimo);

            nuevo.setSiguiente(inicio);
            inicio.setAnterior(nuevo);
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

        NodoDoble<T> nuevo = new NodoDoble<>(o);

        if (i == 0) { 
            // Insertar al inicio
            if (inicio == null) {
                append(o);
                return;
            } else {
                NodoDoble<T> ultimo = inicio.getAnterior();
                nuevo.setSiguiente(inicio);
                nuevo.setAnterior(ultimo);
                inicio.setAnterior(nuevo);
                ultimo.setSiguiente(nuevo);
                inicio = nuevo;
                size++;
            }
            return;
        }

        // Insertar en medio
        NodoDoble<T> aux = inicio;
        for (int cont = 0; cont < i; cont++) {
            aux = aux.getSiguiente();
        }

        nuevo.setSiguiente(aux);
        nuevo.setAnterior(aux.getAnterior());
        aux.getAnterior().setSiguiente(nuevo);
        aux.setAnterior(nuevo);
        size++;
    }

    @Override
    public T get(int i) throws ListException {
        if (i < 0 || i >= size || inicio == null) {
            throw new ListException("Posición inválida o lista vacía");
        }

        NodoDoble<T> aux = inicio;
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

        NodoDoble<T> nodoAEliminar = inicio;

        if (size == 1) { // Caso donde solo hay un elemento
            inicio = null;
            
        } else if (i == 0) { // Eliminar el primero
            NodoDoble<T> ultimo = inicio.getAnterior();
            inicio = inicio.getSiguiente();
            inicio.setAnterior(ultimo);
            ultimo.setSiguiente(inicio);
            
        } else { 
            // Eliminar en medio o al final
            for (int cont = 0; cont < i; cont++) {
                nodoAEliminar = nodoAEliminar.getSiguiente();
            }
            NodoDoble<T> anterior = nodoAEliminar.getAnterior();
            NodoDoble<T> siguiente = nodoAEliminar.getSiguiente();

            anterior.setSiguiente(siguiente);
            siguiente.setAnterior(anterior);
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

        NodoDoble<T> actual = inicio;
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

        NodoDoble<T> actual = inicio;
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

            NodoDoble<T> aux = inicio;
            for (int cont = 0; cont < i; cont++) {
                aux = aux.getSiguiente();
            }
            aux.setDato(o);
        } catch (Exception e) {
            throw new RuntimeException("Posicion invalida ");
        }
    }

    @Override
    public void clear() {
        inicio = null;
        size = 0;
    }
}
