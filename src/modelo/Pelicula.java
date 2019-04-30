/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import control.ConnectBD;
import java.io.File;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author lab.informatica
 */
public class Pelicula {
    
    String idPelicula;
    String titulo;
    String descripcion;
    String lanzamiento;
    String idLenguaje;
    String duracionAlquiler;
    String tasa;
    String duracionPelicula;
    String costo;
    String categoria;
    String caracteristicas;
    String ultimaactualizacion;

    public Pelicula(String idPelicula, String titulo, String descripcion, String lanzamiento, String idLenguaje, String duracionAlquiler, String tasa, String duracionPelicula, String costo, String categoria, String caracteristicas, String ultimaactualizacion) {
        this.idPelicula = idPelicula;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.lanzamiento = lanzamiento;
        this.idLenguaje = idLenguaje;
        this.duracionAlquiler = duracionAlquiler;
        this.tasa = tasa;
        this.duracionPelicula = duracionPelicula;
        this.costo = costo;
        this.categoria = categoria;
        this.caracteristicas = caracteristicas;
        this.ultimaactualizacion = ultimaactualizacion;
    }

    public Pelicula(String titulo, String descripcion, String lanzamiento, String idLenguaje, String duracionAlquiler, String tasa, String duracionPelicula, String costo, String categoria, String caracteristicas) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.lanzamiento = lanzamiento;
        this.idLenguaje = idLenguaje;
        this.duracionAlquiler = duracionAlquiler;
        this.tasa = tasa;
        this.duracionPelicula = duracionPelicula;
        this.costo = costo;
        this.categoria = categoria;
        this.caracteristicas = caracteristicas;
    }

    public Pelicula() {
    }

    public Pelicula(String idPelicula, String titulo, String descripcion, String lanzamiento, String duracionAlquiler, String costo) {
        this.idPelicula = idPelicula;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.lanzamiento = lanzamiento;
        this.duracionAlquiler = duracionAlquiler;
        this.costo = costo;
    }

    public String getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(String idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLanzamiento() {
        return lanzamiento;
    }

    public void setLanzamiento(String lanzamiento) {
        this.lanzamiento = lanzamiento;
    }

    public String getIdLenguaje() {
        return idLenguaje;
    }

    public void setIdLenguaje(String idLenguaje) {
        this.idLenguaje = idLenguaje;
    }

    public String getDuracionAlquiler() {
        return duracionAlquiler;
    }

    public void setDuracionAlquiler(String duracionAlquiler) {
        this.duracionAlquiler = duracionAlquiler;
    }

    public String getTasa() {
        return tasa;
    }

    public void setTasa(String tasa) {
        this.tasa = tasa;
    }

    public String getDuracionPelicula() {
        return duracionPelicula;
    }

    public void setDuracionPelicula(String duracionPelicula) {
        this.duracionPelicula = duracionPelicula;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getUltimaactualizacion() {
        return ultimaactualizacion;
    }

    public void setUltimaactualizacion(String ultimaactualizacion) {
        this.ultimaactualizacion = ultimaactualizacion;
    }
    
    public boolean insertarPeliculas(Pelicula pel, String insertarSQL) {

        ConnectBD CBD = new ConnectBD();
        
        PreparedStatement ps = null;
        boolean f = false;

        try {

            if (CBD.crearConexion()) {

                CBD.getConexion().setAutoCommit(false);

                
               
                ps = CBD.getConexion().prepareStatement(insertarSQL);

                ps.setString(1, pel.getTitulo());
                ps.setString(2, pel.getDescripcion());
                ps.setString(3, pel.getLanzamiento());
                ps.setString(4, pel.getIdLenguaje());
                ps.setString(5, pel.getDuracionAlquiler());
                ps.setString(6, pel.getTasa());
                ps.setString(7, pel.getDuracionPelicula());
                ps.setString(8, pel.getCosto());
                ps.setString(9, pel.getCategoria());
                ps.setString(10, pel.getCaracteristicas());
               
                
                ps.executeUpdate();

                CBD.getConexion().commit();

                f = true;

            }//Fin if

        } catch (Exception ex) {

            f = false;
            JOptionPane.showMessageDialog(null, "Error al guardar los datos1: " + ex, "Error", JOptionPane.ERROR_MESSAGE);

        } finally {

            try {

                ps.close();
             

            } catch (Exception e) {

                f = false;
                JOptionPane.showMessageDialog(null, "Error al guardar los datos2: " + e, "Error", JOptionPane.ERROR_MESSAGE);

            }//Fin catch2

        }//Fin finally

        return f;

    }

    public boolean modificarPelicula(Pelicula pel, String SQL) {
        ConnectBD objCon = new ConnectBD();
        boolean f = false;
        PreparedStatement ps = null;

      
        try {
              if (objCon.crearConexion()) {
        //Statement sentencia = objCon.getConexion().createStatement();
        //sentencia.executeUpdate(SQL);
        //f = true;
                objCon.getConexion().setAutoCommit(false);
                        ps = objCon.getConexion().prepareStatement(SQL);
        
               
                ps.setString(1, pel.getTitulo());
                ps.setString(2, pel.getDescripcion());
                ps.setString(3, pel.getLanzamiento());
                ps.setString(4, pel.getDuracionAlquiler());
                ps.setString(5, pel.getCosto());
                
                
                ps.executeUpdate();

                objCon.getConexion().commit();

                f = true;
        
        }
        }  catch (Exception ex) {

            f = false;
            JOptionPane.showMessageDialog(null, "Error al guardar los datos1: " + ex, "Error", JOptionPane.ERROR_MESSAGE);

        } finally {

            try {

                ps.close();

            } catch (Exception e) {

                f = false;
                JOptionPane.showMessageDialog(null, "Error al guardar los datos2: " + e, "Error", JOptionPane.ERROR_MESSAGE);

            }//Fin catch2

        }//Fin try inicial

        return f;
        
    }
    

}
