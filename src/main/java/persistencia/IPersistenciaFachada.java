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

/**
 *
 * @author chris
 */
public interface IPersistenciaFachada {
    // estudiantes
    void registrarEstudiante(Estudiante estudiante) throws Exception;
    Estudiante buscarEstudiante(String matricula) throws Exception;
    void eliminarEstudiante(String matricula) throws Exception;
    ListaEnlazada<Estudiante> obtenerTodosLosEstudiantes();

    // cursos
    void registrarCurso(Curso curso) throws Exception;
    Curso buscarCurso(String clave) throws Exception;
    void eliminarCurso(String clave) throws Exception;
    ListaEnlazada<Curso> obtenerTodosLosCursos();

    // inscripciones
    void inscribirEstudiante(String claveCurso, String matricula) throws Exception;
    void darBajaEstudiante(String claveCurso, String matricula) throws Exception;
    ListaEnlazada<Inscripciones> obtenerInscripciones();

    // solicitudes
    void agregarSolicitudCalificacion(SolicitudCalificacion solicitud);
    SolicitudCalificacion procesarSolicitud();

    // acciones
    void registrarAccion(Accion accion);
    Accion deshacerAccion();
}
