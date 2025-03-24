package com.project;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        AppData db = AppData.getInstance();

        // Crear les taules
        crearTaules();

        // Afegir Professors
        afegirProfessor("Maria Garcia", "Matemàtiques");
        int idMaria = obtenirIdProfessorPerNom("Maria Garcia");

        afegirProfessor("Jordi Pozo", "Literatura");
        int idJordi = obtenirIdProfessorPerNom("Jordi Pozo");

        afegirProfessor("Anna Molina", "Ciències");
        int idAnna = obtenirIdProfessorPerNom("Anna Molina");

        // Afegir Aules
        afegirAula("A101", 30);
        afegirAula("A102", 25);
        afegirAula("B201", 20);

        // Afegir Assignatures
        if (idMaria != -1) {
            afegirAssignatura("Algebra", 4, idMaria);
        }
        int idAlgebra = obtenirIdAssignaturaPerNom("Algebra");

        if (idJordi != -1) {
            afegirAssignatura("Literatura Catalana", 3, idJordi);
        }
        int idLiteraturaCatalana = obtenirIdAssignaturaPerNom("Literatura Catalana");

        if (idAnna != -1) {
            afegirAssignatura("Biologia", 5, idAnna);
        }
        int idBiologia = obtenirIdAssignaturaPerNom("Biologia");

        // Afegir Alumnes
        afegirAlumne("Marc", "Soler", Date.valueOf("2005-03-15"));
        int idMarc = obtenirIdAlumnePerNom("Marc", "Soler");

        afegirAlumne("Laura", "Vidal", Date.valueOf("2004-07-22"));
        int idLaura = obtenirIdAlumnePerNom("Laura", "Vidal");

        afegirAlumne("Iván", "Coll", Date.valueOf("2004-06-10"));
        int idIvan = obtenirIdAlumnePerNom("Iván", "Coll");

        // Inscripcions, comprovant que tant els alumnes com les assignatures existeixen
        if (idMarc != -1 && idAlgebra != -1) {
            inscriureAlumneAssignatura(idMarc, idAlgebra);
        }
        if (idLaura != -1 && idLiteraturaCatalana != -1) {
            inscriureAlumneAssignatura(idLaura, idLiteraturaCatalana);
        }
        if (idIvan != -1) {
            if (idAlgebra != -1) inscriureAlumneAssignatura(idIvan, idAlgebra);
            if (idLiteraturaCatalana != -1) inscriureAlumneAssignatura(idIvan, idLiteraturaCatalana);
            if (idBiologia != -1) inscriureAlumneAssignatura(idIvan, idBiologia);
        }


        // Llistar informació
        System.out.println("Professors:");
        llistarProfessors();

        System.out.println("\nAssignatures:");
        llistarAssignatures();

        System.out.println("\nAules:");
        llistarAules();

        System.out.println("\nAssignatures:");
        llistarAssignaturesAlumne(1);
        llistarAssignaturesAlumne(3);

        System.out.println("\nAlumnes per assignatura:");
        llistarAlumnesAssignatura(1);
        llistarAlumnesAssignatura(2);
        llistarAlumnesAssignatura(3);

        // Tancar la connexió amb la base de dades
        db.close();

        // Forçar la sortida del programa per no esperar a tancar la connexió amb 'MySQL'
        // Assegura't que en aquest punt totes les dades s'han guardat correctament
        if (!"test".equals(System.getProperty("environment"))) {
            System.exit(0);
        }
    }
}
