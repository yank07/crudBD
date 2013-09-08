/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Cynthia
 */
@Stateless
public class ControlCliente {
    @PersistenceContext(unitName="CRUDPU")
    EntityManager em;
    
}
