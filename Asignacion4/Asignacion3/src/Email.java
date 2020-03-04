
class Email {
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
