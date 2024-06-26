package com.project;

public class Main {
    public static void main(String[] args) {

        int sum = 2 + 3;
        System.out.println("sum = " + sum);

        int a = 3;
        a += 5; // Ara el valor de 'a' serà 5 + 3, 8
        a -= 2; // Ara el valor de 'a' serà 8 - 2, 6
        System.out.println("a = " + a);

        int b = (2 + 3) * 4;
        System.out.println("b = " + b);

        double c = Math.pow(2, 2) + Math.pow(4, 2);
        System.out.println("c = " + c);

        int d = 10 * 2 / 5;
        System.out.println("d = " + d);

        int e = 10 % 3 % 2;
        System.out.println("e = " + e);

        int f = 10 + 2 - 5;
        System.out.println("f = " + f);
    }
}
