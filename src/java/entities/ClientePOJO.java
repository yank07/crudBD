/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * 
 * 
 * 
 * @author Cynthia
 */

public class ClientePOJO {
    //private int id;
 
    private int id;
    private String nombre;
    private String direccion;
    private String ci;
   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

  
    
}
