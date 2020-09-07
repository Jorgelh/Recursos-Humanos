/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases.empleados;

import java.io.FileInputStream;
import java.util.Date;

/**
 *
 * @author jluis
 */
public class ListaMaestro {
    
   
private int ID_LISTAEMPLEADOS;
private int CODIGO;
private String NOMBRES;
private String APELLIDOS;	
private String SEXO;	
private String NIT;	
private String DIRECCION;	
private String TELEFONO;	
private FileInputStream FOTOGRAFIA;	
private Date F_NACIMIENTO;	
private String T_SANGRE;	
private String IRTRA;
private String DPI;
private String DPIEXTENDIDO;	
private String ESTUDIOS_ULTIMOS;	
private String ESTUDIOS_ACTUALES;
private String ESTADO_CIVIL;	
private String NOMBRE_CONYUGE;	
private String CORREO_ELECTRO;	
private String PUESTO;	
private int DEPARTAMENTO;	
private String CUENTA_BANCO;
private String IGSS;
private Date FECHA_INGRESO;	
private Date FECHA_BAJA;	
private String MOTIVO_BAJA;	
private double ORDINARIO;
private double BONIFICACION;  
private int longitudBytes;
private String depto;
private String f_nacimiento;
private String f_ingreso;
private int discapacidad;
private String TipoDiscapa;
private String NivelAcademico;
private int evaluadopor;
private String fechadebaja;

    public String getFechadebaja() {
        return fechadebaja;
    }

    public void setFechadebaja(String fechadebaja) {
        this.fechadebaja = fechadebaja;
    }
    
    public int getEvaluadopor() {
        return evaluadopor;
    }

    public void setEvaluadopor(int evaluadopor) {
        this.evaluadopor = evaluadopor;
    }

    public int getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(int discapacidad) {
        this.discapacidad = discapacidad;
    }

    public String getTipoDiscapa() {
        return TipoDiscapa;
    }

    public void setTipoDiscapa(String TipoDiscapa) {
        this.TipoDiscapa = TipoDiscapa;
    }

    public String getNivelAcademico() {
        return NivelAcademico;
    }

    public void setNivelAcademico(String NivelAcademico) {
        this.NivelAcademico = NivelAcademico;
    }
    
     
 
    public String getF_nacimiento() {
        return f_nacimiento;
    }

    public void setF_nacimiento(String f_nacimiento) {
        this.f_nacimiento = f_nacimiento;
    }

    public String getF_ingreso() {
        return f_ingreso;
    }

    public void setF_ingreso(String f_ingreso) {
        this.f_ingreso = f_ingreso;
    }

     

    public String getDepto() {
        return depto;
    }

    public void setDepto(String depto) {
        this.depto = depto;
    }



    public int getID_LISTAEMPLEADOS() {
        return ID_LISTAEMPLEADOS;
    }

    public void setID_LISTAEMPLEADOS(int ID_LISTAEMPLEADOS) {
        this.ID_LISTAEMPLEADOS = ID_LISTAEMPLEADOS;
    }

    public int getCODIGO() {
        return CODIGO;
    }

    public void setCODIGO(int CODIGO) {
        this.CODIGO = CODIGO;
    }

    public String getNOMBRES() {
        return NOMBRES;
    }

    public void setNOMBRES(String NOMBRES) {
        this.NOMBRES = NOMBRES;
    }

    public String getAPELLIDOS() {
        return APELLIDOS;
    }

    public void setAPELLIDOS(String APELLIDOS) {
        this.APELLIDOS = APELLIDOS;
    }

    public String getSEXO() {
        return SEXO;
    }

    public void setSEXO(String SEXO) {
        this.SEXO = SEXO;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public String getDIRECCION() {
        return DIRECCION;
    }

    public void setDIRECCION(String DIRECCION) {
        this.DIRECCION = DIRECCION;
    }

    public String getTELEFONO() {
        return TELEFONO;
    }

    public void setTELEFONO(String TELEFONO) {
        this.TELEFONO = TELEFONO;
    }

    public FileInputStream getFOTOGRAFIA() {
        return FOTOGRAFIA;
    }

    public void setFOTOGRAFIA(FileInputStream FOTOGRAFIA) {
        this.FOTOGRAFIA = FOTOGRAFIA;
    }

    public int getLongitudBytes() {
        return longitudBytes;
    }

    public void setLongitudBytes(int longitudBytes) {
        this.longitudBytes = longitudBytes;
    }

    public Date getF_NACIMIENTO() {
        return F_NACIMIENTO;
    }

    public void setF_NACIMIENTO(Date F_NACIMIENTO) {
        this.F_NACIMIENTO = F_NACIMIENTO;
    }

    public String getT_SANGRE() {
        return T_SANGRE;
    }

    public void setT_SANGRE(String T_SANGRE) {
        this.T_SANGRE = T_SANGRE;
    }

    public String getIRTRA() {
        return IRTRA;
    }

    public void setIRTRA(String IRTRA) {
        this.IRTRA = IRTRA;
    }

    public String getDPI() {
        return DPI;
    }

    public void setDPI(String DPI) {
        this.DPI = DPI;
    }

    public String getDPIEXTENDIDO() {
        return DPIEXTENDIDO;
    }

    public void setDPIEXTENDIDO(String DPIEXTENDIDO) {
        this.DPIEXTENDIDO = DPIEXTENDIDO;
    }

    public String getESTUDIOS_ULTIMOS() {
        return ESTUDIOS_ULTIMOS;
    }

    public void setESTUDIOS_ULTIMOS(String ESTUDIOS_ULTIMOS) {
        this.ESTUDIOS_ULTIMOS = ESTUDIOS_ULTIMOS;
    }

    public String getESTUDIOS_ACTUALES() {
        return ESTUDIOS_ACTUALES;
    }

    public void setESTUDIOS_ACTUALES(String ESTUDIOS_ACTUALES) {
        this.ESTUDIOS_ACTUALES = ESTUDIOS_ACTUALES;
    }

    public String getESTADO_CIVIL() {
        return ESTADO_CIVIL;
    }

    public void setESTADO_CIVIL(String ESTADO_CIVIL) {
        this.ESTADO_CIVIL = ESTADO_CIVIL;
    }

    public String getNOMBRE_CONYUGE() {
        return NOMBRE_CONYUGE;
    }

    public void setNOMBRE_CONYUGE(String NOMBRE_CONYUGE) {
        this.NOMBRE_CONYUGE = NOMBRE_CONYUGE;
    }

    public String getCORREO_ELECTRO() {
        return CORREO_ELECTRO;
    }

    public void setCORREO_ELECTRO(String CORREO_ELECTRO) {
        this.CORREO_ELECTRO = CORREO_ELECTRO;
    }

    public String getPUESTO() {
        return PUESTO;
    }

    public void setPUESTO(String PUESTO) {
        this.PUESTO = PUESTO;
    }

    public int getDEPARTAMENTO() {
        return DEPARTAMENTO;
    }

    public void setDEPARTAMENTO(int DEPARTAMENTO) {
        this.DEPARTAMENTO = DEPARTAMENTO;
    }

    public String getCUENTA_BANCO() {
        return CUENTA_BANCO;
    }

    public void setCUENTA_BANCO(String CUENTA_BANCO) {
        this.CUENTA_BANCO = CUENTA_BANCO;
    }

    public String getIGSS() {
        return IGSS;
    }

    public void setIGSS(String IGSS) {
        this.IGSS = IGSS;
    }

    public Date getFECHA_INGRESO() {
        return FECHA_INGRESO;
    }

    public void setFECHA_INGRESO(Date FECHA_INGRESO) {
        this.FECHA_INGRESO = FECHA_INGRESO;
    }

    public Date getFECHA_BAJA() {
        return FECHA_BAJA;
    }

    public void setFECHA_BAJA(Date FECHA_BAJA) {
        this.FECHA_BAJA = FECHA_BAJA;
    }

    public String getMOTIVO_BAJA() {
        return MOTIVO_BAJA;
    }

    public void setMOTIVO_BAJA(String MOTIVO_BAJA) {
        this.MOTIVO_BAJA = MOTIVO_BAJA;
    }

    public double getORDINARIO() {
        return ORDINARIO;
    }

    public void setORDINARIO(double ORDINARIO) {
        this.ORDINARIO = ORDINARIO;
    }

    public double getBONIFICACION() {
        return BONIFICACION;
    }

    public void setBONIFICACION(double BONIFICACION) {
        this.BONIFICACION = BONIFICACION;
    }


    
}
