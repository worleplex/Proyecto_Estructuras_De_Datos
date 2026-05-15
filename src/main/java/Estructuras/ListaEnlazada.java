/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import Excepciones.ListException;
import Interfaces.IList;
import Nodos.NodoSimple;

/**
 implementacion de una lista enlazada simple generica
 * permite insertar, eliminar y consultar elementos por posicion
 * se usa como base para la pila, la cola y la lista de inscritos en un curso
 *
 * @param <T> tipo de dato que almacena la lista
 * @author julian izaguirre
 */
public class ListaEnlazada<T> implements IList<T> {
    private NodoSimple<T> inicio;
    private int nElementos;
 
    /**
     * constructor que inicializa la lista vacia
     * el inicio queda en null y el contador de elementos en cero
     */
    public ListaEnlazada() {
        this.inicio = null;
        this.nElementos = 0;
    }
 
    /**
     * regresa la referencia al primer nodo de la lista
     * se usa en estructuras que necesitan recorrer la lista directamente
     *
     * @return nodo de inicio de la lista o null si esta vacia
     */
    public NodoSimple<T> getInicio() {
        return inicio;
    }
 
    /**
     * elimina la primera ocurrencia del elemento recibido en la lista
     * si el elemento no existe regresa false sin lanzar excepcion
     *
     * @param o elemento a remover de la lista
     * @return true si el elemento existia y fue removido, false si no se encontro
     * @throws ListException si la lista esta vacia al momento de llamar el metodo
     */
    @Override
    public boolean remove(T o) {
        if (empty()) {
            throw new ListException("lista vacia");
        }
        // el elemento a eliminar esta al inicio
        if (inicio.getDato().equals(o)) {
            inicio = inicio.getSiguiente();
            nElementos--;
            return true;
        }
        // recorre la lista buscando el elemento por su valor
        NodoSimple<T> aux = inicio;
        while (aux.getSiguiente() != null) {
            if (aux.getSiguiente().getDato().equals(o)) {
                aux.setSiguiente(aux.getSiguiente().getSiguiente());
                nElementos--;
                return true;
            }
            aux = aux.getSiguiente();
        }
        return false;
    }
 
    /**
     * busca la primera ocurrencia del elemento en la lista y regresa su posicion
     * si el elemento no existe regresa -1
     *
     * @param o elemento a buscar en la lista
     * @return indice de la primera ocurrencia del elemento o -1 si no existe
     */
    @Override
    public int indexOf(T o) {
        NodoSimple<T> aux = inicio;
        for (int i = 0; aux != null; i++) {
            if (aux.getDato().equals(o)) {
                return i;
            }
            aux = aux.getSiguiente();
        }
        return -1;
    }
 
    /**
     * reemplaza el elemento en la posicion indicada por el elemento recibido
     *
     * @param o nuevo elemento a colocar en la posicion i
     * @param i posicion donde se reemplaza el elemento
     * @throws ListException si el indice es menor que 0 o mayor o igual a nElementos
     */
    @Override
    public void set(T o, int i) throws ListException {
        if (i < 0 || i >= nElementos) {
            throw new ListException("indice fuera de limites");
        }
        NodoSimple<T> nodo = inicio;
        for (int j = 0; j < i; j++) {
            nodo = nodo.getSiguiente();
        }
        nodo.setDato(o);
    }
 
    /**
     * elimina todos los elementos de la lista
     * el inicio queda en null y el contador de elementos en cero
     */
    @Override
    public void clear() {
        inicio = null;
        nElementos = 0;
    }
 
    /**
     * inserta un nuevo elemento al final de la lista
     * si la lista esta vacia el nuevo nodo se convierte en el inicio
     *
     * @param o elemento a insertar al final de la lista
     */
    @Override
    public void append(T o) {
        NodoSimple<T> nodoNuevo = new NodoSimple<>(o);
        if (inicio == null) {
            // el nuevo nodo es el primero
            inicio = nodoNuevo;
        } else {
            // avanza hasta el ultimo nodo de la lista
            NodoSimple<T> nodo = inicio;
            while (nodo.getSiguiente() != null) {
                nodo = nodo.getSiguiente();
            }
            // enlaza el ultimo nodo con el nuevo
            nodo.setSiguiente(nodoNuevo);
        }
        nElementos++;
    }
 
    /**
     * inserta un nuevo elemento en la posicion indicada de la lista
     * si la posicion es 0 el elemento se inserta al inicio
     * si la posicion es igual a nElementos se inserta al final
     *
     * @param o elemento a insertar en la lista
     * @param i posicion donde se inserta el elemento (desde 0)
     * @throws ListException si el indice es menor que 0 o mayor que nElementos
     */
    @Override
    public void insert(T o, int i) throws ListException {
        NodoSimple<T> nodoNuevo = new NodoSimple<>(o);
        if (i < 0 || i > nElementos) {
            throw new ListException("indice fuera de limites");
        }
        if (i == 0) {
            // el nuevo nodo apunta al antiguo inicio
            if (inicio != null) {
                nodoNuevo.setSiguiente(inicio);
            }
            inicio = nodoNuevo;
        } else {
            // avanza hasta el nodo anterior al punto de insercion
            NodoSimple<T> nodo = inicio;
            for (int j = 0; j < i - 1; j++) {
                nodo = nodo.getSiguiente();
            }
            nodoNuevo.setSiguiente(nodo.getSiguiente());
            nodo.setSiguiente(nodoNuevo);
        }
        nElementos++;
    }
 
    /**
     * inspecciona el elemento en la posicion indicada sin extraerlo de la lista
     *
     * @param i posicion del elemento a consultar (desde 0)
     * @return elemento almacenado en la posicion i
     * @throws ListException si la lista esta vacia o el indice esta fuera de rango
     */
    @Override
    public T get(int i) throws ListException {
        if (empty()) {
            throw new ListException("lista vacia");
        }
        if (i < 0 || i >= nElementos) {
            throw new ListException("indice fuera de limites");
        }
        NodoSimple<T> nodo = inicio;
        for (int j = 0; j < i; j++) {
            nodo = nodo.getSiguiente();
        }
        return nodo.getDato();
    }
 
    /**
     * extrae y elimina el elemento en la posicion indicada de la lista
     *
     * @param i posicion del elemento a eliminar (desde 0)
     * @return elemento que estaba almacenado en la posicion i
     * @throws ListException si la lista esta vacia o el indice esta fuera de rango
     */
    @Override
    public T remove(int i) throws ListException {
        T o;
        if (empty()) {
            throw new ListException("lista vacia");
        }
        if (i < 0 || i >= nElementos) {
            throw new ListException("indice fuera de limites");
        }
        if (i == 0) {
            // eliminacion al inicio: guarda el dato y avanza el inicio
            o = inicio.getDato();
            inicio = inicio.getSiguiente();
        } else {
            // avanza hasta el nodo anterior al que se quiere eliminar
            NodoSimple<T> nodo = inicio;
            for (int j = 0; j < i - 1; j++) {
                nodo = nodo.getSiguiente();
            }
            o = nodo.getSiguiente().getDato();
            // enlaza el nodo anterior con el nodo posterior al eliminado
            nodo.setSiguiente(nodo.getSiguiente().getSiguiente());
        }
        nElementos--;
        return o;
    }
 
    /**
     * determina si la lista esta vacia
     *
     * @return true si no hay elementos en la lista, false en caso contrario
     */
    @Override
    public boolean empty() {
        return inicio == null;
    }
 
    /**
     * determina si la lista contiene el elemento recibido
     * recorre la lista completa comparando con equals
     *
     * @param o elemento a buscar en la lista
     * @return true si el elemento existe en la lista, false en caso contrario
     */
    public boolean contains(T o) {
        NodoSimple<T> aux = inicio;
        while (aux != null) {
            if (aux.getDato().equals(o)) {
                return true;
            }
            aux = aux.getSiguiente();
        }
        return false;
    }
 
    /**
     * regresa el numero de elementos almacenados en la lista
     *
     * @return cantidad de elementos en la lista
     */
    @Override
    public int size() {
        return nElementos;
    }
 
    /**
     * genera una cadena con todos los elementos de la lista separados por coma
     * el formato de salida es [elemento0, elemento1, ..., elementoN]
     *
     * @return cadena con los elementos de la lista en orden
     */
    @Override
    public String toString() {
        String s = "[";
        NodoSimple<T> nodo = inicio;
        while (nodo != null) {
            s += nodo.getDato();
            if (nodo.getSiguiente() != null) {
                s += ", ";
            }
            nodo = nodo.getSiguiente();
        }
        s += "]";
        return s;
    }
}