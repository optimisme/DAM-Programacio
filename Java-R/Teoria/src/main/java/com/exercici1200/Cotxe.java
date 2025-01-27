package com.exercici1200;

public class Cotxe {
    private String color;
    private String marca;
    private String model;
    private Integer cilindrada;
    private Integer any;

    public Cotxe(String color, String marca, String model, Integer cilindrada, Integer any) {
        this.color = color;
        this.marca = marca;
        this.model = model;
        this.cilindrada = cilindrada;
        this.any = any;
        
    }

    public Cotxe(String color, String marca, String model, Integer cilindrada) {
        this.color = color;
        this.marca = marca;
        this.model = model;
        this.cilindrada = cilindrada;
        
        
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(Integer cilindrada) {
        this.cilindrada = cilindrada;
    }

    public Integer getAny() {
        return any;
    }

    public void setAny(Integer any) {
        this.any = any;
    }
/* 
    @Override
    public String toString() {
        return "Model:" + marca + model + "; Color:"+ color + "; Cilindrada:" + cilindrada + "; Any:" + any ;
    }*/
}