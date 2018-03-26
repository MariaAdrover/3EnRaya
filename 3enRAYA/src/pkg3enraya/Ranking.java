package pkg3enraya;

public class Ranking {     
    public int empats;    
    public int guanyadesJugador;
    public int partidesJugades;
 
    public Ranking(){
        this.partidesJugades = 0;
        this.guanyadesJugador = 0;
        this.empats = 0;
    }
    
    public void empatar() {
        this.partidesJugades++; 
        this.empats++;
    }
    
    public void guanyar(Jugador j) {
        this.partidesJugades++; 
        if(!(j instanceof IA0)) {
            this.guanyadesJugador++;
        }   
    }
    
    public void mostrarRanking() {
        int derrotasJugador = this.partidesJugades - this.empats - this.guanyadesJugador;
        
        System.out.println("");
        System.out.println("                           ***************************");
        System.out.println("                                      RANKING");
        System.out.println("                           ***************************");        
        System.out.println("");
        System.out.println("                               Partidas jugadas: " + this.partidesJugades);
        System.out.println("                                    Empates: " + this.empats);
        System.out.println("                               Victorias Humano: " + this.guanyadesJugador);
        System.out.println("                                Derrotas Humano: " + derrotasJugador);
        System.out.println("                                 Victorias IA: " + derrotasJugador);
        System.out.println("                                  Derrotas IA: " + this.guanyadesJugador);
    }
}
