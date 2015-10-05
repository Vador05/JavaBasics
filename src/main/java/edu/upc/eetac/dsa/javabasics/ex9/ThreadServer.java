package edu.upc.eetac.dsa.javabasics.ex9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by kenshin on 1/10/15.
 */
public class ThreadServer {
    Socket soc;
    String name;
    private BufferedReader reader;
    private PrintWriter writer;

    public static List<ThreadServer> threads = Collections.synchronizedList(new ArrayList<ThreadServer>());

    private void send(String msg) {
        writer.println(msg);
    }

    public ThreadServer(Socket con) throws IOException {
        soc = con;
        writer = new PrintWriter(soc.getOutputStream());
        reader = new BufferedReader(new InputStreamReader(soc.getInputStream()));
    }

    public void run() throws IOException {
        threads.add(this);
        String[] temp;
        do {

            String rebut = reader.readLine();/** llegim el que ens arribe*/
            temp = rebut.split(" ", 2);

            if (temp[0].equals("JOIN")) {
                name = temp[1];
            } else if (temp[0].equals("MESSAGE")) {
                for (ThreadServer th : threads) {
                    th.send(name + "> " + temp[1]);
                }/**Keep It Simple, Stupid[KISS]*/
            } else if (temp[0].equals("LEAVE")) {
                for (ThreadServer th : threads) {
                    th.send(name + "> " + "me piro");
                }/**Keep It Simple, Stupid[KISS]*/
            }
        } while (temp[0].equals("LEAVE"));

        threads.remove(this);
        soc.close();

    }
}
