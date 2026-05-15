/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 * se usa como tipo generico en la cola de solicitudes el FIFO del urbina
 * y tambien para registrar datos necesarios al revertir acciones en la pila
 *
 * @author julian izaguirre
 */
public class SolicitudCalificacion {
    private String matricula;
    private double nuevaCalificacion;
    private int indiceModificar;
 
    /**
     * constructor para agregar una nueva calificacion al arreglo del estudiante
     * el indice se establece en -1 para indicar que es una adicion
     *
     * @param matricula matricula del estudiante
     * @param nuevaCalificacion calificacion nueva a agregar
     */
    public SolicitudCalificacion(String matricula, double nuevaCalificacion) {
        this.matricula = matricula;
        this.nuevaCalificacion = nuevaCalificacion;
        this.indiceModificar = -1;
    }
 
    /**
     * constructor para modificar una calificacion existente por su indice
     *
     * @param matricula matricula del estudiante
     * @param nuevaCalificacion nuevo valor de la calificacion
     * @param indiceModificar posicion del arreglo a modificar
     */
    public SolicitudCalificacion(String matricula, double nuevaCalificacion, int indiceModificar) {
        this.matricula = matricula;
        this.nuevaCalificacion = nuevaCalificacion;
        this.indiceModificar = indiceModificar;
    }
 
    /**
     * regresa la matricula del estudiante de la solicitud
     *
     * @return matricula del estudiante
     */
    public String getMatricula() {
        return matricula;
    }
 
    /**
     * asigna la matricula del estudiante de la solicitud
     *
     * @param matricula nueva matricula del estudiante
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
 
    /**
     * regresa el valor de la calificacion de la solicitud
     *
     * @return valor de la nueva calificacion
     */
    public double getNuevaCalificacion() {
        return nuevaCalificacion;
    }
 
    /**
     * asigna el valor de la calificacion de la solicitud
     *
     * @param nuevaCalificacion nuevo valor de la calificacion
     */
    public void setNuevaCalificacion(double nuevaCalificacion) {
        this.nuevaCalificacion = nuevaCalificacion;
    }
 
    /**
     * regresa el indice a modificar
     * un valor de -1 indica que la solicitud es una adicion, no una modificacion
     *
     * @return indice de la calificacion a modificar o -1 si es adicion
     */
    public int getIndiceModificar() {
        return indiceModificar;
    }
 
    /**
     * asigna el indice de la calificacion a modificar
     *
     * @param indiceModificar posicion a modificar o -1 para indicar adicion
     */
    public void setIndiceModificar(int indiceModificar) {
        this.indiceModificar = indiceModificar;
    }
 
    /**
     * indica si esta solicitud es una adicion o una modificacion
     *
     * @return true si es adicion (indice -1), false si es modificacion
     */
    public boolean esAdicion() {
        return indiceModificar == -1;
    }
 
    /**
     * regresa una representacion en texto de la solicitud
     *
     * @return cadena con los datos de la solicitud
     */
    @Override
    public String toString() {
        String tipo = esAdicion() ? "adicion" : "modificacion en indice " + indiceModificar;
        return "SolicitudCalificacion("
                + "matricula: " + matricula
                + ", calificacion: " + nuevaCalificacion
                + ", tipo: " + tipo + ")";
    }
}
