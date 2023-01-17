/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BDreloj;

import BD.BD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author jluis
 */
public class QuerysReloj {
    
    
    
    public static ArrayList<ClassReloj> ListarFaltasEmpleados(String a) {
        return SQL2("select codigo,nombres,decode(departamento,1,'INSPECCION',2,'TESTING',3,'CHIPS',4,'STRIP Y POTTING',5,'TRANSFORMADORES',6,'TALLER',7,'BODEGA',8,'ADMINISTRACION',9,'GERENCIA',10,'TECNOLOGIA DE LA INFORMACIO / MANTENIMIENTO',11,'MOLDING') as departamento from alistaempleados where estado = 1 and marcaje = 1 and codigo not in (select codigo from reloj where to_date(fecha,'dd/mm/yy') = to_date('"+a+"','dd/mm/yy')) ORDER BY departamento");
    }
    private static ArrayList<ClassReloj> SQL2(String sql){
    ArrayList<ClassReloj> list = new ArrayList<ClassReloj>();
    Connection cn = BD.getConnection();
        try {
            ClassReloj t;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                 t = new ClassReloj();
                 t.setCodigo(rs.getInt("CODIGO"));
                 t.setNombre(rs.getString("NOMBRES"));
                 t.setDepartamento(rs.getString("DEPARTAMENTO"));
                 list.add(t);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("error consulta "+e);
            return null;
        } 
        return list;

    }
    

 public static ArrayList<ClassReloj> ListarAsistenciaEmpleados(String a,String b) {
        return SQL("select e.codigo,e.nombres,TO_char(r.fecha,'dd/mm/yyyy') as FECHA,TO_char(r.ingreso,'HH24:mi:ss') as \"HORAIN\" ,TO_char(r.SALIDA,'HH24:mi:ss') as \"HORAOUT\",decode(departamento,1,'INSPECCION',2,'TESTING',3,'CHIPS',4,'STRIP Y POTTING',5,'TRANSFORMADORES',6,'TALLER',7,'BODEGA',8,'ADMINISTRACION',9,'GERENCIA',10,'TECNOLOGIA DE LA INFORMACIO / MANTENIMIENTO',11,'MOLDING') as departamento,"
                + "decode(estadoasistencia,1,'SIN MARCAJE DE ENTRADA',2,'OLVIDO CARNET DE MARCAJE',3,'NO SE PRESENTO',4,'FALTA CON PERMISO',5,'SUSPENDIDO',6,'SUSPENDIDO POR IGSS',7,'REGRESADO POR LLEGAR TARDE') as NOTA  \n" +
"from alistaempleados e inner join reloj r on e.codigo = r.codigo where e.marcaje = 1 and r.codigo in(select codigo from reloj where  to_date(r.fecha,'dd/mm/yy') = to_date('"+a+"','dd/mm/yy') and upper(codigo) like upper('"+b+"%'))  ORDER BY e.departamento");
    }                                                                            //upper(producto.descripcion) like upper('" + d + "%')"                                        
  public static ArrayList<ClassReloj> ListarAsistenciaPermisos(String a) {
        return SQL("select e.codigo,e.nombres,TO_char(r.fecha,'dd/mm/yyyy') as FECHA,TO_char(r.ingreso,'HH24:mi:ss') as \"HORAIN\" ,TO_char(r.SALIDA,'HH24:mi:ss') as \"HORAOUT\",decode(departamento,1,'INSPECCION',2,'TESTING',3,'CHIPS',4,'STRIP Y POTTING',5,'TRANSFORMADORES',6,'TALLER',7,'BODEGA',8,'ADMINISTRACION',9,'GERENCIA',10,'TECNOLOGIA DE LA INFORMACIO / MANTENIMIENTO',11,'MOLDING') as departamento,'' AS NOTA  \n" +
"from alistaempleados e inner join reloj r on e.codigo = r.codigo where e.marcaje = 1 and r.codigo in(select codigo from reloj where  to_date(r.fecha,'dd/mm/yy') = to_date('"+a+"','dd/mm/yy') and horas < 9 ) and to_date(r.ingreso,'dd/mm/yy') = to_date('"+a+"','dd/mm/yy') and r.horas < 9  ORDER BY e.departamento");
    }
    private static ArrayList<ClassReloj> SQL(String sql){
    ArrayList<ClassReloj> list = new ArrayList<ClassReloj>();
    Connection cn = BD.getConnection();
        try {
            ClassReloj t;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                 t = new ClassReloj();
                 t.setCodigo(rs.getInt("CODIGO"));
                 t.setNombre(rs.getString("NOMBRES"));
                 t.setFecha(rs.getString("FECHA"));
                 t.setHorain(rs.getString("HORAIN"));
                 t.setHoraout(rs.getString("HORAOUT"));
                 t.setDepartamento(rs.getString("DEPARTAMENTO"));
                 t.setNota(rs.getString("NOTA"));
                 list.add(t);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("error consulta "+e);
            return null;
        } 
        return list;

    }   
    
    
    
    public static ArrayList<ClassReloj> ListarHorasExtrasDia(String a) {
        return DIA("select a.codigo,a.nombres,to_char(r.fecha,'DD/MM/yy') as FECHA ,to_char(r.ingreso,'hh24:mi:ss') as HORAINGRESO ,to_char(r.salida ,'hh24:mi:ss')as HORASALIDA,lpad(Horas,2,0)||':'||lpad(Minutos,2,0) as HORASLABORADAS,\n" +
"lpad(HoraExtra,2,0)||':'||lpad(MINUTOEXTRA,2,0) as HORASEXTRAS\n" +
"from alistaempleados a inner join  reloj r on a.codigo = r.codigo where TO_DATE(r.fecha,'DD/MM/YY') = to_date( '"+a+"' ,'dd/mm/yy') and estadoextras = 2");
    }
    private static ArrayList<ClassReloj> DIA(String sql){
    ArrayList<ClassReloj> list = new ArrayList<ClassReloj>();
    Connection cn = BD.getConnection();
        try {
            ClassReloj t;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                 t = new ClassReloj();
                 t.setCodigo(rs.getInt("CODIGO"));
                 t.setNombre(rs.getString("NOMBRES"));
                 t.setFecha(rs.getString("FECHA"));
                 t.setHorain(rs.getString("HORAINGRESO"));
                 t.setHoraout(rs.getString("HORASALIDA"));
                 t.setHorasLaboradas(rs.getString("HORASLABORADAS"));
                 t.setHorasExtras(rs.getString("HORASEXTRAS"));
                 list.add(t);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("error consulta "+e);
            return null;
        } 
        return list;

    }   
    
    
     
    public static ArrayList<ClassReloj> ListarHorasCodigo(int a,String f1,String f2) {
        return CODIGO("select a.codigo,a.nombres,to_char(r.fecha,'mm/dd/yy') as FECHA ,to_char(r.ingreso,'hh24:mi:ss') as HORAINGRESO ,to_char(r.salida ,'hh24:mi:ss')as HORASALIDA,lpad(Horas,2,0)||':'||lpad(Minutos,2,0) as HORASLABORADAS,\n" +
"lpad(HoraExtra,2,0)||':'||lpad(MINUTOEXTRA,2,0) as HORASEXTRAS\n" +
"from alistaempleados a inner join  reloj r on a.codigo = r.codigo where a.codigo = "+a+"  and r.fecha between to_date('"+f1+"','dd/mm/yy') and to_date('"+f2+"','dd/mm/yy') order by to_date(r.fecha,'dd/mm/yy'),r.id_reloj");
    }
    private static ArrayList<ClassReloj> CODIGO(String sql){
    ArrayList<ClassReloj> list = new ArrayList<ClassReloj>();
    Connection cn = BD.getConnection();
        try {
            ClassReloj t;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                 t = new ClassReloj();
                 t.setCodigo(rs.getInt("CODIGO"));
                 t.setNombre(rs.getString("NOMBRES"));
                 t.setFecha(rs.getString("FECHA"));
                 t.setHorain(rs.getString("HORAINGRESO"));
                 t.setHoraout(rs.getString("HORASALIDA"));
                 t.setHorasLaboradas(rs.getString("HORASLABORADAS"));
                 t.setHorasExtras(rs.getString("HORASEXTRAS"));
                 list.add(t);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("error consulta "+e);
            return null;
        } 
        return list;
    }   
    



public static ArrayList<ClassReloj> ListarHorasExtrasMes(String a,String b) {
        return MES("select a.codigo,a.nombres,sum(horaextra)+(round(sum(minutoextra)/60,2)) TOTALHORAS\n" +
"from alistaempleados a inner join  reloj r on a.codigo = r.codigo where r.fecha between to_date('"+a+"','dd/mm/yy') and to_date('"+b+"','dd/mm/yy') GROUP BY a.codigo,a.nombres");
    }
    private static ArrayList<ClassReloj> MES(String sql){
    ArrayList<ClassReloj> list = new ArrayList<ClassReloj>();
    Connection cn = BD.getConnection();
        try {
            ClassReloj t;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                 t = new ClassReloj();
                 t.setCodigo(rs.getInt("CODIGO"));
                 t.setNombre(rs.getString("NOMBRES"));
                 t.setHorasExtras(rs.getString("TOTALHORAS"));
                 list.add(t);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("error consulta "+e);
            return null;
        } 
        return list;

    }
    
public static void IngresoEspecialSinMarcajeEntrada(ClassReloj c) throws SQLException {
        
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("insert into RELOJ(ID_RELOJ,CODIGO,FECHA,INGRESO,ESTADO) VALUES(ID_RELOJ.NEXTVAL,?,SYSDATE,TO_DATE(TRUNC(sysdate),'dd/mm/yy hh24:mi')+06.00/24,1)");
        ps.setInt(1, c.getCodigo());
        ps.execute();
        cnn.close();
        ps.close();
    }

public static void IngresoDatosRelojingresoEspecial(ClassReloj c) throws SQLException {
        
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("insert into RELOJ(ID_RELOJ,CODIGO,FECHA,ESTADO,ESTADOASISTENCIA) VALUES(ID_RELOJ.NEXTVAL,?,SYSDATE,1,?)");
        ps.setInt(1, c.getCodigo());
        ps.setInt(2, c.getEstadoIngresoEspecial());
        ps.execute();
        cnn.close();
        ps.close();
    }      
    
    
  
}