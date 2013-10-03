/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resource;

import Facade.ProductoFacade;
import Facade.VentaDetalleFacade;
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
import entities.VentaDetalle;
import entities.VentaDetallePOJO;
import java.util.ArrayList;
import javax.ejb.EJB;

import javax.ws.rs.POST;
import javax.ws.rs.PathParam;

@Path("ventas")
public class VentaResource {
    static Ventadao dao = new Ventadao();
    
   @EJB
   VentaFacade mgr;     
   @EJB
   VentaDetalleFacade vdmgr;
   @EJB
   ProductoFacade prodmgr;
   
   Venta venta = new Venta();
   Venta ventaVista=new Venta();
   List<Venta> listaVenta =  new ArrayList <Venta>();
   
   private long vdId;
    private VentaDetalle ventadetalle2;

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
    public Venta listarUltimaVenta() {
        System.out.println("Lista la ultima venta");
        listaVenta= mgr.findAll();
        venta= listaVenta.get(listaVenta.size()-1);
        System.out.println(venta.getDetalles().toString());
        return venta;
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
    public Venta updateVenta(VentaDetalle ventadetalle, @PathParam("id") int venta_id) {
        System.out.println("Actualizando  Venta:");
        venta = mgr.find(venta_id);
        mgr.sumarTotal(venta,ventadetalle.getCant_venta()*ventadetalle.getProducto().getPrecio());
        ventadetalle.setVenta(venta);
        vdmgr.create(ventadetalle);
        
        //vdId = ventadetalle.getId();
       // venta = mgr.find(venta_id);
       // ventadetalle2 = vdmgr.find(vdId);
        //venta.agregarDetalle(ventadetalle);
       // mgr.edit(venta);
        
        ventaVista=vdmgr.armarVista(ventaVista);
        
        return ventaVista;
        
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
