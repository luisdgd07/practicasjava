/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asignacion_1;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

public class Encriptar {
        Cipher ecipher;
    public Encriptar(SecretKey key) {
        try {
            ecipher = Cipher.getInstance(key.getAlgorithm());
            ecipher.init(Cipher.ENCRYPT_MODE, key);
        } catch (Exception e) {
        } 
    }
    public String encrypt(String str) {
        try {
            byte[] utf8 = str.getBytes("UTF8");

            return new sun.misc.BASE64Encoder().encode(utf8);

        } catch (UnsupportedEncodingException e) {
        } catch (IOException e) {
        }
        return null;
    }
}
