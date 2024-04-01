package com.project;

public class Flora implements Identifiable {
    private int id;
    private String nomComu;
    private String nomCientific;
    private int idPais;
    private String descripcio;
    private String habitat;

    public Flora(int id, String nomComu, String nomCientific, int idPais, String descripcio, String habitat) {
        this.id = id;
        this.nomComu = nomComu;
        this.nomCientific = nomCientific;
        this.idPais = idPais;
        this.descripcio = descripcio;
        this.habitat = habitat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomComu() {
        return nomComu;
    }

    public void setNomComu(String nomComu) {
        this.nomComu = nomComu;
    }

    public String getNomCientific() {
        return nomCientific;
    }

    public void setNomCientific(String nomCientific) {
        this.nomCientific = nomCientific;
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public void save() {
        String sql;
        if (this.id == 0) {
            // Nova flora
            sql = "INSERT INTO flora (nom_comu, nom_cientific, id_pais, habitat, descripcio) VALUES (\""
                  + this.nomComu + "\", \""
                  + this.nomCientific + "\", "
                  + this.idPais + ", \""
                  + this.habitat + "\", \""
                  + this.descripcio + "\")";
        } else {
            // Actualitzar flora existent
            sql = "UPDATE flora SET nom_comu = \"" + this.nomComu
                  + "\", nom_cientific = \"" + this.nomCientific
                  + "\", id_pais = " + this.idPais
                  + ", habitat = \"" + this.habitat
                  + "\", descripcio = \"" + this.descripcio
                  + "\" WHERE id = " + this.id;
        }
        AppData.getInstance().update(sql);
    
        // Si és nova, obtenir l'ID generat
        if (this.id == 0) {
            this.id = Main.obtenirIdFloraPerNomComu(this.nomComu);
        }
    }

    @Override
    public String toString() {
        return "Flora { Id: " + id + ", Nom Comú: \"" + nomComu + "\", Nom Científic: \"" + nomCientific +
               "\", Pais: " + idPais + ", Habitat: \"" + habitat + "\" }";
    }
}
