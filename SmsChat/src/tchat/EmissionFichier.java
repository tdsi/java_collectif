 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tchat;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import static tchat.Interface.ta;

/**
 *
 * @author Papa Babacar Ndiaye
 */
public class EmissionFichier extends Thread {

    Socket s;
    static PrintWriter pw;
    static BufferedOutputStream bos;

    public EmissionFichier(Socket s) {
        this.s = s;
    }

    public void run() {
        OutputStream os = null;

        try {
            os = s.getOutputStream();
            bos = new BufferedOutputStream(os);

            pw = new PrintWriter(os, true);

            while (true) {
                //permet d'attendre et de ne pas fermet le frux 
            }

        } catch (IOException ex) {
            //  Logger.getLogger(Emission.class.getName()).log(Level.SEVERE, null, ex);
            //System.err.println("conection perdue");
        } finally {
            try {
                bos.close();
                os.close();
            } catch (IOException ex) {
               // System.err.println("conection perdue");
                //Logger.getLogger(Emission.class.getName()).log(Level.SEVERE, null, ex);
               // JOptionPane.showMessageDialog(null, "Problme de réseau", "Connexion au réseau impossible.", JOptionPane.WARNING_MESSAGE);
            }
        }

    }

    public static void ecrirefichier(File fichier) {

        FileReader fr = null;
        
        try {
            fr = new FileReader(fichier);
            String nom = fichier.getName();
            String str = "";
            int i = 0;
            //Lecture des données
            while ((i = fr.read()) != -1) {
                str += (char) i;
            }
            if (pw != null) {
                //ecrir sur le fluxS
                pw.println(nom);//le nom du fichier en premier lieu
                pw.println("<<<<<<<<<<<< DEBUT DU FICHIER >>>>>>>>>>>>");
                pw.println(str);
                pw.println("<<<<<<<<<<<<< FIN DU FICHIER >>>>>>>>>>>>>");
                ta.append("<<<< Fichier "+nom +"  Envoyé Avec Succé>>>>\n");
                //System.err.println(str);
            } else {
                System.err.println("pas de client connecté ");
              //  JOptionPane.showMessageDialog(null, "pas de client connecté", "Problme de réseau", JOptionPane.WARNING_MESSAGE);

            }

        } catch (FileNotFoundException ex) {
           // Logger.getLogger(EmissionFichier.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
           // Logger.getLogger(EmissionFichier.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
               // Logger.getLogger(EmissionFichier.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
