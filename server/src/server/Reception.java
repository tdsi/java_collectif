/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ouz
 */
public class Reception extends Thread{
    Socket s;

    public Reception(Socket s) {
        this.s = s;
    }
    @Override
    public void run() {
        //System.out.println("test");
        InputStream is=null;
        try {
            is = s.getInputStream();
        } catch (IOException ex) {
            Logger.getLogger(Reception.class.getName()).log(Level.SEVERE, null, ex);
        }
        //flux de caractère
        InputStreamReader isr=new InputStreamReader(is);
        BufferedReader br=new BufferedReader(isr);
        while(true){
            String str=null;
            try {
                str = br.readLine();
            } catch (IOException ex) {
                Logger.getLogger(Reception.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(str);
        }
    }
}
