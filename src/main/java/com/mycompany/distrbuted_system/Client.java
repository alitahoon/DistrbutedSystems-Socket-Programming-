package com.mycompany.distrbuted_system;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ali Tahoon
 */
public class Client {

    private static final int serverPort = 1100;

    public Client() {
        try {
            InetAddress serverIp = InetAddress.getLocalHost();
            Socket client = new Socket(serverIp, serverPort);
            //recieving messages from server
            DataInputStream is= new DataInputStream(client.getInputStream());
            DataOutputStream os=new DataOutputStream(client.getOutputStream());
            String messagefromserver;
            messagefromserver =is.readLine();
            //write messages to server
            os.writeBytes("hello server");
            is.close();
            os.close();
            client.close();
            

        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
