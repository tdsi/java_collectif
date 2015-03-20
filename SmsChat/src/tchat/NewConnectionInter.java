/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tchat;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Papa Babacar Ndiaye
 */
public class NewConnectionInter extends JFrame implements ActionListener {

    JLabel labeladdr = new JLabel("Adresse IP :");
    JLabel labelPort = new JLabel(" Port :");
    JTextField newaddr = new JTextField();
    JTextField newport = new JTextField();
    JLabel lab = new JLabel(" Entrez l'Adresse IP et le Port");
    JButton ok = new JButton("OK");
    JButton anul = new JButton("ANNULER");
    JFrame fenetre = new JFrame();
    static Interface interfacnew = new Interface();
     Socket snew;
   public  NewConnectionInter() {
        super();
        fenetre.setSize(250, 120);
        fenetre.setLocation(200, 300);
        fenetre.setTitle("nouveau chat");
        fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fenetre.setLayout(new GridLayout(3, 2));
        fenetre.add(labeladdr);
        fenetre.add(newaddr);
        fenetre.add(labelPort);
        fenetre.add(newport);
        fenetre.add(ok);
        fenetre.add(anul);
        ok.addActionListener(this);
        anul.addActionListener(this);
        fenetre.setVisible(true);
        fenetre.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object composant = ae.getSource();
        if (composant == ok) {
            if (!"".equals(newport.getText()) && !"".equals(newaddr.getText())) {
                // System.out.println("newaddr : " + newaddr.getText() + " newport :" + newport.getText());
              
                try {
                    int port = Integer.parseInt(newport.getText());
                    String add = newaddr.getText();
                    snew = new Socket(add, port);
                    fenetre.setVisible(false);
                    // System.out.println("serveur retrouve");
                   ClassMain cm = new ClassMain();
                   cm.lancementclient(add, port);
                   
                } catch (IOException ex) {
                    //Logger.getLogger(ClassMain.class.getName()).log(Level.SEVERE, null, ex);
                    //  System.out.println("serveur non trouve");
                    JOptionPane.showMessageDialog(null, "Adresse IP ou Port incorrecte", "Connexion au réseau impossible.", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Saisie incomplete", "<<< Erreur >>>", JOptionPane.WARNING_MESSAGE);
            }
        } else if (composant == anul) {
            newaddr.setText("");
            newport.setText("");
        }
    }
   // public static void main(String[] args) {
    //   NewConnectionInter f = new NewConnectionInter();
//}
}
