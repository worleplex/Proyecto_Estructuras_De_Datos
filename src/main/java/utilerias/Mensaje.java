/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilerias;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Noelia E.N
 */
public class Mensaje {

    public static void info(Component c, String msg) {
        JOptionPane.showMessageDialog(c, msg, "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void error(Component c, String msg) {
        JOptionPane.showMessageDialog(c, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void exito(Component c, String msg) {
        JOptionPane.showMessageDialog(c, msg, "Éxito", JOptionPane.PLAIN_MESSAGE);
    }
}
