package com.exercici0400;

import java.util.ArrayList;

public class Table extends Component {

    private ArrayList<String> headers;
    private ArrayList<Integer> widths;
    private ArrayList<String> aligns;
    private ArrayList<ArrayList<String>> rows;
    
    public Table(int x, int y, int width, int height, String title, ArrayList<String> headers, ArrayList<Integer> widths, ArrayList<String> aligns, ArrayList<ArrayList<String>> rows) {
        super(x, y, width, height, title);
        this.headers = headers;
        this.widths = widths;
        this.aligns = aligns;
        this.rows = rows;
    }

    public ArrayList<String> render() {
        ArrayList<String> rst = new ArrayList<String>();

        // Afegir linia buida al principi
        rst.add(0, " ".repeat(width)); 

        String capcelera = "";
        for (int cnt = 0; cnt < headers.size(); cnt = cnt + 1) {
            String header = headers.get(cnt);
            int width = widths.get(cnt);

            capcelera = capcelera + header;
            
            if (cnt < (headers.size() - 1)) {
                capcelera = capcelera + "|";
            }
        }
        rst.add(1, " " + capcelera + " ");


        for (int i = 2; i < height; i++) {
            rst.add(i, "x".repeat(width));
        }

        return rst;
    } 
}
