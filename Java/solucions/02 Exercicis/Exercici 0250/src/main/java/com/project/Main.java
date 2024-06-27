// Main.java
package com.project;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        String email;

        while (true) {
            System.out.print("Introdueix una direcció de correu electrònic: ");
            email = scanner.nextLine();
            if (validaEmail(email)) {
                break;
            } else {
                System.out.println("Correu electrònic no vàlid. Torna a intentar-ho.");
            }
        }

        System.out.println("Correu electrònic vàlid: " + email);
        scanner.close();
    }

    /**
     * Valida una direcció de correu electrònic segons les regles especificades.
     * @param email Direcció de correu electrònic a validar.
     * @return True si el correu és vàlid, false altrament.
     */
    public static boolean validaEmail(String email) {
        int atIndex = email.indexOf('@');
        int dotIndex = email.lastIndexOf('.');

        if (atIndex == -1 || dotIndex == -1) return false;
        if (atIndex == 0 || atIndex == email.length() - 1) return false;
        if (dotIndex == 0 || dotIndex == email.length() - 1) return false;
        if (Math.abs(atIndex - dotIndex) == 1) return false;

        return true;
    }
}
