package com.project;

public class OcellVolador extends Ocell implements Volador {
    public OcellVolador(String nom, int edat, String colorPlomatge) {
        super(nom, edat, colorPlomatge);
    }

    @Override
    public void volar() {
        System.out.println(nom + " està volant!");
    }
}
