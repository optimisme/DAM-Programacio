package com.exercici0400;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;


public class Menu extends Component {

    private String title;
    private HashMap<Integer, MenuItem> items;
    private boolean lastZero;
    
    public Menu(int x, int y, int width, int height, String title, HashMap<Integer, MenuItem> items, boolean lastZero) {
        super(x, y, width, height);
        this.title = title;
        this.items = items;
        this.lastZero = lastZero;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public String getTitle() {
        return title;
    }

    public void setLastZero(boolean value) {
        this.lastZero = value;
    }

    public boolean getLastZero() {
        return lastZero;
    }

    public int getSelection(String text) {
        return -1;
    }

    private String fixLine(String line) {
        if (line.length() < width) {
            String espais = " ".repeat(width - line.length());
            return line + espais;
        } else {
            String nouString = line.substring(0, width);
            return nouString;
        }
    }

    public ArrayList<String> render() { 
        ArrayList<String> rst = new ArrayList<String>();
        boolean doneZero = false; 

        int begin = 0;
        if (lastZero) {
            begin = 1;
        }

        rst.add(" ".repeat(width));
        for (int i = begin; i < height; i++) {
             
            if (items.get(i) != null) {
                String linia = " "+ i + "." + items.get(i).getTitle();
                rst.add(fixLine(linia));
            } else {
                if (lastZero && doneZero == false && items.get(0) != null) {
                    String line = " " + "0." + items.get(0).getTitle();
                    rst.add(fixLine(line));
                    doneZero = true;
                }
                String linia = " ".repeat(width);
                rst.add(linia);
            } 
        }
        
        return rst;

    } 
}
