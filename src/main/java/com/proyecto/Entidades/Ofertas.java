/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.Entidades;

import java.io.Serializable;

/**
 *
 * @author empre
 */
public class Ofertas implements Serializable{
    
    protected int idOferta;
    private String nombrePuesto, remunerada;
    private int idEmpresa;
    private String imagenOferta; // Campo para almacenar la imagen

    public Ofertas() {
    }

    public Ofertas(int idOferta, String nombrePuesto, String remunerada, String imagenOferta) {
        this.idOferta = idOferta;
        this.nombrePuesto = nombrePuesto;
        this.remunerada = remunerada;
        this.imagenOferta = imagenOferta;
        
    }

    public int getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(int idOferta) {
        this.idOferta = idOferta;
    }

    public String getNombrePuesto() {
        return nombrePuesto;
    }

    public void setNombrePuesto(String nombrePuesto) {
        this.nombrePuesto = nombrePuesto;
    }

    public String getRemunerada() {
        return remunerada;
    }

    public void setRemunerada(String remunerada) {
        this.remunerada = remunerada;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getImagenOferta() {
        return imagenOferta;
    }

    public void setImagenOferta(String imagenOferta) {
        this.imagenOferta = imagenOferta;
    }
}
