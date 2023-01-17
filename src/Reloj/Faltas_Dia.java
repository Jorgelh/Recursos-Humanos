/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reloj;

import BD.BD;
import BDreloj.ClassReloj;
import BDreloj.QuerysReloj;
import Clases.empleados.Empleados;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
public class Faltas_Dia extends javax.swing.JInternalFrame {
    String fecha1;
    int estadoasistencia;
    /**
     * Creates new form Faltas_Dia
     */
    public Faltas_Dia() {
        initComponents();
        Calendar c2 = new GregorianCalendar();
        JD_Fecha.setCalendar(c2);
        fecha(); 
    }
    
    private void INGRESOSINMARCAJE() {

        try {

            ClassReloj g = new ClassReloj();
            g.setCodigo(Integer.parseInt(CODIGO.getText()));
            QuerysReloj.IngresoEspecialSinMarcajeEntrada(g);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR DE INSERTAR" + e);
        }

    }
    
     private void INGRESOESPECIAL() {

        try {

            ClassReloj g = new ClassReloj();
            g.setCodigo(Integer.parseInt(CODIGO.getText()));
            g.setEstadoIngresoEspecial(estadoasistencia);
            QuerysReloj.IngresoDatosRelojingresoEspecial(g);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR DE INSERTAR" + e);
        }

    }
    
    
   private void fecha(){
    Date date = JD_Fecha.getDate();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
    fecha1 = sdf.format(date);
   }
    
    
    
    private void ListarFaltas(){
        fecha();
        System.out.println("TEST "+fecha1);
        ArrayList<ClassReloj> result = QuerysReloj.ListarFaltasEmpleados(fecha1);
        RecargarTabla(result);  
    }
     private void RecargarTabla(ArrayList<ClassReloj> list) {
         
              Object[][] datos = new Object[list.size()][8];
              int i = 0;
              for(ClassReloj t : list)
              {
                  datos[i][0] = t.getCodigo();
                  datos[i][1] = t.getNombre();
                  datos[i][2] = t.getDepartamento();
                  
                  i++;
              }    
             ListaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
                datos,
                new String[]{
                "CODIGO","NOMBRE","DEPARTAMENTO"
 
             })
             {  
                 @Override
             public boolean isCellEditable(int row, int column){
                 return false;
             }
             });
             TableColumn columna1 = ListaEmpleados.getColumn("CODIGO");
             columna1.setPreferredWidth(-10);
             TableColumn columna2 = ListaEmpleados.getColumn("NOMBRE");
             columna2.setPreferredWidth(250);
             TableColumn columna3 = ListaEmpleados.getColumn("DEPARTAMENTO");
             columna3.setPreferredWidth(250);
      
}
   
     
     
private void ImprimeReporteFaltas(){
        //id_evaluacion = (Integer.parseInt(String.valueOf(NoImprime.getModel().getValueAt(NoImprime.getSelectedRow(),0))));
          BD con= new BD();
         Connection conexion= con.getConnection();
        try {
            JasperReport jasperReport=(JasperReport)JRLoader.loadObjectFromFile("\\\\SRVANATEK\\Bases de Datos\\Sistema\\Recursos Humanos\\Reloj\\Faltas por dia.jasper");
            Map parametros= new HashMap();
            parametros.put("FECHA", fecha1);
            JasperPrint print = JasperFillManager.fillReport(jasperReport,parametros, conexion);
            JasperViewer view = new JasperViewer(print,false);
            view.setVisible(true);
        } catch (Exception e) {
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaEmpleados = new javax.swing.JTable();
        JD_Fecha = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        BUSCAR = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        CODIGO = new javax.swing.JTextField();
        NOMBRE = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Motivo = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setTitle("REPORTE DE FALTAS");
        setToolTipText("");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clock (2).png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("REPORTE DE FALTAS POR DIA ");

        ListaEmpleados.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ListaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "NOMBRE", "DEPARTAMENTO"
            }
        ));
        ListaEmpleados.setIntercellSpacing(new java.awt.Dimension(10, 1));
        ListaEmpleados.setRowHeight(26);
        ListaEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListaEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ListaEmpleados);

        JD_Fecha.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                JD_FechaInputMethodTextChanged(evt);
            }
        });
        JD_Fecha.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                JD_FechaPropertyChange(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("FECHA");

        BUSCAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Zoom.png"))); // NOI18N
        BUSCAR.setText("BUSCAR");
        BUSCAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUSCARActionPerformed(evt);
            }
        });

        CODIGO.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        NOMBRE.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("CODIGO:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("NOMBRE:");

        Motivo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONAR...", "SIN MARCAJE DE ENTRADA", "OLVIDO CARNET DE MARCAJE", "REGRESADO POR LLEGAR TARDE", "NO SE PRESENTO", "FALTA CON PERMISO", "SUSPENDIDO", "SUSPENDIDO POR IGSS", " ", " ", " " }));
        Motivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MotivoActionPerformed(evt);
            }
        });

        jButton2.setText("ACTUALIZAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(NOMBRE, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Motivo, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(NOMBRE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Motivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JD_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BUSCAR))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(317, 317, 317)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 905, Short.MAX_VALUE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(JD_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BUSCAR, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    private void JD_FechaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_JD_FechaPropertyChange
         
    }//GEN-LAST:event_JD_FechaPropertyChange

    private void JD_FechaInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_JD_FechaInputMethodTextChanged
       
    }//GEN-LAST:event_JD_FechaInputMethodTextChanged

    private void BUSCARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUSCARActionPerformed
        ListarFaltas();
    }//GEN-LAST:event_BUSCARActionPerformed

    private void MotivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MotivoActionPerformed
       
         if (Motivo.getSelectedItem().toString().equalsIgnoreCase("SIN MARCAJE DE ENTRADA")) {
            estadoasistencia = 1;
        } else if (Motivo.getSelectedItem().toString().equalsIgnoreCase("OLVIDO CARNET DE MARCAJE")) {
            estadoasistencia = 2;
        } else if (Motivo.getSelectedItem().toString().equalsIgnoreCase("NO SE PRESENTO")) {
            estadoasistencia = 3;
        }else if (Motivo.getSelectedItem().toString().equalsIgnoreCase("FALTA CON PERMISO")) {
            estadoasistencia = 4;
        }else if (Motivo.getSelectedItem().toString().equalsIgnoreCase("SUSPENDIDO")) {
            estadoasistencia = 5;
        }else if (Motivo.getSelectedItem().toString().equalsIgnoreCase("SUSPENDIDO POR IGSS")) {
            estadoasistencia = 6;
        }else if (Motivo.getSelectedItem().toString().equalsIgnoreCase("REGRESADO POR LLEGAR TARDE")) {
            estadoasistencia = 7;
        }
    }//GEN-LAST:event_MotivoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       if (Motivo.getSelectedItem().toString().equalsIgnoreCase("SELECCIONAR..."))
       {
       JOptionPane.showMessageDialog(null,"SELECCIONE UN MOTIVO PARA EL MARCAJE");
       }
       else if(Motivo.getSelectedItem().toString().equalsIgnoreCase("SIN MARCAJE DE ENTRADA"))
       {
           if(CODIGO.getText().compareTo("")!=0){
               INGRESOSINMARCAJE();
           }else{JOptionPane.showMessageDialog(null,"SELECCIONE UN EMPLEADO...");}
       }else
       {
          if(CODIGO.getText().compareTo("")!=0){
               INGRESOESPECIAL();
           }else{JOptionPane.showMessageDialog(null,"SELECCIONE UN EMPLEADO...");}
       }
       ListarFaltas();
       NOMBRE.setText("");
       CODIGO.setText("");
       Motivo.setSelectedItem("SELECCIONAR...");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void ListaEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListaEmpleadosMouseClicked
        CODIGO.setText(String.valueOf(ListaEmpleados.getModel().getValueAt(ListaEmpleados.getSelectedRow(),0)));
        NOMBRE.setText(String.valueOf(ListaEmpleados.getModel().getValueAt(ListaEmpleados.getSelectedRow(),1)));
    }//GEN-LAST:event_ListaEmpleadosMouseClicked

    
   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BUSCAR;
    private javax.swing.JTextField CODIGO;
    private com.toedter.calendar.JDateChooser JD_Fecha;
    private javax.swing.JTable ListaEmpleados;
    private javax.swing.JComboBox<String> Motivo;
    private javax.swing.JTextField NOMBRE;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
