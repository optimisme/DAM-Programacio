package com.exercici0400;

import java.util.ArrayList;
import java.util.HashMap;


/*
 Estructura ✅
 Components ✅
 Menús
 Text
 Table
 Input
 */

public class Main {
    public static void main(String[] args) {
   
        Text txt0 = new Text(1, 1, 20, 8, "Lorem ipsum dolor sit amet, consectetur adipiscing elit", 3, false, "left");
        Text txt1 = new Text(22, 1, 25, 8, "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium", 3, false, "left");

/* Exemple Menu
        HashMap<Integer, MenuItem> mapMnu = new HashMap<>();

        mapMnu.put(0, new MenuItem("Sortir", new String[] {"sortir", "exit"}));
        mapMnu.put(1, new MenuItem("Alinear esquerra", new String[]{"esquerra", "left"}));
        mapMnu.put(2, new MenuItem("Alinear dreta", new String[]{"dreta", "right"}));
        mapMnu.put(3, new MenuItem("Alineció centrada", new String[]{"centrat", "center"}));

        Menu mnu0 = new Menu(1, 1, 20, 8, "Titol menú", mapMnu, false);
        Menu mnu1 = new Menu(22, 1, 25, 8, "Titol menú", mapMnu, true);
*/


        ArrayList<Component> components = new ArrayList<>();
        components.add(txt0);
        components.add(txt1);

        Container container = new Container(50, 10, components);
        container.draw();
    }
}