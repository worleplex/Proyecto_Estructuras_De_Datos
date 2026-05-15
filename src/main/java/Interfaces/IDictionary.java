/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

/**
 * Interfaz que define el comportamiento de un Diccionario (o Mapa)
 *
 * @param <K> Tipo de dato que representará la Clave
 * @param <V> Tipo de dato que representará el Valor asociado
 *
 * @author chris
 */
public interface IDictionary<K, V> {

    /**
     * Inserta un nuevo par clave-valor en el diccionario. Si la clave ya existe
     * en la estructura, su valor anterior se reemplazará por el nuevo.
     *
     * @param clave Identificador único para el dato
     * @param valor El dato u objeto que se desea almacenar asociado a la clave
     */
    void put(K clave, V valor);

    /**
     * Recupera el valor asociado a una clave específica sin eliminarlo del
     * diccionario.
     *
     * @param clave La clave del elemento que se desea buscar
     * @return El valor (objeto) asociado a la clave proporcionada
     * @throws Exception Si la clave no se encuentra dentro del diccionario
     */
    V get(K clave) throws Exception;

    /**
     * Extrae y elimina permanentemente un par clave-valor del diccionario.
     *
     * @param clave La clave del elemento que se desea remover
     * @throws Exception Si se intenta eliminar una clave que no existe en el
     * diccionario
     */
    void remove(K clave) throws Exception;

    /**
     * Determina si una clave específica ya se encuentra registrada en el
     * diccionario.
     *
     * @param clave La clave que se desea verificar
     * @return true si la clave existe en el diccionario, false en caso
     * contrario
     */
    boolean contains(K clave);

    /**
     * Regresa el número total de pares clave-valor almacenados en el
     * diccionario.
     *
     * @return El número de elementos (tamaño) del diccionario
     */
    int size();

    /**
     * Elimina absolutamente todos los elementos almacenados, dejando el
     * diccionario vacío.
     */
    void clear();

}
