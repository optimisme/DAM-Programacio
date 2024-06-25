package com.project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quin és el valor en Euros que vols convertir? ");
        double euros = scanner.nextDouble();

        System.out.print("Quina és la taxa de conversió? ");
        double taxaConversio = scanner.nextDouble();

        double dollars = euros * taxaConversio;

        System.out.printf("El valor de %.2f€ són %.2f$\n", euros, dollars);
    }
}
