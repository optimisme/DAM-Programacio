package com.project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digues un animal: ");
        String subjecte = scanner.nextLine();

        System.out.print("Digues què fa l'animal: ");
        String verb = scanner.nextLine();

        System.out.print("Digues un objecte: ");
        String objecte = scanner.nextLine();

        System.out.println(subjecte + ", " + verb + ", " + objecte);
    }
}
