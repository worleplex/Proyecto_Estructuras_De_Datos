/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import Entidades.SolicitudCalificacion;
import Estructuras.Cola;
import excepciones.PersistenciaException;

/**
 *
 * @author Jorge
 */
public class PersistenciaSolicitudes {
    /**
     * cola de solicitudes
     */
    private Cola<SolicitudCalificacion> colaSolicitudes;

    /**
     * constructor que inicializa la cola vacia
     */
    public PersistenciaSolicitudes() {
        colaSolicitudes = new Cola<>();
    }

    /**
     * agrega una solicitud al final de la cola
     *
     * @param solicitud solicitud de calificacion a registrar
     * @throws PersistenciaException si la solicitud es null
     */
    public void agregarSolicitud(SolicitudCalificacion solicitud) {
        colaSolicitudes.enqueue(solicitud);
    }

    /**
     * procesa y elimina la solicitud mas antigua
     *
     * @return solicitud procesada
     * @throws PersistenciaException si no hay solicitudes pendientes
     */
    public SolicitudCalificacion procesarSolicitud() throws PersistenciaException {
        try {
            return colaSolicitudes.dequeue();
        } catch (Exception e) {
            throw new PersistenciaException("No hay solicitudes pendientes");
        }
    }
}
