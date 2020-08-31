/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases.EvaluacionSupervisores;

import BD.BD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author jluis
 */
public class InsertarEvaluacionSupervisores {
    
   // 1/
    public static void insertarPlanificacion(ClassEvaluacionSupervisores c) throws SQLException {
        
        Connection cnn = BD.getConnection();
        PreparedStatement p = null;
        p = cnn.prepareStatement("insert into aplanificacion values(IDPLANIFICACION.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,1,2,?)");
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
 //2
 public static void insertarOrientacionResultados(ClassEvaluacionSupervisores c) throws SQLException {
        
        Connection cnn = BD.getConnection();
        PreparedStatement p = null;
        p = cnn.prepareStatement("insert into borientacion values(IDORIENTACION.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,1,2,?)");
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
 
 //3
 public static void insertarResolucionConflictos(ClassEvaluacionSupervisores c) throws SQLException {
        
        Connection cnn = BD.getConnection();
        PreparedStatement p = null;
        p = cnn.prepareStatement("insert into cresolucion_conflictos values(IDCONFLICTOS.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,1,2,?)");
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
 //4
 public static void insertarTrabajoEquipo(ClassEvaluacionSupervisores c) throws SQLException {
        
        Connection cnn = BD.getConnection();
        PreparedStatement p = null;
        p = cnn.prepareStatement("insert into dtrabajo_equipo values(idtrabajo_equipo.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,1,2,?)");
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

 //5
 public static void insertarOrganizacion(ClassEvaluacionSupervisores c) throws SQLException {
        
        Connection cnn = BD.getConnection();
        PreparedStatement p = null;
        p = cnn.prepareStatement("insert into eorganizacion values(IDORGANIZACION.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,1,2,?)");
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
 //6
 public static void insertarLiderazgo(ClassEvaluacionSupervisores c) throws SQLException {
        
        Connection cnn = BD.getConnection();
        PreparedStatement p = null;
        p = cnn.prepareStatement("insert into fliderazgo values(IDLIDERAZGO.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,1,2,?)");
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
 
 //7
 public static void insertarResponsabilidad(ClassEvaluacionSupervisores c) throws SQLException {
        
        Connection cnn = BD.getConnection();
        PreparedStatement p = null;
        p = cnn.prepareStatement("insert into gresponsabilidad values(IDRESPONSABILIDAD.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,1,2,?)");
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
 //8
 public static void insertarIniciativa(ClassEvaluacionSupervisores c) throws SQLException {
        
        Connection cnn = BD.getConnection();
        PreparedStatement p = null;
        p = cnn.prepareStatement("insert into hiniciativa values(IDINICIATIVA.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,1,2,?)");
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

}
