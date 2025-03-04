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
    private String nombrePuesto, remunerada, empresa, ubicacion, detalles;
    private int idEmpresa;
    private String imagenOferta; // Campo para almacenar la imagen

    public Ofertas() {
    }

    public Ofertas(int idOferta, String nombrePuesto, String remunerada, int idEmpresa, String empresa, String ubicacion, String detalle) {
        this.idOferta = idOferta;
        this.nombrePuesto = nombrePuesto;
        this.remunerada = remunerada;
        this.idEmpresa = idEmpresa;
        this.empresa = empresa;
        this.ubicacion = ubicacion;
        this.detalles = detalles;
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

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public String getImagenOferta() {
        return imagenOferta;
    }

    public void setImagenOferta(String imagenOferta) {
        this.imagenOferta = imagenOferta;
    }
    
    public void setDescripcion(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
