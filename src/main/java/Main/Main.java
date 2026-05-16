/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package Main;

import Frames.FrmMenuPrincipal;
import persistencia.PersistenciaFachada;

/**
 *
 * @author julia
 */
public class Main {

    public static void main(String[] args) {

        new FrmMenuPrincipal(new PersistenciaFachada());
    }
}