/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.Objects;

/**
 *
 * @author julian izaguirre
 */
public class Estudiante implements Comparable<Estudiante> {
    private String matricula;
    private String nombreCompleto;
    private String telefono;
    private String correo;
    private String direccion;
    private double[] calificaciones;
    private String rol;
    // el rol es de tutor o lider 
    private int totalCalificaciones;
    // para reservar algunos espacios por adelantado
    private static final int CAPACIDAD_INICIAL = 10;
 
    /**
     * constructor para buscar un estudiante solo por matricula
     * se usa al buscar en el BST sin necesidad de todos los datos
     *
     * @param matricula matricula del estudiante a buscar
     */
    public Estudiante(String matricula) {
        this.matricula = matricula;
        this.calificaciones = new double[CAPACIDAD_INICIAL];
        this.totalCalificaciones = 0;
    }
 
    /**
     * constructor completo para registrar un nuevo estudiante sin calificaciones
     * el arreglo de calificaciones se inicializa vacio
     *
     * @param matricula matricula alfanumerica del estudiante
     * @param nombreCompleto nombre completo del estudiante
     * @param telefono numero de telefono del estudiante
     * @param correo correo electronico del estudiante
     * @param direccion  direccion postal del estudiante
     */
    public Estudiante(String matricula, String nombreCompleto, String telefono,
            String correo, String direccion) {
        this.matricula = matricula;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.calificaciones = new double[CAPACIDAD_INICIAL];
        this.totalCalificaciones = 0;
        this.rol = "ESTUDIANTE";
    }
 
    /**
     * agrega una nueva calificacion al arreglo del estudiante
     * si el arreglo esta lleno se duplica su capacidad automaticamente
     *
     * @param calificacion valor numerico de la calificacion a agregar
     */
    public void agregarCalificacion(double calificacion) {
        if (totalCalificaciones == calificaciones.length) {
            duplicarCapacidad();
        }
        calificaciones[totalCalificaciones] = calificacion;
        totalCalificaciones++;
    }
 
    /**
     * modifica una calificacion existente en el arreglo por su indice
     *
     * @param indice       posicion de la calificacion a modificar (desde 0)
     * @param calificacion nuevo valor de la calificacion
     * @throws IndexOutOfBoundsException si el indice esta fuera del rango valido
     */
    public void modificarCalificacion(int indice, double calificacion) {
        if (indice < 0 || indice >= totalCalificaciones) {
            throw new IndexOutOfBoundsException("indice fuera de rango: " + indice);
        }
        calificaciones[indice] = calificacion;
    }
 
    /**
     * elimina la ultima calificacion registrada del arreglo
     * se usa al deshacer una accion de agregar calificacion
     *
     * @throws IllegalStateException si no hay calificaciones registradas
     */
    public void eliminarUltimaCalificacion() {
        if (totalCalificaciones == 0) {
            throw new IllegalStateException("no hay calificaciones registradas");
        }
        totalCalificaciones--;
    }
 
    /**
     * regresa la calificacion almacenada en una posicion especifica
     *
     * @param indice posicion de la calificacion a consultar (desde 0)
     * @return valor de la calificacion en el indice dado
     * @throws IndexOutOfBoundsException si el indice esta fuera del rango valido
     */
    public double getCalificacion(int indice) {
        if (indice < 0 || indice >= totalCalificaciones) {
            throw new IndexOutOfBoundsException("indice fuera de rango: " + indice);
        }
        return calificaciones[indice];
    }
 
    /**
     * regresa la cantidad de calificaciones registradas actualmente
     *
     * @return numero total de calificaciones del estudiante
     */
    public int getTotalCalificaciones() {
        return totalCalificaciones;
    }
 
    /**
     * metodo auxiliar recursivo que suma las calificaciones desde un indice dado
     * sirve como base para el calculo recursivo del promedio
     *
     * @param indice posicion actual del recorrido recursivo
     * @return suma acumulada desde el indice hasta el final del arreglo
     */
    private double sumarCalificacionesRec(int indice) {
        if (indice >= totalCalificaciones) {
            return 0.0;
        }
        return calificaciones[indice] + sumarCalificacionesRec(indice + 1);
    }
 
    /**
     * calcula el promedio de calificaciones del estudiante de forma recursiva
     * regresa 0.0 si el estudiante no tiene calificaciones registradas
     *
     * @return promedio de calificaciones o 0.0 si no hay ninguna
     */
    public double calcularPromedio() {
        if (totalCalificaciones == 0) {
            return 0.0;
        }
        return sumarCalificacionesRec(0) / totalCalificaciones;
    }
 
    /**
     * duplica la capacidad interna del arreglo de calificaciones
     * se invoca automaticamente cuando el arreglo esta lleno
     */
    private void duplicarCapacidad() {
        double[] nuevo = new double[calificaciones.length * 2];
        for (int i = 0; i < calificaciones.length; i++) {
            nuevo[i] = calificaciones[i];
        }
        calificaciones = nuevo;
    }
 
    /**
     * regresa la matricula del estudiante
     *
     * @return matricula alfanumerica del estudiante
     */
    public String getMatricula() {
        return matricula;
    }
 
    /**
     * asigna una nueva matricula al estudiante
     *
     * @param matricula nueva matricula del estudiante
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
 
    /**
     * regresa el nombre completo del estudiante
     *
     * @return nombre completo del estudiante
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }
 
    /**
     * asigna el nombre completo del estudiante
     *
     * @param nombreCompleto nuevo nombre completo
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
 
    /**
     * regresa el telefono del estudiante
     *
     * @return numero de telefono del estudiante
     */
    public String getTelefono() {
        return telefono;
    }
 
    /**
     * asigna el telefono del estudiante
     *
     * @param telefono nuevo numero de telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
 
    /**
     * regresa el correo electronico del estudiante
     *
     * @return correo electronico del estudiante
     */
    public String getCorreo() {
        return correo;
    }
 
    /**
     * asigna el correo electronico del estudiante
     *
     * @param correo nuevo correo electronico
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }
 
    /**
     * regresa la direccion postal del estudiante
     *
     * @return direccion postal del estudiante
     */
    public String getDireccion() {
        return direccion;
    }
 
    /**
     * asigna la direccion postal del estudiante
     *
     * @param direccion nueva direccion postal
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
 
    /**
     * regresa el rol actual del estudiante dentro del curso
     *
     * @return rol del estudiante (estudiante o lider de proyecto)
     */
    public String getRol() {
        return rol;
    }
 
    /**
     * asigna el rol del estudiante dentro del curso
     *
     * @param rol nuevo rol del estudiante
     */
    public void setRol(String rol) {
        this.rol = rol;
    }
 
    /**
     * compara este estudiante con otro por matricula
     * se usa para ordenar correctamente en el arbol BST
     *
     * @param otro el otro estudiante con quien comparar
     * @return valor negativo si esta antes, cero si es igual, positivo si va despues
     */
    @Override
    public int compareTo(Estudiante otro) {
        return this.matricula.compareTo(otro.getMatricula());
    }
 
    /**
     * compara si dos estudiantes son el mismo basandose unicamente en la matricula
     *
     * @param o objeto a comparar
     * @return true si la matricula es igual, false en caso contrario
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Estudiante)) {
            return false;
        }
        Estudiante otro = (Estudiante) o;
        return Objects.equals(this.matricula, otro.matricula);
    }
 
    /**
     * genera el hashcode del estudiante basado en la matricula
     *
     * @return hashcode calculado a partir de la matricula
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(this.matricula);
    }
 
    /**
     * regresa una representacion en texto del estudiante con todos sus datos
     *
     * @return cadena con la informacion del estudiante
     */
    @Override
    public String toString() {
        return "Estudiante("
                + "matricula: " + matricula
                + ", nombre: " + nombreCompleto
                + ", telefono: " + telefono
                + ", correo: " + correo
                + ", direccion: " + direccion
                + ", promedio: " + calcularPromedio()
                + ", rol: " + rol + ")";
    }
}
