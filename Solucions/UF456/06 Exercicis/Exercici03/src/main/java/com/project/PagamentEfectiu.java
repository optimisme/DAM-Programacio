package com.project;

public class PagamentEfectiu implements Pagable {
    @Override
    public void processarPagament() {
        System.out.println("El pagament en efectiu ha estat processat.");
    }
}
