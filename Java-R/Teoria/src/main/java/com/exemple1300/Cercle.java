package com.exemple1300;

public class Cercle extends Poligon {
    private double radi;

    public Cercle(double x, double y, double radi) {
        super(x, y);
        this.radi = radi;
    }

    @Override
    public double calcularArea() {
        return Math.PI * radi * radi;
    }

    @Override
    public double calcularPerimetre() {
        return 2 * Math.PI * radi;
    }
}

