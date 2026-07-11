package org.example.model;

public class Producto {
    //lla razon por la que id es protecterd es par q las hijas cmo comprar elminar eherencen del adpre entonmces protecer permitada q id se leimian crezca etec etc
    protected int id;
    public String nombre;
    private double precio;
    private int cantidad_stock;
   public  Producto(int id,String nombre,double precio,int cantidad_stock){
        this.id=id;
        this.nombre=nombre;
        this.precio=precio;
        this.cantidad_stock=cantidad_stock;
    }
    public int getid(){
        return id;
    }
    public String getNombre(){
        return nombre;
    }

    public int getCantidad_stock(){
        return  cantidad_stock;
    }
    public void setCantidad_stock(int nuevo_stock){
        this.cantidad_stock=nuevo_stock;
    }
    public double getprecio(){
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


