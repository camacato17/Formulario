/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Interfaz;

import conexionMysql.conector;
import conexionMysql.conector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.crypto.AEADBadTagException;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author LUIS
 */
public class INSERTAR extends javax.swing.JPanel {

    private static Connection conectar=null;
    PreparedStatement ps=null;
    ResultSet RS = null;
    public INSERTAR() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setLayout(null);

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel1.setText("INSERTAR");
        add(jLabel1);
        jLabel1.setBounds(330, 20, 100, 50);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        add(jTextField1);
        jTextField1.setBounds(170, 100, 90, 28);
        add(jTextField2);
        jTextField2.setBounds(170, 180, 100, 28);
        add(jTextField3);
        jTextField3.setBounds(320, 100, 90, 28);
        add(jTextField4);
        jTextField4.setBounds(310, 180, 100, 28);
        add(jTextField5);
        jTextField5.setBounds(470, 140, 120, 28);

        jLabel2.setText("Primer_nombre");
        add(jLabel2);
        jLabel2.setBounds(170, 80, 100, 16);

        jLabel3.setText("Segundo_nombre");
        add(jLabel3);
        jLabel3.setBounds(170, 160, 100, 16);

        jLabel4.setText("Primer Apellido");
        add(jLabel4);
        jLabel4.setBounds(320, 80, 100, 16);

        jLabel5.setText("Segundo Apellido");
        add(jLabel5);
        jLabel5.setBounds(310, 160, 100, 16);

        jLabel6.setText("Fecha Nacimiento");
        add(jLabel6);
        jLabel6.setBounds(480, 120, 100, 16);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "             Id", "Primer Nombre", "Segundo Nombre", "Primer Apellido", "Segundo Apellido", "Fecha Nacimiento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1);
        jScrollPane1.setBounds(30, 240, 720, 406);

        jButton1.setText("Insertar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(650, 130, 70, 28);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        obtenerDatos();
    }//GEN-LAST:event_jButton1ActionPerformed
     public static void obtenerDatos() {
            conector c= new conector();
            Connection conector = c.conexion();
            String sql = "SELECT * form estudiantes;";
            Statement stmt;
            DefaultTableModel  model = new DefaultTableModel();
             model.addColumn("id");
             model.addColumn("nombre1");
             model.addColumn("nombre2");
             model.addColumn("apellido");
             model.addColumn("apellido2");
             model.addColumn("fecha_nacimiento");
             jTable1.setModel(model);
            String[] datos= new String[6];
        try {
            stmt = conector.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM estudiantes1;");
            while (rs.next()) {
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5);
                datos[5]=rs.getDate(6).toString();
                model.addRow(datos);
            }
            conector.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ;
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
