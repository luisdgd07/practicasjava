/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asignacion3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;
import java.util.Scanner;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Gonzalez Duerto
 */
public class Asignacion3 {

    public static void main(String[] args) {
        try{
            int i;
            BufferedReader txt=new BufferedReader(new FileReader("usuario.txt"));
            String usu=txt.readLine();
            String contra=txt.readLine();
            Scanner s=new Scanner(System.in);
            do{
                System.out.println("Que desea hacer?");
                System.out.println("1. Ingresar");
                System.out.println("2. Olvidó su contraseña");
                i=Integer.parseInt(s.next());
                if(i==1){
                    Usuario usuario1=new Usuario(usu,contra);
                }
                else if(i==2){
                    Email email=new Email();
                    System.out.println("Ingrese su correo");
                    String usuario=s.next();
                    System.out.println("Ingrese lacontraseña de su contraseña");
                    String contrasena=s.next();
                    email.iniciar(usuario,contrasena);
                    email.enviar(usuario,contra);
                }
            }while(i<3&&i>0);
            
        }catch(Exception e){
            System.out.println("Error");
        }

    }
}
class Usuario{
    private String usuario,contra;
    private Scanner s=new Scanner(System.in); 
    
    
    public Usuario(String usuario,String contra){
        setusuario(usuario,contra);
    }
    public void setusuario(String usuario,String contrasena){
        System.out.println("Introduzca usuario");
        String ingresado=s.next();
        System.out.println("Introduzca contraseña");
        String contra=s.next();
        getusuario(usuario,ingresado,contrasena,contra);
    }
    public String getusuario(String usuario,String ingresado,String contrasena,String contra){
        if(ingresado.equals(usuario)&&contra.equals(contrasena)){
            System.out.println("Bienvenido usuario "+usuario);
        }
        else if(!ingresado.equals(usuario)||!contrasena.equals(contra)){
            System.out.println("Usuario incorrecto");
        }
        return ingresado;
    }
    
} 
class Email{
    private final Properties pro=new Properties();
    private String password;
    private Session session;
    public void iniciar(String email,String contrasena){
        pro.put("mail.smtp.host", "mail.gmail.com");
        pro.put("mail.smtp.starttls.enable", "true");
        pro.put("mail.stmp.port", 25);
        pro.put("mail.smtp.mail.sender", email);
        pro.put("mail.smtp.user","usuario");
        pro.put("mail.smtp.auth", contrasena);
        session =Session.getDefaultInstance(pro);
}
    public void enviar(String email,String contra){
        try{
            MimeMessage mensaje=new MimeMessage(session);
            mensaje.setFrom(new InternetAddress((String)pro.get("mail.smtp.mail.sender")));
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            mensaje.setSubject("Contraseña");
            mensaje.setText("Su contraseña es: "+contra);
            Transport tr= session.getTransport("smtp");
            tr.connect((String)pro.get("mail.smtp.user"),"password");
            tr.sendMessage(mensaje, mensaje.getAllRecipients());
            tr.close();
        }catch(Exception e){
            System.out.println("Error");
        }
    }
}
