package com.project;

class CompteEstalvi {
    private double balanc;

    CompteEstalvi(double balancInicial) {
        this.balanc = balancInicial;
    }

    // Les classes que hereten de 'CompteEstalvi' no poden sobreescrure 'dispositar'
    final void dipositar(double quantitat) {
        if (quantitat > 0) {
            balanc += quantitat;
            System.out.println("Dipòsit realitzat: " + quantitat);
        }
    }

    // Les classes que hereten de 'CompteEstalvi' no poden sobreescrure 'retirar'
    final void retirar(double quantitat) {
        if (quantitat > 0 && quantitat <= balanc) {
            balanc -= quantitat;
            System.out.println("Retirada realitzada: " + quantitat);
        } else {
            System.out.println("Operació no vàlida.");
        }
    }

    void imprimirBalanc() {
        System.out.println("Balanc actual: " + balanc);
    }
}
