/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases.CalculosPrestaciones;

import BD.BD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author jluis
 */
public class Indemnizacion {
    
    public static classIndemnizacion buscarEmpleado(int id) throws SQLException {
        return buscarEmple(id, null);
    }    
 public static classIndemnizacion buscarEmple(int id,classIndemnizacion p) throws SQLException {
        Connection cnn = BD.getConnection();
        
        try {
            PreparedStatement ps = null;
            ps = cnn.prepareStatement("select ID_LISTAEMPLEADOS,NOMBRES,ORDINARIO,BONIFICACION,TO_CHAR(FECHA_INGRESO,'MON-DD-YYYY') AS FECHA_INGRESO from alistaempleados where codigo = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                if (p == null) {
                    p = new classIndemnizacion(){
                    };
                }
                p.setIdEmpleado(rs.getInt("ID_LISTAEMPLEADOS"));
                p.setNombre(rs.getString("NOMBRES"));
                p.setSalario(rs.getDouble("ORDINARIO"));
                p.setBonificacion(rs.getDouble("BONIFICACION"));
                p.setFechaIngre(rs.getString("FECHA_INGRESO"));
                cnn.close();
                ps.close();
                return p;
            }

        } catch (Exception e) {
               System.err.println("errroooooorrr"+e);    
        }
        
        return null;

    }  


     public static classIndemnizacion PromedioSalarioDias(int codigo) throws SQLException {
        return promedio(codigo, null);
    }    
 public static classIndemnizacion promedio(int codigo,classIndemnizacion p) throws SQLException {
        Connection cnn = BD.getConnection();
        
        try {
            PreparedStatement ps = null;
            ps = cnn.prepareStatement("Select sum(salario)/6 as salario,sum(dias) as dias,sum(salario) as salariototal from (select * from historialsalarios order by id_historial desc ) where codigo = ? and rownum <= 6 ORDER BY id_historial ASC");
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                if (p == null) {
                    p = new classIndemnizacion(){
                    };
                }
                p.setSalario(rs.getDouble("salario"));
                p.setDias(rs.getInt("dias"));
                p.setSalariopromedio(rs.getDouble("salariototal"));
                cnn.close();
                ps.close();
                return p;
            }

        } catch (Exception e) {
               System.err.println("errroooooorrr"+e);    
        }
        
        return null;

    }  
 
    public static classIndemnizacion PromedioSalario12meses(int codigo) throws SQLException {
        return promedio12(codigo, null);
    }    
 public static classIndemnizacion promedio12(int codigo,classIndemnizacion p) throws SQLException {
        Connection cnn = BD.getConnection();
        
        try {
            PreparedStatement ps = null;
            ps = cnn.prepareStatement("Select sum(salario-250)/12 as salario,sum(dias) as dias,sum(salario) as salariototal from (select * from historialsalarios order by id_historial desc ) where codigo = ? and rownum <= 12 ORDER BY id_historial ASC");
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                if (p == null) {
                    p = new classIndemnizacion(){
                    };
                }
                p.setSalariopromedio12(rs.getDouble("salario"));
                p.setDias(rs.getInt("dias"));
                p.setSalariopromedio(rs.getDouble("salariototal"));
                cnn.close();
                ps.close();
                return p;
            }

        } catch (Exception e) {
               System.err.println("errroooooorrr"+e);    
        }
        
        return null;

    }  
 
 

public static ArrayList<classIndemnizacion> ListarUltimosMeses(int codigo) {
                   
        return SQL1("Select salario,TO_CHAR(fecha,'MON-DD-YYYY') as fecha,dias from (select * from historialsalarios order by id_historial desc ) where codigo = "+codigo+" and rownum <= 6 ORDER BY id_historial ASC");
    }
 
 
 
    private static ArrayList<classIndemnizacion> SQL1(String sql){
    ArrayList<classIndemnizacion> list = new ArrayList<classIndemnizacion>();
    Connection cn = BD.getConnection();
        try {
            classIndemnizacion b;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                 b = new classIndemnizacion();
                 b.setSalario(rs.getDouble("salario"));
                 b.setFecha(rs.getString("fecha"));
                 b.setDias(rs.getInt("dias"));
                 list.add(b);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } 
        return list;
} 
    
    
    
    
}
