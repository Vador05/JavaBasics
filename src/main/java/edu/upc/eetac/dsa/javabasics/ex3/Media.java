package edu.upc.eetac.dsa.javabasics.ex3;

import build.tools.javazic.Main;
import com.sun.java.util.jar.pack.*;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

/**
 * Created by kenshin on 24/09/15.
 */
public class Media {

    public static void main(String[] args) {
       /* final JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog();

        if (returnVal == JFileChooser.APPROVE_OPTION)

                System.out.println( Calcular(fc.getSelectedFile().getName()));

         */
        Scanner cin= new Scanner(System.in);
        System.out.println("Dame la buena ruta");
        String path = cin.nextLine();
        System.out.println(Calcular(path));
    }


    public static double Calcular(String path) {
        File lista = new File(path);
        FileReader lectorsito;
        try {
            lectorsito = new FileReader(lista);

            BufferedReader buffersito = new BufferedReader(lectorsito);
            int Counter = 1;
            double sumita = 0;
            try {
                String linea = buffersito.readLine();

                while (linea != null) {
                    if (Double.parseDouble(linea) < 1000) {
                        sumita += Double.parseDouble(linea);
                        linea = buffersito.readLine();
                        Counter++;
                    } else {
                        System.out.println("BigNumberException");
                        linea = null;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Format Exception");
                try {
                    lectorsito.close();
                } catch (IOException g) {
                    g.printStackTrace();
                }
            }
            try {
                lectorsito.close();
            } catch (IOException g) {
                g.printStackTrace();
            }
            sumita = sumita / Counter;
            return (sumita);
        } catch (java.io.FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("No se haya el fichero indicado");
        }
        return (0);
    }

}
