/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.Controllers;

import com.proyecto.Entidades.Empresas;
import com.proyecto.Entidades.Provincia;
import com.proyecto.ServiciosDatos.DatosEmpresas;
import com.proyecto.ServiciosDatos.DatosProvincias;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author empre
 */

@Named
@SessionScoped
public class ControllerEmpresas implements Serializable{

    private int idProvincia;
    private String nombreEmpresa, correoEmpresa, contraEmpresa, tipoSector, quienesSomoss;
    private List<Provincia> provincias;

    private Empresas objEmpresas = new Empresas();

    private DatosEmpresas datosEmpresas = new DatosEmpresas();

    /**
     * Inicializa el bean y carga la lista de provincias.
     */
    @PostConstruct
    public void init() {
        cargarProvincias();
    }

    /**
     * Carga la lista de provincias desde la clase DatosProvincias. Si ocurre un
     * error, muestra un mensaje de error.
     */
    private void cargarProvincias() {
        try {
            DatosProvincias datosProvincias = new DatosProvincias();
            this.provincias = datosProvincias.obtenerProvincias();
        } catch (Exception e) {
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "Error", "No se pudieron cargar las provincias");
        }
    }

    private void mostrarMensaje(FacesMessage.Severity severidad, String titulo, String detalle) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(severidad, titulo, detalle));
    }

    private void limpiarCampos() {
        nombreEmpresa = null;
        correoEmpresa = null;
        contraEmpresa = null;
        idProvincia = 0;
        quienesSomoss = null;
        tipoSector = null;
    }

    public String registrarEmpresa() {

        try {
            Empresas objEmpresas = new Empresas();

            objEmpresas.setNombreEmpresa(this.nombreEmpresa);
            objEmpresas.setCorreoEmpresa(this.correoEmpresa);
            objEmpresas.setContraEmpresa(this.contraEmpresa);
            objEmpresas.setIdProvincia(this.idProvincia);
            objEmpresas.setQuienesSomos(this.quienesSomoss);
            objEmpresas.setTipoSector(this.tipoSector);

            boolean resultdo = datosEmpresas.insertarEmpresa(objEmpresas);

            if (resultdo) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "¡Registro Exitoso!",
                                "Tu cuenta ha sido creada correctamente"));

                limpiarCampos();
                return "index?faces-redirect=true";
            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                "Error",
                                "No se pudo completar el registro"));
                return null;
            }
        }
         catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Error",
                            e.getMessage()));
            return null;
        }
    }

    public void dirigirRegistroEmpresa() {
        redireccionar("/registroEmpresa.xhtml");
    }

    public void redireccionar(String ruta) {
        HttpServletRequest request;
        try {
            request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            FacesContext.getCurrentInstance().getExternalContext().redirect(request.getContextPath() + ruta);
        } catch (IOException e) {
        }
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getCorreoEmpresa() {
        return correoEmpresa;
    }

    public void setCorreoEmpresa(String correoEmpresa) {
        this.correoEmpresa = correoEmpresa;
    }

    public String getContraEmpresa() {
        return contraEmpresa;
    }

    public void setContraEmpresa(String contraEmpresa) {
        this.contraEmpresa = contraEmpresa;
    }

    public int getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
    }

    public List<Provincia> getProvincias() {
        return provincias;
    }

    public void setProvincias(List<Provincia> provincias) {
        this.provincias = provincias;
    }

    public String getTipoSector() {
        return tipoSector;
    }

    public void setTipoSector(String tipoSector) {
        this.tipoSector = tipoSector;
    }

    public String getQuienesSomoss() {
        return quienesSomoss;
    }

    public void setQuienesSomoss(String quienesSomoss) {
        this.quienesSomoss = quienesSomoss;
    }

    
    
}
