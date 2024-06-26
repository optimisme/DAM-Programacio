package com.project;

public class Main {
    public static void main(String[] args) {
        // Configuració inicial
        ConfiguracioGlobal config = ConfiguracioGlobal.getInstance();
        config.setIdioma("Castellà");
        config.setZonaHoraria("CET");

        // Usuari i Sistema utilitzen la configuració
        Usuari usuari = new Usuari();
        usuari.mostrarPreferencies();

        Sistema sistema = new Sistema();
        sistema.configurarSistema();
    }
}
