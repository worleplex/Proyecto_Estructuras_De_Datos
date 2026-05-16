/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilerias;

import java.awt.Font;
import javax.swing.JTable;

/**
 *
 * @author Noelia E.N
 */
public class Tabla extends JTable {

    public Tabla() {
        setRowHeight(30);
        setFont(new Font("Segoe UI", Font.PLAIN, 14));

        getTableHeader().setFont(
                new Font("Segoe UI", Font.BOLD, 15)
        );
    }
}
