/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asignacion2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Gonzalez Duerto
 */
public class Asignacion2 {

    public static void main(String[] args) {

        Scanner s=new Scanner(System.in);
        int i;
        do{
        System.out.println("Bienvenidos al banco que desea hacer?");
        System.out.println("1. Crear cuenta");
        System.out.println("2. Ingresar en su cuenta");
            System.out.println("3. Salir");
        i=Integer.parseInt(s.next());
        if(i==1){
            try{
            Cuenta cu=new Cuenta();
            }catch(Exception e){
                System.out.println("Ha ocurrido un error");
            }
        }
        else if(i==2){
            try{
            String tipo;
            System.out.println("Ingrese numero de cuenta");
            int ncuenta=Integer.parseInt(s.next());
            System.out.println("Ingrese su nombre");
            String cliente=s.next();
            System.out.println("Que tipo de cuenta posee?");
            System.out.println("1. Ahorro");
            System.out.println("2. Corriente");
            int n=Integer.parseInt(s.next());
            if(n==1){
                tipo="ahorro";
                Cuenta cu=new Cuenta(cliente,tipo,ncuenta);
            }
            else if(n==2){
                tipo="corriente";
                Cuenta cu=new Cuenta(cliente,tipo,ncuenta);
                }
            }
            catch(Exception e){
                System.out.println("Ha ocurrido un error");
            }
        }
        }
        while(i>0&&i<2);

    }
    
}
class Cuenta{
    private static ArrayList cuentas=new ArrayList();
    private static ArrayList registro=new ArrayList();
    private static int e;
    private Scanner s=new Scanner(System.in);
    private int ncuenta;
    private int n,n2;
    private String cliente,tipo;
    private int saldo;
    public Cuenta()throws Exception{
        ncuenta=532200000+(int) Math.round(Math.random()*1000);
        while(cuentas.contains(ncuenta)){
            ncuenta=(int) Math.random();
        }
        System.out.println("Ingrese su nombre");
        cliente=s.next();
        cuentas.add(cliente);
        System.out.println("Que tipo de cuenta desea crear?");
        System.out.println("1. Ahorro");
        System.out.println("2. Corriente");
        n=Integer.parseInt(s.next());
        if(n==1){
            tipo="ahorro";
            cuentas.add(tipo);
            cuentas.add(ncuenta);
            saldo=0;
            cuentas.add(saldo);
            registro.add(ncuenta);
            int nc=registro.indexOf(ncuenta);
            for(int i=1+nc;i<21+nc;i++){
                registro.add(i,"");
       }
        System.out.println("Ha creado una cuenta bancaria. Su numero de cuenta es "+ncuenta);
        }
        else if(n==2){
            tipo="corriente";
            cuentas.add(tipo);
            cuentas.add(ncuenta);
            saldo=0;
            cuentas.add(saldo);
            registro.add(ncuenta);
            int nc=registro.indexOf(ncuenta);
            for(int i=1+nc;i<21+nc;i++){
                registro.add(i,"");
            }
            System.out.println("Ha creado una cuenta bancaria. Su numero de cuenta es "+ncuenta);
        }
        else{
            System.out.println("elija un tipo de cuenta correctamente");
        }

    }
    public Cuenta(String cliente,String tipo,int numerocuenta)throws Exception{
        int i=cuentas.indexOf(cliente);
        int nc=registro.indexOf(numerocuenta);
        Object t=cuentas.get(i+1);
        Object ncu=cuentas.get(i+2);
        e=i+3;
        if(t.equals(tipo)&&ncu.equals(numerocuenta)){
            do{
            System.out.println("Que desea hacer?");
            System.out.println("1. Ingresar dinero");
            System.out.println("2. Retirar dinero");
            System.out.println("3. Transferir dinero");
            System.out.println("4. Consultar movimientos");
            System.out.println("5. Consultar Saldo");
            System.out.println("6. Salir");
            n=Integer.parseInt(s.next());
            switch (n) {
                case 1:
                setingreso(i,nc);
                break;
                case 2:
                setdebito(i,nc);
                break;
                case 3:
                settransferencia(i,nc);
                break;
                case 4:
                    setconsulta(i,nc);
                break;
                case 5:
                    setsaldo(i);
                    break;
                default:
                break;
            }
            }while(n>0&&n<6);
            
        }
        else {
            System.out.println("Datos incorrectos vuelva a intentarlo");
        }
                do{
        System.out.println("Bienvenidos al banco que desea hacer?");
        System.out.println("1. Crear cuenta");
        System.out.println("2. Ingresar en su cuenta");
        i=Integer.parseInt(s.next());
        if(i==1){
            Cuenta cu=new Cuenta();
        }
        else if(i==2){
            System.out.println("Ingrese numero de cuenta");
            int ncuenta=Integer.parseInt(s.next());
            System.out.println("Ingrese su nombre");
            cliente=s.next();
            System.out.println("Que tipo de cuenta posee?");
            System.out.println("1. Ahorro");
            System.out.println("2. Corriente");
            int n=Integer.parseInt(s.next());
            if(n==1){
                tipo="ahorro";
                Cuenta cu=new Cuenta(cliente,tipo,ncuenta);
            }
            else if(n==2){
                tipo="corriente";
                Cuenta cu=new Cuenta(cliente,tipo,ncuenta);
            } 
            }
        }
        while(i>0&&i<2);
    }
    public void setingreso(int i,int nc){
        System.out.println("Cuanto dinero desea ingresar?");
        int sal=i+3;
        int ingreso=Integer.parseInt(s.next());
        getingreso(sal,ingreso);
        boolean ing=true;
        while(ing){
            if(registro.get(nc)==""){
                registro.add(nc,"ha ingresado "+ingreso);
                ing=false;
            }
            else{
                nc++;
            }
        }
    }
    public int getingreso(int sal, int ingreso){
        saldo=(int) cuentas.get(sal);
        int total=saldo+ingreso;
        cuentas.set(sal, total);
        System.out.println("Ha ingresado "+ingreso);
        System.out.println("Tiene un total de "+total);
        return total;
    }
    public void setdebito(int i,int nc){
        System.out.println("Cuanto dinero quiere retirar?");
        int debito=Integer.parseInt(s.next());
        int sal=i+3;
        saldo=(int)cuentas.get(sal);
        if(debito<saldo){
            System.out.println("Tiene saldo suficiente para retirar");
            cuentas.add("Ha retirado "+debito);
            getdebito(sal,debito);
            boolean ing=true;
             while(ing){
            if(registro.get(nc)==""){
                registro.add(nc,"Ha retirado "+debito);
                ing=false;
            }
            else{
                nc++;
            }
        }
        }
        else{
            System.out.println("Tiene saldo insuficiente");
        }
    }
    public int getdebito(int sal,int debito){
        saldo=(int) cuentas.get(sal);
        int total=saldo-debito;
        cuentas.set(sal, total);
        System.out.println("Ha retirado "+debito);
        System.out.println("Tiene un total de "+total);
        return saldo;
    }
    public void settransferencia(int i,int nc){
        System.out.println("Que cantidad desea transferir");
        int monto= Integer.parseInt(s.next());
        int sal=i+3;
        saldo=(int)cuentas.get(sal);
        if(monto<saldo){
            int total=saldo-monto;
            cuentas.set(sal, total);
            System.out.println("A que numero de cuenta desea transferir?");
            int numerocuenta = Integer.parseInt(s.next());
            System.out.println("Nombre del titular al que desea transferir");
            String cliente=s.next();
            System.out.println("Tipo de cuenta al que desea transferir");
            System.out.println("1. Ahorro");
            System.out.println("2. Corriente");
            int n=Integer.parseInt(s.next());
            if(n==1){
                tipo="ahorro";
                gettransferencia(cliente,tipo,numerocuenta,monto,nc);
            }
            else if(n==2){
                tipo="corriente";
                gettransferencia(cliente,tipo,numerocuenta,monto,nc);
            }
        }
        else{
            System.out.println("Tiene saldo insuficiente para transferir");
        }
    }
    public int gettransferencia(String cliente,String tipo, int numerocuenta,int monto,int nc){
        int e=cuentas.indexOf(cliente);
        Object t=cuentas.get(e+1);
        Object ncu=cuentas.get(e+2);
        if(t.equals(tipo)&&ncu.equals(numerocuenta)){
            int saldo=(int) cuentas.get(e+3);
            cuentas.set(e+3,saldo+monto);
            System.out.println("La transferencia de "+monto+" ha sido completada ");
            boolean ing=true;
            while(ing){
            if(registro.get(nc)==""){
                registro.add(nc,"ha transferido "+monto+" a "+cliente);
                ing=false;
            }
            else{
                nc++;
            }
            }
                System.out.println("1");
            boolean ing2=true;
            int nc2=registro.indexOf(numerocuenta);
            while(ing2){
            if(registro.get(nc2)==""){
                registro.add(nc2,"ha recibido "+monto);
                ing2=false;
            }
            else{
                nc2++;
            }
        }
        }
        else{
            System.out.println("Cuenta inexistente");
        }
        return monto;
    }
    public void setconsulta(int i,int nc){
        System.out.println("Operaciones en su cuenta");
        getconsulta(nc);
        setsaldo(i);
    }
    public int getconsulta(int nc){
        for(int j=nc+1;j<nc+21;j++){
            if(registro.get(j).toString()!=""){
            System.out.println(registro.get(j).toString());}
            else{
            }
        }
        
        return 0; 
    }
    public void setsaldo(int i){
        int sal=i+3;
        saldo=(int) cuentas.get(sal);
        getsaldo(saldo);
    } 
    public int getsaldo(int saldo){
        System.out.println("Su saldo es "+saldo);
        return saldo;
    }
}