/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 * representa una accion realizada en el sistema
 * se almacena en la pila generica de acciones para poder revertirla
 * cada accion guarda su tipo y el dato anterior necesario para deshacer
 *
 * @author julian izaguirre
 */
public class Accion {
    /**
     * tipos de acciones que el sistema puede registrar y revertir
     */
    public enum Tipo {
        REGISTRO,INSCRIPCION,BAJA,CALIFICACION
    }

    private Tipo tipo;
    private Object datoAnterior;
 
    /**
     * constructor que inicializa la accion con su tipo y el dato previo
     *
     * @param tipo tipo de accion realizada
     * @param datoAnterior objeto con el estado anterior necesario para deshacer
     */
    public Accion(Tipo tipo, Object datoAnterior) {
        this.tipo = tipo;
        this.datoAnterior = datoAnterior;
    }
 
    /**
     * regresa el tipo de accion registrada
     *
     * @return tipo de la accion
     */
    public Tipo getTipo() {
        return tipo;
    }
 
    /**
     * asigna el tipo de accion
     *
     * @param tipo nuevo tipo de accion
     */
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
 
    /**
     * regresa el dato anterior guardado para poder deshacer la accion
     *
     * @return objeto con el estado previo a la accion
     */
    public Object getDatoAnterior() {
        return datoAnterior;
    }
 
    /**
     * asigna el dato anterior de la accion
     *
     * @param datoAnterior nuevo objeto con el estado previo
     */
    public void setDatoAnterior(Object datoAnterior) {
        this.datoAnterior = datoAnterior;
    }
 
    /**
     * regresa una representacion en texto de la accion con su tipo y dato anterior
     *
     * @return cadena con la informacion de la accion
     */
    @Override
    public String toString() {
        return "Accion("
                + "tipo: " + tipo
                + ", datoAnterior: " + datoAnterior + ")";
    }
}
