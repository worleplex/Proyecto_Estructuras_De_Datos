/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arboles;

import Nodos.NodoArbolAVL;

/**
 *
 * @author Jorge
 */
public class ArbolAVL<T extends Comparable<T>> {
    private NodoArbolAVL<T> raiz;

    public ArbolAVL() {
        this.raiz = null;
    }
    
    /**
     * inserta un nuevo nodo
     * @param dato dato a ingresar
     */
    public void insertar(T dato) {
        raiz = insertarRec(raiz, dato);
    }
    
    /**
     * Metodo recursivo para insertar un nodo
     * @param nodo nodo raiz del arbol
     * @param dato dato del nodo a insertar
     * @return nodo raiz del arbol
     */
    private NodoArbolAVL<T> insertarRec(NodoArbolAVL<T> nodo, T dato) {
        //Cuando encuentra un null, regresa el nuevo nodo
        if (nodo == null) {
            return new NodoArbolAVL(dato);
        }

        //Insercion a la izquierda
        if (dato.compareTo(nodo.getDato()) < 0) {
            nodo.setIzquierdo(insertarRec(nodo.getIzquierdo(), dato));
        } else if (dato.compareTo(nodo.getDato()) > 0) {
            nodo.setDerecho(insertarRec(nodo.getDerecho(), dato));
        } else {
            //no permiten valores duplicados, asi que no se inserta
            return nodo;
        }

        //Se actualiza la altura del nodo
        actualizarAltura(nodo);

        //Se obtiene su balance y se aplica rotacion si es necesario
        int balance = calcularBalance(nodo);

        if (balance > 1 && dato.compareTo(nodo.getIzquierdo().getDato()) < 0) {
            return rotacionDerecha(nodo);
        } else if (balance < -1 && dato.compareTo(nodo.getDerecho().getDato()) > 0) {
            return rotacionIzquierda(nodo);
        } else if (balance > 1 && dato.compareTo(nodo.getIzquierdo().getDato()) > 0) {
            return rotacionIzquierdaDerecha(nodo);
        } else if (balance < -1 && dato.compareTo(nodo.getDerecho().getDato()) < 0) {
            return rotacionDerechaIzquierda(nodo);
        }
        return nodo;
    }

    /**
     * muestra los nodos del arbol inOrden
     */
    public void inOrden() {
        inOrdenRec(raiz);
        System.out.println();
    }
    
    /**
     * Metodo recursivo que imprime el arbol en orden
     * @param nodo Nodo raiz del arbol que se imprimira
     */
    private void inOrdenRec(NodoArbolAVL<T> nodo) {
        if (nodo != null) {
            inOrdenRec(nodo.getIzquierdo());
            System.out.print(nodo.getDato() + " ");
            inOrdenRec(nodo.getDerecho());
        }
    }

    /**
     * Devuelve la altura almacenada en el nodo, si el nodo es null, se considera que su altura es 0
     * @param nodo nodo del que se obtiene la altura
     * @return Altura del nodo
     */
    private int altura(NodoArbolAVL<T> nodo) {
        return (nodo == null) ? 0 : nodo.getAltura();
    }

    /**
     * actualiza la altura de un nodo
     * @param nodo nodo al que se le quiere actualizar la altura
     */
    private void actualizarAltura(NodoArbolAVL<T> nodo) {
        nodo.setAltura(Math.max(altura(nodo.getIzquierdo()), altura(nodo.getDerecho())) + 1);
    }
    
    /**
     * Calcula el factor de balance de un nodo
     * @param nodo nodo al que se le calcula el factor de balance
     * @return Factor de balance
     */
    private int calcularBalance(NodoArbolAVL<T> nodo) {
        return (nodo == null) ? 0 : altura(nodo.getIzquierdo()) - altura(nodo.getDerecho());
    }

    /**
     * Metodo que hace una rotacion a la derecha simple para cuando el desvalance esta a la izquierda
     * @param nodo Nodo a equilibrar
     * @return nodo que quedaria en su posicion 
     */
    private NodoArbolAVL<T> rotacionDerecha(NodoArbolAVL<T> nodo) {
        //Sera la nueva raiz
        NodoArbolAVL<T> nodoT = nodo.getIzquierdo();

        //Obtenemos el hijo derecho del nodoT
        NodoArbolAVL<T> T2 = nodoT.getDerecho();

        //Iniciamos la rotacion
        //1. El nodoT ahora es la raiz
        nodoT.setDerecho(nodo);
        //2. El hijo izquierdo del nodo, ahora apunta a nodoT
        nodo.setIzquierdo(T2);

        //Una vez hecho hecho la rotacion, se actualizan las alturas
        actualizarAltura(nodo);
        actualizarAltura(nodoT);

        //regresamos la nueva raiz
        return nodoT;
    }

    /**
     * Metodo que hace una rotacion a la izquierda simple para cuando el desvalance esta a la derecha
     * @param nodo Nodo a equilibrar
     * @return nodo que quedaria en su posicion
     */
    private NodoArbolAVL<T> rotacionIzquierda(NodoArbolAVL<T> nodo) {
        //Sera la nueva raiz
        NodoArbolAVL<T> nodoT = nodo.getDerecho();

        //Obtenemos el hijo izquierdo del nodoT
        NodoArbolAVL<T> T2 = nodoT.getIzquierdo();

        //Iniciamos la rotacion
        //1. El nodoT ahora es la raiz
        nodoT.setIzquierdo(nodo);
        //2.El hijo derecho de nodo ahora apunta al nodoT
        nodo.setDerecho(T2);

        //Una vez hecha la rotacion, se actualizan las alturas
        actualizarAltura(nodo);
        actualizarAltura(nodoT);

        //regresamos la nueva raiz
        return nodoT;
    }

    /**
     * Metodo que hace una rotacion doble - izquierda -> derecha
     * @param nodo Nodo por equilibrar
     * @return nodo equilibrado
     */
    private NodoArbolAVL<T> rotacionIzquierdaDerecha(NodoArbolAVL<T> nodo) {

        nodo.setIzquierdo(rotacionIzquierda(nodo.getIzquierdo()));
        NodoArbolAVL<T> nuevaRaiz = rotacionDerecha(nodo);

        return nuevaRaiz;
    }

    /**
     * Metodo que hace una rotacion doble - derecha -> izquierda
     * @param nodo Nodo por equilibrar.
     * @return nodo equilibrado.
     */
    private NodoArbolAVL<T> rotacionDerechaIzquierda(NodoArbolAVL<T> nodo) {

        nodo.setDerecho(rotacionDerecha(nodo.getDerecho()));
        NodoArbolAVL<T> nuevaRaiz = rotacionIzquierda(nodo);

        return nuevaRaiz;
    }

    /**
     * Vacia el arbol
     */
    public void clear() {
        raiz = null;
    }
}
