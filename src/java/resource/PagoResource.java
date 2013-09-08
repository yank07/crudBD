/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resource;

import entities.Pago;
import entities.VentaPOJO;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.util.List;


import javax.ws.rs.POST;
import javax.ws.rs.PathParam;

/**
 *
 * @author Marco
 */

@Path("pagos")
public class PagoResource {
    
    static Pagodao dao = new Pagodao();
    
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Pago> listarPagos() {
        System.out.println("Listar todos los pagos");

        return dao.listar();
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Pago addPago(Pago pago) {
        System.out.println("Creando Pago") ;
        return dao.create(pago);
    }

    @PUT
    @Path("{id}/{formadepago}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Pago updatePago(VentaPOJO venta, @PathParam("id") int id_pago) {
        
        System.out.println("Actualizando  Pago:");
        return dao.updateContado(venta, id_pago);
    }

    @PUT
    @Path("{id}/{formadepago}/{cuotas}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Pago updatePagoCredito(VentaPOJO venta, @PathParam("id") int id_pago, @PathParam("cuotas") int cuotas) {
        
        System.out.println("Actualizando  Pago:");
        return dao.updateCredito(venta, id_pago, cuotas);
    }
    
    @Path("{id}")
    @DELETE
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deleteVenta(@PathParam("id") int id) {
        System.out.println("Eliminando Pago con id :" + id);
        
        
        dao.delete(id);
    }


}
