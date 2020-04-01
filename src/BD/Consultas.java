/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Clases.empleados.Empleados;
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
public class Consultas {
    
    public static ArrayList<Empleados> ListarEmpleadosCodigo(String f) {

         //return consultanombreSQL("select codigo,nombre,puesto from empleados where upper(puesto) like upper('"+f+"%')");
         return consultanombreSQL("select codigo,nombre,puesto from empleados where  codigo in("+f+") AND ESTADO = 1");
    }
    
    public static ArrayList<Empleados> ListarEmpleadosDepto( int d) {

         //return consultanombreSQL("select codigo,nombre,puesto from empleados where upper(puesto) like upper('"+f+"%')");
         return consultanombreSQL("select codigo,nombre,puesto from empleados where   id_depto = "+d+" AND ESTADO = 1");
    }
    
    public static ArrayList<Empleados> ListarEmpleadosNombre(String f) {

         //return consultanombreSQL("select codigo,nombre,puesto from empleados where upper(puesto) like upper('"+f+"%')");
         return consultanombreSQL("select codigo,nombre,puesto from empleados where  upper(NOMBRE) like upper('"+f+"%') AND ESTADO = 1");
    }
    
     public static ArrayList<Empleados> ListarEmpleadosAgregados() {

         //return consultanombreSQL("select codigo,nombre,puesto from empleados where upper(puesto) like upper('"+f+"%')");
         return consultanombreSQL("select codigo,nombre,puesto from empleados where ESTADO = 2");
    }
    
    
    private static ArrayList<Empleados> consultanombreSQL(String sql) {
        ArrayList<Empleados> list = new ArrayList<Empleados>();
        Connection cn = BD.getConnection();
        try {
            Empleados c;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                c = new Empleados();
                c.setCodigo(rs.getInt("codigo"));
                c.setNombre(rs.getString("nombre")); 
                c.setPuesto(rs.getString("puesto"));
                list.add(c);
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error Consulta producto por nombre " + e);
            return null;
        }
        return list;
    }

  public static boolean agregaralista(Empleados f) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("update empleados set estado=2 where codigo=" + f.getCodigo());
        //ps.setInt(1, f.getCodigo());
        int rowsUpdated = ps.executeUpdate();
        cnn.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }   
  
  public static boolean Eliminarlista(Empleados f) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("update empleados set estado=1 where codigo=" + f.getCodigo());
        //ps.setInt(1, f.getCodigo());
        int rowsUpdated = ps.executeUpdate();
        cnn.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }   
    
  public static boolean agregardepto(Empleados f) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("update empleados set estado=2 where id_depto=" + f.getDepto());
        //ps.setInt(1, f.getCodigo());
        int rowsUpdated = ps.executeUpdate();
        cnn.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }       
  
  public static boolean eleminartododelista(Empleados f) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("update empleados set estado=?");
        ps.setInt(1, f.getEstado());
        int rowsUpdated = ps.executeUpdate();
        cnn.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }      
  
  public static boolean agregartodoalista(Empleados f) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("update empleados set estado=?");
        ps.setInt(1, f.getEstado());
        int rowsUpdated = ps.executeUpdate();
        cnn.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }      
  
    
}
