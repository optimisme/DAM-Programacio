package com.exercici0303;

public class Sistema {
    public void configurarSistema() {
        ConfiguracioGlobal configuracio = ConfiguracioGlobal.getInstance();
        System.out.println("Configurant sistema amb idioma " + configuracio.getIdioma() + " i zona horària " + configuracio.getZonaHoraria());
    }
}
