/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilerias;

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
        setFont(new Font("Segoe UI", Font.BOLD, 15));
        setFocusPainted(false);
        setBackground(Colores.AZUL_MEDIO);
        setForeground(Colores.BLANCO);
        setPreferredSize(new Dimension(150, 45));
    }
}
