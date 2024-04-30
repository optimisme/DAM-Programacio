package com.project;

public class ApiBackend {
    public void executarAccio(String accio) {
        RegistreAccionsSingleton.getInstance().registrarAccio("API: " + accio);
    }
}

