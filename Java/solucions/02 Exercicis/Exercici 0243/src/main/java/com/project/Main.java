package com.project;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introdueix el primer número del rang: ");
        int num1 = scanner.nextInt();
        System.out.print("Introdueix el segon número del rang: ");
        int num2 = scanner.nextInt();
        scanner.nextLine();  // Consumeix la nova línia

        String result = getOddNumbersInRange(num1, num2);
        System.out.println(result);
    }

    public static boolean esImparell(int num) {
        return num % 2 != 0;
    }

    public static String getOddNumbersInRange(int num1, int num2) {
        int start = Math.min(num1, num2);
        int end = Math.max(num1, num2);
        StringBuilder sb = new StringBuilder();

        for (int i = start; i <= end; i++) {
            if (esImparell(i)) {
                sb.append(i).append(" ");
            }
        }

        return sb.toString().trim();
    }
}
