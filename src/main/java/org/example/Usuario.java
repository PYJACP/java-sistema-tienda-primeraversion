package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class Usuario {
    public int id_usuario ;
    public String nombre;
    public double saldo;
    public HashMap<Producto,Integer> producto_usuario=new HashMap<>();

    public Usuario(int id_usuario,String nombre,double saldo){
      this.id_usuario=id_usuario;
      this.nombre=nombre;
      this.saldo=saldo;
    }

    public void agregar_producto(Tienda t ){
        Scanner sc=new Scanner(System.in);
        System.out.println("Deseas agregar un producto?");
        String confirmacion=sc.next();
        if(confirmacion.equalsIgnoreCase("SI")){
           System.out.println("Que producto queires agregar");
            String producto= sc.next();
            System.out.println("Que cantidad quieres agregar");
            int cantidad=sc.nextInt();
            while(cantidad<=0){
                System.out.println("La cantidad debe ser mayor a 0");
                cantidad=sc.nextInt();
            }
            for(Producto p:t.registar_producto){
                if(p.getNombre().equals(producto)){
                    if( saldo>=p.getprecio()*cantidad){
                        Producto pr=t.venta(p.getid(),cantidad);
                       if(pr!=null){
                        saldo=saldo-p.getprecio()*cantidad;
                        producto_usuario.put(pr,producto_usuario.getOrDefault(pr,0)+cantidad);
                        }
                        break;
                    }else{
                        System.out.println("Saldo insuficiente");
                    }

                }
            }
        }
    }

    public void eliminar_producto(){
     Scanner sc=new Scanner(System.in);
     System.out.println("Escriba el producto q desea eliminar");
         String producto = sc.next();
         for (Producto p:producto_usuario.keySet()){
             if(p.getNombre().equals(producto)){
                 producto_usuario.remove(p);
                 break;
             }
         }
    }


    public void remplazar_producto(){
       Scanner sc=new Scanner(System.in);
       System.out.println("Eliga el producto a remplazar");
      String remplazo=sc.next();
        System.out.println("Eliga la cantidad");
        int remplazo_cantidad=sc.nextInt();
     while(remplazo_cantidad<=0){
         System.out.println("Debe ser mayor a 0 la cantidad cantidad");
         remplazo_cantidad=sc.nextInt();
     }
      for(Producto p: producto_usuario.keySet()){
          if(p.getNombre().equals(remplazo)){
              producto_usuario.put(p,remplazo_cantidad);
              System.out.println("Producto remplazado con exito"+p);
              break;
          }
      }

    }

    public void ver_mi_lista(){
       for(Producto p:producto_usuario.keySet()){
           System.out.println("Nombre: "+ p.getNombre() + "cantidad: " + producto_usuario.get(p));
       }

    }


}
