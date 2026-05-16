/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author Jorge
 */
public class PersistenciaException extends Exception{
    /**
     * Constructor por omision
     */
    public PersistenciaException() {
        super();
    }

    /**
     * Constructor que recibe un mensaje
     *
     * @param mensaje descripcion del problema
     */
    public PersistenciaException(String mensaje) {
        super(mensaje);
    }

    /**
     * Constructor con mensaje y causa del error
     *
     * @param mensaje descripcion del problema
     * @param causa excepcion original
     */
    public PersistenciaException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
