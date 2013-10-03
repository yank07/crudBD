/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Cynthia
 */
@Entity

public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_producto")
    private Integer id_producto;
    
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "cantidad")
    private int cantidad;
    
    @Column(name = "precio")
    private int precio;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productoId")
    private List<VentaDetalle> listaVentaDetalles;
    
    public Integer getId() {
        return id_producto;
    }

    public void setId(Integer id) {
        this.id_producto = id;
    }

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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_producto != null ? id_producto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.id_producto == null && other.id_producto != null) || (this.id_producto != null && !this.id_producto.equals(other.id_producto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Producto[ id=" + id_producto + " ]";
    }
    
}
