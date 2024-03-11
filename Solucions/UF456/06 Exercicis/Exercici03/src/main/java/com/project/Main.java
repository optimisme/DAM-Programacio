package com.project;

public class Main {
    public static void main(String[] args) {
        PagamentEfectiu pagamentEfectiu = new PagamentEfectiu();
        PagamentTargeta pagamentTargeta = new PagamentTargeta();
        PagamentDigital pagamentDigital = new PagamentDigital();

        // Processar un pagament en efectiu
        System.out.println("Processant un pagament en efectiu:");
        pagamentEfectiu.processarPagament();

        // Processar un pagament amb targeta
        System.out.println("\nProcessant un pagament amb targeta:");
        pagamentTargeta.autoritzarPagament();
        pagamentTargeta.processarPagament();

        // Processar un pagament digital
        System.out.println("\nProcessant un pagament digital:");
        pagamentDigital.autoritzarPagament();
        pagamentDigital.processarPagament();
    }
}