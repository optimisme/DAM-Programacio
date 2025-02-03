package com.exercici0400;

import java.util.ArrayList;
import java.util.Scanner;

public class Input extends Component {

    private String label;
    
    public Input(int x, int y, int width, int height, String label) {
        super(x, y, width, height);
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
