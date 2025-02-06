package com.exercici0400;

import java.util.ArrayList;

/*
 Estructura ✅
 Components 
 Menús
 Text
 Table
 Input
 */

public class Main {
    public static void main(String[] args) {
   
        Text txt0 = new Text(1, 0, 3, 4, "0123456789AB", 3, false, "left");
        Text txt1 = new Text(7, 2 , 3, 5, "(*)( )(-)( )(*)", 3, false, "left");
        Text txt2 = new Text(22, 6 , 4, 3, "abcdefghijkl", 3, false, "left");

        ArrayList<Component> components = new ArrayList<>();
        components.add(txt0);
        components.add(txt1);
        components.add(txt2);

        Container container = new Container(25, 8, components);
        container.draw();
    }
}