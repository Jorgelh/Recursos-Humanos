/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EvaluacionDesempeñoSupervisores;

import EvaluacionDesempeñoOperativo.*;
import BD.BD;
import Clases.EvaluacionSupervisores.BDEvaluacionSupervisores;
import Clases.EvaluacionSupervisores.ClassEvaluacionSupervisores;
import static Formuarios.Inicio.Pane1;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author jluis
 */
public class TiposEvaluacionSupervisores extends javax.swing.JInternalFrame {

    int id_listaempleados;
    int id_evaluacion;
    int estado1;
    int estado2;
    int estado3;
    int estado4;
    int estado5;
    int estado6;
    int estado7;
    int estado8;
    int face;
    int no_evaluacion;
    String FechaProxima;
    ImageIcon iconobtn = new ImageIcon("1481834876_tick_16.png");

    /**
     * Creates new form TiposEvaluacion
     */
    public TiposEvaluacionSupervisores(int id) {
        this.id_evaluacion = id;
        initComponents();
        buscar();
        validarrealizadas();
        actualizarEstado();
    }

    private void actualizarEstado() {
        
            if (estado1 == 1 && estado2 == 1 && estado3 == 1 && estado4 == 1 && 
                estado5 == 1 && estado6 == 1 && estado7 == 1 && estado8 == 1) 
            {
            
            try {
            int meses = 4; 
            String FechaS = FECHA.getText();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
            Date fecha = sdf.parse(FechaS);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fecha); 
            calendar.add(Calendar.MONTH, meses);  
            FechaProxima = (sdf.format(calendar.getTime()));
                Connection con = BD.getConnection();
                Statement stmt = con.createStatement();
                Statement st = con.createStatement();
                ResultSet rs = stmt.executeQuery("update BEVALUACION_DESEMPENO set estado = 2 where id_evaluacion ="+id_evaluacion);
                ResultSet r = st.executeQuery("update BEVALUACION_DESEMPENO set estado = 1,fecha = '"+FechaProxima+"' where estado = 0 and id_listaempleados ="+id_listaempleados+"  and face = "+(face+1)+" and evaluacion =" + no_evaluacion);
                rs.close();
                r.close();
                stmt.close();
                st.close();
                con.close();
            } catch (SQLException error) {
               System.out.print(" ERROR QUE OBTIENE EL ULTIMO ID DE INGRESO  " + error );
            } catch (ParseException ex) {
                Logger.getLogger(TiposEvaluacionSupervisores.class.getName()).log(Level.SEVERE, null, ex);
            }
            } 
         //System.out.println("1 = "+FechaProxima+ "2 = "+id_listaempleados+" 3 = "+no_evaluacion+" FACE ="+(face+1));
    }

    private void buscar() {

        try {
            ClassEvaluacionSupervisores p = BDEvaluacionSupervisores.buscarEmpleadoIDEvaluacion(id_evaluacion);
            CODIGO.setText(String.valueOf(p.getCodigo()));
            NOMBRE.setText(p.getNombres() + ' ' + p.getApellidos());
            PUESTO.setText(p.getPuesto());
            DEPTO.setText(p.getDepto());
            FECHA.setText(p.getFechaS());
            FACE.setText(p.getFaceS());
            face = p.getFace();
            no_evaluacion = p.getNoEvaluacion();
            id_evaluacion = p.getId_evaluacion();
            id_listaempleados = p.getId_listaempleados();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL OBTENER EL EMPLEADO A EDITAR " + e);
        }
    }

    private void validarrealizadas() {

        try {
            Connection con = BD.getConnection();
            Statement stmt1 = con.createStatement();
            ResultSet rs1 = stmt1.executeQuery("select  COALESCE(sum(estado),0) as estado from dtrabajo_equipo where id_evaluacion = " + id_evaluacion);
            rs1.next();
            int c1 = rs1.getInt("estado");
            if (c1 == 1) {
                trabajoEquipo.setIcon(iconobtn);
                estado1 = 1;
            }

            Statement stmt2 = con.createStatement();
            ResultSet rs2 = stmt2.executeQuery("select  COALESCE(sum(estado),0) as estado from borientacion where id_evaluacion = " + id_evaluacion);
            Statement stmt3 = con.createStatement();
            rs2.next();
            int c2 = rs2.getInt("estado");
            if (c2 == 1) {
                orientacionResultados.setIcon(iconobtn);
                estado2 = 1;
            }

            ResultSet rs3 = stmt3.executeQuery("select  COALESCE(sum(estado),0) as estado from eorganizacion where id_evaluacion = " + id_evaluacion);
            Statement stmt4 = con.createStatement();
            rs3.next();
            int c3 = rs3.getInt("estado");
            if (c3 == 1) {
                Organizacion.setIcon(iconobtn);
                estado3 = 1;
            }

            ResultSet rs4 = stmt4.executeQuery("select  COALESCE(sum(estado),0) as estado from gresponsabilidad where id_evaluacion = " + id_evaluacion);
            rs4.next();
            int c4 = rs4.getInt("estado");
            if (c4 == 1) {
                responsabilidad.setIcon(iconobtn);
                estado4 = 1;
            }
          actualizarEstado();
        } catch (Exception e) {
            System.out.println("ERROR " + e);
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

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        trabajoEquipo = new javax.swing.JButton();
        Organizacion = new javax.swing.JButton();
        orientacionResultados = new javax.swing.JButton();
        responsabilidad = new javax.swing.JButton();
        trabajoEquipo1 = new javax.swing.JButton();
        responsabilidad1 = new javax.swing.JButton();
        Organizacion1 = new javax.swing.JButton();
        orientacionResultados1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        CODIGO = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        NOMBRE = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        PUESTO = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        FECHA = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        FACE = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        DEPTO = new javax.swing.JTextField();

        jLabel3.setText("jLabel3");

        setClosable(true);
        setTitle("EVALUACION DE DESEMPEÑO");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
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

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));

        trabajoEquipo.setText("1. Planificacion");
        trabajoEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trabajoEquipoActionPerformed(evt);
            }
        });

        Organizacion.setText("5. Organización");
        Organizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrganizacionActionPerformed(evt);
            }
        });

        orientacionResultados.setText("6. Liderazgo");
        orientacionResultados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orientacionResultadosActionPerformed(evt);
            }
        });

        responsabilidad.setText("2. Orientacion a Resultados");
        responsabilidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                responsabilidadActionPerformed(evt);
            }
        });

        trabajoEquipo1.setText("3. Resolucion de Conflictos");
        trabajoEquipo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trabajoEquipo1ActionPerformed(evt);
            }
        });

        responsabilidad1.setText("4. Trabajo en Equipo");
        responsabilidad1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                responsabilidad1ActionPerformed(evt);
            }
        });

        Organizacion1.setText("8. Iniciativa");
        Organizacion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Organizacion1ActionPerformed(evt);
            }
        });

        orientacionResultados1.setText("7. Responsabilidad");
        orientacionResultados1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orientacionResultados1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(trabajoEquipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(responsabilidad, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addComponent(trabajoEquipo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(responsabilidad1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Organizacion1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(orientacionResultados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(orientacionResultados1, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
                    .addComponent(Organizacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 24, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(trabajoEquipo)
                    .addComponent(Organizacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(responsabilidad)
                    .addComponent(orientacionResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(trabajoEquipo1)
                    .addComponent(orientacionResultados1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(responsabilidad1)
                    .addComponent(Organizacion1))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jLabel1.setText("CODIGO:");

        CODIGO.setEditable(false);

        jLabel2.setText("NOMBRE:");

        NOMBRE.setEditable(false);

        jLabel4.setText("PUESTO:");

        PUESTO.setEditable(false);
        PUESTO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PUESTOActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NOMBRE)
                    .addComponent(CODIGO)
                    .addComponent(PUESTO)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(0, 197, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(4, 4, 4)
                .addComponent(NOMBRE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PUESTO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setText("FECHA:");

        FECHA.setEditable(false);

        jLabel7.setText("FASE:");

        FACE.setEditable(false);

        jLabel5.setText("DEPARTAMENTO:");

        DEPTO.setEditable(false);
        DEPTO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DEPTOActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FECHA)
                    .addComponent(FACE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(0, 162, Short.MAX_VALUE))
                    .addComponent(DEPTO))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DEPTO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FECHA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FACE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void trabajoEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trabajoEquipoActionPerformed

        if (estado1 == 0){
            aEvaluacionTrabajoEnEquipo ma = new aEvaluacionTrabajoEnEquipo(id_evaluacion, Integer.parseInt(CODIGO.getText()));
            Pane1.add(ma);
            Dimension desktopSize = Pane1.getSize();
            Dimension FrameSize = ma.getSize();
            ma.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
            ma.show();
            this.dispose();
        }
    }//GEN-LAST:event_trabajoEquipoActionPerformed

    private void OrganizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrganizacionActionPerformed
        if (estado3 == 0){
            
            cEvaluacionOrganizacion ma = new cEvaluacionOrganizacion(id_evaluacion,Integer.parseInt(CODIGO.getText()));
            Pane1.add(ma);
            Dimension desktopSize = Pane1.getSize();
            Dimension FrameSize = ma.getSize();
            ma.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
            ma.show();
            this.dispose();
        }
    }//GEN-LAST:event_OrganizacionActionPerformed

    private void orientacionResultadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orientacionResultadosActionPerformed
        if (estado2 == 0){
            bEvaluacionOrientacionAresultados ma = new bEvaluacionOrientacionAresultados(id_evaluacion,Integer.parseInt(CODIGO.getText()));
            Pane1.add(ma);
            Dimension desktopSize = Pane1.getSize();
            Dimension FrameSize = ma.getSize();
            ma.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
            ma.show();
            this.dispose();
        }
       
    }//GEN-LAST:event_orientacionResultadosActionPerformed

    private void responsabilidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_responsabilidadActionPerformed
        if (estado4 == 0){
            dEvaluacionResponsabilidad ma = new dEvaluacionResponsabilidad(id_evaluacion,Integer.parseInt(CODIGO.getText()));
            Pane1.add(ma);
            Dimension desktopSize = Pane1.getSize();
            Dimension FrameSize = ma.getSize();
            ma.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
            ma.show();
            this.dispose();
        }
    }//GEN-LAST:event_responsabilidadActionPerformed

    private void DEPTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DEPTOActionPerformed
       
        
    }//GEN-LAST:event_DEPTOActionPerformed

    private void PUESTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PUESTOActionPerformed
        
        
    }//GEN-LAST:event_PUESTOActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        InicioEvaluacioOperativos tra = new InicioEvaluacioOperativos();
        Pane1.add(tra);
        Dimension desktopSize = Pane1.getSize();
        Dimension FrameSize = tra.getSize();
        tra.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        tra.show();       
    }//GEN-LAST:event_formInternalFrameClosing

    private void trabajoEquipo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trabajoEquipo1ActionPerformed
        
        
    }//GEN-LAST:event_trabajoEquipo1ActionPerformed

    private void responsabilidad1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_responsabilidad1ActionPerformed
       
        
    }//GEN-LAST:event_responsabilidad1ActionPerformed

    private void Organizacion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Organizacion1ActionPerformed
        
        
    }//GEN-LAST:event_Organizacion1ActionPerformed

    private void orientacionResultados1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orientacionResultados1ActionPerformed
        
        
    }//GEN-LAST:event_orientacionResultados1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CODIGO;
    private javax.swing.JTextField DEPTO;
    private javax.swing.JTextField FACE;
    private javax.swing.JTextField FECHA;
    private javax.swing.JTextField NOMBRE;
    private javax.swing.JButton Organizacion;
    private javax.swing.JButton Organizacion1;
    private javax.swing.JTextField PUESTO;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton orientacionResultados;
    private javax.swing.JButton orientacionResultados1;
    private javax.swing.JButton responsabilidad;
    private javax.swing.JButton responsabilidad1;
    private javax.swing.JButton trabajoEquipo;
    private javax.swing.JButton trabajoEquipo1;
    // End of variables declaration//GEN-END:variables
}
