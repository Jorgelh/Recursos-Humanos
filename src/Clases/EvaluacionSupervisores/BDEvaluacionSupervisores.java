/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases.EvaluacionSupervisores;

import Clases.EvaluacionOperativo.*;
import BD.BD;
import Clases.empleados.ListaMaestro;
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
public class BDEvaluacionSupervisores {
    
    public static void insertarEvaluacion(ClassEvaluacionSupervisores c) throws SQLException {
        
        Connection cnn = BD.getConnection();
        PreparedStatement p = null;
        p = cnn.prepareStatement("insert into BEVALUACION_DESEMPENO values(id_evaluacion.nextval,?,?,1,?,?)");
        p.setInt(1, c.getId_listaempleados());
        p.setDate(2, new java.sql.Date(c.getFecha().getTime()));
        p.setInt(3, c.getFace());
        p.setInt(4, c.getNoEvaluacion());
        p.executeUpdate();
        cnn.close();
        p.close();
    }
 
    
    
public static ClassEvaluacionSupervisores buscarEmpleado(int id) throws SQLException {
        return buscarEmple(id, null);
    }    
 public static ClassEvaluacionSupervisores buscarEmple(int id,ClassEvaluacionSupervisores p) throws SQLException {
        Connection cnn = BD.getConnection();
        
        try {
            PreparedStatement ps = null;
            ps = cnn.prepareStatement("select ID_LISTAEMPLEADOS,nombres,apellidos,puesto,decode(departamento,1,'INSPECCION',2,'TESTING',3,'CHIPS',4,'STRIP Y POTTING',5,'TRANSFORMADORES',6,'TALLER',7,'BODEGA',8,'ADMINISTRACION','GERENCIA',9) as DEPTO from alistaempleados where codigo = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                if (p == null) {
                    p = new ClassEvaluacionSupervisores(){
                    };
                }
                p.setId_listaempleados(rs.getInt("ID_LISTAEMPLEADOS"));
                p.setNombres(rs.getString("NOMBRES"));
                p.setApellidos(rs.getString("APELLIDOS"));
                p.setDepto(rs.getString("DEPTO"));
                p.setPuesto(rs.getString("PUESTO"));
                cnn.close();
                ps.close();
                return p;
            }

        } catch (Exception e) {
               System.err.println("errroooooorrr"+e);    
        }
        
        return null;

    }   
 
 public static ClassEvaluacionSupervisores buscarEmpleadoID(int id) throws SQLException {
        return buscarEmpleID(id, null);
    }    
 public static ClassEvaluacionSupervisores buscarEmpleID(int id,ClassEvaluacionSupervisores p) throws SQLException {
        Connection cnn = BD.getConnection();
        try {
            PreparedStatement ps = null;
            ps = cnn.prepareStatement("select ID_LISTAEMPLEADOS,codigo,nombres,apellidos,puesto,decode(departamento,1,'INSPECCION',2,'TESTING',3,'CHIPS',4,'STRIP Y POTTING',5,'TRANSFORMADORES',6,'TALLER',7,'BODEGA',8,'ADMINISTRACION','GERENCIA',9) as DEPTO from alistaempleados where id_listaempleados = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                if (p == null) {
                    p = new ClassEvaluacionSupervisores(){
                    };
                }
                p.setCodigo(rs.getInt("CODIGO"));
                p.setId_listaempleados(rs.getInt("ID_LISTAEMPLEADOS"));
                p.setNombres(rs.getString("NOMBRES"));
                p.setApellidos(rs.getString("APELLIDOS"));
                p.setDepto(rs.getString("DEPTO"));
                p.setPuesto(rs.getString("PUESTO"));
                cnn.close();
                ps.close();
                return p;
            }
        } catch (Exception e) {
               System.err.println("errroooooorrr"+e);    
        }
        return null;
    }   
 
 public static ArrayList<ClassEvaluacionSupervisores> ListarEvaluacionesPendientes(String a ,int depto) {
                   
        return SQL1("SELECT v.id_evaluacion,e.codigo,E.NOMBRES,E.APELLIDOS,decode(e.departamento,1,'INSPECCION',2,'TESTING',3,'CHIPS',4,'STRIP Y POTTING',5,'TRANSFORMADORES',6,'TALLER',7,'BODEGA',8,'ADMINISTRACION',9,'GERENCIA') as DEPTO,\n" +
"E.PUESTO,TO_CHAR(V.FECHA,'dd/mm/yy') as FECHA,v.evaluacion,decode(v.face,1,'FASE 1',2,'FASE 2',3,'FASE 3') as FASE \n" +
"FROM alistaempleados E INNER JOIN bevaluacion_desempeno V ON e.id_listaempleados = v.id_listaempleados where v.estado = 1 and e.departamento = "+depto+" and upper(e.codigo) like upper('"+a+"%')");
    }
 
 public static ArrayList<ClassEvaluacionSupervisores> ListarEvaluacionesTerminadas(String B,int depto) {
                   
        return SQL1("SELECT v.id_evaluacion,e.codigo,E.NOMBRES,E.APELLIDOS,decode(e.departamento,1,'INSPECCION',2,'TESTING',3,'CHIPS',4,'STRIP Y POTTING',5,'TRANSFORMADORES',6,'TALLER',7,'BODEGA',8,'ADMINISTRACION','GERENCIA',9) as DEPTO,\n" +
"E.PUESTO,TO_CHAR(V.FECHA,'dd/mm/yy') as FECHA,decode(v.face,1,'FASE 1',2,'FASE 2',3,'FASE 3') as FASE,v.evaluacion \n" +
"FROM alistaempleados E INNER JOIN bevaluacion_desempeno V ON e.id_listaempleados = v.id_listaempleados where v.estado = 2 and e.departamento = "+depto+" and upper(e.codigo) like upper('"+B+"%') order by v.id_evaluacion");
    }
    private static ArrayList<ClassEvaluacionSupervisores> SQL1(String sql){
    ArrayList<ClassEvaluacionSupervisores> list = new ArrayList<ClassEvaluacionSupervisores>();
    Connection cn = BD.getConnection();
        try {
            ClassEvaluacionSupervisores b;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                 b = new ClassEvaluacionSupervisores();
                 b.setId_evaluacion(rs.getInt("id_evaluacion"));
                 b.setCodigo(rs.getInt("codigo"));
                 b.setNombres(rs.getString("nombres"));
                 b.setApellidos(rs.getString("apellidos"));
                 b.setDepto(rs.getString("depto"));
                 b.setPuesto(rs.getString("puesto"));
                 b.setFechaS(rs.getString("FECHA"));
                 b.setFaceS(rs.getString("FASE"));
                 b.setNoEvaluacion(rs.getInt("evaluacion"));
                 list.add(b);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } 
        return list;
}
  
public static ClassEvaluacionSupervisores buscarEmpleadoIDEvaluacion(int id) throws SQLException {
        return buscarEmpleIDeva(id, null);
    }    
 public static ClassEvaluacionSupervisores buscarEmpleIDeva(int id,ClassEvaluacionSupervisores p) throws SQLException {
        Connection cnn = BD.getConnection();
        try {
            PreparedStatement ps = null;
            ps = cnn.prepareStatement("SELECT v.id_listaempleados,v.id_evaluacion,e.codigo,E.NOMBRES,E.APELLIDOS,decode(e.departamento,1,'INSPECCION',2,'TESTING',3,'CHIPS',4,'STRIP Y POTTING',5,'TRANSFORMADORES',6,'TALLER',7,'BODEGA',8,'ADMINISTRACION','GERENCIA',9) as DEPTO,E.PUESTO,to_char(V.FECHA,'dd/mm/yy') as fecha,v.face,decode(v.face,1,'FASE 1',2,'FASE 2',3,'FASE 3') as FASE, v.evaluacion FROM alistaempleados E INNER JOIN bevaluacion_desempeno V ON e.id_listaempleados = v.id_listaempleados\n" +
            "where v.id_evaluacion = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                if (p == null) {
                    p = new ClassEvaluacionSupervisores(){
                    };
                }
                p.setCodigo(rs.getInt("CODIGO"));
                p.setId_evaluacion(rs.getInt("ID_EVALUACION"));
                p.setNombres(rs.getString("NOMBRES"));
                p.setApellidos(rs.getString("APELLIDOS"));
                p.setDepto(rs.getString("DEPTO"));
                p.setPuesto(rs.getString("PUESTO"));
                p.setFechaS(rs.getString("FECHA"));
                p.setFaceS(rs.getString("FASE"));
                p.setFace(rs.getInt("face"));
                p.setNoEvaluacion(rs.getInt("evaluacion"));
                p.setId_listaempleados(rs.getInt("id_listaempleados"));
                cnn.close();
                ps.close();
                return p;
            }
        } catch (Exception e) {
               System.err.println("errroooooorrr"+e);    
        }
        return null;
    }       
    
 
 
}