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
    private DiccionarioTablaHash<String, Curso> cursos;

    public PersistenciaCursos() {
        cursos = new DiccionarioTablaHash<>(50);
    }

    public void registrarCurso(Curso curso) throws PersistenciaException {
        if (curso == null) {
            throw new PersistenciaException("Curso no puede ser null");
        }

        if (cursos.contains(curso.getClave())) {
            throw new PersistenciaException("Ya existe un curso con esa clave");
        }

        cursos.put(curso.getClave(), curso);
    }

    public Curso buscarCurso(String clave) throws PersistenciaException {
        try {
            return cursos.get(clave);
        } catch (Exception e) {
            throw new PersistenciaException("Curso no encontrado");
        }
    }

    public void eliminarCurso(String clave) throws PersistenciaException {
        try {
            cursos.remove(clave);
        } catch (Exception e) {
            throw new PersistenciaException("No se pudo eliminar el curso");
        }
    }

    public ListaEnlazada<Curso> obtenerTodos() {
        return cursos.obtenerTodosLosValores();
    }
}
