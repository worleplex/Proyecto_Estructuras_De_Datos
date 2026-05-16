/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilerias;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Noelia E.N
 */
public abstract class PantallaBase extends JPanel {

    protected JPanel contenido;

    public PantallaBase() {

        setLayout(new BorderLayout());
        setBackground(Colores.AZUL_CLARO);

        contenido = new PanelFormulario();

        add(contenido, BorderLayout.CENTER);
    }

    public JLabel titulo(String texto){

        JLabel lbl = new JLabel(texto, SwingConstants.CENTER);
        lbl.setFont(Fuentes.TITULO);
        lbl.setForeground(Colores.AZUL_OSCURO);

        return lbl;
    }

    public abstract void construir();
}
