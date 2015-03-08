/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client1;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author ouz
 */
public class Client1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Socket s=new Socket("10.153.2.104", 2015);
        System.out.println("server trouve");
        
        new Emission(s).start();
        new Reception(s).start();
    }
    
}
