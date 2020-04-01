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

/**
 *
 * @author jluis
 */
public class IngresoEmpleado {
    
    
    public static void insertarEmpleado(ListaMaestro c) throws SQLException {
        
        Connection cnn = BD.getConnection();
        PreparedStatement p = null;
        p = cnn.prepareStatement("insert into ALISTAEMPLEADOS" 
                + "(ID_LISTAEMPLEADOS,CODIGO,NOMBRES,APELLIDOS,F_NACIMIENTO,DPI,DPIEXTENDIDO,DIRECCION,NIT,TELEFONO,T_SANGRE,"
                + " CORREO_ELECTRO,ESTUDIOS_ULTIMOS,IGSS,IRTRA,ESTADO_CIVIL,SEXO,CUENTA_BANCO,DEPARTAMENTO,PUESTO,"
                + " FECHA_INGRESO,ORDINARIO,BONIFICACION,FOTOGRAFIA) "
                + "values (IDEMPLEADO.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        p.setInt(1, c.getCODIGO());
        p.setString(2, c.getNOMBRES());
        p.setString(3, c.getAPELLIDOS());
        p.setDate(4, new java.sql.Date(c.getF_NACIMIENTO().getTime()));
        p.setInt(5, c.getDPI());
        p.setString(6, c.getDPIEXTENDIDO());
        p.setString(7, c.getDIRECCION());
        p.setString(8, c.getNIT());
        p.setString(9, c.getTELEFONO());
        p.setString(10, c.getT_SANGRE());
        p.setString(11, c.getCORREO_ELECTRO());
        p.setString(12, c.getESTUDIOS_ULTIMOS());
        p.setString(13, c.getIGSS());
        p.setString(14, c.getIRTRA());
        p.setString(15, c.getESTADO_CIVIL());
        p.setString(16, c.getSEXO());
        p.setString(17, c.getCUENTA_BANCO());
        p.setInt(18, c.getDEPARTAMENTO());
        p.setString(19, c.getPUESTO());
        p.setDate(20, new java.sql.Date(c.getFECHA_INGRESO().getTime()));
        p.setDouble(21, c.getORDINARIO());
        p.setDouble(22, c.getBONIFICACION());
        p.setBinaryStream(23, c.getFOTOGRAFIA(),c.getLongitudBytes());
        p.executeUpdate();
        cnn.close();
        p.close();
    }
    
    public static ListaMaestro buscarEmpleado(int id) throws SQLException {
        return buscarEmple(id, null);
    }

    public static ListaMaestro buscarEmple(int id, ListaMaestro p) throws SQLException {
        Connection cnn = BD.getConnection();
        
        try {
            PreparedStatement ps = null;

            ps = cnn.prepareStatement("select CODIGO,NOMBRES,APELLIDOS,to_char(F_NACIMIENTO,'dd/mm/yy') as F_NACIMIENTO,DPI,DPIEXTENDIDO,DIRECCION,NIT,TELEFONO,T_SANGRE,CORREO_ELECTRO,ESTUDIOS_ULTIMOS,IGSS,IRTRA,ESTADO_CIVIL,SEXO,CUENTA_BANCO,DECODE(DEPARTAMENTO,1,'INSPECCION',2,'TESTING',3,'CHIPS',4,'STRIP Y POTTING',5,'TRANSFORMADORES',6,'TALLER',7,'BODEGA',8,'ADMINISTRACION',9,'GERENCIA') AS DEPTO,PUESTO,to_char(FECHA_INGRESO,'dd/mm/yy') as FECHA_INGRESO,ORDINARIO,BONIFICACION FROM alistaempleados  where codigo = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                if (p == null) {
                    p = new ListaMaestro() {
                    };
                }
                p.setCODIGO(rs.getInt("CODIGO"));
                p.setNOMBRES(rs.getString("NOMBRES"));
                p.setAPELLIDOS(rs.getString("APELLIDOS"));
                p.setF_nacimiento(rs.getString("F_NACIMIENTO"));
                p.setDPI(rs.getInt("DPI"));
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
