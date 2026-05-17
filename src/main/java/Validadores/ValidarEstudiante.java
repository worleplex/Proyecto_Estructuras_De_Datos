/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validadores;

import Excepciones.DatosInvalidosEstudianteException;
import Excepciones.EstudianteMatriculaException;

/**
 * Clase utilitaria que valida los datos de un estudiante antes de registrarlo.
 * Todos los métodos son estáticos; no se necesita instanciar la clase.
 *
 * @author julian izaguirre
 */
public class ValidarEstudiante {

    /**
     * Valida todos los campos del estudiante de una sola vez.
     * Lanza excepción al primer campo inválido que encuentre.
     *
     * @param matricula matrícula del estudiante
     * @param nombreCompleto nombre completo
     * @param telefono número de teléfono
     * @param correo correo electrónico
     * @param direccion dirección postal
     * @throws EstudianteMatriculaException si la matrícula está vacía o tiene formato incorrecto
     * @throws DatosInvalidosEstudianteException si cualquier otro campo es inválido
     */
    public static void validar(String matricula, String nombreCompleto,
            String telefono, String correo, String direccion) {

        validarMatricula(matricula);
        validarNombre(nombreCompleto);
        validarTelefono(telefono);
        validarCorreo(correo);
        validarDireccion(direccion);
    }

    /**
     * Valida que la matrícula no esté vacía y sea alfanumérica.
     *
     * @param matricula matrícula a validar
     * @throws EstudianteMatriculaException si la matrícula es inválida
     */
    public static void validarMatricula(String matricula) {
        if (matricula == null || matricula.trim().isEmpty()) {
            throw new EstudianteMatriculaException("La matrícula no puede estar vacía");
        }
        if (!matricula.trim().matches("[a-zA-Z0-9]+")) {
            throw new EstudianteMatriculaException(
                    "La matrícula solo puede contener letras y números, sin espacios ni caracteres especiales");
        }
    }

    /**
     * Valida que el nombre no esté vacío y solo contenga letras y espacios.
     *
     * @param nombre nombre completo a validar
     * @throws DatosInvalidosEstudianteException si el nombre es inválido
     */
    public static void validarNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new DatosInvalidosEstudianteException("El nombre completo no puede estar vacío");
        }
        if (!nombre.trim().matches("[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ ]+")) {
            throw new DatosInvalidosEstudianteException(
                    "El nombre solo puede contener letras y espacios");
        }
    }

    /**
     * Valida que el teléfono tenga entre 7 y 15 dígitos.
     *
     * @param telefono teléfono a validar
     * @throws DatosInvalidosEstudianteException si el teléfono es inválido
     */
    public static void validarTelefono(String telefono) {
        if (telefono == null || telefono.trim().isEmpty()) {
            throw new DatosInvalidosEstudianteException("El teléfono no puede estar vacío");
        }
        if (!telefono.trim().matches("\\d{7,15}")) {
            throw new DatosInvalidosEstudianteException(
                    "El teléfono debe contener entre 7 y 15 dígitos numéricos");
        }
    }

    /**
     * Valida que el correo tenga formato básico usuario@dominio.ext
     *
     * @param correo correo electrónico a validar
     * @throws DatosInvalidosEstudianteException si el correo es inválido
     */
    public static void validarCorreo(String correo) {
        if (correo == null || correo.trim().isEmpty()) {
            throw new DatosInvalidosEstudianteException("El correo no puede estar vacío");
        }
        if (!correo.trim().matches("[^@\\s]+@[^@\\s]+\\.[^@\\s]+")) {
            throw new DatosInvalidosEstudianteException(
                    "El correo debe tener el formato usuario@dominio.ext");
        }
    }

    /**
     * Valida que la dirección no esté vacía.
     *
     * @param direccion dirección postal a validar
     * @throws DatosInvalidosEstudianteException si la dirección es inválida
     */
    public static void validarDireccion(String direccion) {
        if (direccion == null || direccion.trim().isEmpty()) {
            throw new DatosInvalidosEstudianteException("La dirección no puede estar vacía");
        }
        if (direccion.trim().length() < 5) {
            throw new DatosInvalidosEstudianteException(
                    "La dirección debe tener al menos 5 caracteres");
        }
    }
}
