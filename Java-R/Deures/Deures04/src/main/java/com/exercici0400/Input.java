package com.exercici0400;

import java.util.ArrayList;
import java.util.Scanner;

public class Input {

    private String label;
    
    public Input(String label) {
        this.label = label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public String getinput(Scanner scanner) {
        return scanner.nextLine();
    }

    public ArrayList<String> render() {
        ArrayList<String> rst = new ArrayList<String>();
        return rst;
    } 
}
