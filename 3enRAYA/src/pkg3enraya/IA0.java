package pkg3enraya;

public class IA0 extends Jugador {
    Taulell taulell; 
 
    public IA0(String nombre){
        super(nombre);
    }
    
    @Override
    public Moviment moviment() {
        int[] mov = this.taulell.getCasillaLibre();        
        Moviment moviment = new Moviment(this, mov[0], mov[1]); 
        
        return moviment;
    }
    
    public void setTaulell (Taulell t) {
        this.taulell = t;
    }
}
