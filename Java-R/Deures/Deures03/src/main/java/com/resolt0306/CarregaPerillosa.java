package com.resolt0306;

public class CarregaPerillosa extends Carrega {
    private int nivellPerillositat;

    public CarregaPerillosa(String descripcio, double pes, int nivellPerillositat) {
        super(descripcio, pes);
        if (nivellPerillositat < 0 || nivellPerillositat > 5) {
            throw new IllegalArgumentException("El nivell de perillositat ha de ser entre 0 i 5");
        }
        this.nivellPerillositat = nivellPerillositat;
    }

    public int getNivellPerillositat() {
        return nivellPerillositat;
    }

    public void setNivellPerillositat(int nivellPerillositat) {
        if (nivellPerillositat < 0 || nivellPerillositat > 5) {
            throw new IllegalArgumentException("El nivell de perillositat ha de ser entre 0 i 5");
        }
        this.nivellPerillositat = nivellPerillositat;
    }

    @Override
    public String toString() {
        return "CarregaPerillosa[descripcio=" + descripcio + ", pes=" + pes + ", nivellPerillositat=" + nivellPerillositat + "]";
    }
}
