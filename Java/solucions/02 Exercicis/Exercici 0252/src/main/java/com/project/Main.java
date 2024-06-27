// Main.java
package com.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        comptaVendes();
    }

    /**
     * Demana a l'usuari el valor en € d'unes quantes vendes i mostra el nombre de vendes, la suma total i la mitjana.
     */
    public static void comptaVendes() {
        Scanner scanner = new Scanner(System.in);
        List<Double> vendes = new ArrayList<>();
        String input;

        System.out.println("Introdueix el valor de les vendes (escriu 'fi' per acabar):");

        while (!(input = scanner.nextLine()).equalsIgnoreCase("fi")) {
            try {
                double venda = Double.parseDouble(input);
                vendes.add(venda);
            } catch (NumberFormatException e) {
                System.out.println("Valor no vàlid, torna a intentar-ho.");
            }
        }

        int nombreDeVendes = vendes.size();
        double sumaTotal = vendes.stream().mapToDouble(Double::doubleValue).sum();
        double mitjana = nombreDeVendes == 0 ? 0 : sumaTotal / nombreDeVendes;

        System.out.printf("S'han apuntat %d vendes, amb un total de %.2f € i una mitjana de %.2f €.\n", nombreDeVendes, sumaTotal, mitjana);
        scanner.close();
    }
}
