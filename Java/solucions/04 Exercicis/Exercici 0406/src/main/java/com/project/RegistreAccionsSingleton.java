package com.project;

import java.util.ArrayList;
import java.util.List;

public class RegistreAccionsSingleton {
    private static RegistreAccionsSingleton instancia;
    private List<String> accions;

    private RegistreAccionsSingleton() {
        accions = new ArrayList<>();
    }

    public static synchronized RegistreAccionsSingleton getInstance() {
        if (instancia == null) {
            instancia = new RegistreAccionsSingleton();
        }
        return instancia;
    }

    public void registrarAccio(String accio) {
        accions.add(accio);
    }

    public void mostrarAccions() {
        for (String accio : accions) {
            System.out.println(accio);
        }
    }
}

