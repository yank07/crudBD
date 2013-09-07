/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resource;

import entities.Venta;
import entities.VentaDetalle;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marco
 */
public class Ventadao {
    
    static List<Venta> listaVenta = new ArrayList<Venta>();
    static int cont_id=1;
    Venta actual;
    
    List<Venta> listar() {
        return listaVenta;
        }

    Venta create(Venta venta) {
        venta.setId(cont_id);
        listaVenta.add(venta);
        cont_id++;
        
        return venta;
    }

    Venta update(VentaDetalle ventadetalle, int venta_id) {
       System.out.println("Venta detalle a actualizar "+ listaVenta.size() + " el id de la venta es  " +  venta_id);
        for (int i = 0; i < listaVenta.size(); i++) {
            System.out.println(i + "="+ listaVenta.get(i).getId()+"?" );
            if (venta_id == listaVenta.get(i).getId() ){
                System.out.println("ya encontro la venta" );
                actual=listaVenta.get(i);
                System.out.println("ya asigno actual" );
                actual.setDetalles(ventadetalle);
              //  listaVenta.set(i, venta);
                System.out.println("Venta Actualizada " + venta_id);
                
            }
            
        }
        return actual;

    }

    void delete(int id) {
        System.out.println("Venta a eliminar"+ listaVenta.size() );
        for (int i = 0; i < listaVenta.size(); i++) {
            System.out.println(i+ "="+ listaVenta.get(i).getId()+"?" );
            if (id == listaVenta.get(i).getId() ){
                
                listaVenta.remove(i);
                System.out.println("Venta elimindado el tamaño de la lista es " + listaVenta.size());
                
            }
            
        }
    }

    Venta listarUVenta() {
        System.out.println(" cantidad de Venta  " + listaVenta.size());
        actual = listaVenta.get(listaVenta.size()-1);
        return actual;
    }
    
}
