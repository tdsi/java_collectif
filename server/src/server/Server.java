/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.io.InputStream;
import static java.lang.System.exit;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLServerSocket;

/**
 *
 * @author ouz
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    Socket s;

    public static void main(String[] args) throws IOException {

     MessengerTool.demarrer("127.0.0.1", 5001);
    }

}
