
package resource;

import entities.ProductoPOJO;
import entities.VentaDetallePOJO;
import java.util.List;
import java.util.ArrayList;

public class VentaDetalledao {

    static List<VentaDetallePOJO> listaVentaDetalle = new ArrayList<VentaDetallePOJO>();
//    static Productodao productodao= new Productodao();
    ProductoPOJO producto;
    static int cant_vd=1;
    
    List<VentaDetallePOJO> listar() {
        return listaVentaDetalle;
    }

    VentaDetallePOJO create(VentaDetallePOJO ventadetalle) {
       ventadetalle.setId(cant_vd);
       listaVentaDetalle.add(ventadetalle);
       cant_vd++;
       
       return ventadetalle;
    }

    VentaDetallePOJO update(VentaDetallePOJO ventadetalle) {
       System.out.println("Venta detalle a actualizar"+ listaVentaDetalle.size() );
        for (int i = 0; i < listaVentaDetalle.size(); i++) {
            System.out.println(i+ "="+ listaVentaDetalle.get(i).getId()+"?" );
            if (ventadetalle.getId() == listaVentaDetalle.get(i).getId() ){
                
                listaVentaDetalle.set(i, ventadetalle);
                System.out.println("Venta detalle Actualizado " + ventadetalle.getId());
                
            }
            
        }
        return ventadetalle;
    }

    void delete(int id) {
        System.out.println("VentaDetalle a eliminar"+ listaVentaDetalle.size() );
        for (int i = 0; i < listaVentaDetalle.size(); i++) {
            System.out.println(i+ "="+ listaVentaDetalle.get(i).getId()+"?" );
            if (id == listaVentaDetalle.get(i).getId() ){
                
                listaVentaDetalle.remove(i);
                System.out.println("VentaDetalle elimindado el tamaño de la lista es " + listaVentaDetalle.size());
                
            }
            
        }
        
    }


    
}
