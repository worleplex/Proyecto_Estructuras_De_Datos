/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

/**
 * Excepción para datos incompletos o con formato incorrecto al registrar un estudiante.
 * campo vacío, correo sin @, teléfono con letras, y asip
 *
 * @author julian izaguirre
 */
public class DatosInvalidosEstudianteException extends RuntimeException {

    public DatosInvalidosEstudianteException() {
        super();
    }

    public DatosInvalidosEstudianteException(String mensaje) {
        super(mensaje);
    }
}
