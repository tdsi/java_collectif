/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tchat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author Papa Babacar Ndiaye
 */
public class ServeurFichier extends Thread {

    static Socket s;
    static Socket socketClient2;

    public void run() {
        try {

            s = new Socket("127.0.0.1", 2017);
            ReceptionFichier gt = new ReceptionFichier(s);
            gt.start();
            (new EmissionFichier(s)).start();
         //   System.out.println("serveur retrouve");

        } catch (IOException ex) {
            //Logger.getLogger(ClassMain.class.getName()).log(Level.SEVERE, null, ex);
           // System.out.println("serveur fichier non trouve");
        }
            try {

                ServerSocket socketServeur2 = new ServerSocket(2017);
              //  System.out.println("Lancement du serveur de fichier");
                while (true) {
                    socketClient2 = socketServeur2.accept();
                    ReceptionFichier gt = new ReceptionFichier(socketClient2);
                    gt.start();
                    (new EmissionFichier(socketClient2)).start();
                    //System.out.println("connection acceptee");
                    //fir.setEnabled(true);

                }

            } catch (IOException ex) {
                // Logger.getLogger(ClassMain.class.getName()).log(Level.SEVERE, null, ex);
                //System.out.println("conection serfich perdue");
                JOptionPane.showMessageDialog(null, "Probleme de réseau", "Connexion au réseau impossible.", JOptionPane.WARNING_MESSAGE);
            }
        }
}
