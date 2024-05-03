package com.project;

public class LanguageVerbal extends Language {
    private boolean hasSyntax;

    public LanguageVerbal(String name, String planetOrigin, int complexity, boolean telepathic, boolean hasSyntax) {
        super(name, planetOrigin, complexity, telepathic);
        this.hasSyntax = hasSyntax;
    }

    public LanguageVerbal(int id, String name, String planetOrigin, int complexity, boolean telepathic, boolean hasSyntax) {
        super(id, name, planetOrigin, complexity, telepathic);
        this.hasSyntax = hasSyntax;
    }

    @Override
    public String getInsertSQL() {
        return String.format("INSERT INTO languages (name, planet_origin, complexity, telepathic, has_syntax, type) VALUES ('%s', '%s', %d, '%s', '%s', 'Verbal')",
                             MainA.escapeSQL(name), MainA.escapeSQL(planetOrigin), complexity, telepathic ? "1" : "0", hasSyntax ? "1" : "0");
    }

    @Override
    public String toString() {
        return "- ID: " + id + ", Name: " + name + ", Planet Origin: " + planetOrigin + ", Complexity: " + complexity + ", Telepathic: " + (telepathic ? "Yes" : "No") + ", Uses gestures: " + (hasSyntax ? "Yes" : "No");
    }
}