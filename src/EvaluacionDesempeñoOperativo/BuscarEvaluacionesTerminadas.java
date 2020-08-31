/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EvaluacionDesempeñoOperativo;

import BD.BD;
import Clases.EvaluacionOperativo.BDEvaluacion;
import Clases.EvaluacionOperativo.ClassEvaluacionOperativo;
import static Formuarios.Inicio.Pane1;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
public class BuscarEvaluacionesTerminadas extends javax.swing.JInternalFrame {
     int id_evaluacion;
     int codigo;
     int id;
     int idevaluacion;
     int depto = 10;
     int evalua;
     
    /**
     * Creates new form BuscarCodigo
     */
    public BuscarEvaluacionesTerminadas() {
        initComponents();
        selectusuario();
        if (depto == 8) {DEPAR.setEnabled(true); }
    }
     
    public void selectusuario() {

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
        if (a.equals("jluis")) {
            evalua = 367;
            depto = 8;
        } //INFORMATICA
        else if (a.equals("Inspeccion")) {
            evalua = 302;
        }// INSPECCION
        else if (a.equals("testing")) {
            evalua = 822;
        } // TESTING
        else if (a.equals("deptochips")) {
            evalua = 748;
        }//CHIPS
        else if (a.equals("potting")) {
            evalua = 781;
        } //STRIP & POTTING
        else if (a.equals("ehernandez")) {
            evalua = 533;
        } //TRANSFORMADORES
        else if (a.equals("taller")) {
            evalua = 348;
        }//TALLE
        else if (a.equals("bodega")) {
            evalua = 465;
        }//BODEGA 
        else if (a.equals("amonroy")) {
            evalua = 920;
            depto = 8;
        } //INFORMATICA
        else if (a.equals("ingenieria2")) {
            evalua = 876;
        } // CALIDAD 
        else if (a.equals("glemus")) {
            evalua = 755;
        }//SOTANO
        else if (a.equals("oecheverria")) {
            evalua = 847;
        }//SOTANO
        else if (a.equals("apacheco")) {
            evalua = 833;
        }//SOTANO
        else if (a.equals("emely")) {
            evalua = 833;
        }//SOTANO
        ListarCodigosTerminados();
    }
    
    private void ImprimeEva(){
        id_evaluacion = (Integer.parseInt(String.valueOf(Evaluaciones.getModel().getValueAt(Evaluaciones.getSelectedRow(),0))));
          BD con= new BD();
         Connection conexion= con.getConnection();
        try {
            JasperReport jasperReport=(JasperReport)JRLoader.loadObjectFromFile("\\\\SRVANATEK\\Bases de Datos\\Sistema\\Recursos Humanos\\Reportes\\EvaluacionDesempeño.jasper");
            JasperReport jasperReport2=(JasperReport)JRLoader.loadObjectFromFile("\\\\SRVANATEK\\Bases de Datos\\Sistema\\Recursos Humanos\\Reportes\\EvaluacionDesempeño2de2.jasper");
            Map parametros= new HashMap();
            parametros.put("ID", id_evaluacion);
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
        Evaluaciones = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Codigotxt = new javax.swing.JTextField();
        DEPAR = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

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

        Evaluaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "CODIGO", "NOMBRE", "PUESTO", "DEPARTAMENTO", "FECHA", "#EVALUACION", "FASE"
            }
        ));
        Evaluaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EvaluacionesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Evaluaciones);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("EVALUACIONES PARA IMPRIMIR");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("CODIGO");

        Codigotxt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Codigotxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CodigotxtKeyReleased(evt);
            }
        });

        DEPAR.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        DEPAR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONAR...", "INSPECCION", "TESTING", "CHIPS", "SOLDER DIP, STRIP & POTTING", "TRANSFORMADORES", "TALLER", "BODEGA", "TECNOLOGIA DE LA INFORMACION/MANTENIMIENTO" }));
        DEPAR.setEnabled(false);
        DEPAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DEPARActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("DEPARTAMENTO");

        jLabel4.setText("jLabel4");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 899, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Codigotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DEPAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(195, 195, 195)
                .addComponent(jLabel4)
                .addGap(64, 64, 64))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addGap(18, 51, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Codigotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(DEPAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
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

    
    
    private void ListarCodigosTerminados(){
        ArrayList<ClassEvaluacionOperativo> result1 = BDEvaluacion.ListarEvaluacionesTerminadas(Codigotxt.getText(),evalua);
        Listar(result1);  
    }
     private void Listar(ArrayList<ClassEvaluacionOperativo> list1) {
         
              Object[][] datos = new Object[list1.size()][8];
              int i = 0;
              for(ClassEvaluacionOperativo t : list1)
              {
                  datos[i][0] = t.getId_evaluacion();
                  datos[i][1] = t.getCodigo();
                  datos[i][2] = t.getNombres();//+' '+t.getApellidos();
                  datos[i][3] = t.getPuesto();
                  datos[i][4] = t.getDepto();
                  datos[i][5] = t.getFechaS();
                  datos[i][6] = t.getNoEvaluacion();
                  datos[i][7] = t.getFaceS();
                  i++;
              }    
             Evaluaciones.setModel(new javax.swing.table.DefaultTableModel(
                datos,
                new String[]{
                "No.","CODIGO","NOMBRE","PUESTO","DEPARTAMENTO","FECHA EVALUACION","#EVALUACION","FASE"
             })
             {  
                 @Override
             public boolean isCellEditable(int row, int column){
             return false;
             }
             });
             TableColumn columna1 = Evaluaciones.getColumn("No.");
             columna1.setPreferredWidth(0);
             TableColumn columna2 = Evaluaciones.getColumn("CODIGO");
             columna2.setPreferredWidth(0);
             TableColumn columna3 = Evaluaciones.getColumn("NOMBRE");
             columna3.setPreferredWidth(150);
             TableColumn columna4 = Evaluaciones.getColumn("PUESTO");
             columna4.setPreferredWidth(150);
             TableColumn columna5 = Evaluaciones.getColumn("DEPARTAMENTO");
             columna5.setPreferredWidth(100);
             TableColumn columna6 = Evaluaciones.getColumn("FECHA EVALUACION");
             columna6.setPreferredWidth(75);
             TableColumn columna7 = Evaluaciones.getColumn("#EVALUACION");
             columna7.setPreferredWidth(35);
             TableColumn columna8 = Evaluaciones.getColumn("FASE");
             columna8.setPreferredWidth(35);
     }
     
      private void ListarCodigosTerminadosEvalua(){
        ArrayList<ClassEvaluacionOperativo> result1 = BDEvaluacion.ListarEvaluacionesTerminadasEvalua(Codigotxt.getText(),depto);
        Listar1(result1);  
    }
     private void Listar1(ArrayList<ClassEvaluacionOperativo> list1) {
         
              Object[][] datos = new Object[list1.size()][8];
              int i = 0;
              for(ClassEvaluacionOperativo t : list1)
              {
                  datos[i][0] = t.getId_evaluacion();
                  datos[i][1] = t.getCodigo();
                  datos[i][2] = t.getNombres();//+' '+t.getApellidos();
                  datos[i][3] = t.getPuesto();
                  datos[i][4] = t.getDepto();
                  datos[i][5] = t.getFechaS();
                  datos[i][6] = t.getNoEvaluacion();
                  datos[i][7] = t.getFaceS();
                  i++;
              }    
             Evaluaciones.setModel(new javax.swing.table.DefaultTableModel(
                datos,
                new String[]{
                "No.","CODIGO","NOMBRE","PUESTO","DEPARTAMENTO","FECHA EVALUACION","#EVALUACION","FASE"
             })
             {  
                 @Override
             public boolean isCellEditable(int row, int column){
             return false;
             }
             });
             TableColumn columna1 = Evaluaciones.getColumn("No.");
             columna1.setPreferredWidth(0);
             TableColumn columna2 = Evaluaciones.getColumn("CODIGO");
             columna2.setPreferredWidth(0);
             TableColumn columna3 = Evaluaciones.getColumn("NOMBRE");
             columna3.setPreferredWidth(150);
             TableColumn columna4 = Evaluaciones.getColumn("PUESTO");
             columna4.setPreferredWidth(150);
             TableColumn columna5 = Evaluaciones.getColumn("DEPARTAMENTO");
             columna5.setPreferredWidth(100);
             TableColumn columna6 = Evaluaciones.getColumn("FECHA EVALUACION");
             columna6.setPreferredWidth(75);
             TableColumn columna7 = Evaluaciones.getColumn("#EVALUACION");
             columna7.setPreferredWidth(35);
             TableColumn columna8 = Evaluaciones.getColumn("FASE");
             columna8.setPreferredWidth(35);
     }
     

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
       
        InicioEvaluacioOperativos tra = new InicioEvaluacioOperativos();
        Pane1.add(tra);
        Dimension desktopSize = Pane1.getSize();
        Dimension FrameSize = tra.getSize();
        tra.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        tra.show();
        
    }//GEN-LAST:event_formInternalFrameClosing

    private void EvaluacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EvaluacionesMouseClicked
        
        if (evt.getClickCount() > 1) {
          ImprimeEva();
        }
    }//GEN-LAST:event_EvaluacionesMouseClicked

    private void CodigotxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CodigotxtKeyReleased
        ListarCodigosTerminados();
    }//GEN-LAST:event_CodigotxtKeyReleased

    private void DEPARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DEPARActionPerformed
        if (DEPAR.getSelectedItem().toString().equalsIgnoreCase("INSPECCION")) {
            depto = 1;
        } else if (DEPAR.getSelectedItem().toString().equalsIgnoreCase("TESTING")) {
            depto = 2;
        } else if (DEPAR.getSelectedItem().toString().equalsIgnoreCase("CHIPS")) {
            depto = 3;
        } else if (DEPAR.getSelectedItem().toString().equalsIgnoreCase("SOLDER DIP, STRIP & POTTING")) {
            depto = 4;
        } else if (DEPAR.getSelectedItem().toString().equalsIgnoreCase("TRANSFORMADORES")) {
            depto = 5;
        } else if (DEPAR.getSelectedItem().toString().equalsIgnoreCase("TALLER")) {
            depto = 6;
        } else if (DEPAR.getSelectedItem().toString().equalsIgnoreCase("BODEGA")) {
            depto = 7;
        } else if (DEPAR.getSelectedItem().toString().equalsIgnoreCase("ADMINISTRACION")) {
            depto = 8;
        }else if (DEPAR.getSelectedItem().toString().equalsIgnoreCase("GERENCIA")) {
            depto = 9;
        }else if (DEPAR.getSelectedItem().toString().equalsIgnoreCase("TECNOLOGIA DE LA INFORMACION/MANTENIMIENTO")){
           depto = 10;
        }
        else if (DEPAR.getSelectedItem().toString().equalsIgnoreCase("SELECCIONAR...")){depto = 0;}
        ListarCodigosTerminadosEvalua();

    }//GEN-LAST:event_DEPARActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Codigotxt;
    private javax.swing.JComboBox<String> DEPAR;
    private javax.swing.JTable Evaluaciones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
