package com.project;

public class Cotxe {
    private String color;
    private String marca;
    private String model;
    private int cilindrada;
    private int any;

    Cotxe(String color, String marca, String model, int cilindrada, int any) {
        this.color = color;
        this.marca = marca;
        this.model = model;
        this.cilindrada = cilindrada;
        this.any = any;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String value) {
        this.color = value;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String value) {
        this.marca = value;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String value) {
        this.model = value;
    }

    public int getCilindrada() {
        return this.cilindrada;
    }

    public void setCilindrada(int value) {
        this.cilindrada = value;
    }

    public int getAny() {
        return this.any;
    }

    public void setAny(int value) {
        this.any = value;
    }

    @Override
    public String toString() {
        return "Model: " + this.marca + " " + this.model + "; Color: " + this.color + "; Cilindrada: " + this.cilindrada + "cc; Any: " + this.any;
    }
}
