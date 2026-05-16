/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilerias;

import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JTextField;

/**
 *
 * @author Noelia E.N
 */
public class CampoTexto extends JTextField {

    public CampoTexto() {
        setFont(new Font("Segoe UI", Font.PLAIN, 16));
        setBorder(BorderFactory.createEmptyBorder(8, 10, 8, 10));
    }
}
