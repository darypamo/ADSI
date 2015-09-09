package Controladores;

import Vistas.FrmProductos;
import Vistas.FrmUsuarios;

/**
 * @author Ricardo Palacio P.
 */
public class UsuariosPpal{

    public static void main(String[] args){
        new UsuariosControlador(new FrmUsuarios()).iniciar();
    }
}
