/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.Entidades;

import java.io.Serializable;
import java.util.Date;

public class Usuario implements Serializable {

    private int idUsuario;
    private String nombreUsuario;
    private String contrasenaUsuario;
    private String correoUsuario;
    private Date fechaNacimiento;
    private String cv;
    private int idProvincia;
    private String carrera;

    // Constructor vacío
    public Usuario() {
    }

    // Constructor con todos los campos
    public Usuario(int idUsuario, String nombreUsuario, String contrasenaUsuario,
            String correoUsuario, Date fechaNacimiento, String cv, int idProvincia) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contrasenaUsuario = contrasenaUsuario;
        this.correoUsuario = correoUsuario;
        this.fechaNacimiento = fechaNacimiento;
        this.cv = cv;
        this.idProvincia = idProvincia;
    }

    // Getters y Setters
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenaUsuario() {
        return contrasenaUsuario;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setContrasenaUsuario(String contrasenaUsuario) {
        this.contrasenaUsuario = contrasenaUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public int getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
    }

    // Método toString para depuración
    @Override
    public String toString() {
        return "Usuario{"
                + "idUsuario=" + idUsuario
                + ", nombreUsuario='" + nombreUsuario + '\''
                + ", correoUsuario='" + correoUsuario + '\''
                + ", fechaNacimiento=" + fechaNacimiento
                + ", idProvincia=" + idProvincia
                + '}';
    }
}
