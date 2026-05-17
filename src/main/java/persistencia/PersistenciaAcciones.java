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
    /**
     * pila que guarda el historial de acciones
     */
    private Pila<Accion> historial;

    /**
     * constructor que inicializa la pila vacia
     */
    public PersistenciaAcciones() {
        historial = new Pila<>();
    }

    /**
     * registra una nueva accion en el historial
     *
     * @param accion accion realizada
     */
    public void registrarAccion(Accion accion) {
        historial.push(accion);
    }

     /**
     * elimina y devuelve la ultima accion registrada
     *
     * @return ultima accion realizada
     * @throws PersistenciaException si no hay acciones para deshacer
     */
    public Accion deshacerAccion() throws PersistenciaException {
        try {
            return historial.pop();
        } catch (Exception e) {
            throw new PersistenciaException("No hay acciones para deshacer");
        }
    }
}
