package com.project;

public class Main {

    public static boolean es_palindrom(String text) {
        // Treu tots els espais en blanc de la frase
        String processedText = text.replace(" ", "").replace("·", "").replace("'", "").toLowerCase();
        // Compara si el resultat anterior és igual al seu invertit
        String reversedText = new StringBuilder(processedText).reverse().toString();
        return processedText.equals(reversedText);
    }

    public static void main(String[] args) {
        String[] frases = {
            "Anul·la la lluna",
            "Atrapa'l o l'aparta",
            "No sap pas on",
            "Tramaran anar a Mart",
            "Un pop nu",
            "Aquesta frase no és un palíndrom",
            "Aquest tampoc no ho és"
        };

        for (String frase : frases) {
            boolean resultat = es_palindrom(frase);
            System.out.printf("És la frase '%s' un palindrom? %b\n", frase, resultat);
        }
    }
}
