/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.util.List;

import entities.Venta;
import entities.Cliente;
import entities.VentaDetalle;

import javax.ws.rs.POST;
import javax.ws.rs.PathParam;

@Path("ventas")
public class VentaResource {
    static Ventadao dao = new Ventadao();

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Venta> listarVentas() {
        System.out.println("Listar todas las ventas");
        Venta venta = new Venta();
        Cliente cliente = new Cliente();
        cliente.setNombre("rodrigp");
        cliente.setCi("122");
        venta.setComprador(cliente);
        venta.setId(12);
         dao.create(venta);
        return dao.listar();
    }

    @Path("ultimaVenta")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Venta listarUltimaVenta() {
        System.out.println("Lista la ultima venta");
        return dao.listarUVenta();
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Venta addVenta(Venta venta) {
        
        System.out.println("Creando VENTA" ) ;
        return dao.create(venta);
    }
    
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Venta updateVenta(VentaDetalle ventadetalle, @PathParam("id") int venta_id) {
        System.out.println("Actualizando  Venta:");
        return dao.update(ventadetalle, venta_id);
        
    }

    @Path("{id}")
    @DELETE
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deleteVenta(@PathParam("id") int id) {
        System.out.println("Eliminando Venta con id :" + id);
        
        
        dao.delete(id);
    }

}
