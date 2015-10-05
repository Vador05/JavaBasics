package edu.upc.eetac.dsa.javabasics.ex7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by kenshin on 30/09/15.
 */
public class ClientApp {
    public static void main(String[] args) throws IOException {
        String IP = args[0];/**Agafem la IP dels arguments*/
        int port = Integer.parseInt(args[1]);/**agafem el port dels arguments que hem passat*/

        Socket con = new Socket(IP, port);/**creem una nova conn*/
        BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String rebut = reader.readLine();/** llegim el que ens arribe*/
        System.out.println(rebut);/**Ho mostrem per pantalla*/
    }

}
