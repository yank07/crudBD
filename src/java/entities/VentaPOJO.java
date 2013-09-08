/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.ArrayList;
import java.util.List;


public class Venta {
    private int id;
    private Cliente comprador;
    private List<VentaDetalle> detalles = new ArrayList();
    private int total=0;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getComprador() {
        return comprador;
    }

    public void setComprador(Cliente comprador) {
        this.comprador = comprador;
    }

    public List<VentaDetalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(VentaDetalle ventadetalle) {
        System.out.println("setee la lista detalle");
        this.detalles.add(ventadetalle);
        this.total=this.total+ventadetalle.getPrecio()*ventadetalle.getCant_venta();
        System.out.println("setee la lista detalle");
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
}
