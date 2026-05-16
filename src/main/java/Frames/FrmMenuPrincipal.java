/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Frames;

import persistencia.IPersistenciaFachada;

import javax.swing.*;
import java.awt.*;
import utilerias.Boton;
import utilerias.Colores;
import utilerias.Fuentes;
import utilerias.PantallaBase;

/**
 *
 * @author Noelia E.N
 */
public class FrmMenuPrincipal extends JFrame {

    private final IPersistenciaFachada persistencia;
    private JPanel panelCentral;

    public FrmMenuPrincipal(IPersistenciaFachada persistencia) {
        this.persistencia = persistencia;

        configurarVentana();
        construirMenu();
        construirInicio();

        setVisible(true);
    }

    private void configurarVentana() {
        setTitle("Sistema de Inscripciones");
        setSize(1200, 750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
    }

    private void construirInicio() {

        panelCentral = new JPanel(new BorderLayout());
        panelCentral.setBackground(Colores.AZUL_CLARO);

        JLabel titulo = new JLabel(
                "Sistema de Inscripciones",
                SwingConstants.CENTER
        );

        titulo.setFont(Fuentes.TITULO);
        titulo.setForeground(Colores.AZUL_OSCURO);

        JLabel subtitulo = new JLabel(
                "Seleccione una opción del menú superior",
                SwingConstants.CENTER
        );

        subtitulo.setFont(Fuentes.SUBTITULO);

        JPanel texto = new JPanel(new GridLayout(2, 1));
        texto.setBackground(Colores.AZUL_CLARO);

        texto.add(titulo);
        texto.add(subtitulo);

        panelCentral.add(texto, BorderLayout.CENTER);

        Boton salir = new Boton("Salir");
        salir.addActionListener(e -> System.exit(0));

        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.RIGHT, 50, 40));
        panelInferior.setBackground(Colores.AZUL_CLARO);
        panelInferior.add(salir);

        panelCentral.add(panelInferior, BorderLayout.SOUTH);

        add(panelCentral, BorderLayout.CENTER);
    }

    private void construirMenu() {

        JMenuBar barra = new JMenuBar();
        barra.setBackground(Colores.AZUL_OSCURO);

        barra.add(crearMenuEstudiantes());
        barra.add(crearMenuCursos());
        barra.add(crearMenuInscripciones());
        barra.add(crearMenuSolicitudes());
        barra.add(crearMenuAcciones());
        barra.add(crearMenuReportes());

        setJMenuBar(barra);
    }

    private JMenu crearMenuEstudiantes() {

        JMenu menu = menu("Estudiantes");
        
        JMenuItem registrar = item("Registrar estudiante");
        registrar.addActionListener(e -> mostrarPantalla(new FrmRegistrarEstudiante(persistencia, this)));
        menu.add(registrar);
        
        
        JMenuItem buscar = item("Buscar estudiante");
        buscar.addActionListener(e -> mostrarPantalla(new FrmBuscarEstudiante(persistencia, this)));
        menu.add(buscar);
        
        
        menu.add(item("Eliminar estudiante"));

        return menu;
    }

    private JMenu crearMenuCursos() {

        JMenu menu = menu("Cursos");

        menu.add(item("Registrar curso"));
        menu.add(item("Buscar curso"));
        menu.add(item("Eliminar curso"));
        menu.add(item("Listar cursos"));

        return menu;
    }

    private JMenu crearMenuInscripciones() {

        JMenu menu = menu("Inscripciones");

        menu.add(item("Inscribir estudiante"));
        menu.add(item("Dar baja"));
        menu.add(item("Mostrar inscripciones"));

        return menu;
    }

    private JMenu crearMenuSolicitudes() {

        JMenu menu = menu("Solicitudes");

        menu.add(item("Agregar solicitud"));
        menu.add(item("Procesar solicitud"));

        return menu;
    }

    private JMenu crearMenuAcciones() {

        JMenu menu = menu("Acciones");

        menu.add(item("Deshacer acción"));

        return menu;
    }

    private JMenu crearMenuReportes() {

        JMenu menu = menu("Reportes");

        menu.add(item("Listar por promedio"));

        return menu;
    }

    private JMenu menu(String texto) {

        JMenu menu = new JMenu(texto);

        menu.setForeground(Colores.BLANCO);
        menu.setFont(Fuentes.BOTON);

        return menu;
    }

    private JMenuItem item(String texto) {

        JMenuItem item = new JMenuItem(texto);

        item.setFont(Fuentes.TEXTO);

        return item;
    }

    public void mostrarPantalla(PantallaBase pantalla) {

        panelCentral.removeAll();

        pantalla.construir();

        panelCentral.add(pantalla, BorderLayout.CENTER);

        panelCentral.revalidate();
        panelCentral.repaint();
    }

    public IPersistenciaFachada getPersistencia() {
        return persistencia;
    }
    
    public void volverInicio() {

    panelCentral.removeAll();

    JPanel inicio = new JPanel(new BorderLayout());
    inicio.setBackground(Colores.AZUL_CLARO);

    JLabel titulo = new JLabel(
            "Sistema de Inscripciones",
            SwingConstants.CENTER
    );

    titulo.setFont(Fuentes.TITULO);
    titulo.setForeground(Colores.AZUL_OSCURO);

    JLabel subtitulo = new JLabel(
            "Seleccione una opción del menú superior",
            SwingConstants.CENTER
    );

    subtitulo.setFont(Fuentes.SUBTITULO);

    JPanel texto = new JPanel(new GridLayout(2,1));
    texto.setBackground(Colores.AZUL_CLARO);

    texto.add(titulo);
    texto.add(subtitulo);

    inicio.add(texto, BorderLayout.CENTER);

    Boton salir = new Boton("Salir");
    salir.addActionListener(e -> System.exit(0));

    JPanel abajo = new JPanel(
            new FlowLayout(FlowLayout.RIGHT,20,20)
    );

    abajo.setBackground(Colores.AZUL_CLARO);
    abajo.add(salir);

    inicio.add(abajo, BorderLayout.SOUTH);

    panelCentral.add(inicio, BorderLayout.CENTER);

    panelCentral.revalidate();
    panelCentral.repaint();
}
    
}
