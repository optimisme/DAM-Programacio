package com.project;

public class Rectangle extends Poligon {
    private double amplada;
    private double altura;

    public Rectangle(double amplada, double altura) {
        this.amplada = amplada;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return amplada * altura;
    }

    @Override
    public double calcularPerimetre() {
        return 2 * (amplada + altura);
    }
}

