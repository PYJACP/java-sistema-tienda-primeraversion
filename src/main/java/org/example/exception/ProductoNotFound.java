package org.example.exception;

public class ProductoNotFound extends RuntimeException{

    public ProductoNotFound(String mensaje){
        super(mensaje);
    }

}
