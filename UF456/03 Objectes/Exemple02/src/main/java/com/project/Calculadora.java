package com.project;

public class Calculadora {

    static public int valorCompartit = 0;
    private int a;
    private int b;

    // Constructor
    public Calculadora(int a, int b) {
        this.a = a;
        this.b = b;
    }

    // Suma els atributs de cada instància
    public int sumaValorsInstancia() {
        return a + b;
    }

    // Suma els paràmetres rebuts
    public static int sumaValors(int a, int b) {
        return a + b;
    }

    @Override
    public String toString() {
        return "Compartit:" + Calculadora.valorCompartit + "; a = " + a + "; b = " + b;
    }
}
