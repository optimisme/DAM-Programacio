package com.project;

public class Pais implements Identifiable {
    private int id;
    private String nom;

    public Pais(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void save() {
        String sql;
        if (this.id == 0) {
            // Nou país
            sql = "INSERT INTO paisos (nom) VALUES ('" + this.nom + "')";
        } else {
            // Actualitzar país existent
            sql = "UPDATE paisos SET nom = '" + this.nom + "' WHERE id = " + this.id;
        }
        AppData.getInstance().update(sql);
    
        // Si és nou, obtenir l'ID generat
        if (this.id == 0) {
            this.id = Main.obtenirIdPaisPerNom(this.nom);
        }
    }

    @Override
    public String toString() {
        return "Pais { Id: " + id + ", Nom: \"" + nom + "\" }";
    }
}
