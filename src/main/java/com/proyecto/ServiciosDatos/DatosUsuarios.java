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
    
    public void insertarUsuario(Usuario objUsuario) {

        try {
            super.Conectar();
            String sql = "INSERT INTO estudiantes(nombreEstudiante, correoEstudiante, contraEstudiante) VALUES(?,?,?)";
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
