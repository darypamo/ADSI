/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Vistas.FrmValidar;

/**
 *
 * @author DELL
 */
public class ValidarPpal {

    /**
     * @param args the command line arguments
     */
    public void main(String[] args) {
        // TODO code application logic here
        iniciar();
    }
    
    public void iniciar(){
        new ValidarControlador(new FrmValidar()).iniciar();
    }
}
