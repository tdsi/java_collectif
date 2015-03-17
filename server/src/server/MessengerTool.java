/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author ouz
 */
public class MessengerTool {
    public static void demarrer(String ip, int port){
		try {
			//tentative d'�tre client
			Socket s = new Socket(ip,port);
			dialoguer(s);
			System.out.println("Client démarré, dialogue possible");
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			
			try {
				//reservation du port
				ServerSocket ss=new ServerSocket(port);
				System.out.println("Serveur démarré ...");
				//ecoute du port
				Socket s = ss.accept();
				System.out.println("Connection acceptée, dialogue possible");
				dialoguer(s);
								
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
				
	}//fin methode demarrer
    public static void dialoguer(Socket s){
		Emission emetteur = new Emission(s);
		emetteur.start();
		Reception recepteur=new Reception(s);
		recepteur.start();
		
	}//fin mehode dialoguer
}
