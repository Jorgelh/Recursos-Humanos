/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BDreloj;

/**
 *
 * @author jluis
 */
public class ClassReloj {
    
     private int Codigo;
    private String nombre;
    private String puesto;
    private int estado;
    private int depto;
    private String Departamento;
    private String fecha;
    private String horain;
    private String horaout;
    private String HorasLaboradas;
    private String HorasExtras;
    private int EstadoIngresoEspecial;
    private String Nota;

    public String getNota() {
        return Nota;
    }

    public void setNota(String Nota) {
        this.Nota = Nota;
    }
    public int getEstadoIngresoEspecial() {
        return EstadoIngresoEspecial;
    }
    public void setEstadoIngresoEspecial(int EstadoIngresoEspecial) {
        this.EstadoIngresoEspecial = EstadoIngresoEspecial;
    }
    public String getHorasLaboradas() {
        return HorasLaboradas;
    }

    public void setHorasLaboradas(String HorasLaboradas) {
        this.HorasLaboradas = HorasLaboradas;
    }

    public String getHorasExtras() {
        return HorasExtras;
    }

    public void setHorasExtras(String HorasExtras) {
        this.HorasExtras = HorasExtras;
    }
    
    
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHorain() {
        return horain;
    }

    public void setHorain(String horain) {
        this.horain = horain;
    }

    public String getHoraout() {
        return horaout;
    }

    public void setHoraout(String horaout) {
        this.horaout = horaout;
    }
    
    

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getDepto() {
        return depto;
    }

    public void setDepto(int depto) {
        this.depto = depto;
    }

    public String getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(String Departamento) {
        this.Departamento = Departamento;
    }
    
    
    
}
