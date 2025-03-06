/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.Controllers;

import com.proyecto.Entidades.Ofertas;
import com.proyecto.ServiciosDatos.DatosOfertas;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author empre
 * Controlador de JSF para la gestión de ofertas de trabajo.
 * Este bean gestiona la lista de ofertas, el filtrado y la interacción del usuario.
 */
@Named
@SessionScoped
public class ControllerOfertas implements Serializable{
    
    private List<Ofertas> listaOfertas = new ArrayList<>();
    
    private String filtroNombre = "";
    private String filtroEmpresa = "";
    private String filtroUbicacion = "";
    
    private Ofertas ofertaSeleccionada; //Guarda la oferta seleccionada
    private boolean mostrarDetalles = false; //Controla si el panel lateral se muestra

    
    private List<Ofertas> ofertasFiltradas = new ArrayList<>();
    
    /**
     * Carga la lista de ofertas al inicializar el bean.
     * Utiliza la clase DatosOfertas para obtener los datos.
     */
    
    @PostConstruct
    public void cargarOfertas() {
        DatosOfertas datosOfertas = new DatosOfertas();
        this.listaOfertas = datosOfertas.leerOferta();
        this.ofertasFiltradas = new ArrayList<>(listaOfertas); // Copia inicial
    }

    /**
     * Filtra la lista de ofertas basándose en los criterios introducidos por el usuario.
     * Utiliza Streams de Java 8 para el filtrado.
     */
    public void filtrarOfertas() {
        this.ofertasFiltradas = listaOfertas.stream()
                .filter(oferta -> filtroNombre.isEmpty() || oferta.getNombrePuesto().toLowerCase().contains(filtroNombre.toLowerCase()))
                .filter(oferta -> filtroEmpresa.isEmpty() || oferta.getEmpresa().toLowerCase().contains(filtroEmpresa.toLowerCase()))
                .filter(oferta -> filtroUbicacion.isEmpty() || oferta.getNombrePuesto().toLowerCase().contains(filtroUbicacion.toLowerCase()))
                .collect(Collectors.toList());
    }

       /**
     * Redirige a la ruta especificada.
     *
     * @param ruta La ruta a la que se redirige.
     */
    public void redireccionar(String ruta) {
        HttpServletRequest request;
        try {
            request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            FacesContext.getCurrentInstance().getExternalContext().redirect(request.getContextPath() + ruta);
        } catch (IOException e) {
        }
    } 

     /**
     * Simula el envío de una solicitud para una oferta de trabajo.
     * Muestra un mensaje en la interfaz de usuario.
     *
     * @param idOferta El ID de la oferta para la que se envía la solicitud.
     */
    public void solicitarOferta(int idOferta) {
        // Simulación de envío de solicitud (aquí podrías agregar lógica real)
        System.out.println("Solicitud enviada para la oferta con ID: " + idOferta);

        // Mostrar mensaje en la interfaz
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Solicitud enviada", "Tu solicitud ha sido enviada correctamente."));
    }
    
    public void verDetalles(Ofertas oferta) {
        this.ofertaSeleccionada = oferta;
        this.mostrarDetalles = true;
    }
    
    
    // Getters y setters (necesarios para que JSF pueda acceder a los atributos)
    
    public List<Ofertas> getListaOfertas() {
        return listaOfertas;
    }

    public void setListaOfertas(List<Ofertas> listaOfertas) {
        this.listaOfertas = listaOfertas;
    }

    public Ofertas getOfertaSeleccionada() {
        return ofertaSeleccionada;
    }

    public void setOfertaSeleccionada(Ofertas ofertaSeleccionada) {
        this.ofertaSeleccionada = ofertaSeleccionada;
    }

    public boolean isMostrarDetalles() {
        return mostrarDetalles;
    }

    public void setMostrarDetalles(boolean mostrarDetalles) {
        this.mostrarDetalles = mostrarDetalles;
    }

    public String getFiltroNombre() {
        return filtroNombre;
    }

    public void setFiltroNombre(String filtroNombre) {
        this.filtroNombre = filtroNombre;
    }

    public String getFiltroEmpresa() {
        return filtroEmpresa;
    }

    public void setFiltroEmpresa(String filtroEmpresa) {
        this.filtroEmpresa = filtroEmpresa;
    }

    public String getFiltroUbicacion() {
        return filtroUbicacion;
    }

    public void setFiltroUbicacion(String filtroUbicacion) {
        this.filtroUbicacion = filtroUbicacion;
    }

    public List<Ofertas> getOfertasFiltradas() {
        return ofertasFiltradas;
    }

    public void setOfertasFiltradas(List<Ofertas> ofertasFiltradas) {
        this.ofertasFiltradas = ofertasFiltradas;
    }
}
