package com.exercici0303;

// Classe ConfiguracioGlobal
public class ConfiguracioGlobal {
    private static ConfiguracioGlobal instancia;
    private String idioma;
    private String zonaHoraria;

    private ConfiguracioGlobal() {
        this.idioma = "Anglès";
        this.zonaHoraria = "UTC";
    }

    public static ConfiguracioGlobal getInstance() {
        if (instancia == null) {
            instancia = new ConfiguracioGlobal();
        }
        return instancia;
    }

    public String getIdioma() {
        return "";
    }

    public void setIdioma(String idioma) {
    }

    public String getZonaHoraria() {
        return "";
    }

    public void setZonaHoraria(String zonaHoraria) {
    }
}