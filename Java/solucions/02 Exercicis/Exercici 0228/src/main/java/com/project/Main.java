package com.project;

import java.util.Scanner;

public class Main {

    public static double metresAMilles(double metres) {
        return metres * 0.000621371;
    }

    public static double millesAMetres(double milles) {
        return milles * 1609.34;
    }

    public static double metresAPolzades(double metres) {
        return metres * 39.3701;
    }

    public static double polzadesAMetres(double polzades) {
        return polzades * 0.0254;
    }

    public static double polzadesAMilles(double polzades) {
        return polzades * 0.0000157828;
    }

    public static double millesAPolzades(double milles) {
        return milles * 63360;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Conversió de mesures:");
        System.out.println("1. Metres a Milles");
        System.out.println("2. Milles a Metres");
        System.out.println("3. Metres a Polzades");
        System.out.println("4. Polzades a Metres");
        System.out.println("5. Polzades a Milles");
        System.out.println("6. Milles a Polzades");
        System.out.print("Escull una opció de conversió: ");
        int opcio = scanner.nextInt();

        double quantitat = 0;
        double resultat = 0;
        String conversio = "";

        switch (opcio) {
            case 1:
                System.out.print("S'ha escollit conversió 'Metres a Milles', introdueix la quantitat de metres: ");
                quantitat = scanner.nextDouble();
                resultat = metresAMilles(quantitat);
                conversio = "Metres a Milles";
                break;
            case 2:
                System.out.print("S'ha escollit conversió 'Milles a Metres', introdueix la quantitat de milles: ");
                quantitat = scanner.nextDouble();
                resultat = millesAMetres(quantitat);
                conversio = "Milles a Metres";
                break;
            case 3:
                System.out.print("S'ha escollit conversió 'Metres a Polzades', introdueix la quantitat de metres: ");
                quantitat = scanner.nextDouble();
                resultat = metresAPolzades(quantitat);
                conversio = "Metres a Polzades";
                break;
            case 4:
                System.out.print("S'ha escollit conversió 'Polzades a Metres', introdueix la quantitat de polzades: ");
                quantitat = scanner.nextDouble();
                resultat = polzadesAMetres(quantitat);
                conversio = "Polzades a Metres";
                break;
            case 5:
                System.out.print("S'ha escollit conversió 'Polzades a Milles', introdueix la quantitat de polzades: ");
                quantitat = scanner.nextDouble();
                resultat = polzadesAMilles(quantitat);
                conversio = "Polzades a Milles";
                break;
            case 6:
                System.out.print("S'ha escollit conversió 'Milles a Polzades', introdueix la quantitat de milles: ");
                quantitat = scanner.nextDouble();
                resultat = millesAPolzades(quantitat);
                conversio = "Milles a Polzades";
                break;
            default:
                System.out.println("Opció no vàlida");
                return;
        }

        System.out.printf("La conversió '%s' de %.2f és %.2f\n", conversio, quantitat, resultat);
    }
}
