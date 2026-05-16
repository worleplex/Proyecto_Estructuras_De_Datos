/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilerias;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Noelia E.N
 */
public class Tabla extends JTable {

    public Tabla() {

        setFont(Fuentes.TEXTO);
        setRowHeight(28);

        JTableHeader header = getTableHeader();
        header.setFont(Fuentes.SUBTITULO);
    }
}