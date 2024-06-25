package com.project;

public class Main {

    public static void informacio_llibre(String titol, String autor, int any) {
        System.out.printf("Títol: %s, Autor: %s, Any: %d\n", titol, autor, any);
    }

    public static void main(String[] args) {
        informacio_llibre("El Gran Gatsby", "F. Scott Fitzgerald", 1925);
        informacio_llibre("1984", "George Orwell", 1949);
        informacio_llibre("Matar un rossinyol", "Harper Lee", 1960);
    }
}
