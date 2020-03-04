/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asignacion1;

import java.util.ArrayList;
import java.util.Scanner;



/**
 *
 * @author Gonzalez Duerto
 */
public class Asignacion1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {String titulo,genero;
        int ntemporadas,horases;
        Scanner s=new Scanner(System.in);
        int i;
        do{
            System.out.println("Bienvenidos alquilamos series y videojuegos que desea hacer?");
            System.out.println("1. Alquilar Serie");
            System.out.println("2. Alquilar videojuego");
            System.out.println("3. Entregar Serie");
            System.out.println("4. Entregar videojuego");
            System.out.println("5. Salir");
            i=Integer.parseInt(s.next());
        if(i==1){
            Serie s1=new Serie();
        }
        else if(i==2){
            Videojuego v1=new Videojuego();
        }
        else if(i==3){
            System.out.println("Que serie alquiló");
            titulo=s.next();
            System.out.println("Genero de la serie");
            genero=s.next();
            System.out.println("numero de temporadas que alquiló");
            ntemporadas=Integer.parseInt(s.next());
            Serie s1=new Serie(titulo,genero,ntemporadas);
            
        }
        else if(i==4){
            System.out.println("Que videojuego alquiló");
            titulo=s.next();
            System.out.println("Genero del videojuego");
            genero=s.next();
            System.out.println("numero de horas que alquiló");
            horases=Integer.parseInt(s.next());
            Videojuego v1=new Videojuego(titulo,genero,horases);
        }
        }
        while(i>0&&i<5);
        }catch(Exception e){
            System.out.println("Error vuelva a iniciar el programa");
        }

    }
}

class Serie implements Entregable{
    private static ArrayList series= new ArrayList();
    private String titulo="Serie1",genero="Drama";
    private boolean entregado=false;
    private int ntemporadas=1;
    private Scanner s=new Scanner (System.in);
    public Serie(){
        System.out.println("Va a alquilar una serie");
        settitulo();
    }
    public Serie(String titulo,String genero, int ntemporadas){
        int i=series.indexOf(titulo);
        Object g=series.get(i+1);
        Object n=series.get(i+2);
        if(g.equals(genero)&&n.equals(ntemporadas)){
            System.out.println("serie correcta");
            isEntregado(i);
        }
        else{
            System.out.println("Serie incorrecta");
        }
    }
    public void settitulo(){
        System.out.println("Que serie desea alquilar?");
        titulo=s.next();
        gettitulo(titulo);
    }
    public String gettitulo(String titulo){
        series.add(titulo);
        this.setgenero();
        return titulo;
    }
    public void setgenero(){
        System.out.println("Que genero es la serie?");
        genero=s.next();
        this.getgenero(genero);
    }
    public String getgenero(String genero){
        series.add(genero);
        this.setntemporadas();
        return genero;
    }
    public void setntemporadas(){
        try{System.out.println("Cuantas temporadas quiere ver?");
        ntemporadas=Integer.parseInt(s.next());
        getntemporadas(ntemporadas);
        this.ntemporadas=ntemporadas;}
        catch(Exception e){
            System.out.println("Error al introducir temporadas");
            Serie s1=new Serie();

        }
    }
    public int getntemporadas(int ntemporadas){
        series.add(ntemporadas);
        this.entregar(entregado);
        System.out.println("La serie ha sido alquilada");
        return ntemporadas;
    }
    @Override
    public void entregar(boolean prestado) {
        entregado=prestado;
        prestado=true;
        series.add(prestado);
    }

    @Override
    public void devolver(int i) {
        series.set(i+3,"false");
    }

    @Override
    public boolean isEntregado(int i) {
        Object s=series.get(i+3);
        if(s.equals(true)){
            devolver(i);
            System.out.println("la serie ha sido devuelta");
            return true;
        }
        else{
            System.out.println("la serie ya habia sido devuelta");
            return false;
        }
    }
    
}
class Videojuego implements Entregable{
    private static ArrayList videojuegos= new ArrayList();
    private String titulo="Videojuego 1",genero="Accion";
    private boolean entregado=false;
    private int horasestimadas=10;
    private Scanner s=new Scanner (System.in);
    public Videojuego(){
        System.out.println("Va a alquilar un videojuego");
        settitulo();
    }
    public Videojuego(String titulo,String genero, int horaestimadas){
        int i=videojuegos.indexOf(titulo);
        Object g=videojuegos.get(i+1);
        Object n=videojuegos.get(i+2);
        if(g.equals(genero)&&n.equals(horaestimadas)){
            System.out.println("Videojuego correcto");
            isEntregado(i);
        }
        else{
            System.out.println("Videojuego incorrecto");
        }
    }
    public void settitulo(){
        System.out.println("Que videojuego desea alquilar?");
        titulo=s.next();
        gettitulo(titulo);
    }
    public String gettitulo(String titulo){
        videojuegos.add(titulo);
        this.setgenero();
        return titulo;
    }
    public void setgenero(){
        System.out.println("Que genero es el videojuego?");
        genero=s.next();
        this.getgenero(genero);
    }
    public String getgenero(String genero){
        videojuegos.add(genero);
        this.sethorasestimadas();
        return genero;
    }
    public void sethorasestimadas(){
        try{System.out.println("Cuantas horas quiere jugar?");
        horasestimadas=Integer.parseInt(s.next());
        gethorasestimadas(horasestimadas);
        this.horasestimadas=horasestimadas;}catch(Exception e){
            System.out.println("Error al introducir horas estimadas");
            Videojuego v1=new Videojuego();
            v1.settitulo();
        }
    }
    public int gethorasestimadas(int horasestimadas){
        videojuegos.add(horasestimadas);
        this.entregar(entregado);
        System.out.println("El videojuego ha sido alquiladao");
        return horasestimadas;
    }
    @Override
    public void entregar(boolean prestado) {
        entregado=prestado;
        prestado=true;
        videojuegos.add(prestado);
    }

    @Override
    public void devolver(int i) {
        videojuegos.set(i+3,"false");
    }

    @Override
    public boolean isEntregado(int i) {
        Object s=videojuegos.get(i+3);
        if(s.equals(true)){
            devolver(i);
            System.out.println("El videojuego ha sido devuelto");
            return true;
        }
        else{
            System.out.println("El videojuego ya habia sido devuelto");
            return false;
        }
    }
}

