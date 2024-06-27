package com.project;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introdueix un text: ");
        String text = scanner.nextLine();

        int count = countAs(text);
        System.out.printf("El text té %d 'a'.\n", count);
    }

    public static int countAs(String text) {
        int count = 0;
        for (char c : text.toLowerCase().toCharArray()) {
            if (c == 'a' || c == 'à' || c == 'á' || c == 'â' || c == 'ã' || c == 'ä') {
                count++;
            }
        }
        return count;
    }
}
