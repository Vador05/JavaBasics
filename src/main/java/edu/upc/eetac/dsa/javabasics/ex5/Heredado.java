package edu.upc.eetac.dsa.javabasics.ex5;

/**
 * Created by kenshin on 29/09/15.
 */
public class Heredado extends Thread {
    Double alacama = 0.0;

    public void run() {
        for (int i = 0; i < 10; i++) {

            System.out.println("Thread heredado me he dormido " + alacama + " ms");
            alacama = Math.random() * 2000;
            try {
                Thread.sleep(alacama.longValue());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
