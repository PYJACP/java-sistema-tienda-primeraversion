package org.example.repository;

import com.sun.source.tree.ReturnTree;
import org.example.model.Producto;
import org.example.exception.ProductoNotFound;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProductoRepository {

    private ArrayList<Producto> registar_producto=new ArrayList<Producto>();
    public ProductoRepository(){

   }
    public Producto buscar_por_nombre(String nombre) {
        for(int y=0;y<=registar_producto.size()-1;y++){
            if(registar_producto.get(y)!=null && registar_producto.get(y).getNombre().equals(nombre)){
                    return registar_producto.get(y);
            }
        }
        throw new  ProductoNotFound("Producto NO encontrado: "+nombre);
    }


    public void agregar_producto(Producto p){
        registar_producto.add(p);
    }

    public void remplazar_producto(String nombre,Producto p){
        for(int i=0;i<=registar_producto.size()-1;i++){
            if(registar_producto.get(i).getNombre().equals(nombre)){
                registar_producto.set(i,p);
                break;
            }

        }
    }

    public void eliminar_producto(String nombre){
        for(int a=0;a<=registar_producto.size()-1;a++){
            if(nombre.equals(registar_producto.get(a).nombre)){
                registar_producto.remove(a);
                return;
            }
        }

    }

    public Producto BuscarID(int id){
        for(int o=0;o<=registar_producto.size()-1;o++){
            if(registar_producto.get(o).getid()==id){
              return  registar_producto.get(o);
            }
        }
        throw new ProductoNotFound("El producto no se encontro, intentalo de nuevo");
    }


    public List<Producto> Obtenertodos(){
       return new ArrayList<>(registar_producto);

    }


}
