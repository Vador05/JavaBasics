package edu.upc.eetac.dsa.javabasics.ex6;

import java.awt.*;

/**
 * Created by kenshin on 30/09/15.
 */
public class Buffer {
    private char[] buffer = new char[32];
    int contador = 0;

    public synchronized char lectura() {
        char temp = '\0';
        if (contador > 0) {
            temp = buffer[0];
            for (int i = 0; i < contador - 1; i++) {
                buffer[i] = buffer[i + 1];
            }contador--;
        } else {
            System.out.println("EL BUFFER ESTA BUIT");
        }

        return temp;
    }

    public synchronized void escritura(char novato) {
        if (contador < 32) {
            buffer[contador] = novato;
            contador++;
        } else {
            System.out.println("LO HEMOS PERDIDO TT , EL BUFFER ESTA LLENO " + novato + " HA MUERTO");
        }
    }

}
