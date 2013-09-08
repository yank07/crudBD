/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entities.Venta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Cynthia
 */
@Stateless
public class VentaFacade extends AbstractFacade<Venta> {
    @PersistenceContext(unitName = "CRUDPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VentaFacade() {
        super(Venta.class);
    }
    
}
