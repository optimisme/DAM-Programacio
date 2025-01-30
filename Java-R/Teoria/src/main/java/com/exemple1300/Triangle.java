package com.exemple1300;

public class Triangle extends Poligon {
    private double costat1;
    private double costat2;
    private double costat3;

    public Triangle(double x, double y, double costat1, double costat2, double costat3) {
        super(x, y);
        this.costat1 = costat1;
        this.costat2 = costat2;
        this.costat3 = costat3;
    }

    @Override
    public double calcularArea() {
        // Fórmula de Heron per calcular l'àrea d'un triangle donats els seus tres costats
        double s = (costat1 + costat2 + costat3) / 2;
        return Math.sqrt(s * (s - costat1) * (s - costat2) * (s - costat3));
    }

    @Override
    public double calcularPerimetre() {
        return costat1 + costat2 + costat3;
    }
}

