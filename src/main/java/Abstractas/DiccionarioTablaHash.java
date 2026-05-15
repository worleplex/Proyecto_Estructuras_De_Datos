/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Abstractas;

import Estructuras.ListaEnlazada;
import Interfaces.IDictionary;
import Nodos.NodoDiccionario;

/**
 * Implementación de un Diccionario usando una Tabla Hash con resolución de
 * colisiones mediante encadenamiento
 *
 * @author chris
 */
public class DiccionarioTablaHash<K, V> implements IDictionary<K, V> {

    private NodoDiccionario<K, V>[] tabla;
    private int capacidad;
    private int size;

    /**
     * Inicializamos la tabal con un tamaño fijo
     *
     * @param capacidad
     */
    @SuppressWarnings("unchecked")
    public DiccionarioTablaHash(int capacidad) {
        this.capacidad = capacidad;

        // Cast
        this.tabla = (NodoDiccionario<K, V>[]) new NodoDiccionario[capacidad];
        this.size = 0;
    }

    /**
     * Convierte la clave en un índice válido dentro del arreglo
     *
     * @param clave
     * @return
     */
    private int calcularIndice(K clave) {
        // hashCode() nos da un número entero y Math.abs quita los negativos y el % asegura que el número sea menor que la capacidad
        return Math.abs(clave.hashCode()) % capacidad;
    }

    @Override
    public void put(K clave, V valor) {
        if (clave == null) {
            return;
        }

        int indice = calcularIndice(clave);
        NodoDiccionario<K, V> actual = tabla[indice];

        // Verificamos si la clave ya existe para actualizarla
        while (actual != null) {
            // CORREGIDO: Se cambió getClave() por getLlave()
            if (actual.getLlave().equals(clave)) {
                actual.setValor(valor); // Actualiza el valor si la clave ya existía
                return;
            }
            actual = actual.getSiguiente();
        }

        // Si no existe, creamos un nuevo nodo y lo insertamos al inicio del balde
        NodoDiccionario<K, V> nuevoNodo = new NodoDiccionario<>(clave, valor);
        nuevoNodo.setSiguiente(tabla[indice]);
        tabla[indice] = nuevoNodo;
        size++;
    }

    @Override
    public V get(K clave) throws Exception {
        int indice = calcularIndice(clave);
        NodoDiccionario<K, V> actual = tabla[indice];

        // Recorremos la lista enlazada dentro del balde buscando la clave
        while (actual != null) {
            // CORREGIDO: Se cambió getClave() por getLlave()
            if (actual.getLlave().equals(clave)) {
                return actual.getValor(); // Lo encontramos
            }
            actual = actual.getSiguiente();
        }

        throw new Exception("La clave no existe en el diccionario");
    }

    @Override
    public void remove(K clave) throws Exception {
        int indice = calcularIndice(clave);
        NodoDiccionario<K, V> actual = tabla[indice];
        NodoDiccionario<K, V> anterior = null;

        while (actual != null) {
            // CORREGIDO: Se cambió getClave() por getLlave()
            if (actual.getLlave().equals(clave)) {
                
                // Si es el primero de la lista
                if (anterior == null) {
                    tabla[indice] = actual.getSiguiente();
                } else { // CORREGIDO: ¡Faltaba abrir esta llave!
                    
                    // Si está en medio o al final
                    anterior.setSiguiente(actual.getSiguiente());
                }
                size--;
                return;
            }
            anterior = actual;
            actual = actual.getSiguiente();
        }
        
        // CORREGIDO: Quedó fuera del ciclo while correctamente
        throw new Exception("No se puede eliminar: La clave no existe");
    }

    @Override
    public boolean contains(K clave) {
        int indice = calcularIndice(clave);
        NodoDiccionario<K, V> actual = tabla[indice];

        while (actual != null) {
            // CORREGIDO: Se cambió getClave() por getLlave()
            if (actual.getLlave().equals(clave)) {
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * Limpiamos la tabla creando un arreglo nuevo
     */
    @Override
    public void clear() {
        this.tabla = (NodoDiccionario<K, V>[]) new NodoDiccionario[capacidad];
        this.size = 0;
    }

    /**
     * Obtener todos los valores
     *
     * @return
     */
    public ListaEnlazada<V> obtenerTodosLosValores() {
        ListaEnlazada<V> lista = new ListaEnlazada<>();
        for (int i = 0; i < capacidad; i++) {
            NodoDiccionario<K, V> actual = tabla[i];
            while (actual != null) {
                lista.append(actual.getValor());
                actual = actual.getSiguiente();
            }
        }
        return lista;
    }

}