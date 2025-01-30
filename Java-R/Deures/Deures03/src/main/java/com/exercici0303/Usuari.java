package com.exercici0303;

public class Usuari {
    public void mostrarPreferencies() {
        ConfiguracioGlobal configuracio = ConfiguracioGlobal.getInstance();
        System.out.println("Idioma: " + configuracio.getIdioma() + ", Zona Horaria: " + configuracio.getZonaHoraria());
    }
}
