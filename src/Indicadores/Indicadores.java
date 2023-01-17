/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Indicadores;

import BD.BD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import oracle.net.aso.n;

/**
 *
 * @author jluis
 */
public class Indicadores extends javax.swing.JInternalFrame {

    
    String fecha1;
    String fecha2;
    DefaultTableModel temp;
    int n;
    /**
     * Creates new form Indicadores
     */
    public Indicadores() {
        initComponents();
    }
    
     public void totalevaluaciones(){
    
     try {
             Connection cn = BD.getConnection();
             Statement ps = cn.createStatement();
             ResultSet rs = ps.executeQuery("select count(*) as todo from bevaluacion_desempeno b inner join alistaempleados a on b.id_listaempleados = a.id_listaempleados where \n" +
"b.fecha between to_date('"+fecha1+"','dd/mm/yy') and to_date('"+fecha2+"','dd/mm/yy') and b.estado = 2");
             rs.next();
             n = (rs.getInt("todo"));
             total.setText(String.valueOf(n));
             ps.close();
             rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR "+e);
        }
     }
    
     
     public void limpiartabla() {

        try {
            temp = (DefaultTableModel) evaluacionesRealizadas.getModel();
            int a = temp.getRowCount();
            for (int i = 0; i < a; i++) {
                temp.removeRow(i);
                i--;
            }
        } catch (Exception e) {

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
        FE1 = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        evaluacionesRealizadas = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();
        Nbusqueda = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setTitle("INDICADOR DE EVALUACIONES");

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("FECHA DE EVALUACION");

        evaluacionesRealizadas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "NOMBRES", "DEPARTAMENTO", "FECHA", "EVALUACION", "FASE"
            }
        ));
        jScrollPane1.setViewportView(evaluacionesRealizadas);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("TOTAL EVALUCIONES REALIZADAS");

        total.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        total.setForeground(new java.awt.Color(255, 0, 0));

        Nbusqueda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Search.png"))); // NOI18N
        Nbusqueda.setText("BUSCAR");
        Nbusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NbusquedaActionPerformed(evt);
            }
        });

        jButton1.setText("NUEVA CONSULTA");
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
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(FE1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(Nbusqueda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(266, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(FE1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Nbusqueda)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(31, Short.MAX_VALUE))
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

    private void NbusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NbusquedaActionPerformed
        
       
        
         try {
                
       if (FE1.getDate() != null ) {

            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yy");
            Date fec1 = FE1.getDate();
            Date fec2 = FE1.getDate();
            String fe1 = formato.format(fec1);
            String fe2 = formato.format(fec2);
             fecha1 = formato.format(fec1);
             fecha2 = formato.format(fec2);
                
                Date f1 = formato.parse(fe1);
                Date f2 = formato.parse(fe2);
            
                     ListaIndicardores();
                     totalevaluaciones();
                    FE1.setEnabled(false);
                    Nbusqueda.requestFocus();
                }
        
         }catch (ParseException ex) {
                Logger.getLogger(Indicadores.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }//GEN-LAST:event_NbusquedaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        limpiartabla();
        FE1.setDate(null);
        FE1.setEnabled(true);
        total.setText("");
        
    }//GEN-LAST:event_jButton1ActionPerformed
    
    
    
    private void ListaIndicardores() {
        ArrayList<ClassIndicador> result = coneIndicadores.ListarTodosProductos(fecha1, fecha1);
        recargarTablaPro(result);
    }
    public void recargarTablaPro(ArrayList<ClassIndicador> list) {
        Object[][] datos = new Object[list.size()][6];
        int i = 0;
        for (ClassIndicador f : list)
        {
            datos[i][0] = f.getCodigo();
            datos[i][1] = f.getNombre();
            datos[i][2] = f.getDepto();
            datos[i][3] = f.getFecha();
            datos[i][4] = f.getEvaluacion();
            datos[i][5] = f.getFase();
            i++;
        }
        evaluacionesRealizadas.setModel(new javax.swing.table.DefaultTableModel(
                datos,
                new String[]{
                    "CODIGO","NOMBRES","DEPARTAMENTO","FECHA","EVALUACION","FASE"
                }) {
                     @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        
        TableColumn columna1 = evaluacionesRealizadas.getColumn("CODIGO");
        columna1.setPreferredWidth(0);
        TableColumn columna2 = evaluacionesRealizadas.getColumn("NOMBRES");
        columna2.setPreferredWidth(150);
         TableColumn columna3 = evaluacionesRealizadas.getColumn("DEPARTAMENTO");
        columna3.setPreferredWidth(200);
    }
    
    
    
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser FE1;
    private javax.swing.JButton Nbusqueda;
    private javax.swing.JTable evaluacionesRealizadas;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField total;
    // End of variables declaration//GEN-END:variables
}