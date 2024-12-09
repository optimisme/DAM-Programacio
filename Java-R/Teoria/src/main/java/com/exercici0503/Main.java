package com.exercici0503;

import java.util.Scanner;
public class Main {

    public static Boolean startsWithVowel(String word){

        String word_lower = word.toLowerCase();

        if (word_lower.startsWith("a") || word_lower.startsWith("e") || word_lower.startsWith("i") || word_lower.startsWith("o") || word_lower.startsWith("u")){
            System.out.println("La paraula "+word+" comença per vocal");
            return true;
        } else {
            System.out.println("La paraula "+word+" NO comença per vocal");
            return false;
        }
        
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Paraula: ");
        String paraula = scanner.nextLine();

        System.out.println(startsWithVowel(paraula));
        scanner.close();
        
    }
}