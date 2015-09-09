package Controladores;

import Vistas.FrmProductos;

/**
 * @author Ricardo Palacio P.
 */
public class ProductosPpal{

    public static void main(String[] args){
        new ProductosControlador(new FrmProductos()).iniciar();
    }
}
