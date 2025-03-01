/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.Controllers;

import com.proyecto.Entidades.Ofertas;
import com.proyecto.ServiciosDatos.DatosOfertas;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author empre
 */

@Named
@SessionScoped
public class ControllerOfertas implements Serializable{
    private List<Ofertas> listaOfertas = new ArrayList<>();

    public void a(){
        
        DatosOfertas datosOfertas = new DatosOfertas();
        this.listaOfertas = datosOfertas.leerOferta();
        this.redireccionar("/principal.xhtml");

    }
    
    public void redireccionar(String ruta) {
        HttpServletRequest request;
        try {
            request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            FacesContext.getCurrentInstance().getExternalContext().redirect(request.getContextPath() + ruta);
        } catch (IOException e) {
        }
    } 

    public List<Ofertas> getListaOfertas() {
        return listaOfertas;
    }

    public void setListaOfertas(List<Ofertas> listaOfertas) {
        this.listaOfertas = listaOfertas;
    }
}
