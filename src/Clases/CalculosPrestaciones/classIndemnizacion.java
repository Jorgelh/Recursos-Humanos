/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases.CalculosPrestaciones;

/**
 *
 * @author jluis
 */
public class classIndemnizacion {
    
    private String nombre;
    private Double salario;
    private Double salariopromedio;
    private Double salariopromedio12;
    private Double bonificacion;
    private int IdEmpleado;
    private String Fecha;
    private int Dias;
    private String FechaIngre;

    public Double getSalariopromedio12() {
        return salariopromedio12;
    }

    public void setSalariopromedio12(Double salariopromedio12) {
        this.salariopromedio12 = salariopromedio12;
    }
    public String getFechaIngre() {
        return FechaIngre;
    }

    public void setFechaIngre(String FechaIngre) {
        this.FechaIngre = FechaIngre;
    }

    public Double getSalariopromedio() {
        return salariopromedio;
    }

    public void setSalariopromedio(Double salariopromedio) {
        this.salariopromedio = salariopromedio;
    }
    
    
    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public int getDias() {
        return Dias;
    }

    public void setDias(int Dias) {
        this.Dias = Dias;
    }
    
    public int getIdEmpleado() {
        return IdEmpleado;
    }

    public void setIdEmpleado(int IdEmpleado) {
        this.IdEmpleado = IdEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Double getBonificacion() {
        return bonificacion;
    }
    public void setBonificacion(Double bonificacion) {
        this.bonificacion = bonificacion;
    }
}
