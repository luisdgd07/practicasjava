/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asignacion_2;

import java.util.Scanner;

/**
 *
 * @author Gonzalez Duerto
 */
public class Asignacion_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Ingrese expresión algebraica Infija: ");
        Scanner leer = new Scanner(System.in);

    String expr = depurar(leer.nextLine());
    String[] arrayInfix = expr.split(" ");
    
    Pilas Entrada = new Pilas();
    Pilas Operadores = new Pilas();
    Pilas Salida = new Pilas();

      for (int i = arrayInfix.length - 1; i >= 0; i--) {
      Entrada.push(arrayInfix[i]);
    }
      
      //Algoritmo Infijo a Postfijo
      while (Entrada.esVacia() == false) {
         
        switch (pref(Entrada.primero())){
          case 1:
            Operadores.push(Entrada.pop());
            break;
          case 3:
          case 4:
            while(pref(Operadores.primero()) >= pref(Entrada.primero())) {
              Salida.push(Operadores.pop());
            }
            Operadores.push(Entrada.pop());
            break; 
          case 2:
            while(!Operadores.primero().equals("(")) {
              Salida.push(Operadores.pop());
            }
            Operadores.pop();
            Entrada.pop();
            break; 
          default:
            Salida.push(Entrada.pop()); 
        } 
      }
      
      
      
       String infix = expr.replace(" ", "");
      String postfix = Salida.toString(Salida).replaceAll("[\\]\\[,]", "");
      System.out.println("Expresion Postfija: " + postfix);
      
    }  
    private static int pref(String op) {
        int prf = 99;
        if (op.equals("^")) prf = 5;
        if (op.equals("*") || op.equals("/")) prf = 4;
        if (op.equals("+") || op.equals("-")) prf = 3;
        if (op.equals(")")) prf = 2;
        if (op.equals("(")) prf = 1;
        return prf;
  }
    
     private static String depurar(String cadena) {
   cadena = cadena.replaceAll("\\s+", "");
   cadena = "(" + cadena + ")";
    String simbols = "+-*/()";
    String str = "";

    for (int i = 0; i < cadena.length(); i++) {
      if (simbols.contains("" + cadena.charAt(i))) {
        str += " " + cadena.charAt(i) + " ";
      }else str += cadena.charAt(i);
    }
    return str.replaceAll("\\s+", " ").trim();
  }
     

    
}
