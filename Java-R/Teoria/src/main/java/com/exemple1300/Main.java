package com.exemple1300;

public class Main {
    public static void main(String[] args) {
        // Cercle a la posicó x=10, y=10 de radi 5
        Cercle cercle = new Cercle(10, 10, 5);
        System.out.println("Cercle amb radi 5:");
        System.out.println("Àrea: " + cercle.calcularArea());
        System.out.println("Perímetre: " + cercle.calcularPerimetre());

        // Rectangle a la posició x=10, y=100 amb amplada 4 i altura 5
        Rectangle rectangle = new Rectangle(10, 100, 4, 5);
        System.out.println("\nRectangle amb amplada 4 i altura 5:");
        System.out.println("Àrea: " + rectangle.calcularArea());
        System.out.println("Perímetre: " + rectangle.calcularPerimetre());

        // Triangle a la posició x=10, y=150 amb costats 3, 4, 5
        Triangle triangle = new Triangle(10, 150, 3, 4, 5);
        System.out.println("\nTriangle amb costats 3, 4, 5:");
        System.out.println("Àrea: " + triangle.calcularArea());
        System.out.println("Perímetre: " + triangle.calcularPerimetre());
    }
}
