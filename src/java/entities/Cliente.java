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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cynthia
 */
@Entity

public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id_cliente")
    private Integer id_cliente;
    
    @Column(name = "nombre")    
    private String nombre;
    
    @Column(name = "direccion")
    private String direccion;
    
    @Column(name = "ci")
    private String ci;

    
   

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }


   
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
        return id_cliente;
    }

    public void setId(int id) {
        this.id_cliente = id;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_cliente != null ? id_cliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.id_cliente == null && other.id_cliente != null) || (this.id_cliente != null && !this.id_cliente.equals(other.id_cliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ClienteEntity[ id=" + id_cliente + " ]";
    }
}
