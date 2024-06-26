package com.project;

public class LanguageSign extends Language {
    private boolean usesGestures;

    public LanguageSign(String name, String planetOrigin, int complexity, boolean telepathic, boolean usesGestures) {
        super(name, planetOrigin, complexity, telepathic);
        this.usesGestures = usesGestures;
    }

    public LanguageSign(int id, String name, String planetOrigin, int complexity, boolean telepathic, boolean usesGestures) {
        super(id, name, planetOrigin, complexity, telepathic);
        this.usesGestures = usesGestures;
    }

    @Override
    public String getInsertSQL() {
        return String.format("INSERT INTO languages (name, planet_origin, complexity, telepathic, uses_gestures, type) VALUES ('%s', '%s', %d, '%s', '%s', 'Sign')",
                             MainA.escapeSQL(name), MainA.escapeSQL(planetOrigin), complexity, telepathic ? "1" : "0", usesGestures ? "1" : "0");
    }

    @Override
    public String toString() {
        return "- ID: " + id + ", Name: " + name + ", Planet Origin: " + planetOrigin + ", Complexity: " + complexity + ", Telepathic: " + (telepathic ? "Yes" : "No") + ", Uses gestures: " + (usesGestures ? "Yes" : "No");
    }
}

