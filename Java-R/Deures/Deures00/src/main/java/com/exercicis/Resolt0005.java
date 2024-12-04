package com.exercicis;


public class Resolt0005 {

    public static boolean isPalindrom(String text) {
        // Normalitzar text
        text = normalize(text);
        
        // Invertir el text
        int lastLetter = text.length() - 1;
        String inverted = "";
        for (int cnt = lastLetter; cnt >= 0; cnt = cnt - 1) {
            String letter = String.valueOf(text.charAt(cnt));
            inverted = inverted + letter;
        }

        return text.equals(inverted);
    }

    public static String normalize(String text) {
        String rst = text.toLowerCase();
    
        // Arrays amb caràcters especials i les seves substitucions
        String[] accents = {"à", "á", "è", "é", "í", "ò", "ó", "ú", "ù", " ", "'", "!", "\\.", ",", "·"};
        String[] senseAccents = {"a", "a", "e", "e", "i", "o", "o", "u", "u", "", "", "", "", "", ""};
    
        // Substituir cada caràcter del text original
        for (int cnt = 0; cnt < accents.length; cnt++) {
            rst = rst.replaceAll(accents[cnt], senseAccents[cnt]);
        }
        
        return rst;
    }
    
   
    public static void main(String[] args) {

        String[] exemples = {
            "Anul·la la lluna",
            "Atrapa la lluna",
            "Atrapa'l o l'aparta",
            "Aparta'l o atrapa'l",
            "No sap pas on",
            "On sap pas qui",
            "Tramaran anar a Mart",
            "A Mart trobaràn art",
            "Un pop nu",
            "Nu pop un"
        };

        // Comprovar cada text
        for (String text : exemples) {
            boolean esPalindrom = isPalindrom(text);
            System.out.println(text + " (" + (esPalindrom ? "Si" : "No") + ")");
        }
    }
}
