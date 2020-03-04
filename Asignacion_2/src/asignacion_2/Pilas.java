/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asignacion_2;

/**
 *
 * @author Gonzalez Duerto
 */
class Pilas {
    private Nodos nodo;
    private int len;
    
    public Pilas(){
        nodo = null;
        len=0;
    }
    
    public int len(){
        return len;
    }
    
    public boolean esVacia(){
        return(nodo==null);
    }
    
    public void push(String informacion){
        Nodos n= new Nodos(informacion,nodo);
        nodo=n;
        len++;
    }
    
    public String pop(){
        String aux;
        if(esVacia())return null;
        aux = nodo.informacion();
        nodo = nodo.getSigiente();
        len--;
        return aux;
        
    }
    
    public String primero(){
    if(esVacia()){
        return null;}
    else {
        return nodo.informacion();}
    }
    
    public Nodos getNodo(){
        if(esVacia()){
            return null;}
         else {
            return nodo;}
    }
    
     public String toString(Pilas pila){
        String cadena="";
         System.out.println(pila.nodo.informacion());
         Boolean evaluar_numero=false;
         String evaluar_nodo;
        while(!pila.esVacia()){
        evaluar_numero=false;
        evaluar_nodo= pila.primero();
        System.out.println(evaluar_nodo);
        
        if(evaluar_nodo.equals("-") == false && evaluar_nodo.equals("*") == false && evaluar_nodo.equals("+") == false && evaluar_nodo.equals("/") == false){
        if(Integer.parseInt(pila.primero())>=10 ){
            String cadena_auxiliar = pila.pop();
            cadena= cadena + " ";
            for(int i=(cadena_auxiliar.length() -1);i>=0;i--){
                cadena+=cadena_auxiliar.charAt(i);
            }
            evaluar_numero=true;
        }
        }
        if(evaluar_numero == false){
        cadena=cadena + " " + pila.pop();
        }
        
        System.out.println("esta entrando en cadena : " + cadena);
        }
        
        String cadena2="";
        
        for (int i = (cadena.length()-1); i >= 0; i--) {
            cadena2+=cadena.charAt(i);
    }
        return cadena2;
    }
}
