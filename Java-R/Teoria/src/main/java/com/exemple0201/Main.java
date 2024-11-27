package com.exemple0201;

public class Main {
    public static void main(String[] args) {

        boolean a = true;
        boolean b = false;

        System.out.println("a=" + a + "; b=" + b);
        
        // Operador AND (i)
        // Només és cert si 'a' i 'b' són 'true'
        boolean resultatAnd = a && b; 
        System.out.println("Resultat de AND: " + resultatAnd);
        
        // Operador OR (o)
        // És cert alguna de les dues 'a' o 'b' és 'true'
        boolean resultatOr = a || b; 
        System.out.println("Resultat de OR: " + resultatOr);
        
        // Operador NOT (no)
        // Inverteix el valor de 'a' (si és true dóna false ...)
        boolean resultatNot = !a; 
        System.out.println("Resultat de NOT: " + resultatNot);
    }
}
