/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.ServiciosDatos;

import com.proyecto.Entidades.Provincia;
import com.proyecto.Entidades.Provincia;
import com.proyecto.ServiciosDatos.AccesoDatos;
import com.proyecto.ServiciosDatos.AccesoDatos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DatosProvincias extends AccesoDatos {
    
    public List<Provincia> obtenerProvincias() {
        List<Provincia> provincias = new ArrayList<>();
        PreparedStatement prepared = null;
        ResultSet result = null;
        
        try {
            super.Conectar();
            String sql = "SELECT idProvincia, nombreProvincia FROM provincia ORDER BY nombreProvincia";
            prepared = super.getConector().prepareStatement(sql);
            result = prepared.executeQuery();
            
            while (result.next()) {
                Provincia provincia = new Provincia();
                provincia.setIdProvincia(result.getInt("idProvincia"));
                provincia.setNombreProvincia(result.getString("nombreProvincia"));
                provincias.add(provincia);
            }
        } catch (Exception e) {
            System.out.println("Error al obtener provincias: " + e.getMessage());
        } finally {
            cerrarConexion();
            cerrarPrepared(prepared);
            cerrarResult(result);
        }
        
        return provincias;
    }
}