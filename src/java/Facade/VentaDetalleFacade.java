/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entities.Venta;
import entities.VentaDetalle;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Cynthia
 */
@Stateless
public class VentaDetalleFacade extends AbstractFacade<VentaDetalle> {
    @PersistenceContext(unitName = "CRUDPU")
    private EntityManager em;
    Venta ventaReturn=new Venta();
    List<VentaDetalle> details= new ArrayList<VentaDetalle>();
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VentaDetalleFacade() {
        super(VentaDetalle.class);
    }

    public Venta armarVista(Venta ventaVista) {
        int idatraer;
        idatraer = ventaVista.getId();
        

        return ventaReturn;
    }
    
}
