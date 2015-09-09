
package Controladores;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ricardo Palacio P.
 */
public class MiModelo extends DefaultTableModel
{
   @Override
   public boolean isCellEditable (int row, int column)
   {
//       if (column == 3)
//          return true;
       return false;
   }
}
