/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tchat;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import static tchat.Interface.ta;

/**
 *
 * @author Papa Babacar Ndiaye
 */
public class Emission extends Thread {

    Socket s;
    static PrintWriter pw;

    public Emission(Socket s) {
        this.s = s;
    }

    public void run() {
        OutputStream os = null;

        try {
            os = s.getOutputStream();
            pw = new PrintWriter(os, true);

            while (true) {
                //permet d'attendre et de ne pas fermet le frux 
            }

        } catch (IOException ex) {
            //  Logger.getLogger(Emission.class.getName()).log(Level.SEVERE, null, ex);
          // System.out.println("conection perdue");
           
        } finally {
            try {
                os.close();
            } catch (IOException ex) {
                //System.out.println("conection perdue ");
              // Logger.getLogger(Emission.class.getName()).log(Level.SEVERE, null, ex);
               //JOptionPane.showMessageDialog(null, "Problme de réseau", "Connexion au réseau impossible.", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public static void ecrire(String mess) {
        
        
        if (pw != null) {
            //ecrir sur le fluxS
            ta.append(mess + '\n');
            pw.println(mess);

        } else {
            ta.append("!!!!pas de client!!!!"+ '\n');
            System.err.println("pas de client connecté ");
          //  JOptionPane.showMessageDialog(null, "pas de client connecté", "Problme de réseau", JOptionPane.WARNING_MESSAGE);

        }
    }
}
