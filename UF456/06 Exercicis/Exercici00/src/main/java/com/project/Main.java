package com.project;


public class Main {
    public static void main(String[] args) {
        Cercle cercle = new Cercle(5);
        System.out.println("Cercle amb radi 5:");
        System.out.println("Àrea: " + cercle.calcularArea());
        System.out.println("Perímetre: " + cercle.calcularPerimetre());

        // Creem un rectangle amb amplada 4 i altura 5
        Rectangle rectangle = new Rectangle(4, 5);
        System.out.println("\nRectangle amb amplada 4 i altura 5:");
        System.out.println("Àrea: " + rectangle.calcularArea());
        System.out.println("Perímetre: " + rectangle.calcularPerimetre());

        // Creem un triangle amb costats 3, 4, 5
        Triangle triangle = new Triangle(3, 4, 5);
        System.out.println("\nTriangle amb costats 3, 4, 5:");
        System.out.println("Àrea: " + triangle.calcularArea());
        System.out.println("Perímetre: " + triangle.calcularPerimetre());
    }
}