package com.exercici1400;

import java.util.List;
import java.util.Map;
import java.util.Locale;

public class Biblioteca {

    public static void crearTaulaEditorials() {
        // TODO 
        String sql = """
        """;
        AppData.getInstance().update(sql);
    }

    public static void crearTaulaLlibres() {
        // TODO 
        String sql = """
        """;
        AppData.getInstance().update(sql);
    }

    public static void afegirEditorial(String nom) {
        // TODO 
        String sql = String.format("", nom);
        AppData.getInstance().update(sql);
    }

    public static void afegirLlibre(String titol, String autor, int anyPublicacio, int idEditorial) {
         // TODO 
        String sql = String.format("", titol, autor, anyPublicacio, idEditorial
        );
        AppData.getInstance().update(sql);
    }

    public static void llistarTaulaEditorials() {
        // TODO 
    }

    public static void llistarTaulaLlibres() {
        // TODO 
    }

    public static void llistarInfoLlibre(int idLlibre) {
        // TODO 
    }
}
