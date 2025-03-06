/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.ServiciosDatos;

import com.proyecto.Entidades.Empresas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author empre
 */
public class DatosEmpresas extends AccesoDatos {

    private ResultSet result = null;
    private PreparedStatement prepared = null;

    public boolean insertarEmpresa(Empresas objEmpresas) throws Exception{
        try {
            
            super.Conectar();

            String sql = "INSERT INTO empresas(`nombreEmpresa`, `correoEmpresa`, `contraEmpresa`, `idProvincia`, `quienesSomos`, `tipoSector`) VALUES (?, ?, ?, ?, ?, ?)";
            this.prepared = super.getConector().prepareStatement(sql);
            this.prepared.setString(1, objEmpresas.getNombreEmpresa());
            this.prepared.setString(2, objEmpresas.getCorreoEmpresa());
            this.prepared.setString(3, objEmpresas.getContraEmpresa());
            this.prepared.setInt(4, objEmpresas.getIdProvincia());
            this.prepared.setString(5, objEmpresas.getQuienesSomos());
            this.prepared.setString(6, objEmpresas.getTipoSector());
            
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

}
