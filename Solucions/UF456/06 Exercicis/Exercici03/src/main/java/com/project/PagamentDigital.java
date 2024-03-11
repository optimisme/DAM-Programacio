package com.project;

public class PagamentDigital implements Autoritzable {
    @Override
    public void processarPagament() {
        System.out.println("El pagament digital ha estat processat.");
    }

    @Override
    public void autoritzarPagament() {
        System.out.println("El pagament digital ha estat autoritzat.");
    }
}