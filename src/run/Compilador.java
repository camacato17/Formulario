
package run;
import Interfaz.Diseño;
import conexionMysql.conector;
import java.sql.*;
import Interfaz.INSERTAR;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
public class Compilador {
    public void conecion(){
//         conector c = new conector();
//        c.conexion();
        Interfaz.INSERTAR.obtenerDatos();
    }
    
    public static void main(String[] args) {
        
        Diseño i =new Diseño();
        i.setVisible(true);
        i.setSize(1200, 680);
        i.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        
        
    }
}
