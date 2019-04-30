/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import control.ConnectBD;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author User
 */
public class Cliente {
    String idCliente;
    String NombreC;
    String ApellidoC;
    String correoC;

    public Cliente(String idCliente, String NombreC, String ApellidoC, String correoC) {
        this.idCliente = idCliente;
        this.NombreC = NombreC;
        this.ApellidoC = ApellidoC;
        this.correoC = correoC;
    }

    public Cliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreC() {
        return NombreC;
    }

    public void setNombreC(String NombreC) {
        this.NombreC = NombreC;
    }

    public String getApellidoC() {
        return ApellidoC;
    }

    public void setApellidoC(String ApellidoC) {
        this.ApellidoC = ApellidoC;
    }

    public String getCorreoC() {
        return correoC;
    }

    public void setCorreoC(String correoC) {
        this.correoC = correoC;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", NombreC=" + NombreC + ", ApellidoC=" + ApellidoC + ", correoC=" + correoC + '}';
    }

    public boolean buscarPeliculas(String SQL) {
        ConnectBD objCon = new ConnectBD();
        boolean f = false;

        if (objCon.crearConexion()) {
        try {
        Statement sentencia = objCon.getConexion().createStatement();
        sentencia.executeUpdate(SQL);
        f = true;
        
        } catch (SQLException ex) {
        ex.printStackTrace();
        f = false;
        }
        
        }
        return f;
    }
}
