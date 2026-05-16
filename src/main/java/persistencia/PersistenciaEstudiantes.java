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
    private DiccionarioTablaHash<String, Estudiante> estudiantes;

    public PersistenciaEstudiantes() {
        estudiantes = new DiccionarioTablaHash<>(100);
    }

    public void registrarEstudiante(Estudiante estudiante) throws PersistenciaException {
        if (estudiante == null) {
            throw new PersistenciaException("El estudiante no puede ser null");
        }

        if (estudiantes.contains(estudiante.getMatricula())) {
            throw new PersistenciaException("Ya existe un estudiante con esa matricula");
        }

        estudiantes.put(estudiante.getMatricula(), estudiante);
    }

    public Estudiante buscarEstudiante(String matricula) throws PersistenciaException {
        try {
            return estudiantes.get(matricula);
        } catch (Exception e) {
            throw new PersistenciaException("Estudiante no encontrado");
        }
    }

    public void eliminarEstudiante(String matricula) throws PersistenciaException {
        try {
            estudiantes.remove(matricula);
        } catch (Exception e) {
            throw new PersistenciaException("No se pudo eliminar el estudiante");
        }
    }

    public ListaEnlazada<Estudiante> obtenerTodos() {
        return estudiantes.obtenerTodosLosValores();
    }

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
