/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import Abstractas.DiccionarioTablaHash;
import Entidades.Curso;
import Entidades.Estudiante;
import Estructuras.ListaEnlazada;
import ListasEnlazadas.ListaDoblementeEnlazadaCircular;
import excepciones.PersistenciaException;

/**
 *
 * @author Jorge
 */
public class PersistenciaCursos {
    /**
     * diccionario de cursos donde la llave es la clave
     */
    private DiccionarioTablaHash<String, Curso> cursos;

    /**
     * constructor de la estructura con una capacidad de 50
     */
    public PersistenciaCursos() {
        cursos = new DiccionarioTablaHash<>(50);
    }

    /**
     * registra un curso
     *
     * @param curso curso a registrar
     * @throws PersistenciaException si el curso es null o la clave ya existe
     */
    public void registrarCurso(Curso curso) throws PersistenciaException {
        if (curso == null) {
            throw new PersistenciaException("Curso no puede ser null");
        }

        if (cursos.contains(curso.getClave())) {
            throw new PersistenciaException("Ya existe un curso con esa clave");
        }

        cursos.put(curso.getClave(), curso);
    }

    /**
     * busca un curso por su clave
     *
     * @param clave clave del curso a buscar
     * @return curso encontrado
     * @throws PersistenciaException si el curso no existe
     */
    public Curso buscarCurso(String clave) throws PersistenciaException {
        if (clave == null || clave.trim().isEmpty()) {
            throw new PersistenciaException("La clave no puede estar vacía");
        }
        try {
            return cursos.get(clave.trim());
        } catch (Exception e) {
            throw new PersistenciaException("Curso no encontrado con clave: " + clave);
        }
    }

    /**
     * elimina un curso por su clave
     *
     * @param clave clave del curso a eliminar
     * @throws PersistenciaException si el curso no existe
     */
    public void eliminarCurso(String clave) throws PersistenciaException {
        if (!cursos.contains(clave)) {
            throw new PersistenciaException("No existe ningún curso con clave: " + clave);
        }
        try {
            cursos.remove(clave);
        } catch (Exception e) {
            throw new PersistenciaException("No se pudo eliminar el curso: " + e.getMessage());
        }
    }
    
    /**
     * obtiene todos los cursos
     *
     * @return lista enlazada con todos los cursos
     */
    public ListaEnlazada<Curso> obtenerTodos() {
        return cursos.obtenerTodosLosValores();
    }
    
    // niño jorge te añadi esto porque ya tenemos el curso completo
    
    /**
     * Inscribe un estudiante en un curso.
     * Si hay cupo lo inscribe; si no, lo manda a lista de espera.
     *
     * @param claveCurso  clave del curso
     * @param estudiante  estudiante a inscribir
     * @throws PersistenciaException si el curso no existe
     */
    public void inscribirEstudiante(String claveCurso, Estudiante estudiante)
            throws PersistenciaException {
        Curso curso = buscarCurso(claveCurso);
        curso.inscribir(estudiante);
    }

    /**
     * Da de baja a un estudiante de un curso.
     * Si hay alguien en espera, pasa al cupo liberado automáticamente.
     *
     * @param claveCurso clave del curso
     * @param estudiante estudiante a dar de baja
     * @throws PersistenciaException si el curso no existe o el estudiante no estaba inscrito
     */
    public void darBajaEstudiante(String claveCurso, Estudiante estudiante)
            throws PersistenciaException {
        Curso curso = buscarCurso(claveCurso);
        boolean eliminado = curso.darBaja(estudiante);
        if (!eliminado) {
            throw new PersistenciaException(
                    "El estudiante " + estudiante.getMatricula() + " no está inscrito en el curso");
        }
    }

    /**
     * Obtiene la lista de espera de un curso.
     *
     * @param claveCurso clave del curso
     * @return lista doblemente enlazada circular con los estudiantes en espera
     * @throws PersistenciaException si el curso no existe
     */
    public ListaDoblementeEnlazadaCircular<Estudiante> obtenerListaEspera(String claveCurso)
            throws PersistenciaException {
        return buscarCurso(claveCurso).getEspera();
    }

    /**
     * Obtiene la lista de inscritos de un curso.
     *
     * @param claveCurso clave del curso
     * @return lista enlazada simple con los estudiantes inscritos
     * @throws PersistenciaException si el curso no existe
     */
    public ListaEnlazada<Estudiante> obtenerInscritos(String claveCurso)
            throws PersistenciaException {
        return buscarCurso(claveCurso).getInscritos();
    }

    /**
     * Rota el rol (tutor/líder) al siguiente estudiante en el curso.
     *
     * @param claveCurso clave del curso
     * @return estudiante que ahora tiene el rol activo
     * @throws PersistenciaException si el curso no existe o no hay estudiantes con rol
     */
    public Estudiante rotarRol(String claveCurso) throws PersistenciaException {
        Curso curso = buscarCurso(claveCurso);
        if (curso.getRoles().empty()) {
            throw new PersistenciaException("No hay estudiantes en la lista de roles del curso");
        }
        curso.rotarRol();
        Estudiante conRol = curso.getEstudianteConRol();
        if (conRol != null) {
            conRol.setRol("LÍDER");
        }
        return conRol;
    }
}
