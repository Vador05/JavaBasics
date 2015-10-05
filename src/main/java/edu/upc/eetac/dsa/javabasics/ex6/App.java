package edu.upc.eetac.dsa.javabasics.ex6;

import edu.upc.eetac.dsa.javabasics.ex5.Heredado;
import edu.upc.eetac.dsa.javabasics.ex5.Interface;

/**
 * Created by kenshin on 29/09/15.
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        Buffer bf = new Buffer();
        Thread Th1 = new Thread(new ThreadLector(bf));
        Thread Th2 = new Thread(new ThreadGenerator(bf));

        Th2.start();
        Th1.start();

        Th2.join();
        Th1.join();

    }
}
