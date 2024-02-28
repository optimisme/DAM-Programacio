package com.project;

public class Sistema {
    public void configurarSistema() {
        ConfiguracioGlobal config = ConfiguracioGlobal.getInstance();
        System.out.println("Configurant sistema amb idioma " + config.getIdioma() + " i zona horària " + config.getZonaHoraria());
    }
}

