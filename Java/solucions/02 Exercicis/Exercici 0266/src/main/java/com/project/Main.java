// Main.java
package com.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introdueix una llista de paraules separades per espais:");
        String input = scanner.nextLine();
        List<String> paraules = Arrays.asList(input.split(" "));

        String[][] resultat = separaVocals(paraules);
        System.out.println("Paraules que comencen per vocal: " + Arrays.toString(resultat[0]));
        System.out.println("Paraules que comencen per consonant: " + Arrays.toString(resultat[1]));

        List<String> resultatVocalsAlFinal = vocalsAlFinal(paraules);
        System.out.println("Paraules amb vocals al final: " + resultatVocalsAlFinal);
    }

    /**
     * Separa les paraules que comencen per vocal i consonant.
     * @param paraules La llista de paraules.
     * @return Un array bidimensional on el primer element són les paraules que comencen per vocal i el segon les que comencen per consonant.
     */
    public static String[][] separaVocals(List<String> paraules) {
        List<String> vocals = new ArrayList<>();
        List<String> consonants = new ArrayList<>();
        for (String paraula : paraules) {
            paraula = paraula.replaceAll(",$", "");  // Eliminar coma final si existeix
            char firstChar = Character.toLowerCase(paraula.charAt(0));
            if (isVowel(firstChar)) {
                vocals.add(paraula);
            } else {
                consonants.add(paraula);
            }
        }
        return new String[][]{
                vocals.toArray(new String[0]),
                consonants.toArray(new String[0])
        };
    }

    /**
     * Col·loca les paraules que comencen per vocal al final de la llista.
     * @param paraules La llista de paraules.
     * @return Una nova llista amb les paraules que comencen per vocal al final.
     */
    public static List<String> vocalsAlFinal(List<String> paraules) {
        List<String> vocals = new ArrayList<>();
        List<String> altres = new ArrayList<>();
        for (String paraula : paraules) {
            paraula = paraula.replaceAll(",$", "");  // Eliminar coma final si existeix
            char lastChar = Character.toLowerCase(paraula.charAt(paraula.length() - 1));
            if (isVowel(lastChar)) {
                vocals.add(paraula);
            }
        }
        return vocals;
    }

    /**
     * Determina si un caràcter és una vocal, incloent les accentuades.
     * @param c El caràcter a comprovar.
     * @return true si el caràcter és una vocal, false altrament.
     */
    public static boolean isVowel(char c) {
        return "aeiouáéíóúàèìòùâêîôûäëïöü".indexOf(c) != -1;
    }
}
