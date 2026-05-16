/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arboles;

import Nodos.NodoArbolBST;

/**
 *
 * @author Jorge
 */
public class ArbolBST<T extends Comparable<T>> {
    private NodoArbolBST<T> raiz;
    /**
     * constructor que inicializa el arbol vacio
     */
    public ArbolBST() {
        this.raiz = null;
    }
    /**
     * verifica si el arbol esta vacio
     *
     * @return true si no hay raiz, false en caso contrario
     */
    public boolean estaVacio() {
        return raiz == null;
    }
    /**
     * inserta un nuevo dato
     *
     * @param dato dato a insertar
     */
    public void insertar(T dato) {
        raiz = insertarRec(raiz, dato);
    }
    /**
     * metodo recursivo para insertar
     *
     * @param nodo nodo actual
     * @param dato dato a insertar
     * @return nodo actualizado
     */
    private NodoArbolBST<T> insertarRec(NodoArbolBST<T> nodo, T dato) {
        if (nodo == null) {
            return new NodoArbolBST<>(dato);
        }
        if (dato.compareTo(nodo.getDato()) < 0) {
            nodo.setIzquierdo(insertarRec(nodo.getIzquierdo(), dato));
        } else if (dato.compareTo(nodo.getDato()) > 0) {
            nodo.setDerecho(insertarRec(nodo.getDerecho(), dato));
        }
        return nodo;
    }
    /**
     * busca un dato dentro del arbol
     *
     * @param dato dato a buscar
     * @return true si existe, false si no
     */
    public boolean contiene(T dato) {
        return buscarRec(raiz, dato);
    }
    /**
     * metodo recursivo de busqueda
     *
     * @param nodo nodo actual
     * @param dato dato buscado
     * @return true si existe
     */
    private boolean buscarRec(NodoArbolBST<T> nodo, T dato) {
        if (nodo == null) {
            return false;
        }
        if (dato.compareTo(nodo.getDato()) == 0) {
            return true;
        }
        if (dato.compareTo(nodo.getDato()) < 0) {
            return buscarRec(nodo.getIzquierdo(), dato);
        }
        return buscarRec(nodo.getDerecho(), dato);
    }
    /**
     * elimina un dato del arbol
     *
     * @param dato dato a eliminar
     */
    public void eliminar(T dato) {
        raiz = eliminarRec(raiz, dato);
    }
    /**
     * metodo recursivo para eliminar
     *
     * @param nodo nodo actual
     * @param dato dato a eliminar
     * @return nodo actualizado
     */
    private NodoArbolBST<T> eliminarRec(NodoArbolBST<T> nodo, T dato) {
        if (nodo == null) {
            return null;
        }
        if (dato.compareTo(nodo.getDato()) < 0) {
            nodo.setIzquierdo(eliminarRec(nodo.getIzquierdo(), dato));
        } else if (dato.compareTo(nodo.getDato()) > 0) {
            nodo.setDerecho(eliminarRec(nodo.getDerecho(), dato));
        } else {
            //sin hijos
            if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
                return null;
            }
            //un hijo derecho
            if (nodo.getIzquierdo() == null) {
                return nodo.getDerecho();
            }
            //un hijo izquierdo
            if (nodo.getDerecho() == null) {
                return nodo.getIzquierdo();
            }
            //dos hijos
            T menor = obtenerMenor(nodo.getDerecho());
            nodo.setDato(menor);
            nodo.setDerecho(eliminarRec(nodo.getDerecho(), menor));
        }
        return nodo;
    }
    /**
     * obtiene el menor valor de un subarbol
     *
     * @param nodo raiz del subarbol
     * @return menor dato
     */
    private T obtenerMenor(NodoArbolBST<T> nodo) {
        while (nodo.getIzquierdo() != null) {
            nodo = nodo.getIzquierdo();
        }
        return nodo.getDato();
    }
    /**
     * recorrido inOrden
     */
    public void inOrden() {
        inOrdenRec(raiz);
    }
    /**
     * metodo recursivo inOrden
     *
     * @param nodo nodo actual
     */
    private void inOrdenRec(NodoArbolBST<T> nodo) {
        if (nodo != null) {
            inOrdenRec(nodo.getIzquierdo());
            System.out.println(nodo.getDato());
            inOrdenRec(nodo.getDerecho());
        }
    }
    /**
     * recorrido preOrden
     */
    public void preOrden() {
        preOrdenRec(raiz);
    }
    /**
     * metodo recursivo preOrden
     *
     * @param nodo nodo actual
     */
    private void preOrdenRec(NodoArbolBST<T> nodo) {
        if (nodo != null) {
            System.out.println(nodo.getDato());
            preOrdenRec(nodo.getIzquierdo());
            preOrdenRec(nodo.getDerecho());
        }
    }
    /**
     * recorrido postOrden
     */
    public void postOrden() {
        postOrdenRec(raiz);
    }
    /**
     * metodo recursivo postOrden
     *
     * @param nodo nodo actual
     */
    private void postOrdenRec(NodoArbolBST<T> nodo) {
        if (nodo != null) {
            postOrdenRec(nodo.getIzquierdo());
            postOrdenRec(nodo.getDerecho());
            System.out.println(nodo.getDato());
        }
    }
}