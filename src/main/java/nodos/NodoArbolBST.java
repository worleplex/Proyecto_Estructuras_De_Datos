/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nodos;

/**
 * nodo generico para arboles binarios
 * el BST almacena estudiantes ordenados por matricula
 * el AVL almacena estudiantes ordenados por promedio
 *
 * @param <T> tipo de dato que almacena el nodo
 * @author julian izaguirre
 */
public class NodoArbolBST<T> {
    private T dato;
    private NodoArbolBST<T> izquierdo;
    private NodoArbolBST<T> derecho;
 
    /**
     * constructor que inicializa el nodo con un dato
     * los hijos izquierdo y derecho quedan en null porque aun no apuntan a nada
     *
     * @param dato valor que se almacena en el nodo
     */
    public NodoArbolBST(T dato) {
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
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
     * regresa la referencia al hijo izquierdo
     *
     * @return nodo hijo izquierdo o null si no tiene
     */
    public NodoArbolBST<T> getIzquierdo() {
        return izquierdo;
    }
 
    /**
     * asigna la referencia al hijo izquierdo
     *
     * @param izquierdo nodo que sera el hijo izquierdo de este nodo
     */
    public void setIzquierdo(NodoArbolBST<T> izquierdo) {
        this.izquierdo = izquierdo;
    }
 
    /**
     * regresa la referencia al hijo derecho
     *
     * @return nodo hijo derecho o null si no tiene
     */
    public NodoArbolBST<T> getDerecho() {
        return derecho;
    }
 
    /**
     * asigna la referencia al hijo derecho
     *
     * @param derecho nodo que sera el hijo derecho de este nodo
     */
    public void setDerecho(NodoArbolBST<T> derecho) {
        this.derecho = derecho;
    }
}
