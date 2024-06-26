package com.project;

public class Main {
    public static void main(String[] args) {
        String text = "Gotta Lose Something To Get Something";

        // La llargada de la frase
        int length = text.length();
        System.out.println("La llargada de la frase: " + length);

        // La subcadena 'Something' en majúscules
        String substringUppercase = text.substring(11, 20).toUpperCase();
        System.out.println("La subcadena 'Something' en majúscules: " + substringUppercase);

        // Les subcadenes "Lose" i "Get" repetides dos cops cada una "LoseLoseGetGet"
        String repeatedSubstrings = "Lose".repeat(2) + "Get".repeat(2);
        System.out.println("Les subcadenes 'Lose' i 'Get' repetides dos cops cada una: " + repeatedSubstrings);

        // La cadena intercanviant paraules en majúscules i minúscules: "GOTTA lose SOMETHING to GET something"
        String mixedCase = text.substring(0, 5).toUpperCase() + text.substring(5, 10).toLowerCase() +
                           text.substring(10, 20).toUpperCase() + text.substring(20, 23).toLowerCase() +
                           text.substring(23, 27).toUpperCase() + text.substring(27).toLowerCase();
        System.out.println("La cadena intercanviant paraules en majúscules i minúscules: " + mixedCase);

        // La subcadena invertida, sense espais, de la part: "Lose Something To"
        String partToReverse = text.substring(6, 23).replace(" ", "");
        String reversedSubstring = new StringBuilder(partToReverse).reverse().toString();
        System.out.println("La subcadena invertida, sense espais, de la part: 'Lose Something To': " + reversedSubstring);
    }
}
