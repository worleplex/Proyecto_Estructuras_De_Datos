/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import Entidades.Accion;
import Entidades.Curso;
import Entidades.Estudiante;
import Entidades.Inscripciones;
import Entidades.SolicitudCalificacion;
import Estructuras.ListaEnlazada;
import ListasEnlazadas.ListaDoblementeEnlazadaCircular;
import excepciones.PersistenciaException;

/**
 *
 * @author chris
 */
public interface IPersistenciaFachada {
    // estudiantes
    void registrarEstudiante(Estudiante estudiante) throws PersistenciaException;
    Estudiante buscarEstudiante(String matricula) throws PersistenciaException;
    void eliminarEstudiante(String matricula) throws PersistenciaException;
    ListaEnlazada<Estudiante> obtenerTodosLosEstudiantes();
    ListaEnlazada<Estudiante> listarEstudiantesOrdenadosPorPromedio() throws PersistenciaException;

    // cursos
    void registrarCurso(Curso curso) throws PersistenciaException;
    Curso buscarCurso(String clave) throws PersistenciaException;
    void eliminarCurso(String clave) throws PersistenciaException;
    ListaEnlazada<Curso> obtenerTodosLosCursos();

    // inscripciones
    void inscribirEstudiante(String claveCurso, String matricula) throws PersistenciaException;
    void darBajaEstudiante(String claveCurso, String matricula) throws PersistenciaException;
    ListaEnlazada<Inscripciones> obtenerInscripciones();
    // fitch te añadi esto nuevo y solo esos 3
    ListaEnlazada<Estudiante> obtenerInscritosDeCurso(String claveCurso) throws PersistenciaException;
    ListaDoblementeEnlazadaCircular<Estudiante> obtenerListaEsperaDeCurso(String claveCurso) throws PersistenciaException;
    Estudiante rotarRolCurso(String claveCurso) throws PersistenciaException;
    
    // solicitudes
    void agregarSolicitudCalificacion(SolicitudCalificacion solicitud);
    SolicitudCalificacion procesarSolicitud() throws PersistenciaException;

    // acciones
    void registrarAccion(Accion accion);
    Accion deshacerAccion() throws PersistenciaException;
    
}
