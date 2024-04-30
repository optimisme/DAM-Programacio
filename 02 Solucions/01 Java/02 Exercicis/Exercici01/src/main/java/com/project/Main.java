package com.project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        System.out.print("Quina edat tens? ");

        String input = scanner.nextLine();
        int numero = Integer.parseInt(input) * 7;

        System.out.println("Si fossis un gos, tindries " + numero + " anys");
        
        scanner.close(); 
    }
}