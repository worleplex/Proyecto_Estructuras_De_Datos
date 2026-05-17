/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

/**
 * Excepción para operaciones invalidas en árboles BST y AVL.
 * Se lanza cuando se busca un elemento inexistente, se intenta
 * eliminar de un árbol vacío, etc.
 *
 * @author julian izaguirre
 */
public class TreeException extends RuntimeException {

    public TreeException() {
        super();
    }

    public TreeException(String mensaje) {
        super(mensaje);
    }
}
