package edu.upc.eetac.dsa.javabasics.ex9;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * Created by kenshin on 30/09/15.
 */
public class ServerApp {

    public static void main(String[] args) throws IOException {
        System.out.println("port of server");
        Scanner cin = new Scanner(System.in);
        int port = cin.nextInt();

        ServerSocket serverSocket = new ServerSocket(port);/** posem el server a escoltar*/
        while(true)
        {
            Socket con = serverSocket.accept();/** Si tenim alguna conexio la acceptem*/
            (new Thread(new ThreadServer(con))).start();

        }


    }
}
