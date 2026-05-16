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
import excepciones.PersistenciaException;

/**
 *
 * @author Jorge
 */
public class PersistenciaFachada implements IPersistenciaFachada{
    private PersistenciaEstudiantes persistenciaEstudiantes;
    private PersistenciaCursos persistenciaCursos;
    private PersistenciaInscripciones persistenciaInscripciones;
    private PersistenciaSolicitudes persistenciaSolicitudes;
    private PersistenciaAcciones persistenciaAcciones;

    public PersistenciaFachada() {
        persistenciaEstudiantes = new PersistenciaEstudiantes();
        persistenciaCursos = new PersistenciaCursos();
        persistenciaInscripciones = new PersistenciaInscripciones();
        persistenciaSolicitudes = new PersistenciaSolicitudes();
        persistenciaAcciones = new PersistenciaAcciones();
    }

    @Override
    public void registrarEstudiante(Estudiante estudiante) throws PersistenciaException {
        persistenciaEstudiantes.registrarEstudiante(estudiante);
    }

    @Override
    public Estudiante buscarEstudiante(String matricula) throws PersistenciaException {
        return persistenciaEstudiantes.buscarEstudiante(matricula);
    }

    @Override
    public void eliminarEstudiante(String matricula) throws PersistenciaException {
        persistenciaEstudiantes.eliminarEstudiante(matricula);
    }

    @Override
    public ListaEnlazada<Estudiante> obtenerTodosLosEstudiantes() {
        return persistenciaEstudiantes.obtenerTodos();
    }

    @Override
    public ListaEnlazada<Estudiante> listarEstudiantesOrdenadosPorPromedio() {
        return persistenciaEstudiantes.listarOrdenadosPorPromedio();
    }

    @Override
    public void registrarCurso(Curso curso) throws PersistenciaException {
        persistenciaCursos.registrarCurso(curso);
    }

    @Override
    public Curso buscarCurso(String clave) throws PersistenciaException {
        return persistenciaCursos.buscarCurso(clave);
    }

    @Override
    public void eliminarCurso(String clave) throws PersistenciaException {
        persistenciaCursos.eliminarCurso(clave);
    }

    @Override
    public ListaEnlazada<Curso> obtenerTodosLosCursos() {
        return persistenciaCursos.obtenerTodos();
    }

    @Override
    public void inscribirEstudiante(String claveCurso, String matricula) throws PersistenciaException {
        Curso curso = persistenciaCursos.buscarCurso(claveCurso);
        Estudiante estudiante = persistenciaEstudiantes.buscarEstudiante(matricula);

        persistenciaInscripciones.inscribir(
                curso.getClave(),
                curso.getNombre(),
                estudiante.getNombreCompleto()
        );
    }

    @Override
    public void darBajaEstudiante(String claveCurso, String matricula) throws PersistenciaException {
        Estudiante estudiante = persistenciaEstudiantes.buscarEstudiante(matricula);

        persistenciaInscripciones.darBaja(claveCurso, estudiante.getNombreCompleto());
    }

    @Override
    public ListaEnlazada<Inscripciones> obtenerInscripciones() {
        return persistenciaInscripciones.obtenerTodas();
    }

    @Override
    public void agregarSolicitudCalificacion(SolicitudCalificacion solicitud) {
        persistenciaSolicitudes.agregarSolicitud(solicitud);
    }

    @Override
    public SolicitudCalificacion procesarSolicitud() throws PersistenciaException {
        return persistenciaSolicitudes.procesarSolicitud();
    }

    @Override
    public void registrarAccion(Accion accion) {
        persistenciaAcciones.registrarAccion(accion);
    }

    @Override
    public Accion deshacerAccion() throws PersistenciaException {
        return persistenciaAcciones.deshacerAccion();
    }
}
