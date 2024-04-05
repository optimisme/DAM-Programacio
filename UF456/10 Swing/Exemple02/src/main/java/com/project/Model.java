package com.project;

public class Model {
    private String name;
    private int age;

    // Constructor
    public Model() {
        this.name = "Unknown";
        this.age = -1;
    }

    // Getters i setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}