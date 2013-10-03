/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resource;

import entities.PagoPOJO;
import entities.VentaPOJO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marco
 */
public class Pagodao {

    static List<PagoPOJO> listaPago = new ArrayList<PagoPOJO>();
    static int cont_id=1;
    PagoPOJO actual;

    
    List<PagoPOJO> listar() {
        return listaPago;
    }

    PagoPOJO create(PagoPOJO pago) {
        pago.setId(cont_id);
        listaPago.add(pago);
        cont_id++;
        
        return pago;
    }

    PagoPOJO updateContado(VentaPOJO venta, int id_pago) {
       System.out.println("Pago a actualizar"+ listaPago.size() );
        for (int i = 0; i < listaPago.size(); i++) {
            System.out.println(i+ "="+ listaPago.get(i).getId()+"?" );
            if (id_pago == listaPago.get(i).getId() ){
                actual=listaPago.get(i);
                actual.setVenta(venta);
                actual.setForma_pago(0);
              //  listaVenta.set(i, venta);
                System.out.println("Venta Actualizada " + id_pago);
                
            }
            
        }
        return actual;


    }
    
    PagoPOJO updateCredito(VentaPOJO venta, int id_pago, int cuotas) {
       System.out.println("Pago a actualizar"+ listaPago.size() );
        for (int i = 0; i < listaPago.size(); i++) {
            System.out.println(i+ "="+ listaPago.get(i).getId()+"?" );
            if (id_pago == listaPago.get(i).getId() ){
                actual=listaPago.get(i);
                actual.setVenta(venta);
                actual.setCuotas(cuotas);
                actual.setForma_pago(1);
              //  listaVenta.set(i, venta);
                System.out.println("Venta Actualizada " + id_pago);
                
            }
            
        }
        return actual;

    }

    void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
