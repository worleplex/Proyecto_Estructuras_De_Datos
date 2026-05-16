/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Frames;

import Entidades.Estudiante;
import excepciones.PersistenciaException;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import persistencia.IPersistenciaFachada;
import utilerias.Boton;
import utilerias.CampoTexto;
import utilerias.Colores;
import utilerias.Fuentes;
import utilerias.Mensaje;
import utilerias.PantallaBase;

/**
 *
 * @author Noelia E.N
 */
public class FrmBuscarEstudiante extends PantallaBase {

    private final IPersistenciaFachada persistencia;
    private final FrmMenuPrincipal menu;

    public FrmBuscarEstudiante(IPersistenciaFachada persistencia, FrmMenuPrincipal menu) {
        this.persistencia = persistencia;
        this.menu = menu;
    }

    @Override
    public void construir() {

        setLayout(new BorderLayout());

        add(titulo("Buscar Estudiante"), BorderLayout.NORTH);

        CampoTexto matricula = new CampoTexto();

        JTextArea resultado = new JTextArea();
        resultado.setEditable(false);
        resultado.setFont(Fuentes.TEXTO);

        JScrollPane scroll = new JScrollPane(resultado);

        contenido.add(new JLabel("Matrícula:"));
        contenido.add(matricula);

        Boton buscar = new Boton("Buscar");
        Boton regresar = new Boton("Regresar");

        buscar.addActionListener(e -> {

            try {

                Estudiante estudiante
                        = persistencia.buscarEstudiante(matricula.getText());

                if (estudiante == null) {
                    Mensaje.error(this, "Estudiante no encontrado");
                    resultado.setText("");
                    return;
                }

                resultado.setText(
                        "MATRÍCULA: "
                        + estudiante.getMatricula()
                        + "\n\n"
                        + "NOMBRE: "
                        + estudiante.getNombreCompleto()
                        + "\n\n"
                        + "TELÉFONO: "
                        + estudiante.getTelefono()
                        + "\n\n"
                        + "CORREO: "
                        + estudiante.getCorreo()
                        + "\n\n"
                        + "DIRECCIÓN: "
                        + estudiante.getDireccion()
                        + "\n\n"
                        + "PROMEDIO: "
                        + estudiante.calcularPromedio()
                        + "\n\n"
                        + "ROL: "
                        + estudiante.getRol()
                );

            } catch (PersistenciaException ex) {
                Mensaje.error(this, ex.getMessage());
            }
        });

        regresar.addActionListener(e -> {
            menu.volverInicio();
        });
        
        JPanel botones = new JPanel(new FlowLayout());
        botones.setBackground(Colores.AZUL_CLARO);
        botones.add(buscar);
        botones.add(regresar);
        
        JPanel abajo = new JPanel(new BorderLayout());
        abajo.setBackground(Colores.AZUL_CLARO);

        abajo.add(botones, BorderLayout.NORTH);
        abajo.add(scroll, BorderLayout.CENTER);

        add(contenido, BorderLayout.NORTH);
        add(abajo, BorderLayout.CENTER);
    }
}
