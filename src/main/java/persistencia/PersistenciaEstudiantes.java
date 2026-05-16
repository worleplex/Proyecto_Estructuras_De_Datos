/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import Abstractas.DiccionarioTablaHash;
import Entidades.Estudiante;
import Estructuras.ListaEnlazada;
import excepciones.PersistenciaException;

/**
 *
 * @author Jorge
 */
public class PersistenciaEstudiantes {
    /**
     * diccionario principal
     * llave = matricula
     */
    private DiccionarioTablaHash<String, Estudiante> estudiantes;
    
    /**
     * constructor que inicializa la estructura con capacidad de 100 estudiantes
     */
    public PersistenciaEstudiantes() {
        estudiantes = new DiccionarioTablaHash<>(100);
    }

    /**
     * registra un nuevo estudiante
     * valida que no sea null y que la matricula no exista
     *
     * @param estudiante estudiante a registrar
     * @throws PersistenciaException si el estudiante es null o ya existe
     */
    public void registrarEstudiante(Estudiante estudiante) throws PersistenciaException {
        if (estudiante == null) {
            throw new PersistenciaException("El estudiante no puede ser null");
        }

        if (estudiantes.contains(estudiante.getMatricula())) {
            throw new PersistenciaException("Ya existe un estudiante con esa matricula");
        }

        estudiantes.put(estudiante.getMatricula(), estudiante);
    }

    /**
     * busca un estudiante por su matricula
     *
     * @param matricula matricula del estudiante
     * @return estudiante encontrado
     * @throws PersistenciaException si no existe el estudiante con esa matricula
     */
    public Estudiante buscarEstudiante(String matricula) throws PersistenciaException {
        try {
            return estudiantes.get(matricula);
        } catch (Exception e) {
            throw new PersistenciaException("Estudiante no encontrado");
        }
    }

    /**
     * elimina un estudiante usando su matricula
     *
     * @param matricula matricula del estudiante a eliminar
     * @throws PersistenciaException si el estudiante no existe o no puede eliminarse
     */
    public void eliminarEstudiante(String matricula) throws PersistenciaException {
        try {
            estudiantes.remove(matricula);
        } catch (Exception e) {
            throw new PersistenciaException("No se pudo eliminar el estudiante");
        }
    }

     /**
     * obtiene todos los estudiantes registrados
     *
     * @return lista enlazada con todos los estudiantes
     */
    public ListaEnlazada<Estudiante> obtenerTodos() {
        return estudiantes.obtenerTodosLosValores();
    }

    /**
     * genera una lista de estudiantes ordenados de mayor a menor promedio
     *
     * @return lista enlazada ordenada por promedio
     */
    public ListaEnlazada<Estudiante> listarOrdenadosPorPromedio() {
        ListaEnlazada<Estudiante> listaOriginal = estudiantes.obtenerTodosLosValores();
        ListaEnlazada<Estudiante> ordenados = new ListaEnlazada<>();

        while (!listaOriginal.empty()) {
            Estudiante mayor = listaOriginal.get(0);
            int indiceMayor = 0;

            for (int i = 1; i < listaOriginal.size(); i++) {
                if (listaOriginal.get(i).calcularPromedio() > mayor.calcularPromedio()) {
                    mayor = listaOriginal.get(i);
                    indiceMayor = i;
                }
            }

            ordenados.append(mayor);
            listaOriginal.remove(indiceMayor);
        }

        return ordenados;
    }
}
