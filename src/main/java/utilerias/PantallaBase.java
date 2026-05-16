/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilerias;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Noelia E.N
 */
public class PantallaBase extends JFrame {

    protected JPanel panelCentro;

    public PantallaBase(String titulo) {

        setTitle(titulo);
        setSize(1100, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        panelCentro = new JPanel(new BorderLayout());
        panelCentro.setBackground(Colores.AZUL_CLARO);

        JLabel bienvenida = new JLabel(
                titulo,
                SwingConstants.CENTER
        );

        bienvenida.setFont(
                new java.awt.Font(
                        "Segoe UI",
                        java.awt.Font.BOLD,
                        28
                )
        );

        bienvenida.setForeground(Colores.AZUL_OSCURO);

        panelCentro.add(bienvenida, BorderLayout.CENTER);

        add(panelCentro);
    }

    public JPanel getPanelCentro() {
        return panelCentro;
    }

    public void limpiar() {
        panelCentro.removeAll();
        panelCentro.revalidate();
        panelCentro.repaint();
    }
}
