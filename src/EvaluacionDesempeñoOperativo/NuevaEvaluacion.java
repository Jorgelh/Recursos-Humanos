/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EvaluacionDesempeñoOperativo;

import BD.BD;
import Clases.Evaluacion.BDEvaluacion;
import Clases.Evaluacion.ClassEvaluacion;
import static Formuarios.Inicio.Pane1;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author jluis
 */
public class NuevaEvaluacion extends javax.swing.JInternalFrame {

    int idlistaempleado;
    int face = 1;
    int codigo;
    int año;
    int evaluacion;

    /**
     * Creates new form NuevaEvaluacion
     */
    public NuevaEvaluacion() {
        initComponents();
    }

    private void buscar() {

        try {
            ClassEvaluacion p = BDEvaluacion.buscarEmpleado(Integer.parseInt(CODIGO.getText()));
            nombre.setText(p.getNombres() + ' ' + p.getApellidos());
            PUESTO.setText(p.getPuesto());
            DEPTO.setText(p.getDepto());
            idlistaempleado = p.getId_listaempleados();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRORRRR" + e);
        }
    }

    private void next() {

        BuscarCodigo tra = new BuscarCodigo();
        Pane1.add(tra);
        Dimension desktopSize = Pane1.getSize();
        Dimension FrameSize = tra.getSize();
        tra.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        tra.show();
        try {
            this.dispose();
        } catch (Exception e) {
            System.out.println("F " + e);
        }

    }

    private void ValidarExistencia() {

        try {

            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select COUNT(codigo) from alistaempleados where codigo=" + CODIGO.getText());
            rs.next();
            int c = rs.getInt("count(codigo)");
            if (CODIGO.getText() == "") {
                JOptionPane.showMessageDialog(null, "INGRESE EL CODIGO");
            } else if (c == 1) {
                buscar();
                fechaEvaluacion.setEnabled(true);
                nuevo.setEnabled(true);
                guardar.setEnabled(true);
                fechaEvaluacion.requestFocus();
            } else {
                JOptionPane.showMessageDialog(null, "EL CODIGO EMPLEADO NO EXITE INTENTE DE NUEVO...");
            }

        } catch (Exception e) {
            System.out.println("ERROR " + e);
        }

    }

/*    private void ValidarExistenciaFaceporAño() {

        
        try {
            if (fechaEvaluacion.getDate() != null && face != 0 && CODIGO.getText().compareTo("") != 0) {
                Date date = fechaEvaluacion.getDate();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
                String fecha = sdf.format(date);
                Connection con = BD.getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select COUNT(codigo) as cantidaFace from alistaempleados e inner join bevaluacion_desempeno d on e.id_listaempleados = d.id_listaempleados where e.codigo = " + CODIGO.getText() + " and d.face = " + face + " and TO_CHAR(d.fecha,'yyyy') = '" + fecha + "'");
                rs.next();
                int c = rs.getInt("cantidaFace");
                if (c == 1) {
                    JOptionPane.showMessageDialog(null, "LA FACE No. " + face + " PARA EL AÑO = " + fecha + " YA FUE CREADA");
                } else {
                    guardarEvaluacion();
                }
            } else {
                JOptionPane.showMessageDialog(null, "LLENE TODOS LOS DATOS");
            }

        } catch (Exception e) {
            System.out.println("ERROR " + e);
        }

    }*/
    
    private void ValidarNodeEvaluacion() {

        
        try {
            
                Connection con = BD.getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select max(d.evaluacion) evaluacion from alistaempleados e inner join bevaluacion_desempeno d on e.id_listaempleados = d.id_listaempleados where e.codigo ="+CODIGO.getText());
                rs.next();
                int c = rs.getInt("evaluacion");
                evaluacion = c+1;
                
        } catch (Exception e) {
            System.out.println("ERROR " + e);
        }

    }
    
    

    private void limpiar() {
        CODIGO.setText("");
        nombre.setText("");
        PUESTO.setText("");
        DEPTO.setText("");
        fechaEvaluacion.setDate(null);
        fechaEvaluacion.setEnabled(false);
        nuevo.setEnabled(false);
        guardar.setEnabled(false);
        CODIGO.requestFocus();

    }
    
   

    private void guardarEvaluacion() {
        try {
            ValidarNodeEvaluacion();
            ClassEvaluacion l = new ClassEvaluacion();
            l.setId_listaempleados(idlistaempleado);
            l.setFace(face);
            l.setFecha(fechaEvaluacion.getDate());
            l.setNoEvaluacion(evaluacion);
            Clases.Evaluacion.BDEvaluacion.insertarEvaluacion(l);
            JOptionPane.showMessageDialog(null, "EVALUACION ASIGNADA");
            crearEvaluaciones();
            this.dispose();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR INGRESO EMPLEADOS" + e);
        }
    }

    
    public void crearEvaluaciones(){
        
         Date date = fechaEvaluacion.getDate();
         SimpleDateFormat sdf = new SimpleDateFormat("d/MM/yyyy");
         String fecha = sdf.format(date);
        try {
            Connection c = BD.getConnection();
            Statement ps = c.createStatement();
            ps.executeUpdate("BEGIN CREAREVALUACIONES(NID_EMPLEADO=>"+idlistaempleado+",NFECHA=>'"+fecha+"',NEVALUACION=>"+evaluacion+"); COMMIT; END;");
            c.close();
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error"+e);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        CODIGO = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        DEPTO = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        PUESTO = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        fechaEvaluacion = new com.toedter.calendar.JDateChooser();
        guardar = new javax.swing.JButton();
        nuevo = new javax.swing.JButton();

        setClosable(true);
        setTitle("INGRESO NUEVA EVALUACION");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("CODIGO DEL EMPLEADO");

        CODIGO.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        CODIGO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CODIGOActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS DEL EMPLEADO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("NOMBRE");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("DEPARTAMENTO");

        nombre.setEditable(false);
        nombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        DEPTO.setEditable(false);
        DEPTO.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("PUESTO");

        PUESTO.setEditable(false);
        PUESTO.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DEPTO)
                    .addComponent(nombre)
                    .addComponent(PUESTO)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(0, 278, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PUESTO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DEPTO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("FECHA ");

        fechaEvaluacion.setEnabled(false);
        fechaEvaluacion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save2.png"))); // NOI18N
        guardar.setText("GUARDAR");
        guardar.setEnabled(false);
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/New.png"))); // NOI18N
        nuevo.setText("NUEVO");
        nuevo.setEnabled(false);
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(CODIGO, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(90, 90, 90)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(guardar)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(nuevo))
                                        .addComponent(fechaEvaluacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(94, 94, 94))))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fechaEvaluacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        //ValidarExistenciaFaceporAño();
        guardarEvaluacion();
    }//GEN-LAST:event_guardarActionPerformed

    private void CODIGOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CODIGOActionPerformed
        ValidarExistencia();
    }//GEN-LAST:event_CODIGOActionPerformed

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
        limpiar();
    }//GEN-LAST:event_nuevoActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        InicioEvaluacioOperativos tra = new InicioEvaluacioOperativos();
        Pane1.add(tra);
        Dimension desktopSize = Pane1.getSize();
        Dimension FrameSize = tra.getSize();
        tra.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        tra.show();

    }//GEN-LAST:event_formInternalFrameClosing

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        InicioEvaluacioOperativos tra = new InicioEvaluacioOperativos();
        Pane1.add(tra);
        Dimension desktopSize = Pane1.getSize();
        Dimension FrameSize = tra.getSize();
        tra.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        tra.show();
    }//GEN-LAST:event_formInternalFrameClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CODIGO;
    private javax.swing.JTextField DEPTO;
    private javax.swing.JTextField PUESTO;
    private com.toedter.calendar.JDateChooser fechaEvaluacion;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField nombre;
    private javax.swing.JButton nuevo;
    // End of variables declaration//GEN-END:variables
}
