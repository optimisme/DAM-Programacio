package com.project;

public class Main {
    public static void main(String[] args) {
        String text = "Monsters Are Victims Too";

        // La llargada de la frase
        int length = text.length();
        System.out.println("La llargada de la frase: " + length);

        // La subcadena 'Are'
        String substring = text.substring(9, 12); // Subcadena 'Are'
        System.out.println("La subcadena 'Are': " + substring);

        // Repeteix la subcadena anterior 5 vegades
        String repeatedSubstring = substring.repeat(5);
        System.out.println("Repeteix la subcadena anterior 5 vegades: " + repeatedSubstring);

        // La frase amb només la primera M majúscula
        String lowerCaseText = text.toLowerCase();
        String capitalizedText = lowerCaseText.substring(0, 1).toUpperCase() + lowerCaseText.substring(1);
        System.out.println("La frase amb només la primera M majúscula: " + capitalizedText);
    }
}
