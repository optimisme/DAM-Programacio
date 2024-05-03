package com.project;

class UOR268 {
    int UOR201; 
    String UOR202; 
    int UOR203; 

    // Constructor
    public UOR268(int UOR201, String UOR202, int UOR203) {
        this.UOR201 = UOR201;
        this.UOR202 = UOR202;
        this.UOR203 = UOR203;
    }

    // Getters
    public int getUOR201() { return UOR201; }
    public String getUOR202() { return UOR202; }
    public int getUOR203() { return UOR203; }

    // Setters
    public void setUOR201(int UOR201) { this.UOR201 = UOR201; }
    public void setUOR202(String UOR202) { this.UOR202 = UOR202; }
    public void setUOR203(int UOR203) { this.UOR203 = UOR203; }

    // toString
    @Override
    public String toString() {
        return "UOR206{" +
                "UOR201=" + UOR201 +
                ", UOR202='" + UOR202 + '\'' +
                ", UOR203=" + UOR203 +
                '}';
    }
}
