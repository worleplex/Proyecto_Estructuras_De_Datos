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
    private ListaEnlazada<Inscripciones> inscripciones;

    public PersistenciaInscripciones() {
        inscripciones = new ListaEnlazada<>();
    }

    public void inscribir(String claveCurso, String nombreCurso, String nombreEstudiante) {
        inscripciones.append(new Inscripciones(claveCurso, nombreCurso, nombreEstudiante));
    }

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

    public ListaEnlazada<Inscripciones> obtenerTodas() {
        return inscripciones;
    }
}
