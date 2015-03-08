/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;

/**
 *
 * @author ouz
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        ServerSocket ss=new ServerSocket(2015);
        System.out.println("Init du Server");
        Socket s=ss.accept();
        System.out.println("connexion acceptee");
        new Reception(s).start();
        new Emission(s).start();
    }
    
}
