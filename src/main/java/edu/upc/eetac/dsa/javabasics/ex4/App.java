package edu.upc.eetac.dsa.javabasics.ex4;

import com.sun.xml.internal.fastinfoset.util.CharArray;
import sun.org.mozilla.javascript.ast.SwitchCase;

import java.util.Scanner;

/**
 * Created by kenshin on 26/09/15.
 */
public class App {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        BInary binarsito = new BInary();

        System.out.println("que numero quieres guardar?");
        binarsito.num = (cin.nextInt());
        System.out.println("que decimal quieres guardar?");
        binarsito.dec = (cin.nextDouble());
        System.out.println("que caracter quieres guardar?");
        char [] temp = cin.next().toCharArray();
        binarsito.car = temp[0];


        System.out.println("Dame la buena ruta");
        String path = cin.next();
        binarsito.Guardar(path);

        System.out.println("Leyendo el archivo");
        BInary bin = new BInary(path);
        System.out.println("=============================================================");
        System.out.println("===================CONTENIDO DEL ARCHIVO=====================");
        System.out.println();
        System.out.println("Int: "+bin.num);
        System.out.println("Double: "+bin.dec);
        System.out.println("Char: "+bin.car);
        System.out.println();
        System.out.println("======================FIN DEL ARCHIVO========================");





    }
}
