package com.exercici0400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main { 

    // ./run.sh com.exercici0400.Main
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = "";
        String align = "left";
        ArrayList<Component> components = new ArrayList<>();
        boolean repetirBucle = true;

        while (repetirBucle) {

            HashMap<Integer, MenuItem> mapMnu = new HashMap<>();
    
            mapMnu.put(0, new MenuItem("Sortir", new String[] {"sortir", "exit"}));
            mapMnu.put(1, new MenuItem("Esquerra", new String[] {"esquerra", "left"}));
            mapMnu.put(2, new MenuItem("Dreta", new String[] {"dreta", "right"}));
            mapMnu.put(3, new MenuItem("Centrada", new String[] {"centrat", "center"}));
    
            Menu mnu0 = new Menu(0, 0, 20, 8, "Menú", mapMnu, true);
            Text txt = new Text(21, 0, 25, 8, "Txt", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", 3, false, align);

            components.add(mnu0);
            components.add(txt);

            Container container = new Container(50, 10, components);
            container.draw();

            System.out.print("Escull una opció: ");
            input = scanner.nextLine();

            int selection = mnu0.getSelection(input);
            switch (selection) {
                case 0:
                    repetirBucle = false;
                    break;
                case 1: 
                    align = "left";
                    break;
                case 2: 
                    align = "right";
                    break;
                case 3: 
                    align = "center";
                    break;
                default:
                    break;
            }
        }
        
        scanner.close();
   
/*
        ArrayList<Component> components = new ArrayList<>();

        Text txt0 = new Text(1, 1, 20, 8, "Txt0", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", 3, false, "left");
        Text txt1 = new Text(22, 1, 25, 8, "Txt1", "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium", 3, false, "center");
        components.add(txt0);
        components.add(txt1);

        HashMap<Integer, MenuItem> mapMnu = new HashMap<>();

        mapMnu.put(0, new MenuItem("Sortir", new String[] {"sortir", "exit"}));
        mapMnu.put(1, new MenuItem("Alinear esquerra", new String[]{"esquerra", "left"}));
        mapMnu.put(2, new MenuItem("Alinear dreta", new String[]{"dreta", "right"}));
        mapMnu.put(3, new MenuItem("Alineció centrada", new String[]{"centrat", "center"}));

        Menu mnu0 = new Menu(1, 1, 20, 8, "Titol menú", mapMnu, false);
        Menu mnu1 = new Menu(22, 1, 25, 8, "Titol menú", mapMnu, true);
        components.add(mnu0);
        components.add(mnu1);


        ArrayList<String> tabHeaders0 = new ArrayList<>(Arrays.asList("col0", "col1", "col2"));
        ArrayList<Integer> tabWidth0 = new ArrayList<>(Arrays.asList(5, 8, 10));
        ArrayList<String> tabAligns0 = new ArrayList<>(Arrays.asList("left", "right", "center"));
        ArrayList<ArrayList<String>> tabRows0 = new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList("ab", "si", "gos")),
            new ArrayList<>(Arrays.asList("def", "no", "guineu")),
            new ArrayList<>(Arrays.asList("hi", "perquè", "llop")),
            new ArrayList<>(Arrays.asList("jklm", "qui", "formiga"))
        ));

        Table tab0 = new Table(0, 0, 28, 8, "Taula0", tabHeaders0, tabWidth0, tabAligns0, tabRows0);
        components.add(tab0);

        Container container = new Container(50, 10, components);
        container.draw();
        */
    }

}