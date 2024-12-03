package com.exemple0606;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("poma", "plàtan", "maduixa", "raïm");

        // Ajuntar els elements amb una barra '/'
        String result = String.join("/", fruits);

        System.out.println(result);
    }
}