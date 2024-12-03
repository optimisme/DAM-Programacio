package com.exemple0605;

public class Main {

    public static void main(String[] args) {
        String text = "poma,plàtan,maduixa,raïm";

        // Dividir el text en un array de cadenes
        String[] fruits = text.split(",");

        // Mostrar el resultat
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}