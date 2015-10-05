package edu.upc.eetac.dsa.javabasics.ex9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.List;

/**
 * Created by kenshin on 1/10/15.
 */
public class ThreadClient implements Runnable {
    Socket con;


    public ThreadClient(Socket c) {
        con = c;
    }

    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String rebut = reader.readLine();/** llegim el que ens arribe*/
            System.out.println(rebut);/**Ho mostrem per pantalla*/
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
