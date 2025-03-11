package com.easyText;

import java.util.ArrayList;
import java.util.Arrays;

public class MenuItem {

    private String title;
    private String[] keyWords;
    
    public MenuItem(String title, String[] keyWords) {
        this.title = title;
        this.keyWords = keyWords;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public String[] getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String[] keyWords) {
        this.keyWords = keyWords;
    }
    
    /**
     * Retorna si la paraula està a KeyWords
     * @param word paraula a analitzar
     * @return true si ha trobat la paraula
     */
    public boolean isInKeyWords(String word) {
        return Arrays.asList(keyWords).contains(word);
    }
}