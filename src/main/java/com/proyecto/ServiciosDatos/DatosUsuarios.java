/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.ServiciosDatos;

import com.proyecto.Entidades.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author empre
 */
public class DatosUsuarios extends AccesoDatos{
    
    private PreparedStatement prepared = null;
    private ResultSet result = null;

    public List<Usuario> leerUsuario() throws SQLException {

        List<Usuario> listaRetorno = new ArrayList<>();

        try {

            super.Conectar();
            String sql = "SELECT idUsuario FROM usuarios;";
            prepared = super.getConector().prepareStatement(sql);
            result = prepared.executeQuery();

            while (result.next()) {

                Usuario objUsuario = new Usuario();
                objUsuario.setIdUsuario(result.getInt(""));

                listaRetorno.add(objUsuario);

            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.print(e);
        } finally {
            cerrarConexion();
            cerrarPrepared(prepared);
            cerrarResult(result);
        }
        return listaRetorno;
    }

    public boolean existeUsuario(String correo) {
        try {
            super.Conectar();
            String sql = "SELECT COUNT(*) FROM usuario WHERE correoUsuario = ?";
            prepared = super.getConector().prepareStatement(sql);
            prepared.setString(1, correo);
            result = prepared.executeQuery();

            if (result.next()) {
                return result.getInt(1) > 0;
            }
            return false;
        } catch (Exception e) {
            System.out.println("Error al verificar usuario: " + e.getMessage());
            return false;
        } finally {
            cerrarConexion();
            cerrarPrepared(prepared);
            cerrarResult(result);
        }
    }

    public boolean insertarUsuario(Usuario objUsuario) throws Exception {
        try {
            // Primero verificar si el usuario ya existe
            if (existeUsuario(objUsuario.getCorreoUsuario())) {
                throw new Exception("Ya existe un usuario registrado con este correo electrónico");
            }

            super.Conectar();
            String sql = "INSERT INTO usuario (nombreUsuario, contrasenaUsuario, correoUsuario, "
                    + "fechaNacimiento, carrera, idProvincia) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";

            prepared = super.getConector().prepareStatement(sql);
            prepared.setString(1, objUsuario.getNombreUsuario());
            prepared.setString(2, objUsuario.getContrasenaUsuario());
            prepared.setString(3, objUsuario.getCorreoUsuario());
            prepared.setDate(4, new java.sql.Date(objUsuario.getFechaNacimiento().getTime()));
            prepared.setString(5, objUsuario.getCarrera());
            prepared.setInt(6, objUsuario.getIdProvincia());

            int resultado = prepared.executeUpdate();
            return resultado > 0;

        } catch (SQLException e) {
            if (e.getSQLState().equals("23000")) { // Error de duplicado
                throw new Exception("Ya existe un usuario registrado con este correo electrónico");
            } else {
                throw new Exception("Error al registrar usuario: " + e.getMessage());
            }
        } finally {
            cerrarConexion();
            cerrarPrepared(prepared);
        }
    }

    public void actulizarUsuario(Usuario objUsuario) {

        try {
            super.Conectar();
            String sql = "UPDATE estudiantes SET nombreEstudiante = ?, contraEstudiante = ? WHERE correoEstudiante = ? ";
            prepared = super.getConector().prepareStatement(sql);
            prepared.setString(1, objUsuario.getNombreUsuario());

            int registro = prepared.executeUpdate();

            if (registro == 0) {
                throw new SQLException("No se agrego ningun registro");
            }
            prepared.executeQuery();

        } catch (SQLException | ClassNotFoundException e) {
            System.out.print(e);

        } finally {
            cerrarConexion();
            cerrarPrepared(prepared);

        }
    }

    public void eliminarUsuario(Usuario objUsuario) {

        try {
            super.Conectar();
            String sql = "DELETE FROM estudiantes WHERE correoEstudiante = ?;";
            prepared = super.getConector().prepareStatement(sql);
            prepared.setString(1, objUsuario.getNombreUsuario());

            int registro = prepared.executeUpdate();

            if (registro == 0) {
                throw new SQLException("No se agrego ningun registro");
            }
            prepared.executeQuery();

        } catch (SQLException | ClassNotFoundException e) {
            System.out.print(e);

        } finally {
            cerrarConexion();
            cerrarPrepared(prepared);

        }
    }
}
