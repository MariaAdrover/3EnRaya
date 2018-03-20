package pkg3enraya;

public class Moviment {
    
    private boolean blancas;
    private int fila;    
    private int columna;    
    private Jugador jugador; 
 
    public Moviment(Jugador jugador, int fila, int columna){
        this.fila = fila;
        this.columna = columna;
        this.jugador = jugador;
    }
    
    public boolean getBlancas() {
       return this.blancas;
    }
    
    public int getColumna() {
       return this.columna;
    }
    
    public int getFila() {
       return this.fila;
    }
    
    public Jugador getJugador() {
        return this.jugador;
    }
    
    public void setBlancas(boolean blancas) {
        this.blancas = blancas;
    }
}
