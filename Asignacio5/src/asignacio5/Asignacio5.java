/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asignacio5;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Gonzalez Duerto
 */
public class Asignacio5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Menu fr=new Menu();
    fr.setVisible(true);
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
    public void enviar(String email,String contra,String codigo){
        try{
            MimeMessage mensaje=new MimeMessage(session);
            mensaje.setFrom(new InternetAddress((String)pro.get("mail.smtp.mail.sender")));
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            mensaje.setSubject("Contraseña");
            mensaje.setText("Su contraseña es: "+codigo);
            Transport tr= session.getTransport("smtp");
            tr.connect((String)pro.get("mail.smtp.user"),"password");
            tr.sendMessage(mensaje, mensaje.getAllRecipients());
            tr.close();
        }catch(Exception e){
            System.out.println("Error email");
        }
    }
}
