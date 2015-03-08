/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ouz
 */
public class Emission extends Thread{
    Socket s;

    public Emission(Socket s) {
        this.s = s;
    }
    @Override
    public void run() {
        OutputStream os=null;
        try {
            os = s.getOutputStream();
        } catch (IOException ex) {
            Logger.getLogger(Emission.class.getName()).log(Level.SEVERE, null, ex);
        }
        PrintWriter pw=new PrintWriter(os, true);
        Scanner sc=new Scanner(System.in);
        while(true){
            //lire sur le clavier
            String str=sc.nextLine();
            
            //ecrire sur le flux
            pw.println(str);
           // System.err.println(str);
        }
        
    }
}
