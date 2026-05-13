/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author julian izaguirre
 */
public class Inscripciones {
    private String nombreCurso;
    private String nombreEstudiante;
    private String claveCurso;
    
    /**
     * constructor que inicializa la inscripcion con la clave del curso,
     * el nombre del curso y el nombre del estudiante
     *
     * @param claveCurso clave unica del curso
     * @param nombreCurso nombre del curso
     * @param nombreEstudiante nombre completo del estudiante inscrito
     */
    public Inscripciones(String claveCurso, String nombreCurso, String nombreEstudiante) {
        this.claveCurso = claveCurso;
        this.nombreCurso = nombreCurso;
        this.nombreEstudiante = nombreEstudiante;
    }
 
    /**
     * regresa el nombre del curso
     *
     * @return nombre del curso
     */
    public String getNombreCurso() {
        return nombreCurso;
    }
 
    /**
     * asigna el nombre del curso
     *
     * @param nombreCurso nuevo nombre del curso
     */
    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }
 
    /**
     * regresa el nombre completo del estudiante inscrito
     *
     * @return nombre del estudiante
     */
    public String getNombreEstudiante() {
        return nombreEstudiante;
    }
 
    /**
     * asigna el nombre completo del estudiante inscrito
     *
     * @param nombreEstudiante nuevo nombre del estudiante
     */
    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }
 
    /**
     * regresa la clave unica del curso
     *
     * @return clave del curso
     */
    public String getClaveCurso() {
        return claveCurso;
    }
 
    /**
     * asigna la clave unica del curso
     *
     * @param claveCurso nueva clave del curso
     */
    public void setClaveCurso(String claveCurso) {
        this.claveCurso = claveCurso;
    }
 
    /**
     * regresa una representacion en texto de la inscripcion con sus tres datos
     *
     * @return cadena con la clave del curso, nombre del curso y nombre del estudiante
     */
    @Override
    public String toString() {
        return "Inscripciones{" + "nombreCurso=" + nombreCurso + ", nombreEstudiante=" + nombreEstudiante + ", claveCurso=" + claveCurso + '}';
    }
}
