package com.exercici0303;

public class Usuari {
    public void mostrarPreferencies() {
        ConfiguracioGlobal configuracio = ConfiguracioGlobal.getInstance();
        System.out.println("Idioma: " + configuracio.getIdioma() + ", Zona Horaria: " + configuracio.getZonaHoraria());

        // Fràncès: Configuration du système en langue ABC et fuseau horaire de DEF
        // Dothraki: Thorat system ma chekof ABC ma asavvaja DEF.
    }
}
