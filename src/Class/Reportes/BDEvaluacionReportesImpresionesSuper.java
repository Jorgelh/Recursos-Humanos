/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class.Reportes;

import Clases.EvaluacionSupervisores.ClassEvaluacionSupervisores.*;
import BD.BD;
import Clases.EvaluacionSupervisores.ClassEvaluacionSupervisores;
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
public class BDEvaluacionReportesImpresionesSuper {
    


public static ArrayList<ClassEvaluacionSupervisores> ListarEvaluacionesImprimir(String B,int depto,String a,String c) {
                   
        return IMPRE("SELECT v.id_evaluacion,e.codigo,E.NOMBRES,E.APELLIDOS,decode(e.departamento,1,'INSPECCION',2,'TESTING',3,'CHIPS',4,'STRIP Y POTTING',5,'TRANSFORMADORES',6,'TALLER',7,'BODEGA',8,'ADMINISTRACION',9,'GERENCIA',10,'TECNOLOGIA DE LA INFORMACION/MANTENIMIENTO') as DEPTO,\n" +
"E.PUESTO,TO_CHAR(V.FECHA,'dd/mm/yy') as FECHA,decode(v.face,1,'FASE 1',2,'FASE 2',3,'FASE 3') as FASE,v.evaluacion \n" +
"FROM alistaempleados E INNER JOIN bevaluacion_desempeno V ON e.id_listaempleados = v.id_listaempleados where v.estado = 2 and tipo = 2 and upper(e.codigo) like upper('"+B+"%') and upper(v.face) like upper('"+a+"%') and upper(v.evaluacion) like upper('"+c+"%') and imprime = 2 order by v.id_evaluacion");
    }

public static ArrayList<ClassEvaluacionSupervisores> ListarEvaluacionesNoImprimir(String B,int depto,String a,String c) {
                   
        return IMPRE("SELECT v.id_evaluacion,e.codigo,E.NOMBRES,E.APELLIDOS,decode(e.departamento,1,'INSPECCION',2,'TESTING',3,'CHIPS',4,'STRIP Y POTTING',5,'TRANSFORMADORES',6,'TALLER',7,'BODEGA',8,'ADMINISTRACION',9,'GERENCIA',10,'TECNOLOGIA DE LA INFORMACION/MANTENIMIENTO') as DEPTO,\n" +
"E.PUESTO,TO_CHAR(V.FECHA,'dd/mm/yy') as FECHA,decode(v.face,1,'FASE 1',2,'FASE 2',3,'FASE 3') as FASE,v.evaluacion \n" +
"FROM alistaempleados E INNER JOIN bevaluacion_desempeno V ON e.id_listaempleados = v.id_listaempleados where v.estado = 2 and tipo = 2 and upper(e.codigo) like upper('"+B+"%') and upper(v.face) like upper('"+a+"%') and upper(v.evaluacion) like upper('"+c+"%') and imprime = 1 order by v.id_evaluacion");
    }
    private static ArrayList<ClassEvaluacionSupervisores> IMPRE(String sql){
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

}