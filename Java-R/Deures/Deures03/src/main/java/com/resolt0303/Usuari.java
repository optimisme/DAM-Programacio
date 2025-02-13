package com.resolt0303;

public class Usuari {
    public void mostrarPreferencies() {
        ConfiguracioGlobal configuracio = ConfiguracioGlobal.getInstance();
        System.out.println("Idioma: " + configuracio.getIdioma() + ", Zona Horaria: " + configuracio.getZonaHoraria());

        // Fràncès: Configuration du système en langue ABC et fuseau horaire de DEF
        // Dothraki: Thorat system ma chekof ABC ma asavvaja DEF.
        switch (configuracio.getIdioma()) {
            case "English":
                System.out.println("Language " + configuracio.getIdioma() + ", Timezone " + configuracio.getZonaHoraria());
                break;
            case "Català":
                System.out.println("Idioma " + configuracio.getIdioma() + ", Zona horària " + configuracio.getZonaHoraria());
                break;
            case "Francès":
                System.out.println("Langue " + configuracio.getIdioma() + ", Fuseau horaire de " + configuracio.getZonaHoraria());
                break;
            case "Dothraki":
                System.out.println("Chekof " + configuracio.getIdioma() + ", Asavvaja " + configuracio.getZonaHoraria());
                break;
            default:
                break;
        }
    }
}
