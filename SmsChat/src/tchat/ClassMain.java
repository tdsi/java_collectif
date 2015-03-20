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
import static tchat.Interface.newcon;

/**
 *
 * @author Papa Babacar Ndiaye
 */
public class ClassMain {
    static Socket socketClient;
    static Socket s;
    static int nbcon = 0;
    static Interface interfac = new Interface();
    

    static void lancement(String addr,int port) {
        
        interfac.go();//lencement de l'interface graphiques
       // System.out.println("Lancement du client");
       // System.out.println("connection vers  " + addr + " port " + port);
        ServeurFichier srf = new ServeurFichier();//serveur de fichier pour pouvoire recevoir des fichiers
        srf.start();
        try {

            s = new Socket(addr, port);//on se connecte en ten k client
         // System.out.println("serveur retrouve");
            Reception t = new Reception(s);//Thead de reception
            t.start();
            Emission e = new Emission(s);//thread d'émission
            e.start();

        } catch (IOException ex) {
            //Logger.getLogger(ClassMain.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("serveur non trouve");
        }
        //lencer un serveur pour un autre connection
            try {

                ServerSocket socketServeur = new ServerSocket(port);
              //  System.out.println("Lancement du serveur");
                while (true) {
                    socketClient = socketServeur.accept();
                    System.err.println("connection acceptee");
                    Reception t = new Reception(socketClient);
                    t.start();
                    Emission e = new Emission(socketClient);
                    e.start();
                    //  animation de bouton
                    long start = System.currentTimeMillis();
                        long end = start + 10 * 1000; // 60 seconds * 1000 ms/sec
                        long end2 = start + 5 * 100; 
                        long end3 = start + 1 * 1000;
                       while (System.currentTimeMillis() < end) {  
                            newcon.setEnabled(true);
                            while (System.currentTimeMillis() < end2) {    
                            }
                            newcon.setEnabled(false);
                            end2 += 1 * 1000;
                            while (System.currentTimeMillis() < end3) {   
                            }
                            end3 +=  1 * 1000;
                        }
                       newcon.setEnabled(true);
                       
                }
            } catch (IOException ex) {
                // Logger.getLogger(ClassMain.class.getName()).log(Level.SEVERE, null, ex);
                //System.err.println("conection perdue");
                JOptionPane.showMessageDialog(interfac, "Probléme de réseau", "Connexion au réseau impossible.", JOptionPane.WARNING_MESSAGE);
            }

        
    }
    static void lancementclient(String addr,int port) {
        
        interfac.go();//lencement de l'interface graphiques
       // System.out.println("Lancement du client");
       // System.out.println("connection vers  " + addr + " port " + port);
        ServeurFichier srf = new ServeurFichier();//serveur de fichier pour pouvoire recevoir des fichiers
        srf.start();
        try {

            s = new Socket(addr, port);//on se connecte en ten k client
         // System.out.println("serveur retrouve");
            Reception t = new Reception(s);//Thead de reception
            t.start();
            Emission e = new Emission(s);//thread d'émission
            e.start();

        } catch (IOException ex) {
            //Logger.getLogger(ClassMain.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("serveur non trouve");
        }
    }

    public static void main(String[] args) {
        lancement("127.0.0.1",2015);
    }
}
