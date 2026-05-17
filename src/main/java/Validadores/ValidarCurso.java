/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validadores;

import Excepciones.DatosInvalidosCursoException;

/**
 * Clase utilitaria que valida los datos de un curso antes de registrarlo.
 * Todos los métodos son estáticos; no se necesita instanciar la clase.
 *
 * @author julian izaguirre
 */
public class ValidarCurso {

    /**
     * Valida todos los campos del curso de una sola vez.
     *
     * @param clave clave única del curso
     * @param nombre nombre descriptivo del curso
     * @param capacidadMaxima capacidad máxima de estudiantes
     * @throws DatosInvalidosCursoException si algún campo es inválido
     */
    public static void validar(String clave, String nombre, int capacidadMaxima) {
        validarClave(clave);
        validarNombre(nombre);
        validarCapacidad(capacidadMaxima);
    }

    /**
     * Valida que la clave no esté vacía y sea alfanumérica.
     *
     * @param clave clave a validar
     * @throws DatosInvalidosCursoException si la clave es inválida
     */
    public static void validarClave(String clave) {
        if (clave == null || clave.trim().isEmpty()) {
            throw new DatosInvalidosCursoException("La clave del curso no puede estar vacía");
        }
        if (!clave.trim().matches("[a-zA-Z0-9\\-]+")) {
            throw new DatosInvalidosCursoException(
                    "La clave del curso solo puede contener letras, números y guiones");
        }
    }

    /**
     * Valida que el nombre del curso no esté vacío.
     *
     * @param nombre nombre a validar
     * @throws DatosInvalidosCursoException si el nombre es inválido
     */
    public static void validarNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new DatosInvalidosCursoException("El nombre del curso no puede estar vacío");
        }
        if (nombre.trim().length() < 3) {
            throw new DatosInvalidosCursoException(
                    "El nombre del curso debe tener al menos 3 caracteres");
        }
    }

    /**
     * Valida que la capacidad sea un número positivo mayor que cero.
     *
     * @param capacidad capacidad a validar
     * @throws DatosInvalidosCursoException si la capacidad es menor o igual a cero
     */
    public static void validarCapacidad(int capacidad) {
        if (capacidad <= 0) {
            throw new DatosInvalidosCursoException(
                    "La capacidad máxima debe ser mayor que cero");
        }
        if (capacidad > 30) {
            throw new DatosInvalidosCursoException(
                    "La capacidad máxima no puede superar 500 estudiantes");
        }
    }
}
