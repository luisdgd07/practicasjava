/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asignacion_3;

import java.util.Scanner;

/**
 *
 * @author Gonzalez Duerto
 */
public class Asignacion_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String_personalizado string_per=new String_personalizado();
        Scanner s=new Scanner(System.in);
        System.out.println("Bienvenido. Por favor ingrese el nombre del archivo txt a encriptar");
        String documento1=s.next();
        String documento2=s.next();
        System.out.println(string_per.equals(documento1,documento2));
        System.out.println(documento1.getBytes());
    }
    
}
