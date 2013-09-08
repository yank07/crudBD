/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.ArrayList;
import java.util.List;


public class VentaPOJO {
    private int id;
    private ClientePOJO comprador;
    private List<VentaDetallePOJO> detalles = new ArrayList();
    private int total=0;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClientePOJO getComprador() {
        return comprador;
    }

    public void setComprador(ClientePOJO comprador) {
        this.comprador = comprador;
    }

    public List<VentaDetallePOJO> getDetalles() {
        return detalles;
    }

    public void setDetalles(VentaDetallePOJO ventadetalle) {
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
