package com.exemple0301;

public class Main {
    public static void main(String[] args) {

        String text = "Hola, Java";
        System.out.println(text);
        System.out.println("0123456789");
        System.out.println("      " + text.substring(6));    // "Java"
        System.out.println("      " + text.substring(6, 9)); // "Jav"
        System.out.println("      " + text.substring(6, 8)); // "Ja"
    }
}
