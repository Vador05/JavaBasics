package edu.upc.eetac.dsa.javabasics.ex2;

/**
 * Created by kenshin on 23/09/15.
 */
public class AppInheritance {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[2];
        shapes[0] = new Circle(2.5);
        shapes[1] = new Rectangle(3, 5);
        for (Shape shape : shapes)https://www.dropbox.com/sh/yapivn44kqd6ehu/AABZvR6pyoVL0diNG-X-bYy6a?dl=0
            System.out.println(shape + " with area = " + shape.area);
    }
}