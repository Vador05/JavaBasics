package edu.upc.eetac.dsa.javabasics.ex4;

import java.io.*;
import java.math.BigInteger;

/**
 * Created by kenshin on 26/09/15.
 */
public class BInary {

    public int num;
    public double dec;
    public char car;

    public void Guardar(String path) {


        File fl = new File(path);
        try {

/**Creem el lector*/
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(fl));

/**Desem les dades*/
            dos.writeInt(this.num);
            dos.writeDouble(this.dec);
            dos.writeChar(this.car);
/** Tanquem el lector*/
            dos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BInary() {
        num = 0;
        dec = 0;
        car = '\0';

    }

    public BInary(String path) {
        try {
            File lista = new File(path);
            DataInputStream dis = new DataInputStream(new FileInputStream(lista));
            this.num = dis.readInt();
            this.dec = dis.readDouble();
            this.car = dis.readChar();

            dis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
