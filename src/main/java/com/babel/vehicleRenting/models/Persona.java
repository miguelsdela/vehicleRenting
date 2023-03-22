package com.babel.vehicleRenting.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;

public class Persona {

    private int personaId;
    private String nombre;
    private String apellido1;
    private String Apellido2;
    private Direccion direccionDomicilio;
    private boolean direccionDomicilioSameAsNotification = true;
    private Direccion direccionNotificacion;
    private String nif;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date fechaNacimiento;
    private String nacionalidad;
    @Min(1)
    @Max(8)
    private Integer scoring;
    
    //TODO: Falta FechaScoring
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date fechaScoring;

    public int getPersonaId() {
        return personaId;
    }

    public void setPersonaId(int personaId) {
        this.personaId = personaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return Apellido2;
    }

    public void setApellido2(String apellido2) {
        Apellido2 = apellido2;
    }

    public Direccion getDireccionDomicilio() {
        return direccionDomicilio;
    }

    public void setDireccionDomicilio(Direccion direccionDomicilio) {
        this.direccionDomicilio = direccionDomicilio;
    }

    public boolean isDireccionDomicilioSameAsNotification() {
        return direccionDomicilioSameAsNotification;
    }

    public void setDireccionDomicilioSameAsNotification(boolean direccionDomicilioSameAsNotification) {
        this.direccionDomicilioSameAsNotification = direccionDomicilioSameAsNotification;
    }

    public Direccion getDireccionNotificacion() {
        return direccionNotificacion;
    }

    public void setDireccionNotificacion(Direccion direccionNotificacion) {
        this.direccionNotificacion = direccionNotificacion;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Integer getScoring() {
        return scoring;
    }

    public void setScoring(Integer scoring) {
        this.scoring = scoring;
    }

    public Date getFechaScoring() {
        return fechaScoring;
    }

    public void setFechaScoring(Date fechaScoring) {
        this.fechaScoring = fechaScoring;
    }
}
