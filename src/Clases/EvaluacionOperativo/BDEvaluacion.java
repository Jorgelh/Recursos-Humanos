/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases.EvaluacionOperativo;

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
public class BDEvaluacion {
    
    public static void insertarEvaluacion(ClassEvaluacionOperativo c) throws SQLException {
        
        Connection cnn = BD.getConnection();
        PreparedStatement p = null;
        p = cnn.prepareStatement("insert into BEVALUACION_DESEMPENO(ID_EVALUACION,ID_LISTAEMPLEADOS,FECHA,ESTADO,FACE,EVALUACION,TIPO,IMPRIME,DEPTO,EVALUADOPOR) values(id_evaluacion.nextval,?,?,1,?,?,1,1,?,?)");
        p.setInt(1, c.getId_listaempleados());
        p.setDate(2, new java.sql.Date(c.getFecha().getTime()));
        p.setInt(3, c.getFace());
        p.setInt(4, c.getNoEvaluacion());
        p.setInt(5, c.getDept());
        p.setInt(6, c.getEvalua());
        p.executeUpdate();
        cnn.close();
        p.close();
    }
 
    
    
public static ClassEvaluacionOperativo buscarEmpleado(int id) throws SQLException {
        return buscarEmple(id, null);
    }    
 public static ClassEvaluacionOperativo buscarEmple(int id,ClassEvaluacionOperativo p) throws SQLException {
        Connection cnn = BD.getConnection();
        
        try {
            PreparedStatement ps = null;
            ps = cnn.prepareStatement("select ID_LISTAEMPLEADOS,nombres,apellidos,puesto,decode(departamento,1,'INSPECCION',2,'TESTING',3,'CHIPS',4,'SOLDER DIP, STRIP & POTTING',5,'TRANSFORMADORES',6,'TALLER',7,'BODEGA',8,'ADMINISTRACION',9,'GERENCIA',10,'TECNOLOGIA DE LA INFORMACION/MANTENIMIENTO') as DEPTO,EVALUADOPOR from alistaempleados where codigo = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                if (p == null) {
                    p = new ClassEvaluacionOperativo(){
                    };
                }
                p.setId_listaempleados(rs.getInt("ID_LISTAEMPLEADOS"));
                p.setNombres(rs.getString("NOMBRES"));
                p.setApellidos(rs.getString("APELLIDOS"));
                p.setDepto(rs.getString("DEPTO"));
                p.setPuesto(rs.getString("PUESTO"));
                p.setEvalua(rs.getInt("EVALUADOPOR"));
                cnn.close();
                ps.close();
                return p;
            }

        } catch (Exception e) {
               System.err.println("errroooooorrr"+e);    
        }
        
        return null;

    }   
 
 public static ClassEvaluacionOperativo buscarEmpleadoID(int id) throws SQLException {
        return buscarEmpleID(id, null);
    }    
 public static ClassEvaluacionOperativo buscarEmpleID(int id,ClassEvaluacionOperativo p) throws SQLException {
        Connection cnn = BD.getConnection();
        try {
            PreparedStatement ps = null;
            ps = cnn.prepareStatement("select ID_LISTAEMPLEADOS,codigo,nombres,apellidos,puesto,decode(departamento,1,'INSPECCION',2,'TESTING',3,'CHIPS',4,'SOLDER DIP, STRIP & POTTING',5,'TRANSFORMADORES',6,'TALLER',7,'BODEGA',8,'ADMINISTRACION',9,'GERENCIA',10,'TECNOLOGIA DE LA INFORMACION/MANTENIMIENTO') as DEPTO from alistaempleados where id_listaempleados = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                if (p == null) {
                    p = new ClassEvaluacionOperativo(){
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
 
 public static ArrayList<ClassEvaluacionOperativo> ListarEvaluacionesPendientes(String a ,int depto) {
                   
        return SQL1("SELECT v.id_evaluacion,e.codigo,E.NOMBRES,E.APELLIDOS,decode(e.departamento,1,'INSPECCION',2,'TESTING',3,'CHIPS',4,'SOLDER DIP, STRIP & POTTING',5,'TRANSFORMADORES',6,'TALLER',7,'BODEGA',8,'ADMINISTRACION',9,'GERENCIA',10,'TECNOLOGIA DE LA INFORMACION/MANTENIMIENTO') as DEPTO,\n" +
"E.PUESTO,TO_CHAR(V.FECHA,'MON-DD-YYYY') as FECHA,v.evaluacion,decode(v.face,1,'FASE 1',2,'FASE 2',3,'FASE 3') as FASE \n" +
"FROM alistaempleados E INNER JOIN bevaluacion_desempeno V ON e.id_listaempleados = v.id_listaempleados where v.estado = 1 and v.tipo = 1 and v.depto = "+depto+" and upper(e.codigo) like upper('"+a+"%') order by e.codigo");
    }
 
 public static ArrayList<ClassEvaluacionOperativo> ListarEvaluacionesPendientesEvalua(String a ,int evalua) {
                   
        return SQL1("SELECT v.id_evaluacion,e.codigo,E.NOMBRES,E.APELLIDOS,decode(e.departamento,1,'INSPECCION',2,'TESTING',3,'CHIPS',4,'SOLDER DIP, STRIP & POTTING',5,'TRANSFORMADORES',6,'TALLER',7,'BODEGA',8,'ADMINISTRACION',9,'GERENCIA',10,'TECNOLOGIA DE LA INFORMACION/MANTENIMIENTO') as DEPTO,\n" +
"E.PUESTO,TO_CHAR(V.FECHA,'MON-DD-YYYY') as FECHA,v.evaluacion,decode(v.face,1,'FASE 1',2,'FASE 2',3,'FASE 3') as FASE \n" +
"FROM alistaempleados E INNER JOIN bevaluacion_desempeno V ON e.id_listaempleados = v.id_listaempleados where v.estado = 1 and v.tipo = 1 and v.evaluadopor = "+evalua+" and upper(e.codigo) like upper('"+a+"%') order by e.codigo");
    }
 
 public static ArrayList<ClassEvaluacionOperativo> ListarEvaluacionesTerminadas(String B,int evalua) {
                   
        return SQL1("SELECT v.id_evaluacion,e.codigo,E.NOMBRES,E.APELLIDOS,decode(e.departamento,1,'INSPECCION',2,'TESTING',3,'CHIPS',4,'SOLDER DIP, STRIP & POTTING',5,'TRANSFORMADORES',6,'TALLER',7,'BODEGA',8,'ADMINISTRACION',9,'GERENCIA',10,'TECNOLOGIA DE LA INFORMACION/MANTENIMIENTO') as DEPTO,\n" +
"E.PUESTO,TO_CHAR(V.FECHA,'MON-DD-YYYY') as FECHA,decode(v.face,1,'FASE 1',2,'FASE 2',3,'FASE 3') as FASE,v.evaluacion \n" +
"FROM alistaempleados E INNER JOIN bevaluacion_desempeno V ON e.id_listaempleados = v.id_listaempleados where v.estado = 2 and v.tipo = 1 and v.evaluadopor = "+evalua+" and upper(e.codigo) like upper('"+B+"%') order by v.id_evaluacion");
    }
 
 public static ArrayList<ClassEvaluacionOperativo> ListarEvaluacionesTerminadasEvalua(String B,int depto) {
                   
        return SQL1("SELECT v.id_evaluacion,e.codigo,E.NOMBRES,E.APELLIDOS,decode(e.departamento,1,'INSPECCION',2,'TESTING',3,'CHIPS',4,'SOLDER DIP, STRIP & POTTING',5,'TRANSFORMADORES',6,'TALLER',7,'BODEGA',8,'ADMINISTRACION',9,'GERENCIA',10,'TECNOLOGIA DE LA INFORMACION/MANTENIMIENTO') as DEPTO,\n" +
"E.PUESTO,TO_CHAR(V.FECHA,'MON-DD-YYYY') as FECHA,decode(v.face,1,'FASE 1',2,'FASE 2',3,'FASE 3') as FASE,v.evaluacion \n" +
"FROM alistaempleados E INNER JOIN bevaluacion_desempeno V ON e.id_listaempleados = v.id_listaempleados where v.estado = 2 and v.tipo = 1  and v.depto ="+depto+" and upper(e.codigo) like upper('"+B+"%') order by v.id_evaluacion");
    }
 
 
 
    private static ArrayList<ClassEvaluacionOperativo> SQL1(String sql){
    ArrayList<ClassEvaluacionOperativo> list = new ArrayList<ClassEvaluacionOperativo>();
    Connection cn = BD.getConnection();
        try {
            ClassEvaluacionOperativo b;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                 b = new ClassEvaluacionOperativo();
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
  
public static ClassEvaluacionOperativo buscarEmpleadoIDEvaluacion(int id) throws SQLException {
        return buscarEmpleIDeva(id, null);
    }    
 public static ClassEvaluacionOperativo buscarEmpleIDeva(int id,ClassEvaluacionOperativo p) throws SQLException {
        Connection cnn = BD.getConnection();
        try {
            PreparedStatement ps = null;
            ps = cnn.prepareStatement("SELECT v.id_listaempleados,v.id_evaluacion,e.codigo,E.NOMBRES,E.APELLIDOS,decode(e.departamento,1,'INSPECCION',2,'TESTING',3,'CHIPS',4,'SOLDER DIP, STRIP & POTTING',5,'TRANSFORMADORES',6,'TALLER',7,'BODEGA',8,'ADMINISTRACION',9,'GERENCIA',10,'TECNOLOGIA DE LA INFORMACION/MANTENIMIENTO') as DEPTO,E.PUESTO,TO_CHAR(V.FECHA,'MON-DD-YYYY') as fecha,v.face,decode(v.face,1,'FASE 1',2,'FASE 2',3,'FASE 3') as FASE, v.evaluacion FROM alistaempleados E INNER JOIN bevaluacion_desempeno V ON e.id_listaempleados = v.id_listaempleados\n" +
            "where v.id_evaluacion = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                if (p == null) {
                    p = new ClassEvaluacionOperativo(){
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
    
 
 public static void insertarTrabajoEnEquipo(ClassEvaluacionOperativo c) throws SQLException {
        
        Connection cnn = BD.getConnection();
        PreparedStatement p = null;
        p = cnn.prepareStatement("insert into DTRABAJO_EQUIPO values(IDTRABAJO_EQUIPO.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,1,1,?)");
        p.setInt(1, c.getId_evaluacion());
        p.setInt(2, c.getUNO());
        p.setInt(3, c.getDOS());
        p.setInt(4, c.getTRES());
        p.setInt(5, c.getCUATRO());
        p.setInt(6, c.getUNO1());
        p.setInt(7, c.getDOS1());
        p.setInt(8, c.getTRES1());
        p.setInt(9, c.getCUATRO1());
        p.setInt(10, c.getUNO2());
        p.setInt(11, c.getDOS2());
        p.setInt(12, c.getTRES2());
        p.setInt(13, c.getCUATRO2());
        p.setInt(14, c.getUNO3());
        p.setInt(15, c.getDOS3());
        p.setInt(16, c.getTRES3());
        p.setInt(17, c.getCUATRO3());
        p.setInt(18, c.getUNO4());
        p.setInt(19, c.getDOS4());
        p.setInt(20, c.getTRES4());
        p.setInt(21, c.getCUATRO4());
        p.setString(22,c.getNOTA());
        p.executeUpdate();
        cnn.close();
        p.close();
    }
 
 public static void insertarOrientacionResultados(ClassEvaluacionOperativo c) throws SQLException {
        
        Connection cnn = BD.getConnection();
        PreparedStatement p = null;
        p = cnn.prepareStatement("insert into BORIENTACION values(IDORIENTACION.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,1,1,?)");
        p.setInt(1, c.getId_evaluacion());
        p.setInt(2, c.getUNO());
        p.setInt(3, c.getDOS());
        p.setInt(4, c.getTRES());
        p.setInt(5, c.getCUATRO());
        p.setInt(6, c.getUNO1());
        p.setInt(7, c.getDOS1());
        p.setInt(8, c.getTRES1());
        p.setInt(9, c.getCUATRO1());
        p.setInt(10, c.getUNO2());
        p.setInt(11, c.getDOS2());
        p.setInt(12, c.getTRES2());
        p.setInt(13, c.getCUATRO2());
        p.setInt(14, c.getUNO3());
        p.setInt(15, c.getDOS3());
        p.setInt(16, c.getTRES3());
        p.setInt(17, c.getCUATRO3());
        p.setInt(18, c.getUNO4());
        p.setInt(19, c.getDOS4());
        p.setInt(20, c.getTRES4());
        p.setInt(21, c.getCUATRO4());
        p.setString(22, c.getNOTA());
        p.executeUpdate();
        cnn.close();
        p.close();
    }
 
 
 public static void insertarOrganizacion(ClassEvaluacionOperativo c) throws SQLException {
        
        Connection cnn = BD.getConnection();
        PreparedStatement p = null;
        p = cnn.prepareStatement("insert into EORGANIZACION values(IDORGANIZACION.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,1,1,?)");
        p.setInt(1, c.getId_evaluacion());
        p.setInt(2, c.getUNO());
        p.setInt(3, c.getDOS());
        p.setInt(4, c.getTRES());
        p.setInt(5, c.getCUATRO());
        p.setInt(6, c.getUNO1());
        p.setInt(7, c.getDOS1());
        p.setInt(8, c.getTRES1());
        p.setInt(9, c.getCUATRO1());
        p.setInt(10, c.getUNO2());
        p.setInt(11, c.getDOS2());
        p.setInt(12, c.getTRES2());
        p.setInt(13, c.getCUATRO2());
        p.setInt(14, c.getUNO3());
        p.setInt(15, c.getDOS3());
        p.setInt(16, c.getTRES3());
        p.setInt(17, c.getCUATRO3());
        p.setInt(18, c.getUNO4());
        p.setInt(19, c.getDOS4());
        p.setInt(20, c.getTRES4());
        p.setInt(21, c.getCUATRO4());
        p.setString(22, c.getNOTA());
        p.executeUpdate();
        cnn.close();
        p.close();
    }
 
 public static void insertarResponsabilidad(ClassEvaluacionOperativo c) throws SQLException {
        
        Connection cnn = BD.getConnection();
        PreparedStatement p = null;
        p = cnn.prepareStatement("insert into GRESPONSABILIDAD values(IDRESPONSABILIDAD.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,1,1,?)");
        p.setInt(1, c.getId_evaluacion());
        p.setInt(2, c.getUNO());
        p.setInt(3, c.getDOS());
        p.setInt(4, c.getTRES());
        p.setInt(5, c.getCUATRO());
        p.setInt(6, c.getUNO1());
        p.setInt(7, c.getDOS1());
        p.setInt(8, c.getTRES1());
        p.setInt(9, c.getCUATRO1());
        p.setInt(10, c.getUNO2());
        p.setInt(11, c.getDOS2());
        p.setInt(12, c.getTRES2());
        p.setInt(13, c.getCUATRO2());
        p.setInt(14, c.getUNO3());
        p.setInt(15, c.getDOS3());
        p.setInt(16, c.getTRES3());
        p.setInt(17, c.getCUATRO3());
        p.setInt(18, c.getUNO4());
        p.setInt(19, c.getDOS4());
        p.setInt(20, c.getTRES4());
        p.setInt(21, c.getCUATRO4());
        p.setString(22, c.getNOTA());
        p.executeUpdate();
        cnn.close();
        p.close();
    }




public static ArrayList<ClassEvaluacionOperativo> ListarEvaluacionesImprimir(String B,int depto) {
                   
        return IMPRE("SELECT v.id_evaluacion,e.codigo,E.NOMBRES,E.APELLIDOS,decode(e.departamento,1,'INSPECCION',2,'TESTING',3,'CHIPS',4,'SOLDER DIP, STRIP & POTTING',5,'TRANSFORMADORES',6,'TALLER',7,'BODEGA',8,'ADMINISTRACION',9,'GERENCIA',10,'TECNOLOGIA DE LA INFORMACION/MANTENIMIENTO') as DEPTO,\n" +
"E.PUESTO,TO_CHAR(V.FECHA,'dd/mm/yy') as FECHA,decode(v.face,1,'FASE 1',2,'FASE 2',3,'FASE 3') as FASE,v.evaluacion \n" +
"FROM alistaempleados E INNER JOIN bevaluacion_desempeno V ON e.id_listaempleados = v.id_listaempleados where v.estado = 2 and e.departamento = "+depto+" and upper(e.codigo) like upper('"+B+"%') order by v.id_evaluacion");
    }
    private static ArrayList<ClassEvaluacionOperativo> IMPRE(String sql){
    ArrayList<ClassEvaluacionOperativo> list = new ArrayList<ClassEvaluacionOperativo>();
    Connection cn = BD.getConnection();
        try {
            ClassEvaluacionOperativo b;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                 b = new ClassEvaluacionOperativo();
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

}