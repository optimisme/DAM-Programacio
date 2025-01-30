package com.exemple1300;

public class Poligon {
    // Atributs comuns a tots els polígons podrien anar aquí
    public double x;
    public double y;

    Poligon(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double calcularArea() {
        return 0; // Implementació genèrica, la idea és sobreescriure en subclasses
    }

    public double calcularPerimetre() {
        return 0; // Implementació genèrica, la idea és sobreescriure en subclasses
    }
}