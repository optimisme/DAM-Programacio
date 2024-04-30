package com.project;

public abstract class Publicacio {
    protected String titol;
    protected int anyPublicacio;

    public Publicacio(String titol, int anyPublicacio) {
        this.titol = titol;
        this.anyPublicacio = anyPublicacio;
    }

    public abstract String descripcioDetallada();

    @Override
    public String toString() {
        return "Publicacio{titol='" + titol + "', anyPublicacio=" + anyPublicacio + "}";
    }

    public String getTitol() { return titol; }
    public int getAnyPublicacio() { return anyPublicacio; }
}
