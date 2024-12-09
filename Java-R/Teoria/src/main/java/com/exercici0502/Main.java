package com.exercici0502;

import java.util.Scanner;

public class Main {

    public static float maxOfThree(float a, float b, float c){
        if (a>b){
            if (a>c){
                return a;
            }
            else{
                return c;
            }
        }
        else if (b>c){
            return b;
        }
        else{
            return c;
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        System.out.println("Introduce un numero(a): ");
        float a = sc.nextInt();

        System.out.println("Introduce otro numero(b): ");
        float b = sc.nextInt();

        System.out.println("Introduce otro numero(c): ");
        float c = sc.nextInt();

        float resultado = maxOfThree(a, b, c);
        System.out.println(resultado);

        sc.close();
    }
}