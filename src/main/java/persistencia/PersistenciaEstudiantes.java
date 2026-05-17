/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import Abstractas.DiccionarioTablaHash;
import Entidades.Estudiante;
import Estructuras.ListaEnlazada;
import arboles.ArbolBST;
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
     * Árbol BST para búsqueda ordenada por matrícula 
     */
    private ArbolBST<Estudiante> bst;
    
    /**
     * constructor que inicializa la estructura con capacidad de 100 estudiantes
     */
    public PersistenciaEstudiantes() {
        estudiantes = new DiccionarioTablaHash<>(100);
        bst = new ArbolBST<>();
    }

    /**
     * Registra un nuevo estudiante en el diccionario y en el BST.
     *
     * @param estudiante estudiante a registrar
     * @throws PersistenciaException si el estudiante es null o la matrícula ya existe
     */
    public void registrarEstudiante(Estudiante estudiante) throws PersistenciaException {
        if (estudiante == null) {
            throw new PersistenciaException("El estudiante no puede ser null");
        }
        if (estudiantes.contains(estudiante.getMatricula())) {
            throw new PersistenciaException(
                    "Ya existe un estudiante con la matrícula: " + estudiante.getMatricula());
        }
        estudiantes.put(estudiante.getMatricula(), estudiante);
        bst.insertar(estudiante);     
    }

    /**
     * Busca un estudiante por matrícula en el diccionario (O(1) promedio).
     *
     * @param matricula matrícula del estudiante
     * @return objeto Estudiante encontrado
     * @throws PersistenciaException si no existe ningún estudiante con esa matrícula
     */
    public Estudiante buscarEstudiante(String matricula) throws PersistenciaException {
        if (matricula == null || matricula.trim().isEmpty()) {
            throw new PersistenciaException("La matrícula no puede estar vacía");
        }
        try {
            return estudiantes.get(matricula.trim());
        } catch (Exception e) {
            throw new PersistenciaException("Estudiante no encontrado con matrícula: " + matricula);
        }
    }

    /**
     * Elimina un estudiante del diccionario y del BST.
     *
     * @param matricula matrícula del estudiante a eliminar
     * @throws PersistenciaException si el estudiante no existe
     */
    public void eliminarEstudiante(String matricula) throws PersistenciaException {
        if (!estudiantes.contains(matricula)) {
            throw new PersistenciaException(
                    "No existe ningún estudiante con matrícula: " + matricula);
        }
        try {
            Estudiante e = estudiantes.get(matricula);
            estudiantes.remove(matricula);
            bst.eliminar(e);
        } catch (Exception ex) {
            throw new PersistenciaException("No se pudo eliminar: " + ex.getMessage());
        }
    }

    /**
     * Obtiene todos los estudiantes registrados.
     *
     * @return lista enlazada con todos los estudiantes
     */
    public ListaEnlazada<Estudiante> obtenerTodos() {
        return estudiantes.obtenerTodosLosValores();
    }

    /**
     * Ordena los estudiantes de mayor a menor promedio usando selección simple.
     * No usa colecciones del JDK: solo arreglos y la ListaEnlazada propia.
     *
     * @return lista enlazada ordenada de mayor a menor promedio
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

    /**
     * Expone el BST para que otros módulos puedan usarlo si es necesario.
     *
     * @return árbol BST de estudiantes ordenado por matrícula
     */
    public ArbolBST<Estudiante> getBst() {
        return bst;
    }
}
