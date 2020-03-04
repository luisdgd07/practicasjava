/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asignacion_3;

/**
 *
 * @author Gonzalez Duerto
 */
public class String_personalizado {
    public String ToLower(String cadena){
    		String cadena_transformada = "";
                
   		for(int i=0;i<cadena.length();i++){
   			if(cadena.charAt(i)=='A'){
   				cadena_transformada += 'a';
   			}else if(cadena.charAt(i)=='B'){
   				cadena_transformada += 'b';
   			}else if(cadena.charAt(i)=='C'){
   				cadena_transformada += 'c';
   			}else if(cadena.charAt(i)=='D'){
   				cadena_transformada += 'd';
   			}else if(cadena.charAt(i)=='E'){
   				cadena_transformada += 'e';
   			}else if(cadena.charAt(i)=='F'){
   				cadena_transformada += 'f';
   			}else if(cadena.charAt(i)=='G'){
   				cadena_transformada += 'g';
   			}else if(cadena.charAt(i)=='H'){
   				cadena_transformada += 'h';
   			}else if(cadena.charAt(i)=='I'){
   				cadena_transformada += 'i';
   			}else if(cadena.charAt(i)=='J'){
   				cadena_transformada += 'j';
   			}else if(cadena.charAt(i)=='K'){
   				cadena_transformada += 'k';
   			}else if(cadena.charAt(i)=='L'){
   				cadena_transformada += 'l';
   			}else if(cadena.charAt(i)=='M'){
   				cadena_transformada += 'm';
   			}else if(cadena.charAt(i)=='N'){
   				cadena_transformada += 'n';
   			}else if(cadena.charAt(i)=='O'){
   				cadena_transformada += 'o';
   			}else if(cadena.charAt(i)=='P'){
   				cadena_transformada += 'p';
   			}else if(cadena.charAt(i)=='Q'){
   				cadena_transformada += 'q';
   			}else if(cadena.charAt(i)=='R'){
   				cadena_transformada += 'r';
   			}else if(cadena.charAt(i)=='S'){
   				cadena_transformada += 's';
   			}else if(cadena.charAt(i)=='T'){
   				cadena_transformada += 't';
   			}else if(cadena.charAt(i)=='U'){
   				cadena_transformada += 'u';
   			}else if(cadena.charAt(i)=='V'){
   				cadena_transformada += 'v';
   			}else if(cadena.charAt(i)=='W'){
   				cadena_transformada += 'w';
   			}else if(cadena.charAt(i)=='X'){
   				cadena_transformada += 'x';
   			}else if(cadena.charAt(i)=='Y'){
   				cadena_transformada += 'y';
   			}else if(cadena.charAt(i)=='Z'){
   				cadena_transformada += 'z';
   			}else{
   				cadena_transformada += cadena.charAt(i);
   			}
   		}
   		return cadena_transformada;
    }
    public String subString(String cadena,int begin){
        String result="";
        boolean error=false;
        int lenght=0;
        while(!error){
            try{
    		cadena.charAt(lenght);
    		lenght++;
    		}catch(Exception e){
                    error=true;
    		}
        }
        for(int i=begin;i<lenght;i++){
            result+=cadena.charAt(i);
        }
        return result;
    }
    public String subString(String string,int begin,int end){
        try{
            String result="";
            for(int i=begin;i<end;i++){
                result+=string.charAt(i);
            }
            return result;
        }
        catch(Exception e){
            return "Error";
        }
    }
    public int length(String string){
        int longitud=0;
   	char prueba;
   	boolean error=false;
   	while(error!=true){
            try{
    		prueba = string.charAt(longitud);
    		longitud++;
    		}catch(Exception e){
                    error=true;
    		}	
            }
    		return longitud;
    	}
    public String equals(String cadena1,String cadena2){
        if(length(cadena1)==length(cadena2)){
            boolean igual=true;
            for(int i=0;i<length(cadena1);i++){
                if(cadena1.charAt(i)==cadena2.charAt(i)){
                }
                else{
                    igual=false;
                }
            }
            if(igual){
            return "Son iguales las cadenas";}
            else{
                return "No son iguales las cadenas";
            }
        }
        else{
            return "No son iguales las cadenas";
        }
    }
    public String replace(String cadena,char oldChar, char newChar){
        boolean error=false;
        int lenght=0;
        while(!error){
            try{
    		cadena.charAt(lenght);
    		lenght++;
    		}catch(Exception e){
                    error=true;
    		}
        }
        String cadena_reemplazada="";
        boolean reemplazo=false;
        for(int i=0;i<lenght;i++){
            if(cadena.charAt(i)==oldChar&&reemplazo==false){
               cadena_reemplazada+=newChar;
               reemplazo=true;
            }
            else{
                cadena_reemplazada+=cadena.charAt(i);
            }
        }
        return cadena_reemplazada;
    }
    public String remove(String cadena,char oldChar){
        boolean error=false;
        
        int lenght=0;
        while(!error){
            try{
    		cadena.charAt(lenght);
    		lenght++;
    		}catch(Exception e){
                    error=true;
    		}
        }
        String cadena_reemplazada="";
        boolean reemplazo=false;
        for(int i=0;i<lenght;i++){
            if(cadena.charAt(i)==oldChar&&reemplazo==false){
               cadena_reemplazada+="";
               reemplazo=true;
            }
            else{
                cadena_reemplazada+=cadena.charAt(i);
            }
        }
        return cadena_reemplazada;
    }
    public String insert(String cadena,char newChar,int position){
        boolean error=false;
        int lenght=0;
        while(!error){
            try{
    		cadena.charAt(lenght);
    		lenght++;
    		}catch(Exception e){
                    error=true;
    		}
        }
        String cadena_reemplazada="";
        boolean reemplazo=false;
        for(int i=0;i<lenght;i++){
            if(i==position&&reemplazo==false){
               cadena_reemplazada+=newChar+cadena.charAt(i);
               reemplazo=true;
            }
            else{
                cadena_reemplazada+=cadena.charAt(i);
            }
        }
        return cadena_reemplazada;
    }
    public String insert(String cadena,char newChar){
        return cadena+newChar;
    }
}
