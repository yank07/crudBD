
package resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.util.List;

import entities.VentaDetallePOJO;

import javax.ws.rs.POST;
import javax.ws.rs.PathParam;


@Path("ventadetalles")
public class VentaDetalleResource {

   static VentaDetalledao dao = new VentaDetalledao();

   
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<VentaDetallePOJO> listarVentaDetalles() {
        System.out.println("Listar todos los detalles de ventas");

        return dao.listar();
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public VentaDetallePOJO addVentaDetalle(VentaDetallePOJO ventadetalle) {
        System.out.println("Creando VentaDetalle:" ) ;
        return dao.create(ventadetalle);
    }
    
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public VentaDetallePOJO updateVentaDetalle(VentaDetallePOJO ventadetalle) {
        System.out.println("Actualizando  VentaDetalle:");
        return dao.update(ventadetalle);
        
    }
    
   @Path("{id}")
    @DELETE
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deleteVentaDetalle(@PathParam("id") int id) {
        System.out.println("Eliminando VentaDetalle con id :" + id);
        
        
        dao.delete(id);
    }
}
