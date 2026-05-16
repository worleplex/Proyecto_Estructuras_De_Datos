/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilerias;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;

/**
 *
 * @author Noelia E.N
 */
public class Boton extends JButton {

    public Boton(String texto) {
        super(texto);

        setFont(Fuentes.BOTON);
        setBackground(Colores.AZUL_MEDIO);
        setForeground(Colores.BLANCO);
        setPreferredSize(new Dimension(150, 45));

        setFocusPainted(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}
