/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 * almacena la clave unica, nombre y capacidad maxima de estudiantes
 * las listas de inscritos, espera y rotacion de roles se agregan
 * una vez que las estructuras esten implementadas
 *
 * @author julian izaguirre
 */
public class Curso {
    private String clave;
    private String nombre;
    private int capacidadMaxima;
 
    /**
     * constructor que inicializa un curso con su clave, nombre y capacidad
     *
     * @param clave clave unica del curso
     * @param nombre nombre del curso
     * @param capacidadMaxima numero maximo de estudiantes permitidos
     */
    public Curso(String clave, String nombre, int capacidadMaxima) {
        this.clave = clave;
        this.nombre = nombre;
        this.capacidadMaxima = capacidadMaxima;
    }
 
    /**
     * regresa la clave unica del curso
     *
     * @return clave del curso
     */
    public String getClave() {
        return clave;
    }
 
    /**
     * asigna una nueva clave al curso
     *
     * @param clave nueva clave del curso
     */
    public void setClave(String clave) {
        this.clave = clave;
    }
 
    /**
     * regresa el nombre del curso
     *
     * @return nombre del curso
     */
    public String getNombre() {
        return nombre;
    }
 
    /**
     * asigna un nuevo nombre al curso
     *
     * @param nombre nuevo nombre del curso
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
    /**
     * regresa la capacidad maxima de estudiantes del curso
     *
     * @return capacidad maxima del curso
     */
    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }
 
    /**
     * asigna una nueva capacidad maxima al curso
     *
     * @param capacidadMaxima nuevo numero maximo de estudiantes
     */
    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }
 
    /**
     * regresa una representacion en texto del curso con su clave, nombre y capacidad
     *
     * @return cadena con la informacion del curso
     */
    @Override
    public String toString() {
        return "Curso("
                + "clave: " + clave
                + ", nombre: " + nombre
                + ", capacidadMaxima: " + capacidadMaxima + ")";
    }
}
