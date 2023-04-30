package conexionMysql;

public class Matricula {
    int numero;
    String fecha;

    public Matricula(String fecha) {
        this.fecha = fecha;
    }

    public Matricula(int numero, String fecha) {
        this.numero = numero;
        this.fecha = fecha;
    }
    
    // <editor-fold  desc="Setters y Getters" defaultstate="collapsed">
    public int getNumero() {
        return numero;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    // </editor-fold>

}
