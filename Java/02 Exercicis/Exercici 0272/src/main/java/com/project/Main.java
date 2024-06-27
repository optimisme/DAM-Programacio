// Main.java
package com.project;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introdueix un text:");
        String text = scanner.nextLine();

        int majuscules = calculaMajuscules(text);
        int minuscules = calculaMinuscules(text);

        System.out.println("Número de majúscules: " + majuscules);
        System.out.println("Número de minúscules: " + minuscules);
    }

    public static int calculaMajuscules(String text) {
        return 0;
    }

    public static int calculaMinuscules(String text) {
        return 0;
    }
}
