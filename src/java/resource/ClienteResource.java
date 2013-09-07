package resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import entities.Cliente;

import java.util.List;


import javax.ws.rs.POST;
import javax.ws.rs.PathParam;

@Path("clientes")
public class ClienteResource {

   static Clientedao dao = new Clientedao();

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Cliente> listarClientes() {
        System.out.println("Listar todos los clientes");

        return dao.listar();
    }

    @GET @Path("{ci}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Cliente listarClientePorCi(@PathParam("ci") String ci) {
            System.out.println("findByCi " + ci);
            return dao.listarPorCi(Integer.parseInt(ci));
    }    
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Cliente addCliente(Cliente cliente) {
        System.out.println("Creando Cliente:" + cliente.getNombre());
        return dao.create(cliente);
    }
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Cliente updateCliente(Cliente cliente) {
        System.out.println("Actualizando  Cliente:" + cliente.getNombre());
        return dao.update(cliente);
        
    }
     
   @Path("{id}")
    @DELETE
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deleteCliente(@PathParam("id") int id) {
        System.out.println("Eliminando Cliente con id :" + id);
        
        
        dao.delete(id);
    }
    
}
