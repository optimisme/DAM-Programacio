package com.project;

public final class SingletonDades {
  
    private static SingletonDades instance;
    public String value;
 
    private SingletonDades(String value) {
        this.value = value;
    }
 
    public static SingletonDades getInstance(String value) {
        if (instance == null) {
            instance = new SingletonDades(value);
        }
        return instance;
    }

    @Override
    public String toString() {
        return "Valor: " + value;
    }
 }