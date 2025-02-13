package com.exercici0400;

import java.util.ArrayList;

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
    
    
}