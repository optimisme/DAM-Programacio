package com.project;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introdueix un número entre 1 i 10 per generar un triangle d'asteriscs: ");
        int num = scanner.nextInt();
        scanner.nextLine();  // Consumeix la nova línia

        if (num < 1 || num > 10) {
            System.out.println("El número ha d'estar entre 1 i 10.");
        } else {
            String triangle = generateCenteredTriangle(num);
            System.out.println(triangle);
        }
    }

    public static String generateCenteredTriangle(int num) {
        String rst = "";
        for (int i = 1; i <= num; i++) {
            rst = rst + generateCenteredText("*".repeat(i), 10) + "\n";
        }
        return rst;
    }

    public static String generateCenteredText(String text, int width) {
        int padding = (width - text.length()) / 2;
        return " ".repeat(padding) + text;
    }
}
