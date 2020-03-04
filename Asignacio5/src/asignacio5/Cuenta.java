/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asignacio5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gonzalez Duerto
 */
public class Cuenta extends javax.swing.JFrame {

    /**
     * Creates new form Cuenta
     */
    public Cuenta() {
        initComponents();
        setLocationRelativeTo(null);
        boton.setVisible(false);
        campo1.setVisible(false);
        ntransf.setVisible(false);
        tipotra.setVisible(false);
        ncuentatr.setVisible(false);
        atransf.setVisible(false);
        
        adestino.setVisible(false);
        ndestino.setVisible(false);
        ncdestino.setVisible(false);
        dinero.setVisible(false);
        tcdestino.setVisible(false);
    }
    void setcuenta(File txt,String ntxt) throws IOException, Exception{
        numeroc.setVisible(false);
        numeroc.setText(ntxt);
        ncuenta.setVisible(false);
        ncuenta.addItem(ntxt);
        BufferedReader leer=new BufferedReader(new FileReader(txt));
        String contra=leer.readLine();
        String correo=leer.readLine();
        String nombre=leer.readLine();
        String apellido=leer.readLine();
        leer.readLine();
        String genero=leer.readLine();
        if(genero.equals("Masculino")){
        ltitulo.setText("Bienvenido Sr. "+nombre+" "+apellido);}
        else{
            ltitulo.setText("Bienvenido Sra. "+nombre+" "+apellido);
        }
        leer.close();
    }
    void setingreso(int nc,int ing) throws Exception{
        File cud=new File(nc+"d.txt");
        File cur=new File(nc+"r.txt");
        BufferedReader leerd=new BufferedReader(new FileReader(cud));
        int saldo=Integer.parseInt(leerd.readLine());
        leerd.close();
        BufferedWriter escribird=new BufferedWriter(new FileWriter(cud));
        saldo+=ing;
        String nsaldo=saldo+"";
        escribird.write(nsaldo);
        escribird.close();
        BufferedWriter escribirr=new BufferedWriter(new FileWriter(cur,true));
        escribirr.write("Ha agregado "+nsaldo);
        escribirr.newLine();
        escribirr.close();
        salida.setText("Ha agregado a su cuenta "+ing+" saldo: "+saldo);
    }
    void setdebito(int nc,int debito) throws Exception{
        File cud=new File(nc+"d.txt");
        File cur=new File(nc+"r.txt");
        BufferedReader leerd=new BufferedReader(new FileReader(cud));
        int saldo=Integer.parseInt(leerd.readLine());
        leerd.close();
        if(debito<saldo){
        BufferedWriter escribird=new BufferedWriter(new FileWriter(cud));
        saldo-=debito;
        String nsaldo=saldo+"";
        escribird.write(nsaldo);
        escribird.close();
        BufferedWriter escribirr=new BufferedWriter(new FileWriter(cur,true));
        escribirr.write("Ha retirado "+debito+" su saldo es: "+nsaldo);
        escribirr.newLine();
        escribirr.close();
        salida.setText("Ha retirado de su cuenta "+debito);}
        else{
            salida.setText("No tiene saldo suficiente");
        }
    }
        void settransferencia(int nc,int debito,int ncd,String tipo,String nombre,String apellido) throws Exception{
        File cud=new File(nc+"d.txt");
        File cur=new File(nc+"r.txt");
        BufferedReader leerd=new BufferedReader(new FileReader(cud));
        int saldo=Integer.parseInt(leerd.readLine());
        leerd.close();
        File cudes=new File(ncd+".txt");
        BufferedReader leerdes=new BufferedReader(new FileReader(cudes));
        leerdes.readLine();
        leerdes.readLine();
        String nombrer=leerdes.readLine();
        String apellidor=leerdes.readLine();
        leerdes.readLine();
        leerdes.readLine();
        String tipor=leerdes.readLine();
        leerdes.close();
        if(debito<saldo&&cudes.exists()&&nombre.equals(nombrer)&&apellido.equals(apellidor)&&tipo.equals(tipor)){
            File curdes=new File(ncd+"d.txt");
        BufferedReader leerddes=new BufferedReader(new FileReader(curdes));
        int saldod=Integer.parseInt(leerddes.readLine().toString());
        saldod=saldod+debito;
        leerddes.close();
        BufferedWriter escribirrdes=new BufferedWriter(new FileWriter(curdes));
        escribirrdes.write(saldod+"");
        escribirrdes.close();
            File cudesr=new File(ncd+"r.txt");
        BufferedWriter escribirdesr=new BufferedWriter(new FileWriter(cudesr,true));
        escribirdesr.write("Ha recibido "+debito+" de "+nc);
        escribirdesr.newLine();
        escribirdesr.close();
        BufferedWriter escribird=new BufferedWriter(new FileWriter(cud));
        saldo-=debito;
        String nsaldo=saldo+"";
        escribird.write(nsaldo);
        escribird.close();
        BufferedWriter escribirr=new BufferedWriter(new FileWriter(cur,true));
        escribirr.write("Ha transferido "+debito+" a "+ncd+" su saldo es: "+nsaldo);
        escribirr.newLine();
        escribirr.close();
        salida.setText("La Transferencia de "+debito+". Se realizo correctamente");
        }
        else{
            salida.setText("No tiene saldo suficiente para transferir o no existe la cuenta");
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ltitulo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        titulo = new javax.swing.JLabel();
        boton = new javax.swing.JButton();
        salida = new javax.swing.JLabel();
        ncuenta = new javax.swing.JComboBox<>();
        campo1 = new javax.swing.JTextField();
        ncuentatr = new javax.swing.JTextField();
        tipotra = new javax.swing.JComboBox<>();
        ntransf = new javax.swing.JTextField();
        atransf = new javax.swing.JTextField();
        ncdestino = new javax.swing.JLabel();
        tcdestino = new javax.swing.JLabel();
        ndestino = new javax.swing.JLabel();
        adestino = new javax.swing.JLabel();
        dinero = new javax.swing.JLabel();
        numeroc = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(532, 670));

        jPanel1.setBackground(new java.awt.Color(0, 120, 215));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 99, 177), 5));

        ltitulo.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        ltitulo.setForeground(new java.awt.Color(255, 255, 255));
        ltitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ltitulo.setText("Bienvenido ");

        jButton1.setBackground(new java.awt.Color(0, 99, 177));
        jButton1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Ingresar saldo");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 99, 177), 3));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 99, 177));
        jButton2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Transferir");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 99, 177), 3));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 99, 177));
        jButton3.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Consultar Movimientos");
        jButton3.setToolTipText("");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 99, 177), 3));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 99, 177));
        jButton4.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Retirar Dinero");
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 99, 177), 3));
        jButton4.setPreferredSize(new java.awt.Dimension(150, 40));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(203, 22, 37));
        jButton7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("salir");
        jButton7.setBorder(null);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        titulo.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        boton.setBackground(new java.awt.Color(255, 255, 255));
        boton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        boton.setForeground(new java.awt.Color(0, 120, 215));
        boton.setText("jButton8");
        boton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 99, 177), 3));
        boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActionPerformed(evt);
            }
        });

        salida.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        salida.setForeground(new java.awt.Color(255, 255, 255));
        salida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        ncuenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"N° de cuenta"}));

        campo1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        ncuentatr.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ncuentatr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ncuentatrActionPerformed(evt);
            }
        });

        tipotra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ahorro","Corriente" }));

        ntransf.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        atransf.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        ncdestino.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        ncdestino.setForeground(new java.awt.Color(255, 255, 255));
        ncdestino.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ncdestino.setText("N° a transferir");

        tcdestino.setBackground(new java.awt.Color(255, 255, 255));
        tcdestino.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        tcdestino.setForeground(new java.awt.Color(255, 255, 255));
        tcdestino.setText("Tipo de cuenta");

        ndestino.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        ndestino.setForeground(new java.awt.Color(255, 255, 255));
        ndestino.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ndestino.setText("Nombre");

        adestino.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        adestino.setForeground(new java.awt.Color(255, 255, 255));
        adestino.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adestino.setText("Apellido");

        dinero.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        dinero.setForeground(new java.awt.Color(255, 255, 255));
        dinero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dinero.setText("jLabel4");

        numeroc.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ltitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(salida, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campo1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ncuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dinero)
                    .addComponent(numeroc, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(atransf, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(ntransf, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(adestino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ndestino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(75, 75, 75)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tcdestino, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(ncdestino, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ncuentatr, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(tipotra, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(38, 38, 38))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(boton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ltitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ncdestino)
                    .addComponent(ndestino))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ncuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ncuentatr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ntransf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tcdestino)
                    .addComponent(adestino)
                    .addComponent(dinero))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(atransf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipotra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numeroc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salida, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        Menu m=new Menu();
        m.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dinero.setText("Saldo a ingresar");
        adestino.setVisible(false);
        ndestino.setVisible(false);
        ncdestino.setVisible(false);
        dinero.setVisible(true);
        tcdestino.setVisible(false);
        ntransf.setVisible(false);
        tipotra.setVisible(false);
        ncuentatr.setVisible(false);
        atransf.setVisible(false);
        campo1.setVisible(true);
        boton.setText("Ingresar");
        boton.setVisible(true);
        ncuenta.setVisible(true);
        titulo.setText("Ingresar saldo");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        dinero.setText("Saldo a retirar");
        adestino.setVisible(false);
        ndestino.setVisible(false);
        ncdestino.setVisible(false);
        dinero.setVisible(true);
        tcdestino.setVisible(false);
        ntransf.setVisible(false);
        tipotra.setVisible(false);
        ncuentatr.setVisible(false);
        atransf.setVisible(false);
        campo1.setVisible(true);
        boton.setText("Retirar");
        boton.setVisible(true);
        ncuenta.setVisible(true);
        titulo.setText("Retirar Dinero");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void botonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActionPerformed
        // TODO add your handling code here:
        try{
        if(boton.getText().equals("Ingresar")){
            int nc=Integer.parseInt(ncuenta.getSelectedItem().toString());
            int ingreso=Integer.parseInt(campo1.getText());
            setingreso(nc,ingreso);
        }
        else if(boton.getText().equals("Retirar")){
            int nc=Integer.parseInt(ncuenta.getSelectedItem().toString());
            int debito=Integer.parseInt(campo1.getText());
            setdebito(nc,debito);
        }
        else if(boton.getText().equals("Transferir")){
            int nc=Integer.parseInt(ncuenta.getSelectedItem().toString());
            int debito=Integer.parseInt(campo1.getText().toString());
            int ncd=Integer.parseInt(ncuentatr.getText().toString());
            String tipo=tipotra.getSelectedItem().toString();
            String nombre=ntransf.getText().toString();
            String apellido=atransf.getText().toString();
            settransferencia(nc,debito,ncd,tipo,nombre,apellido);
        }
        }catch(Exception e){
            salida.setText("Error en algun dato");
        }
    }//GEN-LAST:event_botonActionPerformed

    private void ncuentatrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ncuentatrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ncuentatrActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            // TODO add your handling code here:
            titulo.setText("Transferir saldo");
            dinero.setText("Saldo a transferir");
            adestino.setVisible(true);
            ndestino.setVisible(true);
            ncdestino.setVisible(true);
            dinero.setVisible(true);
            tcdestino.setVisible(true);
            ncuenta.setVisible(true);
            boton.setVisible(true);
            boton.setText("Transferir");
            campo1.setVisible(true);
            ntransf.setVisible(true);
            tipotra.setVisible(true);
            ncuentatr.setVisible(true);
            atransf.setVisible(true);
            boton.setText("Transferir");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            // TODO add your handling code here:
            Movimientos m=new Movimientos();
            m.setVisible(true);
            String nc=numeroc.getText();
            m.setmovimientos(nc);
            
        } catch (Exception ex) {
            Logger.getLogger(Cuenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cuenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adestino;
    private javax.swing.JTextField atransf;
    private javax.swing.JButton boton;
    private javax.swing.JTextField campo1;
    private javax.swing.JLabel dinero;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel ltitulo;
    private javax.swing.JLabel ncdestino;
    private javax.swing.JComboBox<String> ncuenta;
    private javax.swing.JTextField ncuentatr;
    private javax.swing.JLabel ndestino;
    private javax.swing.JTextField ntransf;
    private javax.swing.JLabel numeroc;
    private javax.swing.JLabel salida;
    private javax.swing.JLabel tcdestino;
    private javax.swing.JComboBox<String> tipotra;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
