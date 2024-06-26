package com.project;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introdueix un dia de la setmana: ");
        String dia = scanner.nextLine().toLowerCase(Locale.US);

        if (dia.equals("dilluns") || dia.equals("dimarts") || dia.equals("dimecres") || dia.equals("dijous") || dia.equals("divendres")) {
            System.out.println("S'ha d'anar a l'escola");
        } else {
            System.out.println("No s'ha d'anar a l'escola");
        }
    }
}
