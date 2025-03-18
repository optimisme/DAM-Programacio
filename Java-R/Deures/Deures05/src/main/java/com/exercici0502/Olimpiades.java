package com.exercici0502;

import java.security.InvalidParameterException;
import java.util.ArrayList;

public class Olimpiades {

    private ArrayList<Atleta> atletes;
    private ArrayList<Esport> esports;
    private ArrayList<Competicio> competicions;
    private ArrayList<Participant> participants;

    public Olimpiades() {
        // Iniciar arrays a buits
        this.atletes = new ArrayList<Atleta>();
        this.esports = new ArrayList<Esport>();
        this.competicions = new ArrayList<Competicio>();
        this.participants = new ArrayList<Participant>();
    }

    public void crearTaules() {
        AppData db = AppData.getInstance();
        db.update("DROP TABLE IF EXISTS atletes");
        db.update("DROP TABLE IF EXISTS esports");
        db.update("DROP TABLE IF EXISTS competicions");
        db.update("DROP TABLE IF EXISTS participants");

        String sql = """
        CREATE TABLE IF NOT EXISTS atletes (
        id_atleta INTEGER PRIMARY KEY AUTOINCREMENT,
        nom TEXT NOT NULL,
        edat INT,
        pais TEXT NOT NULL,
        equip BOOLEAN
        )""";
        db.update(sql);

        sql = """
        CREATE TABLE IF NOT EXISTS esports (
        id_esport INTEGER PRIMARY KEY AUTOINCREMENT,
        nom TEXT NOT NULL,
        categoria TEXT NOT NULL
        )
        """;
        db.update(sql);

        sql = """
        CREATE TABLE IF NOT EXISTS competicions (
        id_competicio INTEGER PRIMARY KEY AUTOINCREMENT,
        id_esport INTEGER,
        lloc TEXT NOT NULL,
        data DATE,
        FOREIGN KEY (id_esport) REFERENCES esports(id_esport)
        )
        """;
        db.update(sql);

        sql = """
        CREATE TABLE IF NOT EXISTS participants (
        id_participant INTEGER PRIMARY KEY AUTOINCREMENT,
        id_atleta INTEGER,
        id_competicio INTEGER,
        posicio INT,
        medalla TEXT,
        FOREIGN KEY (id_atleta) REFERENCES atletes(id_atleta),
        FOREIGN KEY (id_competicio) REFERENCES competicions(id_competicio)
        )
        """;
        db.update(sql);

    }

    public Atleta afegirAtleta(String nom,int edat, String pais, boolean equip) {
        AppData db = AppData.getInstance();
        String sql = String.format("INSERT INTO atletes (nom, edat, pais, equip) VALUES ('%s', %d, '%s', %b)", nom, edat, pais, equip);
        Integer id = db.insertAndGetId(sql);

        Atleta nou_Atleta = new Atleta(id, nom, edat, pais, equip);
        this.atletes.add(nou_Atleta);

        return nou_Atleta;
    }

    public Esport afegirEsport(String nom, String categoria) {
        return null;
    }

    public Competicio afegirCompeticio(Esport esport, String lloc, String data) {
        return null;
    }

    public void afegirParticipant(Atleta atleta, Competicio competicio, int posicio, String medalla) {

    }

    public void llistarAtletes() {

    }

    public void mostrarMedaller() {

    }
}
