/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 * clase auxiliar que encapsula el promedio calculado de un estudiante
 * junto con la referencia al objeto estudiante original
 * se usa como tipo de dato en el arbol AVL para ordenar por promedio
 * si dos estudiantes tienen el mismo promedio se desempata por matricula
 *
 * @author julian izaguirre
 */
public class PromedioEstudiante implements Comparable<PromedioEstudiante> {
    private double promedio;
    private Estudiante estudiante;
 
    /**
     * constructor que inicializa el objeto con el promedio y el estudiante
     *
     * @param promedio promedio de calificaciones del estudiante
     * @param estudiante referencia al objeto estudiante correspondiente
     */
    public PromedioEstudiante(double promedio, Estudiante estudiante) {
        this.promedio = promedio;
        this.estudiante = estudiante;
    }
 
    /**
     * regresa el promedio del estudiante
     *
     * @return promedio de calificaciones del estudiante
     */
    public double getPromedio() {
        return promedio;
    }
 
    /**
     * asigna el promedio del estudiante
     *
     * @param promedio nuevo valor del promedio
     */
    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }
 
    /**
     * regresa la referencia al objeto estudiante
     *
     * @return estudiante asociado a este promedio
     */
    public Estudiante getEstudiante() {
        return estudiante;
    }
 
    /**
     * asigna la referencia al objeto estudiante
     *
     * @param estudiante nuevo estudiante asociado
     */
    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
 
    /**
     * compara este objeto con otro promedioestudiante
     * primero compara por promedio tipo si jorge urbina es main lucario entonces ya no funciona
     * si los promedios son iguales desempata por matricula 
     *
     * @param otro objeto promedioestudiante con quien comparar
     * @return negativo si es menor, cero si son iguales, positivo si es mayor
     */
    @Override
    public int compareTo(PromedioEstudiante otro) {
        int cmpPromedio = Double.compare(this.promedio, otro.getPromedio());
        if (cmpPromedio != 0) {
            return cmpPromedio;
        }
        return this.estudiante.getMatricula().compareTo(otro.getEstudiante().getMatricula());
    }
 
    /**
     * regresa una representacion en texto con el promedio y la matricula del estudiante
     *
     * @return cadena con el promedio y matricula del estudiante
     */
    @Override
    public String toString() {
        return "PromedioEstudiante("
                + "promedio: " + promedio
                + ", matricula: " + estudiante.getMatricula() + ")";
    }
}
