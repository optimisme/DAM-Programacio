package com.exemple1300;

public class Rectangle extends Poligon {
    private double amplada;
    private double altura;

    public Rectangle(double x, double y, double amplada, double altura) {
        super(x, y);
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

