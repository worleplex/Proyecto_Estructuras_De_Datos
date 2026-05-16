/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package Main;

import UI.Menu.UIMenuInicio;
import persistencia.PersistenciaFachada;

/**
 *
 * @author julia
 */
public class Main {

    public static void main(String[] args) {

        PersistenciaFachada persistencia = new PersistenciaFachada();

        UIMenuInicio menu = new UIMenu(persistencia);

        menu.mostrarMenu();
    }
}
