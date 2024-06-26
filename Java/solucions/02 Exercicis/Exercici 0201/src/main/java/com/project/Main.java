package com.project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Quina edat tens? ");
        int edatHumana = scanner.nextInt();
        int edatGos = edatHumana * 7;
        System.out.println("Si fossis un gos, tindries " + edatGos + " anys");
    }
}
