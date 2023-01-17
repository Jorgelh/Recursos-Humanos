/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reloj;

import BD.BD;
import BDreloj.ClassReloj;
import BDreloj.QuerysReloj;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
public class Asistencia_Dia extends javax.swing.JInternalFrame {
    String fecha1;
    /**
     * Creates new form Faltas_Dia
     */
    public Asistencia_Dia() {
        initComponents();
        Calendar c2 = new GregorianCalendar();
        JD_Fecha.setCalendar(c2);
        fecha();
        
     

        
    }
    
   private void fecha(){
   
    Date date = JD_Fecha.getDate();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
    fecha1 = sdf.format(date);
   
       
   }
    
    
    
    private void ListarAsistencia(){
        fecha();
        System.out.println("TEST "+fecha1);
        ArrayList<ClassReloj> result = QuerysReloj.ListarAsistenciaEmpleados(fecha1,CODIGO.getText());
        RecargarTabla(result);  
    }
     private void RecargarTabla(ArrayList<ClassReloj> list) {
         
              Object[][] datos = new Object[list.size()][8];
              int i = 0;
              for(ClassReloj t : list)
              {
                  datos[i][0] = t.getCodigo();
                  datos[i][1] = t.getNombre();
                  datos[i][2] = t.getFecha();
                  datos[i][3] = t.getHorain();
                  datos[i][4] = t.getHoraout();
                  datos[i][5] = t.getDepartamento();
                  datos[i][6] = t.getNota();
                  i++;
              }    
             ListaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
                datos,
                new String[]{
                "CODIGO","NOMBRE","FECHA","HORA DE INGRESO","HORA DE SALIDA","DEPARTAMENTO","NOTA"
 
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
             columna2.setPreferredWidth(200);
             TableColumn columna3 = ListaEmpleados.getColumn("FECHA");
             columna3.setPreferredWidth(10);
             TableColumn columna4 = ListaEmpleados.getColumn("HORA DE INGRESO");
             columna4.setPreferredWidth(25);
             TableColumn columna5 = ListaEmpleados.getColumn("HORA DE SALIDA");
             columna5.setPreferredWidth(25);
             TableColumn columna6 = ListaEmpleados.getColumn("DEPARTAMENTO");
             columna6.setPreferredWidth(100);
             TableColumn columna7 = ListaEmpleados.getColumn("NOTA");
             columna7.setPreferredWidth(200);
      
      
}
   
private void ImprimeReporte(){
        //id_evaluacion = (Integer.parseInt(String.valueOf(NoImprime.getModel().getValueAt(NoImprime.getSelectedRow(),0))));
          BD con= new BD();
         Connection conexion= con.getConnection();
        try {
            JasperReport jasperReport=(JasperReport)JRLoader.loadObjectFromFile("\\\\SRVANATEK\\Bases de Datos\\Sistema\\Recursos Humanos\\Reloj\\AsistenciaDia.jasper");
            Map parametros= new HashMap();
            parametros.put("FECHA", fecha1);
            JasperPrint print = JasperFillManager.fillReport(jasperReport,parametros, conexion);
            JasperViewer view = new JasperViewer(print,false);
            view.setVisible(true);
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "ERROR EJECUTAR REPORTES =  "+e);
        }
    }

private void validarExistencia() {
        try {
            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select COUNT(codigo) as codigo from reloj where estado = 1 and to_date(fecha,'dd/mm/yy') = to_date(sysdate,'dd/mm/yy')");
            rs.next();
            int c = rs.getInt("codigo");
            total.setText(String.valueOf(c));
            
        } catch (SQLException ex) {
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
        jButton1 = new javax.swing.JButton();
        BUSCAR = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        CODIGO = new javax.swing.JTextField();
        total = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("REPORTE DE ASISTENCIA ");
        setToolTipText("");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clock (2).png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("REPORTE DE ASISTENCIA POR DIA ");

        ListaEmpleados.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ListaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "NOMBRE", "FECHA", "HORA INGRESO", "HORA SALIDA", "DEPARTAMENTO"
            }
        ));
        ListaEmpleados.setIntercellSpacing(new java.awt.Dimension(10, 1));
        ListaEmpleados.setRowHeight(26);
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
        jLabel2.setText("FECHA:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ComponenteImagenes/Print.png"))); // NOI18N
        jButton1.setText("IMPRIMIR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        BUSCAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Zoom.png"))); // NOI18N
        BUSCAR.setText("BUSCAR");
        BUSCAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUSCARActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("CODIGO:");

        CODIGO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CODIGOKeyReleased(evt);
            }
        });

        total.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel4.setText("TOTAL DE MARCAJES");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(410, 410, 410))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(522, 522, 522)
                            .addComponent(jButton1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(9, 9, 9)
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(JD_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(BUSCAR))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1127, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(JD_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(BUSCAR, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(CODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JD_FechaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_JD_FechaPropertyChange
         
    }//GEN-LAST:event_JD_FechaPropertyChange

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ImprimeReporte();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void JD_FechaInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_JD_FechaInputMethodTextChanged
       
    }//GEN-LAST:event_JD_FechaInputMethodTextChanged

    private void BUSCARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUSCARActionPerformed
        ListarAsistencia();
        validarExistencia();
    }//GEN-LAST:event_BUSCARActionPerformed

    private void CODIGOKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CODIGOKeyReleased
       ListarAsistencia();
       validarExistencia();
    }//GEN-LAST:event_CODIGOKeyReleased

    
   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BUSCAR;
    private javax.swing.JTextField CODIGO;
    private com.toedter.calendar.JDateChooser JD_Fecha;
    private javax.swing.JTable ListaEmpleados;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField total;
    // End of variables declaration//GEN-END:variables
}
