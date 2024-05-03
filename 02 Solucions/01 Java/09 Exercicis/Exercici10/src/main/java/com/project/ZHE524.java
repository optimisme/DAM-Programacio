package com.project;

import java.sql.Date;

class ZHE524 {
    int ZHE301; 
    String ZHE302; 
    Date ZHE303;
    String ZHE304; 

    // Constructor
    public ZHE524(int ZHE301, String ZHE302, Date ZHE303, String ZHE304) {
        this.ZHE301 = ZHE301;
        this.ZHE302 = ZHE302;
        this.ZHE303 = ZHE303;
        this.ZHE304 = ZHE304;
    }

    // Getters
    public int getZHE301() { return ZHE301; }
    public String getZHE302() { return ZHE302; }
    public Date getZHE303() { return ZHE303; }
    public String getZHE304() { return ZHE304; }

    // Setters
    public void setZHE301(int ZHE301) { this.ZHE301 = ZHE301; }
    public void setZHE302(String ZHE302) { this.ZHE302 = ZHE302; }
    public void setZHE303(Date ZHE303) { this.ZHE303 = ZHE303; }
    public void setZHE304(String ZHE304) { this.ZHE304 = ZHE304; }

    // toString
    @Override
    public String toString() {
        return "ZHE304{" +
                "ZHE301=" + ZHE301 +
                ", ZHE302='" + ZHE302 + '\'' +
                ", ZHE303='" + ZHE303 + '\'' +
                ", ZHE304='" + ZHE304 + '\'' +
                '}';
    }
}
    
    
    
    
    
    
    
    
