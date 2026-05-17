/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import Entidades.Inscripciones;
import Estructuras.ListaEnlazada;
import excepciones.PersistenciaException;

/**
 *
 * @author Jorge
 */
public class PersistenciaInscripciones {
    /**
     * lista de inscripciones
     */
    private ListaEnlazada<Inscripciones> inscripciones;

    /**
     * constructor para la lista vacia
     */
    public PersistenciaInscripciones() {
        inscripciones = new ListaEnlazada<>();
    }

    /**
     * registra una inscripcion
     *
     * @param claveCurso clave del curso
     * @param nombreCurso nombre del curso
     * @param nombreEstudiante nombre del estudiante
     * @throws PersistenciaException si ya existe esa inscripcion
     */
    public void inscribir(String claveCurso, String nombreCurso, String nombreEstudiante) {
        inscripciones.append(new Inscripciones(claveCurso, nombreCurso, nombreEstudiante));
    }

    /**
     * elimina una inscripcion
     *
     * @param claveCurso clave del curso
     * @param nombreEstudiante nombre del estudiante
     * @throws PersistenciaException si la inscripcion no existe
     */
    public void darBaja(String claveCurso, String nombreEstudiante) throws PersistenciaException {
        for (int i = 0; i < inscripciones.size(); i++) {
            Inscripciones ins = inscripciones.get(i);

            if (ins.getClaveCurso().equals(claveCurso)
                    && ins.getNombreEstudiante().equals(nombreEstudiante)) {
                inscripciones.remove(i);
                return;
            }
        }

        throw new PersistenciaException("Inscripcion no encontrada");
    }

    /**
     * obtiene todas las inscripciones
     *
     * @return lista enlazada con todas las inscripciones
     */
    public ListaEnlazada<Inscripciones> obtenerTodas() {
        return inscripciones;
    }
}
