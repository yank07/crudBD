package resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import entities.ProductoPOJO;

import java.util.List;


import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import static resource.ProductoResource.dao;

@Path("productos")
public class ProductoResource {

   static Productodao dao = new Productodao();

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<ProductoPOJO> listarProductos() {
        System.out.println("Listar todos los productos");

        return dao.listar();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public ProductoPOJO addProducto(ProductoPOJO producto) {
        System.out.println("Creando Producto:" + producto.getNombre());
        return dao.create(producto);
    }
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public ProductoPOJO updateProducto(ProductoPOJO producto) {
        System.out.println("Actualizando  Producto:" + producto.getNombre());
        return dao.update(producto);
        
    }
     
   @Path("{id}")
    @DELETE
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deleteProducto(@PathParam("id") int id) {
        System.out.println("Eliminando Producto con id :" + id);
        
        
        dao.delete(id);
    }
    
}
