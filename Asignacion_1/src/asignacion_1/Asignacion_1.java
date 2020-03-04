/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asignacion_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.Key;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JFileChooser;

public class Asignacion_1 {

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("Bienvenido. Por favor ingrese el nombre del archivo txt a encriptar");
        String documento=s.next();
        File file=new File(documento+".txt");
        if(file.exists()){
            
        byte[] clave={0,1,2,3,4,5};
        Archivos archivos=new Archivos();
        SecretKey secret=new SecretKeySpec(clave,"md5");    
        Encriptar encriptacion=new Encriptar(secret);
            System.out.println("El archivo contiene");
        System.out.println(archivos.lectura(file));
        String txtencriptado=encriptacion.encrypt(archivos.lectura(file));
        archivos.txt_encriptado(documento, txtencriptado);
        System.out.println("Archivo txt encriptado con exito");}
        else{
            System.out.println("Archivo inexistente");
        }
    }
    
}
