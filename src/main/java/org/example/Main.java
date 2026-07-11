package org.example;
import org.example.model.Producto;
import org.example.model.Usuario;
import org.example.repository.ProductoRepository;
import org.example.service.ProductoService;
import org.example.service.VentaService;

import java.util.Scanner;
//
////TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
//// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
  public static void main(String[] args) {
    System.out.println("Como te llamas");
    Scanner sc=new Scanner(System.in);

      Tienda t=new Tienda("cesar");
      System.out.println("Eres usuario o jefe de tienda?");
      String persona=sc.next();
      ProductoRepository pr = new ProductoRepository();
      Usuario usuario = new Usuario(1, "sebastian", 5000);
      VentaService vs=new VentaService(pr);
      ProductoService PS = new ProductoService(pr);
      if(persona.equalsIgnoreCase("jefe")) {
          System.out.println("Empezemos con el sistema de productos.Presione Si para continuar o no para detenerse");
          String continuar = sc.next();
          while (continuar.equalsIgnoreCase("si")) {
              System.out.println("Elige una opcion");
              System.out.println("Agregar un producto:1");
              System.out.println("Obtener la posible ganancia de un producto con mi actual stock:2");
              System.out.println("Busca un producto:3");
              System.out.println("Remplazar un producto:4");
              System.out.println("Eliminar un producto:5");
              int opcion = sc.nextInt();
              switch (opcion) {
                  case 1:
                      System.out.println("Agregaremos un producto...");
                      System.out.println("Ingresa el ID");
                      int id = sc.nextInt();
                      System.out.println("Escribe el producto nuevo");
                      String nombre_producto = sc.next();
                      System.out.println("Escribe el precio del producto");
                      double precio = sc.nextDouble();
                      System.out.println("Escribe la cantidad del producto");
                      int cantidad = sc.nextInt();
                      Producto p = new Producto(id, nombre_producto, precio, cantidad);
                      pr.agregar_producto(p);
                      break;
                  case 2:
                      System.out.println("Escribe el producto que deseas obtener su ganancia");
                      String produc = sc.next();
                      System.out.println(PS.gancia_venta(produc));
                      break;
                  case 3:
                      System.out.println("Escribe el producto que deseas buscar");
                      String nombre = sc.next();
                      System.out.println(pr.buscar_por_nombre(nombre));
                      break;
                  case 4:
                      System.out.println("Escribe el nombre del producto que quiereas remplazar");
                      nombre = sc.next();
                      System.out.println("Escribe el id del producto ");
                      id = sc.nextInt();
                      System.out.println("Escribe el nombre del producto ");
                      String producto_nuevo = sc.next();
                      System.out.println("Escribe el precio del producto ");
                      double precio_producto = sc.nextDouble();
                      System.out.println("Escribe el cantidad de stock del producto ");
                      int cantidad_stock = sc.nextInt();
                      p = new Producto(id, producto_nuevo, precio_producto, cantidad_stock);
                      pr.remplazar_producto(nombre, p);
                      break;
                  case 5:
                      System.out.println("Que producto deseas eliminar?");
                      nombre = sc.next();
                      pr.eliminar_producto(nombre);
                      break;

              }
              System.out.println("Deseas continuar si o no?");
              continuar = sc.next();
          }
      }else {
          System.out.println("Empezemos con el sistema de productos.Presione Si para continuar o no para detenerse");
          String  continuar = sc.next();
          while (continuar.equalsIgnoreCase("si")) {
              System.out.println("Elige una opcion");
              System.out.println("Comprar producto: 1");
              int opcion = sc.nextInt();
              switch (opcion) {
                  case 1:
                      System.out.println("Elige el id producto que quieras agregar");
                      int id =sc.nextInt();
                      System.out.println("Que cantidad quieres agregar");
                      int cantidad=sc.nextInt();
                       vs.venta(usuario,id,cantidad);
                      break;
                  case 2:
                      System.out.println("Escribe el producto que deseas eliminar");
                      String producto=sc.next();
                      usuario.eliminar_producto_comprado(producto);
                      break;
                  case 3:
                     //AQUI MAÑANA VMAOS A CREAR UN METOO EN USUARIO DE UPDATE BUENO NO USAR ELIMIANR Y VENTA PARA AHCER UPDATE
                      System.out.println("Escribe el producto que deseas remplazar");
                      String remplazo=sc.next();
                      System.out.println("Elige el id producto que quieras agregar");
                       id =sc.nextInt();
                      System.out.println("Eliga la cantidad");
                      cantidad=sc.nextInt();
                      vs.venta(usuario,id,cantidad);
                      usuario.eliminar_producto_comprado(remplazo);
                      break;
                  case 4:
                      usuario.ver_mi_lista().forEach((prod,can)->{
                          System.out.println("Producto: "+prod.getNombre()
                                  + " | Cantidad: " + can
                          );

                      });
                     break;

              }
          }
      }



  }
}