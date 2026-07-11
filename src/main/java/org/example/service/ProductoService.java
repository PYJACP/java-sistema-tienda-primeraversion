package org.example.service;

import org.example.exception.StockInsuficienteError;
import org.example.model.Producto;
import org.example.repository.ProductoRepository;

public class ProductoService  implements Gancia<String,Double>{
    ProductoRepository PR;
    public ProductoService(ProductoRepository PR){
        this.PR=PR;
    }


    @Override
    public Double gancia_venta(String p){
        double total_posible=0;
         Producto producto=PR.buscar_por_nombre(p);
         total_posible+=producto.getprecio()*producto.getCantidad_stock();

        return  total_posible;
    }




    public Double calcular_valor_inventario(){
        return PR.Obtenertodos().stream().
                filter(p->p!=null).
                map(p->p.getCantidad_stock()*p.getprecio()).
                reduce(0.0,(a,b)->a+b);
    }



}
interface Gancia <T,S>{
    S gancia_venta(T objeto);

}
