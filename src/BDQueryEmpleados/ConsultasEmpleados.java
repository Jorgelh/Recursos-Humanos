/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BDQueryEmpleados;

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
public class ConsultasEmpleados {
    
    
    public static ArrayList<ListaMaestro> ListarEmpleados(String codigo, String nombre) {
    return SQLtrabajos("select codigo,nombres,puesto,decode(departamento,1,'INSPECCION',2,'TESTING',3,'CHIPS',4,'STRIP Y POTTING',5,'TRANSFORMADORES',6,'TALLER',7,'BODEGA',8,'ADMINISTRACION',9,'GERENCIA',10,'TECNOLOGIA DE LA INFORMACIO / MANTENIMIENTO') as departamento from alistaempleados where  UPPER(codigo) LIKE UPPER('"+codigo+"%') and UPPER(nombres) LIKE UPPER('"+nombre+"%') and estado = 1");
    }
    
    private static ArrayList<ListaMaestro> SQLtrabajos(String sql1){
    ArrayList<ListaMaestro> list = new ArrayList<ListaMaestro>();
    Connection cn = BD.getConnection();
        try {
            ListaMaestro t;
            Statement stmt = cn.createStatement();
            ResultSet r = stmt.executeQuery(sql1);
            while (r.next()){
                 t = new ListaMaestro();
                 t.setCODIGO(r.getInt("codigo"));
                 t.setNOMBRES(r.getString("nombres"));
                 t.setPUESTO(r.getString("puesto"));
                 t.setDepto(r.getString("departamento"));
                 list.add(t);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("error consulta"+e);
            return null;
        } 
        return list;
}
    
public static ArrayList<ListaMaestro> ListarEmpleadosdeBaja(String codigo, String nombre) {
    return SQLempleadosbaja("select codigo,nombres,puesto,decode(departamento,1,'INSPECCION',2,'TESTING',3,'CHIPS',4,'STRIP Y POTTING',5,'TRANSFORMADORES',6,'TALLER',7,'BODEGA',8,'ADMINISTRACION',9,'GERENCIA',10,'TECNOLOGIA DE LA INFORMACIO / MANTENIMIENTO') as departamento from alistaempleados where  UPPER(codigo) LIKE UPPER('"+codigo+"%') and UPPER(nombres) LIKE UPPER('"+nombre+"%') and estado = 2");
    }
    
    private static ArrayList<ListaMaestro> SQLempleadosbaja(String sql1){
    ArrayList<ListaMaestro> list = new ArrayList<ListaMaestro>();
    Connection cn = BD.getConnection();
        try {
            ListaMaestro t;
            Statement stmt = cn.createStatement();
            ResultSet r = stmt.executeQuery(sql1);
            while (r.next()){
                 t = new ListaMaestro();
                 t.setCODIGO(r.getInt("codigo"));
                 t.setNOMBRES(r.getString("nombres"));
                 t.setPUESTO(r.getString("puesto"));
                 t.setDepto(r.getString("departamento"));
                 list.add(t);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("error consulta"+e);
            return null;
        } 
        return list;
}    
    
    
    
    
    
     public static ListaMaestro buscarEmpleado(int id) throws SQLException {
        return buscarEmple(id, null);
    }

    public static ListaMaestro buscarEmple(int id, ListaMaestro p) throws SQLException {
        Connection cnn = BD.getConnection();
        
        try {
            PreparedStatement ps = null;

            ps = cnn.prepareStatement("select id_listaempleados,CODIGO,NOMBRES,APELLIDOS,to_char(F_NACIMIENTO,'dd/mm/yy') as F_NACIMIENTO,DPI,DPIEXTENDIDO,DIRECCION,NIT,TELEFONO,T_SANGRE,CORREO_ELECTRO,ESTUDIOS_ULTIMOS,IGSS,IRTRA,ESTADO_CIVIL,SEXO,CUENTA_BANCO,DECODE(DEPARTAMENTO,1,'INSPECCION',2,'TESTING',3,'CHIPS',4,'STRIP Y POTTING',5,'TRANSFORMADORES',6,'TALLER',7,'BODEGA',8,'ADMINISTRACION',9,'GERENCIA',10,'TECNOLOGIA DE LA INFORMACION/MATENIMIENTO') AS DEPTO,PUESTO,to_char(FECHA_INGRESO,'dd/mm/yy') as FECHA_INGRESO,ORDINARIO,BONIFICACION,DISCAPACIDAD,TIPODISCA,NIVELACADEMICO,EVALUADOPOR FROM alistaempleados  where codigo = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                if (p == null) {
                    p = new ListaMaestro() {
                    };
                }
                p.setID_LISTAEMPLEADOS(rs.getInt("id_listaempleados"));
                p.setCODIGO(rs.getInt("CODIGO"));
                p.setNOMBRES(rs.getString("NOMBRES"));
                p.setAPELLIDOS(rs.getString("APELLIDOS"));
                p.setF_nacimiento(rs.getString("F_NACIMIENTO"));
                p.setDPI(rs.getString("DPI"));
                p.setDPIEXTENDIDO(rs.getString("DPIEXTENDIDO"));
                p.setDIRECCION(rs.getString("DIRECCION"));
                p.setNIT(rs.getString("NIT"));
                p.setTELEFONO(rs.getString("TELEFONO"));
                p.setT_SANGRE(rs.getString("T_SANGRE"));
                p.setCORREO_ELECTRO(rs.getString("CORREO_ELECTRO"));
                p.setESTUDIOS_ULTIMOS(rs.getString("ESTUDIOS_ULTIMOS"));
                p.setIGSS(rs.getString("IGSS"));
                p.setIRTRA(rs.getString("IRTRA"));
                p.setESTADO_CIVIL(rs.getString("ESTADO_CIVIL"));
                p.setSEXO(rs.getString("SEXO"));
                p.setCUENTA_BANCO(rs.getString("CUENTA_BANCO"));
                p.setDepto(rs.getString("DEPTO"));
                p.setPUESTO(rs.getString("PUESTO"));
                p.setF_ingreso(rs.getString("FECHA_INGRESO"));
                p.setORDINARIO(rs.getDouble("ORDINARIO"));
                p.setBONIFICACION(rs.getDouble("BONIFICACION"));
                p.setDiscapacidad(rs.getInt("DISCAPACIDAD"));
                p.setTipoDiscapa(rs.getString("TIPODISCA"));
                p.setNivelAcademico(rs.getString("NIVELACADEMICO"));
                p.setEvaluadopor(rs.getInt("EVALUADOPOR"));
                cnn.close();
                ps.close();
                return p;
          //  p.setId_Medida(rs.getInt("id_medida"));
                //p.setId_Presentacion(rs.getInt("id_presentacion"));     
            }

        } catch (Exception e) {
               System.err.println("errroooooorrr"+e);    
        }
        
        return null;

    }
    


}
