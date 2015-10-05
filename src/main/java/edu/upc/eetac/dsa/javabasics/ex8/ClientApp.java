package edu.upc.eetac.dsa.javabasics.ex8;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by kenshin on 30/09/15.
 */
public class ClientApp {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.err.println("No has pasado correctamente la ip y el puerto del server");
            System.exit(-1);
        }
        String server = args[0];
        int port = Integer.parseInt(args[1]);

        byte[] data = new byte[0];
        DatagramPacket dp = new DatagramPacket(data, data.length, InetAddress.getByName(server), port);
        DatagramSocket datagramSocket = new DatagramSocket();
        datagramSocket.send(dp);

        byte[] buffer = new byte[1496];
        dp = new DatagramPacket(buffer, buffer.length);
        datagramSocket.receive(dp);
        DataInputStream dis = new DataInputStream(new ByteArrayInputStream(dp.getData()));
        String time = dis.readUTF();
        System.out.println(time);
    }
}
