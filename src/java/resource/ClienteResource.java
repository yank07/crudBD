package resource;

import Facade.ClienteFacade;
import entities.Cliente;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import entities.ClientePOJO;

import java.util.List;
import javax.ejb.EJB;


import javax.ws.rs.POST;
import javax.ws.rs.PathParam;

@Path("clientes")
public class ClienteResource {

   static Clientedao dao = new Clientedao();
   @EJB
   ClienteFacade mgr;
   
   Cliente cliente = new Cliente();

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Cliente> listarClientes() {
        System.out.println("Listar todos los clientes");

        return mgr.findAll();
    }

    @GET @Path("{ci}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Cliente listarClientePorCi(@PathParam("ci") String ci) {
            System.out.println("findByCi " + ci);
            return mgr.find(ci);
    }    
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Cliente addCliente(Cliente cliente) {
        System.out.println("Creando Cliente:" + cliente.getNombre());
         mgr.create(cliente);
         return cliente;
    }
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Cliente updateCliente(Cliente cliente) {
        System.out.println("Actualizando  Cliente:" + cliente.getNombre());
        mgr.edit(cliente);
        return cliente;
        
    }
     
   @Path("{id}")
    @DELETE
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deleteCliente(@PathParam("id") long id) {
        System.out.println("Eliminando Cliente con id :" + id);
        
        cliente = mgr.find(id);
        System.out.println("Ya traigo cliente Eliminar:" + cliente.getId());
    }
    
}
