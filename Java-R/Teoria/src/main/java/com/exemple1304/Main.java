package com.exemple1304;

public class Main {
    public static void main(String[] args) {
        CompteEstalvi meuCompte = new CompteEstalvi(1000);
        meuCompte.dipositar(500);
        meuCompte.retirar(200);
        meuCompte.imprimirBalanc();
    }
}

