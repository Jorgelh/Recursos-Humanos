/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases.Evaluacion;

import BD.BD;
import Clases.empleados.ListaMaestro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jluis
 */
public class BDEvaluacion {
    
    public static void insertarEvaluacion(ClassEvaluacion c) throws SQLException {
        
        Connection cnn = BD.getConnection();
        PreparedStatement p = null;
        p = cnn.prepareStatement("insert into");
        p.setInt(1, c.getId_listaempleados());
        p.setDate(2, new java.sql.Date(c.getFecha().getTime()));
        p.setInt(3, c.getFace());
        p.executeUpdate();
        cnn.close();
        p.close();
    }
 
    
    
 public static ListaMaestro buscarEmple(int id, ClassEvaluacion p) throws SQLException {
        Connection cnn = BD.getConnection();
        
        try {
            PreparedStatement ps = null;

            ps = cnn.prepareStatement("codigo = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                if (p == null) {
                    p = new ClassEvaluacion() {
                    };
                }
                /*p.setCODIGO(rs.getInt("CODIGO"));
                p.setNOMBRES(rs.getString("NOMBRES"));
                p.setAPELLIDOS(rs.getString("APELLIDOS"));
                p.setDepto(rs.getString("DEPTO"));
                p.setPUESTO(rs.getString("PUESTO"));*/
                cnn.close();
                ps.close();
                //return p;
          //  p.setId_Medida(rs.getInt("id_medida"));
                //p.setId_Presentacion(rs.getInt("id_presentacion"));     
            }

        } catch (Exception e) {
               System.err.println("errroooooorrr"+e);    
        }
        
        return null;

    }   
    
}
