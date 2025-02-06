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
   /* 
        Text txt0 = new Text(1, 0, 3, 4, "0123456789AB", 3, false, "left");
        Text txt1 = new Text(7, 2 , 3, 5, "(*)( )(-)( )(*)", 3, false, "left");
        Text txt2 = new Text(22, 6 , 4, 3, "abcdefghijkl", 3, false, "left");
*/


        HashMap<Integer, String[]> mapMnu = new HashMap<>();
        String[] arr0 = {"Sortir", "sortir", "exit"};
        mapMnu.put(0, arr0);
        String[] arr1 = {"Alinear esquerra", "esquerra", "left"};
        mapMnu.put(0, arr1);
        String[] arr2 = {"Alinear dreta", "dreta", "right"};
        mapMnu.put(0, arr2);
        String[] arr3 = {"Alineció centrada", "centrat", "center"};
        mapMnu.put(0, arr3);

        Menu mnu0 = new Menu(1, 1, 20, 8, "Titol menú", mapMnu, false);
        Menu mnu1 = new Menu(22, 1, 25, 8, "Titol menú", mapMnu, true);

        ArrayList<Component> components = new ArrayList<>();
        components.add(mnu0);
        components.add(mnu1);

        Container container = new Container(50, 10, components);
        container.draw();
    }
}