package org.example.service;

import org.example.exception.StockInsuficienteError;
import org.example.model.Producto;
import org.example.model.Usuario;
import org.example.repository.ProductoRepository;
import org.example.exception.SaldoInsuficienteError;
public class VentaService {
    private ProductoRepository PR;
    public VentaService(ProductoRepository PR ){
        this.PR = PR;
    }


    //buscamos por id
    //la cantidad q restamos es la del usuario
    public Producto venta(Usuario us,int id, int cantidad){
        Producto producto = PR.BuscarID(id);
        if (producto.getCantidad_stock() >= cantidad) {
            if (us.getSaldo()>=producto.getprecio()*cantidad) {
                producto.setCantidad_stock(producto.getCantidad_stock() - cantidad);
                double total=producto.getprecio()*cantidad;
                us.descontarSaldo(total);
                us.agregarProductoComprado(producto,cantidad);
                return producto;

            }else{
                throw new SaldoInsuficienteError("Saldo insuficiente");
            }
        }
        else {
            throw new StockInsuficienteError("No hay stock suficiente");
        }

    }





}
