
package conexionMysql;


import java.awt.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
//import java.sql.DriverManager;
//import java.sql.SQLException;
public class conector {
    private static Connection conectar=null;

    PreparedStatement ps=null;
    ResultSet RS = null;
    public Connection conexion(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar=DriverManager.getConnection("jdbc:mysql://localhost:3306/estudiantes", "root", "");  
//            JOptionPane.showMessageDialog(null, "Se ha conectado");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "No se ha podido conectar" +" "+ e.getMessage());
        }
        return conectar;
    }  
    
    
       


    
    
 }


  
