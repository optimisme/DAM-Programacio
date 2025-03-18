package com.exercici0502;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Atleta {
    protected int id;
    protected String nom;
    protected int edat;
    protected String pais;
    final private boolean equip;

    public Atleta(int id, String nom, int edat, String pais, boolean equip) {
        this.id = id;
        this.nom = nom;
        this.edat = edat;
        this.pais = pais;
        this.equip = equip;
    }

    public void setNom(String value) {
        this.nom = value;
        updateToDB();
    }

    public void setEdat(int value) {
        this.edat = value;
        updateToDB();
    }

    /** 
     * Actualitza l'objecte a partir de la informacio de la BD
     * fent servir l'id
     */
    public void updateFromDB() {

    }
    
    /**
     * Actualitza la base de dades d'aquest objecte/fila a partir
     * de la informació de l'objecte
     */
    public void updateToDB() {
        String sql = String.format(
            "UPDATE atletes SET nom='%s', edat=%d, pais='%s', equip=%b WHERE id_atleta=%d;",
            nom, edat, pais, equip, id
        );
        AppData.getInstance().update(sql);
    }
}
