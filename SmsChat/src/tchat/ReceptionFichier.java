/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tchat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import static tchat.Interface.fir;
import static tchat.Interface.ta;

/**
 *
 * @author Papa Babacar Ndiaye
 */
public class ReceptionFichier extends Thread {

    Socket s;

    public ReceptionFichier(Socket s) {
        this.s = s;

    }

    public void run() {
        InputStream is = null;
        try {
            is = s.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String messag = "";
            String messag2 = "";
            while (true) {
                String nom = br.readLine();
                String st = br.readLine();
                if (st != null) {
                    if (st.equals(("<<<<<<<<<<<< DEBUT DU FICHIER >>>>>>>>>>>>"))) {
                        while (!(st.equals(("<<<<<<<<<<<<< FIN DU FICHIER >>>>>>>>>>>>>")))) {
                            messag += "               " + st + "\n";
                            st = br.readLine();
                            if (!(st.equals(("<<<<<<<<<<<<< FIN DU FICHIER >>>>>>>>>>>>>")))) {
                                messag2 += st + "\n";
                            }
                        }
                        messag += "               " + st + "\n";
                        ta.append(messag);
                        copier(messag2, nom);
                        messag = "";
                        messag2 = "";
                        
                        long start = System.currentTimeMillis();
                        long end = start + 10 * 1000; // 60 seconds * 1000 ms/sec
                        long end2 = start + 5 * 100; 
                        long end3 = start + 1 * 1000;
                       while (System.currentTimeMillis() < end) {  
                            fir.setEnabled(true);
                            while (System.currentTimeMillis() < end2) {    
                            }
                            fir.setEnabled(false);
                            end2 += 1 * 1000;
                            while (System.currentTimeMillis() < end3) {   
                            }
                            end3 +=  1 * 1000;
                        }
                       fir.setEnabled(true);
                    }
                }
            }
        } catch (IOException ex) {
            //Logger.getLogger(Reception.class.getName()).log(Level.SEVERE, null, ex);
           // System.out.println("conection perdue");
          //  JOptionPane.showMessageDialog(null, "Problme de réseau", "Connexion au réseau impossible.", JOptionPane.WARNING_MESSAGE);

        } finally {
            try {
                is.close();
            } catch (IOException ex) {
                // Logger.getLogger(Reception.class.getName()).log(Level.SEVERE, null, ex);
                //System.out.println("conection perdue");
               // JOptionPane.showMessageDialog(null, "Problme de réseau", "Connexion au réseau impossible.", JOptionPane.WARNING_MESSAGE);
            }
        }

    }

    public static void copier(String mes, String nom) {
        try {
            FileWriter fichierEcriture = new FileWriter("./Fichiers Reçus/" + nom, false);
            BufferedWriter bufferecriture = new BufferedWriter(fichierEcriture);
            bufferecriture.write(mes);

            bufferecriture.close();
            fichierEcriture.close();

        } catch (FileNotFoundException ex) {
           // Logger.getLogger(ReceptionFichier.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            //Logger.getLogger(ReceptionFichier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
