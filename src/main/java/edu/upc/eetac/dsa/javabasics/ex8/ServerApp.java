package edu.upc.eetac.dsa.javabasics.ex8;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
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
        DatagramSocket datagramSocket = new DatagramSocket(port);/** posem el server a escoltar*/
        while (true) {

            byte[] buff = new byte[0];/** Si tenim alguna conexio la acceptem*/
            DatagramPacket dp = new DatagramPacket(buff, buff.length);/**Creem Un paquet*/
            datagramSocket.receive(dp);
            ByteArrayOutputStream boss = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(boss);
            dos.writeUTF(sdf.format(System.currentTimeMillis()));
            byte[] data = boss.toByteArray();

            dp = new DatagramPacket(data, data.length, dp.getAddress(), dp.getPort());
            datagramSocket.send(dp);
        }
    }
}
