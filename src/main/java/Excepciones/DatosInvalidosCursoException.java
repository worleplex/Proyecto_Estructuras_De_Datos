/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

/**
 * Excepción para datos inválidos al registrar o modificar un curso.
 * clave vacía, capacidad negativa o cero, nombre vacío
 *
 * @author julian izaguirre
 */
public class DatosInvalidosCursoException extends RuntimeException {

    public DatosInvalidosCursoException() {
        super();
    }

    public DatosInvalidosCursoException(String mensaje) {
        super(mensaje);
    }
}
