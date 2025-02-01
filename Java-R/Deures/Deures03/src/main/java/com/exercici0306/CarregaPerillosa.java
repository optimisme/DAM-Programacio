package com.exercici0306;

public class CarregaPerillosa extends Carrega {

    public CarregaPerillosa(String descripcio, double pes, int nivellPerillositat) {
        super(descripcio, pes);
    }

    public int getNivellPerillositat() {
        return 0;
    }

    public void setNivellPerillositat(int value) {

    }

    @Override
    public String toString() {
        return "";
    }
}
