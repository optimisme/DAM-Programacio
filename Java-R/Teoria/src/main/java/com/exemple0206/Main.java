package com.exemple0206;

public class Main {
    public static void main(String[] args) {
        // Cadena d'exemple
        String cadena = "   Hola, món!   ";

        System.out.println("Cadena original: " + cadena);

        // toUpperCase(): Converteix tota la cadena a majúscules
        String majuscules = cadena.toUpperCase();
        System.out.println("Cadena en majúscules: " + majuscules); // "   HOLA, MÓN!   "

        // toLowerCase(): Converteix tota la cadena a minúscules
        String minuscules = cadena.toLowerCase();
        System.out.println("Cadena en minúscules: " + minuscules); // "   hola, món!   "

        // trim(): Elimina espais en blanc al principi i al final
        String senseEspais = cadena.trim();
        System.out.println("Cadena sense espais: '" + senseEspais + "'"); // "Hola, món!"

        // replace(CharSequence target, CharSequence replacement): Substitueix part de la cadena
        String substituida = cadena.replace("món", "univers");
        System.out.println("Cadena substituïda: " + substituida); // "   Hola, univers!   "
    }
}
