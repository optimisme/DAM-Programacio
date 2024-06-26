package com.project;

public class Main {
    public static void main(String[] args) {
        String text = "The pain you feel today will be the strength you'll have tomorrow.";

        // La llargada de la frase
        int length = text.length();
        System.out.println("La llargada de la frase: " + length);

        // La subcadena "The strength you'll have tomorrow"
        String substring = text.substring(28);
        System.out.println("La subcadena 'The strength you'll have tomorrow': " + substring);

        // Subcadenes concatenades per fer una nova frase: "Today you'll have the strength you'll feel tomorrow."
        String newPhrase = "Today you'll have the strength you'll feel tomorrow.";
        System.out.println("Subcadenes concatenades per fer una nova frase: " + newPhrase);

        // La subcadena invertida, sense espais ni cometes simples, de la part: "you'll have the"
        String partToReverse = text.substring(39, 54).replace("'", "").replace(" ", "");
        String reversedSubstring = new StringBuilder(partToReverse).reverse().toString();
        System.out.println("La subcadena invertida, sense espais ni cometes simples, de la part 'you'll have the': " + reversedSubstring);
    }
}
