package com.project;

public class Fauna implements Identifiable {
    private int id;
    private String nomComu;
    private String nomCientific;
    private int idPais;
    private String descripcio;
    private String habitat;

    public Fauna(int id, String nomComu, String nomCientific, int idPais, String descripcio, String habitat) {
        this.id = id;
        this.nomComu = nomComu;
        this.nomCientific = nomCientific;
        this.idPais = idPais;
        this.descripcio = descripcio;
        this.habitat = habitat;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNomComu() {
        return nomComu;
    }

    public String getNomCientific() {
        return nomCientific;
    }

    public int getIdPais() {
        return idPais;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public String getHabitat() {
        return habitat;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNomComu(String nomComu) {
        this.nomComu = nomComu;
    }

    public void setNomCientific(String nomCientific) {
        this.nomCientific = nomCientific;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public void save() {
        String sql;
        if (this.id == 0) {
            // Nova fauna
            sql = "INSERT INTO fauna (nom_comu, nom_cientific, id_pais, descripcio, habitat) VALUES (\""
                  + this.nomComu + "\", \""
                  + this.nomCientific + "\", "
                  + this.idPais + ", \""
                  + this.descripcio + "\", \""
                  + this.habitat + "\")";
        } else {
            // Actualitzar fauna existent
            sql = "UPDATE fauna SET nom_comu = \"" + this.nomComu
                  + "\", nom_cientific = \"" + this.nomCientific
                  + "\", id_pais = " + this.idPais
                  + ", descripcio = \"" + this.descripcio
                  + "\", habitat = \"" + this.habitat
                  + "\" WHERE id = " + this.id;
        }
        AppData.getInstance().update(sql);

        // Si és nova, actualitzar l'ID de l'objecte
        if (this.id == 0) {
            this.id = Main.obtenirIdFaunaPerNomComu(this.nomComu);
        }
    }

    @Override
    public String toString() {
        return "Fauna { Id: " + id + ", Nom Comú: \"" + nomComu + "\", Nom Científic: \"" + nomCientific +
               "\", Pais: " + idPais + ", Habitat: \"" + habitat + "\" }";
    }
}
