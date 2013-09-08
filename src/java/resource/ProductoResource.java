package resource;

import Facade.ProductoFacade;
import entities.Producto;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import entities.ProductoPOJO;

import java.util.List;
import javax.ejb.EJB;


import javax.ws.rs.POST;
import javax.ws.rs.PathParam;


@Path("productos")
public class ProductoResource {

   static Productodao dao = new Productodao();
   @EJB
   ProductoFacade mgr;
   Producto producto = new Producto();
   
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Producto> listarProductos() {
        System.out.println("Listar todos los productos");

        return mgr.findAll();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Producto addProducto(Producto producto) {
        System.out.println("Creando Producto:" + producto.getNombre());
         mgr.create(producto);
         return producto;
    }
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Producto updateProducto(Producto producto) {
        System.out.println("Actualizando  Producto:" + producto.getNombre());
        mgr.edit(producto);
        return producto;
        
    }
     
   @Path("{id}")
    @DELETE
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deleteProducto(@PathParam("id") int id) {
        System.out.println("Eliminando Producto con id :" + id);
        
        
         producto = mgr.find(id);
        mgr.remove(producto);
    }
    
}
