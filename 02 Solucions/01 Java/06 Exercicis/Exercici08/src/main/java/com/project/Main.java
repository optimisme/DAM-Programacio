package com.project;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Empleat> empleats = new ArrayList<>();
        empleats.add(new Desenvolupador("Anna", "DEV001", "Java"));
        empleats.add(new Gestor("Carlos", "MAN001", "TI"));
        empleats.add(new Desenvolupador("Berta", "DEV002", "C#"));

        for (Empleat empleat : empleats) {
            System.out.println(empleat.toString());
            // En cas que es necessiti accedir a mètodes o propietats específiques de les subclasses,
            // realitza el casting descendent aquí, verificant primer el tipus d'empleat amb instanceof.
        }
    }
}