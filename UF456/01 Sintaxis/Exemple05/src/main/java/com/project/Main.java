package com.project;

public class Main {
    public static void main(String[] args) {

    
        // Posar aquí una edat, per exemple 10, 25 o 81
        int edat = 25;

        // Comprovar si la persona pot conduir basant-se en la seva edat
        if (edat >= 18 && edat <= 80) {
            System.out.println("Pots conduir.");
        } else if (edat > 80) {
            System.out.println("No pots conduir per raons de seguretat.");
        } else {
            System.out.println("No pots conduir perquè no tens l'edat suficient.");
        }
    }
}
