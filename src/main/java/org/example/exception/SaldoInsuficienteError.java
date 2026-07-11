package org.example.exception;

public class SaldoInsuficienteError extends RuntimeException {
   public SaldoInsuficienteError(String mensaje){
       super(mensaje);

   }
}
