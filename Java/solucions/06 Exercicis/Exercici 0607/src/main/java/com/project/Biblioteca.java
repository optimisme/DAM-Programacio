package com.project;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Biblioteca {
    private List<Publicacio> publicacions = new ArrayList<>();

    public void afegirPublicacio(Publicacio publicacio) {
        publicacions.add(publicacio);
    }

    public List<Publicacio> getPublicacions() {
        return publicacions;
    }

    public List<Llibre> getLlibres() {
        return publicacions.stream()
                .filter(p -> p instanceof Llibre)
                .map(p -> (Llibre)p)
                .collect(Collectors.toList());
    }

    public List<Revista> getRevistes() {
        return publicacions.stream()
                .filter(p -> p instanceof Revista)
                .map(p -> (Revista)p)
                .collect(Collectors.toList());
    }
}