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
class Nodos {
    private Nodos siguiente;
    private String informacion;
    public Nodos(String info,Nodos next){
        informacion=info;
        siguiente=next;
    }
    
    public String informacion(){
        return informacion;
    }
    
    public Nodos getSigiente(){
        return siguiente;
    }    
}
