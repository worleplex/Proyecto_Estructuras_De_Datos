/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import Abstractas.DiccionarioTablaHash;
import Entidades.Curso;
import Estructuras.ListaEnlazada;
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
        try {
            return cursos.get(clave);
        } catch (Exception e) {
            throw new PersistenciaException("Curso no encontrado");
        }
    }

    /**
     * elimina un curso por su clave
     *
     * @param clave clave del curso a eliminar
     * @throws PersistenciaException si el curso no existe
     */
    public void eliminarCurso(String clave) throws PersistenciaException {
        try {
            cursos.remove(clave);
        } catch (Exception e) {
            throw new PersistenciaException("No se pudo eliminar el curso");
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
}
