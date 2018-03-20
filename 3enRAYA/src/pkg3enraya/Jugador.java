package pkg3enraya;

import java.util.*;

public class Jugador {
    private int torn;
    private String nombre;
    // No necessito navegabilitat de jugador a sessio...
 
    public Jugador(String nombre){
        this.nombre = nombre;
    }
    
    public String getNom() {
        return this.nombre;
    }
    
    public int getTorn() {
        return this.torn;
    }
    
    public Moviment moviment() { // ----------> CREAR METODE PER DEMANAR MOVIMENT??
        int columna;
        int fila;
        int opcio;
        Moviment moviment;
        Scanner resposta = new Scanner(System.in);
        
        System.out.println("Elige fila ---> ");
        opcio = resposta.nextInt();
        fila = opcio - 1;
        
        System.out.println("Elige columna ---> ");
        opcio = resposta.nextInt();
        columna = opcio - 1;
        System.out.println("");
        
        // comprobar moviment        
        moviment = new Moviment(this, fila, columna);
        // addMoviment aqui, habria que añadir taulell...
        
        return moviment;        
    }
    
    public void setTorn(int torn) {
        this.torn = torn;
    }
}
