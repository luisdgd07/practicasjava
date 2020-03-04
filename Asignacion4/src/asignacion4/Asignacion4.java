/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asignacion4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gonzalez Duerto
 */
public class Asignacion4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("Bienvenido introduzca el nombre del archivo txt desea encriptar sin incluir la extension 'txt' ");
        String documento=s.next()+".txt";
        String nombre=documento;
        try {
            Encriptarchivo ar=new Encriptarchivo(nombre,documento);
        } catch (Exception ex) {
            System.out.println("El archivo no existe");
        }
    } 
}
class Encriptarchivo{
    private Scanner s=new Scanner(System.in);
    public Encriptarchivo(String nombre,String documento) throws Exception{
        System.out.println("El archivo "+documento+" contiene:");
            BufferedReader txt=new BufferedReader(new FileReader(documento));
            String txtr="";
            File txt2=new File("(2)"+nombre);
        
        txt2.createNewFile();
        BufferedWriter encriptado=new BufferedWriter(new FileWriter(txt2));
            while(txtr!=null){
                txtr=txt.readLine();
                if(txtr!=null){
                System.out.println(txtr);
                getencriptar(encriptado,txtr);}
            else{}
            }
            encriptado.close();
    }
    public static String getencriptar(BufferedWriter encriptado,String documento) {
        try{
        MessageDigest md=MessageDigest.getInstance("md5");
        byte[] medi=md.digest(documento.getBytes());
        BigInteger numero=new BigInteger(1,medi);
        String hashtexto=numero.toString(16);
        System.out.println(hashtexto);
        encriptado.write(hashtexto);
        encriptado.newLine();
        return "";}catch(Exception e){
            System.out.println("error");
        }
        return "";
    }
}
