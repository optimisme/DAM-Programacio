package com.project;

public class Usuari {
    public void mostrarPreferencies() {
        ConfiguracioGlobal config = ConfiguracioGlobal.getInstance();
        System.out.println("Idioma: " + config.getIdioma() + ", Zona Horaria: " + config.getZonaHoraria());
    }
}

