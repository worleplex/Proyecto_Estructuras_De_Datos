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
    private Cola<SolicitudCalificacion> colaSolicitudes;

    public PersistenciaSolicitudes() {
        colaSolicitudes = new Cola<>();
    }

    public void agregarSolicitud(SolicitudCalificacion solicitud) {
        colaSolicitudes.enqueue(solicitud);
    }

    public SolicitudCalificacion procesarSolicitud() throws PersistenciaException {
        try {
            return colaSolicitudes.dequeue();
        } catch (Exception e) {
            throw new PersistenciaException("No hay solicitudes pendientes");
        }
    }
}
