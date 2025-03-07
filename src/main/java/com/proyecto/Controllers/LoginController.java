//este es el LoginController

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.Controllers;

import com.proyecto.Entidades.Ofertas;
import com.proyecto.ServiciosDatos.DatosOfertas;
import com.proyecto.ServiciosDatos.DatosUsuarios;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 *
 * Controlador de inicio de sesión para la aplicación.
 * Este bean gestiona la autenticación de usuarios y la redirección a la página principal.
 */
@Named
@SessionScoped

public class LoginController implements Serializable{
    
    private String correoUsuario;
    private String contraUsuario;
    private List<Ofertas> listaRetorno = new ArrayList<>();
    private DatosUsuarios datosusuarios = new DatosUsuarios();
    private DatosOfertas datosOfertas = new DatosOfertas();
    
    /**
     * Constructor vacío de LoginController.
     */
    public LoginController() {
        
    }
    
    /**
     * Verifica las credenciales del usuario y redirige a la página principal si son correctas.
     * Si las credenciales son incorrectas, muestra un mensaje de error.
     */
    
    public void verificar() {
        if (datosusuarios.validarUsuario(correoUsuario, contraUsuario) != null) {

            this.listaRetorno = datosOfertas.leerOferta();//Carga la lista de ofertas
            redireccionar("/principal.xhtml");

        } else {
            FacesContext.getCurrentInstance().addMessage("error", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error Verificar", "La contraseña o el correo son incorrectos"));
        }
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
        } catch (Exception e) {
        }
    }
    // Getters y setters
    
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

    public List<Ofertas> getListaRetorno() {
        return listaRetorno;
    }

    public void setListaRetorno(List<Ofertas> listaRetorno) {
        this.listaRetorno = listaRetorno;
    }
    
}