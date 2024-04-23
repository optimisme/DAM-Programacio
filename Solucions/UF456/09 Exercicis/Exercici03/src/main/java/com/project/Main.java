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

    private static void crearTaules() {
    
        AppData db = AppData.getInstance();
        db.update("SET FOREIGN_KEY_CHECKS=0;");


        // Crear taula alumnes
        db.update("DROP TABLE IF EXISTS alumnes");
        db.update("CREATE TABLE alumnes (" +
                "id_alumne INTEGER AUTO_INCREMENT," +
                "nom TEXT," +
                "cognoms TEXT," +
                "data_naixement DATE," +
                "PRIMARY KEY (id_alumne))");
    
        // Crear taula professors
        db.update("DROP TABLE IF EXISTS professors");
        db.update("CREATE TABLE professors (" +
                "id_professor INTEGER AUTO_INCREMENT," +
                "nom TEXT," +
                "especialitat TEXT," +
                "PRIMARY KEY (id_professor))");
    
        // Crear taula assignatures
        db.update("DROP TABLE IF EXISTS assignatures");
        db.update("CREATE TABLE assignatures (" +
                "id_assignatura INTEGER AUTO_INCREMENT," +
                "nom TEXT," +
                "hores_setmanals INTEGER," +
                "id_professor INTEGER," +
                "PRIMARY KEY (id_assignatura)," +
                "FOREIGN KEY (id_professor) REFERENCES professors(id_professor))");
    
        // Crear taula aules
        db.update("DROP TABLE IF EXISTS aules");
        db.update("CREATE TABLE aules (" +
                "id_aula INTEGER AUTO_INCREMENT," +
                "nom TEXT," +
                "capacitat INTEGER," +
                "PRIMARY KEY (id_aula))");
    
        // Crear taula alumne_assignatura
        db.update("DROP TABLE IF EXISTS alumne_assignatura");
        db.update("CREATE TABLE alumne_assignatura (" +
                "id_alumne INTEGER," +
                "id_assignatura INTEGER," +
                "FOREIGN KEY (id_alumne) REFERENCES alumnes(id_alumne)," +
                "FOREIGN KEY (id_assignatura) REFERENCES assignatures(id_assignatura))");
    }    

    private static void afegirAlumne(String nom, String cognoms, Date dataNaixement) {
        AppData db = AppData.getInstance();
        db.update("INSERT INTO alumnes (nom, cognoms, data_naixement) VALUES ('" + nom + "', '" + cognoms + "', '" + dataNaixement + "')");
    }

    private static void afegirProfessor(String nom, String especialitat) {
        AppData db = AppData.getInstance();
        db.update("INSERT INTO professors (nom, especialitat) VALUES ('" + nom + "', '" + especialitat + "')");
    }

    private static void afegirAssignatura(String nom, int horesSetmanals, int idProfessor) {
        AppData db = AppData.getInstance();
        db.update("INSERT INTO assignatures (nom, hores_setmanals, id_professor) VALUES ('" + nom + "', " + horesSetmanals + ", " + idProfessor + ")");
    }

    private static void afegirAula(String nom, int capacitat) {
        AppData db = AppData.getInstance();
        db.update("INSERT INTO aules (nom, capacitat) VALUES ('" + nom + "', " + capacitat + ")");
    }

    private static void inscriureAlumneAssignatura(int idAlumne, int idAssignatura) {
        AppData db = AppData.getInstance();
        db.update("INSERT INTO alumne_assignatura (id_alumne, id_assignatura) VALUES (" + idAlumne + ", " + idAssignatura + ")");
    }

    private static void llistarAlumnes() {
        AppData db = AppData.getInstance();
        List<Map<String, Object>> result = db.query("SELECT * FROM alumnes");
        for (Map<String, Object> row : result) {
            System.out.println("ID: " + row.get("id_alumne") + ", Nom: " + row.get("nom") + ", Cognoms: " + row.get("cognoms") + ", Data de Naixement: " + row.get("data_naixement"));
        }
    }
    
    private static void llistarProfessors() {
        AppData db = AppData.getInstance();
        List<Map<String, Object>> result = db.query("SELECT * FROM professors");
        for (Map<String, Object> row : result) {
            System.out.println("ID: " + row.get("id_professor") + ", Nom: " + row.get("nom") + ", Especialitat: " + row.get("especialitat"));
        }
    }
    
    private static void llistarAssignatures() {
        AppData db = AppData.getInstance();
        List<Map<String, Object>> result = db.query("SELECT a.*, p.nom AS nom_professor FROM assignatures a LEFT JOIN professors p ON a.id_professor = p.id_professor");
        for (Map<String, Object> row : result) {
            System.out.println("ID: " + row.get("id_assignatura") + ", Nom: " + row.get("nom") + ", Hores Setmanals: " + row.get("hores_setmanals") + ", Professor: " + row.get("nom_professor"));
        }
    }
    
    private static void llistarAules() {
        AppData db = AppData.getInstance();
        List<Map<String, Object>> result = db.query("SELECT * FROM aules");
        for (Map<String, Object> row : result) {
            System.out.println("ID: " + row.get("id_aula") + ", Nom: " + row.get("nom") + ", Capacitat: " + row.get("capacitat"));
        }
    }
    
    private static void llistarAssignaturesAlumne(int idAlumne) {
        AppData db = AppData.getInstance();
        List<Map<String, Object>> result = db.query("SELECT a.nom FROM assignatures a JOIN alumne_assignatura aa ON a.id_assignatura = aa.id_assignatura WHERE aa.id_alumne = " + idAlumne);
        System.out.println("Assignatures per l'alumne ID " + idAlumne + ":");
        for (Map<String, Object> row : result) {
            System.out.println("- " + row.get("nom"));
        }
    }
    
    private static void llistarAlumnesAssignatura(int idAssignatura) {
        AppData db = AppData.getInstance();
        List<Map<String, Object>> result = db.query("SELECT al.nom, al.cognoms FROM alumnes al JOIN alumne_assignatura aa ON al.id_alumne = aa.id_alumne WHERE aa.id_assignatura = " + idAssignatura);
        System.out.println("Alumnes inscrits a l'assignatura ID " + idAssignatura + ":");
        for (Map<String, Object> row : result) {
            System.out.println("- " + row.get("nom") + " " + row.get("cognoms"));
        }
    }

    private static int obtenirIdAlumnePerNom(String nom, String cognoms) {
        AppData db = AppData.getInstance();
        String sql = "SELECT id_alumne FROM alumnes WHERE nom = '" + nom + "' AND cognoms = '" + cognoms + "'";
        List<Map<String, Object>> result = db.query(sql);
        if (result.isEmpty()) {
            System.out.println("No s'ha trobat cap alumne amb el nom: " + nom + " " + cognoms);
            return -1;
        } else {
            return (int) result.get(0).get("id_alumne");
        }
    }
    
    private static int obtenirIdAssignaturaPerNom(String nomAssignatura) {
        AppData db = AppData.getInstance();
        String sql = "SELECT id_assignatura FROM assignatures WHERE nom = '" + nomAssignatura + "'";
        List<Map<String, Object>> result = db.query(sql);
        if (result.isEmpty()) {
            System.out.println("No s'ha trobat cap assignatura amb el nom: " + nomAssignatura);
            return -1;
        } else {
            return (int) result.get(0).get("id_assignatura");
        }
    }  
    
    private static int obtenirIdProfessorPerNom(String nomProfessor) {
        AppData db = AppData.getInstance();
        String sql = "SELECT id_professor FROM professors WHERE nom = '" + nomProfessor + "'";
        List<Map<String, Object>> result = db.query(sql);
        if (result.isEmpty()) {
            System.out.println("No s'ha trobat cap professor amb el nom: " + nomProfessor);
            return -1;
        } else {
            return (int) result.get(0).get("id_professor"); // Corregit de 'id_assignatura' a 'id_professor'
        }
    }    
}
