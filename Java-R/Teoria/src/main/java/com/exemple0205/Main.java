package com.exemple0205;

public class Main {
    public static void main(String[] args) {

        String text = "Hola, Laura";

        System.out.println(text);
        System.out.println("0123456789");
        
        int posMariano = text.indexOf("Laura");
        System.out.println("\"Laura\" està a la posició: " + posMariano);

        boolean isHolaInText = text.contains("Hola");
        System.out.println("\"hola\" està a la cadena de text? " + isHolaInText);

        int posLastA = text.lastIndexOf("a");
        System.out.println("La última lletra 'a' està a la posició: " + posLastA);
    }
}