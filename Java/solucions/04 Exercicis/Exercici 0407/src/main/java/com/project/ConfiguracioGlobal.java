package com.project;

public class ConfiguracioGlobal {
    private static ConfiguracioGlobal instancia;
    private String idioma;
    private String zonaHoraria;

    private ConfiguracioGlobal() {
        // Valors predeterminats
        idioma = "Anglès";
        zonaHoraria = "UTC";
    }

    public static synchronized ConfiguracioGlobal getInstance() {
        if (instancia == null) {
            instancia = new ConfiguracioGlobal();
        }
        return instancia;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getZonaHoraria() {
        return zonaHoraria;
    }

    public void setZonaHoraria(String zonaHoraria) {
        this.zonaHoraria = zonaHoraria;
    }
}

