/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author julian_david.escobar
 */
public class ConnectBD {
    
    Connection conexion;
    Statement st;
    
     public ConnectBD() {
        //conexion
    }
     public Connection getConexion() {
        return conexion;
    }

    public Statement getSt() {
        return st;
    }
    
    public boolean crearConexion() {
        
        //Es muy importante colocar en conexión el nombre de la base de datos y posteriormente colocar el nombre del usuario y la contraseña de la BD
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");                                           //user  //pass
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "root");
            st = conexion.createStatement();
        
        } catch (SQLException ex) {
        
            ex.printStackTrace();
            return false;
        
        } catch (ClassNotFoundException ex) {
        
            ex.printStackTrace();
            return false;
       
        }

        return true;
        
    }
    
}
