//este es el LoginController

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.Controllers;

import com.proyecto.Entidades.Usuario;
import com.proyecto.ServiciosDatos.DatosUsuarios;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */

@Named
@SessionScoped

public class LoginController implements Serializable{
    
    private String correoUsuario;
    private String contraUsuario;
    private List<Usuario> listaRetorno = new ArrayList<>();
    private DatosUsuarios datosusuarios = new DatosUsuarios();
    

    public LoginController() {
        
    }
    
    public void verificar() {
        if (datosusuarios.validarUsuario(correoUsuario, contraUsuario) != null) {

            try {
                
                this.listaRetorno = datosusuarios.leerUsuario();
                
                redireccionar("/principal.xhtml");
            } catch (SQLException e) {
                FacesContext.getCurrentInstance().addMessage("error", new FacesMessage(FacesMessage.SEVERITY_ERROR, "erroe1", "error2"));
            }
            

            redireccionar("/principal.xhtml");
        } else {
            FacesContext.getCurrentInstance().addMessage("error", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error Verificar", "La contraseña o el correo son incorrectos"));
        }

    }
    
    
    public void redireccionar(String ruta) {
        HttpServletRequest request;
        try {
            request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            FacesContext.getCurrentInstance().getExternalContext().redirect(request.getContextPath() + ruta);
        } catch (Exception e) {
        }
    }
    
    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getContraUsuario() {
        return contraUsuario;
    }

    public void setContraUsuario(String contraUsuario) {
        this.contraUsuario = contraUsuario;
    }

    public List<Usuario> getListaRetorno() {
        return listaRetorno;
    }

    public void setListaRetorno(List<Usuario> listaRetorno) {
        this.listaRetorno = listaRetorno;
    }
    
    
    
}