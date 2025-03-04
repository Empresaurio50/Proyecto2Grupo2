/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.ServiciosDatos;

import com.proyecto.Entidades.Ofertas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author empre
 */
public class DatosOfertas extends AccesoDatos {

    private PreparedStatement prepared = null;
    private ResultSet result = null;

    public List<Ofertas> leerOferta() {

        List<Ofertas> listaRetorno = new ArrayList<>();

        try {
            super.Conectar();

            String sql = "SELECT o.idOferta, o.nombrePuesto, e.nombreEmpresa, e.ubicacion, o.logo from ofertas o, empresas e where o.idEmpresa = e.idEmpresa;";

            prepared = super.getConector().prepareStatement(sql);
            result = prepared.executeQuery();

            while (result.next()) {

                Ofertas objOfertas = new Ofertas();
                objOfertas.setIdOferta(result.getInt("o.idOferta"));
                objOfertas.setNombrePuesto(result.getString("o.nombrePuesto"));
                objOfertas.setEmpresa(result.getString("e.nombreEmpresa"));
                objOfertas.setUbicacion(result.getString("e.ubicacion"));
                objOfertas.setImagenOferta(result.getString("o.logo"));

                listaRetorno.add(objOfertas);

                
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
}
