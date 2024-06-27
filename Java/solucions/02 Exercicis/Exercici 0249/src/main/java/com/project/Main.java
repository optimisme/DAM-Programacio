// Main.java
package com.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        List<String> paraules = new ArrayList<>();
        String paraula;

        System.out.println("Escriu paraules (escriu 'fi' per acabar):");
        while (!(paraula = scanner.nextLine()).equalsIgnoreCase("fi")) {
            paraules.add(paraula);
        }

        System.out.println("Paraules escrites: " + String.join(" ", paraules));
        scanner.close();
    }
}
