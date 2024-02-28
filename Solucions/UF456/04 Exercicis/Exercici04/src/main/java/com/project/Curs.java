package com.project;

import java.util.ArrayList;

public class Curs {
    private String nomCurs;
    private String professor;
    private ArrayList<Estudiant> llistaEstudiants;

    // Constructor
    public Curs(String nomCurs, String professor) {
        this.nomCurs = nomCurs;
        this.professor = professor;
        this.llistaEstudiants = new ArrayList<>();
    }

    // Setters i Getters
    public String getNomCurs() {
        return nomCurs;
    }

    public void setNomCurs(String nomCurs) {
        this.nomCurs = nomCurs;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    // Afegeix un estudiant a la llista
    public void afegeixEstudiant(Estudiant estudiant) {
        llistaEstudiants.add(estudiant);
    }

    // Elimina un estudiant de la llista pel seu nom
    public void eliminaEstudiant(String nom) {
        llistaEstudiants.removeIf(estudiant -> estudiant.getNom().equals(nom));
    }

    // Mostra la llista d'estudiants inscrits al curs
    public void mostraEstudiants() {
        for (Estudiant estudiant : llistaEstudiants) {
            System.out.println(estudiant.getNom() + " - Nota Mitjana: " + estudiant.getNotaMitjana());
        }
    }
}

