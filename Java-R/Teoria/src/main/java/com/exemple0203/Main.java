package com.exemple0203;

public class Main {
    public static void main(String[] args) {
        // Exemples de cadenes
        String cadena1 = "Hola, món!";
        String cadena2 = "hola, món!";
        String cadena3 = "Adéu, món!";
        String prefix = "Hola";
        String sufix = "món!";

        // equals(String str): Comprova si dues cadenes són exactament iguals
        System.out.println("cadena1.equals(cadena2): " + cadena1.equals(cadena2)); // False
        System.out.println("cadena1.equals(\"Hola, món!\"): " + cadena1.equals("Hola, món!")); // True

        // equalsIgnoreCase(String str): Comprova si dues cadenes són iguals ignorant majúscules i minúscules
        System.out.println("cadena1.equalsIgnoreCase(cadena2): " + cadena1.equalsIgnoreCase(cadena2)); // True

        // compareTo(String str): Compara lexicogràficament les cadenes
        System.out.println("cadena1.compareTo(cadena3): " + cadena1.compareTo(cadena3)); // Positiu (cadena1 > cadena3)
        System.out.println("cadena3.compareTo(cadena1): " + cadena3.compareTo(cadena1)); // Negatiu (cadena3 < cadena1)
        System.out.println("cadena1.compareTo(\"Hola, món!\"): " + cadena1.compareTo("Hola, món!")); // 0

        // startsWith(String prefix): Comprova si comença amb un prefix determinat
        System.out.println("cadena1.startsWith(prefix): " + cadena1.startsWith(prefix)); // True
        System.out.println("cadena3.startsWith(prefix): " + cadena3.startsWith(prefix)); // False

        // endsWith(String suffix): Comprova si acaba amb un sufix determinat
        System.out.println("cadena1.endsWith(sufix): " + cadena1.endsWith(sufix)); // True
        System.out.println("cadena3.endsWith(sufix): " + cadena3.endsWith(sufix)); // True
    }
}
