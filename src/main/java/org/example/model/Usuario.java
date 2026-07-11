package org.example.model;

import org.example.exception.ProductoNotFound;
import org.example.model.Producto;
import org.example.Tienda;

import java.util.HashMap;
import java.util.Scanner;
public class Usuario {
    private  int id_usuario ;
    private String nombre;
    private double saldo;
    private HashMap<Producto,Integer> producto_usuario=new HashMap<>();

    public Usuario(int id_usuario,String nombre,double saldo){
      this.id_usuario=id_usuario;
      this.nombre=nombre;
      this.saldo=saldo;
    }

    public double getSaldo(){
        return saldo;
    }

    public void descontarSaldo(double cantidad) {
        this.saldo -= cantidad;
    }


    public void agregarProductoComprado(Producto producto,int cantidad){
        producto_usuario.put(producto,producto_usuario.getOrDefault(producto,0)+cantidad);
    }



    public void eliminar_producto_comprado(String producto){
         for (Producto p:producto_usuario.keySet()){
             if(p.getNombre().equals(producto)){
                 producto_usuario.remove(p);
                 break;
             }
         }
    }




    public HashMap<Producto, Integer> ver_mi_lista(){
       return new HashMap<>(producto_usuario);
    }


}
