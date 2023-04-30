
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

import java.util.ArrayList;

public class Conexion { 
    private Connection conexion =  null;
    private Statement ControladorSQL;
    
    private static final String stmtInsertar = "INSERT INTO estudiante (nombre1,nombre2,apellido1,apellido2,fecha_nacimiento,n_matricula) VALUES (?,?,?,?,?,?)";
    private static final String stmtBorrar = "DELETE FROM estudiante WHERE id = ?";
    private static final String stmtModificar ="UPDATE estudiante SET nombre1=?,nombre2=?,apellido1=?,apellido2=?, fecha_nacimiento=?, n_matricula=? WHERE id=?";
    
    private static final String queryRelacion = "SELECT estudiante.id, matricula.n_matricula FROM estudiantes INNER JOIN matricula ON estudiante.n_matricula=matricula.n_matricula";
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
        
        PreparedStatement ps =   conexion.prepareStatement(stmtInsertar);
        System.out.println(ps.toString());
        ps.setString(1, e.getNombre1());
        ps.setString(2, e.getNombre2());
        ps.setString(3, e.getApellido1());
        ps.setString(4, e.getApellido2());
        ps.setString(6, e.getFechaNacimiento());
        ps.setInt(5, e.getIdMatricula());
        ps.execute();
    }
    public void modificarEstudiante(Estudiante e) throws SQLException{
        PreparedStatement ps =   conexion.prepareStatement(stmtModificar);
        System.out.println(ps.toString());
        ps.setString(1, e.getNombre1());
        ps.setString(2, e.getNombre2());
        ps.setString(3, e.getApellido1());
        ps.setString(4, e.getApellido2());
        ps.setString(5, e.getFechaNacimiento());
        ps.setInt(6, e.getIdMatricula());
        ps.setInt(7,e.getId());
        ps.execute();
        
    }
    public void eliminarEstudiante(Estudiante e) throws SQLException {
        
        PreparedStatement ps =   conexion.prepareStatement(stmtBorrar);
        ps.setInt(1, e.getId());
        System.out.println(ps.toString());
        ps.execute();
    }
    public ArrayList<Estudiante> obtenerEstudiantes() throws SQLException{
        
        ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();
        Statement stmt = conexion.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM estudiante");
        while (rs.next()) {
            Estudiante e=new Estudiante(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                rs.getDate(6).toString(),
                rs.getInt(7)
            );
            listaEstudiantes.add(e);
        }
        return listaEstudiantes;
    }
    
    public ArrayList<Matricula> obtenerMatriculas() throws SQLException{
        ArrayList<Matricula> listaMatriculas = new ArrayList<>();
        Statement stmt = conexion.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM matricula");
        while (rs.next()) {
            Matricula e=new Matricula(
                rs.getInt(1),
                rs.getDate(2).toString()
            );
            listaMatriculas.add(e);
        }
        return listaMatriculas;
    }
    public String[] obtenerDatosTabla(ArrayList<Estudiante> listaEstudiantes, ArrayList<Matricula> listaMatriculas) throws SQLException{
        String[] datos= new String[4];
        Statement stmt = conexion.createStatement();
        ResultSet rs = stmt.executeQuery(queryRelacion);
        
        while (rs.next()) {
            int idEstudianteQ = rs.getInt(1);
            int idMatriculaQ = rs.getInt(2);
            Estudiante e = listaEstudiantes.stream()
                                    .filter(estudiante -> estudiante.getId() == idEstudianteQ)
                                    .findFirst()
                                    .orElse(null);
            Matricula m = listaMatriculas.stream()
                                    .filter(matricula -> matricula.getNumero()== idMatriculaQ)
                                    .findFirst()
                                    .orElse(null);
            
            if (e==null || m==null) continue;
            
            datos[0] = String.format("%s %s", e.getNombre1(),e.getNombre2());
            datos[1] = String.format("%s %s", e.getApellido1(),e.getApellido2());
            datos[2] = e.getFechaNacimiento();
            datos[3] = m.getFecha();
        }
        
        return datos;
    }
}
