package com.resolt0303;

public class Sistema {
    public void configurarSistema() {
        ConfiguracioGlobal configuracio = ConfiguracioGlobal.getInstance();
        
        // Fràncès: Configuration du système en langue ABC et fuseau horaire de DEF
        // Dothraki: Thorat system ma chekof ABC ma asavvaja DEF.
        switch (configuracio.getIdioma()) {
            case "English":
                System.out.println("Setting up language " + configuracio.getIdioma() + " and timezone " + configuracio.getZonaHoraria());
                break;
            case "Català":
                System.out.println("Configurant sistema amb idioma " + configuracio.getIdioma() + " i zona horària " + configuracio.getZonaHoraria());
                break;
            case "Francès":
                System.out.println("Configuration du système en langue " + configuracio.getIdioma() + " et fuseau horaire de " + configuracio.getZonaHoraria());
                break;
            case "Dothraki":
                System.out.println("Thorat system ma chekof " + configuracio.getIdioma() + " ma asavvaja " + configuracio.getZonaHoraria());
                break;
            default:
                break;
        }
    }
}
