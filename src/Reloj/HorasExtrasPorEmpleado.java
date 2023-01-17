/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Reloj;

import BD.BD;
import BDreloj.ClassReloj;
import BDreloj.QuerysReloj;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
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
public class HorasExtrasPorEmpleado extends javax.swing.JInternalFrame {
    String fecha1;
    /** Creates new form HorasExtrasFecha */
    public HorasExtrasPorEmpleado() {
        initComponents();
    }
    
    private void ImprimeReporte(){
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yy");
            Date fec1 = FECHAINICIO.getDate();
            Date fec2 = FECHAFINAL.getDate();
            String fe1 = formato.format(fec1);
            String fe2 = formato.format(fec2);
          BD con= new BD();
         Connection conexion= con.getConnection();
        try {
            JasperReport jasperReport=(JasperReport)JRLoader.loadObjectFromFile("\\\\SRVANATEK\\Bases de Datos\\Sistema\\Recursos Humanos\\Reloj\\HorasExtrasPorEmpleado.jasper");
            Map parametros= new HashMap();
            parametros.put("FECHA1", fe1);
            parametros.put("FECHA2", fe2);
            parametros.put("CODIGO", codigo.getText());
            JasperPrint print = JasperFillManager.fillReport(jasperReport,parametros, conexion);
            JasperViewer view = new JasperViewer(print,false);
            view.setVisible(true);
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "ERROR EJECUTAR REPORTES =  "+e);
        }
    }
    
    
    
    
    
   private void ListarHorasCodigo(){
        
        Date date = FECHAINICIO.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        String fecha = sdf.format(date);

        Date date2 = FECHAFINAL.getDate();
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yy");
        String fecha1 = sd.format(date2);
       
        Totalhoras();
        ArrayList<ClassReloj> result = QuerysReloj.ListarHorasCodigo(Integer.parseInt(codigo.getText()),fecha,fecha1);
        RecargarTabla(result);  
    }
     private void RecargarTabla(ArrayList<ClassReloj> list) {
              Object[][] datos = new Object[list.size()][6];
              int i = 0;
              for(ClassReloj t : list)
              {
                  datos[i][0] = t.getCodigo();
                  datos[i][1] = t.getFecha();
                  datos[i][2] = t.getHorain();
                  datos[i][3] = t.getHoraout();
                  datos[i][4] = t.getHorasLaboradas();
                  datos[i][5] = t.getHorasExtras();
                  i++;
              }    
             ListadeHoras.setModel(new javax.swing.table.DefaultTableModel(
                datos,
                new String[]{
                "CODIGO","FECHA","HORA DE INGRESO","HORA DE SALIDA","HORAS LABORADAS","HORAS EXTRAS"
 
             })
             {  
                 @Override
             public boolean isCellEditable(int row, int column){
                 return false;
             }
             });
             TableColumn columna1 = ListadeHoras.getColumn("CODIGO");
             columna1.setPreferredWidth(-10);
             TableColumn columna2 = ListadeHoras.getColumn("FECHA");
             columna2.setPreferredWidth(10);
             TableColumn columna3 = ListadeHoras.getColumn("HORA DE INGRESO");
             columna3.setPreferredWidth(25);
             TableColumn columna4 = ListadeHoras.getColumn("HORA DE SALIDA");
             columna4.setPreferredWidth(25);
             TableColumn columna5 = ListadeHoras.getColumn("HORAS LABORADAS");
             columna5.setPreferredWidth(50);
             TableColumn columna6 = ListadeHoras.getColumn("HORAS EXTRAS");
             columna6.setPreferredWidth(50);
}
     
     
     private void buscarhoras(){
         
        Date date = FECHAINICIO.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        String fecha1 = sdf.format(date);

        Date date2 = FECHAFINAL.getDate();
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yy");
        String fecha2 = sd.format(date2);
     
     
     try {
            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select COUNT(codigo) from reloj where codigo= "+codigo.getText()+" and estadoextras = 2 and fecha between to_date( '"+fecha1+"' ,'dd/mm/yy') and to_date('"+fecha2+"' ,'dd/mm/yy')");
            rs.next();
            int c = rs.getInt("count(codigo)");
        if (c > 0){
             ListarHorasCodigo();
             codigo.requestFocus();
        }else {JOptionPane.showMessageDialog(null, "NO TIENE HORAS EXTRAS DEL MES SELECCIONADO");limpiartabla();codigo.setText("");HORAS.setText("");} 
        } catch (Exception e) {
            System.out.println("ERROR "+e);
        }
     }
    
    private void Totalhoras(){
        
        
        Date date = FECHAINICIO.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        String fecha1 = sdf.format(date);

        Date date2 = FECHAFINAL.getDate();
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yy");
        String fecha2 = sd.format(date2);
     
     
     try {
        
            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT sum(horaextra)+(round(sum(minutoextra)/60,2)) TOTALHORAS from reloj where codigo = "+codigo.getText()+" and estadoextras = 2 and  fecha between to_date( '"+fecha1+"' ,'dd/mm/yy') and to_date('"+fecha2+"' ,'dd/mm/yy')");
            rs.next();
            HORAS.setText(String.valueOf(rs.getDouble("TOTALHORAS")));
        } catch (Exception e) {
            System.out.println("ERROR "+e);
        }
     
     }
    
    public void limpiartabla() {
        try {
            DefaultTableModel temp = (DefaultTableModel) ListadeHoras.getModel();
            int a = temp.getRowCount();
            for (int i = 0; i < a; i++) {
                temp.removeRow(i);
                i--;
            }
        } catch (Exception e) {
        }
    }
    
    private void BuscarNombre() {

        try {

            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select nombres from alistaempleados where codigo=" + codigo.getText());
            rs.next();
            String No = rs.getString("nombres");
            Nombre.setText(No);
        } catch (Exception e) {
            System.out.println("ERROR " + e);
        }
    }

    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListadeHoras = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        HORAS = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        imprimir = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        Nombre = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        FECHAINICIO = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        FECHAFINAL = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        codigo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clock (1).png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        ListadeHoras.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ListadeHoras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "NOMBRE", "FECHA", "HORA INGRESO", "HORA SALIDA", "HORAS LABORADAS", "HORAS EXTRAS"
            }
        ));
        ListadeHoras.setIntercellSpacing(new java.awt.Dimension(10, 1));
        ListadeHoras.setRowHeight(26);
        jScrollPane1.setViewportView(ListadeHoras);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("HORAS EXTRAS POR EMPLEADO ");

        HORAS.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 51));
        jLabel3.setText("TOTAL DE HORAS");

        imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ComponenteImagenes/Print.png"))); // NOI18N
        imprimir.setText("IMPRIMIR");
        imprimir.setEnabled(false);
        imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("NOMBRE ");

        Nombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Nombre.setForeground(new java.awt.Color(255, 0, 51));
        Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Fecha Inicio");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Fecha Final");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Codigo");

        codigo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        codigo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                codigoMouseClicked(evt);
            }
        });
        codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoActionPerformed(evt);
            }
        });

        jButton1.setText("BUSCAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FECHAINICIO, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(FECHAFINAL, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(codigo, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(35, 35, 35))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(FECHAINICIO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel4))
                    .addComponent(FECHAFINAL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(imprimir)
                                    .addGap(220, 220, 220)
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(HORAS, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1019, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(370, 370, 370)
                                .addComponent(jLabel2)))
                        .addGap(0, 3, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HORAS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
        if (FECHAINICIO.getDate() != null && FECHAFINAL.getDate()!= null) {

            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yy");
            Date fec1 = FECHAINICIO.getDate();
            Date fec2 = FECHAFINAL.getDate();
            String fe1 = formato.format(fec1);
            String fe2 = formato.format(fec2);
            try {
                Date f1 = formato.parse(fe1);
                Date f2 = formato.parse(fe2);

                if (f1.before(f2)) {
                   
                  if(codigo.getText().compareTo("")!=0) {ListarHorasCodigo();BuscarNombre();imprimir.setEnabled(true);}else{JOptionPane.showMessageDialog(null, "INGRESE UN CODIGO");codigo.requestFocus();limpiartabla();codigo.setText("");}    
                    
                    
                } else {
                    JOptionPane.showMessageDialog(null, "LA PRIMERA FECHA NO PUEDE SER MAYOR A LA SEGUNDA FECHA");
                }

            } catch (ParseException ex) {
                Logger.getLogger(HorasExtrasPorEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "INGRESE LAS FECHAS...");
        }
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoActionPerformed

        if (FECHAINICIO.getDate() != null && FECHAFINAL.getDate()!= null) {

            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yy");
            Date fec1 = FECHAINICIO.getDate();
            Date fec2 = FECHAFINAL.getDate();
            String fe1 = formato.format(fec1);
            String fe2 = formato.format(fec2);
            try {
                Date f1 = formato.parse(fe1);
                Date f2 = formato.parse(fe2);

                if (f1.before(f2)) {
                   
                  if(codigo.getText().compareTo("")!=0) {ListarHorasCodigo();BuscarNombre();imprimir.setEnabled(true);}else{JOptionPane.showMessageDialog(null, "INGRESE UN CODIGO");codigo.requestFocus();limpiartabla();codigo.setText("");}    
                    
                    
                } else {
                    JOptionPane.showMessageDialog(null, "LA PRIMERA FECHA NO PUEDE SER MAYOR A LA SEGUNDA FECHA");
                }

            } catch (ParseException ex) {
                Logger.getLogger(HorasExtrasPorEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "INGRESE LAS FECHAS...");
        }
        
        
        
        
    }//GEN-LAST:event_codigoActionPerformed

    private void NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreActionPerformed

    private void imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirActionPerformed
       ImprimeReporte();
    }//GEN-LAST:event_imprimirActionPerformed

    private void codigoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_codigoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser FECHAFINAL;
    private com.toedter.calendar.JDateChooser FECHAINICIO;
    private javax.swing.JTextField HORAS;
    private javax.swing.JTable ListadeHoras;
    private javax.swing.JTextField Nombre;
    private javax.swing.JTextField codigo;
    private javax.swing.JButton imprimir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
