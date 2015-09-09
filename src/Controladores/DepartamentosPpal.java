/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Vistas.FrmDepartamentos;
import Vistas.FrmProductos;

/**
 *
 * @author DELL
 */
public class DepartamentosPpal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new DepartamentosControlador(new FrmDepartamentos()).iniciar();
    }
}
