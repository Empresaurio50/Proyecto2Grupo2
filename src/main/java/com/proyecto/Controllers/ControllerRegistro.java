/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.Controllers;

import com.proyecto.ServiciosDatos.DatosProvincias;
import com.proyecto.Entidades.Provincia;
import com.proyecto.Entidades.Usuario;
import com.proyecto.ServiciosDatos.DatosUsuarios;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Controlador para la gestión del registro de usuarios.
 * Este bean gestiona la información del usuario y la lógica de registro.
 */

@Named
@SessionScoped
public class ControllerRegistro implements Serializable {

    private String nombres;
    private String apellidos;
    private String correo;
    private String contrasena;
    private String carrera;
    private Date fechaNacimiento;
    private int idProvincia;
    private List<Provincia> provincias;

    /**
     * Inicializa el bean y carga la lista de provincias.
     */
    @PostConstruct
    public void init() {
        cargarProvincias();
    }

    /**
     * Carga la lista de provincias desde la clase DatosProvincias.
     * Si ocurre un error, muestra un mensaje de error.
     */
    private void cargarProvincias() {
        try {
            DatosProvincias datosProvincias = new DatosProvincias();
            this.provincias = datosProvincias.obtenerProvincias();
        } catch (Exception e) {
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "Error", "No se pudieron cargar las provincias");
        }
    }
    
    /**
     * Registra un nuevo usuario en la base de datos.
     * Valida la información del usuario y muestra mensajes de éxito o error.
     *
     * @return La página a la que se redirige después del registro.
     */

    public String registrarUsuario() {
        try {
            Usuario nuevoUsuario = new Usuario();
            nuevoUsuario.setNombreUsuario(nombres + " " + apellidos);
            nuevoUsuario.setContrasenaUsuario(contrasena);
            nuevoUsuario.setCorreoUsuario(correo);
            nuevoUsuario.setFechaNacimiento(fechaNacimiento);
            nuevoUsuario.setIdProvincia(idProvincia);
            nuevoUsuario.setCarrera(carrera);

            DatosUsuarios datosUsuarios = new DatosUsuarios();
            boolean resultado = datosUsuarios.insertarUsuario(nuevoUsuario);

            if (resultado) {
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

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Error",
                            e.getMessage()));
            return null;
        }
    }
    
    /**
     * Limpia los campos del formulario de registro.
     */

    private void limpiarCampos() {
        nombres = null;
        apellidos = null;
        correo = null;
        contrasena = null;
        carrera = null;
        fechaNacimiento = null;
        idProvincia = 0;
    }
    
    /**
     * Verifica si el usuario es mayor de edad.
     *
     * @return true si el usuario es mayor de edad, false de lo contrario.
     */

    private boolean esMayorDeEdad() {
        if (fechaNacimiento == null) {
            return false;
        }

        Calendar fechaNac = Calendar.getInstance();
        fechaNac.setTime(fechaNacimiento);
        Calendar ahora = Calendar.getInstance();

        int edad = ahora.get(Calendar.YEAR) - fechaNac.get(Calendar.YEAR);
        if (ahora.get(Calendar.DAY_OF_YEAR) < fechaNac.get(Calendar.DAY_OF_YEAR)) {
            edad--;
        }

        return edad >= 18;
    }

    
    /**
     * Valida la contraseña del usuario.
     * La contraseña debe tener al menos 8 caracteres y contener letras y números.
     *
     * @return true si la contraseña es válida, false de lo contrario.
     */
    
    private boolean validarContrasena() {
        if (contrasena == null || contrasena.length() < 8) {
            return false;
        }

        boolean tieneNumero = false;
        boolean tieneLetra = false;

        for (char c : contrasena.toCharArray()) {
            if (Character.isDigit(c)) {
                tieneNumero = true;
            }
            if (Character.isLetter(c)) {
                tieneLetra = true;
            }
            if (tieneNumero && tieneLetra) {
                return true;
            }
        }

        return false;
    }
    
    /**
     * Muestra un mensaje en la interfaz de usuario.
     *
     * @param severidad La severidad del mensaje.
     * @param titulo    El título del mensaje.
     * @param detalle   El detalle del mensaje.
     */

    private void mostrarMensaje(FacesMessage.Severity severidad, String titulo, String detalle) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(severidad, titulo, detalle));
    }

    // Getters y Setters
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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
}
