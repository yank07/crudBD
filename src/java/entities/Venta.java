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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Cynthia
 */
@Entity

public class Venta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    @Column(name = "id_venta")
    private int id_venta;
    
    @Column(name = "total_venta")
    private int total=0;

    @JoinColumn(name="id_cliente", referencedColumnName="id_cliente")
    @ManyToOne(optional=false)
    Cliente clienteId;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ventaId")
    List <VentaDetalle> detalles;

    public int getId() {
        return id_venta;
    }

    public void setId(int id) {
        this.id_venta = id;
    }
    
  

   

   

    @Override
    public String toString() {
        return "entities.Venta[ id=" + id_venta + " ]";
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return clienteId;
    }

    public void setCliente(Cliente cliente) {
        this.clienteId = cliente;
    }

    
    public List<VentaDetalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<VentaDetalle> detalles) {
        this.detalles = detalles;
    }

    
    
}
