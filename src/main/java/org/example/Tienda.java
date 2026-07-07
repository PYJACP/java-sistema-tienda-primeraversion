package org.example;
import java.util.*;
import java.util.stream.Stream;

public class Tienda implements Gancia<String, Double>{
    final String cliente;
    ArrayList<Producto> registar_producto=new ArrayList<Producto>();

    public Tienda(final String cliente){
       this.cliente=cliente;
    }
    @Override
    public Double gancia_venta(String p){
     double ganancia=0;
     for(Producto i:registar_producto){
         if(i.getNombre().equals(p)){
              ganancia+=i.getprecio()*i.getCantidad_stock();
         }

     }
     return  ganancia;
    }
   //No usarlo directamente a menos q solo querias verlo peor prefieramtenl usar ganancia_venta
    public void buscar(Producto p) {
         Collections.sort(registar_producto,(p1,p2)->Integer.compare(p1.getid(),p2.getid()));
          boolean encontrado=false;
         for(int y=0;y<=registar_producto.size()-1;y++){
            if(registar_producto.get(y)!=null){
               if(registar_producto.get(y).getid()==p.getid()){
                   encontrado=true;
                   System.out.println("Producto encontrado: "+p);
                   break;
               }
            }
            else{
                break;
            }
         }
         if(!encontrado){
             System.out.println("Producto NO encontrado: "+p);
         }


    }
    public void calcular_valor_inventario(){
        double multiplicaicon=registar_producto.stream().
                filter(p->p!=null).
                map(p->p.getCantidad_stock()*p.getprecio()).
                reduce(0.0,(a,b)->a+b);
        System.out.println( "Valor total del inventario: " + multiplicaicon);

    }

    public Producto venta(int id,int cantidad){
        boolean encontrado = false;
        Producto producto_confirmado=null;
        for(int x=0;x<=registar_producto.size()-1;x++){
            Producto p = registar_producto.get(x);
               if(p!=null && id==p.getid() ) {
                   encontrado = true;
                   if (p.getCantidad_stock() >= cantidad) {
                       producto_confirmado=p;
                       p.setCantidad_stock(p.getCantidad_stock() - cantidad);
                       break;
                   } else {
                       System.out.println("No hay stock suficiente");
                   }
                   break;
               }
          }

        if(!encontrado){
            System.out.println("Producto no encontrado");
        }
        return producto_confirmado;
    }
   public void precios_categoria_mayor_menor(){
       System.out.println("Ordenando los precios...");
       Collections.sort(registar_producto,(p1,p2)->Double.compare(p1.getprecio(),p2.getprecio()));
       registar_producto.stream().filter(p->p!=null).forEach(p->System.out.println("El primer precio es: "+p.getprecio()));

   }

   public void agregar_producto(){
       System.out.println("Agregaremos un producto...");
       Scanner sc=new Scanner(System.in);
       System.out.println("Ingresa el ID");
       int id=sc.nextInt();
       System.out.println("Escribe el producto nuevo");
       String nombre_producto=sc.next();
       System.out.println("Escribe el precio del producto");
       double precio=sc.nextDouble();
       System.out.println("Escribe la cantidad del producto");
       int cantidad=sc.nextInt();
       Producto p=new Producto(id,nombre_producto,precio,cantidad);
       registar_producto.add(p);
   }
   public void eliminar_producto(){
      System.out.println("Que producto deseas eliminar?");
      Scanner SC=new Scanner(System.in);
      String nombre=SC.next();
      for(int a=0;a<=registar_producto.size()-1;a++){
          if(nombre.equals(registar_producto.get(a).nombre)){
              registar_producto.remove(a);
              System.out.println("Producto eliminado con exito");
              return;
        }
      }

   }
   public void remplazar_producto(){
       Scanner sc=new Scanner(System.in);
        System.out.println("Escribe el nombre del producto que quiereas remplazar");
        String nombre=sc.next();
        for(int i=0;i<=registar_producto.size()-1;i++){
              if(registar_producto.get(i).getNombre().equals(nombre)){
                  System.out.println("Escribe el id del producto ");
                  int id=sc.nextInt();
                  System.out.println("Escribe el nombre del producto ");
                  String producto_nuevo=sc.next();
                  System.out.println("Escribe el precio del producto ");
                  double precio_producto=sc.nextDouble();
                  System.out.println("Escribe el cantidad de stock del producto ");
                  int cantidad_stock=sc.nextInt();
                  Producto p=new Producto(id,producto_nuevo,precio_producto,cantidad_stock);
                  registar_producto.set(i,p);
                  break;
              }

       }

   }

}

//Producto es el hijo de tienda y no solo tiene el registro de cada producto es deicr no tendra las ventas
class Producto {
    //lla razon por la que id es protecterd es par q las hijas cmo comprar elminar eherencen del adpre entonmces protecer permitada q id se leimian crezca etec etc
      protected int id;
     String nombre;
     private double precio;
     private int cantidad_stock;
    Producto(int id,String nombre,double precio,int cantidad_stock){
      this.id=id;
      this.nombre=nombre;
      this.precio=precio;
      this.cantidad_stock=cantidad_stock;
    }
    int getid(){
        return id;
    }
    String getNombre(){
        return nombre;
    }

    int getCantidad_stock(){
        return  cantidad_stock;
    }
    void setCantidad_stock(int nuevo_stock){
         this.cantidad_stock=nuevo_stock;
    }
    double getprecio(){
        return precio;
    }

}

class Producto_Delivery extends Producto{
    double pago_extra;
    int distancia;
    Producto_Delivery(int id,String nombre,double precio,int cantidad_stock,int distancia,double pago_extra){
        super(id,nombre,precio,cantidad_stock);
        this.distancia=distancia;
        this.pago_extra=pago_extra;

    }

}


interface Gancia <T,S>{
    S gancia_venta(T objeto);

}