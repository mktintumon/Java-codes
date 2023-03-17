package main;

import shapes.Triangle;

public class Main {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(3.0, 4.2, 5.2);
        System.out.printf("Area: " + "%.3f",triangle.getArea());
        System.out.println("\nPerimeter: " + triangle.getPerimeter());
    }
}
