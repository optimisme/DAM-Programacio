package com.exercici1202;

import java.util.ArrayList;

public class Curs {
    private String nomCurs;
    private String professor;
    private ArrayList<Estudiant> llistaEstudiants;

    public Curs(String nomCurs, String professor) {
        this.nomCurs = nomCurs;
        this.professor = professor;
        this.llistaEstudiants = new ArrayList<>();
    }

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

    public void afegeixEstudiant(Estudiant estudiant){
        llistaEstudiants.add(estudiant);
    }

    public void eliminaEstudiant(String nom) {
        llistaEstudiants.removeIf(estudiant -> estudiant.getNom().equals(nom));
    }

    public void mostraEstudiants() {
        for (Estudiant estudiant : llistaEstudiants) {
            System.out.println(estudiant.getNom() + " - Nota Mitjana: " + estudiant.getNotaMitjana());
        }
    }
}
