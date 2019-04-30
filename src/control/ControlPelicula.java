/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import modelo.Pelicula;

/**
 *
 * @author lab.informatica
 */
public class ControlPelicula {
    public boolean InsertarPelicula(Pelicula pel) {

        boolean t = false;

        
        String insertarSQL = "call InsertarPelicula(?,?,?,?,?,?,?,?,?,?)";
        //String insertarSQL = "INSERT INTO film (title, description, release_year, language_id, rental_duration, rental_rate, length, replacement_cost, rating, special_features)"
          //      + "values(?,?,?,?,?,?,?,?,?,?)";

        t = pel.insertarPeliculas(pel, insertarSQL);

        return t;

    }
    public boolean ModificarPelicula(String idPelicula, Pelicula pel){
        
        boolean t = false;
        String SQL = "UPDATE film SET title = ?, description = ?, release_year = ?, rental_duration = ?, replacement_cost = ? WHERE film_id = '" + idPelicula + "'";
        
        t = pel.modificarPelicula(pel, SQL);
        
        return t;
    }

}
