/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRESTACIONES;

import Clases.CalculosPrestaciones.Indemnizacion;
import Clases.CalculosPrestaciones.classIndemnizacion;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jluis
 */
public class CalculoIndemnización extends javax.swing.JInternalFrame {
      DecimalFormat formatter3 = new DecimalFormat("0.00");
      double  salariototal;
      Double salariopromedio12m;
    /**
     * Creates new form CalculoIndemnización
     */
    public CalculoIndemnización() {
        initComponents();
        
        
    }

    private void buscar() {

        try {
            classIndemnizacion p = Indemnizacion.buscarEmpleado(Integer.parseInt(Codigo.getText()));
            Nombre.setText(p.getNombre());// + ' ' + p.getApellidos());
            Salario.setText(formatter3.format(p.getSalario()));
            Bonificacion.setText(formatter3.format(p.getBonificacion()));
            FechaIngre.setText(p.getFechaIngre());
            buscapromedio6meses();
            ListarUltimosMesesLaborados();
            buscapromedio12meses();
            calculoIndemnizacion();
            Calculoaguinaldo();
            CalculoBono14();
            horaextra();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRORRRR" + e);
        }
    }
    
    private void buscapromedio6meses(){
         try {
            classIndemnizacion p = Indemnizacion.PromedioSalarioDias(Integer.parseInt(Codigo.getText()));
            salariopromedio.setText(formatter3.format(p.getSalario()));
            diasLaborados.setText(String.valueOf(p.getDias()));
            salariototal = p.getSalariopromedio();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRORRRR" + e);
        }
    }
    
    private void buscapromedio12meses(){
         try {
            classIndemnizacion p = Indemnizacion.PromedioSalario12meses(Integer.parseInt(Codigo.getText()));
            salariopromedio12m = p.getSalariopromedio12();
            salariopromedio12.setText(String.valueOf(salariopromedio12m));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRORRRR" + e);
        }
    
    }
    
    private void calculoIndemnizacion(){
         try {
             Double a = ((Double.parseDouble(salariopromedio.getText())));
             Double b = (Double.parseDouble(salariopromedio.getText()));
             Double c = a/365;
             Double d = c *(Integer.parseInt(diasLaborados.getText()));
             indemniacion.setText(formatter3.format(d));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRORRRR" + e);
        }
    }
    
    private void horaextra(){
           Double a = Double.parseDouble(Salario.getText());
           Double b = Double.parseDouble(Bonificacion.getText());
           Double c = (((a+b)-250)/30)*7/44*1.5;
           precioHoraExtra.setText(formatter3.format(c));
    }
    
    private void CalculoVacaciones(){
           //Double a = Double.parseDouble(DiasVaciones.getText());
           int a = (Integer.parseInt(diasLaboradosVacaciones.getText()));
           int d = (Integer.parseInt(DiasVaciones.getText()));
           Double b = (salariopromedio12m/365)*d;
           Double c = (b/30)*a;
           System.out.println("VACACIONES = "+b+" -- "+a+" -- "+d);
           Vacaciones.setText(formatter3.format(c));
    }
    
    private void Calculoaguinaldo(){
       
        Double a = (salariopromedio12m/365);
        int b = (Integer.parseInt(DiasAguinaldo.getText()));
        Double c = a*b;
        Aguinaldo.setText(formatter3.format(c));
    
    }
    private void CalculoBono14(){
     Double a = (salariopromedio12m/365);
        int b = (Integer.parseInt(DiasBono14.getText()));
        Double c = a*b;
        Bono14.setText(formatter3.format(c));
    }
    
    private void salariohorasbonicficacion(){
        
        Double a = (salariopromedio12m/30)* Double.parseDouble(DiasPendientes.getText());//ultino salario 
        salariosPendientes.setText(formatter3.format(a));
        
        Double b = (250/30)* Double.parseDouble(DiasPendientes.getText());
        BonificacionPendiente.setText(formatter3.format(b));   
        
        Double c = (Double.parseDouble(precioHoraExtra.getText()))* Double.parseDouble(HorasE.getText());
        HorasExtras.setText(formatter3.format(c));   
        
        
           
    
    
    }
    
    
    
    
    
    
    
    
    
    private void ListarUltimosMesesLaborados(){
        ArrayList<classIndemnizacion> result1 = Indemnizacion.ListarUltimosMeses(Integer.parseInt(Codigo.getText()));
        Listar(result1);  
    }
     private void Listar(ArrayList<classIndemnizacion> list1) {
         
              Object[][] datos = new Object[list1.size()][3];
              int i = 0;
              for(classIndemnizacion t : list1)
              {
                  datos[i][0] = t.getSalario();
                  datos[i][1] = t.getFecha();
                  datos[i][2] = t.getDias();//+' '+t.getApellidos();
                  i++;
              }    
             UltimosMeses.setModel(new javax.swing.table.DefaultTableModel(
                datos,
                new String[]{
                "SALARIO DEVENGADO","FECHA","DIAS TRABAJADOS"
             })
             {  
                 @Override
             public boolean isCellEditable(int row, int column){
             return false;
             }
             });
             /*TableColumn columna1 = Evaluaciones.getColumn("No.");
             columna1.setPreferredWidth(0);
             TableColumn columna2 = Evaluaciones.getColumn("CODIGO");
             columna2.setPreferredWidth(0);
             TableColumn columna3 = Evaluaciones.getColumn("NOMBRE");
             columna3.setPreferredWidth(150);
             TableColumn columna4 = Evaluaciones.getColumn("PUESTO");
             columna4.setPreferredWidth(150);
             */
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
        Codigo = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Nombre = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        Salario = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        Bonificacion = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        FechaIngre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        UltimosMeses = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        Bono14 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        salariosPendientes = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        BonificacionPendiente = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        HorasExtras = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        indemniacion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Vacaciones = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Aguinaldo = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        diasLaborados = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        salariopromedio = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        salariopromedio12 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        precioHoraExtra = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        HorasE = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        DiasVaciones = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel18 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        DiasPendientes = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        diasLaboradosVacaciones = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        DiasAguinaldo = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        DiasBono14 = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Calculo Indemnización");

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        jLabel1.setText("CODIGO");

        Codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CodigoActionPerformed(evt);
            }
        });

        jLabel2.setText("NOMBRE");

        Nombre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Nombre.setForeground(new java.awt.Color(51, 51, 255));
        Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreActionPerformed(evt);
            }
        });

        jLabel12.setText("SALARIO");

        Salario.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Salario.setForeground(new java.awt.Color(51, 51, 255));

        jLabel13.setText("BONIFICACION");

        Bonificacion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Bonificacion.setForeground(new java.awt.Color(51, 51, 255));

        jLabel17.setText("FECHA INGRESO");

        FechaIngre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        FechaIngre.setForeground(new java.awt.Color(51, 51, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Salario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                            .addComponent(Nombre, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Bonificacion)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FechaIngre, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(Salario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(Bonificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(FechaIngre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        UltimosMeses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SALARIO DEVENGADO", "FECHA", "DIAS TRABAJADOS"
            }
        ));
        jScrollPane1.setViewportView(UltimosMeses);

        jLabel8.setText("BONO 14");

        jButton2.setText("CALCULAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("IMPRIMIR");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Bono14, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Bono14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jButton2)
                .addGap(27, 27, 27)
                .addComponent(jButton1)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jLabel9.setText("SALARIOS PENDIENTES");

        jLabel10.setText("BONIFICACION PENDIENTE");

        jLabel11.setText("HORAS EXTRAORIDANARIAS PENDIENTES");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(HorasExtras, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(BonificacionPendiente, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(salariosPendientes, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(salariosPendientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BonificacionPendiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HorasExtras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel5.setText("INDEMNIZACION");

        jLabel6.setText("VACACIONES");

        jLabel7.setText("AGUINALDO");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(Vacaciones, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                    .addComponent(indemniacion)
                    .addComponent(Aguinaldo))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(indemniacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Vacaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Aguinaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jLabel4.setText("DIAS LABORADOS");

        jLabel3.setText("SALARIO PROMEDIO");

        jLabel22.setText("SALARIO PROMEDIO 12 meses");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(salariopromedio, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(diasLaborados, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(salariopromedio12)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(salariopromedio12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel22))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(diasLaborados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(salariopromedio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jLabel14.setText("PRECIO HORA EXTRA");

        precioHoraExtra.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        precioHoraExtra.setForeground(new java.awt.Color(51, 51, 255));
        precioHoraExtra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precioHoraExtraActionPerformed(evt);
            }
        });

        jLabel15.setText("HORAS EXTRAS PENDIENTES");

        HorasE.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        HorasE.setForeground(new java.awt.Color(51, 51, 255));
        HorasE.setText("0");
        HorasE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HorasEActionPerformed(evt);
            }
        });

        jLabel16.setText("DIAS DE VACACIONES");

        DiasVaciones.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        DiasVaciones.setForeground(new java.awt.Color(51, 51, 255));
        DiasVaciones.setText("10");
        DiasVaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DiasVacionesActionPerformed(evt);
            }
        });

        jLabel18.setText("FECHA DE BAJA");

        jLabel23.setText("DIAS PENDIENTES");

        DiasPendientes.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        DiasPendientes.setForeground(new java.awt.Color(51, 51, 255));
        DiasPendientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DiasPendientesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel23)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel15)
                        .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                            .addComponent(precioHoraExtra)
                            .addComponent(HorasE)
                            .addComponent(DiasVaciones))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(DiasPendientes, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(precioHoraExtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HorasE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(DiasPendientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DiasVaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(12, 12, 12))
        );

        jLabel19.setText("DIAS LABORADOS VACACIONES");

        diasLaboradosVacaciones.setText("150");
        diasLaboradosVacaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diasLaboradosVacacionesActionPerformed(evt);
            }
        });

        jLabel20.setText("DIAS LABORADOS AGUINALDO");

        DiasAguinaldo.setText("360");
        DiasAguinaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DiasAguinaldoActionPerformed(evt);
            }
        });

        jLabel21.setText("DIAS LABORADOS BONO 14");

        DiasBono14.setText("360");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(diasLaboradosVacaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(DiasAguinaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DiasBono14, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(diasLaboradosVacaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DiasAguinaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DiasBono14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CodigoActionPerformed
     buscar();
    }//GEN-LAST:event_CodigoActionPerformed

    private void NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        calculoIndemnizacion();
        horaextra();
        CalculoVacaciones();
        Calculoaguinaldo();
        CalculoBono14();
        salariohorasbonicficacion();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void precioHoraExtraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precioHoraExtraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_precioHoraExtraActionPerformed

    private void HorasEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HorasEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HorasEActionPerformed

    private void DiasVacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DiasVacionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DiasVacionesActionPerformed

    private void DiasAguinaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DiasAguinaldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DiasAguinaldoActionPerformed

    private void DiasPendientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DiasPendientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DiasPendientesActionPerformed

    private void diasLaboradosVacacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diasLaboradosVacacionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_diasLaboradosVacacionesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Aguinaldo;
    private javax.swing.JTextField Bonificacion;
    private javax.swing.JTextField BonificacionPendiente;
    private javax.swing.JTextField Bono14;
    private javax.swing.JTextField Codigo;
    private javax.swing.JTextField DiasAguinaldo;
    private javax.swing.JTextField DiasBono14;
    private javax.swing.JTextField DiasPendientes;
    private javax.swing.JTextField DiasVaciones;
    private javax.swing.JTextField FechaIngre;
    private javax.swing.JTextField HorasE;
    private javax.swing.JTextField HorasExtras;
    private javax.swing.JTextField Nombre;
    private javax.swing.JTextField Salario;
    private javax.swing.JTable UltimosMeses;
    private javax.swing.JTextField Vacaciones;
    private javax.swing.JTextField diasLaborados;
    private javax.swing.JTextField diasLaboradosVacaciones;
    private javax.swing.JTextField indemniacion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField precioHoraExtra;
    private javax.swing.JTextField salariopromedio;
    private javax.swing.JTextField salariopromedio12;
    private javax.swing.JTextField salariosPendientes;
    // End of variables declaration//GEN-END:variables
}
