// Main.java
package com.project;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introdueix un número: ");
        int num = scanner.nextInt();
        escriuImparells(num);
        scanner.close();
    }

    /**
     * Escriu tots els valors imparells entre 0 i el número escrit.
     * @param num Número enter.
     */
    public static void escriuImparells(int num) {
        for (int i = 0; i <= num; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }
    }
}