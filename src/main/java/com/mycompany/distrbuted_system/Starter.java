package com.mycompany.distrbuted_system;

import java.util.Scanner;

/**
 *
 * @author Ali Tahoon
 */
public class Starter {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        if (scan.next().equals("server")) {
            scan.close();
            //server code 
            System.err.println("hello from server");
            new Server();

        } else {
            scan.close();
            //client code
            System.err.println("hello from clint");
            new Client();

        }
    }
}
