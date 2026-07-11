package org.example.exception;

public class StockInsuficienteError extends RuntimeException {
    String mensaje;
    public StockInsuficienteError(String mensaje){
       super(mensaje);

    }
}
