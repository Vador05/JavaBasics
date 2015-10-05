package edu.upc.eetac.dsa.javabasics.ex9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by kenshin on 30/09/15.
 */
public class ClientApp {

    private BufferedReader reader;
    private PrintWriter writer;
    private String IP;
    private int port;
    private Socket con;

    public void Join(Socket con, String name) throws IOException {
        reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
        writer = new PrintWriter(con.getOutputStream());/**Creem l'escriptor*/
        writer.println("JOIN " + name);/**Obtenim la hora del sistema*/
        writer.flush();/**Ho enviem per la connexió*/
    }

    public void Msg(Socket con, String msg) throws IOException {
        writer = new PrintWriter(con.getOutputStream());/**Creem l'escriptor*/
        writer.println("MESSAGE"+msg);/**Obtenim la hora del sistema*/
        writer.flush();/**Ho enviem per la connexió*/
    }

    public void Leave(Socket con) throws IOException {
        writer = new PrintWriter(con.getOutputStream());/**Creem l'escriptor*/
        writer.println("LEAVE");/**Obtenim la hora del sistema*/
        writer.flush();/**Ho enviem per la connexió*/
    }

    public void main(String[] args) throws IOException {
        System.out.println("IP of chat server: ");
        Thread th = new Thread(new ThreadClient(con));
        Scanner cin = new Scanner(System.in);
        IP = cin.next();
        System.out.println("port of server");
        port = cin.nextInt();
       con= new Socket(IP, port);/**creem una nova conn*/
        System.out.println("userID:");
        String name = cin.next();
        reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
        this.Join(con, name);
        while (true) {
            String msg = cin.next();
            if (msg != null) {
                Msg(con, msg);
            } else Leave(con);
        }
    }

}
