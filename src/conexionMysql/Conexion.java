
package conexionMysql;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion { 
    private Connection conexion =  null;
    private Statement ControladorSQL;
    
    private static final String queryInsertar = String.format("INSERT INTO %s (%s,%s,%s,%s,%s) VALUES (?,?,?,?,?)",
            Estudiante.TABLA,
            Estudiante.NOMBRE1,
            Estudiante.NOMBRE2,
            Estudiante.APELLIDO1,
            Estudiante.APELLIDO2,
            Estudiante.ID_MATRICULA
    );
    private static final String queryBorrar = String.format("DELETE FROM %s WHERE %s = ?",
            Estudiante.TABLA,
            Estudiante.ID
    );
    
    private static final String queryModificar = String.format("UPDATE %s SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ? WHERE %s = ?",
            Estudiante.TABLA,
            Estudiante.NOMBRE1,
            Estudiante.NOMBRE2,
            Estudiante.APELLIDO1,
            Estudiante.APELLIDO2,
            Estudiante.ID_MATRICULA,
            Estudiante.ID
    );
    
    public Conexion(){
        
    }
    public Conexion(String url, String bd, String usuario, String clave) {
        if (!url.endsWith("/")) url+="/";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url+bd,usuario,clave);
            ControladorSQL = conexion.createStatement();
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.WARNING, null, ex);
        }
    }
    public void InsertarEstudiante(Estudiante e) throws SQLException {
        
        PreparedStatement ps =   conexion.prepareStatement(queryInsertar);
        System.out.println(ps.toString());
        ps.setString(1, e.getNombre1());
        ps.setString(2, e.getNombre2());
        ps.setString(3, e.getApellido1());
        ps.setString(4, e.getApellido2());
        ps.setInt(5, e.getIdMatricula());
        ps.execute();
    }
    public void modificarEstudiante(Estudiante e) throws SQLException{
        PreparedStatement ps =   conexion.prepareStatement(queryModificar);
        System.out.println(ps.toString());
        ps.setString(1, e.getNombre1());
        ps.setString(2, e.getNombre2());
        ps.setString(3, e.getApellido1());
        ps.setString(4, e.getApellido2());
        ps.setInt(5, e.getIdMatricula());
        ps.setInt(6,e.getId());
        ps.execute();
        
    }
    public void eliminarEstudiante(Estudiante e) throws SQLException {
        
        PreparedStatement ps =   conexion.prepareStatement(queryBorrar);
        ps.setInt(1, e.getId());
        System.out.println(ps.toString());
        ps.execute();
    }
    
    
}
