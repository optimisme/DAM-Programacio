package com.project;

public class Ecosistema implements Identifiable {
    private int id;
    private String nom;
    private int idPais;
    private String caracteristiques;

    public Ecosistema(int id, String nom, int idPais, String caracteristiques) {
        this.id = id;
        this.nom = nom;
        this.caracteristiques = caracteristiques;
        this.idPais = idPais;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public int getIdPais() {
        return idPais;
    }

    public String getCaracteristiques() {
        return caracteristiques;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public void setCaracteristiques(String caracteristiques) {
        this.caracteristiques = caracteristiques;
    }

    public void save() {
        String sql;
        if (this.id == 0) {
            // Nou ecosistema
            sql = "INSERT INTO ecosistemes (nom, caracteristiques, id_pais) VALUES (\""
                  + this.nom + "\", \""
                  + this.caracteristiques + "\", "
                  + this.idPais + ")";
        } else {
            // Actualitzar ecosistema existent
            sql = "UPDATE ecosistemes SET nom = \"" + this.nom
                  + "\", caracteristiques = \"" + this.caracteristiques
                  + "\", id_pais = " + this.idPais
                  + " WHERE id = " + this.id;
        }
        AppData.getInstance().update(sql);

        // Si és nou, obtenir l'ID generat
        if (this.id == 0) {
            this.id = Main.obtenirIdEcosistemaPerNom(this.nom);
        }
    }

    @Override
    public String toString() {
        return "Ecosistema { Id: " + id + ", Nom: \"" + nom + "\", Id Pais: " + idPais + " }";
    }
}
