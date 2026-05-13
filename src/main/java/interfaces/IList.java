/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import excepciones.ListException;

/**
 *
 * @author julian izaguirre
 * @param <T>
 */
public interface IList<T> {
    /**
     * Inserta un elemento al final de la lista
     *
     * @param o Elemento a insertar al final de la lista
     * @throws ListException Si la lista esta llena
     */
    public void append(T o) throws ListException;

    /**
     * Inserta un elemento en la posición i de la lista
     *
     * @param o Elemento a insertar en la posición i de la lista
     * @param i Posición i de la lista donde se inserta el elemento
     * @throws ListException Si la lista esta llena
     */
    public void insert(T o, int i) throws ListException;

    /**
     * inspecciona el elemento en la posición i de la lista sin extraerlo
     *
     * @param i Posición i de la lista del elemento a inspeccionar
     * @return El elemento en la posición i de la lista
     * @throws ListException Si la lista esta vacia
     */
    public T get(int i) throws ListException;

    /**
     * Extrae el elemento de la posición i de la lista
     *
     * @param i Posición i de la lista del elemento a remover
     * @return El elemento de la posición i de la lista
     * @throws ListException Si la lista esta vacia
     */
    public T remove(int i) throws ListException;

    /**
     * Determina si la lista se encuentra vacía
     *
     * @return true si la lista se encuentra vacia, false en caso contrario.
     */
    public boolean empty();

    /**
     * Regresa el numero de elementos en la lista
     *
     * @return El numero de elementos en la lista
     */
    public int size();

    /**
     * elimina la primera ocurrencia del elemento del parámetro si existe. El
     * método regresa true si el elemento existe en la lista, false en caso
     * contrario.
     *
     * @param o elemento a remover
     * @return true si el elemento existe, false en caso contrario
     */
    public boolean remove(T o);

    /**
     * que regresa el índice de la primera ocurrencia del elemento del parámetro
     * en la lista, o -1 si el elemento no existe.
     *
     * @param o
     * @return indice de la primera ocurrencia del parametro, -1 si no existe
     */
    public int indexOf(T o);

    /**
     * que reemplaza el elemento que se encuentra en la posición i de la lista
     * por el objeto del parámetro.
     *
     * @param o elemento a remplazar
     * @param i posicion a remplazar
     */
    public void set(T o, int i);

    /**
     * elimina todos los elementos de la lista.
     */
    public void clear();
}
