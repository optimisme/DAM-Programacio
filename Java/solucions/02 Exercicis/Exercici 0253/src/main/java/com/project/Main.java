// Main.java
package com.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        calculaComissio();
    }

    /**
     * Demana a un empleat que escrigui les vendes realitzades, calcula les comissions i mostra el resultat.
     */
    public static void calculaComissio() {
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
        double sumaTotal = vendes.stream().mapToDouble(Main::calculaComissioVenda).sum();
        double sumaSenseComissio = vendes.stream().mapToDouble(Double::doubleValue).sum();
        double mitjana = nombreDeVendes == 0 ? 0 : sumaSenseComissio / nombreDeVendes;
        double comissioTotal = sumaTotal - sumaSenseComissio;

        System.out.printf("S'han entrat %d vendes, amb un total de %.2f € i una mitjana de %.2f €.\n", nombreDeVendes, sumaTotal, mitjana);
        System.out.printf("S'ha aconseguit una comissió de %.2f €.\n", comissioTotal);
        scanner.close();
    }

    /**
     * Calcula la comissió d'una venda segons el valor de la venda.
     * @param venda Valor de la venda.
     * @return Valor de la venda més la comissió.
     */
    public static double calculaComissioVenda(double venda) {
        if (venda < 1000) {
            return venda * 1.05;
        } else if (venda < 5000) {
            return venda * 1.07;
        } else {
            return venda * 1.10;
        }
    }
}
