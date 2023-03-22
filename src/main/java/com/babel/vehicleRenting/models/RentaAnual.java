package com.babel.vehicleRenting.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class RentaAnual {
    private int rentaId;
    private Persona persona;
    private Profesion profesion;
    private int anio;
    private int importe;
    private int isCuentaPropia;
    private String iae;
    private String cifEmpleador;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date fechaInicioEmpleo;

    public int getRentaId() {
        return rentaId;
    }

    public void setRentaId(int rentaId) {
        this.rentaId = rentaId;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Profesion getProfesion() {
        return profesion;
    }

    public void setProfesion(Profesion profesion) {
        this.profesion = profesion;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getImporte() {
        return importe;
    }

    public void setImporte(int importe) {
        this.importe = importe;
    }

    public int getIsCuentaPropia() {
        return isCuentaPropia;
    }

    public void setIsCuentaPropia(int isCuentaPropia) {
        this.isCuentaPropia = isCuentaPropia;
    }

    public String getIae() {
        return iae;
    }

    public void setIae(String iae) {
        this.iae = iae;
    }

    public String getCifEmpleador() {
        return cifEmpleador;
    }

    public void setCifEmpleador(String cifEmpleador) {
        this.cifEmpleador = cifEmpleador;
    }

    public Date getFechaInicioEmpleo() {
        return fechaInicioEmpleo;
    }

    public void setFechaInicioEmpleo(Date fechaInicioEmpleo) {
        this.fechaInicioEmpleo = fechaInicioEmpleo;
    }
}
