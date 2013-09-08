/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entities.VentaDetalle;
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

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VentaDetalleFacade() {
        super(VentaDetalle.class);
    }
    
}
