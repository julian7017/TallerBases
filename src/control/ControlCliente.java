/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import modelo.Cliente;

/**
 *
 * @author User
 */
public class ControlCliente {

    public boolean BuscarPeli(Cliente objC) {
        boolean t = false;
        String SQL = "Select f.film_id, f.title, f.description, f.release_year   from film f, inventory i, rental r, customer c WHERE f.film_id = i.film_id AND i.inventory_id = r.inventory_id AND r.customer_id = c.customer_id AND c.customer_id = "
                + objC.getIdCliente() + " ;";
                
        t = objC.buscarPeliculas(SQL);
        
        return t;
    }
    
}
