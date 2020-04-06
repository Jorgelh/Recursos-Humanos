/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases.Evaluacion;

import java.util.Date;

/**
 *
 * @author Jorge Luis
 */
public class ClassEvaluacion {
    
    private int id_listaempleados;
    private Date fecha;
    private int face;
    private int estado_evaluacion;
    private String nombres;
    private String apellidos;
    private String depto;
    private String Puesto;

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDepto() {
        return depto;
    }

    public void setDepto(String depto) {
        this.depto = depto;
    }

    public String getPuesto() {
        return Puesto;
    }

    public void setPuesto(String Puesto) {
        this.Puesto = Puesto;
    }
    
    
    
    //private int Organizacion;
    //private int Liderasgo;
    //private int Presentacion;
    //private int Responsabilidad;
    //private int Iniciativa;
    //private int estado;
    //private int tipo;

    public int getId_listaempleados() {
        return id_listaempleados;
    }

    public void setId_listaempleados(int id_listaempleados) {
        this.id_listaempleados = id_listaempleados;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getFace() {
        return face;
    }

    public void setFace(int face) {
        this.face = face;
    }

    public int getEstado_evaluacion() {
        return estado_evaluacion;
    }

    public void setEstado_evaluacion(int estado_evaluacion) {
        this.estado_evaluacion = estado_evaluacion;
    }
   
}
