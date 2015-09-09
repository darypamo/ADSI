/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Vistas.FrmMpios;

/**
 *
 * @author DELL
 */
public class MpiosPpal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new MpiosControlador(new FrmMpios()).iniciar();
    }
}
