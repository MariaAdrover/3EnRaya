package pkg3enraya;

public class IA0 extends Jugador {
    Taulell taulell; 
 
    public IA0(String nombre){
        super(nombre);
    }
    
    @Override
    public Moviment moviment() {
        Moviment moviment = null;

        for (int f = 0; f < 3; f++) {
            for (int c = 0; c < 3; c++) {
                if (this.taulell.getCasilla(f, c) == -1) {
                    moviment = new Moviment(this, f, c);
                    return moviment; // ===== Ha trobat una casella buida =====>
                }
            }
        }
        
        return moviment;
    }
    
    public void setTaulell (Taulell t) {
        this.taulell = t;
    }
}
