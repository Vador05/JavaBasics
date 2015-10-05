package edu.upc.eetac.dsa.javabasics.ex1;

/**
 * Created by kenshin on 23/09/15.
 */
public class Tree {
    int alt;
    String nom;

    public Tree(int a, String b) {
        this.alt = a;
        this.nom = b;
    }

    public Tree(int a) {
        this.alt = a;
        this.nom = null;
    }

    public Tree(String b) {
        this.alt = 0;
        this.nom = b;
    }

    public Tree() {
        this.alt = 0;
        this.nom = null;
    }



    public void Descripción() {
        if (this.alt == 0) {
            if (nom != null) {
                System.out.println("Un " + this.nom);
            } else {
                System.out.println("Un árbol");
            }
        } else {
            if (this.nom != null) {
                System.out.println("Un " + this.nom + " de " + this.alt + " metros");
            } else {
                System.out.println("Un árbol de " + this.alt + " metros");
            }
        }
    }
}
