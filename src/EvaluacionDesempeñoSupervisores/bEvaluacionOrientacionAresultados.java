/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EvaluacionDesempeñoSupervisores;

import EvaluacionDesempeñoOperativo.*;
import BD.BD;
import Clases.EvaluacionSupervisores.ClassEvaluacionSupervisores;
import static Formuarios.Inicio.Pane1;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
//import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author jluis
 */
public class bEvaluacionOrientacionAresultados extends javax.swing.JInternalFrame {
     int total;
     int id_evaluacion;
     int codigo;
    /**
     * Creates new form EvaluacionD
     */
    public bEvaluacionOrientacionAresultados(int i, int c) {
        this.id_evaluacion = i;
        this.codigo = c;
        initComponents();
        jLabel1.setText("<html><b>Define prioridades y orienta a su equipo a lograr los objetivos</b></html>");
        jLabel2.setText("<html><b>Acuerda con su equipo la entrega de los resultados en el tiempo\n" +
                        "establecido</b></html>");
        jLabel3.setText("<html><b>Promueve con su equipo la utilización adecuada de los recursos para\n" +
        "realizar su trabajo</b></html>");
        jLabel4.setText("<html><b>Investiga y busca conocimiento sobre temas relacionados con su\n" +
        "trabajo</b></html>");
        jLabel5.setText("<html><b>Incorpora mejoras en los procesos bajo su responsabilidad</b></html>");
        
        jLabel6.setText("<html><b>2. Orientación a resultados: realizar las funciones y cumplir los compromisos organizacionales con eficacia y calidad.</b></html>");
        l1.setText("<html><b><center> por debajo de lo esperado <br> 0 - 50 </center></b></html>");
        l2.setText("<html><b><center> A mejorar <br> 51 - 65 </center></b></html>");
        l3.setText("<html><b><center> Aceptable <br> 66 - 84 </center></b></html>");
        l4.setText("<html><b><center> Destacado <br> 85 - 100 </center></b></html>");
        foto();
    
    }
    
     private void suma(){
         
         String UNO0,DOS0,TRES0,CUATRO0,
             UNO01,DOS01,TRES01,CUATRO01,
             UNO02,DOS02,TRES02,CUATRO02,
             UNO03,DOS03,TRES03,CUATRO03,
             UNO04,DOS04,TRES04,CUATRO04; 
         
         int UNO00,DOS00,TRES00,CUATRO00,
             UNO001,DOS001,TRES001,CUATRO001,
             UNO002,DOS002,TRES002,CUATRO002,
             UNO003,DOS003,TRES003,CUATRO003,
             UNO004,DOS004,TRES004,CUATRO004; 
         
          
    UNO0 =  UNO.getText();DOS0 = DOS.getText();TRES0 = TRES.getText();CUATRO0 = CUATRO.getText();
    UNO01 =  UNO1.getText();DOS01 = DOS1.getText();TRES01 = TRES1.getText();CUATRO01 = CUATRO1.getText();
    UNO02 =  UNO2.getText();DOS02 = DOS2.getText();TRES02 = TRES2.getText();CUATRO02 = CUATRO2.getText();
    UNO03 =  UNO3.getText();DOS03 = DOS3.getText();TRES03 = TRES3.getText();CUATRO03 = CUATRO3.getText();
    UNO04 =  UNO4.getText();DOS04 = DOS4.getText();TRES04 = TRES4.getText();CUATRO04 = CUATRO4.getText();
    
    UNO00 = Integer.parseInt(UNO0);DOS00 = Integer.parseInt(DOS0);TRES00 = Integer.parseInt(TRES0);CUATRO00 = Integer.parseInt(CUATRO0);
    UNO001 = Integer.parseInt(UNO01);DOS001 = Integer.parseInt(DOS01);TRES001 = Integer.parseInt(TRES01);CUATRO001 = Integer.parseInt(CUATRO01);
    UNO002 = Integer.parseInt(UNO02);DOS002 = Integer.parseInt(DOS02);TRES002 = Integer.parseInt(TRES02);CUATRO002 = Integer.parseInt(CUATRO02);
    UNO003 = Integer.parseInt(UNO03);DOS003 = Integer.parseInt(DOS03);TRES003 = Integer.parseInt(TRES03);CUATRO003 = Integer.parseInt(CUATRO03);
    UNO004 = Integer.parseInt(UNO04);DOS004 = Integer.parseInt(DOS04);TRES004 = Integer.parseInt(TRES04);CUATRO004 = Integer.parseInt(CUATRO04);
   
         
    total = (UNO00+UNO001+UNO002+UNO003+UNO004+DOS00+DOS001+DOS002+DOS003+DOS004+TRES00+TRES001+TRES002+TRES003+TRES004+CUATRO00+CUATRO001+CUATRO002+CUATRO003+CUATRO004)/5;
        
    TxtTotal.setText(Integer.toString(total));
    if((total >= 0 && total <=50)){punteo.setText("Por debajo de lo esperado");}
    else if((total >= 51 && total<=65)){punteo.setText("A mejorar");}
    else if((total >= 66 && total<=84)){punteo.setText("Aceptable");}
    else if((total >= 85 && total<=100)){punteo.setText("Destacado");}
    
     } 
     
    private void foto(){
    
    try {
                String sql = "select fotografia from alistaempleados where codigo = " + codigo;
                ImageIcon foto;
                InputStream is;
                Connection cnn = BD.getConnection();
                PreparedStatement ps = null;
                ps = cnn.prepareStatement(sql);
                ResultSet r = ps.executeQuery();
                while (r.next()) {
                    is = r.getBinaryStream(1);
                    BufferedImage bi = ImageIO.read(is);
                    foto = new ImageIcon(bi);
                    Image img = foto.getImage();
                    Image newimg = img.getScaledInstance(163, 151, java.awt.Image.SCALE_SMOOTH);
                    ImageIcon newicon = new ImageIcon(newimg);
                    LabelFoto1.setIcon(newicon);
                }} catch (Exception e) {
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

        jPanel22 = new javax.swing.JPanel();
        uno19 = new javax.swing.JButton();
        dos19 = new javax.swing.JButton();
        tres19 = new javax.swing.JButton();
        jTextField20 = new javax.swing.JTextField();
        jPanel23 = new javax.swing.JPanel();
        uno20 = new javax.swing.JButton();
        dos20 = new javax.swing.JButton();
        tres20 = new javax.swing.JButton();
        jTextField21 = new javax.swing.JTextField();
        jPanel24 = new javax.swing.JPanel();
        uno21 = new javax.swing.JButton();
        dos21 = new javax.swing.JButton();
        tres21 = new javax.swing.JButton();
        jTextField22 = new javax.swing.JTextField();
        jPanel25 = new javax.swing.JPanel();
        uno22 = new javax.swing.JButton();
        dos22 = new javax.swing.JButton();
        tres22 = new javax.swing.JButton();
        jTextField23 = new javax.swing.JTextField();
        jPanel33 = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        dos30 = new javax.swing.JButton();
        tres30 = new javax.swing.JButton();
        jTextField31 = new javax.swing.JTextField();
        uno30 = new javax.swing.JButton();
        jPanel35 = new javax.swing.JPanel();
        dos31 = new javax.swing.JButton();
        tres31 = new javax.swing.JButton();
        jTextField32 = new javax.swing.JTextField();
        uno31 = new javax.swing.JButton();
        jPanel36 = new javax.swing.JPanel();
        dos32 = new javax.swing.JButton();
        tres32 = new javax.swing.JButton();
        jTextField33 = new javax.swing.JTextField();
        uno32 = new javax.swing.JButton();
        jPanel37 = new javax.swing.JPanel();
        dos33 = new javax.swing.JButton();
        tres33 = new javax.swing.JButton();
        jTextField34 = new javax.swing.JTextField();
        uno33 = new javax.swing.JButton();
        jPanel43 = new javax.swing.JPanel();
        jPanel44 = new javax.swing.JPanel();
        dos38 = new javax.swing.JButton();
        tres38 = new javax.swing.JButton();
        jTextField39 = new javax.swing.JTextField();
        uno38 = new javax.swing.JButton();
        jPanel45 = new javax.swing.JPanel();
        dos39 = new javax.swing.JButton();
        tres39 = new javax.swing.JButton();
        jTextField40 = new javax.swing.JTextField();
        uno39 = new javax.swing.JButton();
        jPanel46 = new javax.swing.JPanel();
        dos40 = new javax.swing.JButton();
        tres40 = new javax.swing.JButton();
        jTextField41 = new javax.swing.JTextField();
        uno40 = new javax.swing.JButton();
        jPanel47 = new javax.swing.JPanel();
        dos41 = new javax.swing.JButton();
        tres41 = new javax.swing.JButton();
        jTextField42 = new javax.swing.JTextField();
        uno41 = new javax.swing.JButton();
        jPanel58 = new javax.swing.JPanel();
        jPanel59 = new javax.swing.JPanel();
        dos50 = new javax.swing.JButton();
        tres50 = new javax.swing.JButton();
        jTextField51 = new javax.swing.JTextField();
        uno50 = new javax.swing.JButton();
        jPanel60 = new javax.swing.JPanel();
        dos51 = new javax.swing.JButton();
        tres51 = new javax.swing.JButton();
        jTextField52 = new javax.swing.JTextField();
        uno51 = new javax.swing.JButton();
        jPanel61 = new javax.swing.JPanel();
        dos52 = new javax.swing.JButton();
        tres52 = new javax.swing.JButton();
        jTextField53 = new javax.swing.JTextField();
        uno52 = new javax.swing.JButton();
        jPanel62 = new javax.swing.JPanel();
        dos53 = new javax.swing.JButton();
        tres53 = new javax.swing.JButton();
        jTextField54 = new javax.swing.JTextField();
        uno53 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        dos = new javax.swing.JButton();
        tres = new javax.swing.JButton();
        UNO = new javax.swing.JTextField();
        uno = new javax.swing.JButton();
        jPanel30 = new javax.swing.JPanel();
        dos27 = new javax.swing.JButton();
        tres27 = new javax.swing.JButton();
        DOS = new javax.swing.JTextField();
        uno27 = new javax.swing.JButton();
        jPanel31 = new javax.swing.JPanel();
        dos28 = new javax.swing.JButton();
        tres28 = new javax.swing.JButton();
        TRES = new javax.swing.JTextField();
        uno28 = new javax.swing.JButton();
        jPanel32 = new javax.swing.JPanel();
        dos29 = new javax.swing.JButton();
        tres29 = new javax.swing.JButton();
        CUATRO = new javax.swing.JTextField();
        uno29 = new javax.swing.JButton();
        jPanel38 = new javax.swing.JPanel();
        jPanel39 = new javax.swing.JPanel();
        dos34 = new javax.swing.JButton();
        tres34 = new javax.swing.JButton();
        UNO1 = new javax.swing.JTextField();
        uno34 = new javax.swing.JButton();
        jPanel40 = new javax.swing.JPanel();
        dos35 = new javax.swing.JButton();
        tres35 = new javax.swing.JButton();
        DOS1 = new javax.swing.JTextField();
        uno35 = new javax.swing.JButton();
        jPanel41 = new javax.swing.JPanel();
        dos36 = new javax.swing.JButton();
        tres36 = new javax.swing.JButton();
        TRES1 = new javax.swing.JTextField();
        uno36 = new javax.swing.JButton();
        jPanel42 = new javax.swing.JPanel();
        dos37 = new javax.swing.JButton();
        tres37 = new javax.swing.JButton();
        CUATRO1 = new javax.swing.JTextField();
        uno37 = new javax.swing.JButton();
        jPanel48 = new javax.swing.JPanel();
        jPanel49 = new javax.swing.JPanel();
        dos42 = new javax.swing.JButton();
        tres42 = new javax.swing.JButton();
        UNO2 = new javax.swing.JTextField();
        uno42 = new javax.swing.JButton();
        jPanel50 = new javax.swing.JPanel();
        dos43 = new javax.swing.JButton();
        tres43 = new javax.swing.JButton();
        DOS2 = new javax.swing.JTextField();
        uno43 = new javax.swing.JButton();
        jPanel51 = new javax.swing.JPanel();
        dos44 = new javax.swing.JButton();
        tres44 = new javax.swing.JButton();
        TRES2 = new javax.swing.JTextField();
        uno44 = new javax.swing.JButton();
        jPanel52 = new javax.swing.JPanel();
        dos45 = new javax.swing.JButton();
        tres45 = new javax.swing.JButton();
        CUATRO2 = new javax.swing.JTextField();
        uno45 = new javax.swing.JButton();
        jPanel53 = new javax.swing.JPanel();
        jPanel54 = new javax.swing.JPanel();
        dos46 = new javax.swing.JButton();
        tres46 = new javax.swing.JButton();
        UNO3 = new javax.swing.JTextField();
        uno46 = new javax.swing.JButton();
        jPanel55 = new javax.swing.JPanel();
        dos47 = new javax.swing.JButton();
        tres47 = new javax.swing.JButton();
        DOS3 = new javax.swing.JTextField();
        uno47 = new javax.swing.JButton();
        jPanel56 = new javax.swing.JPanel();
        dos48 = new javax.swing.JButton();
        tres48 = new javax.swing.JButton();
        TRES3 = new javax.swing.JTextField();
        uno48 = new javax.swing.JButton();
        jPanel57 = new javax.swing.JPanel();
        dos49 = new javax.swing.JButton();
        tres49 = new javax.swing.JButton();
        CUATRO3 = new javax.swing.JTextField();
        uno49 = new javax.swing.JButton();
        jPanel63 = new javax.swing.JPanel();
        jPanel64 = new javax.swing.JPanel();
        dos54 = new javax.swing.JButton();
        tres54 = new javax.swing.JButton();
        UNO4 = new javax.swing.JTextField();
        uno54 = new javax.swing.JButton();
        jPanel65 = new javax.swing.JPanel();
        dos55 = new javax.swing.JButton();
        tres55 = new javax.swing.JButton();
        DOS4 = new javax.swing.JTextField();
        uno55 = new javax.swing.JButton();
        jPanel66 = new javax.swing.JPanel();
        dos56 = new javax.swing.JButton();
        tres56 = new javax.swing.JButton();
        TRES4 = new javax.swing.JTextField();
        uno56 = new javax.swing.JButton();
        jPanel67 = new javax.swing.JPanel();
        dos57 = new javax.swing.JButton();
        tres57 = new javax.swing.JButton();
        CUATRO4 = new javax.swing.JTextField();
        uno57 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        l1 = new javax.swing.JLabel();
        l2 = new javax.swing.JLabel();
        l3 = new javax.swing.JLabel();
        l4 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jPanel6 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        TxtTotal = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        punteo = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        NOTA = new javax.swing.JTextArea();
        jLabel22 = new javax.swing.JLabel();
        LabelFoto1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        uno19.setMargin(new java.awt.Insets(1, 1, 1, 1));
        uno19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uno19ActionPerformed(evt);
            }
        });

        dos19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dos19ActionPerformed(evt);
            }
        });

        tres19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tres19ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(uno19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dos19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tres19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jTextField20)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tres19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(dos19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uno19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        uno20.setMargin(new java.awt.Insets(1, 1, 1, 1));
        uno20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uno20ActionPerformed(evt);
            }
        });

        dos20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dos20ActionPerformed(evt);
            }
        });

        tres20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tres20ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(uno20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dos20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tres20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jTextField21)
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tres20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(dos20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uno20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        uno21.setMargin(new java.awt.Insets(1, 1, 1, 1));
        uno21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uno21ActionPerformed(evt);
            }
        });

        dos21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dos21ActionPerformed(evt);
            }
        });

        tres21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tres21ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(uno21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dos21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tres21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jTextField22)
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tres21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(dos21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uno21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        uno22.setMargin(new java.awt.Insets(1, 1, 1, 1));
        uno22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uno22ActionPerformed(evt);
            }
        });

        dos22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dos22ActionPerformed(evt);
            }
        });

        tres22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tres22ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(uno22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dos22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tres22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jTextField23)
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tres22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(dos22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uno22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        dos30.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        dos30.setMargin(new java.awt.Insets(0, 0, 0, 0));
        dos30.setPreferredSize(new java.awt.Dimension(35, 26));
        dos30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dos30ActionPerformed(evt);
            }
        });

        tres30.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        tres30.setMargin(new java.awt.Insets(0, 0, 0, 0));
        tres30.setPreferredSize(new java.awt.Dimension(35, 26));
        tres30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tres30ActionPerformed(evt);
            }
        });

        jTextField31.setMinimumSize(new java.awt.Dimension(6, 22));

        uno30.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        uno30.setAlignmentY(0.0F);
        uno30.setBorderPainted(false);
        uno30.setMargin(new java.awt.Insets(0, 0, 0, 0));
        uno30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uno30ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField31, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel34Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(uno30, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dos30, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tres30, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(139, 139, 139))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dos30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tres30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uno30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        dos31.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        dos31.setMargin(new java.awt.Insets(0, 0, 0, 0));
        dos31.setPreferredSize(new java.awt.Dimension(35, 26));
        dos31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dos31ActionPerformed(evt);
            }
        });

        tres31.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        tres31.setMargin(new java.awt.Insets(0, 0, 0, 0));
        tres31.setPreferredSize(new java.awt.Dimension(35, 26));
        tres31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tres31ActionPerformed(evt);
            }
        });

        jTextField32.setMinimumSize(new java.awt.Dimension(6, 22));

        uno31.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        uno31.setAlignmentY(0.0F);
        uno31.setBorderPainted(false);
        uno31.setMargin(new java.awt.Insets(0, 0, 0, 0));
        uno31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uno31ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel35Layout.createSequentialGroup()
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField32, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(uno31, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dos31, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tres31, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(139, 139, 139))
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dos31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tres31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uno31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        dos32.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        dos32.setMargin(new java.awt.Insets(0, 0, 0, 0));
        dos32.setPreferredSize(new java.awt.Dimension(35, 26));
        dos32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dos32ActionPerformed(evt);
            }
        });

        tres32.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        tres32.setMargin(new java.awt.Insets(0, 0, 0, 0));
        tres32.setPreferredSize(new java.awt.Dimension(35, 26));
        tres32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tres32ActionPerformed(evt);
            }
        });

        jTextField33.setMinimumSize(new java.awt.Dimension(6, 22));

        uno32.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        uno32.setAlignmentY(0.0F);
        uno32.setBorderPainted(false);
        uno32.setMargin(new java.awt.Insets(0, 0, 0, 0));
        uno32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uno32ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup()
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField33, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(uno32, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dos32, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tres32, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(139, 139, 139))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dos32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tres32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uno32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        dos33.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        dos33.setMargin(new java.awt.Insets(0, 0, 0, 0));
        dos33.setPreferredSize(new java.awt.Dimension(35, 26));
        dos33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dos33ActionPerformed(evt);
            }
        });

        tres33.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        tres33.setMargin(new java.awt.Insets(0, 0, 0, 0));
        tres33.setPreferredSize(new java.awt.Dimension(35, 26));
        tres33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tres33ActionPerformed(evt);
            }
        });

        jTextField34.setMinimumSize(new java.awt.Dimension(6, 22));

        uno33.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        uno33.setAlignmentY(0.0F);
        uno33.setBorderPainted(false);
        uno33.setMargin(new java.awt.Insets(0, 0, 0, 0));
        uno33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uno33ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup()
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField34, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(uno33, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dos33, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tres33, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(139, 139, 139))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dos33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tres33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uno33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel34, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel35, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel36, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel37, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        dos38.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        dos38.setMargin(new java.awt.Insets(0, 0, 0, 0));
        dos38.setPreferredSize(new java.awt.Dimension(35, 26));
        dos38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dos38ActionPerformed(evt);
            }
        });

        tres38.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        tres38.setMargin(new java.awt.Insets(0, 0, 0, 0));
        tres38.setPreferredSize(new java.awt.Dimension(35, 26));
        tres38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tres38ActionPerformed(evt);
            }
        });

        jTextField39.setMinimumSize(new java.awt.Dimension(6, 22));

        uno38.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        uno38.setAlignmentY(0.0F);
        uno38.setBorderPainted(false);
        uno38.setMargin(new java.awt.Insets(0, 0, 0, 0));
        uno38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uno38ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel44Layout.createSequentialGroup()
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField39, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel44Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(uno38, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dos38, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tres38, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(139, 139, 139))
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dos38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tres38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uno38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField39, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        dos39.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        dos39.setMargin(new java.awt.Insets(0, 0, 0, 0));
        dos39.setPreferredSize(new java.awt.Dimension(35, 26));
        dos39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dos39ActionPerformed(evt);
            }
        });

        tres39.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        tres39.setMargin(new java.awt.Insets(0, 0, 0, 0));
        tres39.setPreferredSize(new java.awt.Dimension(35, 26));
        tres39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tres39ActionPerformed(evt);
            }
        });

        jTextField40.setMinimumSize(new java.awt.Dimension(6, 22));

        uno39.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        uno39.setAlignmentY(0.0F);
        uno39.setBorderPainted(false);
        uno39.setMargin(new java.awt.Insets(0, 0, 0, 0));
        uno39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uno39ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel45Layout.createSequentialGroup()
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField40, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel45Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(uno39, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dos39, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tres39, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(139, 139, 139))
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dos39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tres39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uno39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField40, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        dos40.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        dos40.setMargin(new java.awt.Insets(0, 0, 0, 0));
        dos40.setPreferredSize(new java.awt.Dimension(35, 26));
        dos40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dos40ActionPerformed(evt);
            }
        });

        tres40.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        tres40.setMargin(new java.awt.Insets(0, 0, 0, 0));
        tres40.setPreferredSize(new java.awt.Dimension(35, 26));
        tres40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tres40ActionPerformed(evt);
            }
        });

        jTextField41.setMinimumSize(new java.awt.Dimension(6, 22));

        uno40.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        uno40.setAlignmentY(0.0F);
        uno40.setBorderPainted(false);
        uno40.setMargin(new java.awt.Insets(0, 0, 0, 0));
        uno40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uno40ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel46Layout.createSequentialGroup()
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField41, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel46Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(uno40, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dos40, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tres40, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(139, 139, 139))
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dos40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tres40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uno40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField41, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        dos41.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        dos41.setMargin(new java.awt.Insets(0, 0, 0, 0));
        dos41.setPreferredSize(new java.awt.Dimension(35, 26));
        dos41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dos41ActionPerformed(evt);
            }
        });

        tres41.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        tres41.setMargin(new java.awt.Insets(0, 0, 0, 0));
        tres41.setPreferredSize(new java.awt.Dimension(35, 26));
        tres41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tres41ActionPerformed(evt);
            }
        });

        jTextField42.setMinimumSize(new java.awt.Dimension(6, 22));

        uno41.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        uno41.setAlignmentY(0.0F);
        uno41.setBorderPainted(false);
        uno41.setMargin(new java.awt.Insets(0, 0, 0, 0));
        uno41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uno41ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel47Layout.createSequentialGroup()
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField42, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel47Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(uno41, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dos41, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tres41, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(139, 139, 139))
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dos41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tres41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uno41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField42, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel44, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel45, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel46, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel47, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        dos50.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        dos50.setMargin(new java.awt.Insets(0, 0, 0, 0));
        dos50.setPreferredSize(new java.awt.Dimension(35, 26));
        dos50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dos50ActionPerformed(evt);
            }
        });

        tres50.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        tres50.setMargin(new java.awt.Insets(0, 0, 0, 0));
        tres50.setPreferredSize(new java.awt.Dimension(35, 26));
        tres50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tres50ActionPerformed(evt);
            }
        });

        jTextField51.setMinimumSize(new java.awt.Dimension(6, 22));

        uno50.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        uno50.setAlignmentY(0.0F);
        uno50.setBorderPainted(false);
        uno50.setMargin(new java.awt.Insets(0, 0, 0, 0));
        uno50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uno50ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel59Layout = new javax.swing.GroupLayout(jPanel59);
        jPanel59.setLayout(jPanel59Layout);
        jPanel59Layout.setHorizontalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel59Layout.createSequentialGroup()
                .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField51, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel59Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(uno50, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dos50, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tres50, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(139, 139, 139))
        );
        jPanel59Layout.setVerticalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel59Layout.createSequentialGroup()
                .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dos50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tres50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uno50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField51, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        dos51.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        dos51.setMargin(new java.awt.Insets(0, 0, 0, 0));
        dos51.setPreferredSize(new java.awt.Dimension(35, 26));
        dos51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dos51ActionPerformed(evt);
            }
        });

        tres51.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        tres51.setMargin(new java.awt.Insets(0, 0, 0, 0));
        tres51.setPreferredSize(new java.awt.Dimension(35, 26));
        tres51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tres51ActionPerformed(evt);
            }
        });

        jTextField52.setMinimumSize(new java.awt.Dimension(6, 22));

        uno51.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        uno51.setAlignmentY(0.0F);
        uno51.setBorderPainted(false);
        uno51.setMargin(new java.awt.Insets(0, 0, 0, 0));
        uno51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uno51ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel60Layout = new javax.swing.GroupLayout(jPanel60);
        jPanel60.setLayout(jPanel60Layout);
        jPanel60Layout.setHorizontalGroup(
            jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel60Layout.createSequentialGroup()
                .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField52, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel60Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(uno51, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dos51, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tres51, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(139, 139, 139))
        );
        jPanel60Layout.setVerticalGroup(
            jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel60Layout.createSequentialGroup()
                .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dos51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tres51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uno51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField52, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        dos52.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        dos52.setMargin(new java.awt.Insets(0, 0, 0, 0));
        dos52.setPreferredSize(new java.awt.Dimension(35, 26));
        dos52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dos52ActionPerformed(evt);
            }
        });

        tres52.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        tres52.setMargin(new java.awt.Insets(0, 0, 0, 0));
        tres52.setPreferredSize(new java.awt.Dimension(35, 26));
        tres52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tres52ActionPerformed(evt);
            }
        });

        jTextField53.setMinimumSize(new java.awt.Dimension(6, 22));

        uno52.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        uno52.setAlignmentY(0.0F);
        uno52.setBorderPainted(false);
        uno52.setMargin(new java.awt.Insets(0, 0, 0, 0));
        uno52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uno52ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel61Layout = new javax.swing.GroupLayout(jPanel61);
        jPanel61.setLayout(jPanel61Layout);
        jPanel61Layout.setHorizontalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel61Layout.createSequentialGroup()
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField53, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel61Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(uno52, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dos52, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tres52, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(139, 139, 139))
        );
        jPanel61Layout.setVerticalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel61Layout.createSequentialGroup()
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dos52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tres52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uno52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField53, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        dos53.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        dos53.setMargin(new java.awt.Insets(0, 0, 0, 0));
        dos53.setPreferredSize(new java.awt.Dimension(35, 26));
        dos53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dos53ActionPerformed(evt);
            }
        });

        tres53.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        tres53.setMargin(new java.awt.Insets(0, 0, 0, 0));
        tres53.setPreferredSize(new java.awt.Dimension(35, 26));
        tres53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tres53ActionPerformed(evt);
            }
        });

        jTextField54.setMinimumSize(new java.awt.Dimension(6, 22));

        uno53.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        uno53.setAlignmentY(0.0F);
        uno53.setBorderPainted(false);
        uno53.setMargin(new java.awt.Insets(0, 0, 0, 0));
        uno53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uno53ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel62Layout = new javax.swing.GroupLayout(jPanel62);
        jPanel62.setLayout(jPanel62Layout);
        jPanel62Layout.setHorizontalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel62Layout.createSequentialGroup()
                .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField54, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel62Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(uno53, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dos53, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tres53, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(139, 139, 139))
        );
        jPanel62Layout.setVerticalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel62Layout.createSequentialGroup()
                .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dos53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tres53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uno53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField54, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel58Layout = new javax.swing.GroupLayout(jPanel58);
        jPanel58.setLayout(jPanel58Layout);
        jPanel58Layout.setHorizontalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel58Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel59, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel60, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel61, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel62, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel58Layout.setVerticalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel58Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel59, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel60, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel61, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel62, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jLabel8.setText("jLabel7");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel10.setText("jLabel7");
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel12.setText("jLabel7");
        jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("EVALUACION DESEMPEÑO -ORIENTACION A RESULTADOS-");
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

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("jLabel2"); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("jLabel3");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("jLabel4");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("jLabel5");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("jLabel1");

        jPanel2.setBackground(new java.awt.Color(102, 204, 255));

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));

        dos.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        dos.setMargin(new java.awt.Insets(0, 0, 0, 0));
        dos.setPreferredSize(new java.awt.Dimension(35, 26));
        dos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dosActionPerformed(evt);
            }
        });

        tres.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        tres.setMargin(new java.awt.Insets(0, 0, 0, 0));
        tres.setPreferredSize(new java.awt.Dimension(35, 26));
        tres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tresActionPerformed(evt);
            }
        });

        UNO.setEditable(false);
        UNO.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        UNO.setForeground(new java.awt.Color(240, 240, 240));
        UNO.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        UNO.setText("0");
        UNO.setMinimumSize(new java.awt.Dimension(6, 22));

        uno.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        uno.setAlignmentY(0.0F);
        uno.setBorderPainted(false);
        uno.setMargin(new java.awt.Insets(0, 0, 0, 0));
        uno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UNO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(uno, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tres, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(139, 139, 139))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UNO, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel30.setBackground(new java.awt.Color(255, 255, 255));

        dos27.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        dos27.setMargin(new java.awt.Insets(0, 0, 0, 0));
        dos27.setPreferredSize(new java.awt.Dimension(35, 26));
        dos27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dos27ActionPerformed(evt);
            }
        });

        tres27.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        tres27.setMargin(new java.awt.Insets(0, 0, 0, 0));
        tres27.setPreferredSize(new java.awt.Dimension(35, 26));
        tres27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tres27ActionPerformed(evt);
            }
        });

        DOS.setEditable(false);
        DOS.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        DOS.setForeground(new java.awt.Color(240, 240, 240));
        DOS.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        DOS.setText("0");
        DOS.setMinimumSize(new java.awt.Dimension(6, 22));

        uno27.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        uno27.setAlignmentY(0.0F);
        uno27.setBorderPainted(false);
        uno27.setMargin(new java.awt.Insets(0, 0, 0, 0));
        uno27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uno27ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DOS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addComponent(uno27, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dos27, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tres27, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(139, 139, 139))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dos27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tres27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uno27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DOS, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel31.setBackground(new java.awt.Color(102, 102, 102));

        dos28.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        dos28.setMargin(new java.awt.Insets(0, 0, 0, 0));
        dos28.setPreferredSize(new java.awt.Dimension(35, 26));
        dos28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dos28ActionPerformed(evt);
            }
        });

        tres28.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        tres28.setMargin(new java.awt.Insets(0, 0, 0, 0));
        tres28.setPreferredSize(new java.awt.Dimension(35, 26));
        tres28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tres28ActionPerformed(evt);
            }
        });

        TRES.setEditable(false);
        TRES.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        TRES.setForeground(new java.awt.Color(240, 240, 240));
        TRES.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TRES.setText("0");
        TRES.setMinimumSize(new java.awt.Dimension(6, 22));

        uno28.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        uno28.setAlignmentY(0.0F);
        uno28.setBorderPainted(false);
        uno28.setMargin(new java.awt.Insets(0, 0, 0, 0));
        uno28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uno28ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TRES, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(uno28, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dos28, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tres28, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(139, 139, 139))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dos28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tres28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uno28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TRES, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel32.setBackground(new java.awt.Color(255, 255, 255));

        dos29.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        dos29.setMargin(new java.awt.Insets(0, 0, 0, 0));
        dos29.setPreferredSize(new java.awt.Dimension(35, 26));
        dos29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dos29ActionPerformed(evt);
            }
        });

        tres29.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        tres29.setMargin(new java.awt.Insets(0, 0, 0, 0));
        tres29.setPreferredSize(new java.awt.Dimension(35, 26));
        tres29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tres29ActionPerformed(evt);
            }
        });

        CUATRO.setEditable(false);
        CUATRO.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        CUATRO.setForeground(new java.awt.Color(240, 240, 240));
        CUATRO.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CUATRO.setText("0");
        CUATRO.setMinimumSize(new java.awt.Dimension(6, 22));

        uno29.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        uno29.setAlignmentY(0.0F);
        uno29.setBorderPainted(false);
        uno29.setMargin(new java.awt.Insets(0, 0, 0, 0));
        uno29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uno29ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CUATRO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addComponent(uno29, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dos29, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tres29, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(139, 139, 139))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dos29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tres29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uno29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CUATRO, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel38.setBackground(new java.awt.Color(102, 204, 255));

        jPanel39.setBackground(new java.awt.Color(102, 102, 102));

        dos34.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        dos34.setMargin(new java.awt.Insets(0, 0, 0, 0));
        dos34.setPreferredSize(new java.awt.Dimension(35, 26));
        dos34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dos34ActionPerformed(evt);
            }
        });

        tres34.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        tres34.setMargin(new java.awt.Insets(0, 0, 0, 0));
        tres34.setPreferredSize(new java.awt.Dimension(35, 26));
        tres34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tres34ActionPerformed(evt);
            }
        });

        UNO1.setEditable(false);
        UNO1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        UNO1.setForeground(new java.awt.Color(240, 240, 240));
        UNO1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        UNO1.setText("0");
        UNO1.setMinimumSize(new java.awt.Dimension(6, 22));

        uno34.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        uno34.setAlignmentY(0.0F);
        uno34.setBorderPainted(false);
        uno34.setMargin(new java.awt.Insets(0, 0, 0, 0));
        uno34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uno34ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UNO1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel39Layout.createSequentialGroup()
                        .addComponent(uno34, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dos34, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tres34, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(139, 139, 139))
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dos34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tres34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uno34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UNO1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel40.setBackground(new java.awt.Color(255, 255, 255));

        dos35.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        dos35.setMargin(new java.awt.Insets(0, 0, 0, 0));
        dos35.setPreferredSize(new java.awt.Dimension(35, 26));
        dos35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dos35ActionPerformed(evt);
            }
        });

        tres35.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        tres35.setMargin(new java.awt.Insets(0, 0, 0, 0));
        tres35.setPreferredSize(new java.awt.Dimension(35, 26));
        tres35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tres35ActionPerformed(evt);
            }
        });

        DOS1.setEditable(false);
        DOS1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        DOS1.setForeground(new java.awt.Color(240, 240, 240));
        DOS1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        DOS1.setText("0");
        DOS1.setMinimumSize(new java.awt.Dimension(6, 22));

        uno35.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        uno35.setAlignmentY(0.0F);
        uno35.setBorderPainted(false);
        uno35.setMargin(new java.awt.Insets(0, 0, 0, 0));
        uno35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uno35ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DOS1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel40Layout.createSequentialGroup()
                        .addComponent(uno35, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dos35, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tres35, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(139, 139, 139))
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dos35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tres35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uno35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DOS1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel41.setBackground(new java.awt.Color(102, 102, 102));

        dos36.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        dos36.setMargin(new java.awt.Insets(0, 0, 0, 0));
        dos36.setPreferredSize(new java.awt.Dimension(35, 26));
        dos36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dos36ActionPerformed(evt);
            }
        });

        tres36.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        tres36.setMargin(new java.awt.Insets(0, 0, 0, 0));
        tres36.setPreferredSize(new java.awt.Dimension(35, 26));
        tres36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tres36ActionPerformed(evt);
            }
        });

        TRES1.setEditable(false);
        TRES1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        TRES1.setForeground(new java.awt.Color(240, 240, 240));
        TRES1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TRES1.setText("0");
        TRES1.setMinimumSize(new java.awt.Dimension(6, 22));

        uno36.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        uno36.setAlignmentY(0.0F);
        uno36.setBorderPainted(false);
        uno36.setMargin(new java.awt.Insets(0, 0, 0, 0));
        uno36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uno36ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TRES1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addComponent(uno36, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dos36, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tres36, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(139, 139, 139))
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dos36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tres36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uno36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TRES1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel42.setBackground(new java.awt.Color(255, 255, 255));

        dos37.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        dos37.setMargin(new java.awt.Insets(0, 0, 0, 0));
        dos37.setPreferredSize(new java.awt.Dimension(35, 26));
        dos37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dos37ActionPerformed(evt);
            }
        });

        tres37.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        tres37.setMargin(new java.awt.Insets(0, 0, 0, 0));
        tres37.setPreferredSize(new java.awt.Dimension(35, 26));
        tres37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tres37ActionPerformed(evt);
            }
        });

        CUATRO1.setEditable(false);
        CUATRO1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        CUATRO1.setForeground(new java.awt.Color(240, 240, 240));
        CUATRO1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CUATRO1.setText("0");
        CUATRO1.setMinimumSize(new java.awt.Dimension(6, 22));

        uno37.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        uno37.setAlignmentY(0.0F);
        uno37.setBorderPainted(false);
        uno37.setMargin(new java.awt.Insets(0, 0, 0, 0));
        uno37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uno37ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CUATRO1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addComponent(uno37, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dos37, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tres37, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(139, 139, 139))
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dos37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tres37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uno37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CUATRO1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel39, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel40, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel41, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel42, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel48.setBackground(new java.awt.Color(102, 204, 255));

        jPanel49.setBackground(new java.awt.Color(102, 102, 102));

        dos42.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        dos42.setMargin(new java.awt.Insets(0, 0, 0, 0));
        dos42.setPreferredSize(new java.awt.Dimension(35, 26));
        dos42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dos42ActionPerformed(evt);
            }
        });

        tres42.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        tres42.setMargin(new java.awt.Insets(0, 0, 0, 0));
        tres42.setPreferredSize(new java.awt.Dimension(35, 26));
        tres42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tres42ActionPerformed(evt);
            }
        });

        UNO2.setEditable(false);
        UNO2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        UNO2.setForeground(new java.awt.Color(240, 240, 240));
        UNO2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        UNO2.setText("0");
        UNO2.setMinimumSize(new java.awt.Dimension(6, 22));

        uno42.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        uno42.setAlignmentY(0.0F);
        uno42.setBorderPainted(false);
        uno42.setMargin(new java.awt.Insets(0, 0, 0, 0));
        uno42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uno42ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UNO2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel49Layout.createSequentialGroup()
                        .addComponent(uno42, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dos42, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tres42, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(139, 139, 139))
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dos42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tres42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uno42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UNO2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel50.setBackground(new java.awt.Color(255, 255, 255));

        dos43.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        dos43.setMargin(new java.awt.Insets(0, 0, 0, 0));
        dos43.setPreferredSize(new java.awt.Dimension(35, 26));
        dos43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dos43ActionPerformed(evt);
            }
        });

        tres43.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        tres43.setMargin(new java.awt.Insets(0, 0, 0, 0));
        tres43.setPreferredSize(new java.awt.Dimension(35, 26));
        tres43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tres43ActionPerformed(evt);
            }
        });

        DOS2.setEditable(false);
        DOS2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        DOS2.setForeground(new java.awt.Color(240, 240, 240));
        DOS2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        DOS2.setText("0");
        DOS2.setMinimumSize(new java.awt.Dimension(6, 22));

        uno43.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        uno43.setAlignmentY(0.0F);
        uno43.setBorderPainted(false);
        uno43.setMargin(new java.awt.Insets(0, 0, 0, 0));
        uno43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uno43ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DOS2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel50Layout.createSequentialGroup()
                        .addComponent(uno43, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dos43, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tres43, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(139, 139, 139))
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dos43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tres43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uno43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DOS2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel51.setBackground(new java.awt.Color(102, 102, 102));

        dos44.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        dos44.setMargin(new java.awt.Insets(0, 0, 0, 0));
        dos44.setPreferredSize(new java.awt.Dimension(35, 26));
        dos44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dos44ActionPerformed(evt);
            }
        });

        tres44.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        tres44.setMargin(new java.awt.Insets(0, 0, 0, 0));
        tres44.setPreferredSize(new java.awt.Dimension(35, 26));
        tres44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tres44ActionPerformed(evt);
            }
        });

        TRES2.setEditable(false);
        TRES2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        TRES2.setForeground(new java.awt.Color(240, 240, 240));
        TRES2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TRES2.setText("0");
        TRES2.setMinimumSize(new java.awt.Dimension(6, 22));

        uno44.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        uno44.setAlignmentY(0.0F);
        uno44.setBorderPainted(false);
        uno44.setMargin(new java.awt.Insets(0, 0, 0, 0));
        uno44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uno44ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel51Layout = new javax.swing.GroupLayout(jPanel51);
        jPanel51.setLayout(jPanel51Layout);
        jPanel51Layout.setHorizontalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TRES2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel51Layout.createSequentialGroup()
                        .addComponent(uno44, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dos44, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tres44, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(139, 139, 139))
        );
        jPanel51Layout.setVerticalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dos44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tres44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uno44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TRES2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel52.setBackground(new java.awt.Color(255, 255, 255));

        dos45.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        dos45.setMargin(new java.awt.Insets(0, 0, 0, 0));
        dos45.setPreferredSize(new java.awt.Dimension(35, 26));
        dos45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dos45ActionPerformed(evt);
            }
        });

        tres45.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        tres45.setMargin(new java.awt.Insets(0, 0, 0, 0));
        tres45.setPreferredSize(new java.awt.Dimension(35, 26));
        tres45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tres45ActionPerformed(evt);
            }
        });

        CUATRO2.setEditable(false);
        CUATRO2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        CUATRO2.setForeground(new java.awt.Color(240, 240, 240));
        CUATRO2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CUATRO2.setText("0");
        CUATRO2.setMinimumSize(new java.awt.Dimension(6, 22));

        uno45.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        uno45.setAlignmentY(0.0F);
        uno45.setBorderPainted(false);
        uno45.setMargin(new java.awt.Insets(0, 0, 0, 0));
        uno45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uno45ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel52Layout = new javax.swing.GroupLayout(jPanel52);
        jPanel52.setLayout(jPanel52Layout);
        jPanel52Layout.setHorizontalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CUATRO2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel52Layout.createSequentialGroup()
                        .addComponent(uno45, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dos45, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tres45, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(139, 139, 139))
        );
        jPanel52Layout.setVerticalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dos45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tres45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uno45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CUATRO2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel49, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel51, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel52, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel49, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel50, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel51, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel52, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel53.setBackground(new java.awt.Color(102, 204, 255));

        jPanel54.setBackground(new java.awt.Color(102, 102, 102));

        dos46.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        dos46.setMargin(new java.awt.Insets(0, 0, 0, 0));
        dos46.setPreferredSize(new java.awt.Dimension(35, 26));
        dos46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dos46ActionPerformed(evt);
            }
        });

        tres46.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        tres46.setMargin(new java.awt.Insets(0, 0, 0, 0));
        tres46.setPreferredSize(new java.awt.Dimension(35, 26));
        tres46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tres46ActionPerformed(evt);
            }
        });

        UNO3.setEditable(false);
        UNO3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        UNO3.setForeground(new java.awt.Color(240, 240, 240));
        UNO3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        UNO3.setText("0");
        UNO3.setMinimumSize(new java.awt.Dimension(6, 22));

        uno46.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        uno46.setAlignmentY(0.0F);
        uno46.setBorderPainted(false);
        uno46.setMargin(new java.awt.Insets(0, 0, 0, 0));
        uno46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uno46ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel54Layout = new javax.swing.GroupLayout(jPanel54);
        jPanel54.setLayout(jPanel54Layout);
        jPanel54Layout.setHorizontalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UNO3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel54Layout.createSequentialGroup()
                        .addComponent(uno46, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dos46, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tres46, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(139, 139, 139))
        );
        jPanel54Layout.setVerticalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dos46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tres46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uno46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UNO3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel55.setBackground(new java.awt.Color(255, 255, 255));

        dos47.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        dos47.setMargin(new java.awt.Insets(0, 0, 0, 0));
        dos47.setPreferredSize(new java.awt.Dimension(35, 26));
        dos47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dos47ActionPerformed(evt);
            }
        });

        tres47.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        tres47.setMargin(new java.awt.Insets(0, 0, 0, 0));
        tres47.setPreferredSize(new java.awt.Dimension(35, 26));
        tres47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tres47ActionPerformed(evt);
            }
        });

        DOS3.setEditable(false);
        DOS3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        DOS3.setForeground(new java.awt.Color(240, 240, 240));
        DOS3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        DOS3.setText("0");
        DOS3.setMinimumSize(new java.awt.Dimension(6, 22));

        uno47.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        uno47.setAlignmentY(0.0F);
        uno47.setBorderPainted(false);
        uno47.setMargin(new java.awt.Insets(0, 0, 0, 0));
        uno47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uno47ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel55Layout = new javax.swing.GroupLayout(jPanel55);
        jPanel55.setLayout(jPanel55Layout);
        jPanel55Layout.setHorizontalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel55Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DOS3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel55Layout.createSequentialGroup()
                        .addComponent(uno47, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dos47, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tres47, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(139, 139, 139))
        );
        jPanel55Layout.setVerticalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel55Layout.createSequentialGroup()
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dos47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tres47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uno47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DOS3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel56.setBackground(new java.awt.Color(102, 102, 102));

        dos48.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        dos48.setMargin(new java.awt.Insets(0, 0, 0, 0));
        dos48.setPreferredSize(new java.awt.Dimension(35, 26));
        dos48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dos48ActionPerformed(evt);
            }
        });

        tres48.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        tres48.setMargin(new java.awt.Insets(0, 0, 0, 0));
        tres48.setPreferredSize(new java.awt.Dimension(35, 26));
        tres48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tres48ActionPerformed(evt);
            }
        });

        TRES3.setEditable(false);
        TRES3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        TRES3.setForeground(new java.awt.Color(240, 240, 240));
        TRES3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TRES3.setText("0");
        TRES3.setMinimumSize(new java.awt.Dimension(6, 22));

        uno48.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        uno48.setAlignmentY(0.0F);
        uno48.setBorderPainted(false);
        uno48.setMargin(new java.awt.Insets(0, 0, 0, 0));
        uno48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uno48ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel56Layout = new javax.swing.GroupLayout(jPanel56);
        jPanel56.setLayout(jPanel56Layout);
        jPanel56Layout.setHorizontalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel56Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TRES3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel56Layout.createSequentialGroup()
                        .addComponent(uno48, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dos48, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tres48, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(139, 139, 139))
        );
        jPanel56Layout.setVerticalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel56Layout.createSequentialGroup()
                .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dos48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tres48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uno48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TRES3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel57.setBackground(new java.awt.Color(255, 255, 255));

        dos49.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        dos49.setMargin(new java.awt.Insets(0, 0, 0, 0));
        dos49.setPreferredSize(new java.awt.Dimension(35, 26));
        dos49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dos49ActionPerformed(evt);
            }
        });

        tres49.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        tres49.setMargin(new java.awt.Insets(0, 0, 0, 0));
        tres49.setPreferredSize(new java.awt.Dimension(35, 26));
        tres49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tres49ActionPerformed(evt);
            }
        });

        CUATRO3.setEditable(false);
        CUATRO3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        CUATRO3.setForeground(new java.awt.Color(240, 240, 240));
        CUATRO3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CUATRO3.setText("0");
        CUATRO3.setMinimumSize(new java.awt.Dimension(6, 22));

        uno49.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        uno49.setAlignmentY(0.0F);
        uno49.setBorderPainted(false);
        uno49.setMargin(new java.awt.Insets(0, 0, 0, 0));
        uno49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uno49ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel57Layout = new javax.swing.GroupLayout(jPanel57);
        jPanel57.setLayout(jPanel57Layout);
        jPanel57Layout.setHorizontalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CUATRO3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel57Layout.createSequentialGroup()
                        .addComponent(uno49, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dos49, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tres49, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(139, 139, 139))
        );
        jPanel57Layout.setVerticalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dos49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tres49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uno49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CUATRO3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel53Layout = new javax.swing.GroupLayout(jPanel53);
        jPanel53.setLayout(jPanel53Layout);
        jPanel53Layout.setHorizontalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel54, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel55, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel56, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel57, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel53Layout.setVerticalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel54, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel55, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel56, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel57, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel63.setBackground(new java.awt.Color(102, 204, 255));

        jPanel64.setBackground(new java.awt.Color(102, 102, 102));

        dos54.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        dos54.setMargin(new java.awt.Insets(0, 0, 0, 0));
        dos54.setPreferredSize(new java.awt.Dimension(35, 26));
        dos54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dos54ActionPerformed(evt);
            }
        });

        tres54.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        tres54.setMargin(new java.awt.Insets(0, 0, 0, 0));
        tres54.setPreferredSize(new java.awt.Dimension(35, 26));
        tres54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tres54ActionPerformed(evt);
            }
        });

        UNO4.setEditable(false);
        UNO4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        UNO4.setForeground(new java.awt.Color(240, 240, 240));
        UNO4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        UNO4.setText("0");
        UNO4.setMinimumSize(new java.awt.Dimension(6, 22));

        uno54.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        uno54.setAlignmentY(0.0F);
        uno54.setBorderPainted(false);
        uno54.setMargin(new java.awt.Insets(0, 0, 0, 0));
        uno54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uno54ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel64Layout = new javax.swing.GroupLayout(jPanel64);
        jPanel64.setLayout(jPanel64Layout);
        jPanel64Layout.setHorizontalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel64Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UNO4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel64Layout.createSequentialGroup()
                        .addComponent(uno54, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dos54, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tres54, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(139, 139, 139))
        );
        jPanel64Layout.setVerticalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel64Layout.createSequentialGroup()
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dos54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tres54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uno54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UNO4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel65.setBackground(new java.awt.Color(255, 255, 255));

        dos55.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        dos55.setMargin(new java.awt.Insets(0, 0, 0, 0));
        dos55.setPreferredSize(new java.awt.Dimension(35, 26));
        dos55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dos55ActionPerformed(evt);
            }
        });

        tres55.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        tres55.setMargin(new java.awt.Insets(0, 0, 0, 0));
        tres55.setPreferredSize(new java.awt.Dimension(35, 26));
        tres55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tres55ActionPerformed(evt);
            }
        });

        DOS4.setEditable(false);
        DOS4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        DOS4.setForeground(new java.awt.Color(240, 240, 240));
        DOS4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        DOS4.setText("0");
        DOS4.setMinimumSize(new java.awt.Dimension(6, 22));

        uno55.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        uno55.setAlignmentY(0.0F);
        uno55.setBorderPainted(false);
        uno55.setMargin(new java.awt.Insets(0, 0, 0, 0));
        uno55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uno55ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel65Layout = new javax.swing.GroupLayout(jPanel65);
        jPanel65.setLayout(jPanel65Layout);
        jPanel65Layout.setHorizontalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel65Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DOS4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel65Layout.createSequentialGroup()
                        .addComponent(uno55, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dos55, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tres55, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(139, 139, 139))
        );
        jPanel65Layout.setVerticalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel65Layout.createSequentialGroup()
                .addGroup(jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dos55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tres55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uno55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DOS4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel66.setBackground(new java.awt.Color(102, 102, 102));

        dos56.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        dos56.setMargin(new java.awt.Insets(0, 0, 0, 0));
        dos56.setPreferredSize(new java.awt.Dimension(35, 26));
        dos56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dos56ActionPerformed(evt);
            }
        });

        tres56.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        tres56.setMargin(new java.awt.Insets(0, 0, 0, 0));
        tres56.setPreferredSize(new java.awt.Dimension(35, 26));
        tres56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tres56ActionPerformed(evt);
            }
        });

        TRES4.setEditable(false);
        TRES4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        TRES4.setForeground(new java.awt.Color(240, 240, 240));
        TRES4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TRES4.setText("0");
        TRES4.setMinimumSize(new java.awt.Dimension(6, 22));

        uno56.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        uno56.setAlignmentY(0.0F);
        uno56.setBorderPainted(false);
        uno56.setMargin(new java.awt.Insets(0, 0, 0, 0));
        uno56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uno56ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel66Layout = new javax.swing.GroupLayout(jPanel66);
        jPanel66.setLayout(jPanel66Layout);
        jPanel66Layout.setHorizontalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel66Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TRES4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel66Layout.createSequentialGroup()
                        .addComponent(uno56, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dos56, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tres56, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(139, 139, 139))
        );
        jPanel66Layout.setVerticalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel66Layout.createSequentialGroup()
                .addGroup(jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dos56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tres56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uno56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TRES4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel67.setBackground(new java.awt.Color(255, 255, 255));

        dos57.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        dos57.setMargin(new java.awt.Insets(0, 0, 0, 0));
        dos57.setPreferredSize(new java.awt.Dimension(35, 26));
        dos57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dos57ActionPerformed(evt);
            }
        });

        tres57.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        tres57.setMargin(new java.awt.Insets(0, 0, 0, 0));
        tres57.setPreferredSize(new java.awt.Dimension(35, 26));
        tres57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tres57ActionPerformed(evt);
            }
        });

        CUATRO4.setEditable(false);
        CUATRO4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        CUATRO4.setForeground(new java.awt.Color(240, 240, 240));
        CUATRO4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CUATRO4.setText("0");
        CUATRO4.setMinimumSize(new java.awt.Dimension(6, 22));

        uno57.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        uno57.setAlignmentY(0.0F);
        uno57.setBorderPainted(false);
        uno57.setMargin(new java.awt.Insets(0, 0, 0, 0));
        uno57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uno57ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel67Layout = new javax.swing.GroupLayout(jPanel67);
        jPanel67.setLayout(jPanel67Layout);
        jPanel67Layout.setHorizontalGroup(
            jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel67Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CUATRO4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel67Layout.createSequentialGroup()
                        .addComponent(uno57, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dos57, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tres57, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(139, 139, 139))
        );
        jPanel67Layout.setVerticalGroup(
            jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel67Layout.createSequentialGroup()
                .addGroup(jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dos57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tres57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uno57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CUATRO4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel63Layout = new javax.swing.GroupLayout(jPanel63);
        jPanel63.setLayout(jPanel63Layout);
        jPanel63Layout.setHorizontalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel63Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel64, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel65, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel66, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel67, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel63Layout.setVerticalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel63Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel64, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel65, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel66, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel67, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jLabel6.setBackground(new java.awt.Color(153, 153, 153));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        l1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        l1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l1.setText("Por debajo lo esperado");
        l1.setToolTipText("");
        l1.setAlignmentX(1.5F);
        l1.setAlignmentY(1.5F);
        l1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        l2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        l2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l2.setText("A mejorar");
        l2.setToolTipText("");
        l2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        l3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        l3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l3.setText("Aceptable");
        l3.setToolTipText("");
        l3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        l4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        l4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l4.setText("Destacado");
        l4.setToolTipText("");
        l4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel20.setText("DESCRIPCION:");

        TxtTotal.setEditable(false);
        TxtTotal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TxtTotal.setForeground(new java.awt.Color(255, 0, 0));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel21.setText("TOTAL:");

        punteo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        punteo.setForeground(new java.awt.Color(0, 0, 255));

        NOTA.setColumns(20);
        NOTA.setRows(5);
        jScrollPane3.setViewportView(NOTA);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("COMENTARIO(Opcional)");

        LabelFoto1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelFoto1.setText("FOTO");
        LabelFoto1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save2.png"))); // NOI18N
        jButton1.setText("GUARDAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel20)
                            .addComponent(TxtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(punteo, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1))
                            .addComponent(jLabel22)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(LabelFoto1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelFoto1, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(punteo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(337, 337, 337))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(228, 228, 228)
                                .addComponent(l1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(l2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(l3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(l4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel63, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 18, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(l2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(l4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(l3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(l1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void unoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unoActionPerformed
       uno.setText("X");uno.setBackground(Color.red);
       dos.setText("");dos.setBackground(new Color(240, 240, 240));
       tres.setText("");tres.setBackground(new Color(240, 240, 240));
       
       uno27.setText("");uno27.setBackground(new Color(240, 240, 240));
       dos27.setText("");dos27.setBackground(new Color(240, 240, 240));
       tres27.setText("");tres27.setBackground(new Color(240, 240, 240));
       uno28.setText("");uno28.setBackground(new Color(240, 240, 240));
       dos28.setText("");dos28.setBackground(new Color(240, 240, 240));
       tres28.setText("");tres28.setBackground(new Color(240, 240, 240));
       uno29.setText("");uno29.setBackground(new Color(240, 240, 240));
       dos29.setText("");dos29.setBackground(new Color(240, 240, 240));
       tres29.setText("");tres29.setBackground(new Color(240, 240, 240));
      
       UNO.setText("17");UNO.setBackground(Color.RED);
       DOS.setText("0");DOS.setBackground(new Color(240, 240, 240));
       TRES.setText("0");TRES.setBackground(new Color(240, 240, 240));
       CUATRO.setText("0");CUATRO.setBackground(new Color(240, 240, 240));
       
        suma();
               
    }//GEN-LAST:event_unoActionPerformed

    private void dosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dosActionPerformed
       dos.setText("X");dos.setBackground(Color.red);
       uno.setText("");uno.setBackground(new Color(240, 240, 240));
       tres.setText("");tres.setBackground(new Color(240, 240, 240));
       
       uno27.setText("");uno27.setBackground(new Color(240, 240, 240));
       dos27.setText("");dos27.setBackground(new Color(240, 240, 240));
       tres27.setText("");tres27.setBackground(new Color(240, 240, 240));
       uno28.setText("");uno28.setBackground(new Color(240, 240, 240));
       dos28.setText("");dos28.setBackground(new Color(240, 240, 240));
       tres28.setText("");tres28.setBackground(new Color(240, 240, 240));
       uno29.setText("");uno29.setBackground(new Color(240, 240, 240));
       dos29.setText("");dos29.setBackground(new Color(240, 240, 240));
       tres29.setText("");tres29.setBackground(new Color(240, 240, 240));
       UNO.setText("33");UNO.setBackground(Color.RED);
       DOS.setText("0");DOS.setBackground(new Color(240, 240, 240));
       TRES.setText("0");TRES.setBackground(new Color(240, 240, 240));
       CUATRO.setText("0");CUATRO.setBackground(new Color(240, 240, 240));
       
       suma();
    }//GEN-LAST:event_dosActionPerformed

    private void tresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tresActionPerformed
       tres.setText("X");tres.setBackground(Color.red);
       uno.setText("");uno.setBackground(new Color(240, 240, 240));
       dos.setText("");dos.setBackground(new Color(240, 240, 240));
       
       uno27.setText("");uno27.setBackground(new Color(240, 240, 240));
       dos27.setText("");dos27.setBackground(new Color(240, 240, 240));
       tres27.setText("");tres27.setBackground(new Color(240, 240, 240));
       uno28.setText("");uno28.setBackground(new Color(240, 240, 240));
       dos28.setText("");dos28.setBackground(new Color(240, 240, 240));
       tres28.setText("");tres28.setBackground(new Color(240, 240, 240));
       uno29.setText("");uno29.setBackground(new Color(240, 240, 240));
       dos29.setText("");dos29.setBackground(new Color(240, 240, 240));
       tres29.setText("");tres29.setBackground(new Color(240, 240, 240));
       UNO.setText("50");UNO.setBackground(Color.RED);
       DOS.setText("0");DOS.setBackground(new Color(240, 240, 240));
       TRES.setText("0");TRES.setBackground(new Color(240, 240, 240));
       CUATRO.setText("0");CUATRO.setBackground(new Color(240, 240, 240));
       suma();
    }//GEN-LAST:event_tresActionPerformed

    private void uno19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uno19ActionPerformed

    private void dos19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dos19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dos19ActionPerformed

    private void tres19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tres19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tres19ActionPerformed

    private void uno20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uno20ActionPerformed

    private void dos20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dos20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dos20ActionPerformed

    private void tres20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tres20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tres20ActionPerformed

    private void uno21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uno21ActionPerformed

    private void dos21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dos21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dos21ActionPerformed

    private void tres21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tres21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tres21ActionPerformed

    private void uno22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uno22ActionPerformed

    private void dos22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dos22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dos22ActionPerformed

    private void tres22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tres22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tres22ActionPerformed

    private void dos27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dos27ActionPerformed
       dos27.setText("X");dos27.setBackground(Color.red);
       uno27.setText("");uno27.setBackground(new Color(240, 240, 240));
       tres27.setText("");tres27.setBackground(new Color(240, 240, 240));
       
       uno.setText("");uno.setBackground(new Color(240, 240, 240));
       dos.setText("");dos.setBackground(new Color(240, 240, 240));
       tres.setText("");tres.setBackground(new Color(240, 240, 240));
       uno28.setText("");uno28.setBackground(new Color(240, 240, 240));
       dos28.setText("");dos28.setBackground(new Color(240, 240, 240));
       tres28.setText("");tres28.setBackground(new Color(240, 240, 240));
       uno29.setText("");uno29.setBackground(new Color(240, 240, 240));
       dos29.setText("");dos29.setBackground(new Color(240, 240, 240));
       tres29.setText("");tres29.setBackground(new Color(240, 240, 240));
       UNO.setText("0");UNO.setBackground(new Color(240, 240, 240));
       DOS.setText("60");DOS.setBackground(Color.RED);
       TRES.setText("0");TRES.setBackground(new Color(240, 240, 240));
       CUATRO.setText("0");CUATRO.setBackground(new Color(240, 240, 240));
       suma();
    }//GEN-LAST:event_dos27ActionPerformed

    private void tres27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tres27ActionPerformed
       tres27.setText("X");tres27.setBackground(Color.red);
       dos27.setText("");dos27.setBackground(new Color(240, 240, 240));
       uno27.setText("");uno27.setBackground(new Color(240, 240, 240));
       
       uno.setText("");uno.setBackground(new Color(240, 240, 240));
       dos.setText("");dos.setBackground(new Color(240, 240, 240));
       tres.setText("");tres.setBackground(new Color(240, 240, 240));
       uno28.setText("");uno28.setBackground(new Color(240, 240, 240));
       dos28.setText("");dos28.setBackground(new Color(240, 240, 240));
       tres28.setText("");tres28.setBackground(new Color(240, 240, 240));
       uno29.setText("");uno29.setBackground(new Color(240, 240, 240));
       dos29.setText("");dos29.setBackground(new Color(240, 240, 240));
       tres29.setText("");tres29.setBackground(new Color(240, 240, 240));
       UNO.setText("0");UNO.setBackground(new Color(240, 240, 240));
       DOS.setText("65");DOS.setBackground(Color.RED);
       TRES.setText("0");TRES.setBackground(new Color(240, 240, 240));
       CUATRO.setText("0");CUATRO.setBackground(new Color(240, 240, 240));
       suma();
    }//GEN-LAST:event_tres27ActionPerformed

    private void uno27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno27ActionPerformed
       uno27.setText("X");uno27.setBackground(Color.red);
       dos27.setText("");dos27.setBackground(new Color(240, 240, 240));
       tres27.setText("");tres27.setBackground(new Color(240, 240, 240));
       
       uno.setText("");uno.setBackground(new Color(240, 240, 240));
       dos.setText("");dos.setBackground(new Color(240, 240, 240));
       tres.setText("");tres.setBackground(new Color(240, 240, 240));
       uno28.setText("");uno28.setBackground(new Color(240, 240, 240));
       dos28.setText("");dos28.setBackground(new Color(240, 240, 240));
       tres28.setText("");tres28.setBackground(new Color(240, 240, 240));
       uno29.setText("");uno29.setBackground(new Color(240, 240, 240));
       dos29.setText("");dos29.setBackground(new Color(240, 240, 240));
       tres29.setText("");tres29.setBackground(new Color(240, 240, 240));
       
       UNO.setText("0");UNO.setBackground(new Color(240, 240, 240));
       DOS.setText("56");DOS.setBackground(Color.RED);
       TRES.setText("0");TRES.setBackground(new Color(240, 240, 240));
       CUATRO.setText("0");CUATRO.setBackground(new Color(240, 240, 240));
       suma();
    }//GEN-LAST:event_uno27ActionPerformed

    private void dos28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dos28ActionPerformed
        dos28.setText("X");dos28.setBackground(Color.red);
       uno28.setText("");uno28.setBackground(new Color(240, 240, 240));
       tres28.setText("");tres28.setBackground(new Color(240, 240, 240));
       
       uno.setText("");uno.setBackground(new Color(240, 240, 240));
       dos.setText("");dos.setBackground(new Color(240, 240, 240));
       tres.setText("");tres.setBackground(new Color(240, 240, 240));
       uno27.setText("");uno27.setBackground(new Color(240, 240, 240));
       dos27.setText("");dos27.setBackground(new Color(240, 240, 240));
       tres27.setText("");tres27.setBackground(new Color(240, 240, 240));
       uno29.setText("");uno29.setBackground(new Color(240, 240, 240));
       dos29.setText("");dos29.setBackground(new Color(240, 240, 240));
       tres29.setText("");tres29.setBackground(new Color(240, 240, 240));
       UNO.setText("0");UNO.setBackground(new Color(240, 240, 240));
       DOS.setText("0");DOS.setBackground(new Color(240, 240, 240));
       TRES.setText("78");TRES.setBackground(Color.RED);
       CUATRO.setText("0");CUATRO.setBackground(new Color(240, 240, 240));
       suma();
    }//GEN-LAST:event_dos28ActionPerformed

    private void tres28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tres28ActionPerformed
       tres28.setText("X");tres28.setBackground(Color.red);
       dos28.setText("");dos28.setBackground(new Color(240, 240, 240));
       uno28.setText("");uno28.setBackground(new Color(240, 240, 240));
       
       uno.setText("");uno.setBackground(new Color(240, 240, 240));
       dos.setText("");dos.setBackground(new Color(240, 240, 240));
       tres.setText("");tres.setBackground(new Color(240, 240, 240));
       uno27.setText("");uno27.setBackground(new Color(240, 240, 240));
       dos27.setText("");dos27.setBackground(new Color(240, 240, 240));
       tres27.setText("");tres27.setBackground(new Color(240, 240, 240));
       uno29.setText("");uno29.setBackground(new Color(240, 240, 240));
       dos29.setText("");dos29.setBackground(new Color(240, 240, 240));
       tres29.setText("");tres29.setBackground(new Color(240, 240, 240));
       UNO.setText("0");UNO.setBackground(new Color(240, 240, 240));
       DOS.setText("0");DOS.setBackground(new Color(240, 240, 240));
       TRES.setText("84");TRES.setBackground(Color.RED);
       CUATRO.setText("0");CUATRO.setBackground(new Color(240, 240, 240));
       suma();
    }//GEN-LAST:event_tres28ActionPerformed

    private void uno28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno28ActionPerformed
       uno28.setText("X");uno28.setBackground(Color.red);
       dos28.setText("");dos28.setBackground(new Color(240, 240, 240));
       tres28.setText("");tres28.setBackground(new Color(240, 240, 240));
       
       uno.setText("");uno.setBackground(new Color(240, 240, 240));
       dos.setText("");dos.setBackground(new Color(240, 240, 240));
       tres.setText("");tres.setBackground(new Color(240, 240, 240));
       uno27.setText("");uno27.setBackground(new Color(240, 240, 240));
       dos27.setText("");dos27.setBackground(new Color(240, 240, 240));
       tres27.setText("");tres27.setBackground(new Color(240, 240, 240));
       uno29.setText("");uno29.setBackground(new Color(240, 240, 240));
       dos29.setText(""); dos29.setBackground(new Color(240, 240, 240));
       tres29.setText("");tres29.setBackground(new Color(240, 240, 240));
       UNO.setText("0");UNO.setBackground(new Color(240, 240, 240));
       DOS.setText("0");DOS.setBackground(new Color(240, 240, 240));
       TRES.setText("72");TRES.setBackground(Color.RED);
       CUATRO.setText("0");CUATRO.setBackground(new Color(240, 240, 240));
       suma();
    }//GEN-LAST:event_uno28ActionPerformed

    private void dos29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dos29ActionPerformed
       dos29.setText("X");dos29.setBackground(Color.red);
       uno29.setText("");uno29.setBackground(new Color(240, 240, 240));
       tres29.setText("");tres29.setBackground(new Color(240, 240, 240));
       
       uno.setText("");uno.setBackground(new Color(240, 240, 240));
       dos.setText("");dos.setBackground(new Color(240, 240, 240));
       tres.setText("");tres.setBackground(new Color(240, 240, 240));
       uno27.setText("");uno27.setBackground(new Color(240, 240, 240));
       dos27.setText("");dos27.setBackground(new Color(240, 240, 240));
       tres27.setText("");tres27.setBackground(new Color(240, 240, 240));
       uno28.setText("");uno28.setBackground(new Color(240, 240, 240));
       dos28.setText("");dos28.setBackground(new Color(240, 240, 240));
       tres28.setText("");tres28.setBackground(new Color(240, 240, 240));
      UNO.setText("0");UNO.setBackground(new Color(240, 240, 240));
       DOS.setText("0");DOS.setBackground(new Color(240, 240, 240));
       TRES.setText("0");TRES.setBackground(new Color(240, 240, 240));
       CUATRO.setText("95");CUATRO.setBackground(Color.RED);
       suma();
    }//GEN-LAST:event_dos29ActionPerformed

    private void tres29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tres29ActionPerformed
       tres29.setText("X");tres29.setBackground(Color.red);
       dos29.setText("");dos29.setBackground(new Color(240, 240, 240));
       uno29.setText("");uno29.setBackground(new Color(240, 240, 240));
       
       uno.setText("");uno.setBackground(new Color(240, 240, 240));
       dos.setText("");dos.setBackground(new Color(240, 240, 240));
       tres.setText("");tres.setBackground(new Color(240, 240, 240));
       uno27.setText("");uno27.setBackground(new Color(240, 240, 240));
       dos27.setText("");dos27.setBackground(new Color(240, 240, 240));
       tres27.setText("");tres27.setBackground(new Color(240, 240, 240));
       uno28.setText("");uno28.setBackground(new Color(240, 240, 240));
       dos28.setText("");dos28.setBackground(new Color(240, 240, 240));
       tres28.setText("");tres28.setBackground(new Color(240, 240, 240));
       UNO.setText("0");UNO.setBackground(new Color(240, 240, 240));
       DOS.setText("0");DOS.setBackground(new Color(240, 240, 240));
       TRES.setText("0");TRES.setBackground(new Color(240, 240, 240));
       CUATRO.setText("100");CUATRO.setBackground(Color.RED);
       suma();
    }//GEN-LAST:event_tres29ActionPerformed

    private void uno29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno29ActionPerformed
       uno29.setText("X");uno29.setBackground(Color.red);
       dos29.setText("");dos29.setBackground(new Color(240, 240, 240));
       tres29.setText("");tres29.setBackground(new Color(240, 240, 240));
       
       uno.setText("");uno.setBackground(new Color(240, 240, 240));
       dos.setText("");dos.setBackground(new Color(240, 240, 240));
       tres.setText("");tres.setBackground(new Color(240, 240, 240));
       uno27.setText("");uno27.setBackground(new Color(240, 240, 240));
       dos27.setText("");dos27.setBackground(new Color(240, 240, 240));
       tres27.setText("");tres27.setBackground(new Color(240, 240, 240));
       uno28.setText("");uno28.setBackground(new Color(240, 240, 240));
       dos28.setText("");dos28.setBackground(new Color(240, 240, 240));
       tres28.setText("");tres28.setBackground(new Color(240, 240, 240));
       UNO.setText("0");UNO.setBackground(new Color(240, 240, 240));
       DOS.setText("0");DOS.setBackground(new Color(240, 240, 240));
       TRES.setText("0");TRES.setBackground(new Color(240, 240, 240));
       CUATRO.setText("90");CUATRO.setBackground(Color.RED);
       suma();
       
    }//GEN-LAST:event_uno29ActionPerformed

    private void dos30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dos30ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dos30ActionPerformed

    private void tres30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tres30ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tres30ActionPerformed

    private void uno30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno30ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uno30ActionPerformed

    private void dos31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dos31ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dos31ActionPerformed

    private void tres31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tres31ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tres31ActionPerformed

    private void uno31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno31ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uno31ActionPerformed

    private void dos32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dos32ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dos32ActionPerformed

    private void tres32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tres32ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tres32ActionPerformed

    private void uno32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno32ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uno32ActionPerformed

    private void dos33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dos33ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dos33ActionPerformed

    private void tres33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tres33ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tres33ActionPerformed

    private void uno33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno33ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uno33ActionPerformed

    private void dos34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dos34ActionPerformed
       dos34.setText("X");dos34.setBackground(Color.red);
       uno34.setText("");uno34.setBackground(new Color(240, 240, 240));
       tres34.setText("");tres34.setBackground(new Color(240, 240, 240));
       
       uno35.setText("");uno35.setBackground(new Color(240, 240, 240));
       dos35.setText("");dos35.setBackground(new Color(240, 240, 240));
       tres35.setText("");tres35.setBackground(new Color(240, 240, 240));
       uno36.setText("");uno36.setBackground(new Color(240, 240, 240));
       dos36.setText("");dos36.setBackground(new Color(240, 240, 240));
       tres36.setText("");tres36.setBackground(new Color(240, 240, 240));
       uno37.setText("");uno37.setBackground(new Color(240, 240, 240));
       dos37.setText("");dos37.setBackground(new Color(240, 240, 240));
       tres37.setText("");tres37.setBackground(new Color(240, 240, 240));
       UNO1.setText("33");UNO1.setBackground(Color.RED);
       DOS1.setText("0");DOS1.setBackground(new Color(240, 240, 240));
       TRES1.setText("0");TRES1.setBackground(new Color(240, 240, 240));
       CUATRO1.setText("0");CUATRO1.setBackground(new Color(240, 240, 240));
       suma();
    }//GEN-LAST:event_dos34ActionPerformed

    private void tres34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tres34ActionPerformed
       tres34.setText("X");tres34.setBackground(Color.red);
       uno34.setText("");uno34.setBackground(new Color(240, 240, 240));
       dos34.setText("");dos34.setBackground(new Color(240, 240, 240));
       
       uno35.setText("");uno35.setBackground(new Color(240, 240, 240));
       dos35.setText("");dos35.setBackground(new Color(240, 240, 240));
       tres35.setText("");tres35.setBackground(new Color(240, 240, 240));
       uno36.setText("");uno36.setBackground(new Color(240, 240, 240));
       dos36.setText("");dos36.setBackground(new Color(240, 240, 240));
       tres36.setText("");tres36.setBackground(new Color(240, 240, 240));
       uno37.setText("");uno37.setBackground(new Color(240, 240, 240));
       dos37.setText("");dos37.setBackground(new Color(240, 240, 240));
       tres37.setText("");tres37.setBackground(new Color(240, 240, 240));
       UNO1.setText("50");UNO1.setBackground(Color.RED);
       DOS1.setText("0");DOS1.setBackground(new Color(240, 240, 240));
       TRES1.setText("0");TRES1.setBackground(new Color(240, 240, 240));
       CUATRO1.setText("0");CUATRO1.setBackground(new Color(240, 240, 240));
       suma();
    }//GEN-LAST:event_tres34ActionPerformed

    private void uno34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno34ActionPerformed
       uno34.setText("X");uno34.setBackground(Color.red);
       dos34.setText("");dos34.setBackground(new Color(240, 240, 240));
       tres34.setText("");tres34.setBackground(new Color(240, 240, 240));
       
       uno35.setText("");uno35.setBackground(new Color(240, 240, 240));
       dos35.setText("");dos35.setBackground(new Color(240, 240, 240));
       tres35.setText("");tres35.setBackground(new Color(240, 240, 240));
       uno36.setText("");uno36.setBackground(new Color(240, 240, 240));
       dos36.setText("");dos36.setBackground(new Color(240, 240, 240));
       tres36.setText("");tres36.setBackground(new Color(240, 240, 240));
       uno37.setText("");uno37.setBackground(new Color(240, 240, 240));
       dos37.setText("");dos37.setBackground(new Color(240, 240, 240));
       tres37.setText("");tres37.setBackground(new Color(240, 240, 240));
      
       UNO1.setText("17");UNO1.setBackground(Color.RED);
       DOS1.setText("0");DOS1.setBackground(new Color(240, 240, 240));
       TRES1.setText("0");TRES1.setBackground(new Color(240, 240, 240));
       CUATRO1.setText("0");CUATRO1.setBackground(new Color(240, 240, 240));
       suma();
    }//GEN-LAST:event_uno34ActionPerformed

    private void dos35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dos35ActionPerformed
       dos35.setText("X");dos35.setBackground(Color.red);
       uno35.setText("");uno35.setBackground(new Color(240, 240, 240));
       tres35.setText("");tres35.setBackground(new Color(240, 240, 240));
       
       uno34.setText("");uno34.setBackground(new Color(240, 240, 240));
       dos34.setText("");dos34.setBackground(new Color(240, 240, 240));
       tres34.setText("");tres34.setBackground(new Color(240, 240, 240));
       uno36.setText("");uno36.setBackground(new Color(240, 240, 240));
       dos36.setText("");dos36.setBackground(new Color(240, 240, 240));
       tres36.setText("");tres36.setBackground(new Color(240, 240, 240));
       uno37.setText("");uno37.setBackground(new Color(240, 240, 240));
       dos37.setText("");dos37.setBackground(new Color(240, 240, 240));
       tres37.setText("");tres37.setBackground(new Color(240, 240, 240));
       UNO1.setText("0");UNO1.setBackground(new Color(240, 240, 240));
       DOS1.setText("60");DOS1.setBackground(Color.RED);
       TRES1.setText("0");TRES1.setBackground(new Color(240, 240, 240));
       CUATRO1.setText("0");CUATRO1.setBackground(new Color(240, 240, 240));
       suma();
    }//GEN-LAST:event_dos35ActionPerformed

    private void tres35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tres35ActionPerformed
       tres35.setText("X");tres35.setBackground(Color.red);
       dos35.setText("");dos35.setBackground(new Color(240, 240, 240));
       uno35.setText("");uno35.setBackground(new Color(240, 240, 240));
       
       uno34.setText("");uno34.setBackground(new Color(240, 240, 240));
       dos34.setText("");dos34.setBackground(new Color(240, 240, 240));
       tres34.setText("");tres34.setBackground(new Color(240, 240, 240));
       uno36.setText("");uno36.setBackground(new Color(240, 240, 240));
       dos36.setText("");dos36.setBackground(new Color(240, 240, 240));
       tres36.setText("");tres36.setBackground(new Color(240, 240, 240));
       uno37.setText("");uno37.setBackground(new Color(240, 240, 240));
       dos37.setText("");dos37.setBackground(new Color(240, 240, 240));
       tres37.setText("");tres37.setBackground(new Color(240, 240, 240));
       UNO1.setText("0");UNO1.setBackground(new Color(240, 240, 240));
       DOS1.setText("65");DOS1.setBackground(Color.RED);
       TRES1.setText("0");TRES1.setBackground(new Color(240, 240, 240));
       CUATRO1.setText("0");CUATRO1.setBackground(new Color(240, 240, 240));
       suma();
    }//GEN-LAST:event_tres35ActionPerformed

    private void uno35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno35ActionPerformed
       uno35.setText("X");uno35.setBackground(Color.red);
       dos35.setText("");dos35.setBackground(new Color(240, 240, 240));
       tres35.setText("");tres35.setBackground(new Color(240, 240, 240));
       
       uno34.setText("");uno34.setBackground(new Color(240, 240, 240));
       dos34.setText("");dos34.setBackground(new Color(240, 240, 240));
       tres34.setText("");tres34.setBackground(new Color(240, 240, 240));
       uno36.setText("");uno36.setBackground(new Color(240, 240, 240));
       dos36.setText("");dos36.setBackground(new Color(240, 240, 240));
       tres36.setText("");tres36.setBackground(new Color(240, 240, 240));
       uno37.setText("");uno37.setBackground(new Color(240, 240, 240));
       dos37.setText("");dos37.setBackground(new Color(240, 240, 240));
       tres37.setText("");tres37.setBackground(new Color(240, 240, 240));
       
       UNO1.setText("0");UNO1.setBackground(new Color(240, 240, 240));
       DOS1.setText("56");DOS1.setBackground(Color.RED);
       TRES1.setText("0");TRES1.setBackground(new Color(240, 240, 240));
       CUATRO1.setText("0");CUATRO1.setBackground(new Color(240, 240, 240));
       suma();
    }//GEN-LAST:event_uno35ActionPerformed

    private void dos36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dos36ActionPerformed
       dos36.setText("X");dos36.setBackground(Color.red);
       uno36.setText("");uno36.setBackground(new Color(240, 240, 240));
       tres36.setText("");tres36.setBackground(new Color(240, 240, 240));
       
       uno34.setText("");uno34.setBackground(new Color(240, 240, 240));
       dos34.setText("");dos34.setBackground(new Color(240, 240, 240));
       tres34.setText("");tres34.setBackground(new Color(240, 240, 240));
       uno35.setText("");uno35.setBackground(new Color(240, 240, 240));
       dos35.setText("");dos35.setBackground(new Color(240, 240, 240));
       tres35.setText("");tres35.setBackground(new Color(240, 240, 240));
       uno37.setText("");uno37.setBackground(new Color(240, 240, 240));
       dos37.setText("");dos37.setBackground(new Color(240, 240, 240));
       tres37.setText("");tres37.setBackground(new Color(240, 240, 240));
       UNO1.setText("0");UNO1.setBackground(new Color(240, 240, 240));
       DOS1.setText("0");DOS1.setBackground(new Color(240, 240, 240));
       TRES1.setText("78");TRES1.setBackground(Color.RED);
       CUATRO1.setText("0");CUATRO1.setBackground(new Color(240, 240, 240));
       suma();
    }//GEN-LAST:event_dos36ActionPerformed

    private void tres36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tres36ActionPerformed
       tres36.setText("X");tres36.setBackground(Color.red);
       dos36.setText("");dos36.setBackground(new Color(240, 240, 240));
       uno36.setText("");uno36.setBackground(new Color(240, 240, 240));
       
       uno34.setText("");uno34.setBackground(new Color(240, 240, 240));
       dos34.setText("");dos34.setBackground(new Color(240, 240, 240));
       tres34.setText("");tres34.setBackground(new Color(240, 240, 240));
       uno35.setText("");uno35.setBackground(new Color(240, 240, 240));
       dos35.setText("");dos35.setBackground(new Color(240, 240, 240));
       tres35.setText("");tres35.setBackground(new Color(240, 240, 240));
       uno37.setText("");uno37.setBackground(new Color(240, 240, 240));
       dos37.setText("");dos37.setBackground(new Color(240, 240, 240));
       tres37.setText("");tres37.setBackground(new Color(240, 240, 240));
       UNO1.setText("0");UNO1.setBackground(new Color(240, 240, 240));
       DOS1.setText("0");DOS1.setBackground(new Color(240, 240, 240));
       TRES1.setText("84");TRES1.setBackground(Color.RED);
       CUATRO1.setText("0");CUATRO1.setBackground(new Color(240, 240, 240));
       suma();
    }//GEN-LAST:event_tres36ActionPerformed

    private void uno36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno36ActionPerformed
       uno36.setText("X");uno36.setBackground(Color.red);
       dos36.setText("");dos36.setBackground(new Color(240, 240, 240));
       tres36.setText("");tres36.setBackground(new Color(240, 240, 240));
       
       uno34.setText("");uno34.setBackground(new Color(240, 240, 240));
       dos34.setText("");dos34.setBackground(new Color(240, 240, 240));
       tres34.setText("");tres34.setBackground(new Color(240, 240, 240));
       uno35.setText("");uno35.setBackground(new Color(240, 240, 240));
       dos35.setText("");dos35.setBackground(new Color(240, 240, 240));
       tres35.setText("");tres35.setBackground(new Color(240, 240, 240));
       uno37.setText("");uno37.setBackground(new Color(240, 240, 240));
       dos37.setText(""); dos37.setBackground(new Color(240, 240, 240));
       tres37.setText("");tres37.setBackground(new Color(240, 240, 240));
      UNO1.setText("0");UNO1.setBackground(new Color(240, 240, 240));
       DOS1.setText("0");DOS1.setBackground(new Color(240, 240, 240));
       TRES1.setText("72");TRES1.setBackground(Color.RED);
       CUATRO1.setText("0");CUATRO1.setBackground(new Color(240, 240, 240));
       suma();
    }//GEN-LAST:event_uno36ActionPerformed

    private void dos37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dos37ActionPerformed
       dos37.setText("X");dos37.setBackground(Color.red);
       uno37.setText("");uno37.setBackground(new Color(240, 240, 240));
       tres37.setText("");tres37.setBackground(new Color(240, 240, 240));
       
       uno34.setText("");uno34.setBackground(new Color(240, 240, 240));
       dos34.setText("");dos34.setBackground(new Color(240, 240, 240));
       tres34.setText("");tres34.setBackground(new Color(240, 240, 240));
       uno35.setText("");uno35.setBackground(new Color(240, 240, 240));
       dos35.setText("");dos35.setBackground(new Color(240, 240, 240));
       tres35.setText("");tres35.setBackground(new Color(240, 240, 240));
       uno36.setText("");uno36.setBackground(new Color(240, 240, 240));
       dos36.setText("");dos36.setBackground(new Color(240, 240, 240));
       tres36.setText("");tres36.setBackground(new Color(240, 240, 240));
       UNO1.setText("0");UNO1.setBackground(new Color(240, 240, 240));
       DOS1.setText("0");DOS1.setBackground(new Color(240, 240, 240));
       TRES1.setText("0");TRES1.setBackground(new Color(240, 240, 240));
       CUATRO1.setText("95");CUATRO1.setBackground(Color.RED);
       suma();
    }//GEN-LAST:event_dos37ActionPerformed

    private void tres37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tres37ActionPerformed
       tres37.setText("X");tres37.setBackground(Color.red);
       dos37.setText("");dos37.setBackground(new Color(240, 240, 240));
       uno37.setText("");uno37.setBackground(new Color(240, 240, 240));
       
       uno34.setText("");uno34.setBackground(new Color(240, 240, 240));
       dos34.setText("");dos34.setBackground(new Color(240, 240, 240));
       tres34.setText("");tres34.setBackground(new Color(240, 240, 240));
       uno35.setText("");uno35.setBackground(new Color(240, 240, 240));
       dos35.setText("");dos35.setBackground(new Color(240, 240, 240));
       tres35.setText("");tres35.setBackground(new Color(240, 240, 240));
       uno36.setText("");uno36.setBackground(new Color(240, 240, 240));
       dos36.setText("");dos36.setBackground(new Color(240, 240, 240));
       tres36.setText("");tres36.setBackground(new Color(240, 240, 240));
       UNO1.setText("0");UNO1.setBackground(new Color(240, 240, 240));
       DOS1.setText("0");DOS1.setBackground(new Color(240, 240, 240));
       TRES1.setText("0");TRES1.setBackground(new Color(240, 240, 240));
       CUATRO1.setText("100");CUATRO1.setBackground(Color.RED);
       suma();
    }//GEN-LAST:event_tres37ActionPerformed

    private void uno37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno37ActionPerformed
       uno37.setText("X");uno37.setBackground(Color.red);
       dos37.setText("");dos37.setBackground(new Color(240, 240, 240));
       tres37.setText("");tres37.setBackground(new Color(240, 240, 240));
       
       uno34.setText("");uno34.setBackground(new Color(240, 240, 240));
       dos34.setText("");dos34.setBackground(new Color(240, 240, 240));
       tres34.setText("");tres34.setBackground(new Color(240, 240, 240));
       uno35.setText("");uno35.setBackground(new Color(240, 240, 240));
       dos35.setText("");dos35.setBackground(new Color(240, 240, 240));
       tres35.setText("");tres35.setBackground(new Color(240, 240, 240));
       uno36.setText("");uno36.setBackground(new Color(240, 240, 240));
       dos36.setText("");dos36.setBackground(new Color(240, 240, 240));
       tres36.setText("");tres36.setBackground(new Color(240, 240, 240));
       UNO1.setText("0");UNO1.setBackground(new Color(240, 240, 240));
       DOS1.setText("0");DOS1.setBackground(new Color(240, 240, 240));
       TRES1.setText("0");TRES1.setBackground(new Color(240, 240, 240));
       CUATRO1.setText("90");CUATRO1.setBackground(Color.RED);
       suma();
    }//GEN-LAST:event_uno37ActionPerformed

    private void dos38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dos38ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dos38ActionPerformed

    private void tres38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tres38ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tres38ActionPerformed

    private void uno38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno38ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uno38ActionPerformed

    private void dos39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dos39ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dos39ActionPerformed

    private void tres39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tres39ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tres39ActionPerformed

    private void uno39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno39ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uno39ActionPerformed

    private void dos40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dos40ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dos40ActionPerformed

    private void tres40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tres40ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tres40ActionPerformed

    private void uno40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno40ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uno40ActionPerformed

    private void dos41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dos41ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dos41ActionPerformed

    private void tres41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tres41ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tres41ActionPerformed

    private void uno41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno41ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uno41ActionPerformed

    private void dos42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dos42ActionPerformed
       dos42.setText("X");dos42.setBackground(Color.red);
       uno42.setText("");uno42.setBackground(new Color(240, 240, 240));
       tres42.setText("");tres42.setBackground(new Color(240, 240, 240));
       
       uno43.setText("");uno43.setBackground(new Color(240, 240, 240));
       dos43.setText("");dos43.setBackground(new Color(240, 240, 240));
       tres43.setText("");tres43.setBackground(new Color(240, 240, 240));
       uno44.setText("");uno44.setBackground(new Color(240, 240, 240));
       dos44.setText("");dos44.setBackground(new Color(240, 240, 240));
       tres44.setText("");tres44.setBackground(new Color(240, 240, 240));
       uno45.setText("");uno45.setBackground(new Color(240, 240, 240));
       dos45.setText("");dos45.setBackground(new Color(240, 240, 240));
       tres45.setText("");tres45.setBackground(new Color(240, 240, 240));
      UNO2.setText("33");UNO2.setBackground(Color.RED);
       DOS2.setText("0");DOS2.setBackground(new Color(240, 240, 240));
       TRES2.setText("0");TRES2.setBackground(new Color(240, 240, 240));
       CUATRO2.setText("0");CUATRO2.setBackground(new Color(240, 240, 240));
       suma();
    }//GEN-LAST:event_dos42ActionPerformed

    private void tres42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tres42ActionPerformed
       tres42.setText("X");tres42.setBackground(Color.red);
       uno42.setText("");uno42.setBackground(new Color(240, 240, 240));
       dos42.setText("");dos42.setBackground(new Color(240, 240, 240));
       
       uno43.setText("");uno43.setBackground(new Color(240, 240, 240));
       dos43.setText("");dos43.setBackground(new Color(240, 240, 240));
       tres43.setText("");tres43.setBackground(new Color(240, 240, 240));
       uno44.setText("");uno44.setBackground(new Color(240, 240, 240));
       dos44.setText("");dos44.setBackground(new Color(240, 240, 240));
       tres44.setText("");tres44.setBackground(new Color(240, 240, 240));
       uno45.setText("");uno45.setBackground(new Color(240, 240, 240));
       dos45.setText("");dos45.setBackground(new Color(240, 240, 240));
       tres45.setText("");tres45.setBackground(new Color(240, 240, 240));
       UNO2.setText("50");UNO2.setBackground(Color.RED);
       DOS2.setText("0");DOS2.setBackground(new Color(240, 240, 240));
       TRES2.setText("0");TRES2.setBackground(new Color(240, 240, 240));
       CUATRO2.setText("0");CUATRO2.setBackground(new Color(240, 240, 240));
       suma();
    }//GEN-LAST:event_tres42ActionPerformed

    private void uno42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno42ActionPerformed
      
       uno42.setText("X");uno42.setBackground(Color.red);
       dos42.setText("");dos42.setBackground(new Color(240, 240, 240));
       tres42.setText("");tres42.setBackground(new Color(240, 240, 240));
       
       uno43.setText("");uno43.setBackground(new Color(240, 240, 240));
       dos43.setText("");dos43.setBackground(new Color(240, 240, 240));
       tres43.setText("");tres43.setBackground(new Color(240, 240, 240));
       uno44.setText("");uno44.setBackground(new Color(240, 240, 240));
       dos44.setText("");dos44.setBackground(new Color(240, 240, 240));
       tres44.setText("");tres44.setBackground(new Color(240, 240, 240));
       uno45.setText("");uno45.setBackground(new Color(240, 240, 240));
       dos45.setText("");dos45.setBackground(new Color(240, 240, 240));
       tres45.setText("");tres45.setBackground(new Color(240, 240, 240));
      
       UNO2.setText("17");UNO2.setBackground(Color.RED);
       DOS2.setText("0");DOS2.setBackground(new Color(240, 240, 240));
       TRES2.setText("0");TRES2.setBackground(new Color(240, 240, 240));
       CUATRO2.setText("0");CUATRO2.setBackground(new Color(240, 240, 240));
       suma();
    }//GEN-LAST:event_uno42ActionPerformed

    private void dos43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dos43ActionPerformed
       dos43.setText("X");dos43.setBackground(Color.red);
       uno43.setText("");uno43.setBackground(new Color(240, 240, 240));
       tres43.setText("");tres43.setBackground(new Color(240, 240, 240));
       
       uno42.setText("");uno42.setBackground(new Color(240, 240, 240));
       dos42.setText("");dos42.setBackground(new Color(240, 240, 240));
       tres42.setText("");tres42.setBackground(new Color(240, 240, 240));
       uno44.setText("");uno44.setBackground(new Color(240, 240, 240));
       dos44.setText("");dos44.setBackground(new Color(240, 240, 240));
       tres44.setText("");tres44.setBackground(new Color(240, 240, 240));
       uno45.setText("");uno45.setBackground(new Color(240, 240, 240));
       dos45.setText("");dos45.setBackground(new Color(240, 240, 240));
       tres45.setText("");tres45.setBackground(new Color(240, 240, 240));
      UNO2.setText("0");UNO2.setBackground(new Color(240, 240, 240));
       DOS2.setText("60");DOS2.setBackground(Color.RED);
       TRES2.setText("0");TRES2.setBackground(new Color(240, 240, 240));
       CUATRO2.setText("0");CUATRO2.setBackground(new Color(240, 240, 240));
       suma();
    }//GEN-LAST:event_dos43ActionPerformed

    private void tres43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tres43ActionPerformed
       tres43.setText("X");tres43.setBackground(Color.red);
       dos43.setText("");dos43.setBackground(new Color(240, 240, 240));
       uno43.setText("");uno43.setBackground(new Color(240, 240, 240));
       
       uno42.setText("");uno42.setBackground(new Color(240, 240, 240));
       dos42.setText("");dos42.setBackground(new Color(240, 240, 240));
       tres42.setText("");tres42.setBackground(new Color(240, 240, 240));
       uno44.setText("");uno44.setBackground(new Color(240, 240, 240));
       dos44.setText("");dos44.setBackground(new Color(240, 240, 240));
       tres44.setText("");tres44.setBackground(new Color(240, 240, 240));
       uno45.setText("");uno45.setBackground(new Color(240, 240, 240));
       dos45.setText("");dos45.setBackground(new Color(240, 240, 240));
       tres45.setText("");tres45.setBackground(new Color(240, 240, 240));
       UNO2.setText("0");UNO2.setBackground(new Color(240, 240, 240));
       DOS2.setText("65");DOS2.setBackground(Color.RED);
       TRES2.setText("0");TRES2.setBackground(new Color(240, 240, 240));
       CUATRO2.setText("0");CUATRO2.setBackground(new Color(240, 240, 240));
       suma();
    }//GEN-LAST:event_tres43ActionPerformed

    private void uno43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno43ActionPerformed
       uno43.setText("X");uno43.setBackground(Color.red);
       dos43.setText("");dos43.setBackground(new Color(240, 240, 240));
       tres43.setText("");tres43.setBackground(new Color(240, 240, 240));
       
       uno42.setText("");uno42.setBackground(new Color(240, 240, 240));
       dos42.setText("");dos42.setBackground(new Color(240, 240, 240));
       tres42.setText("");tres42.setBackground(new Color(240, 240, 240));
       uno44.setText("");uno44.setBackground(new Color(240, 240, 240));
       dos44.setText("");dos44.setBackground(new Color(240, 240, 240));
       tres44.setText("");tres44.setBackground(new Color(240, 240, 240));
       uno45.setText("");uno45.setBackground(new Color(240, 240, 240));
       dos45.setText("");dos45.setBackground(new Color(240, 240, 240));
       tres45.setText("");tres45.setBackground(new Color(240, 240, 240));
       
      UNO2.setText("0");UNO2.setBackground(new Color(240, 240, 240));
       DOS2.setText("56");DOS2.setBackground(Color.RED);
       TRES2.setText("0");TRES2.setBackground(new Color(240, 240, 240));
       CUATRO2.setText("0");CUATRO2.setBackground(new Color(240, 240, 240));
       suma();
    }//GEN-LAST:event_uno43ActionPerformed

    private void dos44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dos44ActionPerformed
       dos44.setText("X");dos44.setBackground(Color.red);
       uno44.setText("");uno44.setBackground(new Color(240, 240, 240));
       tres44.setText("");tres44.setBackground(new Color(240, 240, 240));
       
       uno42.setText("");uno42.setBackground(new Color(240, 240, 240));
       dos42.setText("");dos42.setBackground(new Color(240, 240, 240));
       tres42.setText("");tres42.setBackground(new Color(240, 240, 240));
       uno43.setText("");uno43.setBackground(new Color(240, 240, 240));
       dos43.setText("");dos43.setBackground(new Color(240, 240, 240));
       tres43.setText("");tres43.setBackground(new Color(240, 240, 240));
       uno45.setText("");uno45.setBackground(new Color(240, 240, 240));
       dos45.setText("");dos45.setBackground(new Color(240, 240, 240));
       tres45.setText("");tres37.setBackground(new Color(240, 240, 240));
      UNO2.setText("0");UNO2.setBackground(new Color(240, 240, 240));
       DOS2.setText("0");DOS2.setBackground(new Color(240, 240, 240));
       TRES2.setText("78");TRES2.setBackground(Color.RED);
       CUATRO2.setText("0");CUATRO2.setBackground(new Color(240, 240, 240));
       suma();
    }//GEN-LAST:event_dos44ActionPerformed

    private void tres44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tres44ActionPerformed
       tres44.setText("X");tres44.setBackground(Color.red);
       dos44.setText("");dos44.setBackground(new Color(240, 240, 240));
       uno44.setText("");uno44.setBackground(new Color(240, 240, 240));
       
       uno42.setText("");uno42.setBackground(new Color(240, 240, 240));
       dos42.setText("");dos42.setBackground(new Color(240, 240, 240));
       tres42.setText("");tres42.setBackground(new Color(240, 240, 240));
       uno43.setText("");uno43.setBackground(new Color(240, 240, 240));
       dos43.setText("");dos43.setBackground(new Color(240, 240, 240));
       tres43.setText("");tres43.setBackground(new Color(240, 240, 240));
       uno45.setText("");uno45.setBackground(new Color(240, 240, 240));
       dos45.setText("");dos45.setBackground(new Color(240, 240, 240));
       tres45.setText("");tres45.setBackground(new Color(240, 240, 240));
       UNO2.setText("0");UNO2.setBackground(new Color(240, 240, 240));
       DOS2.setText("0");DOS2.setBackground(new Color(240, 240, 240));
       TRES2.setText("84");TRES2.setBackground(Color.RED);
       CUATRO2.setText("0");CUATRO2.setBackground(new Color(240, 240, 240));
       suma();
    }//GEN-LAST:event_tres44ActionPerformed

    private void uno44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno44ActionPerformed
       uno44.setText("X");uno44.setBackground(Color.red);
       dos44.setText("");dos44.setBackground(new Color(240, 240, 240));
       tres44.setText("");tres44.setBackground(new Color(240, 240, 240));
       
       uno42.setText("");uno42.setBackground(new Color(240, 240, 240));
       dos42.setText("");dos42.setBackground(new Color(240, 240, 240));
       tres42.setText("");tres42.setBackground(new Color(240, 240, 240));
       uno43.setText("");uno43.setBackground(new Color(240, 240, 240));
       dos43.setText("");dos43.setBackground(new Color(240, 240, 240));
       tres43.setText("");tres43.setBackground(new Color(240, 240, 240));
       uno45.setText("");uno45.setBackground(new Color(240, 240, 240));
       dos45.setText(""); dos45.setBackground(new Color(240, 240, 240));
       tres45.setText("");tres45.setBackground(new Color(240, 240, 240));
       UNO2.setText("0");UNO2.setBackground(new Color(240, 240, 240));
       DOS2.setText("0");DOS2.setBackground(new Color(240, 240, 240));
       TRES2.setText("72");TRES2.setBackground(Color.RED);
       CUATRO2.setText("0");CUATRO2.setBackground(new Color(240, 240, 240));
       suma();
    }//GEN-LAST:event_uno44ActionPerformed

    private void dos45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dos45ActionPerformed
       dos45.setText("X");dos45.setBackground(Color.red);
       uno45.setText("");uno45.setBackground(new Color(240, 240, 240));
       tres45.setText("");tres45.setBackground(new Color(240, 240, 240));
       
       uno42.setText("");uno42.setBackground(new Color(240, 240, 240));
       dos42.setText("");dos42.setBackground(new Color(240, 240, 240));
       tres42.setText("");tres42.setBackground(new Color(240, 240, 240));
       uno43.setText("");uno43.setBackground(new Color(240, 240, 240));
       dos43.setText("");dos43.setBackground(new Color(240, 240, 240));
       tres43.setText("");tres43.setBackground(new Color(240, 240, 240));
       uno44.setText("");uno44.setBackground(new Color(240, 240, 240));
       dos44.setText("");dos44.setBackground(new Color(240, 240, 240));
       tres44.setText("");tres44.setBackground(new Color(240, 240, 240));
       UNO2.setText("0");UNO2.setBackground(new Color(240, 240, 240));
       DOS2.setText("0");DOS2.setBackground(new Color(240, 240, 240));
       TRES2.setText("0");TRES2.setBackground(new Color(240, 240, 240));
       CUATRO2.setText("95");CUATRO2.setBackground(Color.RED);
       suma();
    }//GEN-LAST:event_dos45ActionPerformed

    private void tres45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tres45ActionPerformed
       tres45.setText("X");tres45.setBackground(Color.red);
       dos45.setText("");dos45.setBackground(new Color(240, 240, 240));
       uno45.setText("");uno45.setBackground(new Color(240, 240, 240));
       
       uno42.setText("");uno42.setBackground(new Color(240, 240, 240));
       dos42.setText("");dos42.setBackground(new Color(240, 240, 240));
       tres42.setText("");tres42.setBackground(new Color(240, 240, 240));
       uno43.setText("");uno43.setBackground(new Color(240, 240, 240));
       dos43.setText("");dos43.setBackground(new Color(240, 240, 240));
       tres43.setText("");tres43.setBackground(new Color(240, 240, 240));
       uno44.setText("");uno44.setBackground(new Color(240, 240, 240));
       dos44.setText("");dos44.setBackground(new Color(240, 240, 240));
       tres44.setText("");tres44.setBackground(new Color(240, 240, 240));
       UNO2.setText("0");UNO2.setBackground(new Color(240, 240, 240));
       DOS2.setText("0");DOS2.setBackground(new Color(240, 240, 240));
       TRES2.setText("0");TRES2.setBackground(new Color(240, 240, 240));
       CUATRO2.setText("100");CUATRO2.setBackground(Color.RED);
       suma();
    }//GEN-LAST:event_tres45ActionPerformed

    private void uno45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno45ActionPerformed
       uno45.setText("X");uno45.setBackground(Color.red);
       dos45.setText("");dos45.setBackground(new Color(240, 240, 240));
       tres45.setText("");tres45.setBackground(new Color(240, 240, 240));
       
       uno42.setText("");uno42.setBackground(new Color(240, 240, 240));
       dos42.setText("");dos42.setBackground(new Color(240, 240, 240));
       tres42.setText("");tres42.setBackground(new Color(240, 240, 240));
       uno43.setText("");uno43.setBackground(new Color(240, 240, 240));
       dos43.setText("");dos43.setBackground(new Color(240, 240, 240));
       tres43.setText("");tres43.setBackground(new Color(240, 240, 240));
       uno44.setText("");uno44.setBackground(new Color(240, 240, 240));
       dos44.setText("");dos44.setBackground(new Color(240, 240, 240));
       tres44.setText("");tres44.setBackground(new Color(240, 240, 240));
       UNO2.setText("0");UNO2.setBackground(new Color(240, 240, 240));
       DOS2.setText("0");DOS2.setBackground(new Color(240, 240, 240));
       TRES2.setText("0");TRES2.setBackground(new Color(240, 240, 240));
       CUATRO2.setText("90");CUATRO2.setBackground(Color.RED);
       suma();
    }//GEN-LAST:event_uno45ActionPerformed

    private void dos46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dos46ActionPerformed
       dos46.setText("X");dos46.setBackground(Color.red);
       uno46.setText("");uno46.setBackground(new Color(240, 240, 240));
       tres46.setText("");tres46.setBackground(new Color(240, 240, 240));
       
       uno47.setText("");uno47.setBackground(new Color(240, 240, 240));
       dos47.setText("");dos47.setBackground(new Color(240, 240, 240));
       tres47.setText("");tres47.setBackground(new Color(240, 240, 240));
       uno48.setText("");uno48.setBackground(new Color(240, 240, 240));
       dos48.setText("");dos48.setBackground(new Color(240, 240, 240));
       tres48.setText("");tres48.setBackground(new Color(240, 240, 240));
       uno49.setText("");uno49.setBackground(new Color(240, 240, 240));
       dos49.setText("");dos49.setBackground(new Color(240, 240, 240));
       tres49.setText("");tres49.setBackground(new Color(240, 240, 240));
       UNO3.setText("33");UNO3.setBackground(Color.RED);
       DOS3.setText("0");DOS3.setBackground(new Color(240, 240, 240));
       TRES3.setText("0");TRES3.setBackground(new Color(240, 240, 240));
       CUATRO3.setText("0");CUATRO3.setBackground(new Color(240, 240, 240));
       suma();
    }//GEN-LAST:event_dos46ActionPerformed

    private void tres46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tres46ActionPerformed
       tres46.setText("X");tres46.setBackground(Color.red);
       uno46.setText("");uno46.setBackground(new Color(240, 240, 240));
       dos46.setText("");dos46.setBackground(new Color(240, 240, 240));
       
       uno47.setText("");uno47.setBackground(new Color(240, 240, 240));
       dos47.setText("");dos47.setBackground(new Color(240, 240, 240));
       tres47.setText("");tres47.setBackground(new Color(240, 240, 240));
       uno48.setText("");uno48.setBackground(new Color(240, 240, 240));
       dos48.setText("");dos48.setBackground(new Color(240, 240, 240));
       tres48.setText("");tres48.setBackground(new Color(240, 240, 240));
       uno49.setText("");uno49.setBackground(new Color(240, 240, 240));
       dos49.setText("");dos49.setBackground(new Color(240, 240, 240));
       tres49.setText("");tres49.setBackground(new Color(240, 240, 240));
       UNO3.setText("50");UNO3.setBackground(Color.RED);
       DOS3.setText("0");DOS3.setBackground(new Color(240, 240, 240));
       TRES3.setText("0");TRES3.setBackground(new Color(240, 240, 240));
       CUATRO3.setText("0");CUATRO3.setBackground(new Color(240, 240, 240));
       suma();
    }//GEN-LAST:event_tres46ActionPerformed

    private void uno46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno46ActionPerformed
       uno46.setText("X");uno46.setBackground(Color.red);
       dos46.setText("");dos46.setBackground(new Color(240, 240, 240));
       tres46.setText("");tres46.setBackground(new Color(240, 240, 240));
       
       uno47.setText("");uno47.setBackground(new Color(240, 240, 240));
       dos47.setText("");dos47.setBackground(new Color(240, 240, 240));
       tres47.setText("");tres47.setBackground(new Color(240, 240, 240));
       uno48.setText("");uno48.setBackground(new Color(240, 240, 240));
       dos48.setText("");dos48.setBackground(new Color(240, 240, 240));
       tres48.setText("");tres48.setBackground(new Color(240, 240, 240));
       uno49.setText("");uno49.setBackground(new Color(240, 240, 240));
       dos49.setText("");dos49.setBackground(new Color(240, 240, 240));
       tres49.setText("");tres49.setBackground(new Color(240, 240, 240));
      
       UNO3.setText("17");UNO3.setBackground(Color.RED);
       DOS3.setText("0");DOS3.setBackground(new Color(240, 240, 240));
       TRES3.setText("0");TRES3.setBackground(new Color(240, 240, 240));
       CUATRO3.setText("0");CUATRO3.setBackground(new Color(240, 240, 240));
       suma();
    }//GEN-LAST:event_uno46ActionPerformed

    private void dos47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dos47ActionPerformed
       dos47.setText("X");dos47.setBackground(Color.red);
       uno47.setText("");uno47.setBackground(new Color(240, 240, 240));
       tres47.setText("");tres47.setBackground(new Color(240, 240, 240));
       
       uno46.setText("");uno46.setBackground(new Color(240, 240, 240));
       dos46.setText("");dos46.setBackground(new Color(240, 240, 240));
       tres46.setText("");tres46.setBackground(new Color(240, 240, 240));
       uno48.setText("");uno48.setBackground(new Color(240, 240, 240));
       dos48.setText("");dos48.setBackground(new Color(240, 240, 240));
       tres48.setText("");tres48.setBackground(new Color(240, 240, 240));
       uno49.setText("");uno49.setBackground(new Color(240, 240, 240));
       dos49.setText("");dos49.setBackground(new Color(240, 240, 240));
       tres49.setText("");tres49.setBackground(new Color(240, 240, 240));
       UNO3.setText("0");UNO3.setBackground(new Color(240, 240, 240));
       DOS3.setText("60");DOS3.setBackground(Color.RED);
       TRES3.setText("0");TRES3.setBackground(new Color(240, 240, 240));
       CUATRO3.setText("0");CUATRO3.setBackground(new Color(240, 240, 240));
       suma();
    }//GEN-LAST:event_dos47ActionPerformed

    private void tres47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tres47ActionPerformed
       tres47.setText("X");tres47.setBackground(Color.red);
       dos47.setText("");dos47.setBackground(new Color(240, 240, 240));
       uno47.setText("");uno47.setBackground(new Color(240, 240, 240));
       
       uno46.setText("");uno46.setBackground(new Color(240, 240, 240));
       dos46.setText("");dos46.setBackground(new Color(240, 240, 240));
       tres46.setText("");tres46.setBackground(new Color(240, 240, 240));
       uno48.setText("");uno48.setBackground(new Color(240, 240, 240));
       dos48.setText("");dos48.setBackground(new Color(240, 240, 240));
       tres48.setText("");tres48.setBackground(new Color(240, 240, 240));
       uno49.setText("");uno49.setBackground(new Color(240, 240, 240));
       dos49.setText("");dos49.setBackground(new Color(240, 240, 240));
       tres49.setText("");tres49.setBackground(new Color(240, 240, 240));
       UNO3.setText("0");UNO3.setBackground(new Color(240, 240, 240));
       DOS3.setText("65");DOS3.setBackground(Color.RED);
       TRES3.setText("0");TRES3.setBackground(new Color(240, 240, 240));
       CUATRO3.setText("0");CUATRO3.setBackground(new Color(240, 240, 240));
       suma();
    }//GEN-LAST:event_tres47ActionPerformed

    private void uno47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno47ActionPerformed
       uno47.setText("X");uno47.setBackground(Color.red);
       dos47.setText("");dos47.setBackground(new Color(240, 240, 240));
       tres47.setText("");tres47.setBackground(new Color(240, 240, 240));
       
       uno46.setText("");uno46.setBackground(new Color(240, 240, 240));
       dos46.setText("");dos46.setBackground(new Color(240, 240, 240));
       tres46.setText("");tres46.setBackground(new Color(240, 240, 240));
       uno48.setText("");uno48.setBackground(new Color(240, 240, 240));
       dos48.setText("");dos48.setBackground(new Color(240, 240, 240));
       tres48.setText("");tres48.setBackground(new Color(240, 240, 240));
       uno49.setText("");uno49.setBackground(new Color(240, 240, 240));
       dos49.setText("");dos49.setBackground(new Color(240, 240, 240));
       tres49.setText("");tres49.setBackground(new Color(240, 240, 240));
       
       UNO3.setText("0");UNO3.setBackground(new Color(240, 240, 240));
       DOS3.setText("56");DOS3.setBackground(Color.RED);
       TRES3.setText("0");TRES3.setBackground(new Color(240, 240, 240));
       CUATRO3.setText("0");CUATRO3.setBackground(new Color(240, 240, 240));
       suma();
    }//GEN-LAST:event_uno47ActionPerformed

    private void dos48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dos48ActionPerformed
       dos48.setText("X");dos48.setBackground(Color.red);
       uno48.setText("");uno48.setBackground(new Color(240, 240, 240));
       tres48.setText("");tres48.setBackground(new Color(240, 240, 240));
       
       uno46.setText("");uno46.setBackground(new Color(240, 240, 240));
       dos46.setText("");dos46.setBackground(new Color(240, 240, 240));
       tres46.setText("");tres46.setBackground(new Color(240, 240, 240));
       uno47.setText("");uno47.setBackground(new Color(240, 240, 240));
       dos47.setText("");dos47.setBackground(new Color(240, 240, 240));
       tres47.setText("");tres47.setBackground(new Color(240, 240, 240));
       uno49.setText("");uno49.setBackground(new Color(240, 240, 240));
       dos49.setText("");dos49.setBackground(new Color(240, 240, 240));
       tres49.setText("");tres49.setBackground(new Color(240, 240, 240));
       UNO3.setText("0");UNO3.setBackground(new Color(240, 240, 240));
       DOS3.setText("0");DOS3.setBackground(new Color(240, 240, 240));
       TRES3.setText("78");TRES3.setBackground(Color.RED);
       CUATRO3.setText("0");CUATRO3.setBackground(new Color(240, 240, 240));
       suma();
    }//GEN-LAST:event_dos48ActionPerformed

    private void tres48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tres48ActionPerformed
       tres48.setText("X");tres48.setBackground(Color.red);
       dos48.setText("");dos48.setBackground(new Color(240, 240, 240));
       uno48.setText("");uno48.setBackground(new Color(240, 240, 240));
       
       uno46.setText("");uno46.setBackground(new Color(240, 240, 240));
       dos46.setText("");dos46.setBackground(new Color(240, 240, 240));
       tres46.setText("");tres46.setBackground(new Color(240, 240, 240));
       uno47.setText("");uno47.setBackground(new Color(240, 240, 240));
       dos47.setText("");dos47.setBackground(new Color(240, 240, 240));
       tres47.setText("");tres47.setBackground(new Color(240, 240, 240));
       uno49.setText("");uno49.setBackground(new Color(240, 240, 240));
       dos49.setText("");dos49.setBackground(new Color(240, 240, 240));
       tres49.setText("");tres49.setBackground(new Color(240, 240, 240));
       UNO3.setText("0");UNO3.setBackground(new Color(240, 240, 240));
       DOS3.setText("0");DOS3.setBackground(new Color(240, 240, 240));
       TRES3.setText("84");TRES3.setBackground(Color.RED);
       CUATRO3.setText("0");CUATRO3.setBackground(new Color(240, 240, 240));
       suma();
    }//GEN-LAST:event_tres48ActionPerformed

    private void uno48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno48ActionPerformed
       uno48.setText("X");uno48.setBackground(Color.red);
       dos48.setText("");dos48.setBackground(new Color(240, 240, 240));
       tres48.setText("");tres48.setBackground(new Color(240, 240, 240));
       
       uno46.setText("");uno46.setBackground(new Color(240, 240, 240));
       dos46.setText("");dos46.setBackground(new Color(240, 240, 240));
       tres46.setText("");tres46.setBackground(new Color(240, 240, 240));
       uno47.setText("");uno47.setBackground(new Color(240, 240, 240));
       dos47.setText("");dos47.setBackground(new Color(240, 240, 240));
       tres47.setText("");tres47.setBackground(new Color(240, 240, 240));
       uno49.setText("");uno49.setBackground(new Color(240, 240, 240));
       dos49.setText(""); dos49.setBackground(new Color(240, 240, 240));
       tres49.setText("");tres49.setBackground(new Color(240, 240, 240));
       UNO3.setText("0");UNO3.setBackground(new Color(240, 240, 240));
       DOS3.setText("0");DOS3.setBackground(new Color(240, 240, 240));
       TRES3.setText("72");TRES3.setBackground(Color.RED);
       CUATRO3.setText("0");CUATRO3.setBackground(new Color(240, 240, 240));
       suma();
    }//GEN-LAST:event_uno48ActionPerformed

    private void dos49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dos49ActionPerformed
       dos49.setText("X");dos49.setBackground(Color.red);
       uno49.setText("");uno49.setBackground(new Color(240, 240, 240));
       tres49.setText("");tres49.setBackground(new Color(240, 240, 240));
       
       uno46.setText("");uno46.setBackground(new Color(240, 240, 240));
       dos46.setText("");dos46.setBackground(new Color(240, 240, 240));
       tres46.setText("");tres46.setBackground(new Color(240, 240, 240));
       uno47.setText("");uno47.setBackground(new Color(240, 240, 240));
       dos47.setText("");dos47.setBackground(new Color(240, 240, 240));
       tres47.setText("");tres47.setBackground(new Color(240, 240, 240));
       uno48.setText("");uno48.setBackground(new Color(240, 240, 240));
       dos48.setText("");dos48.setBackground(new Color(240, 240, 240));
       tres48.setText("");tres48.setBackground(new Color(240, 240, 240));
       UNO3.setText("0");UNO3.setBackground(new Color(240, 240, 240));
       DOS3.setText("0");DOS3.setBackground(new Color(240, 240, 240));
       TRES3.setText("0");TRES3.setBackground(new Color(240, 240, 240));
       CUATRO3.setText("95");CUATRO3.setBackground(Color.RED);
       suma();
    }//GEN-LAST:event_dos49ActionPerformed

    private void tres49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tres49ActionPerformed
       tres49.setText("X");tres49.setBackground(Color.red);
       dos49.setText("");dos49.setBackground(new Color(240, 240, 240));
       uno49.setText("");uno49.setBackground(new Color(240, 240, 240));
       
       uno46.setText("");uno46.setBackground(new Color(240, 240, 240));
       dos46.setText("");dos46.setBackground(new Color(240, 240, 240));
       tres46.setText("");tres46.setBackground(new Color(240, 240, 240));
       uno47.setText("");uno47.setBackground(new Color(240, 240, 240));
       dos47.setText("");dos47.setBackground(new Color(240, 240, 240));
       tres47.setText("");tres47.setBackground(new Color(240, 240, 240));
       uno48.setText("");uno48.setBackground(new Color(240, 240, 240));
       dos48.setText("");dos48.setBackground(new Color(240, 240, 240));
       tres48.setText("");tres48.setBackground(new Color(240, 240, 240));
       UNO3.setText("0");UNO3.setBackground(new Color(240, 240, 240));
       DOS3.setText("0");DOS3.setBackground(new Color(240, 240, 240));
       TRES3.setText("0");TRES3.setBackground(new Color(240, 240, 240));
       CUATRO3.setText("100");CUATRO3.setBackground(Color.RED);
       suma();
    }//GEN-LAST:event_tres49ActionPerformed

    private void uno49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno49ActionPerformed
       uno49.setText("X");uno49.setBackground(Color.red);
       dos49.setText("");dos49.setBackground(new Color(240, 240, 240));
       tres49.setText("");tres49.setBackground(new Color(240, 240, 240));
       
       uno46.setText("");uno46.setBackground(new Color(240, 240, 240));
       dos46.setText("");dos46.setBackground(new Color(240, 240, 240));
       tres46.setText("");tres46.setBackground(new Color(240, 240, 240));
       uno47.setText("");uno47.setBackground(new Color(240, 240, 240));
       dos47.setText("");dos47.setBackground(new Color(240, 240, 240));
       tres47.setText("");tres47.setBackground(new Color(240, 240, 240));
       uno48.setText("");uno48.setBackground(new Color(240, 240, 240));
       dos48.setText("");dos48.setBackground(new Color(240, 240, 240));
       tres48.setText("");tres48.setBackground(new Color(240, 240, 240));
       UNO3.setText("0");UNO3.setBackground(new Color(240, 240, 240));
       DOS3.setText("0");DOS3.setBackground(new Color(240, 240, 240));
       TRES3.setText("0");TRES3.setBackground(new Color(240, 240, 240));
       CUATRO3.setText("90");CUATRO3.setBackground(Color.RED);
       suma();
    }//GEN-LAST:event_uno49ActionPerformed

    private void dos50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dos50ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dos50ActionPerformed

    private void tres50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tres50ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tres50ActionPerformed

    private void uno50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno50ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uno50ActionPerformed

    private void dos51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dos51ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dos51ActionPerformed

    private void tres51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tres51ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tres51ActionPerformed

    private void uno51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno51ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uno51ActionPerformed

    private void dos52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dos52ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dos52ActionPerformed

    private void tres52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tres52ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tres52ActionPerformed

    private void uno52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno52ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uno52ActionPerformed

    private void dos53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dos53ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dos53ActionPerformed

    private void tres53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tres53ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tres53ActionPerformed

    private void uno53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno53ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uno53ActionPerformed

    private void dos54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dos54ActionPerformed
       dos54.setText("X");dos54.setBackground(Color.red);
       uno54.setText("");uno54.setBackground(new Color(240, 240, 240));
       tres54.setText("");tres54.setBackground(new Color(240, 240, 240));
       
       uno55.setText("");uno55.setBackground(new Color(240, 240, 240));
       dos55.setText("");dos55.setBackground(new Color(240, 240, 240));
       tres55.setText("");tres55.setBackground(new Color(240, 240, 240));
       uno56.setText("");uno56.setBackground(new Color(240, 240, 240));
       dos56.setText("");dos56.setBackground(new Color(240, 240, 240));
       tres56.setText("");tres56.setBackground(new Color(240, 240, 240));
       uno57.setText("");uno57.setBackground(new Color(240, 240, 240));
       dos57.setText("");dos57.setBackground(new Color(240, 240, 240));
       tres57.setText("");tres57.setBackground(new Color(240, 240, 240));
       UNO4.setText("33");UNO4.setBackground(Color.RED);
       DOS4.setText("0");DOS4.setBackground(new Color(240, 240, 240));
       TRES4.setText("0");TRES4.setBackground(new Color(240, 240, 240));
       CUATRO4.setText("0");CUATRO4.setBackground(new Color(240, 240, 240));
       suma();
    }//GEN-LAST:event_dos54ActionPerformed

    private void tres54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tres54ActionPerformed
       tres54.setText("X");tres54.setBackground(Color.red);
       uno54.setText("");uno54.setBackground(new Color(240, 240, 240));
       dos54.setText("");dos54.setBackground(new Color(240, 240, 240));
       
       uno55.setText("");uno55.setBackground(new Color(240, 240, 240));
       dos55.setText("");dos55.setBackground(new Color(240, 240, 240));
       tres55.setText("");tres55.setBackground(new Color(240, 240, 240));
       uno56.setText("");uno56.setBackground(new Color(240, 240, 240));
       dos56.setText("");dos56.setBackground(new Color(240, 240, 240));
       tres56.setText("");tres56.setBackground(new Color(240, 240, 240));
       uno57.setText("");uno57.setBackground(new Color(240, 240, 240));
       dos57.setText("");dos57.setBackground(new Color(240, 240, 240));
       tres57.setText("");tres57.setBackground(new Color(240, 240, 240));
       UNO4.setText("50");UNO4.setBackground(Color.RED);
       DOS4.setText("0");DOS4.setBackground(new Color(240, 240, 240));
       TRES4.setText("0");TRES4.setBackground(new Color(240, 240, 240));
       CUATRO4.setText("0");CUATRO4.setBackground(new Color(240, 240, 240));
       suma();
    }//GEN-LAST:event_tres54ActionPerformed

    private void uno54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno54ActionPerformed
       uno54.setText("X");uno54.setBackground(Color.red);
       dos54.setText("");dos54.setBackground(new Color(240, 240, 240));
       tres54.setText("");tres54.setBackground(new Color(240, 240, 240));
       
       uno55.setText("");uno55.setBackground(new Color(240, 240, 240));
       dos55.setText("");dos55.setBackground(new Color(240, 240, 240));
       tres55.setText("");tres55.setBackground(new Color(240, 240, 240));
       uno56.setText("");uno56.setBackground(new Color(240, 240, 240));
       dos56.setText("");dos56.setBackground(new Color(240, 240, 240));
       tres56.setText("");tres56.setBackground(new Color(240, 240, 240));
       uno57.setText("");uno57.setBackground(new Color(240, 240, 240));
       dos57.setText("");dos57.setBackground(new Color(240, 240, 240));
       tres57.setText("");tres57.setBackground(new Color(240, 240, 240));
      
       UNO4.setText("17");UNO4.setBackground(Color.RED);
       DOS4.setText("0");DOS4.setBackground(new Color(240, 240, 240));
       TRES4.setText("0");TRES4.setBackground(new Color(240, 240, 240));
       CUATRO4.setText("0");CUATRO4.setBackground(new Color(240, 240, 240));
       suma();
    }//GEN-LAST:event_uno54ActionPerformed

    private void dos55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dos55ActionPerformed
       dos55.setText("X");dos55.setBackground(Color.red);
       uno55.setText("");uno55.setBackground(new Color(240, 240, 240));
       tres55.setText("");tres55.setBackground(new Color(240, 240, 240));
       
       uno54.setText("");uno54.setBackground(new Color(240, 240, 240));
       dos54.setText("");dos54.setBackground(new Color(240, 240, 240));
       tres54.setText("");tres54.setBackground(new Color(240, 240, 240));
       uno56.setText("");uno56.setBackground(new Color(240, 240, 240));
       dos56.setText("");dos56.setBackground(new Color(240, 240, 240));
       tres56.setText("");tres56.setBackground(new Color(240, 240, 240));
       uno57.setText("");uno57.setBackground(new Color(240, 240, 240));
       dos57.setText("");dos57.setBackground(new Color(240, 240, 240));
       tres57.setText("");tres57.setBackground(new Color(240, 240, 240));
       UNO4.setText("0");UNO4.setBackground(new Color(240, 240, 240));
       DOS4.setText("60");DOS4.setBackground(Color.RED);
       TRES4.setText("0");TRES4.setBackground(new Color(240, 240, 240));
       CUATRO4.setText("0");CUATRO4.setBackground(new Color(240, 240, 240));
       suma();
    }//GEN-LAST:event_dos55ActionPerformed

    private void tres55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tres55ActionPerformed
       tres55.setText("X");tres55.setBackground(Color.red);
       dos55.setText("");dos55.setBackground(new Color(240, 240, 240));
       uno55.setText("");uno55.setBackground(new Color(240, 240, 240));
       
       uno54.setText("");uno54.setBackground(new Color(240, 240, 240));
       dos54.setText("");dos54.setBackground(new Color(240, 240, 240));
       tres54.setText("");tres54.setBackground(new Color(240, 240, 240));
       uno56.setText("");uno56.setBackground(new Color(240, 240, 240));
       dos56.setText("");dos56.setBackground(new Color(240, 240, 240));
       tres56.setText("");tres56.setBackground(new Color(240, 240, 240));
       uno57.setText("");uno57.setBackground(new Color(240, 240, 240));
       dos57.setText("");dos57.setBackground(new Color(240, 240, 240));
       tres57.setText("");tres57.setBackground(new Color(240, 240, 240));
        UNO4.setText("0");UNO4.setBackground(new Color(240, 240, 240));
       DOS4.setText("65");DOS4.setBackground(Color.RED);
       TRES4.setText("0");TRES4.setBackground(new Color(240, 240, 240));
       CUATRO4.setText("0");CUATRO4.setBackground(new Color(240, 240, 240));
       suma();
    }//GEN-LAST:event_tres55ActionPerformed

    private void uno55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno55ActionPerformed
       uno55.setText("X");uno55.setBackground(Color.red);
       dos55.setText("");dos55.setBackground(new Color(240, 240, 240));
       tres55.setText("");tres55.setBackground(new Color(240, 240, 240));
       
       uno54.setText("");uno54.setBackground(new Color(240, 240, 240));
       dos54.setText("");dos54.setBackground(new Color(240, 240, 240));
       tres54.setText("");tres54.setBackground(new Color(240, 240, 240));
       uno56.setText("");uno56.setBackground(new Color(240, 240, 240));
       dos56.setText("");dos56.setBackground(new Color(240, 240, 240));
       tres56.setText("");tres56.setBackground(new Color(240, 240, 240));
       uno57.setText("");uno57.setBackground(new Color(240, 240, 240));
       dos57.setText("");dos57.setBackground(new Color(240, 240, 240));
       tres57.setText("");tres57.setBackground(new Color(240, 240, 240));
       UNO4.setText("0");UNO4.setBackground(new Color(240, 240, 240));
       DOS4.setText("56");DOS4.setBackground(Color.RED);
       TRES4.setText("0");TRES4.setBackground(new Color(240, 240, 240));
       CUATRO4.setText("0");CUATRO4.setBackground(new Color(240, 240, 240));
       suma();
    }//GEN-LAST:event_uno55ActionPerformed

    private void dos56ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dos56ActionPerformed
       dos56.setText("X");dos56.setBackground(Color.red);
       uno56.setText("");uno56.setBackground(new Color(240, 240, 240));
       tres56.setText("");tres56.setBackground(new Color(240, 240, 240));
       
       uno54.setText("");uno54.setBackground(new Color(240, 240, 240));
       dos54.setText("");dos54.setBackground(new Color(240, 240, 240));
       tres54.setText("");tres54.setBackground(new Color(240, 240, 240));
       uno55.setText("");uno55.setBackground(new Color(240, 240, 240));
       dos55.setText("");dos55.setBackground(new Color(240, 240, 240));
       tres55.setText("");tres55.setBackground(new Color(240, 240, 240));
       uno57.setText("");uno57.setBackground(new Color(240, 240, 240));
       dos57.setText("");dos57.setBackground(new Color(240, 240, 240));
       tres57.setText("");tres57.setBackground(new Color(240, 240, 240));
       UNO4.setText("0");UNO4.setBackground(new Color(240, 240, 240));
       DOS4.setText("0");DOS4.setBackground(new Color(240, 240, 240));
       TRES4.setText("78");TRES4.setBackground(Color.RED);
       CUATRO4.setText("0");CUATRO4.setBackground(new Color(240, 240, 240));
       suma();
    }//GEN-LAST:event_dos56ActionPerformed

    private void tres56ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tres56ActionPerformed
       tres56.setText("X");tres56.setBackground(Color.red);
       dos56.setText("");dos56.setBackground(new Color(240, 240, 240));
       uno56.setText("");uno56.setBackground(new Color(240, 240, 240));
       
       uno54.setText("");uno54.setBackground(new Color(240, 240, 240));
       dos54.setText("");dos54.setBackground(new Color(240, 240, 240));
       tres54.setText("");tres54.setBackground(new Color(240, 240, 240));
       uno55.setText("");uno55.setBackground(new Color(240, 240, 240));
       dos55.setText("");dos55.setBackground(new Color(240, 240, 240));
       tres55.setText("");tres55.setBackground(new Color(240, 240, 240));
       uno57.setText("");uno57.setBackground(new Color(240, 240, 240));
       dos57.setText("");dos57.setBackground(new Color(240, 240, 240));
       tres57.setText("");tres57.setBackground(new Color(240, 240, 240));
        UNO4.setText("0");UNO4.setBackground(new Color(240, 240, 240));
       DOS4.setText("0");DOS4.setBackground(new Color(240, 240, 240));
       TRES4.setText("84");TRES4.setBackground(Color.RED);
       CUATRO4.setText("0");CUATRO4.setBackground(new Color(240, 240, 240));
       suma();
    }//GEN-LAST:event_tres56ActionPerformed

    private void uno56ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno56ActionPerformed
       uno56.setText("X");uno56.setBackground(Color.red);
       dos56.setText("");dos56.setBackground(new Color(240, 240, 240));
       tres56.setText("");tres56.setBackground(new Color(240, 240, 240));
       
       uno54.setText("");uno54.setBackground(new Color(240, 240, 240));
       dos54.setText("");dos54.setBackground(new Color(240, 240, 240));
       tres54.setText("");tres54.setBackground(new Color(240, 240, 240));
       uno55.setText("");uno55.setBackground(new Color(240, 240, 240));
       dos55.setText("");dos55.setBackground(new Color(240, 240, 240));
       tres55.setText("");tres55.setBackground(new Color(240, 240, 240));
       uno57.setText("");uno57.setBackground(new Color(240, 240, 240));
       dos57.setText(""); dos57.setBackground(new Color(240, 240, 240));
       tres57.setText("");tres57.setBackground(new Color(240, 240, 240));
       UNO4.setText("0");UNO4.setBackground(new Color(240, 240, 240));
       DOS4.setText("0");DOS4.setBackground(new Color(240, 240, 240));
       TRES4.setText("72");TRES4.setBackground(Color.RED);
       CUATRO4.setText("0");CUATRO4.setBackground(new Color(240, 240, 240));
       suma();
    }//GEN-LAST:event_uno56ActionPerformed

    private void dos57ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dos57ActionPerformed
       dos57.setText("X");dos57.setBackground(Color.red);
       uno57.setText("");uno57.setBackground(new Color(240, 240, 240));
       tres57.setText("");tres57.setBackground(new Color(240, 240, 240));
       
       uno54.setText("");uno54.setBackground(new Color(240, 240, 240));
       dos54.setText("");dos54.setBackground(new Color(240, 240, 240));
       tres54.setText("");tres54.setBackground(new Color(240, 240, 240));
       uno55.setText("");uno55.setBackground(new Color(240, 240, 240));
       dos55.setText("");dos55.setBackground(new Color(240, 240, 240));
       tres55.setText("");tres55.setBackground(new Color(240, 240, 240));
       uno56.setText("");uno56.setBackground(new Color(240, 240, 240));
       dos56.setText("");dos56.setBackground(new Color(240, 240, 240));
       tres56.setText("");tres56.setBackground(new Color(240, 240, 240));
       UNO4.setText("0");UNO4.setBackground(new Color(240, 240, 240));
       DOS4.setText("0");DOS4.setBackground(new Color(240, 240, 240));
       TRES4.setText("0");TRES4.setBackground(new Color(240, 240, 240));
       CUATRO4.setText("95");CUATRO4.setBackground(Color.RED);
       suma();
    }//GEN-LAST:event_dos57ActionPerformed

    private void tres57ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tres57ActionPerformed
       tres57.setText("X");tres57.setBackground(Color.red);
       dos57.setText("");dos57.setBackground(new Color(240, 240, 240));
       uno57.setText("");uno57.setBackground(new Color(240, 240, 240));
       
       uno54.setText("");uno54.setBackground(new Color(240, 240, 240));
       dos54.setText("");dos54.setBackground(new Color(240, 240, 240));
       tres54.setText("");tres54.setBackground(new Color(240, 240, 240));
       uno55.setText("");uno55.setBackground(new Color(240, 240, 240));
       dos55.setText("");dos55.setBackground(new Color(240, 240, 240));
       tres55.setText("");tres55.setBackground(new Color(240, 240, 240));
       uno56.setText("");uno56.setBackground(new Color(240, 240, 240));
       dos56.setText("");dos56.setBackground(new Color(240, 240, 240));
       tres56.setText("");tres56.setBackground(new Color(240, 240, 240));
       UNO4.setText("0");UNO4.setBackground(new Color(240, 240, 240));
       DOS4.setText("0");DOS4.setBackground(new Color(240, 240, 240));
       TRES4.setText("0");TRES4.setBackground(new Color(240, 240, 240));
       CUATRO4.setText("100");CUATRO4.setBackground(Color.RED);
       suma();
    }//GEN-LAST:event_tres57ActionPerformed

    private void uno57ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno57ActionPerformed
       uno57.setText("X");uno57.setBackground(Color.red);
       dos57.setText("");dos57.setBackground(new Color(240, 240, 240));
       tres57.setText("");tres57.setBackground(new Color(240, 240, 240));
       
       uno54.setText("");uno54.setBackground(new Color(240, 240, 240));
       dos54.setText("");dos54.setBackground(new Color(240, 240, 240));
       tres54.setText("");tres54.setBackground(new Color(240, 240, 240));
       uno55.setText("");uno55.setBackground(new Color(240, 240, 240));
       dos55.setText("");dos55.setBackground(new Color(240, 240, 240));
       tres55.setText("");tres55.setBackground(new Color(240, 240, 240));
       uno56.setText("");uno56.setBackground(new Color(240, 240, 240));
       dos56.setText("");dos56.setBackground(new Color(240, 240, 240));
       tres56.setText("");tres56.setBackground(new Color(240, 240, 240));
       UNO4.setText("0");UNO4.setBackground(new Color(240, 240, 240));
       DOS4.setText("0");DOS4.setBackground(new Color(240, 240, 240));
       TRES4.setText("0");TRES4.setBackground(new Color(240, 240, 240));
       CUATRO4.setText("90");CUATRO4.setBackground(Color.RED);
       suma();
    }//GEN-LAST:event_uno57ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        if((UNO.getText().compareTo("0") != 0 || DOS.getText().compareTo("0")!= 0 || TRES.getText().compareTo("0")!= 0 || CUATRO.getText().compareTo("0")!= 0) &&
                 (UNO1.getText().compareTo("0") != 0 || DOS1.getText().compareTo("0")!= 0 || TRES1.getText().compareTo("0")!= 0 || CUATRO1.getText().compareTo("0")!= 0) &&
                 (UNO2.getText().compareTo("0") != 0 || DOS2.getText().compareTo("0")!= 0 || TRES2.getText().compareTo("0")!= 0 || CUATRO2.getText().compareTo("0")!= 0) &&
                 (UNO3.getText().compareTo("0") != 0 || DOS3.getText().compareTo("0")!= 0 || TRES3.getText().compareTo("0")!= 0 || CUATRO3.getText().compareTo("0")!= 0) &&
                 (UNO4.getText().compareTo("0") != 0 || DOS4.getText().compareTo("0")!= 0 || TRES4.getText().compareTo("0")!= 0 || CUATRO4.getText().compareTo("0")!= 0) )
         {
        try {
            ClassEvaluacionSupervisores l = new ClassEvaluacionSupervisores();
            l.setId_evaluacion(id_evaluacion);
            l.setUNO(Integer.parseInt(UNO.getText()));
            l.setDOS(Integer.parseInt(DOS.getText()));
            l.setTRES(Integer.parseInt(TRES.getText()));
            l.setCUATRO(Integer.parseInt(CUATRO.getText()));
            
            l.setUNO1(Integer.parseInt(UNO1.getText()));
            l.setDOS1(Integer.parseInt(DOS1.getText()));
            l.setTRES1(Integer.parseInt(TRES1.getText()));
            l.setCUATRO1(Integer.parseInt(CUATRO1.getText()));
            
            l.setUNO2(Integer.parseInt(UNO2.getText()));
            l.setDOS2(Integer.parseInt(DOS2.getText()));
            l.setTRES2(Integer.parseInt(TRES2.getText()));
            l.setCUATRO2(Integer.parseInt(CUATRO2.getText()));
            
            l.setUNO3(Integer.parseInt(UNO3.getText()));
            l.setDOS3(Integer.parseInt(DOS3.getText()));
            l.setTRES3(Integer.parseInt(TRES3.getText()));
            l.setCUATRO3(Integer.parseInt(CUATRO3.getText()));
            l.setUNO4(Integer.parseInt(UNO4.getText()));
            l.setDOS4(Integer.parseInt(DOS4.getText()));
            l.setTRES4(Integer.parseInt(TRES4.getText()));
            l.setCUATRO4(Integer.parseInt(CUATRO4.getText()));
            l.setNOTA(NOTA.getText());
            Clases.EvaluacionSupervisores.InsertarEvaluacionSupervisores.insertarOrientacionResultados(l);
            JOptionPane.showMessageDialog(null, "EVALUACION TERMINADA CORRECTAMENTE");
            this.dispose();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "ERROR INGRESO EMPLEADOS" + e);
        }
        }else{JOptionPane.showMessageDialog(null, "FALTA PARA TERMINAR LA EVALUACION");}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
      
       /* TiposEvaluacion tra = new TiposEvaluacion(id_evaluacion);
        Pane1.add(tra);
        Dimension desktopSize = Pane1.getSize();
        Dimension FrameSize = tra.getSize();
        tra.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        tra.show();*/
        
    }//GEN-LAST:event_formInternalFrameClosing

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
       TiposEvaluacionSupervisores tra = new TiposEvaluacionSupervisores(id_evaluacion);
        Pane1.add(tra);
        Dimension desktopSize = Pane1.getSize();
        Dimension FrameSize = tra.getSize();
        tra.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        tra.show();
       
    }//GEN-LAST:event_formInternalFrameClosed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(bEvaluacionOrientacionAresultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bEvaluacionOrientacionAresultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bEvaluacionOrientacionAresultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bEvaluacionOrientacionAresultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bEvaluacionOrientacionAresultados(1,2).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CUATRO;
    private javax.swing.JTextField CUATRO1;
    private javax.swing.JTextField CUATRO2;
    private javax.swing.JTextField CUATRO3;
    private javax.swing.JTextField CUATRO4;
    private javax.swing.JTextField DOS;
    private javax.swing.JTextField DOS1;
    private javax.swing.JTextField DOS2;
    private javax.swing.JTextField DOS3;
    private javax.swing.JTextField DOS4;
    private javax.swing.JLabel LabelFoto1;
    private javax.swing.JTextArea NOTA;
    private javax.swing.JTextField TRES;
    private javax.swing.JTextField TRES1;
    private javax.swing.JTextField TRES2;
    private javax.swing.JTextField TRES3;
    private javax.swing.JTextField TRES4;
    private javax.swing.JTextField TxtTotal;
    private javax.swing.JTextField UNO;
    private javax.swing.JTextField UNO1;
    private javax.swing.JTextField UNO2;
    private javax.swing.JTextField UNO3;
    private javax.swing.JTextField UNO4;
    private javax.swing.JButton dos;
    private javax.swing.JButton dos19;
    private javax.swing.JButton dos20;
    private javax.swing.JButton dos21;
    private javax.swing.JButton dos22;
    private javax.swing.JButton dos27;
    private javax.swing.JButton dos28;
    private javax.swing.JButton dos29;
    private javax.swing.JButton dos30;
    private javax.swing.JButton dos31;
    private javax.swing.JButton dos32;
    private javax.swing.JButton dos33;
    private javax.swing.JButton dos34;
    private javax.swing.JButton dos35;
    private javax.swing.JButton dos36;
    private javax.swing.JButton dos37;
    private javax.swing.JButton dos38;
    private javax.swing.JButton dos39;
    private javax.swing.JButton dos40;
    private javax.swing.JButton dos41;
    private javax.swing.JButton dos42;
    private javax.swing.JButton dos43;
    private javax.swing.JButton dos44;
    private javax.swing.JButton dos45;
    private javax.swing.JButton dos46;
    private javax.swing.JButton dos47;
    private javax.swing.JButton dos48;
    private javax.swing.JButton dos49;
    private javax.swing.JButton dos50;
    private javax.swing.JButton dos51;
    private javax.swing.JButton dos52;
    private javax.swing.JButton dos53;
    private javax.swing.JButton dos54;
    private javax.swing.JButton dos55;
    private javax.swing.JButton dos56;
    private javax.swing.JButton dos57;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel62;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel64;
    private javax.swing.JPanel jPanel65;
    private javax.swing.JPanel jPanel66;
    private javax.swing.JPanel jPanel67;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField39;
    private javax.swing.JTextField jTextField40;
    private javax.swing.JTextField jTextField41;
    private javax.swing.JTextField jTextField42;
    private javax.swing.JTextField jTextField51;
    private javax.swing.JTextField jTextField52;
    private javax.swing.JTextField jTextField53;
    private javax.swing.JTextField jTextField54;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel l2;
    private javax.swing.JLabel l3;
    private javax.swing.JLabel l4;
    private javax.swing.JLabel punteo;
    private javax.swing.JButton tres;
    private javax.swing.JButton tres19;
    private javax.swing.JButton tres20;
    private javax.swing.JButton tres21;
    private javax.swing.JButton tres22;
    private javax.swing.JButton tres27;
    private javax.swing.JButton tres28;
    private javax.swing.JButton tres29;
    private javax.swing.JButton tres30;
    private javax.swing.JButton tres31;
    private javax.swing.JButton tres32;
    private javax.swing.JButton tres33;
    private javax.swing.JButton tres34;
    private javax.swing.JButton tres35;
    private javax.swing.JButton tres36;
    private javax.swing.JButton tres37;
    private javax.swing.JButton tres38;
    private javax.swing.JButton tres39;
    private javax.swing.JButton tres40;
    private javax.swing.JButton tres41;
    private javax.swing.JButton tres42;
    private javax.swing.JButton tres43;
    private javax.swing.JButton tres44;
    private javax.swing.JButton tres45;
    private javax.swing.JButton tres46;
    private javax.swing.JButton tres47;
    private javax.swing.JButton tres48;
    private javax.swing.JButton tres49;
    private javax.swing.JButton tres50;
    private javax.swing.JButton tres51;
    private javax.swing.JButton tres52;
    private javax.swing.JButton tres53;
    private javax.swing.JButton tres54;
    private javax.swing.JButton tres55;
    private javax.swing.JButton tres56;
    private javax.swing.JButton tres57;
    private javax.swing.JButton uno;
    private javax.swing.JButton uno19;
    private javax.swing.JButton uno20;
    private javax.swing.JButton uno21;
    private javax.swing.JButton uno22;
    private javax.swing.JButton uno27;
    private javax.swing.JButton uno28;
    private javax.swing.JButton uno29;
    private javax.swing.JButton uno30;
    private javax.swing.JButton uno31;
    private javax.swing.JButton uno32;
    private javax.swing.JButton uno33;
    private javax.swing.JButton uno34;
    private javax.swing.JButton uno35;
    private javax.swing.JButton uno36;
    private javax.swing.JButton uno37;
    private javax.swing.JButton uno38;
    private javax.swing.JButton uno39;
    private javax.swing.JButton uno40;
    private javax.swing.JButton uno41;
    private javax.swing.JButton uno42;
    private javax.swing.JButton uno43;
    private javax.swing.JButton uno44;
    private javax.swing.JButton uno45;
    private javax.swing.JButton uno46;
    private javax.swing.JButton uno47;
    private javax.swing.JButton uno48;
    private javax.swing.JButton uno49;
    private javax.swing.JButton uno50;
    private javax.swing.JButton uno51;
    private javax.swing.JButton uno52;
    private javax.swing.JButton uno53;
    private javax.swing.JButton uno54;
    private javax.swing.JButton uno55;
    private javax.swing.JButton uno56;
    private javax.swing.JButton uno57;
    // End of variables declaration//GEN-END:variables
}
