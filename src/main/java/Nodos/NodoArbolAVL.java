/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Nodos;

/**
 * nodo generico para arbol AVL balanceado
 *
 * @param <T> tipo de dato que almacena el nodo
 * @author julian izaguirre
 */
public class NodoArbolAVL<T> {
    private T dato;
    private int altura;
    private int factorBalance;
    private NodoArbolAVL<T> izquierdo;
    private NodoArbolAVL<T> derecho;
 
    /**
     * constructor que inicializa el nodo con un dato
     * la altura se inicializa en 1 al ser un nodo hoja
     * el factor de balance se inicializa en 0 al no tener hijos
     * los hijos izquierdo y derecho quedan en null
     *
     * @param dato valor que se almacena en el nodo
     */
    public NodoArbolAVL(T dato) {
        this.dato = dato;
        this.altura = 1;
        this.factorBalance = 0;
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
     * regresa la altura actual del nodo en el arbol
     *
     * @return altura del nodo, minimo 1 si es hoja
     */
    public int getAltura() {
        return altura;
    }
 
    /**
     * asigna la altura del nodo, se actualiza durante las rotaciones del AVL
     *
     * @param altura nuevo valor de altura para este nodo
     */
    public void setAltura(int altura) {
        this.altura = altura;
    }
 
    /**
     * regresa el factor de balance del nodo
     * un valor de -1, 0 o 1 indica que el nodo esta balanceado
     * un valor fuera de ese rango indica que se necesita una rotacion
     *
     * @return factor de balance calculado como altura(izq) - altura(der)
     */
    public int getFactorBalance() {
        return factorBalance;
    }
 
    /**
     * asigna el factor de balance del nodo, se recalcula tras cada insercion
     *
     * @param factorBalance nuevo valor del factor de balance
     */
    public void setFactorBalance(int factorBalance) {
        this.factorBalance = factorBalance;
    }
 
    /**
     * regresa la referencia al hijo izquierdo
     *
     * @return nodo hijo izquierdo o null si no tiene
     */
    public NodoArbolAVL<T> getIzquierdo() {
        return izquierdo;
    }
 
    /**
     * asigna la referencia al hijo izquierdo
     *
     * @param izquierdo nodo que sera el hijo izquierdo de este nodo
     */
    public void setIzquierdo(NodoArbolAVL<T> izquierdo) {
        this.izquierdo = izquierdo;
    }
 
    /**
     * regresa la referencia al hijo derecho
     *
     * @return nodo hijo derecho o null si no tiene
     */
    public NodoArbolAVL<T> getDerecho() {
        return derecho;
    }
 
    /**
     * asigna la referencia al hijo derecho
     *
     * @param derecho nodo que sera el hijo derecho de este nodo
     */
    public void setDerecho(NodoArbolAVL<T> derecho) {
        this.derecho = derecho;
    }
}
