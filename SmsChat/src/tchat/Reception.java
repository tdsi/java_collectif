/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tchat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import static tchat.Interface.ta;
//import static smschat.Interface.ta;

/**
 *
 * @author Papa Babacar Ndiaye
 */
public class Reception extends Thread {

    Socket s;

    public Reception(Socket s) {
        this.s = s;
    }

    public void run() {
        InputStream is = null;
        try {
            is = s.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            // String st;
            while (true) {
                String st = br.readLine();
                if (st != null) {
                    ta.append("               " + st + "\n");

                }
            }
        } catch (IOException ex) {
            //Logger.getLogger(Reception.class.getName()).log(Level.SEVERE, null, ex);
            //System.out.println("conection perdue");
            //JOptionPane.showMessageDialog(null, "Probléme de réseau", "Connexion au réseau impossible.", JOptionPane.WARNING_MESSAGE);

        } finally {
            try {
         
                is.close();
            } catch (IOException ex) {
                // Logger.getLogger(Reception.class.getName()).log(Level.SEVERE, null, ex);
               // System.out.println("conection perdue");
                //JOptionPane.showMessageDialog(null, "Problme de réseau", "Connexion au réseau impossible.", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

}
