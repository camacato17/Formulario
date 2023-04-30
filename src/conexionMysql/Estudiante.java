
package conexionMysql;

public class Estudiante {
    private int id;
    private String nombre1, nombre2;
    private String apellido1, apellido2;
    private int idMatricula;
    
    public static final String
        TABLA = "estudiante",
        ID = "id",
        NOMBRE1 = "nombre1",
        NOMBRE2 = "nombre2",
        APELLIDO1 = "apellido1",
        APELLIDO2 = "apellido2",
        ID_MATRICULA = "num_matricula";
    ;

    public Estudiante(String nombre1, String nombre2, String apellido1,String apellido2, int idMatricula) {
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.idMatricula = idMatricula;
    }

    public Estudiante(int id, String nombre1, String nombre2, String apellido1, String apellido2, int idMatricula) {
        this(nombre1, nombre2, apellido1, apellido2, idMatricula);
        this.id = id;
    }
    
    // <editor-fold  desc="Setters y Getters" defaultstate="collapsed">
    public int getId() {
        return id;
    }
    
    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public int getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(int idMatricula) {
        this.idMatricula = idMatricula;
    }
    // </editor-fold> 
}
