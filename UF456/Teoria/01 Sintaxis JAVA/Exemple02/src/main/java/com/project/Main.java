package com.project;

public class Main {
    public static void main(String[] args) {
        // Cadena inicial
        String text = "Hola Món, Món és un lloc bonic.";
        
        // Longitud
        int longitud = text.length();
        System.out.println("Longitud: " + longitud);
        
        // Concatenació
        String salutacio = text + " Des de Java!";
        System.out.println("Concatenació: " + salutacio);
        
        // Indexació
        char lletra = text.charAt(0);
        System.out.println("Caràcter en índex 0: " + lletra);
        
        // Subcadena
        String subcadena = text.substring(0, 4);
        System.out.println("Subcadena: " + subcadena);
        
        // Repetició
        String repetit = "ha".repeat(3);
        System.out.println("Repetició: " + repetit);
        
        // Conversió
        String majuscules = text.toUpperCase();
        System.out.println("A majúscules: " + majuscules);
        
        // Ordenar
        char[] lletres = text.toCharArray();
        java.util.Arrays.sort(lletres);
        String ordenat = new String(lletres);
        System.out.println("Ordenat: " + ordenat);
        
        // Substitució
        String substituit = text.replace("Món", "Java");
        System.out.println("Substitució: " + substituit);
        
        // Cerca
        int index = text.indexOf("Món");
        System.out.println("Índex de 'Món': " + index);
        
        // Invertir
        String invertit = new StringBuilder(text).reverse().toString();
        System.out.println("Invertit: " + invertit);
        
        // Canviar totes les aparicions d'una paraula
        String canviParaula = text.replace("Món", "Terra");
        System.out.println("Canvi de paraules: " + canviParaula);
    }
}
