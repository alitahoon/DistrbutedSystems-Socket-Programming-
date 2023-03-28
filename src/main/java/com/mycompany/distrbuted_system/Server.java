package com.mycompany.distrbuted_system;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ali Tahoon
 */
public class Server {

    private static final int serverPort = 1100;

    public Server() {
        ServerSocket server;
        try {
            server = new ServerSocket(serverPort);
            Socket client = server.accept();
            handleConnectionInMuiltiThreads(client);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void handleConnectionInSingleThread(Socket client) {
        try {
            try (client) {
                DataInputStream is;
                DataOutputStream os;
                is = new DataInputStream(client.getInputStream());
                os = new DataOutputStream(client.getOutputStream());
//                //Recieving from client
//                System.out.println("Recieving from client " + is.readLine());
                //Sending to client
                os.writeBytes("hello client from server");
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void handleConnectionInMuiltiThreads(Socket client) {
        while (true) {
            try {
                try (client) {
                    DataInputStream is;
                    DataOutputStream os;
                    is = new DataInputStream(client.getInputStream());
                    os = new DataOutputStream(client.getOutputStream());
                    //Sending to client
                    os.writeBytes("hello client from server");
                    //Recieving from client
                    System.out.println("Recieving from client " + is.readLine());
                    is.close();
                    os.close();
                    client.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
