/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Cynthia
 */
public class ProductoPOJO {
    private int id;
    private String nombre;
    private String descripcion;
    private int cantidad;
    private int precio;

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
        
}
