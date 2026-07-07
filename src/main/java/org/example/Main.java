package org.example;
import java.util.Scanner;
//
////TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
//// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
  public static void main(String[] args) {
    System.out.println("Como te llamas");
    Scanner sc=new Scanner(System.in);

      Tienda t=new Tienda("cesar");
      t.agregar_producto();
         System.out.println(t.gancia_venta("laptop"));
         t.agregar_producto();
         t.agregar_producto();
         t.agregar_producto();
         t.agregar_producto();



     Usuario us=new Usuario(1,"Sebastian",300);
     us.agregar_producto(t);



  }
}