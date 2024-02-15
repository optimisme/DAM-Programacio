package com.project;

public class Main {
    public static void main(String[] args) {
        // Definició de variables
        boolean varBoleana = true;
        char nomesUnCaracter = 'a';
        String cadenaText = "Hola";
        int numeroEnter = 45;
        long numeroEnterGran = 39832L;
        float numeroDecimalsPetit = 32.5f;
        double numeroDecimalsGran = 1.79769313486231570e+308d;

        // Capçaleres de columnes
        System.out.printf("%-10s %-20s %-30s %n", "Tipus", "Nom", "Valor");
        System.out.println("---------------------------------------------------------------");
        
        // Imprimir informació de cada variable amb amplades fixes
        System.out.printf("%-10s %-20s %-30s %n", "boolean", "varBoleana", varBoleana);
        System.out.printf("%-10s %-20s %-30c %n", "char", "nomesUnCaracter", nomesUnCaracter);
        System.out.printf("%-10s %-20s %-30s %n", "String", "cadenaText", cadenaText);
        System.out.printf("%-10s %-20s %-30d %n", "int", "numeroEnter", numeroEnter);
        System.out.printf("%-10s %-20s %-30d %n", "long", "numeroEnterGran", numeroEnterGran);
        System.out.printf("%-10s %-20s %-30f %n", "float", "numeroDecimalsPetit", numeroDecimalsPetit);
        System.out.printf("%-10s %-20s %-30e %n", "double", "numeroDecimalsGran", numeroDecimalsGran);
    }
}
