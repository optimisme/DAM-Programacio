// Main.java
package com.project;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        String correctPassword = "1234";
        int attempts = 3;
        boolean accessGranted = false;

        while (attempts > 0) {
            System.out.print("Introdueix la contrasenya: ");
            String inputPassword = scanner.nextLine();
            if (inputPassword.equals(correctPassword)) {
                System.out.println("Accés permès");
                accessGranted = true;
                break;
            } else {
                attempts--;
                System.out.println("Contrasenya incorrecta");
            }
        }

        if (!accessGranted) {
            System.out.println("Accés denegat. Has exhaurit els intents.");
        }
        scanner.close();
    }
}
