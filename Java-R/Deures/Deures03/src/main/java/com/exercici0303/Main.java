package com.exercici0303;

public class Main {
    public static void main(String[] args) {

        // Configuració inicial
        ConfiguracioGlobal config = ConfiguracioGlobal.getInstance();
        config.setIdioma("Dothraki");
        config.setZonaHoraria("CET");

        // Usuari i Sistema utilitzen la configuració
        Usuari usuari = new Usuari();
        usuari.mostrarPreferencies();

        Sistema sistema = new Sistema();
        sistema.configurarSistema();
    }
}