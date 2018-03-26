package pkg3enraya;

import java.util.*;

public class Jugador {

    private int torn;
    private String nombre;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    private int[] demanarCasella() {
        int[] casella = new int[2];
        Scanner resposta = new Scanner(System.in);

        System.out.print("Elige fila ---> ");
        casella[0] = resposta.nextInt() - 1;
        System.out.print("Elige columna ---> ");
        casella[1] = resposta.nextInt() - 1;

        return casella;
    }

    public int getAdversari() {
        int adversari;
        if (this.getTorn() == 0) {
            adversari = 1;
        } else {
            adversari = 0;
        }
        return adversari;
    }

    public String getNom() {
        return this.nombre;
    }

    public int getTorn() {
        return this.torn;
    }

    public Moviment moviment() {
        int casella[];
        Moviment moviment = null;

        while (moviment == null) {
            try {
                casella = this.demanarCasella();
                moviment = new Moviment(this, casella[0], casella[1]);
            } catch (InputMismatchException e) {
                System.out.println("");
                System.out.println("-------- SÓLO PUEDES PULSAR NÚMEROS --------");
                System.out.println("");
            } 
        }

        return moviment;
    }

    public void setTorn(int torn) {
        this.torn = torn;
    }
}
