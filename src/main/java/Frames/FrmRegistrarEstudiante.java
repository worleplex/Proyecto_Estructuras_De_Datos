/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Frames;

import Entidades.Estudiante;
import excepciones.PersistenciaException;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import persistencia.IPersistenciaFachada;
import utilerias.Boton;
import utilerias.PantallaBase;
import utilerias.CampoTexto;
import utilerias.Colores;
import utilerias.Mensaje;

/**
 *
 * @author Noelia E.N.
 */
public class FrmRegistrarEstudiante extends PantallaBase {

    private final IPersistenciaFachada persistencia;
    private final FrmMenuPrincipal menu;

    public FrmRegistrarEstudiante(IPersistenciaFachada persistencia, FrmMenuPrincipal menu) {
        this.persistencia = persistencia;
        this.menu = menu;
    }

    @Override
    public void construir() {

        setLayout(new BorderLayout());

        add(titulo("Registrar Estudiante"), BorderLayout.NORTH);

        CampoTexto matricula = new CampoTexto();
        CampoTexto nombre = new CampoTexto();
        CampoTexto telefono = new CampoTexto();
        CampoTexto correo = new CampoTexto();
        CampoTexto direccion = new CampoTexto();

        contenido.add(new JLabel("Matrícula:"));
        contenido.add(matricula);

        contenido.add(new JLabel("Nombre completo:"));
        contenido.add(nombre);

        contenido.add(new JLabel("Teléfono:"));
        contenido.add(telefono);

        contenido.add(new JLabel("Correo:"));
        contenido.add(correo);

        contenido.add(new JLabel("Dirección:"));
        contenido.add(direccion);

        Boton registrar = new Boton("Registrar");

        registrar.addActionListener(e -> {

            try {

                Estudiante estudiante = new Estudiante(
                        matricula.getText(),
                        nombre.getText(),
                        telefono.getText(),
                        correo.getText(),
                        direccion.getText()
                );

                persistencia.registrarEstudiante(estudiante);

                Mensaje.exito(this,
                        "Estudiante registrado correctamente");

                menu.volverInicio();

            } catch (PersistenciaException ex) {

                Mensaje.error(this, ex.getMessage());
            }
        });

        JPanel abajo = new JPanel();
        abajo.setBackground(Colores.AZUL_CLARO);
        abajo.add(registrar);

        add(contenido, BorderLayout.CENTER);
        add(abajo, BorderLayout.SOUTH);
    }
}
