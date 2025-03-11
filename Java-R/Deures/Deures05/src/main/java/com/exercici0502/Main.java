package com.exercici0502;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    // Fes anar aquest programa amb:
    // ./run.sh com.exercici0502.Main
    
    public static void main(String[] args) {
        AppData db = AppData.getInstance();

        Olimpiades olm = new Olimpiades();

        olm.crearTaules();

        Atleta atleta1 = olm.afegirAtleta("Usain Bolt", 34, "Jamaica", false);
        Atleta atleta2 = olm.afegirAtleta("Michael Phelps", 36, "EUA", false);

        Esport atletisme = olm.afegirEsport("Atletisme", "Velocitat");
        Esport natacio = olm.afegirEsport("Natació", "Aigua");

        Competicio competicio1 = olm.afegirCompeticio(atletisme, "Estadi Olímpic", "2024-07-23");
        Competicio competicio2 = olm.afegirCompeticio(natacio, "Piscina Olímpica", "2024-07-24");

        olm.afegirParticipant(atleta1, competicio1, 1, "Or");
        olm.afegirParticipant(atleta2, competicio2, 1, "Or");

        System.out.println("\nAtletes:");
        olm.llistarAtletes();

        System.out.println("\nMedaller:");
        olm.mostrarMedaller();

        db.close();
    }
}
