/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EvaluacionDesempeñoOperativo;

import BD.BD;
import Clases.EvaluacionOperativo.ClassEvaluacionOperativo;
import Class.Reportes.BDEvaluacionReportesImpresiones;
import static Formuarios.Inicio.Pane1;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author jluis
 */
public class ImpresionEvaluaciones extends javax.swing.JInternalFrame {
     int id_evaluacion;
     int codigo;
     int id;
     int idevaluacion;
     int depto = 10;
    /**
     * Creates new form BuscarCodigo
     */
    public ImpresionEvaluaciones() {
        initComponents();
        selectusuario();
    }
     
    public void selectusuario(){
         
             /* 1,'INSPECCION',
                2,'TESTING',
                3,'CHIPS',
                4,'STRIP Y POTTING',
                5,'TRANSFORMADORES',
                6,'TALLER',
                7,'BODEGA',
                8,'ADMINISTRACION'
                9,'GERENCIA'*/
             String a = System.getProperty("user.name");//usar usuario de windows
             if (a.equals("jluis")){depto=8;} //INFORMATICA
             else if (a.equals("Inspeccion")){depto=1;}// INSPECCION
             else if (a.equals("testing")){depto=2;} // TESTING
             else if (a.equals("deptochips")){depto=3;}//CHIPS
             else if (a.equals("potting")){depto=4;}  //STRIP & POTTING
             else if (a.equals("ehernandez")){depto=5;} //TRANSFORMADORES
             else if (a.equals("taller")){depto=6;}//TALLE
             else if (a.equals("bodega")){depto=7;}//BODEGA 
             else if (a.equals("amonroy")){depto=8;} //INFORMATICA
             else if (a.equals("calidad")){depto=8;} // CALIDAD
             ListarCodigosSiImprime();
             ListarCodigosNoImprime();
             //jLabel4.setText(a+" "+depto);
   }
    
    
    public boolean AgregarAlista() {

            
         try {
             int id = (Integer.parseInt(String.valueOf(NoImprime.getModel().getValueAt(NoImprime.getSelectedRow(), 0))));
             Connection cnn = BD.getConnection();
             PreparedStatement ps = null;
             ps = cnn.prepareStatement("update bevaluacion_desempeno set imprime=2 where id_evaluacion=" +id);
             int rowsUpdated = ps.executeUpdate();
             cnn.close();
             ps.close();
         } catch (SQLException ex) {
             Logger.getLogger(ImpresionEvaluaciones.class.getName()).log(Level.SEVERE, null, ex);
         }
         return false;
    }
    
    public boolean Eliminardelista() {

            
         try {
             int id = (Integer.parseInt(String.valueOf(Imprime.getModel().getValueAt(Imprime.getSelectedRow(), 0))));
             Connection cnn = BD.getConnection();
             PreparedStatement ps = null;
             ps = cnn.prepareStatement("update bevaluacion_desempeno set imprime = 1 where id_evaluacion=" +id);
             int rowsUpdated = ps.executeUpdate();
             cnn.close();
             ps.close();
         } catch (SQLException ex) {
             Logger.getLogger(ImpresionEvaluaciones.class.getName()).log(Level.SEVERE, null, ex);
         }
         return false;
    }
    
    
    public boolean EliminarTododelista() {

            
         try {
             //int id = (Integer.parseInt(String.valueOf(Imprime.getModel().getValueAt(Imprime.getSelectedRow(), 0))));
             Connection cnn = BD.getConnection();
             PreparedStatement ps = null;
             ps = cnn.prepareStatement("update bevaluacion_desempeno set imprime = 1");
             System.out.println("Evaluacion = "+id);
             int rowsUpdated = ps.executeUpdate();
             cnn.close();
             ps.close();
         } catch (SQLException ex) {
             Logger.getLogger(ImpresionEvaluaciones.class.getName()).log(Level.SEVERE, null, ex);
         }
         return false;
    }
    

    private void ImprimeEva(){
        //id_evaluacion = (Integer.parseInt(String.valueOf(NoImprime.getModel().getValueAt(NoImprime.getSelectedRow(),0))));
          BD con= new BD();
         Connection conexion= con.getConnection();
        try {
            JasperReport jasperReport=(JasperReport)JRLoader.loadObjectFromFile("\\\\SRVANATEK\\Bases de Datos\\Sistema\\Recursos Humanos\\Reportes\\EvaluacionDesempeñoImprimir.jasper");
            JasperReport jasperReport2=(JasperReport)JRLoader.loadObjectFromFile("\\\\SRVANATEK\\Bases de Datos\\Sistema\\Recursos Humanos\\Reportes\\EvaluacionDesempeñoImprime2.jasper");
            Map parametros= new HashMap();
            parametros.put("ID", 2);
            JasperPrint print = JasperFillManager.fillReport(jasperReport,parametros, conexion);
            JasperPrint print2 = JasperFillManager.fillReport(jasperReport2,parametros, conexion);
            JasperViewer view = new JasperViewer(print,false);
            JasperViewer view2 = new JasperViewer(print2,false);
            view.setVisible(true);
            view2.setVisible(true);
        } catch (Exception e) {System.out.println("F"+e);
           JOptionPane.showMessageDialog(null, "ERROR EJECUTAR REPORTES =  "+e);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        NoImprime = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Codigotxt = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Imprime = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        evaluacion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        face = new javax.swing.JTextField();
        Fecha = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Depto = new javax.swing.JTextField();

        setClosable(true);
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

        NoImprime.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "CODIGO", "NOMBRE", "FECHA", "#EVALUACION", "FASE"
            }
        ));
        NoImprime.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NoImprimeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(NoImprime);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("EVALUACIONES PARA IMPRIMIR");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("CODIGO");

        Codigotxt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Codigotxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CodigotxtActionPerformed(evt);
            }
        });
        Codigotxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CodigotxtKeyReleased(evt);
            }
        });

        jButton1.setText("IMPRIMIR EVALUACIONES");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Imprime.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "CODIGO", "NOMBRE", "FECHA", "#EVALUACION", "FASE"
            }
        ));
        Imprime.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImprimeMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Imprime);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("FACE");

        evaluacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                evaluacionActionPerformed(evt);
            }
        });
        evaluacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                evaluacionKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("EVALUACION #");

        face.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                faceActionPerformed(evt);
            }
        });
        face.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                faceKeyReleased(evt);
            }
        });

        Fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FechaActionPerformed(evt);
            }
        });
        Fecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FechaKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("DEPARTAMENTO");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("FECHA DE EVALUACION");

        Depto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeptoActionPerformed(evt);
            }
        });
        Depto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                DeptoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(415, 415, 415))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(33, 33, 33))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Codigotxt, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(face, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                                    .addComponent(evaluacion))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Depto, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Codigotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addComponent(Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(evaluacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(Depto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(face, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(16, 16, 16))
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

    
    
    private void ListarCodigosNoImprime(){
        ArrayList<ClassEvaluacionOperativo> result1 = BDEvaluacionReportesImpresiones.ListarEvaluacionesNoImprimir(Codigotxt.getText(),depto,face.getText(),evaluacion.getText(),Fecha.getText(),Depto.getText());
        Listar(result1);  
    }
     private void Listar(ArrayList<ClassEvaluacionOperativo> list1) {
         
              Object[][] datos = new Object[list1.size()][6];
              int i = 0;
              for(ClassEvaluacionOperativo t : list1)
              {
                  datos[i][0] = t.getId_evaluacion();
                  datos[i][1] = t.getCodigo();
                  datos[i][2] = t.getNombres();//+' '+t.getApellidos();
                  datos[i][3] = t.getFechaS();
                  datos[i][4] = t.getNoEvaluacion();
                  datos[i][5] = t.getFaceS();
                  i++;
              }    
             NoImprime.setModel(new javax.swing.table.DefaultTableModel(
                datos,
                new String[]{
                "No.","CODIGO","NOMBRE","FECHA EVALUACION","#EVALUACION","FASE"
             })
             {  
                 @Override
             public boolean isCellEditable(int row, int column){
             return false;
             }
             });
             TableColumn columna1 = NoImprime.getColumn("No.");
             columna1.setPreferredWidth(0);
             TableColumn columna2 = NoImprime.getColumn("CODIGO");
             columna2.setPreferredWidth(0);
             TableColumn columna3 = NoImprime.getColumn("NOMBRE");
             columna3.setPreferredWidth(150);
             TableColumn columna4 = NoImprime.getColumn("FECHA EVALUACION");
             columna4.setPreferredWidth(75);
             TableColumn columna5 = NoImprime.getColumn("#EVALUACION");
             columna5.setPreferredWidth(35);
             TableColumn columna6 = NoImprime.getColumn("FASE");
             columna6.setPreferredWidth(35);
     }
     
     
     private void ListarCodigosSiImprime(){
        ArrayList<ClassEvaluacionOperativo> result1 = BDEvaluacionReportesImpresiones.ListarEvaluacionesImprimir(Codigotxt.getText(),depto,face.getText(),evaluacion.getText());
        Listarimprime(result1);  
    }
     private void Listarimprime(ArrayList<ClassEvaluacionOperativo> list1) {
         
              Object[][] datos = new Object[list1.size()][6];
              int i = 0;
              for(ClassEvaluacionOperativo t : list1)
              {
                  datos[i][0] = t.getId_evaluacion();
                  datos[i][1] = t.getCodigo();
                  datos[i][2] = t.getNombres();//+' '+t.getApellidos();
                  datos[i][3] = t.getFechaS();
                  datos[i][4] = t.getNoEvaluacion();
                  datos[i][5] = t.getFaceS();
                  i++;
              }    
             Imprime.setModel(new javax.swing.table.DefaultTableModel(
                datos,
                new String[]{
                "No.","CODIGO","NOMBRE","FECHA EVALUACION","#EVALUACION","FASE"
             })
             {  
                 @Override
             public boolean isCellEditable(int row, int column){
             return false;
             }
             });
             TableColumn columna1 = Imprime.getColumn("No.");
             columna1.setPreferredWidth(0);
             TableColumn columna2 = Imprime.getColumn("CODIGO");
             columna2.setPreferredWidth(0);
             TableColumn columna3 = Imprime.getColumn("NOMBRE");
             columna3.setPreferredWidth(150);
             TableColumn columna4 = Imprime.getColumn("FECHA EVALUACION");
             columna4.setPreferredWidth(75);
             TableColumn columna5 = Imprime.getColumn("#EVALUACION");
             columna5.setPreferredWidth(35);
             TableColumn columna6 = Imprime.getColumn("FASE");
             columna6.setPreferredWidth(35);
     }


    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
       
        EliminarTododelista();
        InicioEvaluacioOperativos tra = new InicioEvaluacioOperativos();
        Pane1.add(tra);
        Dimension desktopSize = Pane1.getSize();
        Dimension FrameSize = tra.getSize();
        tra.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        tra.show();
        
    }//GEN-LAST:event_formInternalFrameClosing

    private void NoImprimeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NoImprimeMouseClicked
        
        if (evt.getClickCount() > 1) {
         AgregarAlista();
         ListarCodigosNoImprime();
         ListarCodigosSiImprime();
        }
    }//GEN-LAST:event_NoImprimeMouseClicked

    private void CodigotxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CodigotxtKeyReleased
        ListarCodigosNoImprime();
    }//GEN-LAST:event_CodigotxtKeyReleased

    private void ImprimeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImprimeMouseClicked
       
        if (evt.getClickCount() > 1) {
         Eliminardelista();
         ListarCodigosNoImprime();
         ListarCodigosSiImprime();
        }
        
    }//GEN-LAST:event_ImprimeMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ImprimeEva();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void faceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_faceKeyReleased
           ListarCodigosNoImprime();
    }//GEN-LAST:event_faceKeyReleased

    private void evaluacionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_evaluacionKeyReleased
          ListarCodigosNoImprime();
    }//GEN-LAST:event_evaluacionKeyReleased

    private void CodigotxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CodigotxtActionPerformed
       face.requestFocus();
    }//GEN-LAST:event_CodigotxtActionPerformed

    private void faceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_faceActionPerformed
       evaluacion.requestFocus();
    }//GEN-LAST:event_faceActionPerformed

    private void evaluacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_evaluacionActionPerformed
        Codigotxt.requestFocus();
    }//GEN-LAST:event_evaluacionActionPerformed

    private void FechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FechaActionPerformed

    private void FechaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FechaKeyReleased
         ListarCodigosNoImprime();
    }//GEN-LAST:event_FechaKeyReleased

    private void DeptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeptoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DeptoActionPerformed

    private void DeptoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DeptoKeyReleased
        ListarCodigosNoImprime();
    }//GEN-LAST:event_DeptoKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Codigotxt;
    private javax.swing.JTextField Depto;
    private javax.swing.JTextField Fecha;
    private javax.swing.JTable Imprime;
    private javax.swing.JTable NoImprime;
    private javax.swing.JTextField evaluacion;
    private javax.swing.JTextField face;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
