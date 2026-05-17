/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import Estructuras.ListaEnlazada;
import Excepciones.ListException;
import ListasEnlazadas.ListaDoblementeEnlazadaCircular;
import ListasEnlazadas.ListaEnlazadaCircular;

/**
 * almacena la clave unica, nombre y capacidad maxima de estudiantes
 * las listas de inscritos, espera y rotacion de roles se agregan
 * una vez que las estructuras esten implementadas
 *
 * @author julian izaguirre
 */
public class Curso {
    private String clave;
    private String nombre;
    private int capacidadMaxima;
    // es para verificar cupo y mostrar inscritos
    private ListaEnlazada<Estudiante> inscritos;
    // cuando el curso esta lleno esta lista permite reccores hacia adelante y hacia atras
    private ListaDoblementeEnlazadaCircular<Estudiante> espera;
    // la circular simple se rota para asignar el rol al siguiente en la lista
    private ListaEnlazadaCircular<Estudiante> roles;

    /**
     * Constructor que inicializa un curso con su clave, nombre y capacidad.
     * Las tres listas se crean vacías automáticamente.
     *
     * @param clave clave única del curso
     * @param nombre nombre del curso
     * @param capacidadMaxima número máximo de estudiantes permitidos
     */
    public Curso(String clave, String nombre, int capacidadMaxima) {
        this.clave = clave;
        this.nombre = nombre;
        this.capacidadMaxima = capacidadMaxima;
        this.inscritos = new Estructuras.ListaEnlazada<>();
        this.espera = new ListaDoblementeEnlazadaCircular<>();
        this.roles = new ListaEnlazadaCircular<>();
    }

    /**
     * Indica si el curso todavía tiene cupo disponible.
     *
     * @return true si la cantidad de inscritos es menor que la capacidad máxima
     */
    public boolean tieneCupo() {
        return inscritos.size() < capacidadMaxima;
    }

    /**
     * Inscribe un estudiante si hay cupo; si no, lo manda a lista de espera.
     * También lo agrega a la lista de roles para participar en la rotación.
     *
     * @param estudiante estudiante a inscribir
     */
    public void inscribir(Estudiante estudiante) {
        if (tieneCupo()) {
            inscritos.append(estudiante);
            roles.append(estudiante); 
        } else {
            espera.append(estudiante);
        }
    }

    /**
     * Da de baja a un estudiante de la lista de inscritos.
     * Si hay alguien en espera, pasa automáticamente al cupo liberado.
     *
     * @param estudiante estudiante a dar de baja
     * @return true si se encontró y eliminó, false si no estaba inscrito
     */
    public boolean darBaja(Estudiante estudiante) {
        boolean eliminado = inscritos.remove(estudiante);
        roles.remove(estudiante);

        // Si hay alguien esperando, pasa al cupo liberado
        if (eliminado && !espera.empty()) {
            try {
                Estudiante siguiente = espera.remove(0);
                inscritos.append(siguiente);
                roles.append(siguiente);
            } catch (ListException ignored) {
                // lista de espera ya vacía, no pasa nada
            }
        }
        return eliminado;
    }

    /**
     * Rota la lista de roles al siguiente estudiante.
     * El estudiante que queda al inicio recibe el rol.
     */
    public void rotarRol() {
        roles.rotar();
    }

    /**
     * Regresa el estudiante que actualmente tiene el rol asignado
     * (el que está en la posición 0 de la lista de roles).
     *
     * @return estudiante con el rol activo, o null si la lista está vacía
     */
    public Estudiante getEstudianteConRol() {
        if (roles.empty()) {
            return null;
        }
        try {
            return roles.get(0);
        } catch (Exception e) {
            return null;
        }
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public ListaEnlazada<Estudiante> getInscritos() {
        return inscritos;
    }

    public void setInscritos(ListaEnlazada<Estudiante> inscritos) {
        this.inscritos = inscritos;
    }

    public ListaDoblementeEnlazadaCircular<Estudiante> getEspera() {
        return espera;
    }

    public void setEspera(ListaDoblementeEnlazadaCircular<Estudiante> espera) {
        this.espera = espera;
    }

    public ListaEnlazadaCircular<Estudiante> getRoles() {
        return roles;
    }

    public void setRoles(ListaEnlazadaCircular<Estudiante> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Curso("
                + "clave: " + clave
                + ", nombre: " + nombre
                + ", capacidadMaxima: " + capacidadMaxima
                + ", inscritos: " + inscritos.size()
                + ", enEspera: " + espera.size() + ")";
    }
}
