package com.project;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introdueix un número per veure la seva taula de multiplicar: ");
        int num = scanner.nextInt();
        scanner.nextLine();  // Consumeix la nova línia

        String result = generateMultiplicationTable(num);
        System.out.println(result);
    }

    public static String generateMultiplicationTable(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 10; i++) {
            sb.append(i).append(" x ").append(num).append(" = ").append(i * num).append("\n");
        }
        return sb.toString().trim(); // Elimina l'últim salt de línia
    }
}
