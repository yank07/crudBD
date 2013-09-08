/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resource;

import entities.ClientePOJO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cynthia
 */
public class Clientedao {

    static List<ClientePOJO> listaCliente = new ArrayList<ClientePOJO>();
    int contador_id= 1;
    ClientePOJO actual;
    
    List<ClientePOJO> listar() {
        return listaCliente;
    }

    ClientePOJO listarPorCi(int id_cliente) {
        System.out.println("Cliente a retornar"+ listaCliente.size() );
        for (int i = 0; i < listaCliente.size(); i++) {
            System.out.println(i+ "="+ listaCliente.get(i).getCi()+"?" );
            if (id_cliente == Integer.parseInt(listaCliente.get(i).getCi())){
                System.out.println("Cliente encontrando, retornando " + listaCliente.get(i).getNombre());
                
                actual= listaCliente.get(i);
                
            }
            
        }
        return actual;
    }
    
    ClientePOJO create(ClientePOJO cliente) {
        cliente.setId(contador_id);
        listaCliente.add(cliente);//return boolean
        contador_id++;
        System.out.println("Cliente ya creado" + cliente.getNombre() + "y su id es " + contador_id);
        System.out.println("elementos en la lista " + listaCliente.size());
        
        return cliente;
    }

 
    

    ClientePOJO update(ClientePOJO cliente) {
       System.out.println("Cliente a actualizar"+ listaCliente.size() );
        for (int i = 0; i < listaCliente.size(); i++) {
            System.out.println(i+ "="+ listaCliente.get(i).getId()+"?" );
            if (cliente.getId() == listaCliente.get(i).getId() ){
                
                listaCliente.set(i, cliente);
                System.out.println("Cliente Actualizado " + cliente.getNombre());
                
            }
            
        }
        return cliente;
    }

    void delete(int id) {
        System.out.println("Cliente a eliminar"+ listaCliente.size() );
        for (int i = 0; i < listaCliente.size(); i++) {
            System.out.println(i+ "="+ listaCliente.get(i).getId()+"?" );
            if (id == listaCliente.get(i).getId() ){
                
                listaCliente.remove(i);
                System.out.println("Cliente elimindado el tamaño de la lista es " + listaCliente.size());
                
            }
            
        }
        
    }

}
