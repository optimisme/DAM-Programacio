package com.project;

public class PagamentTargeta implements Autoritzable {
    @Override
    public void processarPagament() {
        System.out.println("El pagament amb targeta ha estat processat.");
    }

    @Override
    public void autoritzarPagament() {
        System.out.println("El pagament amb targeta ha estat autoritzat.");
    }
}
