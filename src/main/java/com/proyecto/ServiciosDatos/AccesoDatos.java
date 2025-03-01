/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.ServiciosDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author empre
 */
public class AccesoDatos {

    protected Connection conector;

    private String host = "localhost";
    private String user = "root";
    private String pass = "J0620"; //Agregar su contraseña de su base de datos
    private String puerto = "3306";
    private String esquemas = "grupoproyecto"; // Agregar su tabla de la base de datos

    public void Conectar() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conector = DriverManager.getConnection("jdbc:mysql://" + host + ":" + puerto + "/" + esquemas + "?serverTimezone=UTC", user, pass);

    }

    public void cerrarConexion() {
        try {
            if (this.getConector() != null && !this.getConector().isClosed()) {
                this.getConector().close();
                this.conector = null;
            }
        } catch (SQLException e) {
            System.out.print(" ERROR " + e);
        }
    }
    
    public void cerrarPrepared(PreparedStatement prepared) {
        try {
            if (prepared != null && !prepared.isClosed()) {
                prepared.close();
                prepared = null;
            }
        } catch (SQLException e) {
            System.out.print(" ERROR " + e);
        }
    }

    public void cerrarResult(ResultSet result) {
        try {
            if (result != null && !result.isClosed()) {
                result.close();
                result = null;
            }
        } catch (SQLException e) {
            System.out.print(" ERROR " + e);
        }
    }

    public Connection getConector() {
        return conector;
    }

    public void setConector(Connection conector) {
        this.conector = conector;
    }
}
