/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EvaluacionDesempeñoSupervisores;

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
                
            /*
            int meses = 4; 
            String FechaS = FECHA.getText();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
            Date fecha = sdf.parse(FechaS);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fecha); 
            calendar.add(Calendar.MONTH, meses);  
            FechaProxima = (sdf.format(calendar.getTime()));
            */
             int meses = 4;
                Date date = fechaF.getDate();
                SimpleDateFormat sdf = new SimpleDateFormat("d/MM/yyyy");
                String fecha = sdf.format(date);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
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
            }
            } 
         //System.out.println("1 = "+FechaProxima+ "2 = "+id_listaempleados+" 3 = "+no_evaluacion+" FACE ="+(face+1));
    }

    private void buscar() {

        try {
            ClassEvaluacionSupervisores p = BDEvaluacionSupervisores.buscarEmpleadoIDEvaluacionSuper(id_evaluacion);
            CODIGO.setText(String.valueOf(p.getCodigo()));
            NOMBRE.setText(p.getNombres()); // + ' ' + p.getApellidos());
            PUESTO.setText(p.getPuesto());
            DEPTO.setText(p.getDepto());
            SimpleDateFormat sdf = new SimpleDateFormat("MMMMM-dd-yyyy");
            Date datenaci = sdf.parse(p.getFechaS());
            fechaF.setDate(datenaci);
            
            //FECHA.setText(p.getFechaS());
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
            ResultSet rs1 = stmt1.executeQuery("select  COALESCE(sum(estado),0) as estado from APLANIFICACION where id_evaluacion = " + id_evaluacion);
            rs1.next();
            int c1 = rs1.getInt("estado");
            if (c1 == 1) {
                planificacion.setIcon(iconobtn);
                estado1 = 1;
            }

            Statement stmt2 = con.createStatement();
            ResultSet rs2 = stmt2.executeQuery("select  COALESCE(sum(estado),0) as estado from borientacion where id_evaluacion = " + id_evaluacion);
            rs2.next();
            int c2 = rs2.getInt("estado");
            if (c2 == 1) {
                OrientaResultados.setIcon(iconobtn);
                estado2 = 1;
            }
            Statement stmt3 = con.createStatement();
            ResultSet rs3 = stmt3.executeQuery("select  COALESCE(sum(estado),0) as estado from CRESOLUCION_CONFLICTOS where id_evaluacion = " + id_evaluacion);
            rs3.next();
            int c3 = rs3.getInt("estado");
            if (c3 == 1) {
                ResolucionConflictos.setIcon(iconobtn);
                estado3 = 1;
            }
            Statement stmt4 = con.createStatement();
            ResultSet rs4 = stmt4.executeQuery("select  COALESCE(sum(estado),0) as estado from DTRABAJO_EQUIPO where id_evaluacion = " + id_evaluacion);
            rs4.next();
            int c4 = rs4.getInt("estado");
            if (c4 == 1) {
                TrabajoEquipo.setIcon(iconobtn);
                estado4 = 1;
            }
            Statement stmt5 = con.createStatement();
            ResultSet rs5 = stmt5.executeQuery("select  COALESCE(sum(estado),0) as estado from EORGANIZACION where id_evaluacion = " + id_evaluacion);
            rs5.next();
            int c5 = rs5.getInt("estado");
            if (c5 == 1) {
                Organizacion.setIcon(iconobtn);
                estado5 = 1;
            }
            Statement stmt6 = con.createStatement();
            ResultSet rs6 = stmt6.executeQuery("select  COALESCE(sum(estado),0) as estado from FLIDERAZGO where id_evaluacion = " + id_evaluacion);
            rs6.next();
            int c6 = rs6.getInt("estado");
            if (c6 == 1) {
                Liderazgo.setIcon(iconobtn);
                estado6 = 1;
            }
            Statement stmt7 = con.createStatement();
            ResultSet rs7 = stmt7.executeQuery("select  COALESCE(sum(estado),0) as estado from gresponsabilidad where id_evaluacion = " + id_evaluacion);
            rs7.next();
            int c7 = rs7.getInt("estado");
            if (c7 == 1) {
                Responsabilidad.setIcon(iconobtn);
                estado7 = 1;
            }
            Statement stmt8 = con.createStatement();
            ResultSet rs8 = stmt8.executeQuery("select  COALESCE(sum(estado),0) as estado from HINICIATIVA where id_evaluacion = " + id_evaluacion);
            rs8.next();
            int c8 = rs8.getInt("estado");
            if (c8 == 1) {
                Iniciativa.setIcon(iconobtn);
                estado8 = 1;
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
        planificacion = new javax.swing.JButton();
        Organizacion = new javax.swing.JButton();
        Liderazgo = new javax.swing.JButton();
        OrientaResultados = new javax.swing.JButton();
        ResolucionConflictos = new javax.swing.JButton();
        TrabajoEquipo = new javax.swing.JButton();
        Iniciativa = new javax.swing.JButton();
        Responsabilidad = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        CODIGO = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        NOMBRE = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        PUESTO = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        FACE = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        DEPTO = new javax.swing.JTextField();
        fechaF = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();

        jLabel3.setText("jLabel3");

        setClosable(true);
        setTitle("EVALUACION DE DESEMPEÑO SUPERVISORES");
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

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));

        planificacion.setText("1. Planificacion");
        planificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                planificacionActionPerformed(evt);
            }
        });

        Organizacion.setText("5. Organización");
        Organizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrganizacionActionPerformed(evt);
            }
        });

        Liderazgo.setText("6. Liderazgo");
        Liderazgo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LiderazgoActionPerformed(evt);
            }
        });

        OrientaResultados.setText("2. Orientacion a Resultados");
        OrientaResultados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrientaResultadosActionPerformed(evt);
            }
        });

        ResolucionConflictos.setText("3. Resolucion de Conflictos");
        ResolucionConflictos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResolucionConflictosActionPerformed(evt);
            }
        });

        TrabajoEquipo.setText("4. Trabajo en Equipo");
        TrabajoEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TrabajoEquipoActionPerformed(evt);
            }
        });

        Iniciativa.setText("8. Iniciativa");
        Iniciativa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IniciativaActionPerformed(evt);
            }
        });

        Responsabilidad.setText("7. Responsabilidad");
        Responsabilidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResponsabilidadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(planificacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(OrientaResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(ResolucionConflictos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TrabajoEquipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Iniciativa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Responsabilidad, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
                        .addComponent(Organizacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Liderazgo, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 15, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(planificacion)
                    .addComponent(Organizacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(OrientaResultados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Liderazgo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ResolucionConflictos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Responsabilidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TrabajoEquipo)
                    .addComponent(Iniciativa))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("CODIGO:");

        CODIGO.setEditable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("NOMBRE:");

        NOMBRE.setEditable(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
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
                        .addGap(0, 240, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NOMBRE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PUESTO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("FECHA:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("FASE:");

        FACE.setEditable(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("DEPARTAMENTO:");

        DEPTO.setEditable(false);
        DEPTO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DEPTOActionPerformed(evt);
            }
        });

        fechaF.setDateFormatString("MMMMM-dd-yyyy");
        fechaF.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FACE)
                    .addComponent(DEPTO)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(fechaF, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DEPTO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fechaF, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FACE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setText("SALIR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(280, 280, 280)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(26, Short.MAX_VALUE))
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

    private void planificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_planificacionActionPerformed

        if (estado1 == 0){
            aEvaluacionPlanificacion ma = new aEvaluacionPlanificacion(id_evaluacion, Integer.parseInt(CODIGO.getText()));
            Pane1.add(ma);
            Dimension desktopSize = Pane1.getSize();
            Dimension FrameSize = ma.getSize();
            ma.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
            ma.show();
            this.dispose();
        }
    }//GEN-LAST:event_planificacionActionPerformed

    private void OrganizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrganizacionActionPerformed
          System.out.println("estado = "+estado5);        
        if (estado5 == 0){
            
            eEvaluacionOrganizacion ma = new eEvaluacionOrganizacion(id_evaluacion,Integer.parseInt(CODIGO.getText()));
            Pane1.add(ma);
            Dimension desktopSize = Pane1.getSize();
            Dimension FrameSize = ma.getSize();
            ma.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
            ma.show();
            this.dispose();
        }
    }//GEN-LAST:event_OrganizacionActionPerformed

    private void LiderazgoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LiderazgoActionPerformed
        if (estado6 == 0){
            fEvaluacionLiderazgo ma = new fEvaluacionLiderazgo(id_evaluacion,Integer.parseInt(CODIGO.getText()));
            Pane1.add(ma);
            Dimension desktopSize = Pane1.getSize();
            Dimension FrameSize = ma.getSize();
            ma.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
            ma.show();
            this.dispose();
        }
       
    }//GEN-LAST:event_LiderazgoActionPerformed

    private void OrientaResultadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrientaResultadosActionPerformed
        if (estado2 == 0){
            bEvaluacionOrientacionAresultados ma = new bEvaluacionOrientacionAresultados(id_evaluacion,Integer.parseInt(CODIGO.getText()));
            Pane1.add(ma);
            Dimension desktopSize = Pane1.getSize();
            Dimension FrameSize = ma.getSize();
            ma.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
            ma.show();
            this.dispose();
        }
    }//GEN-LAST:event_OrientaResultadosActionPerformed

    private void DEPTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DEPTOActionPerformed
       
        
    }//GEN-LAST:event_DEPTOActionPerformed

    private void PUESTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PUESTOActionPerformed
        
        
    }//GEN-LAST:event_PUESTOActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        InicioEvaluacioSupervisores tra = new InicioEvaluacioSupervisores();
        Pane1.add(tra);
        Dimension desktopSize = Pane1.getSize();
        Dimension FrameSize = tra.getSize();
        tra.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        tra.show();       
    }//GEN-LAST:event_formInternalFrameClosing

    private void ResolucionConflictosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResolucionConflictosActionPerformed
         if (estado3 == 0){
        cEvaluacionResolucionConflictos tra = new cEvaluacionResolucionConflictos(id_evaluacion,Integer.parseInt(CODIGO.getText()));
        Pane1.add(tra);
        Dimension desktopSize = Pane1.getSize();
        Dimension FrameSize = tra.getSize();
        tra.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        tra.show(); 
        this.dispose();
         }
    }//GEN-LAST:event_ResolucionConflictosActionPerformed

    private void TrabajoEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TrabajoEquipoActionPerformed
         if (estado4 == 0){
        dEvaluacionTrabajoEnEquipo tra = new dEvaluacionTrabajoEnEquipo(id_evaluacion,Integer.parseInt(CODIGO.getText()));
        Pane1.add(tra);
        Dimension desktopSize = Pane1.getSize();
        Dimension FrameSize = tra.getSize();
        tra.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        tra.show(); 
        this.dispose();
         }
    }//GEN-LAST:event_TrabajoEquipoActionPerformed

    private void IniciativaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniciativaActionPerformed
         if (estado8 == 0){
        hEvaluacionIniciativa tra = new hEvaluacionIniciativa(id_evaluacion,Integer.parseInt(CODIGO.getText()));
        Pane1.add(tra);
        Dimension desktopSize = Pane1.getSize();
        Dimension FrameSize = tra.getSize();
        tra.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        tra.show(); 
        this.dispose();
         }
    }//GEN-LAST:event_IniciativaActionPerformed

    private void ResponsabilidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResponsabilidadActionPerformed
         if (estado7 == 0){
        gEvaluacionResponsabilidad tra = new gEvaluacionResponsabilidad(id_evaluacion,Integer.parseInt(CODIGO.getText()));
        Pane1.add(tra);
        Dimension desktopSize = Pane1.getSize();
        Dimension FrameSize = tra.getSize();
        tra.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        tra.show(); 
        this.dispose();
         }
    }//GEN-LAST:event_ResponsabilidadActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
             this.dispose();
        InicioEvaluacioSupervisores tra = new InicioEvaluacioSupervisores();
        Pane1.add(tra);
        Dimension desktopSize = Pane1.getSize();
        Dimension FrameSize = tra.getSize();
        tra.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        tra.show();       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
      
       
    }//GEN-LAST:event_formInternalFrameClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CODIGO;
    private javax.swing.JTextField DEPTO;
    private javax.swing.JTextField FACE;
    private javax.swing.JButton Iniciativa;
    private javax.swing.JButton Liderazgo;
    private javax.swing.JTextField NOMBRE;
    private javax.swing.JButton Organizacion;
    private javax.swing.JButton OrientaResultados;
    private javax.swing.JTextField PUESTO;
    private javax.swing.JButton ResolucionConflictos;
    private javax.swing.JButton Responsabilidad;
    private javax.swing.JButton TrabajoEquipo;
    private com.toedter.calendar.JDateChooser fechaF;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JButton planificacion;
    // End of variables declaration//GEN-END:variables
}
