/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import Entidades.Accion;
import Estructuras.Pila;
import excepciones.PersistenciaException;

/**
 *
 * @author Jorge
 */
public class PersistenciaAcciones {
    private Pila<Accion> historial;

    public PersistenciaAcciones() {
        historial = new Pila<>();
    }

    public void registrarAccion(Accion accion) {
        historial.push(accion);
    }

    public Accion deshacerAccion() throws PersistenciaException {
        try {
            return historial.pop();
        } catch (Exception e) {
            throw new PersistenciaException("No hay acciones para deshacer");
        }
    }
}
