package com.exercici0400;

import java.util.ArrayList;
import java.util.HashMap;

public class Menu extends Component {

    private String title;
    private HashMap<Integer, String[]> items;
    private boolean lastZero;
    
    public Menu(int x, int y, int width, int height, String title, HashMap<Integer, String[]> items, boolean lastZero) {
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

    public ArrayList<String> render() {
        ArrayList<String> rst = new ArrayList<String>();

        for (int cntLinia = 0; cntLinia < height; cntLinia = cntLinia + 1) {
            String linia = "x".repeat(width);
            rst.add(linia);
        }

        return rst;
    } 
}
