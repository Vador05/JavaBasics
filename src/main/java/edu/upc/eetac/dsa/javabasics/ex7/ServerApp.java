package edu.upc.eetac.dsa.javabasics.ex7;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;

/**
 * Created by kenshin on 30/09/15.
 */
public class ServerApp {

    public static void main(String[] args) throws IOException {
        int port;
        if (args.length == 1) {
            port = Integer.parseInt(args[0]);
        } else
            port = 12345;/**definim el port*/

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");/**Definim el format de la hora*/
        ServerSocket serverSocket = new ServerSocket(port);/** posem el server a escoltar*/
        while (true) {
            Socket con = serverSocket.accept();/** Si tenim alguna conexio la acceptem*/
            PrintWriter writer = new PrintWriter(con.getOutputStream());/**Creem l'escriptor*/
            writer.println(sdf.format(System.currentTimeMillis()));/**Obtenim la hora del sistema*/
            writer.flush();/**Ho enviem per la connexió*/
        }
    }
}
