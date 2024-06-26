package com.project;

public class Main {
    public static void main(String[] args) {
        InterficieUsuari ui = new InterficieUsuari();
        ApiBackend api = new ApiBackend();

        ui.realitzarAccio("Inici de sessió");
        api.executarAccio("Consulta de dades");
        ui.realitzarAccio("Actualització de perfil");
        api.executarAccio("Desconnexió");

        RegistreAccionsSingleton.getInstance().mostrarAccions();
    }
}
