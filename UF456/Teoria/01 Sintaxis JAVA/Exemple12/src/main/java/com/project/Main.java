package com.project;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.Scanner;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double suma = 0.0;
        System.out.println("Introdueix un número (decimals amb .) o escriu 'sortir' per acabar:");

        while (true) {
            System.out.print("La suma actual és " + suma + "\nIntrodueix un número o 'sortir': ");
            String input = scanner.nextLine();

            if ("sortir".equalsIgnoreCase(input)) {
                System.out.println("Finalitzant l'aplicació. La suma final és " + suma);
                break;
            }

            try {
                double numero = Double.parseDouble(input);
                suma += numero;
                clearScreen();
            } catch (NumberFormatException e) {
                System.out.println("Error, cal escriure un número o 'sortir'");
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        scanner.close();
    }

    public static void clearScreen() {
        try {
            String sistemaOperatiu = System.getProperty("os.name");

            if (sistemaOperatiu.contains("Windows")) {
                // Comanda per a Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Comanda per a Unix/Linux/Mac
                // Aquesta línia pot no netejar la pantalla en alguns terminals o IDEs
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            System.out.println("No es pot netejar la pantalla: " + e.getMessage());
        }
    }
}