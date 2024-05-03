package com.project;

public abstract class Language {
    protected int id;
    protected String name;
    protected String planetOrigin;
    protected int complexity;
    protected boolean telepathic;

    // Constructor
    public Language(String name, String planetOrigin, int complexity, boolean telepathic) {
        this.id = -1;  // Assignació inicial, suposant que -1 indica un id no establert
        this.name = name;
        this.planetOrigin = planetOrigin;
        this.complexity = complexity;
        this.telepathic = telepathic;
    }

    public Language(int id, String name, String planetOrigin, int complexity, boolean telepathic) {
        this.id = id;
        this.name = name;
        this.planetOrigin = planetOrigin;
        this.complexity = complexity;
        this.telepathic = telepathic;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPlanetOrigin() {
        return planetOrigin;
    }

    public int getComplexity() {
        return complexity;
    }

    public boolean isTelepathic() {
        return telepathic;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlanetOrigin(String planetOrigin) {
        this.planetOrigin = planetOrigin;
    }

    public void setComplexity(int complexity) {
        this.complexity = complexity;
    }

    public void setTelepathic(boolean telepathic) {
        this.telepathic = telepathic;
    }

    // Mètode abstracte per a obtenir els valors específics per a inserció a la base de dades
    public abstract String getInsertSQL();
}


