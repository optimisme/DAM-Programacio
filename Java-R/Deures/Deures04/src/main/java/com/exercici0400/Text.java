package com.exercici0400;

import java.util.ArrayList;

public class Text extends Component implements Alignable {

    private String text;
    private int truncate;
    private boolean ellipsis;
    private String align;
    
    public Text(int x, int y, int width, int height, String text, int truncate, boolean ellipsis, String align) {
        super(x, y, width, height);
        this.text = text;
        this.truncate = truncate;
        this.ellipsis = ellipsis;
        this.align = align;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setTruncate(int truncate) {
        this.truncate = truncate;
    }

    public int getTruncate() {
        return truncate;
    }

    public void setEllipsis(boolean ellipsis) {
        this.ellipsis = ellipsis;
    }

    public boolean getEllipsis() {
        return ellipsis;
    }

    public void setAlign(String value) {
        this.align = value;
    }

    public String getAlign() {
        return align;
    }

    public ArrayList<String> render() {
        ArrayList<String> rst = new ArrayList<String>();

        String[] arrText = text.split(" ");

        for (int i = 0; i < height; i++) {
            rst.add("x".repeat(width));
        }

        return rst;
    } 
}
