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
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jluis
 */
public class coneIndicadores {
    
    
    
    
    public static  ArrayList<ClassIndicador> ListarTodosProductos(String a,String b) {
       
       return consultaTrabajo("select a.codigo,a.nombres,decode(b.depto,1,'INSPECCION',2,'TESTING',3,'CHIPS',4,'SOLDER DIP STRIP y POTTING',5,'TRANSFORMADORES',6,'TALLER',7,'BODEGA',8,'ADMINISTRACION',9,'GERENCIA',10,'TECNOLOGIA DE LA INFORMACION/MANTENIMIENTO',11,'MOLDING') as DEPTO,to_char(b.fecha,'dd/mm/yyyy') as fecha,b.evaluacion,b.face from bevaluacion_desempeno b inner join alistaempleados a on b.id_listaempleados = a.id_listaempleados where \n" +
        "b.fecha between to_date('"+a+"','dd/mm/yy') and to_date('"+b+"','dd/mm/yy') and b.estado = 2 order by b.depto");
     }
        private static ArrayList<ClassIndicador> consultaTrabajo(String sql) {
        ArrayList<ClassIndicador> list = new ArrayList<ClassIndicador>();
        Connection cn = BD.getConnection();
        try {
            ClassIndicador t;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                t = new ClassIndicador();
                t.setCodigo(rs.getInt("codigo"));
                t.setNombre(rs.getString("nombres"));
                t.setDepto(rs.getString("depto"));
                t.setFecha(rs.getString("fecha"));
                t.setEvaluacion(rs.getInt("evaluacion"));
                t.setFase(rs.getInt("face"));
                list.add(t);
                }
            cn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR " + e);
        }
        return list;
        }
    
    
    
    
    
    
    
    
    
    
    
}
