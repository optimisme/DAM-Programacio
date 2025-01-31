package com.resolt0305;

public class Main {
    public static void main(String[] args) {
        Torneig torneig = new Torneig();

        Jugador jugador1 = new Jugador("Leo Messi", 35, "PSG");
        Jugador jugador2 = new Jugador("Cristiano Ronaldo", 38, "Al-Nassr");
        Arbitre arbitre1 = new Arbitre("Mateu Lahoz", 45, "FIFA");

        torneig.afegirParticipant(jugador1);
        torneig.afegirParticipant(jugador2);
        torneig.afegirParticipant(arbitre1);

        System.out.println("Participants:");
        torneig.printParticipants();

        System.out.println("\nFase d'entrenament:");
        torneig.entrenar();

        System.out.println("\nFase de competició:");
        torneig.competir();
    }
}
