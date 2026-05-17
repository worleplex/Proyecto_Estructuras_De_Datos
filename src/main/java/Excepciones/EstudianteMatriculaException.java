/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

/**
 * Excepción para matrícula duplicada o formato inválido al registrar un estudiante.
 *
 * @author julian izaguirre
 */
public class EstudianteMatriculaException extends RuntimeException {

    public EstudianteMatriculaException() {
        super();
    }

    public EstudianteMatriculaException(String mensaje) {
        super(mensaje);
    }
}
