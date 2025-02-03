package com.exercici0400;

import java.util.ArrayList;
import java.util.HashMap;

public class Menu extends Component {

    private String title;
    private HashMap<Integer, Object> items;
    private boolean lastZero;
    
    public Menu(int x, int y, int width, int height, String title, HashMap<Integer, Object> items, boolean lastZero) {
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
        return rst;
    } 
}
