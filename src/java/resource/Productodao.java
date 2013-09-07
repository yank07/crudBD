/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resource;

import entities.Producto;
            
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cynthia
 */
public class Productodao {

    static List<Producto> listaProducto = new ArrayList<Producto>();
    int contador_id= 1;
    Producto actual ;
    
    
    Producto create(Producto producto) {
        producto.setId(contador_id);
        contador_id++;
        listaProducto.add(producto);//return boolean
        System.out.println("Producto ya creado" + producto.getNombre() + "y su id es " + contador_id);
        System.out.println("elementos en la listaProducto " + listaProducto.size());
        
        return producto;
    }

    List<Producto> listar() {
        return listaProducto;
    }

    Producto listarPorId(int id_producto) {
        System.out.println("Cliente a retornar"+ listaProducto.size() );
        for (int i = 0; i < listaProducto.size(); i++) {
            System.out.println(i+ "="+ listaProducto.get(i).getId()+"?" );
            if (id_producto == listaProducto.get(i).getId()){
                System.out.println("Cliente encontrando, retornando " + listaProducto.get(i).getNombre());
                
                actual= listaProducto.get(i);
                
            }
            
        }
        return actual;
    }
 
    

    Producto update(Producto producto) {
       System.out.println("Producto a actualizar"+ listaProducto.size() );
        for (int i = 0; i < listaProducto.size(); i++) {
            System.out.println(i+ "="+ listaProducto.get(i).getId()+"?" );
            if (producto.getId() == listaProducto.get(i).getId() ){
                
                listaProducto.set(i, producto);
                System.out.println("Producto Actualizado " + producto.getNombre());
                
            }
            
        }
        return producto;
    }

    void delete(int id) {
        System.out.println("Producto a eliminar"+ listaProducto.size() );
        for (int i = 0; i < listaProducto.size(); i++) {
            System.out.println(i+ "="+ listaProducto.get(i).getId()+"?" );
            if (id == listaProducto.get(i).getId() ){
                
                listaProducto.remove(i);
                System.out.println("Producto elimindado el tamaño de la listaProducto es " + listaProducto.size());
                
            }
            
        }
        
    }
}
