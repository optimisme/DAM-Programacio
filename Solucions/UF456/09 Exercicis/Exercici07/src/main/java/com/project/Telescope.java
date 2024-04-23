package com.project;

public class Telescope {

    private int telescopeId;
    private String name;
    private String location;
    private String type;
    private double diameter;

    public Telescope(int telescopeId, String name, String location, String type, double diameter) {
        this.telescopeId = telescopeId;
        this.name = name;
        this.location = location;
        this.type = type;
        this.diameter = diameter;
    }

    public int getTelescopeId() {
        return telescopeId;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getType() {
        return type;
    }

    public double getDiameter() {
        return diameter;
    }

    @Override
    public String toString() {
        return "Telescope [" +
                "telescopeId=" + telescopeId +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", type='" + type + '\'' +
                ", diameter=" + diameter +
                ']';
    }
}
