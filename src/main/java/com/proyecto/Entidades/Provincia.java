/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.Entidades;

import java.io.Serializable;

public class Provincia implements Serializable {
    private int idProvincia;
    private String nombreProvincia;

    public Provincia() {}

    public Provincia(int idProvincia, String nombreProvincia) {
        this.idProvincia = idProvincia;
        this.nombreProvincia = nombreProvincia;
    }

    public int getIdProvincia() { return idProvincia; }
    public void setIdProvincia(int idProvincia) { this.idProvincia = idProvincia; }

    public String getNombreProvincia() { return nombreProvincia; }
    public void setNombreProvincia(String nombreProvincia) { this.nombreProvincia = nombreProvincia; }
}