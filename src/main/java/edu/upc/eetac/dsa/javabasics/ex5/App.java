package edu.upc.eetac.dsa.javabasics.ex5;

/**
 * Created by kenshin on 29/09/15.
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        Heredado Th1 = new Heredado();
        Thread Th2 = new Thread(new Interface());
        Th1.start();
        Th2.start();

        Th1.join();
        Th2.join();

        System.out.println("S acabao la juerga!!");
    }
}
