/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resource;

import Facade.ProductoFacade;
import Facade.VentaFacade;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.util.List;

import entities.VentaPOJO;
import entities.ClientePOJO;
import entities.Producto;
import entities.Venta;
import entities.VentaDetallePOJO;
import javax.ejb.EJB;

import javax.ws.rs.POST;
import javax.ws.rs.PathParam;

@Path("ventas")
public class VentaResource {
    static Ventadao dao = new Ventadao();
    
     @EJB
   VentaFacade mgr;
   Venta venta = new Venta();

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<VentaPOJO> listarVentas() {
        System.out.println("Listar todas las ventas");
        VentaPOJO venta = new VentaPOJO();
        ClientePOJO cliente = new ClientePOJO();
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
    public VentaPOJO listarUltimaVenta() {
        System.out.println("Lista la ultima venta");
        return dao.listarUVenta();
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Venta addVenta(Venta venta) {
        
        System.out.println("Creando VENTA" ) ;
         mgr.create(venta);
         return venta;
    }
    
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public VentaPOJO updateVenta(VentaDetallePOJO ventadetalle, @PathParam("id") int venta_id) {
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
