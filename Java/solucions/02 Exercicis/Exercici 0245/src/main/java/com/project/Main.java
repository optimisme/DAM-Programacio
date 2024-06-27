package com.project;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introdueix un número per calcular el seu factorial: ");
        int num = scanner.nextInt();

        if (num < 0) {
            System.out.println("El número ha de ser positiu.");
        } else {
            long factorial = calculateFactorial(num);
            System.out.printf("El factorial de %d és %d\n", num, factorial);
        }
    }

    public static long calculateFactorial(int num) {
        long result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }
}
