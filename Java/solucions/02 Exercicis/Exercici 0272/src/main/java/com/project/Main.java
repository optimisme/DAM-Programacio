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
        int longitudDelText = text.length();
        int longitudDelTextSenseMajuscules = text.replaceAll("[A-ZÀ-Ý]", "").length();
        return longitudDelText - longitudDelTextSenseMajuscules;
    }

    public static int calculaMinuscules(String text) {
        int longitudDelText = text.length();
        int longitudDelTextSenseMinuscules = text.replaceAll("[a-zà-ý]", "").length();
        return longitudDelText - longitudDelTextSenseMinuscules;
    }
}
