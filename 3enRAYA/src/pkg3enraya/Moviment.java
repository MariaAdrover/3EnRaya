package pkg3enraya;

public class Moviment {
    private int fitxa;
    private int fila;    
    private int columna;    
    private Jugador jugador; 
 
    public Moviment(Jugador jugador, int fila, int columna){
        this.fila = fila;
        this.columna = columna;
        this.jugador = jugador;
    }
    
    public int getFitxa() {
       return this.fitxa;
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
    
    public void setFitxa(int f) {
        this.fitxa = f;
    }
}
