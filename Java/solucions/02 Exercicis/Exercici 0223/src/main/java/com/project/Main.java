package com.project;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introdueix la primera edat: ");
        int edat1 = scanner.nextInt();

        System.out.print("Introdueix la segona edat: ");
        int edat2 = scanner.nextInt();

        System.out.print("Introdueix la tercera edat: ");
        int edat3 = scanner.nextInt();

        int[] edats = {edat1, edat2, edat3};
        Arrays.sort(edats);

        System.out.printf("Les edats ordenades són %d, %d, %d\n", edats[0], edats[1], edats[2]);
    }
}
