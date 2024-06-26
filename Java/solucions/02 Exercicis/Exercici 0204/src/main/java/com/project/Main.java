package com.project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("En graus Celsius, quina temperatura fa? ");
        double grausCelsius = scanner.nextDouble();

        double grausFahrenheit = (grausCelsius * 1.8) + 32;

        System.out.println(grausCelsius + " graus Celsius són " + grausFahrenheit + " graus Fahrenheit");
    }
}
