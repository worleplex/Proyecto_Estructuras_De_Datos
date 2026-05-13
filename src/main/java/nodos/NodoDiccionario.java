/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nodos;

/**
 * nodo generico para el diccionario implementado con tabla hash
 * cada nodo almacena una llave unica y su valor asociado
 * los nodos del mismo balde se encadenan con referencia siguiente
 * para resolver colisiones mediante encadenamiento separado
 *
 * @param <K> tipo de la llave que identifica al elemento
 * @param <V> tipo del valor asociado a la llave
 * @author julian izaguirre
 */
public class NodoDiccionario<K, V> {
    private final K llave;
    private V valor;
    private NodoDiccionario<K, V> siguiente;
 
    /**
     * constructor que inicializa el nodo con llave y valor
     * la llave es final porque no debe cambiar una vez asignada
     * la referencia al siguiente nodo queda en null
     *
     * @param llave identificador unico del elemento
     * @param valor dato asociado a la llave
     */
    public NodoDiccionario(K llave, V valor) {
        this.llave = llave;
        this.valor = valor;
        this.siguiente = null;
    }
 
    /**
     * regresa la llave almacenada en el nodo
     *
     * @return llave de tipo K del nodo
     */
    public K getLlave() {
        return llave;
    }
 
    /**
     * regresa el valor almacenado en el nodo
     *
     * @return valor de tipo V asociado a la llave
     */
    public V getValor() {
        return valor;
    }
 
    /**
     * asigna un nuevo valor al nodo
     * la llave no se puede cambiar porque es final
     *
     * @param valor nuevo valor de tipo V a almacenar
     */
    public void setValor(V valor) {
        this.valor = valor;
    }
 
    /**
     * regresa la referencia al siguiente nodo en el balde
     *
     * @return nodo siguiente en la cadena de colision o null si no hay
     */
    public NodoDiccionario<K, V> getSiguiente() {
        return siguiente;
    }
 
    /**
     * asigna la referencia al siguiente nodo en el balde
     *
     * @param siguiente nodo que va despues en la cadena de colision
     */
    public void setSiguiente(NodoDiccionario<K, V> siguiente) {
        this.siguiente = siguiente;
    }
 
    /**
     * regresa una representacion en texto del nodo con formato llave valor
     *
     * @return cadena con la llave y el valor separados por dos puntos
     */
    @Override
    public String toString() {
        return llave + ": " + valor;
    }
}