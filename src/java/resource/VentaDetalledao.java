
package resource;

import entities.Producto;
import entities.VentaDetalle;
import java.util.List;
import java.util.ArrayList;

public class VentaDetalledao {

    static List<VentaDetalle> listaVentaDetalle = new ArrayList<VentaDetalle>();
//    static Productodao productodao= new Productodao();
    Producto producto;
    static int cant_vd=1;
    
    List<VentaDetalle> listar() {
        return listaVentaDetalle;
    }

    VentaDetalle create(VentaDetalle ventadetalle) {
       ventadetalle.setId(cant_vd);
       listaVentaDetalle.add(ventadetalle);
       cant_vd++;
       
       return ventadetalle;
    }

    VentaDetalle update(VentaDetalle ventadetalle) {
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
