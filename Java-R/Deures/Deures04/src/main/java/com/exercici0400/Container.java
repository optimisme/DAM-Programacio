package com.exercici0400;

import java.util.ArrayList;

public class Container extends Component {
 

    private ArrayList<Component> components;

    public Container(int width, int height, ArrayList<Component> components) {
        super(0, 0, width, height);

        this.components = components;
    }

    private static void clearScreen() {
        try {
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> render() {
        ArrayList<String> rst = new ArrayList<String>();
        return rst;
    } 

    public void draw() {
        ArrayList<String> buffer;

        clearScreen();

        // Inicia el buffer amb espais blancs
        buffer = new ArrayList<>();
        for (int cnt = 0; cnt < height; cnt = cnt + 1) {
            String linia = " ".repeat(width);
            buffer.add(linia);
        }

        // Dibuixa els components al buffer
        for (Component cmp : components) {
            ArrayList<String> buffCmp = cmp.render();
            int posY = cmp.getY();
            for (String lineCmp : buffCmp) {
                if (posY < height) {
                    int posX = cmp.getX();
                    if (posX < width) {
                        String buffLine = buffer.get(posY);
                        String partA = buffLine.substring(0, posX);
                        String partB = lineCmp;
                        if (posX + partB.length() > width) {
                            partB = partB.substring(0, width - posX);
                        }
                        String partC = buffLine.substring(posX + partB.length());
                        buffer.set(posY, partA + partB + partC);
                    }
                }
                posY++;
            }
        }
        
        // Escriu al buffer al terminal
        for (String line : buffer) {
            System.out.println(line);
        }
    }
}
