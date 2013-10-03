/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cynthia
 */
@Entity

public class VentaDetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_ventadetalle")
    private Integer id_ventadetalle;
    @Column(name = "cant_venta")    
    private int cant_venta;

    @ManyToOne
    @JoinColumn(name="id_venta", referencedColumnName="id_venta")
    Venta ventaId;
    
    @ManyToOne
    @JoinColumn(name="id_producto", referencedColumnName="id_producto")
    Producto productoId;
    
    public Integer getId() {
        return id_ventadetalle;
    }

    public void setId(Integer id) {
        this.id_ventadetalle = id;
    }

    public int getCant_venta() {
        return cant_venta;
    }

    public void setCant_venta(int cant_venta) {
        this.cant_venta = cant_venta;
    }

    public Producto getProducto() {
        return productoId;
    }

    public void setProducto(Producto producto) {
        this.productoId = producto;
    }

    //public Venta getVenta() {
      //  return ventaId;
    //}

    public void setVenta(Venta venta) {
        this.ventaId = venta;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_ventadetalle != null ? id_ventadetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentaDetalle)) {
            return false;
        }
        VentaDetalle other = (VentaDetalle) object;
        if ((this.id_ventadetalle == null && other.id_ventadetalle != null) || (this.id_ventadetalle != null && !this.id_ventadetalle.equals(other.id_ventadetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.VentaDetalle[ id=" + id_ventadetalle + " ]";
    }
    
}
