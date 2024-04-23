package com.project;

public class CelestialBody {

    private int bodyId;
    private String name;
    private String type;
    private double mass;
    private double distance;
  
    public CelestialBody(int bodyId, String name, String type, double mass, double distance) {
      this.bodyId = bodyId;
      this.name = name;
      this.type = type;
      this.mass = mass;
      this.distance = distance;
    }
  
    public int getBodyId() {
      return bodyId;
    }
  
    public String getName() {
      return name;
    }
  
    public String getType() {
      return type;
    }
  
    public double getMass() {
      return mass;
    }
  
    public double getDistance() {
      return distance;
    }
  
    @Override
    public String toString() {
      return "CelestialBody [bodyId=" + bodyId + ", name=" + name + ", type=" + type + ", mass=" + mass + ", distance=" + distance + "]";
    }
  }
  