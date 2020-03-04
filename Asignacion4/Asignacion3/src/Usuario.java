
class Usuario {
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
