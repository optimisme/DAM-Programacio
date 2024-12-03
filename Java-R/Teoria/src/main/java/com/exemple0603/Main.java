package com.exemple0603;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        HashMap<String, Object> mixedMap = new HashMap<>();

        mixedMap.put("Enter", 42);
        mixedMap.put("Text", "Hola món");
        mixedMap.put("Decimal", 3.14);

        // Accedir als valors amb cast
        int enter = (int) mixedMap.get("Enter");
        String text = (String) mixedMap.get("Text");
        double decimal = (double) mixedMap.get("Decimal");

        System.out.println("Enter: " + enter);
        System.out.println("Text: " + text);
        System.out.println("Decimal: " + decimal);
    }
}