package com.project;

import java.sql.Timestamp;

public class Observation {

    private int observationId;
    private int telescopeId;
    private int bodyId;
    private Timestamp dateTime;
    private String description;
  
    public Observation(int observationId, int telescopeId, int bodyId, Timestamp dateTime, String description) {
      this.observationId = observationId;
      this.telescopeId = telescopeId;
      this.bodyId = bodyId;
      this.dateTime = dateTime;
      this.description = description;
    }
  
    public int getObservationId() {
      return observationId;
    }
  
    public int getTelescopeId() {
      return telescopeId;
    }
  
    public int getBodyId() {
      return bodyId;
    }
  
    public Timestamp getDateTime() {
      return dateTime;
    }
  
    public String getDescription() {
      return description;
    }
  
    @Override
    public String toString() {
      return "Observation [observationId=" + observationId + ", telescopeId=" + telescopeId + ", bodyId=" + bodyId + ", dateTime=" + dateTime + ", description=" + description + "]";
    }
  }
  
