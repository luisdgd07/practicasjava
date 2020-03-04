/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asignacion_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Gonzalez Duerto
 */
public class Archivos {
    private String texto;
    public String lectura(File file){
        texto="";
                try {
            BufferedReader leer=new BufferedReader(new FileReader(file));
            String cadena;
            while((cadena=leer.readLine())!=null){
                texto+=cadena+'\n';
            }
            leer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return texto;
    }
    public File txt_encriptado(String nombre,String encryp){
        File file=new File(nombre+"_encriptado.txt");
        try {
            file.createNewFile();
            texto="";   
            BufferedWriter escribir=new BufferedWriter(new FileWriter(file));
            escribir.write(encryp);
            escribir.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
