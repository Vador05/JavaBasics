package edu.upc.eetac.dsa.javabasics.ex6;

/**
 * Created by kenshin on 30/09/15.
 */
public class ThreadLector implements Runnable {
    char lectura = 0;
    String salida = "";
    Buffer b;
    public ThreadLector(Buffer buf){
        b=buf;
    }

    public void run() {
        while (lectura != '\n') {
            lectura = b.lectura();


                salida = salida + lectura;

        }
        System.out.println(salida);
    }
}