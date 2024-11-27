package com.exemple0202;

public class Main {
    public static void main(String[] args) {

        int x = 10;
        int y = 5;

        System.out.println("x=" + x + "; y=" + y);
        
        // 10 més gran que 5? Cert
        System.out.println("x > y: "  + (x > y)); 
        
        // 10 més gran o igual a 5? Cert
        System.out.println("x >= y: " + (x >= y));
        
        // 10 més petit que 5? Fals
        System.out.println("x <>> y: "  + (x > y)); 
        
        // 10 més petit o igual a 5? False
        System.out.println("x <>>= y: " + (x >= y));
        
        // 10 és igual a 5? Fals
        System.out.println("x == y: " + (x == y));
        
        // 10 és diferent a 5? Fals
        System.out.println("x != y: " + (x != y));
    }
}
