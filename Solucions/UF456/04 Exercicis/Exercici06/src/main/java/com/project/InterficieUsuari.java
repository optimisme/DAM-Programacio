package com.project;

public class InterficieUsuari {
    public void realitzarAccio(String accio) {
        RegistreAccionsSingleton.getInstance().registrarAccio("UI: " + accio);
    }
}

