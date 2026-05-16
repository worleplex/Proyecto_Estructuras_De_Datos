/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilerias;

import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author Noelia E.N.
 */
public class PanelFormulario extends JPanel {

    public PanelFormulario() {

        setLayout(new GridLayout(0, 2, 15, 15));
        setBackground(Colores.BLANCO);

        setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
    }
}
